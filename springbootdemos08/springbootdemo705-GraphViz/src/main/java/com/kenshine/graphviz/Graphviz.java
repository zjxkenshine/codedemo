package com.kenshine.graphviz;

import java.io.*;

/**
 * @author kenshine
 * Graphviz第三方库
 */
public class Graphviz {
    /**
     * 临时文件目录
     * //private static String TEMP_DIR = "/tmp"; // Linux
     */
    private static String TEMP_DIR = "D:/tmp"; // Windows

    /**
     * dot程序本地地址，会被外部调用
     * private static String DOT = "/usr/bin/dot"; // Linux
     */
    private static String DOT = "D:\\Program1\\Graphviz\\bin\\dot.exe"; // Windows

    /**
     * 用dot语法描述图形来源.
     */
    private StringBuilder graph = new StringBuilder();

    /**
     * 创建一个新的GraphViz对象，该对象将包含一个图
     */
    public Graphviz() {
    }

    /**
     * 以点语言返回图形的源描述
     */
    public String getDotSource() {
       return graph.toString();
    }

    /**
     * 将字符串添加到图形的源中（不带换行符）
     */
    public void add(String line) {
       graph.append(line);
    }

    /**
     * 将字符串添加到图形的源中（带换行符）
     */
    public void addln(String line) {
       graph.append(line + "\n");
    }

    /**
     * 将新行添加到图形的源中
     */
    public void addln() {
       graph.append('\n');
    }

    /**
     * 以二进制格式的图像形式返回图形
     * @param dot_source 图形来源.
     * @param type gif, dot, fig, pdf, ps, svg, png.
     * @return 包含图形图像的字节数组
     */
    public byte[] getGraph(String dot_source, String type)
    {
       File dot;
       byte[] img_stream = null;

       try {
          dot = writeDotSourceToFile(dot_source);
          if (dot != null)
          {
             img_stream = get_img_stream(dot, type);
             if (dot.delete() == false)
                System.err.println("Warning: " + dot.getAbsolutePath() + " could not be deleted!");
             return img_stream;
          }
          return null;
       } catch (java.io.IOException ioe) { return null; }
    }

    /**
     * 将图形的图像写入文件中
     * @param img   A byte array containing the image of the graph.
     * @param file  Name of the file to where we want to write.
     * @return Success: 1, Failure: -1
     */
    public int writeGraphToFile(byte[] img, String file)
    {
       File to = new File(file);
       return writeGraphToFile(img, to);
    }

    /**
     * 将图形的图像写入文件中
     * @param img   A byte array containing the image of the graph.
     * @param to    A File object to where we want to write.
     * @return Success: 1, Failure: -1
     */
    public int writeGraphToFile(byte[] img, File to)
    {
       try {
          FileOutputStream fos = new FileOutputStream(to);
          fos.write(img);
          fos.close();
       } catch (java.io.IOException ioe) { ioe.printStackTrace();return -1; }
       return 1;
    }

    /**
     * 调用外部dot程序，并以二进制格式返回图像
     *
     * @param dot Source of the graph (in dot language).
     * @param type Type of the output image to be produced, e.g.: gif, dot, fig, pdf, ps, svg, png.
     * @return The image of the graph in .gif format.
     */
    private byte[] get_img_stream(File dot, String type) {
       File img;
       byte[] img_stream = null;

        try {
          img = File.createTempFile("graph_", "."+type, new File(Graphviz.TEMP_DIR));
          Runtime rt = Runtime.getRuntime();

          String[] args = {DOT, "-T"+type, dot.getAbsolutePath(), "-o", img.getAbsolutePath()};
          Process p = rt.exec(args);

          p.waitFor();

            FileInputStream in = new FileInputStream(img.getAbsolutePath());
          img_stream = new byte[in.available()];
          in.read(img_stream);
          // Close it if we need to
          if( in != null ) {
              in.close();
          }
            if (img.delete() == false) {
                System.err.println("Warning: " + img.getAbsolutePath() + " could not be deleted!");
            }
       }
       catch (java.io.IOException ioe) {
          System.err.println("Error:    in I/O processing of tempfile in dir " + Graphviz.TEMP_DIR+"\n");
          System.err.println("       or in calling external command");
          ioe.printStackTrace();
       }
       catch (java.lang.InterruptedException ie) {
          System.err.println("Error: the execution of the external program was interrupted");
          ie.printStackTrace();
       }

        return img_stream;
    }
    /**
     * 将图形的源写入文件，并将写入的文件作为file对象返回
     *
     * @param str Source of the graph (in dot language).
     * @return The file (as a File object) that contains the source of the graph.
     */
    public File writeDotSourceToFile(String str) throws java.io.IOException
    {
       File temp;
       try {
          temp = File.createTempFile("graph_", ".dot.tmp", new File(Graphviz.TEMP_DIR));
          FileWriter fout = new FileWriter(temp);
          fout.write(str);
          fout.close();
       }
       catch (Exception e) {
          System.err.println("Error: I/O error while writing the dot source to temp file!");
          return null;
       }
       return temp;
    }

    /**
     * 返回用于启动图形的字符串
     * @return A string to open a graph.
     */
    public String start_graph() {
       return "digraph G {" ;
    }

    /**
     * 结束图形的字符串
     * @return A string to close a graph.
     */
    public String end_graph() {
        return "}";
    }

    /**
     * 从text中读取dot图.
     *
     * @param input Input text file containing the DOT graph
     * source.
     */
    public void readSource(String input) {
        StringBuilder sb = new StringBuilder();

        try {
        FileInputStream fis = new FileInputStream(input);
        DataInputStream dis = new DataInputStream(fis);
        BufferedReader br = new BufferedReader(new InputStreamReader(dis));
        String line;
        while ((line = br.readLine()) != null) {
        sb.append(line);
        }
        dis.close();
        }
        catch (Exception e) {
        System.err.println("Error: " + e.getMessage());
        }
        this.graph = sb;
    }

}