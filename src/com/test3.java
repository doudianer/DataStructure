package com;

import java.io.*;

/*
* 大文件读写
*
* */
public   class test3 {

    void largeFileIO(String inputFile, String outputFile) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(new File(inputFile)));
            BufferedReader in = new BufferedReader(new InputStreamReader(bis, "utf-8"), 10 * 1024 * 1024);//10M缓存
            FileWriter fw = new FileWriter(outputFile);
            while (in.ready()) {
                String line = in.readLine();
                fw.append(line + "\n");
            }
            in.close();
            fw.flush();
            fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[]args)
    {
        test3 t=new test3();
        t.largeFileIO("C:\\Users\\wl105\\Documents\\access.20161111.log\\access.20161111.txt","C:\\Users\\wl105\\Documents\\access.20161111.log\\b.txt");
        System.out.println("结束");
    }
}
