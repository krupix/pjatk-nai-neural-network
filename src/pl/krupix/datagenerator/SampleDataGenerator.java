package pl.krupix.datagenerator;

import pl.krupix.nai.utils.Utils;

import java.util.Random;

/**
 * Created by krupix on 29.12.2015.
 */
public class SampleDataGenerator {


    public String generate(int[] indexDigitsTab) {

        String result = "";

        for (int indexDigit : indexDigitsTab) {

            result += generateDigit(indexDigit) + " ";

        }

        return result;
    }


    public String generateDigit(int digit) {

        int[] digitTab = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};

        while (digit != getDigitTabSum(digitTab)) {

            int pos = new Random().nextInt(9);

            digitTab[pos] = 1;

        }

        return tabToString(digitTab);

    }


    private int getDigitTabSum(int[] digitTab) {

        int sum = 0;

        for (int digit : digitTab) {
            sum += digit;
        }

        return sum;
    }


    public static String tabToString(int[] integerTab) {

        String result = "";

        for (int i : integerTab) {
            result += i + " ";
        }

        return result + "";
    }
}
