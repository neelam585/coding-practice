package LeatCode;

public class MissingNumber {
    //1. sum of numbers in array. Array length = 6 → numbers should be from 0 to 6., n*(n+1)/2 => 21
    //2. Actual sum of array = 0+1+2+4+5+6 = 18.
    //3. Missing number is the difference
    public static int findMissingNum(int[] nums){
        int n = nums.length;
        int expectedSum = n*(n+1)/2;
        int actualSum = 0;

       for(int num:nums){
            actualSum = actualSum+num;
        }
       /* for (int i=0; i<nums.length; i++){
            actualSum = actualSum+nums[i];
        }*/
        return expectedSum-actualSum;

    }

    public static void main(String[] args){
        //Input: nums = [0, 1, 2, 4, 5, 6], find missing number.
        //Output: 3
        int[] nums = {0, 1, 2, 4, 5, 6};
        int result = findMissingNum(nums);
        System.out.println(result);

    }
}
