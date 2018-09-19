package day22;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class CopyFiles {
    public static void main(String[] args) throws IOException {
        copyFiles("c:/File/张城", "c:/File/张城副本");

    }

    @Test
    public void test() {
        File file = new File("c:/File/1.txt");
        System.out.println("file.getName() = " + file.getName());
        String substring = "c:/File/1.txt".substring("c:/File/1.txt".lastIndexOf("/"));
        System.out.println("substring = " + substring);
    }

    public static boolean copyFiles(String srcDir, String desDir) throws IOException {
        if (srcDir == null || "".equals(srcDir.trim()) || desDir == null || "".equals(desDir.trim())) {
            return false;
        }
        File srcFile = new File(srcDir);
        File desFile = new File(desDir);
        if (!(srcFile.isDirectory()) || !(desFile.isDirectory())) {
            return false;
        }

        copy(srcFile, desDir + srcDir.substring(srcDir.lastIndexOf("/")));
        return true;
    }

    public static void copy(File file, String path) throws IOException {
        if (file.isFile()) {
            int len;
            byte[] bytes = new byte[1024];
            FileInputStream inputStream = new FileInputStream(file);
            FileOutputStream outputStream = new FileOutputStream(path);
            try (inputStream; outputStream) {
                while ((len = (inputStream.read(bytes))) != -1) {
                    outputStream.write(bytes, 0, len);
                }
            }
        } else {
            File file2 = new File(path);
            file2.mkdir();
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File file1 : files) {
                    copy(file1, path + "/" + file1.getName());
                }
            }
        }
    }

}
