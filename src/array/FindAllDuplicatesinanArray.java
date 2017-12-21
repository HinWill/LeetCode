package array;

import java.util.ArrayList;
import java.util.List;

/*

Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

Find all the elements that appear twice in this array.

Could you do it without extra space and in O(n) runtime?

看似一道很简单的题  但是题目中要求的限制了空间和时间复杂度，所以双循环肯定是不行的，如果可以的话可以使用java8中的Stream 来解决问题
这里中还有一个很重要的条件，1 ≤ a[i] ≤ n (n = size of array)，数组中的元素的值都是大于1小于数组的长度的，所以最优解中使用类似标记的方法
循环一遍数组，将每个元素值对应的数组元素取相反数，然后在之后的循环中进行判断，如果是相同元素值的话，那么所对应的数组元素应该是小于0的

 public static <E> List<E> getDuplicateElements(List<E> list) {
        return list.stream()                           // list 对应的 Stream
                .collect(Collectors.toMap(e -> e, e -> 1, (a, b) -> a + b)) // 获得元素出现频率的 Map，键为元素，值为元素出现的次数
                .entrySet().stream()                   // 所有 entry 对应的 Stream
                .filter(entry -> entry.getValue() > 1) // 过滤出元素出现次数大于 1 的 entry
                .map(entry -> entry.getKey())          // 获得 entry 的键（重复元素）对应的 Stream
                .collect(Collectors.toList());         // 转化为 List
    }

*/

import java.util.*;
public class FindAllDuplicatesinanArray {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
    }
}
