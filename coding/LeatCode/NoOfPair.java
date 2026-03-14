package LeatCode;

public class NoOfPair {
    public static long findNoOfPairs(int[] arr,int l, int r){
        int sum = 0;
        long count=0;

        for(int i=0; i<arr.length; i++){
            for(int j =i+1; j<arr.length; j++){
                sum = arr[i]+arr[j];
                if(sum <= r && sum >= l){
                    count++;
                }
            }
        }
        return count;
    }
    public static void main(String[] args){
        int[] arr = {2,1, 3, 6, 7};
        int n = 4; // Not strictly needed as arr.length can be used
        int l = 4; // Assuming the user meant between 4 and l=7
        int r = 7; // Assuming the user meant between 4 and l=7

        //int count = 0;
        long result = findNoOfPairs(arr,l, r);
        System.out.println(result);
    }
}
