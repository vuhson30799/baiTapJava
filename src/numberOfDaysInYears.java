import java.util.Scanner;

public class numberOfDaysInYears {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
numberOfDayInYears();
    }
    public static void numberOfDayInYears (){
        System.out.println("Enter Beginning year and Ending year");
        int beginningYear = scanner.nextInt();
        int endingYear = scanner.nextInt();
        int count = 0;
        for (int i = beginningYear; i <= endingYear; i++) {
            if (i % 4 ==0)
                if (i % 100 == 0)
                    if (i % 400 == 0)
                      count += 365;
                    else count += 366;
                    else count += 366;
                    else count +=365;
        }
        System.out.println("The days of year from " + beginningYear + " to " + endingYear + ": " + count);
    }
}
