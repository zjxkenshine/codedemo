package joddmadvoc;

import jodd.madvoc.meta.Action;
import jodd.madvoc.meta.MadvocAction;

/**
 * @author kenshine
 * helloworld
 * 打war包部署到tomcat
 * 访问  http://localhost:8080/ [部署的项目名字] /hello.html
 */
@MadvocAction
public class HelloAction {

    @Action
    public Object view() {
        return "text:hello madvoc";
    }

}