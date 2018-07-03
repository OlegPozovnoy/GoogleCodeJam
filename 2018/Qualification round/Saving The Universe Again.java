
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

        int damage = nextInt();
        String code =next();
        char[] charCode =  code.toCharArray();

        int shootNum=0;

        for (int i =0; i< code.length(); i++)
        {
            if (code.charAt(i)=='S')
                shootNum++;

        }

        if (damage<shootNum)
            {
                printCase();
                out.println("IMPOSSIBLE");
                return;
            }

            int swapNum = 0;
            int nextSwap=0;
        while ((nextSwap = getNextSwap(charCode))>0 && calcDamage(charCode)> damage)
        {
            charCode[nextSwap] = 'C';
            charCode[nextSwap-1] = 'S';
            swapNum++;
        }

        if(calcDamage(charCode)> damage)
        {
            printCase();
            out.println("IMPOSSIBLE");
            return;

        }


        printCase();
        out.println(swapNum);
        return;
    }



    static int getNextSwap(char[] s)
    {
        for (int i = s.length-1;i>=1;i--)
        {
            if (s[i] == 'S' && s[i-1]=='C')
                return i;
        }

        return 0;
    }

    static long calcDamage(char[] s)
    {
        long curDamage = 1;
        long totalDamage=0;
        for (int i = 0; i<s.length;i++ )
        {
            if (s[i]=='S')
                totalDamage+=curDamage;
            else
                curDamage*=2;
        }
        return totalDamage;
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
