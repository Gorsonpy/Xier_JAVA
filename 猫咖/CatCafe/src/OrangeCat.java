public class OrangeCat extends Cat {
    private boolean isFat;

    public OrangeCat(String aName, int aAge, String aGender, boolean isFat) {
        name = aName;
        age = aAge;
        gender = aGender;
        price = 200;
        this.isFat = isFat;
    }

    public OrangeCat() {
        price = 200;
    }

    public void setFat(boolean fat) {
        isFat = fat;
    }

    public boolean isFat() {
        return isFat;
    }

    @Override
    public String toString() {
        return "品种：OrangeCat" +
                " name:" + name +
                " age:" + age +
                " gender:" + gender +
                " isFat:" + isFat +
                " price:" + price;
    }
}
