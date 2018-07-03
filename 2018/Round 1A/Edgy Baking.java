
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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

    static int R;//row 100
    static int C;//column 100
    static int H;//horizontal
    static int V;//vertical


    static int[][] mass;


    static void solve() throws Exception {

        double n = nextInt();
        double p = nextDouble();

        double hor =0 ;
        double ver = 0;

        for (int i=0;i<n;i++)
        {
            hor = nextDouble();
            ver = nextDouble();
        }

        double minstep = 2*Math.min(hor,ver);
        double maxstep = 2*Math.sqrt(hor*hor + ver*ver);

        double result = 0;
        result += 2 * (hor + ver) * n;

        double residual = p-result;

        if (residual<minstep)
        {
            printCase();
            out.println(result);
            return;
        }

        if (residual>maxstep*n)
        {
            result += maxstep*n;
            printCase();
            out.println(result);
            return;
        }

        if (n==1)
        {
            printCase();
            out.println(p);
            return;

        }

        if (n==2)
        {
            if ((residual>minstep && residual<maxstep) ||(residual >2*minstep && residual<2*maxstep))
                {
                    printCase();
                    out.println(p);
                    return;
                }
                if ((residual > maxstep && residual< 2*minstep))
                {
                        result+=maxstep;
                        printCase();
                        out.println(result);
                        return;
                }
        }

        if (n>=3)
        {
            if ((residual>minstep && residual<maxstep) ||(residual >2*minstep && residual<2*maxstep) ||residual >3*minstep)
            {
                printCase();
                out.println(p);
                return;
            }
            if ((residual > maxstep && residual< 2*minstep))
            {
                result+=maxstep;
                printCase();
                out.println(result);
                return;
            }
            if ((residual > 2* maxstep && residual< 3*minstep))
            {
                result+=2*maxstep;
                printCase();
                out.println(result);
                return;
            }


        }


        printCase();
        out.println(result);
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
