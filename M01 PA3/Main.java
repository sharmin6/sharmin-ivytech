//NOTE: This programs ONLY allows 9 numbers to be enter to check wheather List1 is identical to List2.

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int[][] list1 = new int[3][3];
        int[][] list2 = new int[3][3];
        
        System.out.print("Enter list1: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list1[i][j] = scanner.nextInt();
            }
        }
        
        System.out.print("Enter list2: ");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                list2[i][j] = scanner.nextInt();
            }
        }
        
        if (equals(list1, list2)) {
            System.out.println("The two arrays are identical");
        } 
        
        else {
            System.out.println("The two arrays are not identical");
        }
        
        scanner.close();
    }
    
    public static boolean equals(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            return false;
        }
        
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[0].length; j++) {
                if (m1[i][j] != m2[i][j]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}

