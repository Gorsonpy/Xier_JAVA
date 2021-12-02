import java.time.LocalDate;

public interface CatCafe {
    void buyCat(Cat aCat, int num);

    void entertainCustomer(Customer guest);

    void close(LocalDate time);
}
