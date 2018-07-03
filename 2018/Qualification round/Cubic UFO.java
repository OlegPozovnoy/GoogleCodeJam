
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

    double target = nextDouble();
        double tmp;
        double angle1;
        double angle2;

        double vex1[] = {0.5,0,0};
        double vex2[] = {0,0.5,0};
        double vex3[] = {0,0,0.5};


    if (target <= Math.sqrt(2)){
        tmp =  Math.acos(target/Math.sqrt(2));
        angle1 = tmp - Math.PI/4;

        rotate(vex1,angle1);
        rotate(vex2,angle1);
        rotate(vex3,angle1);

        printlnCase();
        out.println(vex1[0] + " " + vex1[1] + " " + vex1[2] );
        out.println(vex2[0] + " " + vex2[1] + " " + vex2[2] );
        out.println(vex3[0] + " " + vex3[1] + " " + vex3[2] );
    }
    else{
        rotate(vex1,-Math.PI/4);
        rotate(vex2,-Math.PI/4);
        rotate(vex3,-Math.PI/4);

        tmp =  Math.acos(target/Math.sqrt(3));
        tmp = tmp - Math.acos(Math.sqrt(2)/Math.sqrt(3));

        swap(vex1,0,2);
        rotate(vex1,tmp);
        swap(vex1,0,2);

        swap(vex2,0,2);
        rotate(vex2,tmp);
        swap(vex2,0,2);

        swap(vex3,0,2);
        rotate(vex3,tmp);
        swap(vex3,0,2);

        printlnCase();
        out.println(vex1[0] + " " + vex1[1] + " " + vex1[2] );
        out.println(vex2[0] + " " + vex2[1] + " " + vex2[2] );
        out.println(vex3[0] + " " + vex3[1] + " " + vex3[2] );

    }


        return;
    }


    static void rotate(double[] cord, double angle)
    {

        int p1;
        int p2;
        double len= Math.sqrt(cord[0]* cord[0] + cord[1]*cord[1]);
        if (len < 0.00000000001)
            return;

        if (cord[0] < 0.00000000001)
        {
            cord[0] = Math.cos(Math.PI/2 * Math.signum(cord[1])+angle)*len;
            cord[1] = Math.sin(Math.PI/2 * Math.signum(cord[1])+angle)*len;
            return;

        }

        double initAngle = Math.atan(cord[1]/cord[0]);
        cord[0] = Math.cos(initAngle+angle)*len;
        cord[1] = Math.sin(initAngle+angle)*len;
        return;
    }

    static void swap(double[] cord, int i, int j)
    {
        double tmp = cord[i];
        cord[i] = cord[j];
        cord[j] = tmp;
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
