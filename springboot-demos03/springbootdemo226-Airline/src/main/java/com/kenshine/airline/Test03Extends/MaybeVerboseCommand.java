package com.kenshine.airline.Test03Extends;

import com.github.rvesse.airline.SingleCommand;
import com.github.rvesse.airline.annotations.Command;
import com.github.rvesse.airline.annotations.help.Discussion;

/**
 * @author Kenshine
 */
@Command(name = "maybe-verbose")
public class MaybeVerboseCommand extends BaseCommand {

    @Override
    public void run() {
        if (this.verbose) {
            System.out.println("Verbose");
        } else {
            System.out.println("Normal");
        }
    }
    
    public static void main(String[] args) {
        args = new String[]{"--verbose"};
        //解析
        MaybeVerboseCommand cmd = SingleCommand.singleCommand(MaybeVerboseCommand.class).parse(args);
        cmd.run();
    }
}