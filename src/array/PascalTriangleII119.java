package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


/*
Given an index k, return the kth row of the Pascal's triangle.

For example, given k = 3,
Return [1,3,3,1].

Note:
Could you optimize your algorithm to use only O(k) extra space?



题目描述：求出给定k 行的杨辉三角

思路：这道题跟118很类似，但是这里要求出的是一样的结果，可以直接取出其中一行的数据返回，

但是这里的要求优化使用O(k)的空间，这样的实现方法为：对于每一行如果从前往后扫，那么第i个元素的值等于上一行的i+[i+1]的值，
可以看到数据是往前看的，如果只用一行的空间，那么需要的数据就会被覆盖掉，所以这里采用的是从后往前扫，这样每次需要的数据就是
i+[i-1]，这样需要的数据就不会被覆盖，因为需要的i只在当前使用，下一步就不需要了，

如果我们从前往后遍历，当i增加的时候，我们的num[j] = num[j] + num[j-1]就会出问题，
因为num[j+1]=num[j+1]+num[j],而num[j]已经更新了。
所以这里采用的是从后往前遍历，num[j] = num[j] + num[j-1],这样num[j-1] = num[j-1] + num[j-2]，
不会受到前面的num[j]的变化而变化。

这个技巧在动态规划省空间时也经常使用，主要就是看我们需要的数据是原来的数据还是新的数据来决定我们遍历的方向。
时间复杂度还是O(n^2)，而空间这里是O(k)来存储结果，仍然不需要额外空间。



 */


public class PascalTriangleII119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            list.add(1);
            for (int j = i-1; j > 0; j--) {
                list.set(j, list.get(j-1)+list.get(j));
            }
        }
        return list;
    }

    public static void main(String[] args) {
        List<Integer> list = new PascalTriangleII119().getRow(4);
        for (Integer integer : list) {
            System.out.println("integer = " + integer);
        }
    }
}
