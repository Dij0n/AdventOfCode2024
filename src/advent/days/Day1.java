package advent.days;

import advent.Helpers;

import java.io.FileReader;
import java.util.*;

public class Day1 {


    public static void solvePart1(){

        List<String> message = Helpers.parseFile("inputs/day1.txt");
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();
        int finalCount = 0;

        for(String line : message){
            firstList.add(Integer.valueOf(line.substring(0,5)));
            secondList.add(Integer.valueOf(line.substring(8)));
        }

        Collections.sort(firstList);
        Collections.sort(secondList);

        System.out.println(firstList);
        System.out.println(secondList);

        for (int i=0; i<firstList.size(); i++) {
            finalCount += Math.abs(firstList.get(i) - secondList.get(i));
        }

        System.out.println(finalCount);

    }

    public static void solvePart2(){
        List<String> message = Helpers.parseFile("inputs/day1.txt");
        ArrayList<Integer> firstList = new ArrayList<>();
        ArrayList<Integer> secondList = new ArrayList<>();

        int finalValue = 0;

        for(String line : message){
            firstList.add(Integer.valueOf(line.substring(0,5)));
            secondList.add(Integer.valueOf(line.substring(8)));
        }

        HashMap<Integer, Integer> secondListOccurrences = new HashMap<>();

        for(int integer : secondList){
            secondListOccurrences.put(integer, secondListOccurrences.getOrDefault(integer, 0) + 1);
        }

        System.out.println(secondListOccurrences);

        for(int integer : firstList){
            finalValue += integer * secondListOccurrences.getOrDefault(integer, 0);
        }

        System.out.println(finalValue);
    }



}
