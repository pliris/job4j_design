package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean work = true;
            while (work) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("Bye")) {
                            work = false;
                            break;
                        }
                        System.out.println(str);
                    }
                    out.write("HTTP/1.1 200 OK\r\n\\".getBytes());

                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}