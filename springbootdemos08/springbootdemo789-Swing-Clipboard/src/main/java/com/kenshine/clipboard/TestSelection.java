package com.kenshine.clipboard;

import java.awt.datatransfer.*;
import java.io.IOException;

/**
 * @author kenshine
 */
public class TestSelection implements Transferable, ClipboardOwner {
    //class为自定义的java类 字串随便
    public static final DataFlavor rangeFlavor = new DataFlavor(RangeDataModel.class, "Report Range");
    private static final DataFlavor[] flavors = { rangeFlavor };
    private Object data;
    public TestSelection(Object data) {
        this.data = data;
    }
    @Override
    public Object getTransferData(DataFlavor flavor) throws UnsupportedFlavorException, IOException {
        if (flavor.equals(flavors[0])) {
            return data;
        } else {
            throw new UnsupportedFlavorException(flavor);
        }
    }
    @Override
    public DataFlavor[] getTransferDataFlavors() {
        return flavors.clone();
    }
    @Override
    public boolean isDataFlavorSupported(DataFlavor flavor) {
        for (int i = 0; i < flavors.length; i++) {
            if (flavor.equals(flavors[i])) {
                return true;
            }
        }
        return false;
    }
    @Override
    public void lostOwnership(Clipboard clipboard, Transferable contents) {
        // 数据更改监控
    }
}