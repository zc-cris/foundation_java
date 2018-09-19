package day25;

import org.junit.Test;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.Instant;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class SocketServer {

    @Test
    public void test() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);


        while (true) {
            Socket accept = serverSocket.accept();

            new Thread(() -> new ReceiveFile(accept).run()).start();

        }

    }
}

class ReceiveFile {

    private Socket socket;

    public ReceiveFile(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            InputStream inputStream = socket.getInputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            String s = dataInputStream.readUTF();
            File file = new File("upload/" + Instant.now().toEpochMilli() + s);
            OutputStream outputStream = new FileOutputStream(file);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = (dataInputStream.read(bytes))) != -1) {
                outputStream.write(bytes, 0, len);
            }
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
