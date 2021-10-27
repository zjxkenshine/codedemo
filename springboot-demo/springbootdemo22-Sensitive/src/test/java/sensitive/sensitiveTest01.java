package sensitive;

import com.github.houbb.sensitive.api.IStrategy;
import com.github.houbb.sensitive.core.api.SensitiveUtil;
import com.github.houbb.sensitive.core.api.strategory.StrategyEmail;
import com.kenshine.domain.User;
import org.junit.Test;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/27 11:19
 * @description：测试01
 * @modified By：
 * @version: $
 */
public class sensitiveTest01 {

    /**
     * 基本使用
     */
    @Test
    public void test01() {
        User user = buildUser();
        System.out.println("脱敏前原始： " + user);
        //进行脱敏
        User sensitiveUser = SensitiveUtil.desCopy(user);
        System.out.println("脱敏对象： " + sensitiveUser);

        System.out.println("脱敏后原始： " + user);
    }

    private User buildUser() {
        User user = new User();
        user.setUsername("脱敏君");
        user.setPassword("123456");
        user.setEmail("12345@qq.com");
        user.setIdCard("123456190001011234");
        user.setPhone("18888888888");
        return user;
    }

    /**
     * 单字段脱敏
     */
    @Test
    public void test02(){
        final String email = "123456@qq.com";
        IStrategy strategy = new StrategyEmail();
        final String emailSensitive = (String) strategy.des(email, null);
        System.out.println("脱敏后的邮箱：" + emailSensitive);
    }

}
