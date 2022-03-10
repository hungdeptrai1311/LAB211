package Validation;

import LinkedList.NodeProduct;
import Product_Management.CustomerList;
import Product_Management.ProductList;
import java.util.Scanner;

public class Input {

    public static int getInteger(String msg, int min, int max) {
        Scanner sc = new Scanner(System.in);
        int result = 0;
        while (true) {
            try {
                System.out.print(msg);
                result = Integer.parseInt(sc.nextLine());
                if (min <= result && result <= max) {
                    break;
                }
                System.err.println("Out of range");
            } catch (NumberFormatException e) {
                System.err.println("You must enter an integer");
            }
        }
        return result;
    }

    public static String checkPCode(String msg) {
        Scanner sc = new Scanner(System.in);
        ProductList plist = new ProductList();
        String pCode = "";
        plist.loadDataFromFile("asm1.text");
        while (true) {
            System.out.print(msg);
            pCode = sc.nextLine().trim();
            if (plist.findProductByCode(pCode) != null) {
                System.err.println("This Pcode has been existed");
                plist.clear();
                continue;
            }
            break;
        }
        return pCode;
    }
    
    public static String checkCCode(String msg) {
        Scanner sc = new Scanner(System.in);
        CustomerList clist = new CustomerList();
        String cCode = "";
        clist.loadDataFromFile("cus.txt");
        while (true) {
            System.out.print(msg);
            cCode = sc.nextLine().trim();
            if (clist.findCustomerByCode(cCode) != null) {
                System.err.println("This Ccode has been existed");
                clist.clear();
                continue;
            }
            break;
        }
        return cCode;
    }
    
    public static String checkOrderCCode(String msg) {
        Scanner sc = new Scanner(System.in);
        CustomerList clist = new CustomerList();
        String cCode = "";
        clist.loadDataFromFile("cus.txt");
        while (true) {
            System.out.print(msg);
            cCode = sc.nextLine().trim();
            if (clist.findCustomerByCode(cCode) == null) {
                System.err.println("You must enter existed Ccode");
                clist.clear();
                continue;
            }
            break;
        }
        return cCode;
    }
    
    public static String checkOrderPCode(String msg) {
        Scanner sc = new Scanner(System.in);
        ProductList plist = new ProductList();
        String pCode = "";
        plist.loadDataFromFile("asm1.txt");
        while (true) {
            System.out.print(msg);
            pCode = sc.nextLine().trim();
            if (plist.findProductByCode(pCode) == null) {
                System.err.println("You must enter existed Pcode");
                plist.clear();
                continue;
            }
            break;
        }
        return pCode;
    }
    
    public static boolean checkQuantity(String pcode){
        ProductList plist = new ProductList();
        plist.loadDataFromFile("asm1.txt");
        NodeProduct p = plist.findProductByCode(pcode);
        if(p.info.getQuantity() != p.info.getSaled()){
            return false;
        }
        return true;
    }
}
