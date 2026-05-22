package bookstore.pojos;

import java.util.Scanner;

public abstract class GamingAccessory extends Product {

    private String brand;

    public GamingAccessory() {
        super();
    }

    public GamingAccessory(String brand) {
        super();
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void initialize(Scanner input) {
        System.out.print("Enter brand: ");
        brand = input.nextLine();
    }

    public void edit(Scanner input) {
        System.out.print("Enter new brand: ");
        brand = input.nextLine();
    }

    @Override
    public String toString() {
        return super.toString() + " brand='" + brand + "'";
    }
}