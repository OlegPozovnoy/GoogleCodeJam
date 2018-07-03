

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
    static int[][] mass;
    static int[] nextMove;
    static int n;
    static int m;


    static void solve() throws Exception {

        nextMove = new int[2];

        int A = nextInt();

        n = (int)Math.floor(Math.sqrt(A));
        m = (int)Math.ceil(A/n);

        System.out.println("2 2");

        int shift1, shift2;

        shift1=nextInt();
        shift2=nextInt();

        if (shift1==0 && shift2==0) {
            return;
        }

        mass = new int[n][m];

        for (int i=1;i<n-1;i++)
            for(int j=1;j<m-1;j++)
                for(int k=-1;k<=1;k++)
                    for(int l=-1;l<=1;l++)
                        mass[i+k][j+l]-=1;

        for (int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                mass[i][j] = -36/mass[i][j];

        mass[0][0]=0;

        int x,y;

        do{
            getNextMove();
            System.out.println( (shift1+nextMove[0]) + " " + (shift2+nextMove[1]));

            x=nextInt();
            y=nextInt();

            if ((x==0 && y==0) )
                return;
            if ((x==-1 &&y==-1))
                exit(0);

            mass[x-shift1][y-shift2]=0;

        } while (!((x==0 && y==0) || (x==-1 &&y==-1)));

        return;
    }

    static void getNextMove()
    {
        int total = 0;
        int current;
        for (int i=1;i<n-1;i++)
            for(int j=1;j<m-1;j++) {
                current = mass[i-1][j-1] + mass[i-1][j] + mass[i][j-1] + mass[i][j] + mass[i+1][j-1] + mass[i-1][j+1] + mass[i+1][j] + mass[i][j+1] + mass[i+1][j+1];
                if (current>total)
                {
                    nextMove[0]=i;
                    nextMove[1]=j;
                }
            }
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
