package com.kenshine.jxls.listener;

import com.kenshine.jxls.model.Employee;
import org.apache.poi.ss.usermodel.*;
import org.jxls.area.XlsArea;
import org.jxls.common.AreaListener;
import org.jxls.common.CellRef;
import org.jxls.common.Context;
import org.jxls.transform.poi.PoiTransformer;

/**
 * @author by kenshine
 * @Classname SimpleAreaListener
 * @Description 自定义监听
 * @Date 2023-11-27 9:36
 * @modified By：
 * @version: 1.0$
 */
public class SimpleAreaListener implements AreaListener {
    XlsArea area;
    PoiTransformer transformer;
    private final CellRef bonusCell1 = new CellRef("Template!E9");
    private final CellRef bonusCell2 =new CellRef("Template!E18");

    public SimpleAreaListener(XlsArea area) {
        this.area = area;
        transformer = (PoiTransformer) area.getTransformer();
    }

    @Override
    public void beforeApplyAtCell(CellRef cellRef, Context context) {

    }

    @Override
    public void afterApplyAtCell(CellRef cellRef, Context context) {

    }

    @Override
    public void beforeTransformCell(CellRef srcCell, CellRef targetCell, Context context) {

    }

    @Override
    public void afterTransformCell(CellRef srcCell, CellRef targetCell, Context context) {
        // we are at employee bonus cell
        if(bonusCell1.equals(srcCell) || bonusCell2.equals(srcCell)){
            // highlight bonus when >= 20%
            Employee employee = (Employee) context.getVar("employee");
            if( employee.getBonus() >= 0.2 ){
                highlightBonus(targetCell);
            }
        }
    }

    /**
     *  高亮处理
     */
    private void highlightBonus(CellRef cellRef) {
        Workbook workbook = transformer.getWorkbook();
        Sheet sheet = workbook.getSheet(cellRef.getSheetName());
        Cell cell = sheet.getRow(cellRef.getRow()).getCell(cellRef.getCol());
        CellStyle cellStyle = cell.getCellStyle();
        CellStyle newCellStyle = workbook.createCellStyle();
        newCellStyle.setDataFormat( cellStyle.getDataFormat() );
        newCellStyle.setFont( workbook.getFontAt( cellStyle.getFontIndex() ));
        newCellStyle.setFillBackgroundColor( cellStyle.getFillBackgroundColor());
        newCellStyle.setFillForegroundColor(IndexedColors.ORANGE.getIndex());
        newCellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cell.setCellStyle(newCellStyle);
    }
}
