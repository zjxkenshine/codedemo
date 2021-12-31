package com.kenshine.responsewrapper.response;

import javax.servlet.ServletOutputStream;
import javax.servlet.WriteListener;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author ：kenshine
 * @date ：Created in 2021/12/31 21:36
 * @description：Response处理
 * @modified By：
 * @version: $
 */
public class CustomResponseWrapper extends HttpServletResponseWrapper {
    private ByteArrayOutputStream bytes = new ByteArrayOutputStream();
    private HttpServletResponse response;
    private PrintWriter pwrite;

    public CustomResponseWrapper(HttpServletResponse response) {
        super(response);
        this.response = response;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        // 将数据写到 byte 中
        return new MyServletOutputStream(bytes);
    }

    /**
     * 重写父类的 getWriter() 方法，将响应数据缓存在 PrintWriter 中
     */
    @Override
    public PrintWriter getWriter() throws IOException {
        pwrite = new PrintWriter(new OutputStreamWriter(bytes, StandardCharsets.UTF_8));
        return pwrite;
    }

    /**
     * 获取缓存在 PrintWriter 中的响应数据
     * @return
     */
    public byte[] getBytes() {
        if(null != pwrite) {
            pwrite.close();
            return bytes.toByteArray();
        }

        if(null != bytes) {
            try {
                bytes.flush();
            } catch(IOException e) {
                e.printStackTrace();
            }
        }
        return bytes.toByteArray();
    }

    class MyServletOutputStream extends ServletOutputStream {
        private ByteArrayOutputStream ostream ;

        public MyServletOutputStream(ByteArrayOutputStream ostream) {
            this.ostream = ostream;
        }

        @Override
        public void write(int b) throws IOException {
            // 将数据写到 stream　中
            ostream.write(b);
        }

        //检查非阻塞写入是否成功
        @Override
        public boolean isReady() {
            return false;
        }

        //为此ServletOutputStream设置WriteListener ，从而切换到非阻塞 IO
        @Override
        public void setWriteListener(WriteListener writeListener) {
        }
    }

}
