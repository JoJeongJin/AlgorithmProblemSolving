package AlgorithmProblemSolving.Baekjoon;

import java.util.Arrays;
import java.util.Scanner;

public class _2036_수열의점수 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        long[] arr = new long[num];
        int plus = 0;
        int minus = 0;
        int zero = 0;
        long result = 0;

        for(int i=0; i<num; i++){
            arr[i] = sc.nextInt();
            if(arr[i] < 0){
                minus++;
            }else if(arr[i] > 0){
                plus++;
            }else{
                zero++;
            }
        }

        Arrays.sort(arr);

        //-밑바닥부터 0근접할때까지 쫙 더하기
        //만약 minus가 홀수인데 0이 있을경우 - 없애기
        if(minus%2 == 0){
            for(int i=0; i<minus; i+=2){
                result += arr[i]*arr[i+1];
            }
        }else{
            for(int i=0; i<minus-1; i+=2){
                result += arr[i]*arr[i+1];
            }
            if(zero==0){
                result+= arr[minus-1];
            }
        }

        //plus가 홀수개라면 처음건 그냥 더하고
        //뒤에나오는것들은 계속해서 곱해서 더하기
        if(plus%2 == 0){
            for(int i=minus+zero; i<num; i+=2){
                if(arr[i] == 1 || arr[i+1] == 1){
                    result+=1;
                }
                result += arr[i]*arr[i+1];
            }
        }else{
            result+= arr[minus+zero];
            for(int i=minus+zero+1; i<num; i+=2){
                if(arr[i] == 1 || arr[i+1] == 1){
                    result+=1;
                }
                result += arr[i]*arr[i+1];
            }
        }

        System.out.print(result);
    }
}
