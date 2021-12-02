import java.time.LocalDate;

public class Customer {
    private String name;
    private int ruaTimes;
    private LocalDate arriveTime = LocalDate.now();

    public Customer(String name, int ruaTimes) {
        this.name = name;
        this.ruaTimes = ruaTimes;
    }

    public Customer() {
        name = "";
        ruaTimes = 0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRuaTimes(int ruaTimes) {
        this.ruaTimes = ruaTimes;
    }

    public int getRuaTimes() {
        return ruaTimes;
    }

    public void setArriveTime(LocalDate arriveTime) {
        this.arriveTime = arriveTime;
    }

    public LocalDate getArriveTime() {
        return arriveTime;
    }

    @Override
    public String toString() {
        return " Customer " +
                " name:" + name +
                " ruaTimes:" + ruaTimes +
                " arriveTime:" + arriveTime;
    }
}

