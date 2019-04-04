import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
 
class PP{
    int R, C;
     
    PP(int R, int C){
        this.R=R;
        this.C=C;
    }
}
class SS{
    int R, C, K;
     
    SS(int R, int C, int K){
        this.R=R;
        this.C=C;
        this.K=K;
    }
}
 
public class Solution2 {
 
     
    static BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static int T, N;
    static int[][] S;
    static List<PP> list_p;
    static List<SS> list_s;
    static List<List> people=new ArrayList<List>();
    static List<List> entran=new ArrayList<List>();
    static int[] MIN;
     
    public static void main(String[] ar) throws IOException {
        Solution lunch=new Solution();
        lunch.run();
     
        bw.flush();
        bw.close();
        br.close();
    }
     
    public static void run() throws IOException {
         
        StringTokenizer st=new StringTokenizer(br.readLine());
        T=Integer.parseInt(st.nextToken());
        MIN=new int[T];
        for(int i=0;i<T;i++) {
            st=new StringTokenizer(br.readLine());
            N=Integer.parseInt(st.nextToken());
             
            list_p=new ArrayList<PP>();
            list_s=new ArrayList<SS>();
             
            for(int j=0;j<N;j++) {
                st=new StringTokenizer(br.readLine()," ");
                for(int k=0;k<N;k++) {
                    int temp=Integer.parseInt(st.nextToken());
                    if(temp==1) list_p.add(new PP(j,k));
                    else if(temp!=0) list_s.add(new SS(j,k,temp));
                }
            }
             
            people.add(list_p);
            entran.add(list_s);
             
        }
         
        Arrays.fill(MIN, Integer.MAX_VALUE);
         
        for(int i=0;i<T;i++) bitmask(i);
         
        for(int i=0;i<T;i++) bw.write("#"+(i+1)+" "+MIN[i]+"\n");
        bw.flush();
    }
     
    public static void bitmask(int num) {
         System.out.println(num);
        List<PP> p=people.get(num);
         
        for(int i=0;i<(1<<p.size());i++) {
         
            List<PP> s1=new ArrayList<PP>();
            List<PP> s2=new ArrayList<PP>();
             
            for(int j=0;j<p.size();j++) 
                if((i & (1<<j))>0) s1.add(p.get(j));
                else s2.add(p.get(j));
             
            cal(s1,s2,num);
        }
         
         
    }
     
    public static void cal(List<PP> s1, List<PP> s2, int num) {
        List<SS> s=entran.get(num);
         
        //s1
        int k=s.get(0).K+1, sr=s.get(0).R, sc=s.get(0).C;
        int time1=0;
         
        int[] temp=new int[s1.size()+1];    temp[0]=0;
        for(int i=1;i<s1.size()+1;i++) 
            temp[i]=Math.abs(sr-s1.get(i-1).R)+Math.abs(sc-s1.get(i-1).C);
         
        Arrays.sort(temp);
 
        int n=(s1.size()/3);    int r=(s1.size()%3);    int cnt=0;
         
        if(n==0&r==0) time1=0;
        else if(n==0) time1=temp[r]+k;
        else if(r==0) {
            time1+=temp[3]+k; cnt++;
            while(cnt<n) {
                if(time1>temp[(cnt+1)*3])    time1+=k-1;
                else time1+=temp[(cnt+1)*3]-temp[cnt*3];
             
                cnt++;
            }
        }
        else {
            time1+=(temp[r]+k);
            do {
             
                if(time1>temp[(cnt+1)*3+r])  time1+=k-1;
                else time1+=temp[(cnt+1)*3+r]-temp[cnt*3+r];
             
                cnt++;
            }while(cnt<n);
        }
         
        //s2
        k=s.get(1).K+1; sr=s.get(1).R; sc=s.get(1).C;
        int time2=0;
 
        temp=new int[s2.size()+1];  temp[0]=0;
        for(int i=1;i<s2.size()+1;i++) 
            temp[i]=Math.abs(sr-s2.get(i-1).R)+Math.abs(sc-s2.get(i-1).C);
         
        Arrays.sort(temp);
         
        n=(s2.size()/3);    r=(s2.size()%3);    cnt=0;
         
        if(n==0 & r==0) time2=0;
        else if(n==0) time2=temp[r]+k;
        else if(r==0) {
            time2+=temp[3]+k; cnt++;
            while(cnt<n) {
                if(time2>temp[(cnt+1)*3])    time2+=k-1;
                else time2+=temp[(cnt+1)*3]-temp[cnt*3];
             
                cnt++;
            }
        }
        else {
            time2+=(temp[r]+k);
            do {
             
                if(time2>temp[(cnt+1)*3+r])  time2+=k-1;
                else time2+=temp[(cnt+1)*3+r]-temp[cnt*3+r];
             
                cnt++;
            }while(cnt<n);
        }
         
         
        int ftime=Math.max(time1,time2);
        MIN[num]=Math.min(MIN[num], ftime); 
         
         
         
    }
}