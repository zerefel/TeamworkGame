
package javaexamprep;

import java.io.PrintStream;
import java.util.Scanner;

public class JavaExamPrep {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int totalHours = 0;
        int totalMinutes = 0;
        
        while (true) {            
            String input = sc.nextLine();
            if (input.equals("End")) {
                break;
            }
            String[] parts = input.split(":");
            int hours = Integer.parseInt(parts[0]);
            int minutes = Integer.parseInt(parts[1]);
            totalHours += hours;

        }
        totalHours += totalMinutes / 60;
        totalMinutes %= 60;
        System.out.printf("%d:%02d", totalHours, totalMinutes);
    }
}
