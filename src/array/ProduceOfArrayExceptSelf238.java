package array;

public class ProduceOfArrayExceptSelf238 {

    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];

        output[0] = 1;

        for (int i = 1; i < output.length; i++) {
            output[i] = output[i-1] * nums[i-1];
        }

        /*
        int n = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= n;
            n *= nums[i];
        }
        */
        //这里还可以省去一个变量，直接使用output[0] 来进行存储每次计算的结果值
        for (int i = nums.length - 1; i > 0; i--) {
            output[i] *= output[0];
            output[0] *= nums[i];
        }

        return output;
    }
    public static void main(String[] args) {
        int[] output = new ProduceOfArrayExceptSelf238().productExceptSelf(new int[]{2, 3, 4});
        for (int i : output) {
            System.out.println("i = " + i);
        }
    }
}
