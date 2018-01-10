package array;

import java.util.*;

import static java.lang.Math.abs;




/*

Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order, then the whole array will be sorted in ascending order, too.

You need to find the shortest such subarray and output its length.

题目描述：给了我们一个数组，让我们求最短的无序连续子数组，根据题目中的例子也不难分析出来是让我们找出数组中的无序的部分。


思路：
这道题非常的好，想了半天  最后又反复读题看到升序才有了思路，先将原数组全部升序后，
找出第一个不同于排序后的坐标和找出最后一个不同的坐标，相减就是其中最短子数组的长度了。
但是我的方法有一种特殊的情况，就是数组本身就是升序的，所以最后要判断一下。

看最优解中，发现真是太牛了。下面这种方法很叼啊，是O(n)的时间复杂度加上O(1)的空间复杂度，
我觉得这实际上是我的那种方法进行空间上的优化的结果，用两个变量mx和mn来代替上面的有序数组，
我们仔细来分析发现，最小值mn初始化为数组的最后一个数字，最大值mx初始化为了第一个数字，
然后我们从第二个数字开始遍历，mx和nums[i]之间取较大值赋值给mx，然后比较此时mx和nums[i]之间的大小关系，
如果mx大于nums[i]，就把i赋值给end，那么我们想如果第一个数字小于第二个，mx就会赋值为第二个数字，
这时候mx和nums[i]就相等了，不进行任何操作，这make sense，因为说明此时是有序的。mn和nums[n-1-i]之间取较小值赋给mn，
然后比较此时mn和nums[n-1-i]之间的大小关系，如果mn小于nums[n-1-i]，就把n-1-i赋值给start，那么什么时候会进行赋值呢，
是当倒数第二个数字大于最后一个数字，这样mn还是最后一个数字，而nums[n-1-i]就会大于mn，这样我们更新start。
我们可以看出start是不断往前走的，end是不断往后走的，整个遍历完成后，start和end就分别指向了最短无序连续子数组的起始和结束位置。

 */
public class ShortestUnsortedContinuousSubarray581 {

    public int findUnsortedSubarray(int[] A) {

        int n = A.length, beg = -1, end = -2, mn = A[n-1], mx = A[0];
        for (int i=1;i<n;i++) {
            mx = Math.max(mx, A[i]);
            mn = Math.min(mn, A[n-1-i]);
            if (A[i] < mx) end = i;
            if (A[n-1-i] > mn) beg = n-1-i;
        }
        return end - beg + 1;


        //My Personal Idea
       /*int[] n = nums.clone();
       Arrays.sort(n);
       int len = nums.length;
       int start = 0,end = 0;
        for (int i=0,j=len-1;i<len&&j>=0;i++,j--) {
            if(nums[i] != n[i]){
                end = i;
            }
            if(nums[j] != n[j]){
                start = j;
            }
        }
        if (start - end == 0){
            return 0;
        }else{
            return end - start +1;
        }*/
    }


    public static void main(String[] args) {
        int[] nums = new int[]{2, 6, 4, 8, 10, 9, 15};
        int m = new ShortestUnsortedContinuousSubarray581().findUnsortedSubarray(nums);
        System.out.println("m = " + m);
    }

}
