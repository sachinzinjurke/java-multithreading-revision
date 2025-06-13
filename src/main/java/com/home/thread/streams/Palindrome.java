package com.home.thread.streams;

import java.util.Scanner;

public class Palindrome {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                // Input from user
                System.out.print("Enter a string: ");
                String input = scanner.nextLine();

                // Remove spaces and convert to lowercase for uniformity
                String cleanedInput = input.replaceAll("\\s+", "").toLowerCase();

                // Check if the string is a palindrome
                if (isPalindrome(cleanedInput)) {
                    System.out.println("The string \"" + input + "\" is a palindrome.");
                } else {
                    System.out.println("The string \"" + input + "\" is not a palindrome.");
                }

                scanner.close();
            }

            // Method to check if a string is a palindrome
            public static boolean isPalindrome(String str) {
                int left = 0;
                int right = str.length() - 1;

                while (left < right) {
                    if (str.charAt(left) != str.charAt(right)) {
                        return false;
                    }
                    left++;
                    right--;
                }
                return true;
            }
}
