import java.util.Scanner;

public class CheckEmail {
    static boolean check(String s) {
        //final String regex = "[\\w]@+[\\w]\\.com\n";
        final String regex="[\\w\\.]+@[\\w]+(\\.(com))";
        return s.matches(regex);
    }
    public static void main(String[] args){
        Scanner in =new Scanner(System.in);
        System.out.println("请输入要检查的字符串");
        String toCheck = in.nextLine();
        if(check(toCheck))
            System.out.println("邮箱格式合法");
        else
            System.out.println("邮箱格式非法");
    }
}
