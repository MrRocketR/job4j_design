package ru.job4j.io.sockets;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EchoServer {
    private static final Logger LOG = LoggerFactory.getLogger(EchoServer.class.getName());
    public static void main(String[] args) {
        try (ServerSocket server = new ServerSocket(9000)) {
            while (!server.isClosed()) {
                Socket socket = server.accept();
                try (OutputStream out = socket.getOutputStream();
                     BufferedReader in = new BufferedReader(
                             new InputStreamReader(socket.getInputStream()))) {
                    out.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                    String str = in.readLine();
                    if (str.contains("Exit")) {
                        System.out.println("Closed");
                        out.write("Closing server".getBytes());
                        server.close();
                    } else if (str.contains("Hello")) {
                        System.out.println(str);
                        out.write("Hello, dear friend.".getBytes());
                    } else if (!str.isEmpty() && str.contains("msg=")) {
                        String[] output = str.split("\\s");
                        String s = output[1].substring(output[1].indexOf("=") + 1);
                        System.out.println(s);
                        out.write(s.getBytes());
                    }
                    out.flush();
                }
            }
    } catch (IOException e) {
            LOG.error("IOException in log", e);
        }
    }
}
