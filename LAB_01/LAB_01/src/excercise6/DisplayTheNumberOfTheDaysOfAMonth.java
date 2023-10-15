package excercise6;

import java.util.Scanner;

public class DisplayTheNumberOfTheDaysOfAMonth {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Get user input for month
        String inputMonth;
        int month;
        do {
            System.out.print("Enter a month (full name, abbreviation, in 3 letters, or number): ");
            inputMonth = sc.nextLine().toLowerCase();
            month = getMonthNumber(inputMonth);
        } while (month == -1);

        // Get user input for year
        int year;
        do {
            System.out.print("Enter a year (non-negative number with all digits): ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a valid year.");
                sc.next(); // consume the invalid input
            }
            year = sc.nextInt();
            sc.nextLine(); // consume the newline character
        } while (year < 0);

        // Check for leap year
        boolean isLeapYear = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);

        // Calculate and display the number of days in the entered month
        int days = getDaysInMonth(month, isLeapYear);
        System.out.println("Number of days in " + getMonthName(month) + " " + year + ": " + days);

        // Close the scanner
        sc.close();
    }

    private static int getMonthNumber(String inputMonth) {
        String[] months = {"january", "february", "march", "april", "may", "june", "july", "august", "september",
                "october", "november", "december"};

        for (int i = 0; i < months.length; i++) {
            if (inputMonth.equals(months[i]) || inputMonth.equals(months[i].substring(0, 3)) || inputMonth.equals(Integer.toString(i + 1))) {
                return i + 1;
            }
        }

        System.out.println("Invalid month. Please enter a valid month.");
        return -1;
    }

    private static String getMonthName(int month) {
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September",
                "October", "November", "December"};

        return months[month - 1];
    }

    private static int getDaysInMonth(int month, boolean isLeapYear) {
        if (month == 2) {
            return isLeapYear ? 29 : 28;
        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30;
        } else {
            return 31;
        }
    }
}
