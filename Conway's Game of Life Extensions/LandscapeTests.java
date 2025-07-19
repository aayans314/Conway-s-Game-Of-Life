/*
file name:      LandscapeTests.java
Authors:        Max Bender & Naser Al Madi
Editor: Aayan Shah
last modified:  9/29/2024

How to run:     java -ea LandscapeTests
*/

import java.util.ArrayList;

public class LandscapeTests {

    public static void landscapeTests() {

        // case 1: testing Landscape(int, int)
        {
            // set up
            Landscape l1 = new Landscape(2, 4);
            Landscape l2 = new Landscape(10, 10);

            // verify
            System.out.println(l1);
            System.out.println("\n");
            System.out.println(l2);

            // test
            assert l1 != null : "Error in Landscape::Landscape(int, int)";
            assert l2 != null : "Error in Landscape::Landscape(int, int)";
        }

        // case 2: testing reset()
        {
            // set up
            Landscape l = new Landscape(5, 5, 0.5);

            // verify
            System.out.println(l);
            l.reset();
            System.out.println(l);

            // test
            boolean newstatus = false;
            for (int i = 0; i < l.getRows(); i++) {
                for (int j = 0; j < l.getCols(); j++) {
                    if (l.getCell(i, j).getAlive()) {
                        newstatus = true;
                        break;
                    }
                }
            }
            assert newstatus : "Error in Landscape::reset()";
        }

        // case 3: testing getRows()
        {
            // set up

            Landscape l = new Landscape(5, 3);
            // verify
            System.out.println("5 == " + l.getRows());

            // test
            assert l.getRows() == 5 : "Error in Landscape::getRows()";
        }

        // case 4: testing getCols()
        {
            // set up
            Landscape l = new Landscape(5, 7);

            // verify
            System.out.println("7 == " + l.getCols());

            // test
            assert l.getCols() == 7 : "Error in Landscape::getCols()";
        }

        // case 5: testing getCell(int, int)
        {
            // set up
            Landscape l = new Landscape(4, 4);

            // verify
            System.out.println(l.getCell(2, 2));

            // test
            assert l.getCell(2, 2) != null : "Error in Landscape::getCell()";

        }

        // case 6: testing getNeighbors()
        {
            // set up
            Landscape l = new Landscape(3, 3);
            ArrayList<Cell> neighbors = l.getNeighbors(1, 1);

            // verify

            System.out.println("no of neighbours 8 == " + neighbors.size());
            // test
            assert neighbors.size() == 8 : "Error in Landscape::getNeighbors()";
        }

        // case 7: testing advance()
        {
            // set up
            Landscape l = new Landscape(3, 3);
            l.getCell(0, 0).setAlive(true);
            l.getCell(0, 1).setAlive(true);
            l.getCell(0, 2).setAlive(true);

            // verify
            System.out.println(l);
            l.advance();
            System.out.println(l);
            // test
            assert !l.getCell(0, 0).getAlive() && l.getCell(1, 1).getAlive() : "Error in Landscape::advance()";
        }

        System.out.println("Done Testing!!!");
    }

    public static void main(String[] args) {

        landscapeTests();
    }
}
