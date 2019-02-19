package basics.test;

import java.util.Scanner;

public class Basics {
    public static void basics() {
        String str1 = "Hello";
        String str2 = "Hello";
        // On compilation, before assigning str2, Java will see that it is equal to str1 so both will share the same memory
        if(str1 == str2)
            System.out.println("Matched");
        else
            System.out.println("Not matched");
        // No same string so new variable is assigned to str3
        String str3 = "hello";

        if(str1 == str3)
            System.out.println("Matched");
        else
            System.out.println("Not matched");

        // Issue with this is that
        String part1 = "Hello ";
        String part2 = "World";
        String part3 = part1 + part2;
        String part4 = "Hello World";

        if(part3 == part4)
            System.out.println("Matched");
        else
            System.out.println("Not matched");

        String[] months = {
                "Jan", "Feb", "Mar"
        };

        for (String month: months) {
            System.out.println(month);
        }

        Scanner s = new Scanner(System.in);
        Integer s1 = s.nextInt();
        // assert throws exceptions when it is false but only on debug modes
        // Needs to be explicitly enabled with -ea in VM and not used as such
        // assert checkInput(s1 is integer: true/false);
    }

    // result = testStatement ? value1 : value2; ternary example

    // Indeterminate number of arguments
    public static double add(String ... values) {
        double result = 0;
        for (String value: values) {
            result += Double.parseDouble(value);
        }
        return result;
    }
}
