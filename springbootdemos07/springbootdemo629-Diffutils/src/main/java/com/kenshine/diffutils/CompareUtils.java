package com.kenshine.diffutils;

import difflib.DiffRow;
import difflib.DiffRowGenerator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 文件对比工具类（支持文件对比/list数据）
 * @author kenshine
 */
public class CompareUtils {

    public static final String Result_EQUAL = "EQUAL";
    public static final String Result_INSERT = "INSERT";
    public static final String Result_DELETE = "DELETE";
    public static final String Result_CHANGE = "CHANGE";

    /***
     * 对两个List<String> 比较其变化
     * @param original 原数据
     * @param revised 新数据
     */
    public static List<CompareInfo> compareAll(List<String> original, List<String> revised) {
        final DiffRowGenerator.Builder builder = new DiffRowGenerator.Builder();
        final DiffRowGenerator dfg = builder.build();
        final List<DiffRow> rows = dfg.generateDiffRows(original, revised);
        List<CompareInfo> listCompareInfo = new ArrayList<>();
        int i = 1;
        int oldSize = original.size();
        int newSize = revised.size();
        int insertSize = 0;
        int deleteSize = 0;
        for (final DiffRow diffRow : rows) {
            String type = diffRow.getTag().toString();
            String oldLine = diffRow.getOldLine();
            String newLine = diffRow.getNewLine();
            if (Result_CHANGE.equals(type)) {
                boolean isInset = false;
                if ((i - insertSize) <= oldSize) {
                    if (oldLine != null && oldLine.trim().length() == 0) {
                        if (!original.get(i - 1 - insertSize).equals(oldLine)) {
                            type = Result_INSERT;
                            isInset = true;
                            insertSize++;
                        }
                    }
                }
                if (!isInset) {
                    if ((i - deleteSize) <= newSize) {
                        if (newLine != null && newLine.trim().length() == 0) {
                            if (!revised.get(i - 1 - deleteSize).equals(oldLine)) {
                                type = Result_DELETE;
                                isInset = true;
                                deleteSize++;
                            }
                        }
                    }
                }
            }
            listCompareInfo.add(new CompareInfo(i, oldLine, newLine, type));
            i++;
        }
        return listCompareInfo;
    }

    /***
     * 读取文件转换成linkedList
     * @param filename
     * @return
     */
    private static List<String> fileToLines(String filename) {
        List<String> lines = new LinkedList<String>();
        String line = "";
        try {
            BufferedReader in = new BufferedReader(new FileReader(filename));
            while ((line = in.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return lines;
    }

    /***
     * 对文件进行比较
     * @param fromFileName 原来的文件名
     * @param toFileName 新的文件名
     */
    public static List<CompareInfo> compareAll(String fromFileName, String toFileName) {
        List<String> original = fileToLines(fromFileName);
        List<String> revised = fileToLines(toFileName);
        final DiffRowGenerator.Builder builder = new DiffRowGenerator.Builder();
        final DiffRowGenerator dfg = builder.build();
        final List<DiffRow> rows = dfg.generateDiffRows(original, revised);
        List<CompareInfo> listCompareInfo = new ArrayList<>();
        int i = 1;
        int oldSize = original.size();
        int newSize = revised.size();
        int insertSize = 0;
        int deleteSize = 0;
        for (final DiffRow diffRow : rows) {
            String type = diffRow.getTag().toString();
            String oldLine = diffRow.getOldLine();
            String newLine = diffRow.getNewLine();
            if (Result_CHANGE.equals(type)) {
                boolean isInset = false;
                if ((i - insertSize) <= oldSize) {
                    if (oldLine != null && oldLine.trim().length() == 0) {
                        if (!original.get(i - 1 - insertSize).equals(oldLine)) {
                            type = Result_INSERT;
                            isInset = true;
                            insertSize++;
                        }
                    }
                }
                if (!isInset) {
                    if ((i - deleteSize) <= newSize) {
                        if (newLine != null && newLine.trim().length() == 0) {
                            if (!revised.get(i - 1 - deleteSize).equals(oldLine)) {
                                type = Result_DELETE;
                                isInset = true;
                                deleteSize++;
                            }
                        }
                    }
                }
            }
            listCompareInfo.add(new CompareInfo(i, oldLine, newLine, type));
            i++;
        }
        return listCompareInfo;
    }
}