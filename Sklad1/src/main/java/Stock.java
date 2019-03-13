import java.util.*;

public class Stock implements SkladService {
    private String legalAddress;
    private Map<String, Integer> quantityProductsMap;
    private Map<String, Product> productsMap;
    private Set<String> sendersSet;


    Stock(String legalAddress) {
        this.legalAddress = legalAddress;
        this.quantityProductsMap = new HashMap<>();
        this.productsMap = new HashMap<>();
        this.sendersSet = new HashSet<>();
    }

    Invoice newInvoice(String sender) {
        Invoice newInvoice = new Invoice(sender);
        return newInvoice;
    }

    void addInvoiceToStock(Invoice invoice) {
        for (Product p : invoice.productSet) {
            String str = p.getProductName();
            Integer q = p.getQuantity();
            if (this.quantityProductsMap.get(str) == null)
                this.quantityProductsMap.put(str, q);
            else {
                Integer quant = this.quantityProductsMap.get(str);
                quant += q;
                this.quantityProductsMap.put(str, quant);
            }
            this.productsMap.put(str, p);
            String sender = invoice.getSender();
            if (sender.length()<5 || !sender.substring(0,5)
                    .equalsIgnoreCase("stock"))
                sendersSet.add(invoice.getSender());
        }
    }


    public Set<String> getAllProducts() {
        System.out.println("This products are available in stock: ");
        return quantityProductsMap.keySet();
    }

    public Product findProduct(String productName) {
        if (productsMap.containsKey(productName)) {
            System.out.println(productName + " is available in quantity " + quantityProductsMap.get(productName));
            return productsMap.get(productName);
        } else {
            System.out.println(productName + " is NOT available now, please ask later. Have a nice day!");
            return null;
        }
    }

    public Set<String> sendersList() {
        if (!this.sendersSet.isEmpty()){
        System.out.println("List of external senders:");
        return this.sendersSet;}
        else {
            System.out.println("List is empty");
            return null;
        }

    }
}
