import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Candidate {
    private static final String FILE_NAME = "StudentData.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BufferedWriter writer = null;
        BufferedReader reader = null;

        try {
            writer = new BufferedWriter(new FileWriter(FILE_NAME, true));
            reader = new BufferedReader(new FileReader(FILE_NAME));

            System.out.println("Welcome to Student Data Management System");

            while (true) {
                System.out.println("\nMENU:");
                System.out.println("1. Add Student Data");
                System.out.println("2. Show Data");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        addStudentData(scanner, writer);
                        writer.close(); // Close the writer after writing data
                        break;
                    case 2:
                        // Close the previous reader before creating a new one
                        if (reader != null) {
                            reader.close();
                        }
                        reader = new BufferedReader(new FileReader(FILE_NAME)); // Create a new reader
                        showStudentData(reader);
                        break;
                    case 3:
                        System.out.println("Exit Done.");
                        if (writer != null) {
                            writer.close();
                        }
                        if (reader != null) {
                            reader.close();
                        }
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void addStudentData(Scanner scanner, BufferedWriter writer) throws IOException {
        System.out.println("Enter details for the student:");

        System.out.print("Name: ");
        String name = scanner.next();

        System.out.print("Roll Number: ");
        int rollNumber = scanner.nextInt();

        System.out.print("Marks in Math: ");
        int mathMarks = scanner.nextInt();

        System.out.print("Marks in Science: ");
        int scienceMarks = scanner.nextInt();

        System.out.print("Marks in English: ");
        int englishMarks = scanner.nextInt();

        System.out.print("Marks in Computer: ");
        int computerMarks = scanner.nextInt();

        System.out.print("Marks in GK: ");
        int gkMarks = scanner.nextInt();

        // Write student data to file
        writer.write(name + "," + rollNumber + "," + mathMarks + "," + scienceMarks + "," + englishMarks
                + "," + computerMarks + "," + gkMarks);
        writer.newLine();

        System.out.println("Student data added successfully.");
    }

    private static void showStudentData(BufferedReader reader) throws IOException {
        System.out.println("Student Data:");

        String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            System.out.println("Name: " + data[0]);
            System.out.println("Roll Number: " + data[1]);
            System.out.println("Math Marks: " + data[2]);
            System.out.println("Science Marks: " + data[3]);
            System.out.println("English Marks: " + data[4]);
            System.out.println("Computer Marks: " + data[5]);
            System.out.println("GK Marks: " + data[6]);
            System.out.println();
        }
    }
}
