import java.util.ArrayList;
import java.util.Scanner;

public class GradeManager {
    private ArrayList<Integer> grades; // Data storage for grades
    private Scanner scanner; // Input scanner

    // Constructor initializes the data storage and scanner
    public GradeManager() {
        this.grades = new ArrayList<>();
        this.scanner = new Scanner(System.in);
    }

    // Method to add a grade to the data storage
    public void addGrade(int grade) {
        grades.add(grade);
    }

    // Bubble Sort algorithm to sort grades in ascending order
    public void bubbleSort() {
        int n = grades.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (grades.get(j) > grades.get(j + 1)) {
                    int temp = grades.get(j);
                    grades.set(j, grades.get(j + 1));
                    grades.set(j + 1, temp);
                }
            }
        }
    }

    // Binary Search algorithm to find a grade
    public boolean binarySearch(int grade) {
        int low = 0;
        int high = grades.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = grades.get(mid);

            if (midVal == grade) {
                return true; // Grade found
            } else if (midVal < grade) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false; // Grade not found
    }

    // Interaction with the user: add grades, search for grades, display grades
    public void interactWithUser() {
        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1. Add a grade");
            System.out.println("2. Search for a grade");
            System.out.println("3. Finish editing and display grades");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    System.out.println("Enter grade to add:");
                    int newGrade = Integer.parseInt(scanner.nextLine());
                    addGrade(newGrade); // Encapsulation: Grade addition encapsulated within a method
                    System.out.println(newGrade + " added to the grades.");
                    break;
                case "2":
                    System.out.println("Enter grade to search for:");
                    int searchGrade = Integer.parseInt(scanner.nextLine());
                    if (binarySearch(searchGrade)) {
                        System.out.println("Grade " + searchGrade + " found.");
                    } else {
                        System.out.println("Grade " + searchGrade + " not found.");
                    }
                    break;
                case "3":
                    bubbleSort(); // Encapsulation: Sorting encapsulated within a method
                    System.out.println("Sorted Grades:");
                    for (int grade : grades) {
                        System.out.println(grade);
                    }
                    scanner.close(); // Encapsulation: Resource closing encapsulated within a method
                    return;
                default:
                    System.out.println("Invalid input. Please choose 1, 2, or 3.");
            }
        }
    }

    // Main method to start the program
    public static void main(String[] args) {
        System.out.println("\u001B[96m== Grade Manager ==\u001B[0m"); // Title for the Grade Manager
        GradeManager gradeManager = new GradeManager(); // Instantiation: Object creation using the class constructor
        gradeManager.interactWithUser(); // Encapsulation: Interaction encapsulated within a method
    }
}
