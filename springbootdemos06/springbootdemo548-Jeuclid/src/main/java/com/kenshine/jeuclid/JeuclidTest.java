package com.kenshine.jeuclid;

import net.sourceforge.jeuclid.DOMBuilder;
import net.sourceforge.jeuclid.LayoutContext;
import net.sourceforge.jeuclid.MutableLayoutContext;
import net.sourceforge.jeuclid.context.LayoutContextImpl;
import net.sourceforge.jeuclid.context.Parameter;
import net.sourceforge.jeuclid.elements.generic.DocumentElement;
import net.sourceforge.jeuclid.layout.JEuclidView;
import net.sourceforge.jeuclid.layout.LayoutInfo;
import net.sourceforge.jeuclid.layout.LayoutStage;
import net.sourceforge.jeuclid.layout.LayoutableNode;
import net.sourceforge.jeuclid.parser.Parser;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.w3c.dom.Document;
import org.xml.sax.SAXException;

import javax.xml.transform.stream.StreamSource;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * @author by kenshine
 * @Classname JeuclidTest
 * @Description 渲染测试
 * @Date 2023-12-07 11:41
 * @modified By：
 * @version: 1.0$
 */
public class JeuclidTest {
 private static final Logger LOGGER = LoggerFactory
            .getLogger(JeuclidTest.class);

    private LayoutContext layoutContext;
    // 最大字体大小
    private static final float LARGE_FONT_SIZE = 48.0f;
    // 渲染文件
    private static final String RENDER_NAME = "renderInfos.ser";

    private final Map<String, List<RenderInfo>> currentRendering = new HashMap<>();

    private final Map<String, List<RenderInfo>> oldRendering;

    private final File tempDir;

    // 初始化数据
    {
        MutableLayoutContext mlc;
        mlc = new LayoutContextImpl(
                LayoutContextImpl.getDefaultLayoutContext());
        mlc.setParameter(Parameter.ANTIALIAS, true);
        mlc.setParameter(Parameter.MATHSIZE,
                JeuclidTest.LARGE_FONT_SIZE);
        mlc.setParameter(Parameter.FONTS_SANSSERIF, "DejaVu Sans");
        mlc.setParameter(Parameter.FONTS_SERIF, "DejaVu Serif");
        this.layoutContext = mlc;

        this.tempDir = new File("temp");
        if (!this.tempDir.isDirectory()) {
            final boolean success = this.tempDir.mkdirs();
            assert success;
        }
        this.oldRendering = this.loadRenderings();
    }

    @Test
    public void test01() throws Exception {
        final InputStream i = new FileInputStream("mml\\test01.list");
        final BufferedReader br = new BufferedReader(new InputStreamReader(i, StandardCharsets.UTF_8));
        String line;
        final List<String> failures = new ArrayList<>();
        while ((line = br.readLine()) != null) {
            this.renderAndCompare(line, failures);
        }
        this.saveCurrentRenderings();
    }

    // 渲染并比较
    private void renderAndCompare(final String name, final List<String> failures)
            throws Exception {
        final List<RenderInfo> currentList = this.render(name);
        this.currentRendering.put(name, currentList);
        final List<RenderInfo> oldList = this.oldRendering.get(name);
        this.compareRenderings(name, currentList, oldList, failures);
    }

    // 比较渲染信息
    private void compareRenderings(final String name,
                                   final List<RenderInfo> currentList, final List<RenderInfo> oldList,
                                   final List<String> failures) {
        boolean have = false;
        if (oldList == null) {
            return;
        }
        if (currentList.size() != oldList.size()) {
            failures.add(name + " has changed in number of elements! (old: "
                    + oldList.size() + " new: " + currentList.size() + ")");
            have = true;
        } else {
            for (int i = 0; i < currentList.size(); i++) {
                final RenderInfo current = currentList.get(i);
                final RenderInfo old = oldList.get(i);
                final String similarities = current.checkSimilar(old);
                if (similarities.length() > 0) {
                    failures.add(name + " differes for element "
                            + current.getElementName() + " in" + similarities);
                    have = true;
                }
            }
        }
        if (have) {
            failures.add("\n");
        }
    }

    // 渲染
    private List<RenderInfo> render(final String line) throws Exception {
        final List<RenderInfo> currentList = new LinkedList<>();
        try {
            final InputStream i = new FileInputStream(line);
            final Document d = Parser.getInstance().parseStreamSource(
                    new StreamSource(i));
            final DocumentElement docElement = DOMBuilder.getInstance()
                    .createJeuclidDom(d);
            final JEuclidView view = new JEuclidView(docElement,
                    this.layoutContext, null);
            // Forces Layout
            view.getAscentHeight();
            this.createInfo(view, docElement, currentList);
        } catch (final IOException io) {
            // ignore
        }
        return currentList;
    }

    // 创建渲染信息
    private void createInfo(final JEuclidView view, final LayoutableNode node,
                            final List<RenderInfo> renderInfos) {
        final LayoutInfo info = view.getInfo(node);
        final RenderInfo renderInfo = new RenderInfo(node.getNodeName(), info
                .getAscentHeight(LayoutStage.STAGE2), info
                .getDescentHeight(LayoutStage.STAGE2), info
                .getWidth(LayoutStage.STAGE2),
                info.getPosX(LayoutStage.STAGE2), info
                .getPosY(LayoutStage.STAGE2));
        renderInfos.add(renderInfo);
        for (final LayoutableNode n : node.getChildrenToLayout()) {
            this.createInfo(view, n, renderInfos);
        }
    }

    // 保存当前渲染信息
    private void saveCurrentRenderings() throws Exception {
        final ObjectOutputStream oo = new ObjectOutputStream(
                new FileOutputStream(new File(this.tempDir,
                        JeuclidTest.RENDER_NAME)));
        oo.writeObject(this.currentRendering);
        oo.close();
    }

    // 加在渲染信息
    private Map<String, List<RenderInfo>> loadRenderings() {
        Map<String, List<RenderInfo>> retVal = null;
        try {
            final ObjectInputStream oi = new ObjectInputStream(
                    new FileInputStream(new File(this.tempDir,
                            JeuclidTest.RENDER_NAME)));
            retVal = (Map<String, List<RenderInfo>>) oi.readObject();
            oi.close();
        } catch (final Exception e) {
            retVal = null;
        }
        if (retVal == null) {
            LOGGER.info("Could not load old rendering infos. Will create them for the first time.");
            retVal = new HashMap<>();
        }
        return retVal;
    }

}
