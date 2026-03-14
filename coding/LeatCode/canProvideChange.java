package LeatCode;

public class canProvideChange {
    public static boolean canProvideChange(int[] bills){
        int five = 0; int ten = 0;
        for (int bill: bills){
            if (bill == 5){
                five++;
            } else if (bill == 10) {
                if (five == 0){ return false; }
                else {
                    five--;
                    ten++;
                }
            } else if (bill == 20) {
                if (ten>0 && five > 0){
                    ten--;
                    five--;
                } else if (five > 3) {
                    five -=3;
                }else {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args){
        int[] bills1 = {5,5,5,10,20};
        int[] bills2 = {5,5,10,10,20};

        System.out.println(canProvideChange(bills1)); // true
        System.out.println(canProvideChange(bills2)); // false
    }
}
// | Metric               | Complexity |
//| -------------------- | ---------- |
//| **Time Complexity**  | `O(n)`     |
//| **Space Complexity** | `O(1)`     |
//| **Approach**         | Greedy     |
//| **In-place**         | Yes        |