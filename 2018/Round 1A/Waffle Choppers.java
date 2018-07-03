
//package com.google.jam;
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

        R = nextInt();
        C = nextInt();
        H = nextInt();
        V = nextInt();

        int[] hor = new int[H+2];
        int[] ver = new int[V+2];


        mass = new int [R][C];

        String c;
        int total=0;
        for (int i = 0; i <R; i++)
            {
                c= next();
                for (int j=0;j<C;j++)
                {

                    if (c.charAt(j) != '.')
                    {
                        mass[i][j] =1;
                        total++;
                    }
                }
            }

        if (total%((H+1)*(V+1)) !=0)
            {
                printCase();
                out.println("IMPOSSIBLE");
                return;
            }


            int counter =0;
            int exp = total/(H+1);

            if (total == 0)
            {
                printCase();
                out.println("POSSIBLE");
                return;
            }

            for (int i = 0; i <R; i++) {
                for (int j = 0; j < C; j++) {
                    counter += mass[i][j];
                }

                if (counter %  exp == 0)
                    hor[(int)(counter/exp)] = i+1;

            }

         counter =0;
         exp = total/(V+1);


        for (int j = 0; j <C; j++) {
            for (int i = 0; i < R; i++) {
                counter += mass[i][j];
            }

            if (counter %  exp == 0)
                ver[(int)(counter/exp)] = j+1;

        }

        hor[H+1] = R;
        hor[0] = 0;
        ver[V+1] = C;
        ver[0] = 0;

        for (int i =1 ;i<= H;i++)
        {
            if (hor[i] == 0)
            {
                printCase();
                out.println("IMPOSSIBLE");
                return;

            }

        }
        for (int i =1 ;i<= V;i++)
        {
            if (ver[i] == 0)
            {
                printCase();
                out.println("IMPOSSIBLE");
                return;

            }

        }

        exp = total/(V+1)/(H+1);

        for (int i = 0; i<H+1;i++)
            for (int j = 0; j<V+1;j++)
                {
                    counter = 0;

                    for (int i1 =hor[i]; i1<hor[i+1]; i1++ )
                        for (int j1 = ver[j]; j1 < ver[j + 1]; j1++)
                            counter += mass[i1][j1];



                        if (counter != exp) {
                            printCase();
                            out.println("IMPOSSIBLE");
                            return;
                        }

                }

        printCase();
        out.println("POSSIBLE");
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
