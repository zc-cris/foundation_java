package recursion;

/**
 * TODO
 *
 * @author zc-cris
 * @version 1.0
 **/
public class RecursionArraySum {
    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int sum = sum(arr);
        System.out.println("sum = " + sum);
    }

    /**
     * 对外暴露的计算数组元素之和的方法
     *
     * @param arr 目标数组
     * @return 数组元素之和
     */
    public static int sum(int[] arr) {
        // 为了提高效率，判断的语句只需要执行一次即可，所以应该放在sum 方法的外面
        if (arr == null || arr.length == 0) {
            throw new NullPointerException("arr is null");
        }
        return sum(arr, arr.length);
    }


    /**
     * 内部用递归来计算数组里面所有元素之和的方法，对外不可见
     *
     * @param arr    目标数组
     * @param length 数组的长度，每次递归-1
     * @return 每次递归返回对应的元素，最后返回所有元素之和
     */
    private static int sum(int[] arr, int length) {

        // 如果使用 三元运算符，最好使用（）来指定优先级
        return arr[length - 1] + (length == 1 ? 0 : sum(arr, length - 1));
    }
}
