package com.weidd.best.sockettest;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

/**
 * @program: SortDemo
 * @author: weidd
 * @date: 2021-03-20 14:26
 **/
public class ClientSocket {

    public static void main(String[] args) throws IOException {

        SocketAddress endpoint = new InetSocketAddress("182.107.135.166", 11111);
//        SocketAddress endpoint = new InetSocketAddress("127.0.0.1", 11111);
        Socket socket = new Socket();
        long l = System.currentTimeMillis();
        try {
            socket.connect(endpoint);
        } finally {
            long end = System.currentTimeMillis();
            System.out.println(end - l);
        }

        socket.setSoTimeout(3000);
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好,你能收到我的消息吗?".getBytes());
        InputStream inputStream = socket.getInputStream();
        byte[] bytes = new byte[1024];
        int read = inputStream.read(bytes);
        String str = new String(bytes, 0, read);
        System.out.println(str);
        outputStream.close();
        socket.close();

    }
}
