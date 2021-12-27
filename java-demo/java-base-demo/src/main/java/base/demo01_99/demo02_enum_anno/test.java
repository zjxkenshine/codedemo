package base.demo01_99.demo02_enum_anno;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/27 12:55
 * @description：
 * @modified By：
 * @version: $
 */
public class test {
    public static void main(String[] args) {
        //info对象
        StudyEnum.StudyEnumInfo info = StudyEnum.JAVA.resolve();
        System.out.println(info.getCostAnno().max());
        System.out.println(info.getLogAnno().open());
    }
}
