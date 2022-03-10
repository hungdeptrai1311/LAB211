package Product_Management;

import LinkedList.NodeProduct;
import Validation.ConsoleColor;
import java.io.File;
import java.io.FileWriter;
import java.util.Locale;
import java.util.Scanner;

public class ProductList {

    private NodeProduct head, tail;

    public ProductList() {
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addLast(Product x) {
        NodeProduct q = new NodeProduct(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    public void display() {
        NodeProduct it = head;
        System.out.printf("%6s | %20s | %10s | %10s | %6s | %s\n", "code", "pro_name", "quantity", "saled", "price", "value");

        System.out.println("-------------------------------------------------------------------------------------");
        while (it != null) {
            System.out.printf("%6s | %20s | %10d | %10d | %6.1f | %.1f\n", it.info.getPcode(), it.info.getPro_name(), it.info.getQuantity(), it.info.getSaled(), it.info.getPrice(), it.info.getPrice() * it.info.getSaled());
            it = it.next;
        }
    }

    public void saveDataToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);

            NodeProduct it = head;
            while (it != null) {
                String line = String.format(Locale.US, "%6s | %20s | %10d | %10d | %6.1f\n", it.info.getPcode(), it.info.getPro_name(), it.info.getQuantity(), it.info.getSaled(), it.info.getPrice());
                fw.append(line);
                it = it.next;
            }

            fw.close();
        } catch (Exception e) {
            System.err.println("Loi khi save file!");
        }
    }

    public void loadDataFromFile(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));

            sc.useLocale(Locale.US);

            while (sc.hasNext()) {
                String line = sc.nextLine();

                String[] tokens = line.split("\\|");

                if (tokens.length == 5) {
                    addLast(new Product(tokens[0].trim(), tokens[1].trim(), Integer.parseInt(tokens[2].trim()), Integer.parseInt(tokens[3].trim()), Double.parseDouble(tokens[4].trim())));
                }
            }

            sc.close();
        } catch (Exception e) {
            System.err.println("Something went wrong while loading data!");
        }
    }

    public NodeProduct findProductByCode(String pcode) {
        NodeProduct p = head;

        while (p != null) {
            if (p.info.getPcode().equals(pcode)) {
                return p;
            }
            p = p.next;
        }

        return null;
    }

    public void searchByPcode(String xPcode) {
        NodeProduct p = findProductByCode(xPcode);
        if (p.info.getPcode().equals(xPcode)) {
            System.out.printf("Found: %6s | %20s | %10d | %10d | %6.1f | %.1f\n", p.info.getPcode(), p.info.getPro_name(), p.info.getQuantity(), p.info.getSaled(), p.info.getPrice(), p.info.getPrice() * p.info.getSaled());
        } else {
            System.err.println("Not found!");
        }
    }

    public void remove(NodeProduct q) {
        NodeProduct pre = null, cur = head;
        while (cur != null && cur.next != null) {
            if (cur.equals(q)) {
                break;
            }
            pre = cur;
            cur = cur.next;
        }
        if (pre != null) {
            pre.next = q.next;
        } else if (head != null) {
            head = head.next;
        }
    }

    public void remove(String xPcode) {
        NodeProduct p = findProductByCode(xPcode);
        remove(p);
        System.out.println(ConsoleColor.GREEN + "Delete successfully");
    }
    
    public void sortByPcode() {
        while (true) {
            NodeProduct p = head;
            boolean isSorted = true;
            while (p != null && p.next != null) {
                if (p.info.getPcode().compareTo(p.next.info.getPcode()) > 0) {
                    Product tmp = p.info;
                    p.info = p.next.info;
                    p.next.info = tmp;
                    
                    isSorted = false;
                }
                p = p.next;
            }
            if(isSorted){
                break;
            }
        }
        System.out.println(ConsoleColor.GREEN + "Sort successfully");
    }
    
    public NodeProduct pos(int k) {
        NodeProduct p = head;
        int count = 0;
        while (p != null) {
            if (count == k) {
                return p;
            }
            count++;
            p = p.next;
        }
        return null;
    }
    
    public void addAfterPos(NodeProduct q, Product x) {
        if (q == null) {
            return;
        }
        NodeProduct p = new NodeProduct(x, q.next);
        q.next = p;
    }
    
     public void removeAfterXCode() {
        Scanner sc = new Scanner(System.in);

        System.out.print("pcode: ");
        String code = sc.nextLine();

        NodeProduct productNode = findProductByCode(code);

        remove(productNode.next);
        System.out.println(ConsoleColor.GREEN +"Delete successfully!");
    }
     
    public void clear() {
        head = tail = null;
    }
    
    public void editQuantity(){
        Scanner sc = new Scanner(System.in);
        NodeProduct p = findProductByCode("3");
        p.info.setQuantity(9);
    }
    
    public void sortBySaled() {
        while (true) {
            NodeProduct p = head;
            boolean isSorted = true;
            while (p != null && p.next != null) {
                if (p.info.getSaled() > p.next.info.getSaled()) {
                    Product tmp = p.info;
                    p.info = p.next.info;
                    p.next.info = tmp;
                    
                    isSorted = false;
                }
                p = p.next;
            }
            if(isSorted){
                break;
            }
        }
        System.out.println(ConsoleColor.GREEN + "Sort successfully");
    }
}
