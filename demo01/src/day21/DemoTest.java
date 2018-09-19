package day21;

import org.junit.Test;

import java.io.File;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
@SuppressWarnings("unused")
public class DemoTest {
    @Test
    public void test1() {
        File file = new File("c:/file/资料 - 副本");

       /* Long size = getSize(file);
        System.out.println("size = " + size);*/
        boolean b = deleteFiles(file);
        System.out.println("b = " + b);

    }

    /**
     * 递归删除文件/文件夹
     *
     * @param file 要删除的文件或者文件夹
     * @return 是否删除成功
     */
    public boolean deleteFiles(File file) {
        if (file.isFile()) {
            return file.delete();
        } else {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File file1 : files) {
                    deleteFiles(file1);
                }
            }
            return file.delete();
        }
    }

    /**
     * 递归获取文件/文件夹的大小
     *
     * @param file file 对象
     * @return 文件/文件夹的大小
     */
    public Long getSize(File file) {
        if (file.isFile()) {
            return file.length();
        } else {
            File[] files = file.listFiles();
            long size = 0;
            if (files != null && files.length > 0) {
                for (File file1 : files) {
                    size += getSize(file1);
                }
            }
            return size;
        }
    }
}
