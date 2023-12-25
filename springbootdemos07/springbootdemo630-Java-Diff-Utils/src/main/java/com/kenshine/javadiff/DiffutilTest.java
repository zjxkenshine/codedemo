package com.kenshine.javadiff;

import com.github.difflib.DiffUtils;
import com.github.difflib.UnifiedDiffUtils;
import com.github.difflib.patch.AbstractDelta;
import com.github.difflib.patch.Patch;
import com.github.difflib.patch.PatchFailedException;
import com.github.difflib.text.DiffRow;
import com.github.difflib.text.DiffRowGenerator;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author by kenshine
 * @Classname DiffutilTest
 * @Description 使用测试
 * @Date 2023-12-25 9:49
 * @modified By：
 * @version: 1.0$
 */
public class DiffutilTest {
    String path1="src\\main\\resources\\t1.txt";
    String path2="src\\main\\resources\\t2.txt";

    /**
     * 计算差异
     */
    @Test
    public void test01() throws IOException {
        //从两个文件构建List
        List<String> original = Files.readAllLines(new File("src\\main\\resources\\t1.txt").toPath());
        List<String> revised = Files.readAllLines(new File("src\\main\\resources\\t2.txt").toPath());

        //计算补丁
        Patch<String> patch = DiffUtils.diff(original, revised);

        //输出补丁信息
        for (AbstractDelta<String> delta : patch.getDeltas()) {
            System.out.println(delta);
        }
    }

    /**
     * 应用补丁
     */
    @Test
    public void test02() throws IOException, PatchFailedException {
        List<String> original = Files.readAllLines(new File(path1).toPath());
        List<String> patched = Files.readAllLines(new File(path2).toPath());

        // 获取补丁
        Patch<String> patch = UnifiedDiffUtils.parseUnifiedDiff(patched);

        // 应用补丁
        List<String> result = DiffUtils.patch(original, patch);
        System.out.println(result);
    }

    /**
     * 生成标准diff格式并应用补丁
     */
    @Test
    public void test03() throws PatchFailedException {
        List<String> text1= Arrays.asList("this is a test","a test");
        List<String> text2=Arrays.asList("this is a testfile","a test");
        //不同信息
        Patch<String> diff = DiffUtils.diff(text1, text2);
        //标准diff格式生成
        List<String> unifiedDiff = UnifiedDiffUtils.generateUnifiedDiff("src\\main\\resources\\t3.txt", "src\\main\\resources\\t4.txt", text1, diff, 0);
        unifiedDiff.forEach(System.out::println);
        //从文件导入补丁
        Patch<String> importedPatch = UnifiedDiffUtils.parseUnifiedDiff(unifiedDiff);
        //应用补丁
        List<String> patchedText = DiffUtils.patch(text1, importedPatch);
        System.out.println(patchedText);
    }

    /**
     * DiffRowGenerator 比对两个文本并输出可读性高的文本
     */
    @Test
    public void test04(){
        //DiffRowGenerator
        DiffRowGenerator generator = DiffRowGenerator.create()
                .showInlineDiffs(true)
                .mergeOriginalRevised(true)
                .inlineDiffByWord(true)
                // 删除线样式 markdown
                .oldTag(f -> "~")
                // 加粗
                .newTag(f -> "**")
                .build();

        //比对两个文本
        List<DiffRow> rows = generator.generateDiffRows(
                Collections.singletonList("This is a test senctence."),
                Collections.singletonList("This is a test for diffutils."));

        System.out.println(rows.get(0).getOldLine());
    }

    /**
     * DiffRowGenerator 多行文本输出
     */
    @Test
    public void test05(){
        DiffRowGenerator generator = DiffRowGenerator.create()
                .showInlineDiffs(true)
                .inlineDiffByWord(true)
                .oldTag(f -> "~")
                .newTag(f -> "**")
                .build();
        List<DiffRow> rows = generator.generateDiffRows(
                Arrays.asList("This is a test senctence.", "This is the second line.", "And here is the finish."),
                Arrays.asList("This is a test for diffutils.", "This is the second line."));

        System.out.println("|original|new|");
        System.out.println("|--------|---|");
        for (DiffRow row : rows) {
            System.out.println("|" + row.getOldLine() + "|" + row.getNewLine() + "|");
        }
    }

    /**
     * 比对非文本之间的差异
     */
    @Test
    public void test06(){
        List<Integer> original = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> revised = Arrays.asList(2, 3, 4, 6);
        Patch<Integer> patch = DiffUtils.diff(original, revised);
        for (AbstractDelta delta : patch.getDeltas()) {
            System.out.println(delta);
        }
    }
}
