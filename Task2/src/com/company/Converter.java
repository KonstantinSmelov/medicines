package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Converter {

    public static String decToHex(int input) {
        List<String> out = new ArrayList<>();
        decToHexRecursion(input, out);
        Collections.reverse(out);
        return out.toString();
    }
    private static void decToHexRecursion(Integer input, List<String> result) {
        if (input < 16) {
            result.add(input.toString());
            return;
        }

        Integer inputTmp = input;

        input = input / 16;
        Integer resultTmp = inputTmp - (input * 16);

        if (resultTmp < 10) {
            result.add(resultTmp.toString());
        } else {

            switch (resultTmp) {
                case 10:
                    result.add("A");
                    break;
                case 11:
                    result.add("B");
                    break;
                case 12:
                    result.add("C");
                    break;
                case 13:
                    result.add("D");
                    break;
                case 14:
                    result.add("E");
                    break;
                case 15:
                    result.add("F");
                    break;
            }
        }
        decToHexRecursion(input, result);
    }


    public static String decToBin(int input) {
        List<Integer> out = new ArrayList<>();
        decToBinRecursion(input, out);
        Collections.reverse(out);
        return out.toString();
    }
    private static void decToBinRecursion(Integer input, List<Integer> result) {
        if (input < 2) {
            result.add(input);
            return;
        }

        Integer inputTmp = input;

        input = input / 2;
        Integer resultTmp = inputTmp - (input * 2);

        result.add(resultTmp);
        decToBinRecursion(input, result);
    }
}
