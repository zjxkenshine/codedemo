package vip.lematech.hrun4j.quickstartdemo.functions;

import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorObject;
import com.googlecode.aviator.runtime.type.AviatorString;
import vip.lematech.hrun4j.helper.LogHelper;

import java.util.Map;

/**
* @author lematech@foxmail.com
* @version 1.0.1
*/

public class MyFunction {

    /**
    * Custom function, set the function name will be implemented in the call supplement function
    */
    public static class SetupHookFunction extends AbstractFunction {
        @Override
        public AviatorObject call(Map<String, Object> env, AviatorObject page, AviatorObject type, AviatorObject count) {
            LogHelper.info("����ִ�У�{}����������������page={},count={},type={}",this.getName(), page,count,type);
            String typeValue = FunctionUtils.getStringValue(type, env);
            Number pageValue = FunctionUtils.getNumberValue(page, env);
            Number countValue = FunctionUtils.getNumberValue(count, env);
            String spiceString = String.format("page=%s&count=%s&page=type",pageValue,countValue,typeValue);
            return new AviatorString(String.valueOf(spiceString));
        }
        @Override
        public String getName() {
            return "shFunction";
        }
    }

    /**
    * Custom function, set the function name will be implemented in the call supplement function
    */
    public static class TearDownHookFunction extends AbstractFunction {
        @Override
        public AviatorObject call(Map<String, Object> env,AviatorObject type) {
            LogHelper.info("����ִ�У�{}����������������{}",this.getName(),type.toString());
            LogHelper.info("��ǰ���������ϸ��Ϣ��{}", env.get("$REQUEST"));
            LogHelper.info("��ǰ��Ӧ������ϸ��Ϣ��{}", env.get("$RESPONSE"));
            return new AviatorString("defineResult");
        }
        @Override
        public String getName() {
            return "tdFunction";
        }
    }


}
