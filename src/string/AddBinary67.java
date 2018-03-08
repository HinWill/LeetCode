package string;

/*

    Given two binary strings, return their sum (also a binary string).

    For example,
    a = "11"
    b = "1"
    Return "100".

 题目描述：给出两个二进制字符串，将它们相加后仍以二级制形式输出

 思路：先将两个字符串逐位从右到左相加的和与进位相加，放入字符数组中。
 最后等到短的字符串加完之后，留下较长的为加完毕字符串和进位，用以补充字符数组。当然这种解法比较麻烦：
 */


public class AddBinary67 {

    public String addBinary(String a, String b) {

        /*
        直接利用java 的api进行二进制转化为十进制后再转化为二进制，但是因为大小的限制，本题无法通过

        Integer n = Integer.valueOf(a,2) + Integer.valueOf(b,2);
        return Integer.toBinaryString(n);
        */

        if (a.equals("")) return b;
        if (b.equals("")) return a;               //如果b为空，则返回a
        int al = a.length() - 1;                 //字符串a的长度减1，刚好指向数组的末尾
        int bl = b.length() - 1;
        int t = Math.max(al, bl) + 1;
        char[] arr = new char[t + 1];             //设置要创建char数组的长度
        int c = 0;

        for (; al >= 0 && bl >= 0; al--, bl--, t--) {           //这里实现a1与b1的位相加
            int s = a.charAt(al) + b.charAt(bl) + c - '0' - '0';
            if (s == 2) {
                c = 1;
                s = 0;
            } else if (s == 3) {
                c = 1;
                s = 1;
            } else c = 0;
            arr[t] = (char) (s + '0');
        }
        while (al >= 0) {                      //若b字符串长度小于a长度，则继续求 a 和进位的和
            if (a.charAt(al) - '0' + c > 1) {
                arr[t] = 0 + '0';
                c = 1;
            } else {
                arr[t] = (char) (a.charAt(al) + c);
                c = 0;
            }
            t--;
            al--;
        }
        while (bl >= 0) {
            if (b.charAt(bl) - '0' + c > 1) {
                arr[t] = 0 + '0';
                c = 1;
            } else {
                arr[t] = (char) (b.charAt(bl) + c);
                c = 0;
            }
            t--;
            bl--;
        }
        if (c == 1) arr[0] = 1 + '0';
        //将数组转化为字符串输出
        return new String(arr).trim();
    }


    public static void main(String[] args) {
        String s = new AddBinary67().addBinary("10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101", "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011");
        System.out.println("s = " + s);
    }


}
