package com.github.yucdong.javabootcamp.basicio;

import java.io.*;

public class BufferedStreamDemo {
    static void createBigfile() throws java.io.IOException {
        OutputStream output = new FileOutputStream("d:\\java_demo\\bigfile");
        String data = "Hello, my names is yuchen dong, how are you?";
        for (int i = 0; i < 10000; i++) {
            output.write(data.getBytes());
        }
        output.close();
    }

    static void deleteBigfile() throws java.io.IOException {
        File f = new File("d:\\java_demo\\bigfile");
        if (f.exists()) {
            f.delete();
        }
    }

    static void NonBufferedRead() throws java.io.IOException {
        long startTime = System.nanoTime();
        for (int i = 0; i < 3; i++) {
            System.out.println("NonBuffer: Round " + i);
            InputStream input = new FileInputStream("d:\\java_demo\\bigfile");
            int data = input.read();
            while (data != -1) {
                //System.out.print((char) data);
                data = input.read();
            }
            input.close();
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("NonBuffered read: Average run time in millisec: " + (duration / 10 / 1000000));
    }

    static void BufferedRead() throws java.io.IOException {
        int bufferSize = 8 * 1024;
        long startTime = System.nanoTime();
        for (int i = 0; i < 3; i++) {
            System.out.println("Buffer: Round " + i);
            InputStream input = new BufferedInputStream(new FileInputStream("d:\\java_demo\\bigfile"), bufferSize);
            int data = input.read();
            while (data != -1) {
                //System.out.print((char) data);
                data = input.read();
            }
            input.close();
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime);  //divide by 1000000 to get milliseconds.
        System.out.println("Buffered read: Average run time in millisec: " + (duration / 10 / 1000000));
    }


    public static void main(String[] args) throws java.io.IOException {
        createBigfile();
        BufferedRead();
        NonBufferedRead();
        deleteBigfile();
    }
}
