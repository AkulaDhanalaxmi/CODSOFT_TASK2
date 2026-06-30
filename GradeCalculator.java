import java.util.Scanner;

public class GradeCalculator {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("========================================");
        System.out.println("      STUDENT GRADE CALCULATOR");
        System.out.println("========================================");

        int numSubjects = getIntInput("\nEnter the number of subjects: ");
        while (numSubjects <= 0) {
            System.out.println("Number of subjects must be greater than 0.");
            numSubjects = getIntInput("Enter the number of subjects: ");
        }

        double[] marks = new double[numSubjects];

        for (int i = 0; i < numSubjects; i++) {
            double mark = getDoubleInput("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            while (mark < 0 || mark > 100) {
                System.out.println("Marks must be between 0 and 100.");
                mark = getDoubleInput("Enter marks obtained in subject " + (i + 1) + " (out of 100): ");
            }
            marks[i] = mark;
        }

        double totalMarks = calculateTotalMarks(marks);
        double averagePercentage = calculateAveragePercentage(totalMarks, numSubjects);
        String grade = calculateGrade(averagePercentage);

        displayResults(totalMarks, averagePercentage, grade);

        scanner.close();
    }

    /**
     * Sums up the marks obtained in all subjects.
     */
    private static double calculateTotalMarks(double[] marks) {
        double total = 0;
        for (double mark : marks) {
            total += mark;
        }
        return total;
    }

    /**
     * Divides total marks by the number of subjects to get the average percentage.
     */
    private static double calculateAveragePercentage(double totalMarks, int numSubjects) {
        return totalMarks / numSubjects;
    }

    /**
     * Assigns a grade based on the average percentage achieved.
     */
    private static String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A+";
        } else if (averagePercentage >= 80) {
            return "A";
        } else if (averagePercentage >= 70) {
            return "B";
        } else if (averagePercentage >= 60) {
            return "C";
        } else if (averagePercentage >= 50) {
            return "D";
        } else {
            return "F";
        }
    }

    /**
     * Displays the total marks, average percentage, and corresponding grade.
     */
    private static void displayResults(double totalMarks, double averagePercentage, String grade) {
        System.out.println("\n========================================");
        System.out.println("              RESULTS");
        System.out.println("========================================");
        System.out.printf("Total Marks: %.2f%n", totalMarks);
        System.out.printf("Average Percentage: %.2f%%%n", averagePercentage);
        System.out.println("Grade: " + grade);
    }

    /**
     * Keeps asking until the user enters a valid integer.
     */
    private static int getIntInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid whole number.");
            }
        }
    }

    /**
     * Keeps asking until the user enters a valid decimal number.
     */
    private static double getDoubleInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            String line = scanner.nextLine().trim();
            try {
                return Double.parseDouble(line);
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        }
    }
}
