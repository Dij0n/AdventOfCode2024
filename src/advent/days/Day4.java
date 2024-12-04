package advent.days;

import advent.Helpers;

import javax.print.DocFlavor;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day4 {


    public static ArrayList<String[]> matrix = new ArrayList<>();

    public static void solvePart1(){

        List<String> message = Helpers.parseFile("inputs/day4.txt");

        for(String line : message){
            String[] row = line.split("");
            matrix.add(row);
            System.out.println(Arrays.toString(row));
        }

        int finalAnswer = 0;

        for(int y=0;y<matrix.size();y++){
            for(int x=0;x<matrix.get(y).length;x++){
                if(matrix.get(y)[x].equals("X")){

                    System.out.println("AT (" + x + y + ")");
                    System.out.println("North: " + checkForNorth(x, y));
                    System.out.println("NorthWest: " + checkForNorthWest(x, y));
                    System.out.println("West: " + checkForWest(x, y));
                    System.out.println("SouthWest: " + checkForSouthWest(x, y));
                    System.out.println("South: " + checkForSouth(x, y));
                    System.out.println("SouthEast: " + checkForSouthEast(x, y));
                    System.out.println("East: " + checkForEast(x, y));
                    System.out.println("NorthEast: " + checkForNorthEast(x, y));

                    finalAnswer += checkForAll(x, y);

                    System.out.println(" ");
                }
            }
        }

        System.out.println(finalAnswer);
    }

    public static void solvePart2(){

        List<String> message = Helpers.parseFile("inputs/day4.txt");

        for(String line : message){
            String[] row = line.split("");
            matrix.add(row);
            System.out.println(Arrays.toString(row));
        }

        int finalAnswer = 0;

        for(int y=0;y<matrix.size();y++){
            for(int x=0;x<matrix.get(y).length;x++){
                if(matrix.get(y)[x].equals("M")){

                    System.out.println("AT (" + x + "," + y + ")");
                    if(checkForNWNEMAS(x, y)) System.out.println("NWNE");
                    if(checkForNWSWMAS(x, y)) System.out.println("NWSW");
                    if(checkForSWSEMAS(x, y)) System.out.println("SWSE");
                    if(checkForSWNWMAS(x, y)) System.out.println("SWNW");
                    if(checkForNENWMAS(x, y)) System.out.println("NENW");
                    if(checkForNESEMAS(x, y)) System.out.println("NESE");
                    if(checkForSENEMAS(x, y)) System.out.println("SENE");
                    if(checkForSESWMAS(x, y)) System.out.println("SESW");
                    finalAnswer += checkForAllMAS(x, y);
                }
            }
        }

        System.out.println(finalAnswer);

    }

    public static int checkForAll(int x, int y){
        int finalInt = 0;

        if(checkForNorth(x, y)) finalInt++;
        if(checkForNorthEast(x, y)) finalInt++;
        if(checkForNorthWest(x, y)) finalInt++;
        if(checkForSouth(x, y)) finalInt++;
        if(checkForSouthWest(x, y)) finalInt++;
        if(checkForSouthEast(x, y)) finalInt++;
        if(checkForEast(x, y)) finalInt++;
        if(checkForWest(x, y)) finalInt++;

        return finalInt;
    }
    public static boolean checkForEast(int x, int y){
        if(x <= matrix.get(y).length - 4){
            return matrix.get(y)[x + 1].equals("M") && matrix.get(y)[x + 2].equals("A") && matrix.get(y)[x + 3].equals("S");
        }
        return false;
    }
    public static boolean checkForWest(int x, int y){
        if(x >= 3){
            return matrix.get(y)[x - 1].equals("M") && matrix.get(y)[x - 2].equals("A") && matrix.get(y)[x - 3].equals("S");
        }
        return false;
    }
    public static boolean checkForSouth(int x, int y){
        if(y <= matrix.size() - 4){
            return matrix.get(y + 1)[x].equals("M") && matrix.get(y + 2)[x].equals("A") && matrix.get(y + 3)[x].equals("S");
        }
        return false;
    }
    public static boolean checkForNorth(int x, int y){
        if(y >= 3){
            return matrix.get(y - 1)[x].equals("M") && matrix.get(y - 2)[x].equals("A") && matrix.get(y - 3)[x].equals("S");
        }
        return false;
    }
    public static boolean checkForNorthEast(int x, int y){
        if(x <= matrix.get(y).length - 4 && y >= 3){
            return matrix.get(y - 1)[x + 1].equals("M") && matrix.get(y - 2)[x + 2].equals("A") && matrix.get(y - 3)[x + 3].equals("S");
        }
        return false;
    }
    public static boolean checkForSouthEast(int x, int y){
        if(x <= matrix.get(y).length - 4 && y <= matrix.size() - 4){
            return matrix.get(y + 1)[x + 1].equals("M") && matrix.get(y + 2)[x + 2].equals("A") && matrix.get(y + 3)[x + 3].equals("S");
        }
        return false;
    }
    public static boolean checkForNorthWest(int x, int y){
        if(x >= 3 && y >= 3){
            return matrix.get(y - 1)[x - 1].equals("M") && matrix.get(y - 2)[x - 2].equals("A") && matrix.get(y - 3)[x - 3].equals("S");
        }
        return false;
    }
    public static boolean checkForSouthWest(int x, int y){
        if(x >= 3 && y <= matrix.size() - 4){
            return matrix.get(y + 1)[x - 1].equals("M") && matrix.get(y + 2)[x - 2].equals("A") && matrix.get(y + 3)[x - 3].equals("S");
        }
        return false;
    }


    public static int checkForAllMAS(int x, int y){
        int finalInt = 0;

        if(checkForNWNEMAS(x, y)) finalInt++;
        if(checkForNWSWMAS(x, y)) finalInt++;
        if(checkForSWSEMAS(x, y)) finalInt++;
        if(checkForSWNWMAS(x, y)) finalInt++;
        if(checkForNENWMAS(x, y)) finalInt++;
        if(checkForNESEMAS(x, y)) finalInt++;
        if(checkForSENEMAS(x, y)) finalInt++;
        if(checkForSESWMAS(x, y)) finalInt++;

        return finalInt;
    }
    public static boolean checkForNESEMAS(int x, int y){
        if(x <= matrix.get(y).length - 3 && y >= 2){
            return matrix.get(y - 1)[x + 1].equals("A") && matrix.get(y - 2)[x + 2].equals("S") && matrix.get(y)[x + 2].equals("M") && matrix.get(y - 2)[x].equals("S");
        }
        return false;
    }
    public static boolean checkForNENWMAS(int x, int y){
        if(x <= matrix.get(y).length - 3 && y >= 2){
            return matrix.get(y - 1)[x + 1].equals("A") && matrix.get(y - 2)[x + 2].equals("S") && matrix.get(y)[x + 2].equals("S") && matrix.get(y - 2)[x].equals("M");
        }
        return false;
    }


    public static boolean checkForSENEMAS(int x, int y){
        if(x <= matrix.get(y).length - 3 && y <= matrix.size() - 3){
            return matrix.get(y + 1)[x + 1].equals("A") && matrix.get(y + 2)[x + 2].equals("S") && matrix.get(y)[x + 2].equals("S") && matrix.get(y + 2)[x].equals("M");
        }
        return false;
    }
    public static boolean checkForSESWMAS(int x, int y){
        if(x <= matrix.get(y).length - 3 && y <= matrix.size() - 3){
            return matrix.get(y + 1)[x + 1].equals("A") && matrix.get(y + 2)[x + 2].equals("S") && matrix.get(y)[x + 2].equals("M") && matrix.get(y + 2)[x].equals("S");
        }
        return false;
    }


    public static boolean checkForNWSWMAS(int x, int y){
        if(x >= 2 && y >= 2){
            return matrix.get(y - 1)[x - 1].equals("A") && matrix.get(y - 2)[x - 2].equals("S") && matrix.get(y)[x - 2].equals("S") && matrix.get(y - 2)[x].equals("M");
        }
        return false;
    }
    public static boolean checkForNWNEMAS(int x, int y){
        if(x >= 2 && y >= 2){
            return matrix.get(y - 1)[x - 1].equals("A") && matrix.get(y - 2)[x - 2].equals("S") && matrix.get(y)[x - 2].equals("M") && matrix.get(y - 2)[x].equals("S");
        }
        return false;
    }



    public static boolean checkForSWNWMAS(int x, int y){
        if(x >= 2 && y <= matrix.size() - 3){
            return matrix.get(y + 1)[x - 1].equals("A") && matrix.get(y + 2)[x - 2].equals("S") && matrix.get(y)[x - 2].equals("S") && matrix.get(y + 2)[x].equals("M");
        }
        return false;
    }
    public static boolean checkForSWSEMAS(int x, int y){
        if(x >= 2 && y <= matrix.size() - 3){
            return matrix.get(y + 1)[x - 1].equals("A") && matrix.get(y + 2)[x - 2].equals("S") && matrix.get(y)[x - 2].equals("M") && matrix.get(y + 2)[x].equals("S");
        }
        return false;
    }

}
