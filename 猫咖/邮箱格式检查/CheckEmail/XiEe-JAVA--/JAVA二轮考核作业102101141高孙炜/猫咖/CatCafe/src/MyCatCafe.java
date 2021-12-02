
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Random;

public class MyCatCafe implements CatCafe {
    private double balance;
    private ArrayList<Cat> catList = new ArrayList<Cat>();
    private ArrayList<Customer> customerList = new ArrayList<Customer>();
    private int times = 0;//店里一天被rua猫的次数

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public ArrayList<Cat> getCatList() {
        return catList;
    }

    public void setCatList(ArrayList<Cat> catList) {
        this.catList = catList;
    }

    public void setCustomerList(ArrayList<Customer> customerList) {
        this.customerList = customerList;
    }

    public ArrayList<Customer> getCustomerList() {
        return customerList;
    }


    public void tryBuy(Cat aCat, int num) throws InsufficientBalanceException {
        for (int i = 0; i < num; ++i) {
            if (aCat.price > this.balance)
                throw new InsufficientBalanceException("余额不足！");
            catList.add(aCat);
            System.out.println("店里新买入一只猫！");
            System.out.println(aCat);
            this.balance = this.balance - aCat.price;
            System.out.println("当前店里余额为" + balance);
        }
    }

    @Override
    public void buyCat(Cat aCat, int num) {
        try {
            tryBuy(aCat, num);
        } catch (InsufficientBalanceException ib) {
            ib.printStackTrace();
        }
    }

    public void tryEntertainCustomer(Customer guest) throws CatNotFoundException {
        System.out.println("招待顾客，欢迎光临！");
        customerList.add(guest);
        System.out.println("您是店里的第" + (customerList.indexOf(guest) + 1) + "个客人！");
        if (catList.isEmpty())
            throw new CatNotFoundException("店里没有猫！");
        System.out.println("店里现在有" + catList.size() + "只猫");
        Random random = new Random();
        for (int i = 0; i < guest.getRuaTimes(); ++i) {
            System.out.println("rua猫，一次15！");
            System.out.println("正在随机挑选一只好rua的猫");
            int r = random.nextInt(catList.size()); //获得随机下标
            Cat ruaCat = catList.get(r);
            r++;
            System.out.println("用户rua的是" + r + "号猫咪");
            System.out.println(ruaCat);
            balance = balance + 15;
            ++times;
            System.out.println("现在店铺余额变成了" + balance + "元");
        }
        System.out.println("Rua猫完毕，谢谢惠顾！");
    }

    @Override
    public void entertainCustomer(Customer guest) {
        try {
            tryEntertainCustomer(guest);
        } catch (CatNotFoundException nf) {
            nf.printStackTrace();
        }

    }

    @Override
    public void close(LocalDate time) {
        System.out.println("现在要关店了......");
        System.out.println("日期:" + time + " 今天的客人有：");
        for (Customer c : customerList) {
            if (c.getArriveTime().equals(time))
                System.out.println(c);
        }
        System.out.println("今天的利润为：" + times * 15 + "元");
    }
}
