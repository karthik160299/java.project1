package practice;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LogandSign {

	private static final String FILENAME = "users.txt";
    private static final String REGEX_EMAIL = "^(.+)@(.+)$";
    private static final String REGEX_PASSWORD = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
    private static final Pattern PATTERN_EMAIL = Pattern.compile(REGEX_EMAIL);
    private static final Pattern PATTERN_PASSWORD = Pattern.compile(REGEX_PASSWORD);

    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Login");
            System.out.println("2. Signup");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    signup();
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
    
    private static void login() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try 
        (BufferedReader br = new BufferedReader(new FileReader("copy_txt"))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(email) && parts[1].equals(password)) {
                    System.out.println("Login successful!");
                    found = true;
                    break;
                }
            }
            if (!found) {
                System.out.println("Invalid email or password!");
            }
        } catch (IOException e) {
            System.out.println("Error reading file!");
            e.printStackTrace();
        }
    }
    private static void signup() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter email: ");
        String email = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        Matcher matcherEmail = PATTERN_EMAIL.matcher(email);
        Matcher matcherPassword = PATTERN_PASSWORD.matcher(password);

        if (matcherEmail.matches() && matcherPassword.matches()) {
            try (BufferedWriter bw = new BufferedWriter(new FileWriter("copy_txt", true))) {
                bw.write(email + "," + password + "\n");
                System.out.println("Signup successful!");
            } catch (IOException e) {
                System.out.println("Error writing file!");
                e.printStackTrace();
            }
        } else {
            System.out.println("Invalid email or password!");
        }
    }
}