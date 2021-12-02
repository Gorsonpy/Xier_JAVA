
public abstract class Cat {
    protected String name;
    protected int age;
    protected String gender;
    protected double price;

    public Cat(String aName, int aAge, String aGender, double aPrice)//全参版本
    {
        name = aName;
        age = aAge;
        gender = aGender;
        price = aPrice;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public Cat()//无参数版本
    {

    }

    @Override
    public abstract String toString();
}
