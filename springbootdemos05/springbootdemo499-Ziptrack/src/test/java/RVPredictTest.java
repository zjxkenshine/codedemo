import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2023/11/19 22:29
 * @description：测试
 * @modified By：
 * @version: $
 */
public class RVPredictTest {

    @Test
    public void test01(){
        for(int i=0;i<10;i++){
            final int j =i;
            new Thread(new Runnable(){
                @Override
                public void run() {
                    System.out.println("线程"+j);
                }
            }).start();
        }
    }
}
