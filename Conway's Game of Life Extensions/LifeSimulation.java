/**
 * Author : Aayan Shah
 * Last modified: 10/1/2024
 * Purpose: run Conway's game of life simulation
 */

public class LifeSimulation {

    public static void main(String[] args) throws InterruptedException {

        //Taking values from the command line
        if(args.length == 0 ){
            System.out.println("Usage: java LifeSimulation int int double int\n\tFirst int num Rows\n\tSecond int num Cols\n\tThird double probabilty of alive (intital density)\n\tFourth int number of iterations");
            return;
        }
        int rows = Integer.parseInt(args[0]);
        int cols = Integer.parseInt(args[1]);
        double prob = Double.parseDouble(args[2]);
        int iterations = Integer.parseInt(args[3]);
        for(int j = 0 ; j <10;j++){
        Landscape scape = new Landscape(rows, cols, prob);
        

        LandscapeDisplay display = new LandscapeDisplay(scape, 6);

        // Simulation
        
        for (int i = 0; i < iterations; i++) {
           if (display.onstate) {
                Thread.sleep(1);
                scape.advance();
                display.repaint();
            }
           Thread.sleep(1);
           i--;
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
