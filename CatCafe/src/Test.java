
import java.time.LocalDate;
import java.util.Scanner;

public class Test {
    Scanner in = new Scanner(System.in);
    static MyCatCafe myCatCafe = new MyCatCafe();
    String currType;

    public void testSet() {
        System.out.println("我们开了一家猫咖！");
    }

    public void testBalance() {
        boolean tag = true;
        double b;
        while (tag) {
            System.out.println("请指定余额");
            b = in.nextDouble();
            if (b < 0)
                System.out.println("金额不能为负数！请重新输入");
            else {
                myCatCafe.setBalance(b);
                System.out.println("你的店铺初始资金是：" + myCatCafe.getBalance());
                tag = false;
            }
        }
    }

    public String readType() {
        boolean tag = true;
        while (tag) {
            System.out.println("请输入猫的种类(OrangeCat or BlackCat)?");
            currType = in.next();
            if (!currType.equals("OrangeCat") && !currType.equals("BlackCat")) {
                System.out.println("种类输入错误！请重新输入");
            } else
                tag = false;
        }
        return currType;
    }

    public String readName() {
        System.out.println("请输入猫的名称(不带空格)");
        String currName = in.next();
        return currName;
    }

    public int readAge() {
        System.out.println("请输入猫的年龄");
        boolean tag = true;
        int currAge = 0;
        while (tag) {
            currAge = in.nextInt();
            if (currAge < 0) {
                System.out.println("年龄非法！请重新输入！");
            } else
                tag = false;

        }
        return currAge;
    }

    public String readGender() {
        boolean tag = true;
        String currGender = "";
        while (tag) {
            System.out.println("请输入猫的性别(只能输入公/母)");
            currGender = in.next();
            if (!currGender.equals("公") && !currGender.equals("母")) {
                System.out.println("性别输入错误，只能输入公/母！请重新输入！");
            } else
                tag = false;

        }
        return currGender;
    }

    public void readFat(OrangeCat o) {
        System.out.println("想要胖的吗(true or false)");
        boolean currFat = in.nextBoolean();
        o.setFat(currFat);
    }

    public void testBuy() {
        System.out.println("来买第一只猫吧！来输入它的信息");
        char c = 'y';
        while (c == 'y') {
            Cat currCat;
            int type = 1;
            if (readType().equals("OrangeCat")) {
                currCat = new OrangeCat();
            } else {
                currCat = new BlackCat();
                type = 0;
            }
            currCat.setName(readName());
            currCat.setAge(readAge());
            currCat.setGender(readGender());
            if (type == 1)
                readFat((OrangeCat) currCat);
            myCatCafe.buyCat(currCat, 1);
            System.out.println("还有要买的猫的信息吗？(y or n)");
            String d;
            d = in.next();
            c = d.charAt(0);
        }
    }

    public String readCustomerName() {
        System.out.println("请输入顾客的名字！(不带空格)");
        String s;
        s = in.next();
        return s;
    }

    public int readRuaTimes() {
        System.out.println("请输入该顾客的rua猫次数");
        int t = 0;
        boolean tag = true;
        while (tag) {
            t = in.nextInt();
            if (t < 0)
                System.out.println("rua猫次数非法！请重新输入！");
            else
                tag = false;
        }
        return t;
    }

    public void testEntertain() {
        System.out.println("现在第一个客人来了！");
        char c = 'y';
        while (c == 'y') {
            Customer currCustomer = new Customer();
            currCustomer.setName(readCustomerName());
            currCustomer.setRuaTimes(readRuaTimes());
            System.out.println("这位顾客的信息是：" + currCustomer);
            myCatCafe.tryEntertainCustomer(currCustomer);
            System.out.println("请问还有客人来吗（y or n)?");
            String d = in.next();
            c = d.charAt(0);
        }
    }

    public void testClose() {
        LocalDate closeTime = LocalDate.now();
        myCatCafe.close(closeTime);
    }

    public static void main(String[] args) {
        Test test = new Test();
        test.testSet();
        test.testBalance();
        test.testBuy();
        test.testEntertain();
        test.testClose();
    }
}

