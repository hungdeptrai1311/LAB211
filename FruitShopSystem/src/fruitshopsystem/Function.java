package fruitshopsystem;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Function {

    ArrayList<Fruit> list = new ArrayList();
    HashMap<String, ArrayList<Fruit>> cusorder = new HashMap<String, ArrayList<Fruit>>();

    public void create() {
        add(null);
        while (true) {
            System.out.println("Do you want to continue(Y/N)?");
            String choice = Validation.getChoice("Y", "N");
            if (choice.equalsIgnoreCase("N")) {
                break;
            } else {
                add(null);
            }
        }
        display();
    }

    public void add(String s) {
        Fruit fruit = new Fruit();
        while (true) {
            if (s == null) {
                s = Validation.getString("Enter fruit's ID: ");
            }
            fruit.setFruitID(s);
            if (checkId(fruit.getFruitID()) == -1) {
                break;
            }
            System.err.println("This ID has been existed. Please enter another ID!");
            s = null;
        }
        fruit.setFruitName(Validation.getString("Enter fruit's name: "));
        fruit.setPrice(Validation.getDouble("Enter fruit's price: ", 0, Double.MAX_VALUE));
        fruit.setQuantity(Validation.getInteger("Enter fruit's quantity: ", 0, Integer.MAX_VALUE));
        fruit.setOrigin(Validation.getString("Enter fruit's origin: "));
        list.add(fruit);
    }

    public int checkId(String s) {
        for (int i = 0; i < list.size(); i++) {
            if (s.equalsIgnoreCase(list.get(i).getFruitID())) {
                return i;
            }
        }
        return -1;
    }

    public void display() {
        System.out.printf("%15s | %15s | %15s | %15s | %15s\n", "ID", "Fruit Name", "Price", "Quantity", "Origin");
        for (Fruit fruit : list) {
            System.out.println(fruit.toString());
        }
    }

    public void update() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter fruit's ID you want to update: ");
        String s = sc.nextLine().trim();
        int i = checkId(s);
        if (i != -1) {
            list.get(i).setQuantity(Validation.getInteger("Enter fruit's quantity: ", 0, Integer.MAX_VALUE));
            System.out.println("Update successfully");
        } else {
            System.out.println("Do you want to create new fruit(Y/N)?");
            String choice = Validation.getChoice("Y", "N");
            if (choice.equalsIgnoreCase("N")) {
                return;
            } else {
                add(s);
            }
        }
    }

    public void shopping() {
        if (list.isEmpty()) {
            System.err.println("Not have any fruit in storage");
            return;
        }
        ArrayList<Fruit> orderlist = new ArrayList();
        ArrayList<Fruit> clone = new ArrayList();
        while (true) {
            System.out.printf("| %8s | %14s | %10s | %9s |\n", "++Item++", "++Fruit Name++", "++Origin++", "++Price++");
            int n = 1;
            for (Fruit fruit : list) {
                if (fruit.getQuantity() > 0) {
                    System.out.printf("%10d %16s %12s %12f$", n, fruit.getFruitName(), fruit.getOrigin(), fruit.getPrice());
                    n++;
                    System.out.println();
                }
            }
            int choice = Validation.getInteger("Enter item: ", 1, n);
            n = 0;
            for (Fruit fruit : list) {
                if (fruit.getQuantity() > 0) {
                    n++;
                    if (n == choice) {
                        Fruit order = new Fruit();
                        System.out.println("You selected: " + fruit.getFruitName());
                        order.setFruitName(fruit.getFruitName());
                        System.out.println("The remaining quantity: " + fruit.getQuantity());
                        choice = Validation.getInteger("Please input quantity: ", 1, fruit.getQuantity());
                        order.setQuantity(choice);
                        fruit.setQuantity(fruit.getQuantity() - choice);
                        order.setPrice(fruit.getPrice());
                        orderlist.add(order);
                        break;
                    }
                }
            }
            for(int i = 0; i < orderlist.size() - 1; i++){
                for(int j = i + 1; j < orderlist.size(); j++){
                    if(orderlist.get(i).getFruitName().equalsIgnoreCase(orderlist.get(j).getFruitName())){
                        orderlist.get(j).setQuantity(orderlist.get(i).getQuantity() + orderlist.get(j).getQuantity());
                        orderlist.remove(i);
                    }
                }
            }
            System.out.print("Do you want to order now (Y/N)? ");
            String option = Validation.getChoice("Y", "N");
            if (option.equalsIgnoreCase("n")) {
                continue;
            } else {
                clone.addAll(orderlist);
                clone.sort((t, t1) -> {
                    return t1.getQuantity() - t.getQuantity();
                });
                System.out.printf("%15s | %8s | %5s | %6s\n", "Product", "Quantity", "Price", "Amount");
                double total = 0;
                for (Fruit fruit : clone) {
                    System.out.printf("%15s %10d %7f$ %9f\n", fruit.getFruitName(), fruit.getQuantity(), fruit.getPrice(), fruit.getPrice() * fruit.getQuantity());
                    total += (fruit.getPrice() * fruit.getQuantity());
                }
                System.out.println("Total: " + total + "$");
                break;
            }
        }

        String cusName = Validation.getString("Input your name: ");
        cusorder.put(cusName, orderlist);
    }

    public void viewOrder() {
        for (Map.Entry<String, ArrayList<Fruit>> entry : cusorder.entrySet()) {
            String key = entry.getKey();
            ArrayList<Fruit> value = entry.getValue();
            System.out.print("Customer: " + key);
            System.out.println();
            System.out.printf("%15s | %8s | %5s | %6s\n", "Product", "Quantity", "Price", "Amount");
            double total = 0;
            for (Fruit fruit : value) {
                System.out.printf("%15s %10d %7f$ %9f\n", fruit.getFruitName(), fruit.getQuantity(), fruit.getPrice(), fruit.getPrice() * fruit.getQuantity());
                total += (fruit.getPrice() * fruit.getQuantity());
            }
            System.out.println("Total: " + total + "$");
        }
    }
}
