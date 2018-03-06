package array;
/*
Given an array arr that is a permutation of [0, 1, ..., arr.length - 1], we split the array into some number of "chunks" (partitions), and individually sort each chunk.  After concatenating them, the result equals the sorted array.

What is the most number of chunks we could have made?

Example 1:

Input: arr = [4,3,2,1,0]
Output: 1
Explanation:
Splitting into two or more chunks will not return the required result.
For example, splitting into [4, 3], [2, 1, 0] will result in [3, 4, 0, 1, 2], which isn't sorted.
Example 2:

Input: arr = [1,0,2,3,4]
Output: 4
Explanation:
We can split into two chunks, such as [1, 0], [2, 3, 4].
However, splitting into [1, 0], [2], [3], [4] is the highest number of chunks possible.
Note:

arr will have length in range [1, 10].
arr[i] will be a permutation of [0, 1, ..., arr.length - 1].


题目描述：给出0到arr.length-1之间的一个数组，将这些数组分成一些“块”（分区），并对每个块进行单独的排序，然后将
它们连接后，结果等于排序后的数组，问最多能分多少个分区块

思路：题中有一个点很重要，那就是permutation of [0, 1, ..., arr.length - 1]，数组中的元素是0到arr.length-1之间的
所以如果有序的话就是arr[i] == i，那么本身有序的数可以自成一段，而无序的只需要找到最大的那个错序数，作为分段的终点
也就是max 是i 之前中的最大数，如果max == i 那么就保证了前面的数字能够排列成正确的顺序，这就是一个分段，size++，
然后继续向下遍历，找到下一个满足max == i 的地方，就可以又分成一个块
在讨论区中也有很多使用迭代的方法，但是比较麻烦，还是这种方法比较简单，但是理解起来有点困难，要自己多找几个例子理解下


 */
public class MaxChunksToMakeSortec769 {

    public int maxChunksToSorted(int[] arr) {

        int size = 0;
        for (int i = 0,max = 0; i < arr.length; i++){
            max = Math.max(arr[i],max);
            if (max == i) size++;
        }
        return size;

    }


    public static void main(String[] args) {

        int n = new MaxChunksToMakeSortec769().maxChunksToSorted(new int[]{1});

        System.out.println("n = " + n);

    }
}
