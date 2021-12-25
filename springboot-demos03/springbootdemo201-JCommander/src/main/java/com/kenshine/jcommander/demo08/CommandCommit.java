package com.kenshine.jcommander.demo08;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import lombok.ToString;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/25 23:21
 * @description：
 * @modified By：
 * @version: $
 */
@Parameters(separators = "=", commandDescription = "Record changes to the repository")
@ToString
public class CommandCommit {
    @Parameter(description = "The list of files to commit")
    private List<String> files;

    @Parameter(names = "--amend", description = "Amend")
    private Boolean amend = false;

    @Parameter(names = "--author")
    private String author;
}
