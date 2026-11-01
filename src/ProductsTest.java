import org.example.Product;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import static org.junit.jupiter.api.Assertions.*;

public class ProductsTest {

    @Test
    public void testProduct() {
        Product p = new Product("iPhone", "Electronics", 40000);

        assertEquals("iPhone", p.getName());
        assertEquals(40000, p.getPrice());
    }

    @Test
    public void testGrouping() {
        List<Product> products = Arrays.asList(
                new Product("iPhone", "Electronics", 40000),
                new Product("Samsung", "Electronics", 30000),
                new Product("Laptop", "Computers", 50000)
        );

        Map<String, List<Product>> groups = products.stream()
                .collect(Collectors.groupingBy(p -> p.getCategory()));

        assertEquals(2, groups.size());
        assertEquals(2, groups.get("Electronics").size());
    }

    @Test
    public void testAverage() {
        List<Product> products = Arrays.asList(
                new Product("iPhone", "Electronics", 40000),
                new Product("Samsung", "Electronics", 30000)
        );

        double average = products.stream()
                .collect(Collectors.averagingDouble(p -> p.getPrice()));

        assertEquals(35000, average);
    }
}
