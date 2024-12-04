package advent.days;

import advent.Helpers;

import java.util.ArrayList;
import java.util.List;

public class Day3 {

    public static boolean doEnabled = true;
    public static boolean nextDo;

    public static void solvePart1(){

        String message = Helpers.parseFileOneString("inputs/day3.txt");

        String correct = "mul\\(";
        String[] messageSplit = message.split(correct);

        int finalAnswer = 0;

        for(String string : messageSplit){
            System.out.println("mul(" + string);

            int result = isThereAMulHerePart1("mul(" + string);
            if(result != -1){
                finalAnswer += result;
            }
        }

        System.out.println(finalAnswer);

    }

    public static void solvePart2(){

        String message = Helpers.parseFileOneString("inputs/day3.txt");

        String correct = "mul\\(";
        String[] messageSplit = message.split(correct);

        int finalAnswer = 0;

        for(String string : messageSplit){
            System.out.println("mul(" + string);

            int result = isThereAMulHerePart2("mul(" + string);
            if(result != -1 && doEnabled){
                finalAnswer += result;
            }
            doEnabled = nextDo;
        }

        System.out.println(finalAnswer);
    }

    public static int isThereAMulHerePart1(String string){

        int commaIndex = 0;
        String number1 = "";
        String number2 = "";

        for(int index=4;index<string.length();index++){
            System.out.print(string.charAt(index));

            if(!(Character.isDigit(string.charAt(index)) || string.charAt(index) == ',' || string.charAt(index) == ')')){
                System.out.println(" TERMINATED");
                return -1;
            }

            if(string.charAt(index) == ','){
                number1 = string.substring(4, index);
                commaIndex = index;
            }

            if(string.charAt(index) == ')'){
                number2 = string.substring(commaIndex + 1, index);
                System.out.println(" TERMINATED");
                int finalAnswer = Integer.parseInt(number1) * Integer.parseInt(number2);
                System.out.println("FINAL ANSWER: " + finalAnswer);

                return finalAnswer;
            }
        }
        System.out.println(" TERMINATED");
        return -1;
    }
    public static int isThereAMulHerePart2(String string){

        int commaIndex = 0;
        String number1 = "";
        String number2 = "";

        for(int index=4;index<string.length();index++){
            System.out.print(string.charAt(index));

            if(!(Character.isDigit(string.charAt(index)) || string.charAt(index) == ',' || string.charAt(index) == ')')){
                System.out.println(" TERMINATED");
                nextDo = doCheck(string);
                return -1;
            }

            if(string.charAt(index) == ','){
                number1 = string.substring(4, index);
                commaIndex = index;
            }

            if(string.charAt(index) == ')'){
                number2 = string.substring(commaIndex + 1, index);
                System.out.println(" TERMINATED");
                int finalAnswer = Integer.parseInt(number1) * Integer.parseInt(number2);
                System.out.println("FINAL ANSWER: " + finalAnswer);
                nextDo = doCheck(string);
                return finalAnswer;
            }
        }
        System.out.println(" TERMINATED");
        nextDo = doCheck(string);
        return -1;
    }

    public static boolean doCheck(String string){
        if(string.contains("do()")) return true;
        if(string.contains("don't()")) return false;
        return doEnabled;
    }
}
