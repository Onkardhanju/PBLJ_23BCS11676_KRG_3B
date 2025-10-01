import java.util.ArrayList;
import java.util.Scanner;

public class que1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> numbers = new ArrayList<>();

        System.out.println("Enter numbers (type 'done' to finish):");

        while (true) {
            String input = scanner.next();
            if (input.equalsIgnoreCase("done")) {
                break;
            }

            try {
                int num = Integer.parseInt(input);
                numbers.add(num);
            } catch (NumberFormatException e) {
                System.out.println("Error: Invalid input, please enter a valid integer.");
            }
        }

        try {
            if (numbers.size() == 0) {
                throw new ArithmeticException("List is empty. Cannot calculate average.");
            }

            int sum = 0;
            for (int num : numbers) {
                sum += num;
            }

            double average = (double) sum / numbers.size();
            System.out.println("Average: " + average);

        } catch (ArithmeticException e) {
            System.out.println("Error: " + e.getMessage());
        }

        scanner.close();
    }
}
