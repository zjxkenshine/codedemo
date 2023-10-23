package com.kenshine.zip4j;

import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

@Data
public class View {

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 压缩前大小
     */
    private long compressedSize;

    /**
     * 压缩后大小
     */
    private long uncompressedSize;

    /**
     * 是否为文件夹
     */
    private boolean directory;

    /**
     * 最后修改时间
     */
    private long lastModifiedTime;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
    }
}