import java.util.Scanner;

public class RabbitProblem {

    // Calculate Rabbit Pairs
    public static int calculateRabbits(int month) {

        if (month == 1 || month == 2) {
            return 1;
        }

        return calculateRabbits(month - 1)
                + calculateRabbits(month - 2);
    }

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of months: ");
        int months = input.nextInt();

        if (months <= 0) {
            System.out.println("Invalid number of months");
        } else {

            int rabbits = calculateRabbits(months);

            System.out.println("Number of rabbit pairs after "
                    + months + " months: " + rabbits);
        }

        input.close();
    }
}
