package com.dyx.algorithm.chapter01;

/**
 * chapter01:位运算与进制基础
 * Demo1
 * 数值的<<,>>,>>>（左移、带符号右移、无符号右移）
 *
 * @auther: mac
 * @since: 2019-06-24 01:46
 */
public class Demo1 {
    public static void main(String[] args) {
//        leftMove();
//        rightMoveWithSignal();
        rightMoveWithoutSignal();

    }

    // 无符号右移: >>> :右移高位都补0
    private static void rightMoveWithoutSignal() {
        System.out.println(">>>>>>>>>>>正数无符号右移<<<<<<<<<<");
        int d1 = 12;// 正数无符号右移，与正数带符号右移一致，不再举例
        System.out.println("二进制输出d1：" + Integer.toBinaryString(d1));
        int d2 = d1 >>> 2;
        System.out.println("d2：" + d2);
        System.out.println("二进制输出d2：" + Integer.toBinaryString(d2));
        System.out.println("===========分隔符===========");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println(">>>>>>>>>>>负数无符号右移<<<<<<<<<<");
        int e1 = -12;// 负数无符号右移，高位补0
        System.out.println("二进制输出e1：" + Integer.toBinaryString(e1));
        int e2 = e1 >>> 2;
        System.out.println("e2：" + e2);// 因为最高位是1，无符号右移，高位补0，变成正数
        System.out.println("二进制输出e2：" + Integer.toBinaryString(e2));
        System.out.println("===========分隔符===========");

        int e3 = e1 >>> 3;
        System.out.println("e3：" + e3);// 因为最高位是1，无符号右移，高位补0，变成正数
        System.out.println("二进制输出e3：" + Integer.toBinaryString(e3));
        System.out.println("===========分隔符===========");
    }

    // 带符号右移: >> :正数右移高位补0，负数右移高位补1。
    private static void rightMoveWithSignal() {
        System.out.println(">>>>>>>>>>>正数带符号右移<<<<<<<<<<");
        int b1 = 12;// 正数带符号右移
        System.out.println("二进制输出b1：" + Integer.toBinaryString(b1));
        int b2 = b1 >> 2;
        System.out.println("b2：" + b2);
        System.out.println("二进制输出b2：" + Integer.toBinaryString(b2));
        System.out.println("===========分隔符===========");

        int b3 = b1 >> 3;
        System.out.println("b3：" + b3);// 右移多少位就除以2的多少次方再取商的整数部分
        System.out.println("二进制输出b3：" + Integer.toBinaryString(b3));
        System.out.println("===========分隔符===========");

        int b4 = b1 >> 4;
        System.out.println("b4：" + b4);// 右移超出位数变为0
        System.out.println("二进制输出b4：" + Integer.toBinaryString(b4));
        System.out.println("===========分隔符===========");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();


        System.out.println(">>>>>>>>>>>负数带符号右移<<<<<<<<<<");
        int c1 = -12;// 负数带符号右移
        System.out.println("二进制输出c1：" + Integer.toBinaryString(c1));
        int c2 = c1 >> 2;// 负数带符号右移后，最高位空出来的位全用1补充
        System.out.println("c2：" + c2);
        System.out.println("二进制输出c2：" + Integer.toBinaryString(c2));
        System.out.println("===========分隔符===========");

        int c3 = c1 >> 3;// 若存在位数被截断的情况(不能被整除)，-12/8 = -1.5 取小于商的最大负整数-2
        System.out.println("c3：" + c3);
        System.out.println("二进制输出c3：" + Integer.toBinaryString(c3));
        System.out.println("===========分隔符===========");

        int c4 = c1 >> 4;// -12/16 = -0.75 取小于商的最大负整数-1
        System.out.println("c4：" + c4);
        System.out.println("二进制输出c4：" + Integer.toBinaryString(c4));
        System.out.println("===========分隔符===========");
    }

    // 左移操作: <<
    private static void leftMove() {
        int a1 = 12345;
        System.out.println("二进制输出a1：" + Integer.toBinaryString(a1));
        int a2 = a1 << 2;//左移两位，相当于乘以2的二次方
        System.out.println("a2：" + a2);
        System.out.println("二进制输出a2：" + Integer.toBinaryString(a2));
        System.out.println("===========分隔符===========");

        // 当数值乘以**倍之后超过了Integer.MAX,
        int intMax = Integer.MAX_VALUE;
        System.out.println("int类型的最大数：" + intMax);
        System.out.println("二进制输出intMax：" + Integer.toBinaryString(intMax));//总共有31个1，此时最高位的0没有输出
        System.out.println("===========分隔符===========");

        int a3 = 1234512345;
        System.out.println("二进制输出a3：" + Integer.toBinaryString(a3));//1001001100101010010100111011001(31位长)
        int a4 = a3 << 1;//左移一位变成32位，按位来看此时最高位是1，末尾补一个零，变为负数
        System.out.println("a3左移一位a4：" + a4);
        System.out.println("二进制输出a4：" + Integer.toBinaryString(a4));
        System.out.println("===========分隔符===========");

        int a5 = a3 << 2;//左移两位变成33位，按位来看超过32位，最高位的"1"被截断，接着两个"0"位则省去，末尾补两个零
        System.out.println("a3左移两位a5：" + a5);
        System.out.println("二进制输出a5：" + Integer.toBinaryString(a5));
        /**
         * 左移：正数左移，看移位之后，是否超过最大长度限制减一位即31位，如果没有超过31位，则还是正数，如果正好是32位，则变成负数，
         *      如果超过32位，会被截断，此时判断最高位是"0"还是"1"
         *      负数左移，一定会被截断，此时判断最高位是"0"还是"1"
         */
    }
}
