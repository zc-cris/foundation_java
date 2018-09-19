package com.java.object04;

import java.util.Scanner;

/**
 * @ClassName FamilyAccount
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class FamilyAccount {

    /**
     * 定义每笔收入或者支出的金额
     **/
    private static double shouzhi;
    /**
     * 定义每笔收入或者支出的说明
     **/
    private static String shuoming;
    /**
     * 定义程序的主界面
     **/
    private static String content;
    /**
     * 定义每笔收入或者支出的记录
     **/
    private static String details;
    /**
     * 定义用于控制程序循环的标志位
     **/
    private static boolean flag = true;
    /**
     * 定义接收用户命令行输入的Scanner类
     **/
    private static Scanner scanner;
    /**
     * 定义家庭初始总金额
     **/
    private static double balance;
    /**
     * 定义用户输入的选项数字
     **/
    private static int number;

    /**
     * @return void
     * @Author zc-cris
     * @Description 记账系统程序入口
     * @Param [args]
     **/
    public static void main(String[] args) {
        // 初始化程序参数
        init();
        // 开始执行程序
        run();
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 程序开始执行
     * @Param []
     **/
    private static void run() {
        while (flag) {
            System.out.print(content);
            number = scanner.nextInt();
            if (number < 1 || number > 4) {
                System.out.println("请重新输入正确的整数！");
                continue;
            }
            judgeNumber();
        }
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 初始化程序参数
     * @Param []
     **/
    private static void init() {
        balance = 10000;
        content = "------------家庭收支记账软件-----------\n\n" +
                "\t\t\t1 收支明细\n" +
                "\t\t\t2 登记收入\n" +
                "\t\t\t3 登记支出\n" +
                "\t\t\t4 退出\n\n" +
                "\t\t\t请选择(1-4):";
        details = "------------家庭收支记账软件-----------\n" +
                "收支\t收支金额\t账户金额\t说明\n";
        scanner = new Scanner(System.in);
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 根据用户输入数字判断
     * @Param []
     **/
    private static void judgeNumber() {
        switch (number) {
            case 4:
                System.out.print("请输入Y 确认退出：");
                String next = scanner.next();
                if (next.equalsIgnoreCase("Y")) {
                    flag = false;
                }
                break;
            case 1:
                System.out.println(details);
                break;
            case 2:
                System.out.print("本次收入金额：");
                shouzhi = scanner.nextInt();
                System.out.print("本次收入说明：");
                shuoming = scanner.next();
                balance += shouzhi;
                details += "收入\t" + shouzhi + "\t\t" + balance + "\t" + shuoming + "\n";
                break;
            case 3:
                System.out.print("本次支出金额：");
                shouzhi = scanner.nextInt();
                System.out.print("本次支出说明：");
                shuoming = scanner.next();
                balance -= shouzhi;
                details += "支出\t" + shouzhi + "\t\t" + balance + "\t" + shuoming + "\n";
                break;
            default:
        }
    }
}
