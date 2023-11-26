package com.kenshine.cdk;

import org.junit.Test;
import org.openscience.cdk.CDKConstants;
import org.openscience.cdk.depict.DepictionGenerator;
import org.openscience.cdk.exception.CDKException;
import org.openscience.cdk.exception.InvalidSmilesException;
import org.openscience.cdk.graph.Cycles;
import org.openscience.cdk.interfaces.*;
import org.openscience.cdk.io.MDLV2000Reader;
import org.openscience.cdk.io.iterator.IteratingSDFReader;
import org.openscience.cdk.isomorphism.Pattern;
import org.openscience.cdk.renderer.AtomContainerRenderer;
import org.openscience.cdk.renderer.RendererModel;
import org.openscience.cdk.renderer.SymbolVisibility;
import org.openscience.cdk.renderer.color.UniColor;
import org.openscience.cdk.renderer.font.AWTFontManager;
import org.openscience.cdk.renderer.generators.BasicSceneGenerator;
import org.openscience.cdk.renderer.generators.standard.StandardGenerator;
import org.openscience.cdk.silent.SilentChemObjectBuilder;
import org.openscience.cdk.smarts.SmartsPattern;
import org.openscience.cdk.smiles.SmilesParser;
import org.openscience.cdk.tools.manipulator.AtomContainerManipulator;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/26 22:15
 * @description：cdk使用测试
 * @modified By：
 * @version: $
 */
public class CdkTest {

    /**
     * https://github.com/cdk/cdk/wiki/Standard-Generator
     * 渲染设置
     */
    @Test
    public void test01(){
        Font font = new Font("Arial", Font.PLAIN, 24);
        // 创建渲染器
        AtomContainerRenderer renderer = new AtomContainerRenderer(Arrays.asList(new BasicSceneGenerator(), new StandardGenerator(font)), new AWTFontManager());

        RendererModel rendererModel = renderer.getRenderer2DModel();
        rendererModel.set(StandardGenerator.AtomColor.class,new UniColor(Color.BLACK));
        rendererModel.set(StandardGenerator.Visibility.class, SymbolVisibility.iupacRecommendations());
        rendererModel.set(StandardGenerator.StrokeRatio.class, 0.85);
        rendererModel.set(StandardGenerator.SymbolMarginRatio.class, 4d);
    }

    /**
     * IAtomContainer 化学对象—原子容器
     */
    @Test
    public void test02(){
        IChemObjectBuilder builder = SilentChemObjectBuilder.getInstance();
        IAtomContainer mol = builder.newAtomContainer();
        IAtom a1  = builder.newAtom();
        IAtom          a2  = builder.newAtom();
        IBond b   = builder.newBond();
        b.setAtoms(new IAtom[]{a1, a2});
        // 添加原子a1
        mol.addAtom(a1);
        // 添加原子a2
        mol.addAtom(a2);
        // 添加纽带b
        mol.addBond(b);
    }

    /**
     * 从.sdf读取
     */
    @Test
    public void test03(){
        IChemObjectBuilder builder = SilentChemObjectBuilder.getInstance();
        boolean skipErrors = true;
        try (InputStream in = new FileInputStream(new File("myinput.sdf"));
             Reader rdr = new InputStreamReader(in, StandardCharsets.UTF_8);
             IteratingSDFReader sdfr = new IteratingSDFReader(rdr,
                     builder,
                     skipErrors)) {
            while (sdfr.hasNext()) {
                IAtomContainer mol = sdfr.next();
                int numHeavy = 0;
                for (IAtom atom : mol.atoms()) {
                    if (atom.getAtomicNumber() > 1) {
                        numHeavy++;
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("No such file: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Low level IO error: " + e.getMessage());
        }
    }

    /**
     * smi构建
     */
    @Test
    public void test04(){
        try (InputStream in = new FileInputStream(new File("input.smi"));
             Reader rdr = new InputStreamReader(in, StandardCharsets.UTF_8);
             BufferedReader brdr = new BufferedReader(rdr)) {

            IChemObjectBuilder builder = SilentChemObjectBuilder.getInstance();
            SmilesParser smipar  = new SmilesParser(builder);

            String line;
            while ((line = brdr.readLine()) != null) {
                try {
                    IAtomContainer mol = smipar.parseSmiles(line);
                    int numRings = Cycles.markRingAtomsAndBonds(mol);
                } catch (InvalidSmilesException ex) {
                    System.err.println("BAD SMILES: " + line);
                }
            }

        } catch (FileNotFoundException e) {
            System.err.println("No such file: " + e.getMessage());
        } catch (IOException e) {
            System.err.println("Low level IO error: " + e.getMessage());
        }
    }

    /**
     * 输出化学表达式图片
     */
    @Test
    public void test05() throws CDKException, IOException {
        IChemObjectBuilder bldr   = SilentChemObjectBuilder.getInstance();
        SmilesParser       smipar = new SmilesParser(bldr);

        IAtomContainer mol = smipar.parseSmiles("CN1C=NC2=C1C(=O)N(C(=O)N2C)C caffeine");
        mol.setProperty(CDKConstants.TITLE, "caffeine"); // title already set from input!

        DepictionGenerator dptgen = new DepictionGenerator();
        dptgen.withSize(200, 250)              // px (raster) or mm (vector)
                .withMolTitle()
                .withTitleColor(Color.DARK_GRAY) // annotations are red by default
                .depict(mol)
                .writeTo("img/caffeine.png");
    }

    /**
     * 突出显示子结构
     */
    @Test
    public void test06() throws CDKException, IOException {
        String fname = "benzodiazepine.sdf";
        String sma   = "c1ccc2c(c1)C(=NCCN2)c3ccccc3";

        IChemObjectBuilder bldr = SilentChemObjectBuilder.getInstance();
        IAtomContainer     mol  = null;

        try (FileInputStream in   = new FileInputStream(fname);
             MDLV2000Reader mdlr = new MDLV2000Reader(in)) {
            while ((mol = mdlr.read(bldr.newInstance(IAtomContainer.class))) != null) {
                if (mol.getProperty(CDKConstants.TITLE).equals("3016")) {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        AtomContainerManipulator.suppressHydrogens(mol);
        Pattern ptrn = SmartsPattern.create(sma, bldr);

        DepictionGenerator dptgen = new DepictionGenerator();
        dptgen.withSize(200, 250)
                .withHighlight(ptrn.matchAll(mol)
                                .uniqueAtoms()
                                .toChemObjects(),
                        Color.RED)
                .depict(mol)
                .writeTo("img/3016.png");
    }
}
