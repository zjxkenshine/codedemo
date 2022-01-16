package com.kenshine.airline.demo;

import com.github.rvesse.airline.Cli;
import com.github.rvesse.airline.annotations.Arguments;
import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.Option;
import com.github.rvesse.airline.annotations.OptionType;
import com.github.rvesse.airline.builder.CliBuilder;
import com.github.rvesse.airline.help.Help;

import java.util.List;

/**
 * @author ：kenshine
 * @date ：Created in 2022/1/16 14:54
 * @description：
 * @modified By：
 * @version: $
 */
public class Git {
    public static void main(String[] args) {
        CliBuilder<Runnable> builder = Cli.<Runnable>builder("git")
                .withDescription("the stupid content tracker")
                .withDefaultCommand(Help.class)
                .withCommands(Help.class, Add.class);

        builder.withGroup("remote")
                .withDescription("Manage set of tracked repositories")
                .withDefaultCommand(RemoteShow.class)
                .withCommands(RemoteShow.class, RemoteAdd.class);

        Cli<Runnable> gitParser = builder.build();

        gitParser.parse(args).run();
    }

    public static class GitCommand implements Runnable {
        @Option(type = OptionType.GLOBAL, name = "-v", description = "Verbose mode")
        public boolean verbose;

        @Override
        public void run()
        {
            System.out.println(getClass().getSimpleName());
        }
    }

    @Command(name = "add", description = "Add file contents to the index")
    public static class Add extends GitCommand {
        @Arguments(description = "Patterns of files to be added")
        public List<String> patterns;

        @Option(name = "-i", description = "Add modified contents interactively.")
        public boolean interactive;
    }

    @Command(name = "show", description = "Gives some information about the remote <name>")
    public static class RemoteShow extends GitCommand
    {
        @Option(name = "-n", description = "Do not query remote heads")
        public boolean noQuery;

        @Arguments(description = "Remote to show")
        public String remote;
    }

    @Command(name = "add", description = "Adds a remote")
    public static class RemoteAdd extends GitCommand {
        @Option(name = "-t", description = "Track only a specific branch")
        public String branch;

        @Arguments(description = "Remote repository to add")
        public List<String> remote;
    }
}
