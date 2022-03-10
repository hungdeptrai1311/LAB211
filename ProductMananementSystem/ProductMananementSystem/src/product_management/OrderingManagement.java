package product_management;

import LinkedList.NodeOrder;
import utilities.ConsoleColor;
import java.io.File;
import java.io.FileWriter;
import java.util.Locale;
import java.util.Scanner;

public class OrderingManagement {

    NodeOrder head, tail;

    public OrderingManagement() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    public void clear() {
        head = tail = null;
    }

    public void addLast(Ordering o) {
        NodeOrder q = new NodeOrder(o);
        if (isEmpty()) {
            head = tail = q;
            return;
        }
        tail.next = q;
        tail = q;
    }

    public void saveDataToFile(String filename) {
        try {
            FileWriter fw = new FileWriter(filename);

            NodeOrder it = head;
            while (it != null) {
                String line = String.format(Locale.US, "%6s | %20s | %10d\n", it.info.getPcode(), it.info.getCcode(), it.info.getQuantity());
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

                if (tokens.length == 3) {
                    addLast(new Ordering(tokens[0].trim(), tokens[1].trim(), Integer.parseInt(tokens[2].trim())));
                }
            }

            sc.close();
        } catch (Exception e) {
            System.err.println("Something went wrong while loading data!");
        }
    }

    public NodeOrder findProductByCode(String pcode) {
        NodeOrder p = head;

        while (p != null) {
            if (p.info.getPcode().equals(pcode)) {
                return p;
            }
            p = p.next;
        }

        return null;
    }

    public NodeOrder findCustomerByCode(String ccode) {
        NodeOrder p = head;

        while (p != null) {
            if (p.info.getPcode().equals(ccode)) {
                return p;
            }
            p = p.next;
        }

        return null;
    }

    public void display() {
        NodeOrder it = head;
        System.out.printf("%6s | %20s | %10s\n", "pcode", "ccode", "quantity");

        System.out.println("-------------------------------------------------------------------------------------");
        while (it != null) {
            System.out.printf("%6s | %20s | %10d\n", it.info.getPcode(), it.info.getCcode(), it.info.getQuantity());
            it = it.next;
        }
    }

    public void sortByPcode() {
        while (true) {
            NodeOrder p = head;
            boolean isSorted = true;
            while (p != null && p.next != null) {
                if (p.info.getPcode().compareTo(p.next.info.getPcode()) > 0) {
                    Ordering tmp = p.info;
                    p.info = p.next.info;
                    p.next.info = tmp;

                    isSorted = false;
                } else {
                    if (p.info.getCcode().compareTo(p.next.info.getCcode()) > 0) {
                        Ordering tmp = p.info;
                        p.info = p.next.info;
                        p.next.info = tmp;

                        isSorted = false;
                    }
                }
                p = p.next;
            }
            if (isSorted) {
                break;
            }
        }
        System.out.println(ConsoleColor.GREEN + "Sort successfully");
    }
}
