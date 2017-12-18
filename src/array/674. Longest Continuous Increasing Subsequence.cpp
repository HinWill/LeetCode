//
// Created by will on 2017/12/16.
//





/*
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * 这道题没有什么难度的，但是关键的是记录最大值
 * 在最优解中用O(1)记录某个值然后随着滚动而重置
 *
 */
#include <iostream>
#include <vector>
using namespace std;


class Solution {
public:
    int findLengthOfLCIS(vector<int>& nums) {

        if (nums.size() == 0){
            return 0;
        }
        int k = 1;
        int flag = 1;
        for(int i = 0 ;i <nums.size()-1; i++){
            if(nums[i] < nums[i+1]){
                k++;
                flag = max(k, flag);
            }else{
                k = 1;
            }
        }
        return flag;

        /*
        optimal solution
        int findLengthOfLCIS(vector<int>& nums) {
            int res = 0, cnt = 0;
            for(int i = 0; i < nums.size(); i++){
                if(i == 0 || nums[i-1] < nums[i]) res = max(res, ++cnt);
                else cnt = 1;
            }
            return res;
        }
         */
    }
};

int main(){
    Solution s;
    vector<int> num = {1,3,5,4,7};
    int n = s.findLengthOfLCIS(num);
    cout<<n<<endl;

    return 0;
}
