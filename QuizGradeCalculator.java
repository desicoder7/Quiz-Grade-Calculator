import java.util.Scanner;

/**
 * QuizGradeCalculator - A Java program for calculating student quiz grades
 * 
 * This program allows students to enter up to 10 quiz scores, calculates the 
 * average score, and displays the corresponding letter grade based on a 
 * standard grading scale.
 * 
 * Features:
 * - Input validation for quiz scores
 * - Dynamic grade entry (up to 10 grades or enter 999 to quit)
 * - Grade storage in an array
 * - Average calculation
 * - Letter grade determination using decision logic
 * 
 * Grading Scale:
 * A = 90-100, B = 80-89, C = 70-79, D = 60-69, F = 0-59
 * 
 * @author Student Name
 * @version 1.0
 * @date February 22, 2026
 */
public class QuizGradeCalculator {
    
    // Constants for program configuration
    private static final int MAX_GRADES = 10;
    private static final int QUIT_VALUE = 999;
    private static final int MIN_SCORE = 0;
    private static final int MAX_SCORE = 100;
    
    /**
     * Step 1: Prints the programming specifications for the project
     * 
     * This method displays a clear overview of what the program does,
     * including its purpose, functionality, and grading scale used.
     */
    public static void printSpecifications() {
        System.out.println("=".repeat(70));
        System.out.println("           QUIZ GRADE CALCULATOR - PROGRAM SPECIFICATIONS");
        System.out.println("=".repeat(70));
        System.out.println();
        System.out.println("Program Purpose:");
        System.out.println("  This program calculates the average quiz grade for a student");
        System.out.println("  and determines the corresponding letter grade.");
        System.out.println();
        System.out.println("Program Functionality:");
        System.out.println("  1. Accepts up to " + MAX_GRADES + " quiz scores from the user");
        System.out.println("  2. User can enter " + QUIT_VALUE + " to stop entering grades early");
        System.out.println("  3. Validates that scores are between " + MIN_SCORE + " and " + MAX_SCORE);
        System.out.println("  4. Displays all entered quiz grades");
        System.out.println("  5. Calculates the average of all quiz grades");
        System.out.println("  6. Determines and displays the letter grade");
        System.out.println();
        System.out.println("Grading Scale:");
        System.out.println("  A = 90-100");
        System.out.println("  B = 80-89");
        System.out.println("  C = 70-79");
        System.out.println("  D = 60-69");
        System.out.println("  F = 0-59");
        System.out.println();
        System.out.println("=".repeat(70));
        System.out.println();
    }
    
    /**
     * Step 2 & 3: Inputs quiz grades from the user and populates the array
     * 
     * This method uses a loop to continuously accept grade input from the user.
     * The loop terminates when either 10 grades are entered or the user enters
     * the quit value (999). Each valid grade is stored in the array and added
     * to the running total.
     * 
     * @param scanner Scanner object for reading user input
     * @param grades Array to store the quiz grades
     * @return The count of grades entered by the user
     */
    public static int inputGrades(Scanner scanner, double[] grades) {
        int count = 0;
        double runningTotal = 0.0;
        
        System.out.println("Enter your quiz grades (0-100)");
        System.out.println("Enter " + QUIT_VALUE + " to finish entering grades");
        System.out.println();
        
        // Loop to input grades - continues until MAX_GRADES or user enters QUIT_VALUE
        while (count < MAX_GRADES) {
            System.out.print("Enter quiz grade #" + (count + 1) + ": ");
            
            // Input validation - ensure user enters a valid number
            if (!scanner.hasNextDouble()) {
                System.out.println("Error: Please enter a valid number.");
                scanner.next(); // Clear invalid input
                continue;
            }
            
            double grade = scanner.nextDouble();
            
            // Check if user wants to quit
            if (grade == QUIT_VALUE) {
                System.out.println("Grade entry stopped by user.");
                break;
            }
            
            // Validate grade is within acceptable range
            if (grade < MIN_SCORE || grade > MAX_SCORE) {
                System.out.println("Error: Grade must be between " + MIN_SCORE + 
                                 " and " + MAX_SCORE + ". Please try again.");
                continue;
            }
            
            // Store grade in array and update running total
            grades[count] = grade;
            runningTotal += grade;
            count++;
            
            System.out.println("Grade recorded successfully.");
            System.out.println();
        }
        
        // Inform user if maximum grades reached
        if (count == MAX_GRADES) {
            System.out.println("Maximum number of grades (" + MAX_GRADES + ") reached.");
        }
        
        return count;
    }
    
    /**
     * Step 4: Displays all grades entered by the user
     * 
     * This method uses a loop to iterate through the array and print
     * each quiz grade that was entered by the user.
     * 
     * @param grades Array containing the quiz grades
     * @param count Number of grades actually entered
     */
    public static void displayGrades(double[] grades, int count) {
        System.out.println();
        System.out.println("=".repeat(70));
        System.out.println("                        YOUR QUIZ GRADES");
        System.out.println("=".repeat(70));
        
        // Loop through array to display each grade
        for (int i = 0; i < count; i++) {
            System.out.printf("Quiz #%d: %.2f%n", (i + 1), grades[i]);
        }
        
        System.out.println("=".repeat(70));
    }
    
    /**
     * Step 5: Calculates the average of all quiz grades
     * 
     * This method computes the average by summing all grades in the array
     * and dividing by the count of grades entered.
     * 
     * @param grades Array containing the quiz grades
     * @param count Number of grades actually entered
     * @return The average quiz grade
     */
    public static double calculateAverage(double[] grades, int count) {
        // Handle edge case where no grades were entered
        if (count == 0) {
            return 0.0;
        }
        
        double sum = 0.0;
        
        // Sum all grades in the array
        for (int i = 0; i < count; i++) {
            sum += grades[i];
        }
        
        // Calculate and return average
        return sum / count;
    }
    
    /**
     * Step 6: Determines the letter grade based on the average score
     * 
     * This method uses decision logic (if-else statements) to determine
     * the appropriate letter grade based on the standard grading scale.
     * 
     * @param average The average quiz grade
     * @return The corresponding letter grade (A, B, C, D, or F)
     */
    public static char determineLetterGrade(double average) {
        char letterGrade;
        
        // Decision logic to determine letter grade
        if (average >= 90.0) {
            letterGrade = 'A';
        } else if (average >= 80.0) {
            letterGrade = 'B';
        } else if (average >= 70.0) {
            letterGrade = 'C';
        } else if (average >= 60.0) {
            letterGrade = 'D';
        } else {
            letterGrade = 'F';
        }
        
        return letterGrade;
    }
    
    /**
     * Displays the final results including average and letter grade
     * 
     * @param average The calculated average quiz grade
     * @param letterGrade The determined letter grade
     */
    public static void displayResults(double average, char letterGrade) {
        System.out.println();
        System.out.println("=".repeat(70));
        System.out.println("                         FINAL RESULTS");
        System.out.println("=".repeat(70));
        System.out.printf("Average Quiz Grade: %.2f%n", average);
        System.out.println("Letter Grade: " + letterGrade);
        System.out.println("=".repeat(70));
        System.out.println();
        
        // Provide encouraging feedback based on grade
        if (letterGrade == 'A') {
            System.out.println("Excellent work! Keep up the outstanding performance!");
        } else if (letterGrade == 'B') {
            System.out.println("Great job! You're doing well!");
        } else if (letterGrade == 'C') {
            System.out.println("Good effort! Keep working to improve!");
        } else if (letterGrade == 'D') {
            System.out.println("You're passing, but consider seeking additional help.");
        } else {
            System.out.println("Please seek assistance to improve your performance.");
        }
    }
    
    /**
     * Main method - Entry point of the program
     * 
     * This method orchestrates the entire program flow by calling each
     * of the helper methods in the proper sequence to accomplish the
     * program's objectives.
     * 
     * @param args Command line arguments (not used)
     */
    public static void main(String[] args) {
        // Create Scanner for user input
        Scanner scanner = new Scanner(System.in);
        
        // Create array to store quiz grades
        double[] quizGrades = new double[MAX_GRADES];
        
        try {
            // Step 1: Display program specifications
            printSpecifications();
            
            // Step 2 & 3: Input and populate grades array
            int gradeCount = inputGrades(scanner, quizGrades);
            
            // Verify at least one grade was entered
            if (gradeCount == 0) {
                System.out.println();
                System.out.println("No grades were entered. Program terminating.");
                return;
            }
            
            // Step 4: Display all entered grades
            displayGrades(quizGrades, gradeCount);
            
            // Step 5: Calculate average grade
            double averageGrade = calculateAverage(quizGrades, gradeCount);
            
            // Step 6: Determine letter grade
            char letterGrade = determineLetterGrade(averageGrade);
            
            // Display final results
            displayResults(averageGrade, letterGrade);
            
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // Close scanner to prevent resource leak
            scanner.close();
            System.out.println("Thank you for using the Quiz Grade Calculator!");
        }
    }
}
