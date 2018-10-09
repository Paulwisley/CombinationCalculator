import java.io.*;
import java.lang.instrument.ClassDefinition;

public class Main {
    private static BSet set;
    private static Input in;
    private static Combination combination;

    public static void main(String[] args) throws Exception {
        init();
        set = in.input("./IO/input.txt");
        int n , r;
        int array[] = new int[set.getB_size()];
        n = set.getB_size();
        r = set.getR();
        array = set.getB_array();
        long ans;
        ans = combination.combinationcount(n,r,array);

        System.out.println();
        System.out.println("***欢迎使用重集组合计数程序***");
        System.out.println();
        System.out.print("重集B系数为：");
        for(int item:array){
            System.out.print(item-1 + " ");
        }
        System.out.println();
        System.out.println("r-组合系数为： "+ r);
        System.out.println("==> 重集B的"+r+"组合数为：" + ans);

    }

    private static void init(){
        set = new BSet();
        in= new Input();
        combination = new Combination();
    }
}
