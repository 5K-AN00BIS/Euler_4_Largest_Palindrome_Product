/*
    Ryan Bachman

    Altered version of https://www.geeksforgeeks.org/largest-palindrome-product-two-n-digit-numbers/

    A palindromic number reads the same both ways. The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 × 99.

    Find the largest palindrome made from the product of two 3-digit numbers.
 */

import java.util.Scanner; // Allow user input.

import static java.lang.Integer.reverse;

public class LargestPalindromeProduct
{
    // Function to print out the largest palindrome on the user specified amount of digits.
    static int largestPalindrome(int digits)
    {
        int upperLimit = 0;
        int num1 = 0;
        int num2 = 0;

        // Use a for loop to calculate the upper bound which is the largest digit of the integer argument.
        for (int i = 1; i <= digits; i++)
        {
            upperLimit *= 10;
            upperLimit += 9;
        }

        // Largest number of n-1 digits.
        // One plus this number is lower limit which is product of two numbers.
        int lowerLimit = 1 + upperLimit / 10;

        // Initialize the result.
        int max = 0;

        for (int i = upperLimit; i >= lowerLimit; i--)
        {
            for (int j = i; j >= lowerLimit; j--)
            {
                // Calculate the product of two n-digit numbers.
                int product = i * j;

                if (product < max)
                {
                    break;
                }

                int number = product;
                int reverse = 0;

                // Calculating reverse of product to check whether it is palindrome or not.
                while (number != 0)
                {
                    reverse = reverse * 10 + number % 10;
                    number /= 10;
                }

                // Update new product if exists and if greater than previous.
                if (product == reverse && product > max)
                {
                    // Set the max to product, which is the highest palindrome product.
                    max = product;
                    // Set num1 and num2 to i and j so we can report back the largest n-digit multiples.
                    num1 = i;
                    num2 = j;
                }
            }
        }

        // Output the n-digit multiples and return max so that it can be used.
        System.out.println("The " + digits + " digit multiplier to get the largest palindrome is " + num1 + " x " + num2 + ".");
        return max;
    }

    // Main function.
    public static void main(String[] args)
    {
        // Get input from the user with how many digits they want to find the palindrome of.
        int digits = 0;
        Scanner getDigits = new Scanner(System.in);
        System.out.print("Please enter the number of digits to find the largest palindrome of: ");
        digits = getDigits.nextInt();

        // Print out to the user.
        System.out.println("The largest palindrome is " + largestPalindrome(digits) + ".");
    }
}