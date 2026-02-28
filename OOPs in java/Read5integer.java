import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;
public class Read5integer{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        for (int i = 1; i <= 5; ) {
            System.out.println("enter integer");
            try {
                int number = scanner.nextInt();
                sum += number;
                i++;   // increase only for valid input
            }

            catch (InputMismatchException e) {
                System.out.println("Invalid input. That is not a valid integer.");
                scanner.next(); // clear wrong input
            }

            catch (IllegalStateException e) {
                System.out.println("Scanner is closed.");
                break;
            }

            catch (NoSuchElementException e) {
                System.out.println("No more input available.");
                break;
            }
        }
        System.out.println("Sum = " + sum);
        scanner.close();
    }
}