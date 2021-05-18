package com.weidd.best.dataStructureandAlgorithms.algorithms.leetcode.editor.cn.test;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.text.SimpleDateFormat;

/**
 * @program: JavaCode
 * @author: weidd
 * @date: 2020-12-26 21:12
 **/
public class Client extends Frame{
    TextArea ta;//聊天记录框
    Panel p;//包含单行发送消息框和发送按钮
    TextField tf;//单行发送消息框
    Button btn;//发送按钮

    Socket socket;

    DataInputStream dis;//读取数据（即服务端发送的数据）
    DataOutputStream dos;//发送数据

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        new Client();
    }
    public Client() {
        init();//搭建窗体
        connect();//建立连接
        new ClientThread(this).start();//启动线程  时刻接收数据
    }

    void connect() {
        try {
            //建立一个Socket连接
            socket = new Socket(InetAddress.getLocalHost(),9999);
            //从socket里面获取输入流信息
            InputStream inputStream = socket.getInputStream();
            dis = new DataInputStream(inputStream);

            //从socket里面获取输出流信息
            OutputStream outputStream = socket.getOutputStream();
            dos = new DataOutputStream(outputStream);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    void init() {
        ta = new TextArea();
        p = new Panel();
        tf = new TextField();
        btn = new Button("发送");

        p.setLayout(new BorderLayout());
        p.add(tf, BorderLayout.CENTER);
        p.add(btn, BorderLayout.EAST);

        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                /*
                 * 获取当前的 客户端名字、时间、消息内容
                 */
                String name = Client.this.getTitle();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss:SSS");
                String time = simpleDateFormat.format(System.currentTimeMillis());
                String text = tf.getText();
                String msg = name+" "+time+"\n\r\t"+text+"\r\n";
                ta.append(msg);
                tf.setText("");//清空输入框
                //发送消息msg
                try {
                    //将信息通过输出流的方式写出去
                    dos.writeUTF(msg);
                } catch (IOException e1) {
                    // TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });

        this.setTitle("客户端");
        this.add(ta,BorderLayout.CENTER);
        this.add(p,BorderLayout.SOUTH);
        this.setSize(400,400);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

}
class ClientThread extends Thread{

    Client client;

    public ClientThread(Client client) {
        this.client = client;
    }

    @Override
    public void run() {
        try {
            while (true) {
                String msg = client.dis.readUTF();
                client.ta.append(msg);
            }
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
