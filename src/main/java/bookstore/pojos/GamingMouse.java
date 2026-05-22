package bookstore.pojos;

import java.util.Scanner;

public class GamingMouse extends GamingAccessory {

    private int dpi;

    public GamingMouse() {
        super();
    }

    public GamingMouse(String brand, int dpi) {
        super(brand);
        this.dpi = dpi;
    }

    public int getDpi() {
        return dpi;
    }

    public void setDpi(int dpi) {
        this.dpi = dpi;
    }

    @Override
    public void initialize(Scanner input) {
        super.initialize(input);

        System.out.print("Enter DPI: ");
        dpi = Integer.parseInt(input.nextLine());
    }

    @Override
    public void edit(Scanner input) {
        super.edit(input);

        System.out.print("Enter new DPI: ");
        dpi = Integer.parseInt(input.nextLine());
    }

    @Override
    public void sellItem() {
        System.out.println("Gaming Mouse sold!");
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public String toString() {
        return super.toString() + " DPI: " + dpi;
    }
}