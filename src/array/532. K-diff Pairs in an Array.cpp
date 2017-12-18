//
// Created by will on 2017/12/18.
//

#include <iostream>
#include <vector>
#include <unordered_map>
#include <map>
#include <unordered_set>
/*
 *
 * 这道题我最开始的思路是将有差值的一对数放入到哈希表中，然后讲以后有差值的数在哈希表中进行比对，是key和value都进行比对，但是有错误，我也不知道哪里错误了，代码贴了出来，有谁知道了可以告诉我一下。
   在最优解中，是将有差值的一对数将其中的较小值放入到哈希表中，这样就避免了重复的一对数的出现，不容易想到，但是也是时间复杂度最小的。
 *
 */
using namespace std;

class Solution{
    public:
        int findPairs(vector<int>& nums, int k){

            /*
            map<int,int> map;
            int number = 0;
            for (int i = 0; i < nums.size(); ++i) {
                for (int j = i+1; j < nums.size(); ++j) {
                    if (abs(nums[i] - nums[j]) == k){

                        cout<<"k = "<<k<<" i and j :"<<nums[i]<<" . "<<nums[j]<<endl;
                        if(judgment(map, nums[i], nums[j])){
                            map.insert(pair<int, int>(nums[i],nums[j]));
                            number++;
                        }
                    }
                }
            }
            return number;
             */


            if (k < 0) {
                return 0;
            }
            unordered_set<int> starters;
            unordered_map<int, int> indices;
            for (int i = 0; i < nums.size(); i++) {
                if (indices.count(nums[i] - k)) {
                    starters.insert(nums[i] - k);
                }
                if (indices.count(nums[i] + k)) {
                    starters.insert(nums[i]);
                }

                indices[nums[i]] += 1;
            }

            return starters.size();
        }

        bool judgment(map<int,int>& map, int i, int j){
            if(map.count(i) && map[i] == j){
                return false;
            }
            else if (map.count(j) && map[j] == i){
                return false;
            }else{
                cout<<"inputnumbers:"<<i<<" "<<j<<endl;
                return true;
            }

        }
};

int main(){

    vector<int> nums = {6,2,9,3,9,6,7,7,6,4};
    Solution s;

    int num = s.findPairs(nums, 3);
    cout<<"the num is :"<<num;
    return 0;
}