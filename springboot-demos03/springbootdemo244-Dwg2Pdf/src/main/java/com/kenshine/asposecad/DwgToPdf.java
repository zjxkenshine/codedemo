package com.kenshine.asposecad;

import com.aspose.cad.Color;
import com.aspose.cad.Image;
import com.aspose.cad.imageoptions.CadRasterizationOptions;
import com.aspose.cad.imageoptions.PdfOptions;

/**
 * @author by kenshine
 * @Classname DwgToPdf
 * @Description DWG转PDF
 * @Date 2023-07-04 8:15
 * @modified By：
 * @version: 1.0$
 */
public class DwgToPdf {
    public static void main(String[] args) {
        DWGFileToPDF("E:\\plm\\DWG转PDF\\5502-8810.dwg", "E:\\plm\\DWG转PDF\\5502-8810.pdf");
    }

    /**
     * @param srcFile 选择dwg文件路径
     * @param dataDir 保存文件路径
     */
    public static void DWGFileToPDF(String srcFile, String dataDir) {

        Image objImage = Image.load(srcFile);
        CadRasterizationOptions rasterizationOptions = new CadRasterizationOptions();
        rasterizationOptions.setBackgroundColor(Color.getWhite());
        rasterizationOptions.setPageWidth(1600);
        rasterizationOptions.setPageHeight(1600);

        // Create an instance of PdfOptions
        PdfOptions pdfOptions = new PdfOptions();
        // Set the VectorRasterizationOptions property
        pdfOptions.setVectorRasterizationOptions(rasterizationOptions);
        // Export the DWG to PDF
        objImage.save(dataDir, pdfOptions);
    }
}
