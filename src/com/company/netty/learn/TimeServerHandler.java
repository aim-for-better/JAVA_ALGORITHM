package com.company.netty.learn;

import org.omg.CORBA.TIMEOUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;
import java.util.concurrent.BlockingQueue;

/**
 * Created by zzy on 18-10-16.
 */
public class TimeServerHandler implements Runnable {

    private Socket socket;

    public TimeServerHandler(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {


        BufferedReader in=null;

        PrintWriter out=null;


        try {
            in=new BufferedReader(new InputStreamReader(this.socket.getInputStream()));

            out=new PrintWriter(this.socket.getOutputStream(),true);

            String currentTime=null;

            String body=null;

            while((body=in.readLine())!=null){

                if(body.equalsIgnoreCase("Query Time Order")){
                    currentTime=new Date(System.currentTimeMillis()).toString();
                }else{
                      currentTime="BAD ORDER";
                }
                System.out.println("The time server receiver is: "+body);
                out.println(currentTime);
            }
        } catch (IOException e) {
            e.printStackTrace();

            if(in!=null){
                try {
                    in.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }

            if(out!=null){
                out.close();

                out=null;
            }

            if(this.socket!=null){
                try {
                    this.socket.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                this.socket=null;
            }
        }
    }
}
