
package prog01_aorderedlist;
import java.util.Scanner;

/**
 *
 * @author diamond
 */
public class Car {
    private String make;
    private int year;
    private int price;


    public Car(String make, int year, int price) {
        this.make = make;
        this.year = year;
        this.price = price;
    }

    public String getMake() {
        return make;
    }

    public int getYear() {
        return year;
    }

    public int getPrice() {
        return price;
    }

    public int compareTo(Car other) {
        if (!this.make.equals(other.make)) {
            return this.make.compareTo(other.make);
        } else {
            if (this.year != other.year) {
                return this.year - other.year;
            } else {
                return 0;
            }
        }

    }

    public String toString() {
        return "Make: " + make + ", Year:" + year + ", Price: " + price + ";";
    }
}
