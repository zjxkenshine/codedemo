package com.kenshine.junrar;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

/**
 * @author by kenshine
 * @Classname UnRarDemo
 * @Description 解压rar方法
 * @Date 2023/3/22 14:12
 * @modified By：
 * @version: 1.0$
 */
public class UnRarDemo {

    // 解压rar
    public static boolean  unrar(String rarFileName, String outFilePath)  throws  Exception{
        try  {
            Archive archive = new Archive(new File(rarFileName), new UnrarProcessMonitor(rarFileName));
            if(archive.isEncrypted()){
                throw new Exception(rarFileName + " IS ENCRYPTED!");
            }
            List<FileHeader> files =  archive.getFileHeaders();
            for (FileHeader fh : files) {
                if(fh.isEncrypted()){
                    throw new Exception(rarFileName + " IS ENCRYPTED!");
                }
                String fileName = fh.getFileName();
                if(fileName != null && fileName.trim().length() > 0){
                    String saveFileName = outFilePath+ File.separator+fileName;
                    File saveFile = new File(saveFileName);
                    File parent =  saveFile.getParentFile();
                    if(!parent.exists()){
                        parent.mkdirs();
                    }
                    if(!saveFile.exists()){
                        saveFile.createNewFile();
                    }
                    // 排除目录
                    if(!saveFile.isDirectory()){
                        FileOutputStream fos = new FileOutputStream(saveFile.getAbsolutePath());
                        try {
                            archive.extractFile(fh, fos);
                            fos.flush();
                            fos.close();
                        } catch (RarException ignored) {
                        }
                    }
                }
            }
            return true;
        } catch  (Exception e) {
            e.printStackTrace();
            System.out.println("failed.");
            return false;
        }
    }

}
