import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.exit;
import static java.lang.Math.min;
import static java.lang.Math.max;

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


        double totaldist =nextDouble();
        int horses = nextInt()+1;

        double[] dist = new double[horses];
        long[] speed = new long[horses];

        int min;

        for (int i = 0;i< horses-1; i++)
        {
            dist[i] = nextDouble();
            speed[i] = nextLong();
        }

        dist[horses-1] = totaldist;
        speed[horses-1] = 0;

        double time=0;

        double currentdist=totaldist;
        long currentspeed=0;

        for(int i=0;i<horses;i++)
        {
            if ((long)currentdist >= (long)dist[i])
            {
                if ((long)currentdist> (long)dist[i])
                {
                    currentdist=dist[i];
                    currentspeed = speed[i];

                }
                else
                {
                    currentspeed = Math.min(currentspeed,speed[i]);
                }
            }
        }

        for (int i=0;i<horses+1;i++)
        {
            if (currentspeed==0)
                break;

            double mintime = (totaldist - currentdist)/currentspeed;
            int minindex = horses-1;
            
            
            
            for (int j = 0; j< horses; j++)
            {
                if (speed[j]>= currentspeed)
                {
                    dist[j]=totaldist;
                    speed[j]=0;
                }

            }

            for (int j = 0; j< horses; j++)
            {
                if ((dist[j]-currentdist)/(currentspeed - speed[j])< mintime)
                {
                    minindex = j;
                    mintime = (dist[j]-currentdist)/(currentspeed - speed[j]);
                }
            }           

            currentdist+=mintime*currentspeed;
            time+= mintime;

            currentspeed = speed[minindex];


            for (int j = 0; j< horses; j++)
            {
                if(speed[j]!=0)
                {
                    if((totaldist - dist[j])/speed[j] < mintime)
                    {
                        dist[j]=totaldist;
                        speed[j] =0;
                    }
                    else
                    {
                        dist[j]+= mintime*speed[j];
                    }
                }
            }      

        }

        
 
        printCase();
        out.println((double)(totaldist/time));

	}
    
    static String convChar(int n)
    {
        char t =  (char)(n+ 'A'-1);
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