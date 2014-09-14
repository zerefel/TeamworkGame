
package javaexamprep;

import java.util.Scanner;

public class LargestThreeRectangles {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] numbers = input.split("\\D+");

        for (int i = 1; i < numbers.length - 1; i++) { 
            int sideA = Integer.parseInt(numbers[i]);
            int sideB = Integer.parseInt(numbers[i + 1]);
            int area = sideA * sideB;
        }
    }
}
