package com.kenshine.jcommander.demo08;

import com.beust.jcommander.JCommander;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 23:22
 * @description：
 * @modified By：
 * @version: $
 */
public class demo08 {
    public static void main(String[] args) {
        CommandMain cm = new CommandMain();
        CommandAdd add = new CommandAdd();
        CommandCommit commit = new CommandCommit();
        JCommander jc = JCommander.newBuilder()
                .addObject(cm)
                .addCommand("add", add)
                .addCommand("commit", commit)
                .build();

        jc.parse("-v", "commit", "--amend", "--author=cbeust", "A.java", "B.java");

        System.out.println(cm);
        System.out.println(add);
        System.out.println(commit);
    }
}
