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
import static java.util.Arrays.binarySearch;

import java.math.BigInteger;
import java.util.*;


public class Solution {

    static BufferedReader in;

    static PrintWriter out;
    static StringTokenizer tok;
    static int test;



    static void solve() throws Exception {

        int len = nextInt();
        int mass[] = new int[len];

        for (int i = 0 ; i<len;i++)
        {
            mass[i] = nextInt();
        }

        int mass1[] = new int[len-len/2];
        int mass2[] = new int[len/2];

        for (int i=0; i<len; i+=2)
            mass1[i/2]=mass[i];

        for (int i=1; i<len;i+=2)
            mass2[i/2] = mass[i];

        Arrays.sort(mass1);
        Arrays.sort(mass2);

        for(int i=0;i<mass2.length;i++)
        {
            if (mass1[i]>mass2[i])
            {
                printCase();
                out.println(2*i);
                return;
            }

            if (i+1<mass1.length && mass2[i]>mass1[i+1])
            {
                printCase();
                out.println(2*i+1);
                return;

            }

        }





        printCase();
        out.println("OK");
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
