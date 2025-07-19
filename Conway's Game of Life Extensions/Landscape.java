
/**
 * File name : Landscapes.java
 * Author: Aayan Shah
 * purpose: reprsent 2d grid of cells
 */

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class Landscape {

    /**
     * Stores the number of rows and columns in the grid
     */
    private int numRows;
    private int numCols;

    /**
     * The underlying grid of Cells for Conway's Game
     */
    Cell[][] landscape;

    /**
     * The original probability each individual Cell is alive
     */
    private double initialChance = 0;

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * All Cells are initially dead.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     */
    public Landscape(int rows, int columns) {
        numCols = columns;
        numRows = rows;
        landscape = new Cell[rows][columns];
        reset();

    }

    /**
     * Constructs a Landscape of the specified number of rows and columns.
     * Each Cell is initially alive with probability specified by chance.
     * 
     * @param rows    the number of rows in the Landscape
     * @param columns the number of columns in the Landscape
     * @param chance  the probability each individual Cell is initially alive
     */
    public Landscape(int rows, int columns, double chance) {
        landscape = new Cell[rows][columns];
        numCols = columns;
        numRows = rows;
        initialChance = chance;
        reset();
    }

    /**
     * Recreates the Landscape according to the specifications given
     * in its initial construction.
     */
    public void reset() {
        Random rand = new Random();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                double testCase = (double) rand.nextInt(100) / 100;
                if (testCase < initialChance)
                    landscape[i][j] = new Cell(true);
                else
                    landscape[i][j] = new Cell(false);

            }
        }

    }

    /**
     * Returns the number of rows in the Landscape.
     * 
     * @return the number of rows in the Landscape
     */
    public int getRows() {
        return landscape.length;
    }

    /**
     * Returns the number of columns in the Landscape.
     * 
     * @return the number of columns in the Landscape
     */
    public int getCols() {
        return landscape[0].length;
    }

    /**
     * Returns the Cell specified the given row and column.
     * 
     * @param row the row of the desired Cell
     * @param col the column of the desired Cell
     * @return the Cell specified the given row and column
     */
    public Cell getCell(int row, int col) {
        return landscape[row][col];

    }

    /**
     * Returns a String representation of the Landscape.
     */
    public String toString() {
        String output = "";
        for (int i = 0; i < landscape.length; i++) {
            for (int j = 0; j < landscape[0].length; j++) {
                output += "  |  " + landscape[i][j].toString();
            }
            output += "\n";
        }
        return output;
    }

    /**
     * Returns an ArrayList of the neighboring Cells to the specified location.
     * 
     * @param row the row of the specified Cell
     * @param col the column of the specified Cell
     * @return an ArrayList of the neighboring Cells to the specified location
     */
    public ArrayList<Cell> getNeighbors(int row, int col) {
        ArrayList<Cell> myNeighbours = new ArrayList<>();
        if (col == 0) {
            if (row == 0) {
                myNeighbours.add(landscape[1][0]);
                myNeighbours.add(landscape[1][1]);
                myNeighbours.add(landscape[0][1]);

            } else if (row == numRows - 1) {
                myNeighbours.add(landscape[numRows - 2][0]);
                myNeighbours.add(landscape[numRows - 2][1]);
                myNeighbours.add(landscape[numRows - 1][1]);
            } else {
                myNeighbours.add(landscape[row - 1][col]);
                myNeighbours.add(landscape[row + 1][col]);
                myNeighbours.add(landscape[row + 1][col + 1]);
                myNeighbours.add(landscape[row - 1][col + 1]);
                myNeighbours.add(landscape[row][col + 1]);

            }

        } else if (col == numCols - 1) {

            if (row == 0) {
                myNeighbours.add(landscape[numRows - 2][0]);
                myNeighbours.add(landscape[numRows - 2][1]);
                myNeighbours.add(landscape[numRows - 1][1]);

            } else if (row == numRows - 1) {
                myNeighbours.add(landscape[numRows - 2][numCols - 2]);
                myNeighbours.add(landscape[numRows - 2][numCols - 1]);
                myNeighbours.add(landscape[numRows - 1][numCols - 2]);
            } else {
                myNeighbours.add(landscape[row - 1][col]);
                myNeighbours.add(landscape[row + 1][col]);
                myNeighbours.add(landscape[row + 1][col - 1]);
                myNeighbours.add(landscape[row - 1][col - 1]);
                myNeighbours.add(landscape[row][col - 1]);

            }

        } else if (row == 0) {

            myNeighbours.add(landscape[row][col - 1]);
            myNeighbours.add(landscape[row][col + 1]);
            myNeighbours.add(landscape[row + 1][col - 1]);
            myNeighbours.add(landscape[row + 1][col + 1]);
            myNeighbours.add(landscape[row + 1][col]);

        } else if (row == numRows - 1) {
            myNeighbours.add(landscape[row][col - 1]);
            myNeighbours.add(landscape[row][col + 1]);
            myNeighbours.add(landscape[row - 1][col - 1]);
            myNeighbours.add(landscape[row - 1][col + 1]);
            myNeighbours.add(landscape[row - 1][col]);
        } else {
            myNeighbours.add(landscape[row + 1][col + 1]);
            myNeighbours.add(landscape[row + 1][col - 1]);
            myNeighbours.add(landscape[row + 1][col]);
            myNeighbours.add(landscape[row][col + 1]);
            myNeighbours.add(landscape[row][col - 1]);
            myNeighbours.add(landscape[row - 1][col + 1]);
            myNeighbours.add(landscape[row - 1][col - 1]);
            myNeighbours.add(landscape[row - 1][col]);
        }

        return myNeighbours;
    }

    /**
     * Advances the current Landscape by one step.
     */
    public void advance() {
        Cell[][] stepGrid = new Cell[this.numRows][this.numCols];
        for (int i = 0; i < stepGrid.length; i++) {
            for (int j = 0; j < stepGrid[0].length; j++) {
                stepGrid[i][j] = new Cell();
                stepGrid[i][j].setAlive(landscape[i][j].getAlive());
                stepGrid[i][j].updateState(this.getNeighbors(i, j));

            }
        }
        this.landscape = stepGrid;
    }

    /**
     * Draws the Cell to the given Graphics object at the specified scale.
     * An alive Cell is drawn with a black color; a dead Cell is drawn gray.
     * 
     * @param g     the Graphics object on which to draw
     * @param scale the scale of the representation of this Cell
     */
    public void draw(Graphics g, int scale) {
        for (int x = 0; x < getRows(); x++) {
            for (int y = 0; y < getCols(); y++) {
                g.setColor(getCell(x, y).getAlive() ? Color.BLACK : Color.gray);
                g.fillOval(y * scale, x * scale, scale, scale);
            }
        }
    }

    public void addGlider() {
        landscape[2][0].setAlive(true);
        landscape[2][1].setAlive(true);
        landscape[2][2].setAlive(true);
        landscape[1][2].setAlive(true);
        landscape[0][1].setAlive(true);
    }

    public void chaos() {
        landscape[(numRows / 2)][(numCols / 2)].setAlive(true);
        landscape[(numRows / 2) + 1][(numCols / 2)].setAlive(true);
        landscape[(numRows / 2) + 2][(numCols / 2)].setAlive(true);
        landscape[(numRows / 2) + 1][(numCols / 2) - 1].setAlive(true);
        landscape[(numRows / 2) + 2][(numCols / 2) + 1].setAlive(true);
    }

    public void gliderGun() {
        leftPart();
        leftEngine();
        rightEngine();
        rightPart();
    }

    public void leftPart() {
        landscape[4][0].setAlive(true);
        landscape[4][1].setAlive(true);
        landscape[5][0].setAlive(true);
        landscape[5][1].setAlive(true);

    }

    public void leftEngine() {
        landscape[4][10].setAlive(true);
        landscape[5][10].setAlive(true);
        landscape[6][10].setAlive(true);
        landscape[3][11].setAlive(true);
        landscape[7][11].setAlive(true);
        landscape[2][12].setAlive(true);
        landscape[2][13].setAlive(true);
        landscape[8][12].setAlive(true);
        landscape[8][13].setAlive(true);
        landscape[5][14].setAlive(true);
        landscape[3][15].setAlive(true);
        landscape[7][15].setAlive(true);
        landscape[4][16].setAlive(true);
        landscape[5][16].setAlive(true);
        landscape[6][16].setAlive(true);
        landscape[5][17].setAlive(true);

    }

    public void rightEngine() {
        landscape[0][24].setAlive(true);
        landscape[1][24].setAlive(true);
        landscape[1][22].setAlive(true);
        landscape[2][21].setAlive(true);
        landscape[2][20].setAlive(true);
        landscape[3][21].setAlive(true);
        landscape[3][20].setAlive(true);
        landscape[4][21].setAlive(true);
        landscape[4][20].setAlive(true);
        landscape[5][22].setAlive(true);
        landscape[5][24].setAlive(true);
        landscape[6][24].setAlive(true);
    }

    public void rightPart() {
        landscape[2][34].setAlive(true);
        landscape[3][34].setAlive(true);
        landscape[2][35].setAlive(true);
        landscape[3][35].setAlive(true);
    }

    public static void main(String[] args) {
    }
}
