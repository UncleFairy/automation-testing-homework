package com.company;

import java.util.Objects;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Exercise #1

        Scanner in = new Scanner(System.in);

        System.out.print("Enter a degree in Celsius: ");
        int celsius = in.nextInt();

        double fahrenheit = (9.0 / 5) * celsius + 32;

        System.out.println(celsius + " Celsius is " + fahrenheit + " Fahrenheit");

        //Exercise #2

        int r, sum = 0, temp;

        System.out.print("Enter a three-digit integer: ");
        int num = in.nextInt();

        temp = num;
        while (num > 0) {
            r = num % 10;
            sum = (sum * 10) + r;
            num = num / 10;
        }
        if (temp == sum)
            System.out.println(temp + " is a palindrome");
        else
            System.out.println(temp + " is not a palindrome");

        //Exercise #3

        in.nextLine();
        System.out.print("Enter a string: ");
        String sentence = in.nextLine();
        int countVowels = 0;
        int countSpaces = 0;
        int sentenceLength = sentence.length();

        for (int i = 0; i < sentence.length(); i++) {
            char ch = sentence.charAt(i);
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                countVowels++;
            }
        }

        for (char c : sentence.toCharArray()) {
            if (c == ' ') {
                countSpaces++;
            }
        }

        System.out.println("The number of vowels  is " + countVowels);
        System.out.println("The number of consonants  is " + (sentenceLength - countVowels - countSpaces));


        //Exercise 4

        System.out.print("Enter a integer: ");
        int integerNumber = in.nextInt();

        System.out.println(isPalindrome(integerNumber));


        //Exercise "PAINT JOB"

        System.out.print("Enter a width: ");
        double width = in.nextDouble();

        System.out.print("Enter a height: ");
        double height = in.nextDouble();

        System.out.print("Enter a areaPerBucket: ");
        double areaPerBucket = in.nextDouble();

        System.out.print("Enter extraBuckets: ");
        double extraBuckets = in.nextDouble();

        System.out.print("Enter a area: ");
        double area = in.nextDouble();

        System.out.println(getBucketCount(width, height, areaPerBucket));
        System.out.println(getBucketCount(area, areaPerBucket));
        System.out.println(getBucketCount(width, height, areaPerBucket, extraBuckets));

        in.close();
    }

    //Exercise #4

    public static int reverse(int number) {
        int digit, reverseNumber = 0;

        while (number > 0) {
            digit = number % 10;
            reverseNumber = (reverseNumber * 10) + digit;
            number = number / 10;
        }

        return reverseNumber;
    }

    public static boolean isPalindrome(int number) {
        int reverseNumber = reverse(number);

        return !!(reverseNumber == number);
    }

    //Exercise "PAINT JOB"

    public static int getBucketCount(double width, double height, double areaPerBucket, double extraBuckets) {
        if (width < 0 || height < 0 || areaPerBucket < 0 || extraBuckets < 0) return -1;

        if(Objects.isNull(extraBuckets)) extraBuckets = 0;

        double paintArea = width*height;
        double countNeedBucket = paintArea / areaPerBucket;

        return (int)Math.ceil(countNeedBucket - extraBuckets);
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        if (width < 0 || height < 0 || areaPerBucket < 0) return -1;

        double extraBuckets = 0;

        double paintArea = width*height;
        double countNeedBucket = paintArea / areaPerBucket;

        return (int)Math.ceil(countNeedBucket - extraBuckets);
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        if (area < 0 && areaPerBucket < 0) return -1;

        double countNeedBucket = area / areaPerBucket;

        return (int)Math.ceil(countNeedBucket);
    }

}
