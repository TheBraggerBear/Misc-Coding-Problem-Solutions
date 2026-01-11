// NOT FINISHED


import java.util.Scanner;
public class fluortanten {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int hold = s.nextInt();
        int[] kids = new int[hold];
        for (int i = 0; i < hold; i++) {
            kids[i] = Integer.valueOf(s.next());
        }
        int highestHappiness = calculateHappiness(kids);
        for (int i = 0; i < kids.length; i++) {
            kids = replaceZero(kids, i);
            hold = calculateHappiness(kids);
            if (hold > highestHappiness) {
                highestHappiness = hold;
            }
        }
        System.out.println(highestHappiness);
    }
    public static int calculateHappiness(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] * (i+1);
        }
        return sum;
    }
    public static int[] replaceZero(int[] arr, int index) {
        int arrIndex = 0;
        int[] arr2 = new int[arr.length];
        int arr2Index = 0;
        for (int i = 0; i < arr.length+1; i++) {
            if  (arr2Index == index) {
                arr2[arr2Index] = 0;
                arr2Index++;
                continue;
            } else if (arr[arrIndex] != 0) {
                arr2[arr2Index] = arr[arrIndex];
                arr2Index++;
                arrIndex++;
                continue;
            }
            
            arrIndex++;

        }
        return arr2;
    }
}