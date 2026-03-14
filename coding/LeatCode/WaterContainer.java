package LeatCode;

public class WaterContainer {
    public static int maxArea(int[] height){
        int left = 0; //1
        int right = height.length-1; //8,7
        int maxArea = 0; //8 , 49
        while (left<right) {
            int width = right - left;  //(8-0=8), (8-1=7)
            int h = Math.min(height[left], height[right]); //(1,7),(8,7)
            int area = width * h;  // 8*1= 8, 7*7,
            maxArea = Math.max(area, maxArea);
            if (height[left] < height[right]){ //(1<7) , (8<7)
                left++; //1
            }else {
                right--;
            }
        }return maxArea;
    }
    public static void main(String[] args){
        int[] height = {1,8,6,2,5,4,8,3,7}; //49
         int result = maxArea(height);
         System.out.println(result);
    }
}


//| Complexity Type  | Value    |
//| ---------------- | -------- |
//| Time Complexity  | **O(n)** |
//| Space Complexity | **O(1)** |

//Time Complexity
//Key observation
//
//You use two pointers: left and right
//
//In each loop iteration, only one pointer moves
//
//left++ or right--
//
//Each pointer moves at most n times

//Space Complexity
//Extra space used
//
//left, right, width, h, area, maxArea
//
//All are primitive variables
//
//No extra arrays or data structures