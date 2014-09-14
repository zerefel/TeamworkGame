
package javaexamprep;

import java.util.Scanner;


public class PythagoreanNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] numbers = new int[n];
        
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = sc.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (i >= n - 3) {
                        return;
                    }
                    int a = numbers[i];
                    int b = numbers[j];
                    int c = numbers[k];
                    if (a < b && (a*a + b*b) == (c*c)) {
                        System.out.println(numbers[i] + "*" + numbers[i] + numbers[j] + "*" + numbers[j] + "=" + numbers[k] + "*" + numbers[k]);
                    }
                }
            }
        }
    }
}
