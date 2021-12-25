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
@Parameters(commandDescription = "Add file contents to the index")
@ToString
public class CommandAdd {

    @Parameter(description = "File patterns to add to the index")
    private List<String> patterns;

    @Parameter(names = "-i")
    private Boolean interactive = false;
}
