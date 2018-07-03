import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Solution {
	
	static BufferedReader in;
	static PrintWriter out;
	static StringTokenizer tok;
	static int test;
	
	static void solve() throws Exception {



		int  n= nextInt();
        long[] a = new long [n];
        

        int sum = 0;
        long max = 0;
        int curLen = 0;
        String ou="";

        for (int i=0; i<n;i++)
		{
            a[i] = nextLong();     
            sum+=a[i];
        } 
        


        while (sum > 0)
        {
            max = 0;   
            int maxnum=0;
            
            for (int i=0; i<n;i++)
            {
                if (max<a[i])
                    max = a[i];
            }

            for (int i=0; i<n;i++)
            {
                if (max==a[i])
                    maxnum++;
            }

            if (sum==3 || sum==1)
            {

                for (int i=0; i<n;i++)
                {
                    if (max==a[i])
                        {
                        ou+=convChar(i) + " ";
                        a[i]--;
                        break;
                        }
                }

                sum--;
            }

            else 
            {
                if (maxnum==1)
                {
                    for (int i=0; i<n;i++)
                    {
                        if (max==a[i])
                            {
                            ou+=convChar(i)+convChar(i) + " ";
                            a[i]-=2;
                            }
                    }                    
                }
                else
                {
                    int j = 2;
                    int i = 0;
                    while (j>0)
                    {
                        if (a[i]==max)
                            {
                                j--;
                                ou+=convChar(i);
                                a[i]--;
                            }
                        i++;

                    }
                    ou+=" ";

                }
                sum-=2;
            }

        }
        printCase();
        out.println( ou.trim());

	}
    
    static String convChar(int n)
    {
        char t =  (char)(n+ 'A');
        return Character.toString(t);    

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