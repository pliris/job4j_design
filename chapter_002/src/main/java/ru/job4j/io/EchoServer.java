package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    private  static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    @SuppressWarnings("checkstyle:InnerAssignment")
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean work = true;
            StringBuilder builder = new StringBuilder();
            while (work) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str;
                    while (!(str = in.readLine()).isEmpty()) {
                        if (str.contains("?msg=") && str.contains("GET")) {
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
                                int b = str.indexOf("msg=");
                                int e = str.indexOf("HTTP/1.1");
                                builder.append(str.subSequence(b + 4, e - 1));
                                out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                                out.write((builder.toString() + ", dear friend.").getBytes());
                                builder.setLength(0);
                            }
                        }
                    }
                }
            }
        } catch (IOException e) {
            LOG.error("Error of IO", e);
        }
    }
}