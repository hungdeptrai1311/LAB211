
import Product_Management.Customer;
import Product_Management.CustomerList;
import Product_Management.Order;
import Product_Management.OrderList;
import Product_Management.Product;
import Product_Management.ProductList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author vuman
 */
public class Ordering {

    CustomerList clist = new CustomerList();
    ProductList plist = new ProductList();
    OrderList olist = new OrderList();
    
    public void loadFiles(String f1, String f2) {
        plist.loadDataFromFile(f1);
        clist.loadDataFromFile(f2);
    }
    
    public void sell(String pcode, String ccode, int quantity) {
        
        Product p = plist.findProductByCode(pcode).info;
        Customer c = clist.findCustomerByCode(ccode).info;
        
        if (p == null || c == null) {
            return;
        }
        
        if (olist.findProductByCode(pcode) != null && olist.findCustomerByCode(ccode) != null) {
            return;
        }
        
        if (p.getSaled() >= p.getQuantity()) {
            return;
        }
        
        olist.addLast(new Order(pcode, ccode, quantity));
        p.setSaled(quantity + p.getSaled());
    }
    
    public void displayProduct() {
        plist.display();
    }
    
    public void displayOrdering() {
        olist.display();
    }
}
