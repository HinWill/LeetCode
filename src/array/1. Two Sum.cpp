//
// Created by will on 2017/12/14.
//


/*
 *Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *You may assume that each input would have exactly one solution, and you may not use the same element twice.

 根据题目的意思就是要在一个数组中找出两个元素之和为给定数的值
思路一：
首先想到就是最简单最暴力的两个for循环，固定一个数，再去寻找数组中的其他数相加与给定数进行比较。
这种方法的时间复杂度为O(nlogn).

思路二：
可以通过哈希表的索引值更快的查找另一个差值，也就是判断 target-nums[i] 是否在哈希表中，
此方法时间复杂度为O(n)，空间复杂度是O(1)

 */

#include <iostream>
#include <vector>
#include <unordered_map>


using namespace std;
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        /*
        for (int i = 0; i < nums.size(); ++i) {
            for (int j = i+1; j < nums.size(); ++j) {
                if(nums[i]+nums[j] == target){
                    vector<int> sum ={i,j};
                    return sum;
                }
            }
        }
         */

        unordered_map<int, int> map;
        vector<int> resoult;

        for (int i = 0; i < nums.size(); i++) {
            int tofind = target - nums[i];
            if (map.count(tofind)){
                resoult.push_back(map[tofind]);
                resoult.push_back(i);
                break;
            }
            map[nums[i]] = i;
        }

        return resoult;

    }
};


int main(){

    vector<int> nums = {2, 7, 11, 15};
    Solution s;
    vector<int> sum = s.twoSum(nums,9);

    cout<<sum[0]<<"  "<<sum[1]<<endl;
    return 0;

}

