package day25;

import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class Client {
    public static void main(String[] args) throws IOException {

        Socket socket = new Socket("192.168.19.132", 8888);
        System.out.println("请输入文件名：");
        Scanner scanner = new Scanner(System.in);
        String fileName = scanner.next();

        FileInputStream inputStream = new FileInputStream(fileName);
        OutputStream outputStream = socket.getOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
        try (inputStream; outputStream) {
            dataOutputStream.writeUTF(fileName.substring(fileName.lastIndexOf(".")));
            byte[] bytes = new byte[1024];
            int len;
            while ((len = (inputStream.read(bytes))) != -1) {
                outputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
