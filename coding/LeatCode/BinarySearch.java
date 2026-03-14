package LeatCode;

public class BinarySearch {
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;  //0 ,6
        while (left <= right) {   // TC o(log n)
            int mid = left + (right - left) / 2;  // 0+(6-0)/2 = 3
            // If found
            if (nums[mid] == target) {
                return mid;
            }
            // Check if left side is sorted
            if (nums[left] <= nums[mid]) {  //{6,7,1,2,3,4,5};
                // Check if target lies in this left sorted part
                if (target >= nums[left] && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            // Otherwise right side is sorted
            else {
                if (target > nums[mid] && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1; // Not found
    }
    public static void main(String[] args) {
        int[] nums = {6,7,1,2,3,4,5};
        int target = 2;

        System.out.println(search(nums, target)); // Output: 3
    }
}
