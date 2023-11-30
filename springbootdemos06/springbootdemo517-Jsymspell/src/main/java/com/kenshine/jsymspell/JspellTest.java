package com.kenshine.jsymspell;

import io.gitlab.rxp90.jsymspell.SymSpell;
import io.gitlab.rxp90.jsymspell.SymSpellBuilder;
import io.gitlab.rxp90.jsymspell.Verbosity;
import io.gitlab.rxp90.jsymspell.api.*;
import io.gitlab.rxp90.jsymspell.exceptions.NotInitializedException;
import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author by kenshine
 * @Classname JspellTest
 * @Description 使用测试
 * @Date 2023-11-30 13:38
 * @modified By：
 * @version: 1.0$
 */
public class JspellTest {

    /**
     * 基本拼写检查、纠正
     */
    @Test
    public void test01() throws IOException, NotInitializedException {
        // 双字节
        Map<Bigram, Long> bigrams = Files.lines(Paths.get("text/bigrams.txt"))
                .map(line -> line.split(" "))
                .collect(Collectors.toMap(tokens -> new Bigram(tokens[0], tokens[1]), tokens -> Long.parseLong(tokens[2])));
        // 单字节
        Map<String, Long> unigrams = Files.lines(Paths.get("text/words.txt"))
                .map(line -> line.split(","))
                .collect(Collectors.toMap(tokens -> tokens[0], tokens -> Long.parseLong(tokens[1])));

        // 创建symspell实例
        SymSpell symSpell = new SymSpellBuilder().setUnigramLexicon(unigrams)
                .setBigramLexicon(bigrams)
                .setMaxDictionaryEditDistance(2)
                .createSymSpell();
        // 进行拼写检查
        int maxEditDistance = 2;
        boolean includeUnknowns = false;
        List<SuggestItem> suggestions = symSpell.lookupCompound("Nostalgiais truly one of th greatests human weakneses", maxEditDistance, includeUnknowns);
        System.out.println(suggestions.get(0).getSuggestion());
    }


    /**
     * 默认使用Damerau-Levenshtein算法计算距离
     * 可选
     * Damerau-Levenshtein
     * Hamming Distance
     * Jaro Distance
     * Keyboard distance
     */
    @Test
    public void test02() throws IOException, NotInitializedException {
        // 初始化
        Map<Bigram, Long> bigrams = Files.lines(Paths.get("text/bigrams.txt"))
                .map(line -> line.split(" "))
                .collect(Collectors.toMap(tokens -> new Bigram(tokens[0], tokens[1]), tokens -> Long.parseLong(tokens[2])));
        Map<String, Long> unigrams = Files.lines(Paths.get("text/words.txt"))
                .map(line -> line.split(","))
                .collect(Collectors.toMap(tokens -> tokens[0], tokens -> Long.parseLong(tokens[1])));
        // 使用Hamming Distance 算法
        SymSpell symSpell = new SymSpellBuilder().setUnigramLexicon(unigrams)
                .setStringDistanceAlgorithm((string1, string2, maxDistance) -> {
                    if (string1.length() != string2.length()){
                        return -1;
                    }
                    char[] chars1 = string1.toCharArray();
                    char[] chars2 = string2.toCharArray();
                    int distance = 0;
                    for (int i = 0; i < chars1.length; i++) {
                        if (chars1[i] != chars2[i]) {
                            distance += 1;
                        }
                    }
                    return distance;
                })
                .createSymSpell();

        // 进行拼写检查
        int maxEditDistance = 2;
        boolean includeUnknowns = false;
        List<SuggestItem> suggestions = symSpell.lookupCompound("Nostalgiais truly one of th greatests human weakneses", maxEditDistance, includeUnknowns);
        System.out.println(suggestions.get(0).getSuggestion());
    }

    /**
     * 自定义comparator比较字符
     */
    @Test
    public void test03() throws NotInitializedException {
        CharComparator customCharComparator = new CharComparator() {
            @Override
            public boolean areEqual(char ch1, char ch2) {
                if (ch1 == 'ñ' || ch2 == 'ñ') {
                    return ch1 == 'n' || ch2 == 'n';
                }
                return ch1 == ch2;
            }
        };
        StringDistance damerauLevenshteinOSA = new DamerauLevenshteinOSA(customCharComparator);
        SymSpell symSpell = new SymSpellBuilder().setUnigramLexicon(Collections.singletonMap("España", 10L))
                .setStringDistanceAlgorithm(damerauLevenshteinOSA)
                .createSymSpell();
        List<SuggestItem> suggestions = symSpell.lookup("Espana", Verbosity.ALL);
        System.out.println(suggestions);
    }

    /**
     * 词频统计
     */
    @Test
    public void test04(){
        Map<String, Long> unigrams = Arrays.stream("A B A B C A B A C A".split(" "))
                .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));
        System.out.println(unigrams);
    }
}
