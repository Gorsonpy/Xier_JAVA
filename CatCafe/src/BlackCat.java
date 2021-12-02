public class BlackCat extends Cat {
    public BlackCat(String aName, int aAge, String aGender) {
        name = aName;
        age = aAge;
        gender = aGender;
        price = 350;
    }

    public BlackCat() {
        price = 350;
    }

    @Override
    public String toString() {
        return "品种：BlackCat" +
                " name:" + name +
                " age:" + age +
                " gender:" + gender +
                " price:" + price;
    }
}