import java.io.*;
import java.util.Scanner;

public class FFirst {
    public static void main(String[] args)throws IOException {
        int num, i;
        Scanner sc = new Scanner(System.in);
        num = sc.nextInt();  //num 生成题目数目
        String[] charArr = new String[num];    //存入题目
        int test = 0;  //用于题目前序号排序

        FileWriter Fw1 = new FileWriter(".\\Exercise111.txt");
        FileWriter Fw2 = new FileWriter(".\\Answers111.txt");
        BufferedWriter bf1 = new BufferedWriter(Fw1);
        BufferedWriter bf2 = new BufferedWriter(Fw2);

        for (i = 0; i < num; ++i) {
            int m = (int) (Math.random() * 100);
            int n = (int) (Math.random() * 100);
            int k = (int) (Math.random() * 100);    //三个100内的数字

            int[] op1 = new int[num];   //存入符号对应数
            int[] op2 = new int[num];
            op1[i] = (int) (Math.random()*10%2);  //取0或1，对应+，-
            op2[i] = (int) (Math.random()*10%2);

            charArr[i] = m + getOp(op1[i]) + n + getOp(op2[i]) + k; //拼接题目

            test = i+1;  //题目序号
            bf1.write(test + ". " + charArr[i]);   //写入
            bf1.newLine();
            bf1.flush();

            //存答案
            int[] answer = new int[num];
            answer[i] = getReal(op1[i], op2[i], m, n, k);  //调用计算函数
            bf2.write(String.valueOf(answer[i]));
            bf2.newLine();
            bf2.flush();
        }
    }


    //取符号，0对应+，1对应-，index随机数
    private static String getOp (int index){
        String str = " ";
        switch (index) {
            case 0:
                str = "+";
                break;
            case 1:
                str = "-";
        }
        return str;
    }

    //计算函数
    private static int getReal(int index1 , int index2 , int m , int n , int k){
        int answer1 = 0;
        int answer2 = 0;
        switch (index1){
            case 0:
                answer1 = m + n;
                break;
            case 1:
                answer1 = m - n;
                break;
        }
        switch (index2){
            case 0:
                answer2 = answer1 + k;
                break;
            case 1:
                answer2 = answer1 - k;
                break;
        }
        return answer2;
    }
}