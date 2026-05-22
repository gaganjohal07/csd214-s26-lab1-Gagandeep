package bookstore;

import bookstore.pojos.*;
import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class App {

    private List<SaleableItem> items = new ArrayList<>();
    private CashTill cashTill = new CashTill();
    private Scanner input = new Scanner(System.in);

    public void run() {
        populate();

        int choice = 0;

        while (choice != 99) {
            System.out.println("\n***********************");
            System.out.println(" 1. Add Items");
            System.out.println(" 2. Edit Items");
            System.out.println(" 3. Delete Items");
            System.out.println(" 4. Sell item(s)");
            System.out.println(" 5. List items");
            System.out.println("99. Quit");
            System.out.println("***********************");
            System.out.print("Enter choice: \n");

            try {
                String line = input.nextLine();
                if (line.trim().isEmpty()) continue;
                choice = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                System.out.println("Invalid input.");
                choice = 0;
            }

            switch (choice) {
                case 1:
                    addItem();
                    break;
                case 2:
                    editItem();
                    break;
                case 3:
                    deleteItem();
                    break;
                case 4:
                    sellItem();
                    break;
                case 5:
                    listAny();
                    break;
                case 99:
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    public void addItem() {
        int choice = 0;

        while (choice != 99) {
            System.out.println("\nAdd an item\n");
            System.out.println("1. Add Book");
            System.out.println("2. Add Magazine");
            System.out.println("3. Add DiscMag");
            System.out.println("4. Add Ticket");
            System.out.println("5. Add Gaming Keyboard");
            System.out.println("6. Add Gaming Mouse");
            System.out.println("99. Exit");

            try {
                String line = input.nextLine();
                if (line.trim().isEmpty()) continue;
                choice = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            if (choice == 99) return;

            SaleableItem item = null;

            switch (choice) {
                case 1:
                    item = new Book();
                    break;
                case 2:
                    item = new Magazine();
                    break;
                case 3:
                    item = new DiscMag();
                    break;
                case 4:
                    item = new Ticket();
                    break;
                case 5:
                    item = new GamingKeyboard();
                    break;
                case 6:
                    item = new GamingMouse();
                    break;
                default:
                    System.out.println("Invalid selection.");
                    continue;
            }

            if (item instanceof Editable) {
                ((Editable) item).initialize(this.input);
            }

            addItem(item);
        }
    }

    public void addItem(SaleableItem item) {
        items.add(item);
    }

    public void listAny() {
        int choice = 0;

        while (choice != 99) {
            System.out.println("\nAll Items");
            System.out.println("-----------");
            System.out.println("List");
            System.out.println("1. All");
            System.out.println("2. Books");
            System.out.println("3. Magazines");
            System.out.println("4. DiscMags");
            System.out.println("5. Tickets");
            System.out.println("6. Gaming Keyboards");
            System.out.println("7. Gaming Mice");
            System.out.println("99. Exit");

            try {
                String line = input.nextLine();
                if (line.trim().isEmpty()) continue;
                choice = Integer.parseInt(line.trim());
            } catch (NumberFormatException e) {
                choice = 0;
            }

            if (choice == 99) return;

            Class<?> filter = null;

            switch (choice) {
                case 1:
                    filter = null;
                    break;
                case 2:
                    filter = Book.class;
                    break;
                case 3:
                    filter = Magazine.class;
                    break;
                case 4:
                    filter = DiscMag.class;
                    break;
                case 5:
                    filter = Ticket.class;
                    break;
                case 6:
                    filter = GamingKeyboard.class;
                    break;
                case 7:
                    filter = GamingMouse.class;
                    break;
                default:
                    System.out.println("Invalid selection.");
                    continue;
            }

            for (SaleableItem i : items) {
                boolean show = false;

                if (filter == null) {
                    show = true;
                } else {
                    if (filter == Magazine.class && i instanceof DiscMag) {
                        show = false;
                    } else if (filter.isInstance(i)) {
                        show = true;
                    }
                }

                if (show) {
                    listI(i);
                }
            }
        }
    }

    public void listI(Object o) {
        System.out.println(o.toString());
    }

    public void editItem() {
        System.out.println("Select item index to edit (0 to " + (items.size() - 1) + "):");

        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ". " + items.get(i));
        }

        try {
            int idx = Integer.parseInt(input.nextLine().trim());

            if (idx >= 0 && idx < items.size()) {
                SaleableItem item = items.get(idx);

                if (item instanceof Editable) {
                    editItem((Editable) item);
                } else {
                    System.out.println("Item is not editable.");
                }
            }
        } catch (Exception e) {
            System.out.println("Invalid selection.");
        }
    }

    public void editItem(Editable item) {
        item.edit(this.input);
    }

    public void deleteItem() {
        System.out.println("Select item index to delete:");

        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ". " + items.get(i));
        }

        try {
            int idx = Integer.parseInt(input.nextLine().trim());

            if (idx >= 0 && idx < items.size()) {
                items.remove(idx);
                System.out.println("Item deleted.");
            }
        } catch (Exception e) {
            System.out.println("Invalid selection.");
        }
    }

    public void sellItem() {
        System.out.println("Select item index to sell:");

        for (int i = 0; i < items.size(); i++) {
            System.out.println(i + ". " + items.get(i));
        }

        try {
            int idx = Integer.parseInt(input.nextLine().trim());

            if (idx >= 0 && idx < items.size()) {
                SaleableItem item = items.get(idx);
                cashTill.sellItem(item);
            }
        } catch (Exception e) {
            System.out.println("Invalid selection.");
        }
    }

    public boolean findItemExists(SaleableItem item) {
        return items.contains(item);
    }

    public SaleableItem findItem(SaleableItem item) {
        int index = items.indexOf(item);

        if (index != -1) {
            return items.get(index);
        }

        return null;
    }

    public SaleableItem getItem(SaleableItem item) {
        return findItem(item);
    }

    public void populate() {
        System.out.println("Populating data with JavaFaker...");

        Faker faker = new Faker();

        for (int i = 0; i < 2; i++) {

            Book b = new Book(
                    faker.book().author(),
                    faker.book().title(),
                    faker.number().randomDouble(2, 10, 50),
                    faker.number().numberBetween(1, 20)
            );
            addItem(b);

            Magazine m = new Magazine(
                    faker.number().numberBetween(100, 500),
                    faker.date().past(30, TimeUnit.DAYS),
                    faker.book().title() + " Monthly",
                    faker.number().randomDouble(2, 5, 15),
                    faker.number().numberBetween(5, 50)
            );
            addItem(m);

            DiscMag dm = new DiscMag(
                    faker.bool().bool(),
                    faker.number().numberBetween(50, 200),
                    faker.date().past(60, TimeUnit.DAYS),
                    "Tech Disc: " + faker.app().name(),
                    faker.number().randomDouble(2, 10, 25),
                    faker.number().numberBetween(5, 30)
            );
            addItem(dm);

            Ticket t = new Ticket();
            t.description = "Concert: " + faker.rockBand().name();
            t.price = faker.number().randomDouble(2, 50, 150);
            addItem(t);

            GamingKeyboard gk = new GamingKeyboard(
                    faker.company().name(),
                    "Blue Switch"
            );
            addItem(gk);

            GamingMouse gm = new GamingMouse(
                    faker.company().name(),
                    faker.number().numberBetween(800, 6400)
            );
            addItem(gm);
        }
    }
}