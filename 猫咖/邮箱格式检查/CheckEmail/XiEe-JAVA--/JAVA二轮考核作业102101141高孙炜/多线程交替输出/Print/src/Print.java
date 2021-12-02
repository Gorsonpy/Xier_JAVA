import java.util.Scanner;
import java.util.concurrent.locks.LockSupport;

//本题实现方法采用LockSupport类
public class Print {
    static Thread x1 = null;
    static Thread x2 = null;

    public void PairPrint(int[] n1, int[] n2) {
        x1 = new Thread(() -> {
            for (int i : n1) {
                System.out.print(i + " ");
                LockSupport.unpark(x2);
                LockSupport.park();
            }
        });
        x2 = new Thread(() -> {
            for (int j : n2) {
                LockSupport.park();
                System.out.print(j + " ");
                LockSupport.unpark(x1);
            }
        });
        x1.start();
        x2.start();
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入数组的元素个数");
        int size = in.nextInt();
        int[] a1 = new int[size];
        int[] a2=new int [size];
        System.out.println("请输入第一个数组的元素");
        for (int i = 0; i < size; ++i)
            a1[i] = in.nextInt();
        System.out.println("请输入第二个数组的元素");
        for (int i = 0; i < size; ++i)
            a2[i] = in.nextInt();
        Print p1 = new Print();
        p1.PairPrint(a1, a2);
    }
}
