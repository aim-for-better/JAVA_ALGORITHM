package com.company.netty.learn;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by zzy on 18-10-16.
 */
public class TimeServer {

    public static void main(String[] args){

        int port=9001;
        if(args!=null&&args.length>0){
            port=Integer.parseInt(args[0]);
        }

        ServerSocket server=null;

        try {
            server=new ServerSocket(port);

            System.out.println("The time Server is start in port: "+port);
            Socket  socket=null;
            while(true){
                socket=server.accept();

                new Thread(new TimeServerHandler(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(server!=null){
                System.out.println("The time server close");
                try {
                    server.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                server=null;
            }
        }
    }
}
