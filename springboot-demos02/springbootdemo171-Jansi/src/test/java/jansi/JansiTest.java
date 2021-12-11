package jansi;

import org.fusesource.jansi.AnsiConsole;
import org.junit.Test;

import static org.fusesource.jansi.Ansi.Color.GREEN;
import static org.fusesource.jansi.Ansi.Color.RED;
import static org.fusesource.jansi.Ansi.ansi;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/11 22:18
 * @description： jansi使控制台输出颜色
 * @modified By：
 * @version: $
 */
public class JansiTest {

    @Test
    public void test01(){
        //加载
        AnsiConsole.systemInstall();
        //方式一
        System.out.println(ansi().eraseScreen().fg(RED).a("Hello").fg(GREEN).a(" World").reset() );
        //方式二
        System.out.println( ansi().eraseScreen().render("@|red Hello|@ @|green World|@") );
        //卸载
        AnsiConsole.systemUninstall();
    }

}
