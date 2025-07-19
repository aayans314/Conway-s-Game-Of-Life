
/**
 * Author : Aayan Shah
 * Purpose : Practising 2D arrays
 * Date: 9/26/2024
 */

import java.util.Random;

public class Grid {
    
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("  Usage: java Grid boolean int int \n            (boolean (true/false) true if building\n\tyour own array, false if random\n\tfollow by elements if building self)");
            return;
            
        }
        Random random = new Random();
        int rowSize=Integer.parseInt(args[1]);
        int colSize = Integer.parseInt(args[2]);
        if (args.length == 0) {
            System.out.println("  Usage: java Grid boolean int int \n            (boolean (true/false) true if building\n\tyour own array, false if random\n\tfollow by elements if building self)");
            return;
            
        }
        
        if (rowSize == 0 || colSize == 0){
            System.out.println(" :) ");
        }else{

       /* for (int i = 0; i < args.length; i++) {
            System.out.print(args[i]);

        }
        System.out.println();
*/
        int[][] myGrid;
        myGrid = new int[rowSize][colSize];
        // System.out.println(myGrid[0][0]);
        // for (int i = 0; i < 3; i++) {
        // myGrid[i] = new Integer[i + 3];
        // }
        // System.out.print(myGrid[0][0]);
        // very different from using int[][] as it would not have null as values and
        // instead initialize all of them to 0
        if (!Boolean.valueOf(args[0])){
            for (int i = 0; i < myGrid.length; i++) {

                for (int j = 0; j < myGrid[i].length; j++) {
                    myGrid[i][j] = random.nextInt(10);
                }
            }
            System.out.println();
            for (int i = 0; i < myGrid.length; i++) {
                System.out.println();
                for (int j = 0; j < myGrid[i].length; j++) {
                    System.out.print(myGrid[i][j] + "\t");
                }
            }
            System.out.println();
            for (int i = 0; i < rotate(myGrid).length; i++) {
                System.out.println();
                for (int j = 0; j < rotate(myGrid)[i].length; j++) {
                    System.out.print(rotate(myGrid)[i][j] + "\t");
                }
            }
            System.out.println();
            System.out.println("Contents of your array and rotated array: "+ gridEquals(myGrid,rotate(myGrid)));
        }
        else{
            int offset = 3;

            for (int i = 0; i < myGrid.length; i++) {

                for (int j = 0; j < myGrid[i].length; j++) {
                    myGrid[i][j] = Integer.parseInt(args[offset++]);
                }
            }
            for (int i = 0; i < myGrid.length; i++) {
                System.out.println();
                for (int j = 0; j < myGrid[i].length; j++) {
                    System.out.print(myGrid[i][j] + "\t");
                }
            }
            System.out.println();
            for (int i = 0; i < rotate(myGrid).length; i++) {
                System.out.println();
                for (int j = 0; j < rotate(myGrid)[i].length; j++) {
                    System.out.print(rotate(myGrid)[i][j] + "\t");
                }
            }
            System.out.println();
            System.out.println("Contents of your array and rotated array: "+ gridEquals(myGrid,rotate(myGrid)));
        }
            /*int[][] arr1 = new int[2][2];
            int[][] arr2 = new int[2][2];
            int[][] arr3;
            for (int i = 0; i < 2; i++) {
                for (int j = 0; j < 2; j++) {
                    arr1[i][j] = i + j;
                    arr2[i][j] = i + j;
                }
            }
            arr3 = arr1;*/
            // arr1[1][1] = 54;
            // arr3 [1][1] = 53; this will change 1 too
            // System.out.print("\n" + arr1 [1][1]);
            //System.out.println(arr1 == arr2);
            //System.out.println(arr1 == arr3);
            //System.out.println(gridEquals(arr1, arr2));

            
            }
        }

        public static boolean gridEquals(int[][] arr1, int[][] arr2){
            return ((gridEqualsOneConfig(arr1, arr2)) ||(gridEqualsOneConfig(arr1, rotate(arr2))) ||(gridEqualsOneConfig(arr1, rotate(rotate(arr2)))) ||(gridEqualsOneConfig(arr1, rotate(rotate(rotate(arr2))))));
            
            

    }
    public static boolean gridEqualsOneConfig(int[][] arr1, int[][] arr2){
            
        if (arr1.length != arr2.length) return false;
    if (arr1.length != 0){
        for (int i = 0; i < arr1.length; i++) {
        
            for (int j = 0; j < arr1[i].length; j++) {
                if (arr1[i][j] != arr2[i][j]) return false;
    }
    }
    }
        return true;

    }


    public static int[][] rotate(int[][] arr){
        int[][] output = new int[arr[0].length][arr.length];
        for(int row = 0; row < output.length; row++){
            for(int col = 0; col < output[row].length; col++){
                output[row][col] = arr[arr.length-1-col][row];
            }
        } return output;
    }
}