import java.io.FileReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class NGramUtils {

    final public HashMap<Character, Integer> characterSetValues = new HashMap<>();
    final public char[] letterOptions = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public void printRowHeader() {
        for (HashMap.Entry<Character, Integer> entry : characterSetValues.entrySet()) {

            // Format Output with equal column sizes
            String numTabs = "";
            char tabChar = ' ';
            int number = 14;
            char[] repeatCount = new char[number];
            Arrays.fill(repeatCount, tabChar);
            numTabs += new String(repeatCount);

            System.out.print(entry.getKey() + numTabs);
        }
    }

    public void initializeCharacterValue(){
        characterSetValues.put('a', 0);
        characterSetValues.put('b', 1);
        characterSetValues.put('c', 2);
        characterSetValues.put('d', 3);
        characterSetValues.put('e', 4);
        characterSetValues.put('f', 5);
        characterSetValues.put('g', 6);
        characterSetValues.put('h', 7);
        characterSetValues.put('i', 8);
        characterSetValues.put('j', 9);
        characterSetValues.put('k', 10);
        characterSetValues.put('l', 11);
        characterSetValues.put('m', 12);
        characterSetValues.put('n', 13);
        characterSetValues.put('o', 14);
        characterSetValues.put('p', 15);
        characterSetValues.put('q', 16);
        characterSetValues.put('r', 17);
        characterSetValues.put('s', 18);
        characterSetValues.put('t', 19);
        characterSetValues.put('u', 20);
        characterSetValues.put('v', 21);
        characterSetValues.put('w', 22);
        characterSetValues.put('x', 23);
        characterSetValues.put('y', 24);
        characterSetValues.put('z', 25);
    }

    public void format2DArrayInt(int[][] array) {
        int rowCount = 0;
        for (int[] x : array) {
            System.out.print(letterOptions[rowCount] +" ");
            ++rowCount;
            format1DArrayInt(x);
            System.out.println();
        }
    }

    public void format2DProbOutputDouble(double[][] array) {
        int rowCount = 0;
        for (double[] x : array) {
            System.out.print(letterOptions[rowCount] +" ");
            ++rowCount;
            format1DProbDouble(x);
            System.out.println();
        }
    }

    public void format1DArrayInt(int[] array) {

        for (int y : array) {
            // Format Output with equal column sizes
            int length = 1;
            int tempNum = y;
            while(tempNum/10>0) {
                tempNum /= 10;
                ++length;
            }
            String numTabs = "";
            char tabChar = ' ';
            int number = 15-length;
            char[] repeatCount = new char[number];
            Arrays.fill(repeatCount, tabChar);
            numTabs += new String(repeatCount);

            System.out.print(y + numTabs);
        }
    }

    public void format1DProbDouble(double[] array) {

        for (double y : array) {
            double tempNum = y;
            DecimalFormat numberFormat = new DecimalFormat("#.######");
            String stringNum = numberFormat.format(tempNum);

            String numTabs = "";
            char tabChar = ' ';
            int number = 15-stringNum.length();
            char[] repeatCount = new char[number];
            Arrays.fill(repeatCount, tabChar);
            numTabs += new String(repeatCount);

            System.out.print(stringNum + numTabs);
        }
    }
}