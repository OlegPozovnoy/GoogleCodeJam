
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import java.io.*;
import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

import java.util.*;


public class Solution {

    static BufferedReader in;
    static PrintWriter out;
    static StringTokenizer tok;
    static int test;

    static long R;
    static long B;
    static int C;
    static long[] M;
    static long[] S;
    static long[] P;

    static long[] Process;

    static void solve() throws Exception {

        R = nextInt();//Robots
        B = nextInt();//Bits

         C = nextInt();//Cashiers

        M = new long[C];//items
        S = new long[C];//seconds
        P = new long[C];//Packink


        for (int i = 0;i<C;i++)
        {
            M[i]= nextInt();
            S[i] = nextInt();
            P[i] = nextInt();

        }

        Process = new long[C];

        long min = 0;
        long max = Long.MAX_VALUE;

        while(max - min>1)
        {
            long current = (min+  max)/2;

            long total=0;

            for (int i=0;i<C;i++)
            {
                Process[i] = Math.min((current - P[i])/S[i],M[i]);
                if (Process[i]<0)
                    Process[i] = 0;
            }

            Arrays.sort(Process);

            for (int i =  (C-1); i>=C-R; i--)
            {
                total += Process[i];
            }

            if (total >= B)
            {
                max = current;

            }
            else
            {
                min = current;

            }


        }


        printCase();
        out.println(min+1);


        return;
    }



    static void printCase() {
        out.print("Case #" + test + ": ");
    }

    static void printlnCase() {
        out.println("Case #" + test + ":");
    }

    static int nextInt() throws IOException {
        return parseInt(next());
    }

    static long nextLong() throws IOException {
        return parseLong(next());
    }

    static double nextDouble() throws IOException {
        return parseDouble(next());
    }

    static String next() throws IOException {
        while (tok == null || !tok.hasMoreTokens()) {
            tok = new StringTokenizer(in.readLine());
        }
        return tok.nextToken();
    }

    public static void main(String[] args) {
        try {
            in = new BufferedReader(new InputStreamReader(System.in));
            out = new PrintWriter(new OutputStreamWriter(System.out));

            //in = new BufferedReader (new FileReader("C:\\GoogleCodeJam\\src\\test.txt"));
            int tests = nextInt();
            for (test = 1; test <= tests; test++) {
                solve();
            }
            in.close();
            out.close();
        } catch (Throwable e) {
            e.printStackTrace();
            exit(1);
        }
    }

}
