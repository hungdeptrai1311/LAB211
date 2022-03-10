
package product_management;

import LinkedList.NodeCustomer;
import utilities.ConsoleColor;
import java.io.File;
import java.io.FileWriter;
import java.util.Locale;
import java.util.Scanner;

public class CustomerManagement {
    private NodeCustomer head, tail;

    public CustomerManagement() {
    }

    public boolean isEmpty() {
        return (head == null);
    }

    public void addLast(Customer x) {
        NodeCustomer q = new NodeCustomer(x);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }
    
    public void loadDataFromFile(String filename) {
        try {
            Scanner sc = new Scanner(new File(filename));

            sc.useLocale(Locale.US);

            while (sc.hasNext()) {
                String line = sc.nextLine();

                String[] tokens = line.split("\\|");

                if (tokens.length == 3) {
                    addLast(new Customer(tokens[0].trim(), tokens[1].trim(), tokens[2].trim()));
                }
            }

            sc.close();
        } catch (Exception e) {
            System.err.println("Something went wrong while loading data!");
        }
    }
    
    public void clear() {
        head = tail = null;
    }
    
    public NodeCustomer findCustomerByCode(String ccode) {
        NodeCustomer p = head;

        while (p != null) {
            if (p.info.getCcode().equals(ccode)) {
                return p;
            }
            p = p.next;
        }

        return null;
    }
    
    public void display() {
        NodeCustomer it = head;
        System.out.printf("%6s | %20s | %10s\n","code", "cus_name", "phone");

        System.out.println("-------------------------------------------------------------------------------------");
        while (it != null) {
            System.out.printf("%6s | %20s | %10s\n", it.info.getCcode(), it.info.getCname(), it.info.getPhone());
            it = it.next;
        }
    }
    
    public void saveDataToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);

            NodeCustomer it = head;
            while (it != null) {
                String line = String.format(Locale.US, "%6s | %20s | %10s\n", it.info.getCcode(), it.info.getCname(), it.info.getPhone());
                fw.append(line);
                it = it.next;
            }

            fw.close();
        } catch (Exception e) {
            System.err.println("Loi khi save file!");
        }
    }
    
    public void searchByPcode(String xPcode) {
        NodeCustomer p = findCustomerByCode(xPcode);
        if (p.info.getCcode().equals(xPcode)) {
            System.out.printf("Found: %6s | %20s | %10s\n", p.info.getCcode(), p.info.getCname(), p.info.getPhone());
        } else {
            System.err.println("Not found!");
        }
    }
    
    public void remove(NodeCustomer q) {
        NodeCustomer pre = null, cur = head;
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
        NodeCustomer p = findCustomerByCode(xPcode);
        remove(p);
        System.out.println(ConsoleColor.GREEN + "Delete successfully");
    }
}
