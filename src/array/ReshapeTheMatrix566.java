package array;


/**
 * 这道题让我们实现矩阵大小的重塑，也就是实现Matlab中的reshape函数，
 * 在看大叔，对这个函数还是比较的熟悉的。对于这种二维数组大小重新非配的问题的关键就是对应位置的坐标转换，
 * 最直接的办法就是先把原数组拉直，变成一条直线，然后再组成新的数组。所以这道题我们先判断给定数组是否能重塑成给定的大小，
 * 就是看两者的元素总数是否相同，直接行数乘以列数即可，然后我们新建一个目标大小的数组，并开始遍历，对于每个位置，
 * 我们先转为拉直后的一维坐标，然后在算出在原数组中的对应位置赋值过来即可
 */

public class ReshapeTheMatrix566 {

        public int[][] matrixReshape(int[][] nums, int r, int c) {

            int n = nums.length,m = nums[0].length;
            if(n*m != r*c){
                return nums;
            }

            int[][] newnum = new int[r][c];
            int l=0,k=0;
            for(int i=0; i<n; i++){
                for (int j=0; j<m; j++){
                    newnum[l][k] = nums[i][j];
                    k++;
                    if (k == c){
                        k = 0;
                        l++;
                    }
                }
            }

            return newnum;

//My Personal Idea
            /*
            if (r==0 || c==0){
                return nums;
            }
            int[] s = new int[r*c];
            int m = 0;
            for (int[] num : nums) {
                for (int i : num) {
                    s[m] = i;
                    m++;
                }
            }
            if(m == r*c){
                int[][] newnum = new int[r][c];
                int n = 0;
                for (int i =0; i<r;i++){
                    for(int j=0;j<c;j++){
                        newnum[i][j] = s[n];
                        n++;
                    }
                }
                return newnum;
            }else {
                return nums;
            }
            */




        }

    public static void main(String[] args) {
        int[][] nums = {{1,2,3},{4,5,6}};

        int[][] nu = new ReshapeTheMatrix566().matrixReshape(nums,3,2);

        for (int[] ints : nu) {
            for (int anInt : ints) {
                System.out.print(anInt+" ");
            }
            System.out.println();
        }
    }
}
