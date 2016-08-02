package com.grudiy.chat.server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class MainServer {

    public static void main(String[] args) {
        System.out.println("Welcome to Server...");
        ServerSocket srvSocket = null;
        Socket fromClient = null;

        try {
            srvSocket = new ServerSocket(9090);
        } catch (IOException e) {
            System.out.println("Couldn't listen to port");
            System.exit(-1);
        }

        try {
            System.out.println("Waiting for connection from Client...");
            fromClient = srvSocket.accept();
            System.out.println("Client connected.");

            BufferedReader in = new BufferedReader(
                    new InputStreamReader(fromClient.getInputStream()) //read input stream from ready socket
            );

            System.out.println("Messages from Client: ");
            String str = in.readLine();

            while (str != null) {
                System.out.println(str);
                str = in.readLine();
            }

            System.out.println("Good bye!");
            fromClient.close();
            srvSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
