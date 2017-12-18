//
// Created by will on 2017/12/18.
//


/*
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not. However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
    Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty), and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 */


/*
 *
 * 这道题本身并没有考察到什么，但是在考虑的时候要考虑周到，否则会有很多的坑要踩，
 * 估计这就是这道题的通过率比较低的原因吧
 * 因为我从通过率最低的开始刷，首先在开头和结尾加入0是为了考虑开头和结尾都是两个0的特殊情况，
 * 然后就是要考虑到在循环的过程中不要越界就可以了
 */

#include <iostream>
#include <vector>

using namespace std;
class Solution {
    public:
        bool canPlaceFlowers(vector<int>& flowerbed, int n) {
            flowerbed.insert(flowerbed.begin(),0);
            flowerbed.push_back(0);
            for(int i = 1; i < flowerbed.size()-1; ++i)
            {
                if(flowerbed[i-1] + flowerbed[i] + flowerbed[i+1] == 0)
                {
                    --n;
                    ++i;
                }
            }
            return n <=0;
        }
    };



int main(){


    vector<int> nums = {0,0,1,0,1,0,1};
    Solution s;
    cout<<"the number is :"<<s.canPlaceFlowers(nums,1);

    return 0;
}

