package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/*

Given a list of 24-hour clock time points in "Hour:Minutes" format, find the minimum minutes difference between any two time points in the list.
Example 1:
Input: ["23:59","00:00"]
Output: 1
Note:
The number of time points in the given list is at least 2 and won't exceed 20000.
The input time is legal and ranges from 00:00 to 23:59.


题目描述：给出一组时间，找出其中分钟数最小的两组，然后计算其时间差

思路：先排序，然后找出最小与最大时间之间的差值，因为时间是循环的，首尾的差值也可能是最小的，然后计算相邻时间组之间的差值
得出最小的时间差
 */


public class MinimumTimeDifference539 {


    public int findMinDifference(List<String> timePoints) {

        int len = timePoints.size();
        Collections.sort(timePoints);


        int le = 24*60 - getTime(timePoints.get(len-1)) + getTime(timePoints.get(0));

        int tmp;
        for (int i = 0; i < len - 1; ++i){
            tmp = getTime(timePoints.get(i+1)) - getTime(timePoints.get(i));

            if (tmp < le){
                le = tmp;
            }
        }

        return le;
    }

    public int getTime(String s){
        char[] c = s.toCharArray();
        return (60*((c[0] - '0')*10 + (c[1] - '0')) + (c[3] - '0')*10 + (c[4]-'0'));
    }


    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("12:12","12:13"));

        int n = new MinimumTimeDifference539().findMinDifference(list);
        System.out.println("n = " + n);
    }
}
