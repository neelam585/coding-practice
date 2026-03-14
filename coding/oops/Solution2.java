package oops;
import java.util.*;
import java.io.*;
public class Solution2 {
    public static void main(String[] args){

        Scanner scanner = new Scanner(System.in);

 // Read initial list size
 int n = scanner.nextInt();
 List<Integer> list = new ArrayList<>();

 // Read initial list elements
 for (int i = 0; i < n; i++) {
 list.add(scanner.nextInt());
 }

 // Read number of queries
 int q = scanner.nextInt();
 scanner.nextLine(); // Consume the newline

 // Process each query
 for (int i = 0; i < q; i++) {
 String command = scanner.nextLine();

 if (command.equals("Insert")) {
 String[] parts = scanner.nextLine().split(" ");
 int index = Integer.parseInt(parts[0]);
 int value = Integer.parseInt(parts[1]);
 list.add(index, value);
 } else if (command.equals("Delete")) {
 int index = Integer.parseInt(scanner.nextLine());
 list.remove(index);
 }
 }

 // Print final list on a single line
 for (int i = 0; i < list.size(); i++) {
 System.out.print(list.get(i));
 if (i < list.size() - 1) {
 System.out.print(" ");
 }
 }

 scanner.close();
 }

}

