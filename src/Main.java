import java.util.*;
import java.io.*;

import static java.lang.Math.pow;

class Main{
    public static void main(String []argh){
        Scanner in = new Scanner(System.in);
        int t=in.nextInt();
        for(int i=0;i<t;i++){
            int a = in.nextInt();
            int b = in.nextInt();
            int n = in.nextInt();
            System.out.println(createSeq(a,b,n));
        }
        in.close();
    }

    public static String createSeq(int a, int b, int n){
        StringBuilder sb = new StringBuilder();
        int cum = a;
        for (int i=0; i<n; i++){
            cum = (int) (cum + pow(2,i)*b);
            sb.append(cum + " ");
        }
        return sb.toString();
    }

}