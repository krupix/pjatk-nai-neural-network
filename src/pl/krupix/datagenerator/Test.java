package pl.krupix.datagenerator;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

/**
 * Created by krupix on 29.12.2015.
 */
public class Test {

    public static void main(String args[]) {

        SampleDataGenerator sampleDataGenerator = new SampleDataGenerator();

        int[] indexDigitsTab = new int[]{1, 1, 5, 6, 2};
        String generatedDigit;

        try {
            PrintWriter out = new PrintWriter("/Users/krupix/KruPiX/dev/git/pjwstk-nai-shit/test/test_data.txt");
            for (int  i = 0; i < 100; i++) {
                generatedDigit = sampleDataGenerator.generate(indexDigitsTab);
                System.out.println("Generated => " + generatedDigit);
//                out.println(generatedDigit + " 1");
                out.println(generatedDigit);
            }

            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }



    }


}
