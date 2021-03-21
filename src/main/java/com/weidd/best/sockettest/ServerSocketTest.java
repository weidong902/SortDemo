package com.weidd.best.sockettest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-20 14:10
 **/
public class ServerSocketTest {
    public static void main(String[] args) throws IOException, InterruptedException {
        ServerSocket serverSocket = new ServerSocket(11111);
        while (true) {

            Socket accept = serverSocket.accept();
            InputStream inputStream = accept.getInputStream();
            byte[] bytes =new byte[1024];
            int read = inputStream.read(bytes);
            System.out.println(new String(bytes,0,read));
            Thread.sleep(4000);
            OutputStream outputStream = accept.getOutputStream();
            String str = "{"+new String(bytes, 0, read)+"}<---我能收到";
            outputStream.write(str.getBytes());

        }
    }
}
