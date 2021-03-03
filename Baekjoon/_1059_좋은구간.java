package AlgorithmProblemSolving.Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class _1059_좋은구간 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int number = scan.nextInt();
        int[] arr= new int[number+1];
        arr[0] = 0;

        for(int i=1; i<=number; i++){
            arr[i] = scan.nextInt();
        }
        Arrays.sort(arr);
        int compare = scan.nextInt();

        int result = 0;
        for(int i=0; i<number; i++){
            if(arr[i] < compare && arr[i+1] > compare){
                int prev = compare - arr[i] - 1;
                int next = arr[i+1] - compare -1 ;
                result += (prev*(next+1)) + next;
                break;
            }
        }

        System.out.println(result);
    }
}
