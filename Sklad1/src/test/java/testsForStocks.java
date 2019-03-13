import org.junit.Assert;
import org.junit.Test;

import java.util.Set;

public class testsForStocks {


    Product product1 = new Product("Milk");
    Product product2 = new Product("Bread");
    Product product3 = new Product("Apple");
    Product product4 = new Product("Butter");
    Product product5 = new Product("Pineapple");
    Product product6 = new Product("Meat");
    Product product7 = new Product("SourCream");

    @Test
    public void testForGetAllProductsPositive() {

        Stock stock = new Stock("Stock on Gorkogo");
        Invoice invoice1 = stock.newInvoice("EuroOpt");
        Invoice invoice2 = stock.newInvoice("Almi");
        Invoice invoice3 = stock.newInvoice("Corona");
        Invoice invoice4 = stock.newInvoice("Stock na Timirazeva");
        invoice1.fillInvoice(product1, 20);
        invoice1.fillInvoice(product2, 10);
        invoice1.fillInvoice(product1, 20);
        invoice2.fillInvoice(product2, 21);
        invoice2.fillInvoice(product3, 13);
        invoice2.fillInvoice(product4, 22);
        invoice3.fillInvoice(product2, 24);
        invoice3.fillInvoice(product3, 15);
        invoice3.fillInvoice(product4, 16);
        invoice4.fillInvoice(product5, 3);
        invoice4.fillInvoice(product6, 1);
        invoice4.fillInvoice(product7, 34);
        stock.addInvoiceToStock(invoice1);
        stock.addInvoiceToStock(invoice2);
        stock.addInvoiceToStock(invoice3);
        stock.addInvoiceToStock(invoice4);
        System.out.println(stock.getAllProducts());
        Assert.assertNotNull(stock);
        Assert.assertNotNull(invoice1);
        Assert.assertNotNull(invoice2);
        Assert.assertNotNull(invoice3);
        Assert.assertNotNull(invoice4);
        Assert.assertNotNull(stock.getAllProducts());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testZeroQuantityNegative() {

        Stock stock = new Stock("Stock on Gorkogo");
        Invoice invoice1 = stock.newInvoice("EuroOpt");
        Invoice invoice2 = stock.newInvoice("Almi");
        Invoice invoice3 = stock.newInvoice("Corona");
        Invoice invoice4 = stock.newInvoice("Stock na Timirazeva");
        invoice1.fillInvoice(product1, 20);
        invoice1.fillInvoice(product2, 0);
        invoice1.fillInvoice(product1, 20);
        invoice2.fillInvoice(product2, 21);
        invoice2.fillInvoice(product3, 13);
        invoice2.fillInvoice(product4, 22);
        invoice3.fillInvoice(product2, 0);
        invoice3.fillInvoice(product3, 15);
        invoice3.fillInvoice(product4, 16);
        invoice4.fillInvoice(product5, 3);
        invoice4.fillInvoice(product6, 0);
        invoice4.fillInvoice(product7, 34);
        stock.addInvoiceToStock(invoice1);
        stock.addInvoiceToStock(invoice2);
        stock.addInvoiceToStock(invoice3);
        stock.addInvoiceToStock(invoice4);
    }

    @Test
    public void testFindProductPositive() {
        Stock stock = new Stock("Stock on Gorkogo");
        Invoice invoice1 = stock.newInvoice("EuroOpt");
        Invoice invoice2 = stock.newInvoice("Almi");
        Invoice invoice3 = stock.newInvoice("Corona");
        Invoice invoice4 = stock.newInvoice("Stock na Timirazeva");
        invoice1.fillInvoice(product1, 20);
        invoice1.fillInvoice(product2, 10);
        invoice1.fillInvoice(product1, 20);
        invoice2.fillInvoice(product2, 21);
        invoice2.fillInvoice(product3, 13);
        invoice2.fillInvoice(product4, 22);
        invoice3.fillInvoice(product2, 24);
        invoice3.fillInvoice(product3, 15);
        invoice3.fillInvoice(product4, 16);
        invoice4.fillInvoice(product5, 3);
        invoice4.fillInvoice(product6, 1);
        stock.addInvoiceToStock(invoice1);
        stock.addInvoiceToStock(invoice2);
        stock.addInvoiceToStock(invoice3);
        stock.addInvoiceToStock(invoice4);
        Product productToFind1 = stock.findProduct("Milk");
        Product productToFind2 = stock.findProduct("Bread");
        Product productToFind3 = stock.findProduct("Apple");
        Product productToFind4 = stock.findProduct("Pineapple");
        Product productToFind5 = stock.findProduct("Meat");
        Product productToFind6 = stock.findProduct("Butter");
        Assert.assertNotNull(productToFind1);
        Assert.assertNotNull(productToFind2);
        Assert.assertNotNull(productToFind3);
        Assert.assertNotNull(productToFind4);
        Assert.assertNotNull(productToFind5);
        Assert.assertNotNull(productToFind6);
    }

    @Test
    public void testFindProductNegative() {
        Stock stock = new Stock("Stock on Gorkogo");
        Product productToFind = stock.findProduct("SourCream");
        Assert.assertNull(productToFind);
    }

    @Test
    public void testSendersListPositive() {
        Stock stock = new Stock("Stock on Gorkogo");
        Invoice invoice1 = stock.newInvoice("EuroOpt");
        Invoice invoice2 = stock.newInvoice("Almi");
        Invoice invoice3 = stock.newInvoice("Corona");
        Invoice invoice4 = stock.newInvoice("Stock na Timirazeva");
        invoice1.fillInvoice(product1, 20);
        invoice2.fillInvoice(product2, 21);
        invoice3.fillInvoice(product2, 24);
        invoice4.fillInvoice(product5, 3);
        stock.addInvoiceToStock(invoice1);
        stock.addInvoiceToStock(invoice2);
        stock.addInvoiceToStock(invoice3);
        stock.addInvoiceToStock(invoice4);
        Set set = stock.sendersList();
        System.out.println(set);
        Assert.assertNotNull(set);

    }

}
