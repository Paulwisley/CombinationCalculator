import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Input {
    private ArrayList<String> str_list = new ArrayList<>(2);
    public BSet input(String filename) throws Exception {
        BSet set = new BSet();
        File file = new File(filename);
        //BufferedInputStream in = new BufferedInputStream(new FileInputStream(filename));
        BufferedReader br = new BufferedReader(new FileReader(file));
        String s = null;
        while((s = br.readLine()) != null){
            str_list.add(s);
        }
        br.close();

        //r值 去掉前后空格
        String strR = str_list.get(1).trim();
        set.setR(Integer.parseInt(strR));

        //获取array数组 按空格分割即可得到
        String strtmp[] = str_list.get(0).trim().split(" ");
        int len = strtmp.length;
        int array[] = new int[len];
        int i = 0;
        for(String ss : strtmp){
            array[i++] = Integer.parseInt(ss) + 1;
        }
        set.setB_array(array);
        set.setB_size(len);
        return set;
    }
}

