
import java.util.ArrayList;
import java.util.List;

public class Combination {

     ArrayList<Integer> list = new ArrayList<Integer>();//暂存深搜得到的组合数
    //结合容斥原理计算
    public long combinationcount(int n, int r, int a[]){
        long ans = combination(n,r);
        int start = 0;

        for(int i = 1; i <= n; i++){
            boolean vis[] = new boolean[n];
            ArrayList<Integer> tmp = new ArrayList<>();
            dfs(0, n, tmp, i ,a, vis);
            for(int j = start; j < list.size(); j++){
                int m = (i%2) == 0 ? 1 : -1;
                ans += m * combination(n,r-list.get(j));
            }
            start = list.size();
        }
        return ans;
    }

    //F(n,r) count the combination
    private long combination(int n, int r) {
        if(r < 0) return 0;
        long  ans = 1;
        int tmp = n + r -1;
        for(int i = tmp - r + 1; i <= tmp; i++) ans *= i;
        for(int j = 1; j <= r; j++) ans /= j;
        System.out.println("");
        return ans;
    }

    private void dfs (int dep,int n, ArrayList<Integer> cur ,int count,int a[],boolean vis[])//dep代表搜索的深度，即当前数组a添加了多少个数
    {
        if (count == cur.size() && cur.size() > 0)//如果添加的数字达到count个，把他们输出
        {
            int sum = 0;
            for (int j = 0; j < cur.size(); ++j)
            {
                sum += a[cur.get(j)];
            }
            list.add(sum);
            return;
        }
        for (int i = dep; i < n; ++i)//从上一个添加的数+1开始搜索数字
        {
            if (vis[i] == false)//如果这个数字没被访问过
            {
                vis[i] = true;
                cur.add(i);
                dfs(i+1,n,cur,count,a,vis);//如果达不到r个继续添加
                vis[i]=false;//回溯，清空当前状态，把vis[i]设为没有访问过。
                cur.remove(cur.size()-1);
            }
        }
    }

}