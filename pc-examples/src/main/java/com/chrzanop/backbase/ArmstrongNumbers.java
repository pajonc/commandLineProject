package com.chrzanop.backbase;

public class ArmstrongNumbers {


        public static void main(String[] args) {
            int num = 153, originalNum = num, sum = 0;
            int digits = 0;

            // Count number of digits
            while (num != 0) {
                num /= 10;
                digits++;
            }

            num = originalNum;
            // Check Armstrong condition
            while (num != 0) {
                int digit = num % 10;
                sum += Math.pow(digit, digits);
                num /= 10;
            }

            // Output result
            if (sum == originalNum)
                System.out.println(originalNum + " is an Armstrong number.");
            else
                System.out.println(originalNum + " is not an Armstrong number.");
        }

}
