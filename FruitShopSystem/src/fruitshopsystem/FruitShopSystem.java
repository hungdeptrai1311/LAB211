package fruitshopsystem;

public class FruitShopSystem {

    public static void main(String[] args) {
        int choice = 0;
        Function f = new Function();
        while (choice != 5) {
            choice = getChoice();
            switch (choice) {
                case 1:
                    f.create();
                    break;
                case 2:
                    f.update();
                    break;
                case 3:
                    f.viewOrder();
                    break;
                case 4:
                    f.shopping();
                    break;
                case 6:
                    f.display();
                    break;
            }
        }
    }

    public static int getChoice() {
        System.out.println("FRUIT SHOP SYSTEM\n \t1. Create Fruit\n \t2. Update Fruit\n \t3. View Orders\n \t4. Shopping(for buyer)\n \t5. Exit");
        int choice = Validation.getInteger("Enter menu choice: ", 1, 6);
        return choice;
    }
}
