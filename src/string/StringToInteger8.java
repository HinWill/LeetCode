package string;



/*


Implement atoi to convert a string to an integer.

题目描述：输入一段字符串转化为数字

思路：这里看似非常简单的就完成了题目中的要求，但是这也是这个题的最坑的地方，因为还有很多地方没有考虑到，比如：

判断输入是否为空，不然则会报错
判断开头是否为“-”，即是否为负数
输入的字符串中可能包含了不是数字的字符
输入的字符串不能太长了，因为过长可能会导致整数的溢出
其中最难解决的就是整数的溢出问题。

针对于整数溢出的问题，有两种处理的方式，

第一种是吧转换后返回的值n定义成long long类型

第二种是比较n和MAX_INF/10的大小，即：

若n>MAX_INF/10， 那么就说明最后一步转换时，n*10必定大于MAX_INF，所以在得知n>MAX_INF/10时，当即返回MAX_INF
若n == MAX_INF/10 时，那么比较最后一个数字c跟MAX_INF%10的大小，即如果n == MAX_INF/10且c>MAX_INF%10 ，则照样返回MAX_INF
 */
public class StringToInteger8 {

    public int myAtoi(String s) {
        int sign = 0;
        int len = s.length();
        int n = 0;
        int i = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE+1;
        if (len == 0) return 0;

        StringBuffer str = new StringBuffer(s.trim());

        if (str.charAt(i) == '-' || str.charAt(i) == '+'){
            if (str.charAt(i) == '-'){
                sign = 1;
            }
            i++;
        }

        while ( i < str.length() && (str.charAt(i) > 47 && str.charAt(i) < 58)){
            int c = str.charAt(i) - '0';
            if (sign == 0 && (n > max/10 || (n == max/10 &&  c>max%10))){
                return max;
            }
            if (sign == 1 && (n < min/10 || (n == min/10 && c<min%10))){
                return min;
            }
            n = n*10 + c;
            i++;
        }

        return sign >0 ? -n : n;
    }

    public static void main(String[] args) {
        int sum = new StringToInteger8().myAtoi("-2147483647");

        System.out.println("sum = " + sum);
    }
}
