package com.harmo.projects.client;

import java.io.*;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try (
        Socket client = new Socket("localhost", 9000);
        PrintWriter out = new PrintWriter(client.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()))
        ){
            String fromServer,fromUser;
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in));
            while ((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                if (fromServer.equals("Bye"))
                    break;

                //Reading from the console.
                fromUser = stdIn.readLine();
                if (fromUser != null) {
                    System.out.println("You: " + fromUser);
                    //Sending to the server.
                    out.println(fromUser);
                }
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
