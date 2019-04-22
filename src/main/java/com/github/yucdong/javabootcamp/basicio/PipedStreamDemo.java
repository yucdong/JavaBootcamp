package com.github.yucdong.javabootcamp.basicio;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {
    public static void main(String[] args) throws java.io.IOException {
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output);

        Thread threadWrite = new Thread(new Runnable() {
            public void run() {
                try {
                    output.write("Hello World".getBytes());
                } catch (IOException e) {

                }
            }
        });

        Thread threadRead = new Thread(new Runnable() {
            public void run() {
                try {
                    int data = input.read();
                    while (data != -1) {
                        System.out.println((char)data);
                        data = input.read();
                    }
                } catch (IOException e) {

                }
            }
        });

        threadRead.start();
        threadWrite.start();
    }
}
