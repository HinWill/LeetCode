package array;

/*
A zero-indexed array A of length N contains all integers from 0 to N-1. Find and return the longest length of set S, where S[i] = {A[i], A[A[i]], A[A[A[i]]], ... } subjected to the rule below.
Suppose the first element in S starts with the selection of element A[i] of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]… By that analogy, we stop adding right before a duplicate element occurs in S.

Example 1:
Input: A = [5,4,0,3,1,6,2]
Output: 6
Explanation:
A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.

One of the longest S[K]:
S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}

Note:
N is an integer within the range [1, 20,000].
The elements of A are all distinct.
Each element of A is an integer within the range [0, N-1].

题目描述：求一个数组中的连续嵌套的子数组的最长大小
（这道题看了好几遍才知道求什么，还有这里的output应该是输出为4，但是这里写的是6）

思路：看到是求数组的嵌套问题，最初的思路是复制一个数组，然后在数组中进行查找，如果找到后进行标记，防止出现P形的循环
后来看到讨论区的答案，发现不需要复制，直接可以在原来的数组中进行标记,
原因是题中的注意，N 的范围是[1 ,20000], A 的范围是[0, N-1] 而且数组没有重复项，
所以最长子数组的形状只可能是一个或者多个O的环，所以不必担心标记后改变了最长子数组中的元素值
 */

public class ArrayNesting565 {
    public int arrayNesting(int[] a) {
        int size = 0,maxsize = 0;
        for (int i = 0; i < a.length; i++) {
            size = 0;
            for (int k = i; a[k] >= 0; size++){
                int va = a[k];
                a[k] = -1;
                k = va;
            }
            maxsize = Math.max(size,maxsize);
        }
       return maxsize;
    }

    public static void main(String[] args) {
        int n = new ArrayNesting565().arrayNesting(new int[]{5,4,0,3,1,6,2});
        System.out.println("n = " + n);
    }
}
