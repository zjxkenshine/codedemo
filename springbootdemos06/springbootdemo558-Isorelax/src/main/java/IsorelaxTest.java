import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;
import org.iso_relax.verifier.Schema;
import org.iso_relax.verifier.Verifier;
import org.iso_relax.verifier.VerifierFactory;
import org.iso_relax.verifier.VerifierFilter;
import org.junit.Test;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

import java.io.InputStream;

/**
 * @author by kenshine
 * @Classname IsorelaxTest
 * @Description isorelax使用测试
 * @Date 2023-12-08 18:49
 * @modified By：
 * @version: 1.0$
 *
 * 根据Schema文件校验XML
 */
public class IsorelaxTest {

    @Test
    public void test01(){
        validate();
    }

    public static void validate() {
        try  {
            //xml文件及schema文件
            InputStream xmlString = IsorelaxTest.class.getResourceAsStream(
                    "test.xml" );
            InputStream schemaStr = IsorelaxTest.class.getResourceAsStream(
                    "testSchema.xsd" );
            SAXReader reader = createSAXReader(schemaStr);
            System.out.println("XSD parse successfully !" );

            Document document = reader.read(xmlString);
            System.out.println("Successfully validation .. . " );
        } catch  (DocumentException e) {
            System.out.println("Exception occurred: "  + e);
            Throwable nestedException = e.getNestedException();
            if  (nestedException !=  null ) {
                System.out.println("NestedException: "  + nestedException);
                nestedException.printStackTrace();
            } else  {
                e.printStackTrace();
            }
        } catch  (Throwable t) {
            System.out.println("Exception occurred: "  + t);
            t.printStackTrace();
        }
    }

    /**
     * 注册
     * */
    protected   static  SAXReader createSAXReader(InputStream schemaURI)
            throws  Exception {
        System.out.println("Loaded schema document: "  + schemaURI);
        //四步必须，一步可选：创建校验工厂、编码Schema、生成校验器、[设置错误处理]、XML文档校验
        //第一步：创建校验工厂，可选择不同的校验工厂
        // use autodetection of schemas
        //查看JARV的详细信息：http://iso-relax.sourceforge.net/JARV/，进入其userGuide
        //该步为创建校验工厂实例，如果需要换成其它的校验器，将com.sun.msv.verifier.jarv.TheFactoryImpl()换成其它即可，如使用 Swift RELAX Verifier：
        //VerifierFactory factory = new jp.xml.gr.relax.swift.SwiftVerifierFactory();
        VerifierFactory factory = new com.sun.msv.verifier.jarv.TheFactoryImpl();
        //第二步：编译成Schema，支持源为URL、InputStream、File、InputSource等
        Schema schema = factory.compileSchema(schemaURI);

        //第三步：生成校验器
        Verifier verifier = schema.newVerifier();

        //第四步：设置自己的错误处理，如果不设置就是默认的错误处理
        verifier.setErrorHandler(new  ErrorHandler() {
            @Override
            public   void  error(SAXParseException e) {
                System.out.println("ERROR: "  + e);
            }
            @Override
            public   void  fatalError(SAXParseException e) {
                System.out.println("FATAL: "  + e);
            }
            @Override
            public   void  warning(SAXParseException e) {
                System.out.println("WARNING: "  + e);
            }
        });
        //第五步：XML文档校验
        VerifierFilter filter = verifier.getVerifierFilter();
        //默认SAXReader的校验是关闭的，采用setXMLFilter方法，就显示设置了过滤器，后面生成的对象就会做校验
        SAXReader reader = new  SAXReader();
        reader.setXMLFilter(filter);
        return  reader;
    }
}
