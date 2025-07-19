/**
 * Author: Aayan Shah
 * Last modified: 10/1/2024
 * Purpose: Testing Cell.java
 */

public class MyCellTests {
    /**
     * Testing using main method
     * 
     * @param args as usual string array from cl
     */
    public static void main(String[] args) {
        // Testing blank constructor
        {
            Cell myCell = new Cell();
            assert myCell.getAlive() == false : "Error in constructor";
        }
        // Testing constructor with Status parameter
        {
            Cell myCell = new Cell(true);
            Cell myCell2 = new Cell(false);
            assert myCell.getAlive() == true : "Error in constructor passing status";
            assert myCell2.getAlive() == false : "Error in constructor passing status";
        }
        // Testing get alive
        {
            Cell myCell = new Cell(false);
            Cell myCell2 = new Cell(true);
            assert myCell.getAlive() == false : "Error in getting alive status";
            assert myCell2.getAlive() == true : "Error in getting alive status";

        }
        // Testing setting alive
        {
            Cell myCell = new Cell();
            myCell.setAlive(true);
            assert myCell.getAlive() == true : "Error in setting status";
            myCell.setAlive(false);
            assert myCell.getAlive() == false : "Error in setting status";

        }
        // Testing toString
        {
            Cell myCell = new Cell();
            assert myCell.toString() == "0" + "\n" : "Error in toString";
            myCell.setAlive(true);
            assert myCell.toString() == "1" + "\n" : "Error in toString";

        }

        System.out.println("Testing complete!");
    }
}
