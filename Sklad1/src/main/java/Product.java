import java.util.Objects;

public class Product {

    private String productName;
    private String unitOfMeasure;
    private int price;
    private int quantity;

    int getQuantity() {
        return this.quantity;
    }

    Product(String productName) {
        this.productName = productName;
        this.quantity = 0;

    }

    void setQuantity(int quantity) {
        this.quantity += quantity;
    }

    String getProductName() {
        return this.productName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(productName, product.productName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productName);
    }
}
