package day11.homework;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName Crm
 * @Description TODO
 * @Author zc-cris
 * @Version 1.0
 **/
public class Crm {

    /**
     * 程序主画面内容
     **/
    private static String content;
    /**
     * 所有用户信息
     **/
    private static String details;
    /**
     * 程序运行标志位
     **/
    private static Boolean flag = true;
    /**
     * 判断用户输入的数字
     **/
    private static Integer number;
    /**
     * 判断用户输入的字符
     **/
    private static char c;
    /**
     * 存储用户信息的列表
     **/
    private static List<Customer> customers;
    /**
     * 用户名字
     **/
    private static String name;
    /**
     * 用户性别
     **/
    private static char sex;
    /**
     * 用户年龄
     **/
    private static int age;
    /**
     * 用户电话
     **/
    private static String tel;
    /**
     * 用户邮箱
     **/
    private static String mail;

    /**
     * @return void
     * @Author zc-cris
     * @Description 客户关系管理程序入口
     * @Param [args]
     **/
    public static void main(String[] args) {
        // 开始执行程序
        run();
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 静态初始化程序参数
     * @Param []
     **/
    static {
        content = "------------客户信息管理软件-----------\n\n" +
                "\t\t\t1 添加客户\n" +
                "\t\t\t2 修改客户\n" +
                "\t\t\t3 删除客户\n" +
                "\t\t\t4 客户列表\n" +
                "\t\t\t5 退出\n\n" +
                "\t\t\t请选择(1-5):";
        details = "------------客户列表-----------\n" +
                "编号 姓名  性别 年龄 电话  邮箱\n";
        customers = new ArrayList<>();
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 程序启动运行程序
     * @Param []
     **/
    private static void run() {
        while (flag) {
            System.out.print(content);
            // 引用工具类来判断用户输入的选项数字
            c = CMUtility.readMenuSelection();
            judgeNumber(c);
        }
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 根据用户输入的选项执行对应的函数
     * @Param [c]
     **/
    private static void judgeNumber(char c) {
        switch (c) {
            case '1':
                addCustomer();
                break;
            case '2':
                updateCustomer();
                break;
            case '3':
                deleteCustomer();
                break;
            case '4':
                showCustomers();
                break;
            case '5':
                System.out.print("请输入Y/N 确认退出：");
                c = CMUtility.readConfirmSelection();
                if (c == 'Y') {
                    flag = false;
                }
                break;
            default:
                break;
        }
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 展示所有用户信息
     * @Param []
     **/
    private static void showCustomers() {
        System.out.print(details);
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            String customerInfo = (i + 1) + "\t" +
                    customer.getName() + "\t" +
                    customer.getSex() + "\t" +
                    customer.getAge() + "\t" +
                    customer.getTel() + "\t" +
                    customer.getMail();
            System.out.println(customerInfo);
        }
        System.out.println("------------客户列表完成---------");
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 删除用户
     * @Param []
     **/
    private static void deleteCustomer() {
        System.out.println("-----------删除客户------------");
        System.out.print("请选择待删除的客户编号(-1退出)：");
        number = CMUtility.readInt();
        if (number == -1) {
            return;
        }
        System.out.print("确认是否删除(Y/N):");
        c = CMUtility.readConfirmSelection();
        if (c == 'Y') {
            // 这里大坑，传入Integer 类型不会作为index来删除，而是作为Object 来删除，只有实参为int 才会按照索引来删除元素
            number--;
            customers.remove(number.intValue());
        }
        System.out.println("------------删除完成---------------");
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 更新用户信息
     * @Param []
     **/
    private static void updateCustomer() {
        System.out.print("请选择待修改的客户的编号(-1退出)：");
        number = CMUtility.readInt();
        if (number == -1) {
            return;
        }
        Customer customer = customers.get(number - 1);

        System.out.print("姓名(" + customer.getName() + "):");
        name = CMUtility.readString(10, customer.getName());

        System.out.print("性别(" + customer.getSex() + "):");
        sex = CMUtility.readChar(customer.getSex());

        System.out.print("年龄(" + customer.getAge() + "):");
        age = CMUtility.readInt(customer.getAge());

        System.out.print("电话(" + customer.getTel() + "):");
        tel = CMUtility.readString(11, customer.getTel());

        System.out.print("邮箱(" + customer.getMail() + "):");
        mail = CMUtility.readString(11, customer.getMail());

        customer.setName(name);
        customer.setSex(sex);
        customer.setAge(age);
        customer.setTel(tel);
        customer.setMail(mail);

        System.out.println("------------修改完成----------");
    }

    /**
     * @return void
     * @Author zc-cris
     * @Description 添加员工信息
     * @Param []
     **/
    private static void addCustomer() {
        System.out.println("------添加客户------");
        System.out.print("姓名：");
        name = CMUtility.readString(5);
        System.out.print("性别：");
        sex = CMUtility.readChar();
        System.out.print("年龄：");
        age = CMUtility.readInt();
        System.out.print("电话：");
        tel = CMUtility.readString(11);
        System.out.print("邮箱：");
        mail = CMUtility.readString(11);
        System.out.println("------添加完成------");
        customers.add(new Customer(name, sex, age, tel, mail));
    }
}
