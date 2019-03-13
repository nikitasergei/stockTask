import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Invoice {
    private String sender;
    private Integer num;
    Set<Product> productSet;

    Invoice(String sender) {
        this.sender = sender;
        this.productSet = new HashSet<>();

    }

    void fillInvoice(Product product, int quantity) throws IndexOutOfBoundsException {
        if (quantity <= 0)
            throw new IndexOutOfBoundsException();
        else {
            product.setQuantity(quantity);
            if (!this.productSet.contains(product)) {
                this.productSet.add(product);
            } else {
                List list = this.productSet
                        .stream()
                        .filter(prod -> prod.equals(product))
                        .collect(Collectors.toList());
                Product prod = (Product) list.get(0);
                prod.setQuantity(product.getQuantity());
            }
        }
    }

    String getSender() {
        return this.sender;
    }
}
