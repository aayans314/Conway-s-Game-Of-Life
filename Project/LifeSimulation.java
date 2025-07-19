/**
 * Author : Aayan Shah
 * Last modified: 10/1/2024
 * Purpose: run Conway's game of life simulation
 */

public class LifeSimulation {

    public static void main(String[] args) throws InterruptedException {

        
        int rows = 250;
        int cols = 250;
        double prob = 0.2;
        int iterations = 1000; 
        for(int j = 0 ; j <10;j++){
        Landscape scape = new Landscape(rows, cols, prob);
        

        LandscapeDisplay display = new LandscapeDisplay(scape, 6);

        // Simulation
        
        for (int i = 0; i < iterations; i++) {
           // if (display.onstate) {
                Thread.sleep(1);
                scape.advance();
                display.repaint();
           // }
           // Thread.sleep(1);
           // i--;
        }
            System.out.println(finalAliveCells(rows,cols, scape));
    }
    }

    //Following code was for checking number of alive cells after a certain number of iterations
    public static int finalAliveCells(int rows, int cols, Landscape scape) {
        int count = 0;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (scape.landscape[i][j].getAlive()) {
                    count++;
                }
            }
        }
        return count;
    }
}
