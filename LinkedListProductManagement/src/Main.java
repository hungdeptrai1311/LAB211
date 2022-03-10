
import LinkedList.NodeProduct;
import Product_Management.Customer;
import Product_Management.CustomerList;
import Product_Management.Order;
import Product_Management.OrderList;
import Product_Management.Product;
import Product_Management.ProductList;
import Validation.Input;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Order o = new Order("P1", "C1", 1);
        Product p = new Product("6", "E", 3, 2, 1);
        CustomerList clist = new CustomerList();
        ProductList plist = new ProductList();
        OrderList olist = new OrderList();
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        while (choice != 4) {
            choice = getMenuChoice();
            switch (choice) {
                case 1:
                    while (true) {
                        int productChoice = getProductChoice();
                        switch (productChoice) {
                            case 1:
                                plist.clear();
                                plist.loadDataFromFile("asm1.txt");
                                break;
                            case 2:
                                plist.addLast(addProduct());
                                break;
                            case 3:
                                plist.display();
                                break;
                            case 4:
                                plist.saveDataToFile("asm1.txt");
                                break;
                            case 5:
                                System.out.print("Enter product's code:");
                                plist.searchByPcode(sc.nextLine());
                                break;
                            case 6:
                                System.out.print("Enter product's code:");
                                plist.remove(sc.nextLine());
                                break;
                            case 7:
                                plist.sortByPcode();
                                break;
                            case 8:
                                System.out.print("Enter position: ");
                                plist.addAfterPos(plist.pos(sc.nextInt()), addProduct());
                                break;
                            case 9:
                                plist.removeAfterXCode();
                                break;
                            case 11:
                                plist.clear();
                                plist.loadDataFromFile("product1.txt");
                                plist.display();
                                break;
                            case 12:
                                plist.clear();
                                plist.loadDataFromFile("product1.txt");
                                plist.remove("2");
                                plist.display();
                                break;
                            case 13:
                                plist.clear();
                                plist.loadDataFromFile("product1.txt");
                                plist.editQuantity();
                                plist.display();
                                break;
                            case 14:
                                plist.clear();
                                plist.loadDataFromFile("product1.txt");
                                plist.addLast(p);
                                plist.display();
                                break;
                            case 15:
                                plist.clear();
                                plist.loadDataFromFile("product1.txt");
                                plist.sortBySaled();
                                plist.display();
                                break;
                        }
                        if (productChoice == 10) {
                            break;
                        }
                    }
                    break;
                case 2:
                    while (true) {
                        int customerChoice = getCustomerChoice();
                        switch (customerChoice) {
                            case 1:
                                clist.clear();
                                clist.loadDataFromFile("cus.txt");
                                break;
                            case 2:
                                clist.addLast(addCustomer());
                                break;
                            case 3:
                                clist.display();
                                break;
                            case 4:
                                clist.saveDataToFile("cus.txt");
                                break;
                            case 5:
                                System.out.print("Enter customer's code:");
                                clist.searchByPcode(sc.nextLine().trim());
                                break;
                            case 6:
                                System.out.print("Enter customer's code:");
                                clist.remove(sc.nextLine());
                                break;
                        }
                        if (customerChoice == 7) {
                            break;
                        }
                    }
                    break;
                case 3:
                    while (true) {
                        int orderChoice = getOrderChoice();
                        switch (orderChoice) {
                            case 1:
                                olist.loadDataFromFile("order.txt");
                                olist.addLast(addOrder());
                                olist.saveDataToFile("order.txt");
                                olist.clear();
                                break;
                            case 2:
                                olist.loadDataFromFile("order.txt");
                                olist.display();
                                break;
                            case 3:
                                olist.loadDataFromFile("order.txt");
                                olist.sortByPcode();
                                break;
                            case 4: {
                                Ordering t = new Ordering();
                                t.loadFiles("product.txt", "customer.txt");
                                t.sell("P1", "C1", 1); // Successful
                                t.sell("P1", "C2", 1); // Not successful because quantity=selled
                                t.sell("P2", "C2", 2); // Successful
                                t.displayProduct();
                                t.displayOrdering();
                                System.out.println();
                                break;
                            }

                        }
                        if (orderChoice == 4) {
                            break;
                        }
                    }
                    break;
            }
        }
    }

    public static int getProductChoice() {
        System.out.println("1. Load data from file \n2. Input & add to the end \n3. Display data \n4. Save product list to the file \n5. Search by pcode \n6. Delete by pcode \n7. Sort by pcode \n8. Add after position k \n9. Delete the node after the node having code = xCode \n10. Back to main menu \n11.Yêu cầu 1 của thầy \n12. Yêu cầu 2 của thầy \n13. Yêu cầu 3 của thầy \n14. Yêu cầu 4 của thầy \n15. Yêu cầu 5 của thầy");
        int choice = Input.getInteger("Enter product choice: ", 1, 15);
        return choice;
    }

    public static int getCustomerChoice() {
        System.out.println("1. Load data from file \n2. Input & add to the end \n3. Display data \n4. Save customer list to the file \n5. Search by ccode \n6. Delete by ccode \n7. Back to main menu");
        int choice = Input.getInteger("Enter customer chocie: ", 1, 7);
        return choice;
    }

    public static int getOrderChoice() {
        System.out.println("1. Input data \n2. Display data with total value \n3. Sort by pcode + ccode \n4. Back to main menu");
        int choice = Input.getInteger("Enter order choice: ", 1, 4);
        return choice;
    }

    public static int getMenuChoice() {
        System.out.println("1. Product \n2. Customer \n3. Order \n4. Exit");
        int choice = Input.getInteger("Enter menu choice: ", 1, 4);
        return choice;
    }

    public static Product addProduct() {
        Scanner sc = new Scanner(System.in);
        Product p = new Product();
        p.setPcode(Input.checkPCode("Enter product's code: "));
        System.out.print("Enter product's name: ");
        p.setPro_name(sc.nextLine());
        System.out.print("Enter product's quantity: ");
        p.setQuantity(sc.nextInt());
        System.out.print("Enter product's saled: ");
        while (true) {
            p.setSaled(sc.nextInt());
            if (p.getSaled() > p.getQuantity()) {
                System.err.println("Saled number must be smaller than quantity");
                p.setSaled(sc.nextInt());
                continue;
            }
            break;
        }
        System.out.print("Enter product's price: ");
        p.setPrice(sc.nextDouble());
        return p;
    }

    public static Customer addCustomer() {
        Scanner sc = new Scanner(System.in);
        Customer c = new Customer();
        c.setCcode(Input.checkCCode("Enter customer's code: "));
        System.out.print("Enter customer's name: ");
        c.setCus_name(sc.nextLine().trim());
        System.out.print("Enter customer's phone number: ");
        c.setPhone(sc.nextLine().trim());
        return c;
    }

    public static Order addOrder() {
        Scanner sc = new Scanner(System.in);
        ProductList plist = new ProductList();
        OrderList olist = new OrderList();
        Order o = new Order();
        olist.loadDataFromFile("order.txt");
        while (true) {
            o.setPcode(Input.checkOrderPCode("Enter product's code: "));
            o.setCcode(Input.checkOrderCCode("Enter customer's code: "));
            if (olist.findProductByCode(o.getPcode()) != null && olist.findCustomerByCode(o.getCcode()) != null) {
                System.out.println("This info is not accepted");
                continue;
            }
            plist.loadDataFromFile("asm1.txt");
            NodeProduct p = plist.findProductByCode(o.getPcode());
            plist.clear();
            System.out.println("This product has " + (p.info.getQuantity() - p.info.getSaled()) + " left");
            o.setQuantity(Input.getInteger("Enter product's quantity you want to buy: ", 1, p.info.getQuantity() - p.info.getSaled()));
            if (Input.checkQuantity(o.getPcode())) {
                System.out.println("The product is exhausted");
                continue;
            }
            break;
        }
        olist.addLast(o);
        return o;
    }
}
