import java.util.Set;

public interface SkladService {
    /**
     * @return set of all products on this sklad;
     */
    Set<String> getAllProducts();

    /**
     * @param productName - name of product to find;
     * @return product, if @product is found, and otherwise @return null
     */
    Product findProduct(String productName);

    /**
     * print list of external senders;
     */
    Set<String> sendersList();

}
