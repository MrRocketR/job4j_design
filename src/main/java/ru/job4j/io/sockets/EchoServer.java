package ru.job4j.io.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    String str = in.readLine();
                    if (str.contains("Exit")) {
                        System.out.println("Closed");
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("Closing server".getBytes());
                        server.close();
                    } else if (str.contains("Hello")) {
                        System.out.println(str);
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write("Hello, dear friend.".getBytes());
                    } else if (!str.isEmpty() && str.contains("msg=")) {
                        String[] output = str.split("\\s");
                        String s = output[1].substring(output[1].indexOf("=") + 1);
                        System.out.println(s);
                        out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                        out.write(s.getBytes());
                    }
                    out.flush();
                }
            }
        }
    }
}
