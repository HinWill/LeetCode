//
// Created by will on 2017/12/15.
//


/*
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
    Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.

这道题整整花了快一个小时，试了好几种方法。先来分析题目，找到频率最大，距离最小的子数组的长度，
 根据上一道题的经验，只遍历一遍肯定是最优的解法，所以一开始我想的是用map寻找出频率最高的，
 再使用遍历数组找出元素的长度，但还是想用一种更为简便的方法去解，一般都是用空间去换时间。
这里声明了两个map，一个存储元素第一次出现的下标，第二个map存储出现的次数，
 通过len = min(i - map[nums[i]] + 1, len);来取出现频率相同的子数组中的最小长度，最后返回len

 */


#include <iostream>
#include <vector>
#include <unordered_map>

using namespace std;


class Solution {
public:
    int findShortestSubArray(vector<int>& nums) {
        unordered_map<int, int> map,count;

        int len = nums.size(), flag = 0;

        for (int i = 0; i < nums.size(); ++i) {
            if (map.count(nums[i]) == 0) map[nums[i]] = i;
            count[nums[i]]++;

            if(count[nums[i]] == flag){
                len = min(i - map[nums[i]] + 1, len);
            }

            if (count[nums[i]] > flag){
                len = i - map[nums[i]] + 1, len;
                flag = count[nums[i]];
            }

        }

        return len;




    }
};



int main(){
    vector<int> nums = {1,2,3,4,2};
    Solution s;
    int len = s.findShortestSubArray(nums);
    cout<<len;

    return 0;
}