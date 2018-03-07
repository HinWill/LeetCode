package array;

import java.util.List;

public class Subsets78 {


    public List<List<Integer>> subsets(int[] nums) {

        for (int i =1 ; i <= nums.length ; i++){

        }

        return null;
    }
    public static void main(String[] args) {

        List<List<Integer>> s = new Subsets78().subsets(new int[]{1,2,3});

        for (List<Integer> list : s) {
            for (Integer integer : list) {
                System.out.print(" " + integer);
            }
            System.out.println();
        }


    }
}
