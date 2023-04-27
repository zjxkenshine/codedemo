package com.kenshine.sevenzip;

import net.sf.sevenzipjbinding.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author by kenshine
 * @Classname ExtractCallback
 * @Description 解压回调
 * @Date 2023-04-27 19:22
 * @modified By：
 * @version: 1.0$
 */
public class ExtractCallback implements IArchiveExtractCallback {

    private int index;
    private IInArchive inArchive;
    private String ourDir;

    public ExtractCallback(IInArchive inArchive, String ourDir) {
        this.inArchive = inArchive;
        this.ourDir = ourDir;
    }

    @Override
    public ISequentialOutStream getStream(int index, ExtractAskMode extractAskMode) throws SevenZipException {
        this.index = index;
        final String path = (String) inArchive.getProperty(index, PropID.PATH);
        final boolean isFolder = (boolean) inArchive.getProperty(index, PropID.IS_FOLDER);
        final String[] oldPath = {""};
        return data -> {
            try {
                if (!isFolder) {
                    File file = new File(ourDir + "\\" + path);
                    if (path.equals(oldPath[0])) {
                        save2File(file, data, true);
                    } else {
                        save2File(file, data, false);
                    }
                    oldPath[0] = path;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            return data.length;
        };
    }

    @Override
    public void prepareOperation(ExtractAskMode extractAskMode) throws SevenZipException {

    }

    @Override
    public void setOperationResult(ExtractOperationResult extractOperationResult) throws SevenZipException {

    }

    @Override
    public void setTotal(long l) throws SevenZipException {

    }

    @Override
    public void setCompleted(long l) throws SevenZipException {

    }

    public boolean save2File(File file, byte[] msg, boolean append) {
        FileOutputStream fos = null;
        try {
            File parent = file.getParentFile();
            boolean bool;
            if ((!parent.exists()) && (!parent.mkdirs())) {
                return false;
            }
            fos = new FileOutputStream(file, append);
            fos.write(msg);
            fos.flush();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
