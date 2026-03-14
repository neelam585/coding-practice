package LeatCode;

import java.util.Stack;

public class Asteroid1 {
    public static void main(String [] args){

        //int [] data = {5,2,-3};  // 5
       //int [] data = {3,5,-6,2,-1,4}; //2,6
        int [] data = {5,10,-5};//asteroids = [3,5,-6,2,-1,4], {5,10,-5}
        aestroid(data);  // o/p: 5 ,{2,6} , 5,10
    }

    public static void aestroid(int [] data){
        Stack<Integer> st = new Stack<>();
        boolean destroy = false;
        for(int a: data){
            while (!st.empty() && a<0 && st.peek()>0 ){ //while: The truck doesn’t stop after hitting the first car —
                //st.peek() > 0 → previous asteroid is moving RIGHT
                //a < 0 → current asteroid is moving LEFT
                if(Math.abs(a)>Math.abs(st.peek())){
                   st.pop();
                   continue;// So after popping: We immediately check again: while (!st.empty() && a < 0 && st.peek() > 0)
                }else if(Math.abs(a)==Math.abs(st.peek())){
                    st.pop();
                }else {

                }
                destroy = true; //This tells the outer loop: ❝Do NOT push current asteroid into stack❞
                break;//❝Exit the while loop completely❞ Because:Current asteroid is destroyed No need to check further collisions
            }
            if(!destroy) { //destroy == true → asteroid is gone, destroy == false → asteroid survives
                st.push(a);
            }
        }
        while (!st.empty()){
            System.out.println(st.pop());
        }
    }
}
