package com.github.yucdong.javabootcamp.basicio;

import java.io.File;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
    public static void main(String[] args) throws java.io.IOException {
        RandomAccessFile outfile = new RandomAccessFile("d:\\java_demo\\raf.txt", "rw");
        outfile.write("hello, world".getBytes());
        outfile.close();

        RandomAccessFile outfile2 = new RandomAccessFile("d:\\java_demo\\raf.txt", "rw");
        outfile2.seek(7);
        outfile2.write("WO".getBytes());
        outfile2.close();

        RandomAccessFile outfile3 = new RandomAccessFile("d:\\java_demo\\raf.txt", "rw");
        int input = outfile3.read();
        while (input != -1) {
            System.out.print((char) input);
            input = outfile3.read();
        }
        System.out.println();

        outfile3.close();
        File f = new File("d:\\java_demo\\raf.txt");
        f.delete();
        System.out.println("File deleted");
    }
}
