import prog01_aorderedlist.Car;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

class Prog01_aOrderedList {

    public static void main(String[] args) {
        // Create aOrderedList object
        aOrderedList orderedList = new aOrderedList();

        // Get input file
        Scanner scanner = null;
        try {
            scanner = getInputFile("Enter input filename: ");
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 4) {
                    String operation = parts[0];
                    if (operation.equalsIgnoreCase("A")) {
                        String make = parts[1];
                        int year = Integer.parseInt(parts[2]);
                        int price = Integer.parseInt(parts[3]);
                        Car car = new Car(make, year, price);
                        orderedList.add((Comparable) car);
                    } else if (operation.equalsIgnoreCase("D")) {
                        // Implement delete operation if needed
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        // Get output file and write ordered list content
        try {
            PrintWriter writer = getOutputFile("Enter output filename: ");
            writer.println("Number of cars: " + orderedList.size());
            for (int i = 0; i < orderedList.size(); i++) {
                writer.println();
                writer.println(orderedList.get(i).toString());
            }
            writer.close();

            // Print the contents of the input file
            System.out.println("Contents of input file:");
            printFileContents(getInputFile("Enter input filename: "));

            // Print the contents of the output file
            System.out.println("Contents of output file:");
            printFileContents(getInputFile("Enter output filename: "));
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Scanner getInputFile(String userPrompt) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String filename;
        File file;
        do {
            System.out.print(userPrompt);
            filename = scanner.nextLine();
            file = new File(filename);
            if (!file.exists()) {
                System.out.println("File specified <" + filename + "> does not exist.");
                System.out.print("Would you like to continue? <Y/N> ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    throw new FileNotFoundException("User canceled program execution.");
                }
            }
        } while (!file.exists());
        return new Scanner(file);
    }

    public static PrintWriter getOutputFile(String userPrompt) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        String filename;
        PrintWriter writer = null;
        do {
            System.out.print(userPrompt);
            filename = scanner.nextLine();
            try {
                writer = new PrintWriter(filename);
            } catch (FileNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.print("Would you like to continue? <Y/N> ");
                String choice = scanner.nextLine();
                if (!choice.equalsIgnoreCase("Y")) {
                    throw new FileNotFoundException("User canceled program execution.");
                }
            }
        } while (writer == null);
        return writer;
    }

    public static void printFileContents(Scanner scanner) {
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();
    }
}

