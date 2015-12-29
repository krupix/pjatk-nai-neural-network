package pl.krupix.nai.utils;

/**
 * Created by krupix on 28.12.2015.
 */
public class Utils {

    public static String tabToString(int[] integerTab) {

        String result = "[ ";

        for (int i : integerTab) {
            result += i + " ";
        }

        return result + "]";
    }

    public static String tabToString(float[] integerTab) {

        String result = "[ ";

        for (float i : integerTab) {
            result += i + " ";
        }

        return result + "]";
    }
}
