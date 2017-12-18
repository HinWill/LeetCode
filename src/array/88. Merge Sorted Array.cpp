//
// Created by will on 2017/12/14.
//

/*
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

  这道题其实不难，主要考察的就是对一道题的逆向思维，比如从前往后比较，这道题也能做出来，
  但是比较耗时间，对于一些题，
  如果正向的去考虑比较困难的时候，不妨试试逆向的思考，就像数学中的反证法一样。
  还有对n,m特殊值的考虑
 * /


#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    void merge(vector<int>& nums1, int m, vector<int>& nums2, int n) {
        if (n == 0)
            return;
        if (m == 0 && n != 0){
            for (int i = 0; i < n; ++i) {
                nums1[i] == nums2[i];
            }
        }


        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(i>=0 && j>=0){
            if (nums1[i] > nums2[j]){
                nums1[k] = nums1[i];
                i--;
            }else{
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        
        while (i>=0){
            nums1[k] = nums1[i];
            k--;
            i--;
        }

        while (j>=0){
            nums1[k] = nums2[j];
            k--;
            j--;
        }

    }
};

int main(){
    Solution e;

    vector<int> num1 = {1,2,3,4,5,6,7};
    vector<int> num2 = {4,5,6,7,8,9};
    e.merge(num1,7,num2,6);
    return 0;
}

