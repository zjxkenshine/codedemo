package bilibili.eventBus.events;

import lombok.Data;

/**
 * @author ：kenshine
 * @date ：Created in 2021/10/26 7:34
 * @description：苹果
 * @modified By：
 * @version: $
 */
@Data
public class Apple extends Fruit{

    public Apple(String name){
        super(name);
    }
}
