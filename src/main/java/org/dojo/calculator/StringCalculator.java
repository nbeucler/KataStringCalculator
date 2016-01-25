package org.dojo.calculator;

import java.util.ArrayList;
import java.util.List;

public class StringCalculator {

    public int add(String s) {
        String delimiter = ",|\n";
        boolean hasNegativeNumbers = false;
        List<Integer> negativeNumbers = new ArrayList<Integer>();

        if ("".equals(s)) {
            return 0;
        }

        if (s.startsWith("//")) {
            int indexOf = s.indexOf("\\n");
            delimiter = s.substring(2, indexOf);
            s = s.substring(indexOf + 2);
        }

        String[] numbers = s.split(delimiter);
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = Integer.parseInt(numbers[i]);
            if (number < 0) {
                hasNegativeNumbers = true;
                negativeNumbers.add(number);
            }
            sum += number;
        }

        if (hasNegativeNumbers) {
            throw new RuntimeException("Negatives not allowed:" + negativeNumbers.toString());
        }
        return sum;
    }
}
