package advent.days;

import advent.Helpers;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class Day2 {


    public static void solvePart1(){

        List<String> message = Helpers.parseFile("inputs/day2.txt");

        ArrayList<ArrayList<Integer>> data = new ArrayList<>();

        for(String line : message){
            ArrayList<Integer> intList = new ArrayList<>();
            String[] lineArray = line.split(" ");
            for(String num : lineArray){
                intList.add(Integer.valueOf(num));
            }
            data.add(intList);
        }

        int totalSafe = 0;

        for(ArrayList<Integer> list : data){

            System.out.println(list);
            System.out.println(listOk(list));
            if(listOk(list)){
                totalSafe++;
            }

        }

        System.out.println(totalSafe);


    }

    public static void solvePart2(){

        List<String> message = Helpers.parseFile("inputs/day2.txt");

        ArrayList<ArrayList<Integer>> data = new ArrayList<>();

        for(String line : message){
            ArrayList<Integer> intList = new ArrayList<>();
            String[] lineArray = line.split(" ");
            for(String num : lineArray){
                intList.add(Integer.valueOf(num));
            }
            data.add(intList);
        }

        int totalSafe = 0;

        for(ArrayList<Integer> list : data){

            System.out.println(list);
            boolean listOk = listOkPart2(list);
            System.out.println(listOk);
            if(listOk){
                totalSafe++;
            }

        }

        System.out.println(totalSafe);

    }

    public static boolean listOk(ArrayList<Integer> list){

        boolean sign = list.get(0) - list.get(1) > 0;

        for(int i=0;i<list.size();i++){
            if(i == list.size() - 1) return true;

            int diff = list.get(i) - list.get(i+1);

            if(diff > 0 != sign){
                return false;
            }

            if(Math.abs(diff) < 1 || Math.abs(diff) > 3){
                return false;
            }
        }

        return true;

    }

    public static boolean listOkPart2(ArrayList<Integer> list){

        boolean sign = list.get(0) - list.get(1) > 0;

        for(int i=0;i<list.size();i++){
            ArrayList<Integer> listOneRemoved = (ArrayList<Integer>) list.clone();
            listOneRemoved.remove(i);
            if(listOk(listOneRemoved)) return true;
        }

        return false;

    }
}
