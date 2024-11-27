package com.harmo.projects.server;

import java.io.*;
import java.net.Socket;

public class Server extends Thread{

    private final Socket socket;

    public Server(Socket socket) {
        super("Server Thread");
        this.socket = socket;
    }

    @Override
    public void run(){
        try (
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){

            String outputLine, inputLine;
            //Server initial message.
            outputLine = reader.readLine();
            out.println(outputLine);

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Client: " + inputLine);
                //Server Responding
                outputLine = reader.readLine();
                out.println(outputLine);
                if (outputLine.equals("Bye"))
                    break;
            }
            socket.close();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
