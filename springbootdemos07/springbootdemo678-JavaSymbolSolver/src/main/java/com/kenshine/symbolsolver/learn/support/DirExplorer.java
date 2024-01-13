package com.kenshine.symbolsolver.learn.support;

import java.io.File;
import java.io.FileNotFoundException;

/**
 * 目录扫描
 * @author kenshine
 */
public class DirExplorer {
    public interface FileHandler {
        void handle(int level, String path, File file) throws FileNotFoundException;
    }
    public interface Filter {
        boolean interested(int level, String path, File file);
    }
    private FileHandler fileHandler;
    private Filter filter;
    public DirExplorer(Filter filter, FileHandler fileHandler) {
        this.filter = filter;
        this.fileHandler = fileHandler;
    }
    public void explore(File root) throws FileNotFoundException {
        explore(0, "", root);
    }
    private void explore(int level, String path, File file) throws FileNotFoundException {
        if (file.isDirectory()) {
            for (File child : file.listFiles()) {
                explore(level + 1, path + "/" + child.getName(), child);
            }
        } else {
            if (filter.interested(level, path, file)) {
                fileHandler.handle(level, path, file);
            }
        }
    }
}