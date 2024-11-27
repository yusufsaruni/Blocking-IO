package com.harmo.projects.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class MultiThreadedServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(9000)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("can only be printed after client is accepted..");
                new Server(clientSocket).start();
	        }
	    } catch (IOException e) {
            System.err.println("Could not listen on port " + 9000);
            System.exit(-1);
        }
    }
}