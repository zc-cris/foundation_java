package day16;


import java.util.Scanner;

/**
 * @author zc-cris
 * @version 1.0
 **/
public class Test02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入序号：");
        int i = scanner.nextInt();
        Payment payment = Payment.getPayment(i);
        System.out.println("payment's name is " + payment.name() + payment);
    }
}

@SuppressWarnings("unused")
enum Payment {

    /**
     * 银行卡支付
     */
    BankCard(1, "银行卡支付"),
    /**
     * 支付宝支付
     */
    ZhiFuBao(2, "支付宝支付"),
    /**
     * 微信支付
     */
    WeiXin(3, "微信支付"),
    /**
     * 虚拟币支付
     */
    XuNiBi(4, "虚拟币支付"),
    /**
     * 现金支付
     */
    XianJin(5, "现金支付");

    private int id;
    private String des;

    Payment(int id, String des) {
        this.id = id;
        this.des = des;
    }

    public static Payment getPayment(int id) {
        return Payment.values()[id - 1];
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", des='" + des + '\'' +
                '}';
    }
}
