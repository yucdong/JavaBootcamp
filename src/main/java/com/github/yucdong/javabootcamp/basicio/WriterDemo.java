package com.github.yucdong.javabootcamp.basicio;

import java.io.*;
import java.nio.charset.Charset;

public class WriterDemo {
    static void writeUtfText() throws java.io.IOException {
        OutputStream out = new FileOutputStream("d:\\java_demo\\out_utf8.txt");
        OutputStreamWriter writer = new OutputStreamWriter(out, Charset.forName("UTF-8"));
        writer.write("你好中国");
        writer.close();
    }

    static void readAsRaw() throws java.io.IOException {
        InputStream in = new FileInputStream("d:\\java_demo\\out_utf8.txt");

        int data = in.read();
        while (data != -1) {
            System.out.print((char) data);
            data = in.read();
        }
        System.out.println();
        in.close();
    }

    static void readAsChar() throws java.io.IOException {
        InputStream input = new FileInputStream("d:\\java_demo\\out_utf8.txt");
        try (InputStreamReader reader = new InputStreamReader(input, Charset.forName("UTF-8"))) {
            int data = reader.read();
            while (data != -1) {
                System.out.print((char) data);
                data = reader.read();
            }
        }
        System.out.println();
    }

    public static void main(String[] args) throws java.io.IOException {
        writeUtfText();
        readAsRaw();
        readAsChar();
    }
}
