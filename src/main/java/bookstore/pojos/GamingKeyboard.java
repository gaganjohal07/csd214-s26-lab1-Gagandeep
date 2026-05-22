package bookstore.pojos;

import java.util.Scanner;

public class GamingKeyboard extends GamingAccessory {

    private String switchType;

    public GamingKeyboard() {
        super();
    }

    public GamingKeyboard(String brand, String switchType) {
        super(brand);
        this.switchType = switchType;
    }

    public String getSwitchType() {
        return switchType;
    }

    public void setSwitchType(String switchType) {
        this.switchType = switchType;
    }

    @Override
    public void initialize(Scanner input) {

        super.initialize(input);

        System.out.print("Enter Switch Type: ");
        switchType = input.nextLine();
    }

    @Override
    public void edit(Scanner input) {

        super.edit(input);

        System.out.print("Enter New Switch Type: ");
        switchType = input.nextLine();
    }

    @Override
    public double getPrice() {
        return 0;
    }

    @Override
    public void sellItem() {
        System.out.println("Gaming Keyboard sold!");
    }

    @Override
    public String toString() {
        return "GamingKeyboard{" +
                super.toString() +
                ", switchType='" + switchType + '\'' +
                '}';
    }
}