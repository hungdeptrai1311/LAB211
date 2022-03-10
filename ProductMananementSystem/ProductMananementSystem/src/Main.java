
import product_management.Customer;
import product_management.CustomerManagement;
import product_management.Ordering;
import product_management.OrderingManagement;
import product_management.Product;
import product_management.ProductManagement;
import utilities.Input;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Ordering o = new Ordering("P1", "C1", 1);
        Product p = new Product("6", "E", 3, 2, 1.0);
        CustomerManagement clist = new CustomerManagement();
        ProductManagement plist = new ProductManagement();
        OrderingManagement olist = new OrderingManagement();
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
                                plist.loadDataFromFile("product2.txt");
                                break;
                            case 2:
                                plist.insertData();
                                break;
                            case 3:
                                plist.displayInorder();
                                break;
                            case 4:
                                plist.displayBreadthFirst();
                                break;
                            case 5:
                                plist.saveToFileInorder("product.txt");
                                break;
                            case 6:
                                plist.searchByCode();
                                break;
                            case 7:
                                plist.deleteByCode();
                                break;
                            case 8:
                                plist.selfBalance();
                                break;
                            case 9:
                                plist.countNumberOfProduct();
                                break;
                            case 11:
                                //1
                                plist.loadDataFromFile("product2.txt");
                                plist.displayBreadthFirst();
                                System.out.println("-----------------");
                                plist.displayInorder();
                                System.out.println("-----------------");

                                //2
                                plist.getTree().search(new Product("6", "", 0, 0, 0.0)).getData().setQuantity(9);
                                plist.displayBreadthFirst();
                                System.out.println("-----------------");
                            //3
                                plist.clear();
                                plist.loadDataFromFile("product2.txt");
                                plist.deleteByCode("2");
                                System.out.println("-----------------");
                            //4
                                plist.clear();
                                plist.loadDataFromFile("product2.txt");
                                plist.insert();
                                plist.displayBreadthFirst();
                                System.out.println("-----------------");
                            //5
                                plist.clear();
                                plist.loadDataFromFile("product2.txt");
                                plist.selfBalance();
                                plist.displayBreadthFirst();
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
//                case 3:
//                    while (true) {
//                        int orderChoice = getOrderChoice();
//                        switch (orderChoice) {
//                            case 1:
//                                olist.loadDataFromFile("order.txt");
//                                olist.
//                                olist.saveDataToFile("order.txt");
//                                olist.clear();
//                                break;
//                            case 2:
//                                olist.loadDataFromFile("order.txt");
//                                olist.display();
//                                break;
//                            case 3:
//                                olist.loadDataFromFile("order.txt");
//                                olist.sortByPcode();
//                                break;
//
//                        }
//
//                    }
//                    if (orderChoice == 4) {
//                        break;
//                    }
            }
            break;
        }
    }

    public static int getProductChoice() {
        System.out.println("1. Load data from file \n2. Input & insert data \n3. Inorder traverse \n4. Breadth-first traverse \n5. Inorder traverse to file \n6. Search by pcode \n7. Delete by pcode by copying \n8. Simply balancing \n9. Count number of product \n10. Back to main menu \n11.Yêu cầu của thầy");
        int choice = Input.getIntegerInclusive("Enter product choice: ", 1, 11);;
        return choice;
    }

    public static int getCustomerChoice() {
        System.out.println("1. Load data from file \n2. Input & add to the end \n3. Display data \n4. Save customer list to the file \n5. Search by ccode \n6. Delete by ccode \n7. Back to main menu");
        int choice = Input.getIntegerInclusive("Enter customer choice: ", 1, 7);
        return choice;
    }

    public static int getOrderChoice() {
        System.out.println("1. Input data \n2. Display data with total value \n3. Sort by pcode + ccode \n4. Back to main menu");
        int choice = Input.getIntegerInclusive("Enter order choice: ", 1, 4);
        return choice;
    }

    public static int getMenuChoice() {
        System.out.println("1. Product \n2. Customer \n3. Order \n4. Exit");
        int choice = Input.getIntegerInclusive("Enter menu choice: ", 1, 4);
        return choice;
    }

    public static Customer addCustomer() {
        Scanner sc = new Scanner(System.in);
        Customer c = new Customer();
        c.setCcode(Input.checkCCode("Enter customer's code: "));
        System.out.print("Enter customer's name: ");
        c.setCname(sc.nextLine().trim());
        System.out.print("Enter customer's phone number: ");
        c.setPhone(sc.nextLine().trim());
        return c;
    }

//    public static Ordering addOrder() {
//        Scanner sc = new Scanner(System.in);
//        ProductManagement plist = new ProductManagement();
//        OrderingManagement olist = new OrderingManagement();
//        Ordering o = new Ordering();
//        olist.loadDataFromFile("order.txt");
//        while (true) {
//            o.setPcode(Input.checkOrderPCode("Enter product's code: "));
//            o.setCcode(Input.checkOrderCCode("Enter customer's code: "));
//            if (olist.findProductByCode(o.getPcode()) != null && olist.findCustomerByCode(o.getCcode()) != null) {
//                System.out.println("This info is not accepted");
//                continue;
//            }
//            plist.loadDataFromFile("asm1.txt");
//            NodeProduct p = plist.findProductByCode(o.getPcode());
//            plist.clear();
//            System.out.println("This product has " + (p.info.getQuantity() - p.info.getSaled()) + " left");
//            o.setQuantity(Input.getInteger("Enter product's quantity you want to buy: ", 1, p.info.getQuantity() - p.info.getSaled()));
//            if (Input.checkQuantity(o.getPcode())) {
//                System.out.println("The product is exhausted");
//                continue;
//            }
//            break;
//        }
//        olist.addLast(o);
//        return o;
//    }
}
