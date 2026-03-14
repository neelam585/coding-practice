package LeatCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Asteroid {
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for (int a : asteroids) {
            boolean alive = true;
            while (!stack.isEmpty() && a < 0 && stack.peek() > 0) {
                int top = stack.peek();
                if (Math.abs(top) < Math.abs(a)) { //{3,5,-6,2,-1,4}
                    stack.pop(); // top explodes
                   // continue;
                } else if (Math.abs(top) == Math.abs(a)) {
                    stack.pop(); // both explode
                    /*alive = false;
                    break;*/
                } else {
                    alive = false; // current asteroid explodes
                    break;
                }
            }
            if (alive) {
                stack.push(a);
            }
        }
        // Convert stack to array (IMPORTANT)
        int[] result = new int[stack.size()];  //define array length
        for (int i = 0; i < stack.size(); i++) {
            result[i] = stack.get(i);
        }
        return result;
        //return stack.stream().mapToInt(i -> i).toArray();
    }
    public static void main(String[] args){
        int[] asteroids = {3,5,-6,2,-1,4}; // -6,2,4
        //int [] asteroids = {5,10,-5};  //  5,10
        //int [] asteroids = {5,2,-3};  // 5
        int[] result = asteroidCollision(asteroids);
        System.out.println("asteroid"+ Arrays.toString(result));
    }
}
//| Code                                       | What Java Prints |
//| ------------------------------------------ | ---------------- |
//| `System.out.println(arr)`                  | Memory address   |
//| `System.out.println(Arrays.toString(arr))` | Array contents   |

// Time complexity: O(n) , Linear Time, Each asteroid is pushed once,Each asteroid is popped at most once
//Space complexity: O(n), because of the stack

//Collision only happens when:
//(left(current) asteroid is negative) AND (top of stack is positive)
//Otherwise → no collision.
// {5,2,-3}  //-3 destroys 2, but fails on 5 // current is -3 for 2 and 5

//| Asteroid | Stack          | Explanation                 |
//| -------- | -------------- | --------------------------- |
//| 3        | [3]            | Push                        |
//| 5        | [3, 5]         | Push                        |
//| -6       | compare with 5 | collision (6 > 5) → 5 dies  |
//| -6       | compare with 3 | collision (6 > 3) → 3 dies  |
//| -6       | stack empty    | push -6                     |
//| 2        | [-6, 2]        | Push                        |
//| -1       | compare with 2 | collision (2 > 1) → -1 dies |
//| 4        | [-6, 2, 4]     | Push                        |