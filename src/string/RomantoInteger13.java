package string;



/*

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.


题目描述：将一个罗马数字转换为阿拉伯数字


这个题非常的扯，如果你不会罗马数字根本就不会做，而且做了也没有多大的意义

首先，学习一下罗马数字，参考罗马数字

罗马数字是最古老的数字表示方式，比阿拉伯数组早2000多年，起源于罗马

罗马数字有如下符号：

基本字符	        I	V	X	L	C	D	  M
对应阿拉伯数字	1	5	10	50	100	500	 1000

计数规则：
相同的数字连写，所表示的数等于这些数字相加得到的数，例如：III = 3
小的数字在大的数字右边，所表示的数等于这些数字相加得到的数，例如：VIII = 8
小的数字，限于（I、X和C）在大的数字左边，所表示的数等于大数减去小数所得的数，例如：IV = 4
正常使用时，连续的数字重复不得超过三次
在一个数的上面画横线，表示这个数扩大1000倍（本题只考虑3999以内的数，所以用不到这条规则）

其次，罗马数字转阿拉伯数字规则（仅限于3999以内）：

 */


public class RomantoInteger13 {
    public int romanToInt(String s){

        int[] num = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)){
                case 'M':
                    num[i] = 1000;
                    break;
                case 'D':
                    num[i] = 500;
                    break;
                case 'C':
                    num[i] = 100;
                    break;
                case 'L':
                    num[i] = 50;
                    break;
                case 'X':
                    num[i] = 10;
                    break;
                case 'V':
                    num[i] = 5;
                    break;
                case 'I':
                    num[i] = 1;
            }
        }

        int sum = 0,i = 0;
        for (; i < num.length-1; i++){
            if (num[i] < num[i+1]){
                sum -= num[i];
            }
            else {
                sum += num[i];
            }
        }
        return sum+num[i++];
    }


    public static void main(String[] args) {
        int n = new RomantoInteger13().romanToInt("3999");

        System.out.println("n = " + n);
    }
}
