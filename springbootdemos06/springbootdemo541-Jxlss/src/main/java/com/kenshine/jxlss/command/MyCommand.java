package com.kenshine.jxlss.command;

import lombok.Data;
import org.jxls.command.AbstractCommand;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.common.Size;

/**
 * @author by kenshine
 * @Classname MyCommand
 * @Description 自定义指令
 * @Date 2023-12-05 15:33
 * @modified By：
 * @version: 1.0$
 */
@Data
public class MyCommand extends AbstractCommand {
    private String attr1;
    private String attr2;
    @Override
    public String getName() {
        return "my";
    }

    @Override
    public Size applyAt(CellRef cellRef, Context context) {
        // 如果属性值是个表达式则用下面方法解析出值来
        Object attr1Obj = getTransformationConfig().getExpressionEvaluator().evaluate(attr1, context.toMap());
        /*
         * 返回新的区域大小
         * Size对象指是当前指令处理的单元格区域大小
         * 如果指令执行完之后单元格区域大小有改变则需要返回新的大小，不然生成的excel样式就会有错乱
         */
        return new Size();
    }

}
