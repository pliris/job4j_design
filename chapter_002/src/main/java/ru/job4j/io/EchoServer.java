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
                        if (str.contains("?msg=")) {
                            if (str.contains("Hello")) {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write("Hello, dear friend.".getBytes());
                            } else if (str.contains("Exit")) {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write("Bye, dear friend.".getBytes());
                                work = false;
                                socket.close();
                                break;
                            } else {
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write("Any, dear friend.".getBytes());
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}