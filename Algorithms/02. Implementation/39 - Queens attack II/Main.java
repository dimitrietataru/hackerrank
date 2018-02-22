/**
 *              39 | QUEEN'S ATTACK II
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner in = new Scanner(file);
        int n = in.nextInt();                   // board size
        int k = in.nextInt();                   // obstacles
        int xQueen = in.nextInt();
        int yQueen = in.nextInt();

        // (X,Y) coordinates of the closest obstacle in each direction
        int xTop = -1, yTop = -1;
        int xBot = -1, yBot = -1;
        int xLeft = -1, yLeft = -1;
        int xRight = -1, yRight = -1;
        int xTopL = -1, yTopL = -1;
        int xTopR = -1, yTopR = -1;
        int xBotL = -1, yBotL = -1;
        int xBotR = -1, yBotR = -1;

        // Total squares the queen can attack/reach
        int reachableSquares = 0;

        // Finds the closest object in each direction
        for(int i = 0; i < k; i++){

            // Obstacle coordinates (X,Y)
            int xObst = in.nextInt();
            int yObst = in.nextInt();

            // Top
            if((xObst < xTop || xTop == -1)     // obstacle is closer to queen/no known obstacle
                    && xObst > xQueen           // obstacle is located TOP from queen
                    && yObst == yQueen) {       // obstacle and queen are on the same COLUMN
                xTop = xObst;
                yTop = yObst;
            }

            // Bottom
            if((xObst > xBot || xBot == -1)     // obstacle is closer to queen/no known obstacle
                    && xObst < xQueen           // obstacle is located BOTTOM from queen
                    && yObst == yQueen) {       // obstacle and queen are on the same COLUMN
                xBot = xObst;
                yBot = yObst;
            }

            // Left
            if((yObst > yLeft || xLeft == -1)   // obstacle is closer to queen/no known obstacle
                    && yObst < yQueen           // obstacle is located LEFT from queen
                    && xObst == xQueen) {       // obstacle and queen are on the same ROW
                xLeft = xObst;
                yLeft = yObst;
            }

            // Right
            if((yObst < yRight || xRight == -1) // obstacle is closer to queen/no known obstacle
                    && yObst > yQueen           // obstacle is located RIGHT from queen
                    && xObst == xQueen) {       // obstacle and queen are on the same ROW
                xRight = xObst;
                yRight = yObst;
            }

            // Top Left
            if(xObst - xQueen == yQueen - yObst                             // obstacle on diagonal TL
                    && yObst < yQueen && xObst > xQueen                     // obstacle on TOP-LEFT
                    && ((xObst < xTopL && yObst > yTopL) || xTopL == -1)) { // closest obstacle
                xTopL = xObst;
                yTopL = yObst;
            }

            // Top Right
            if(xObst - xQueen == yObst - yQueen                             // obstacle on diagonal TR
                    && yObst > yQueen && xObst > xQueen                     // obstacle on TOP-RIGHT
                    && ((xObst < xTopR && yObst < yTopR) || xTopR == -1)) { // closest obstacle
                xTopR = xObst;
                yTopR = yObst;
            }

            // Bottom Left
            if(xQueen - xObst == yQueen - yObst                             // obstacle on diagonal BL
                    && yObst < yQueen && xObst < xQueen                     // obstacle on BL
                    && ((xObst > xBotL && yObst > yBotL) || xBotL == -1)) { // closest obstacle
                xBotL = xObst;
                yBotL = yObst;
            }

            // Bottom Right
            if(xQueen - xObst == yObst - yQueen                             // obstacle on diagonal BR
                    && yObst > yQueen && xObst < xQueen                     // obstacle on BL
                    && ((xObst > xBotR && yObst < yBotR) || xBotR == -1)) { // closest obstacle
                xBotR = xObst;
                yBotR = yObst;
            }
        }

        // Calculates the distance to the closest obstacle in each direction
        reachableSquares += (xTop != -1) ? (xTop - xQueen - 1) : n - xQueen;
        reachableSquares += (xBot != -1) ? (xQueen - xBot - 1) : xQueen - 1;
        reachableSquares += (yLeft != -1) ? (yQueen - yLeft -1) : yQueen - 1;
        reachableSquares += (yRight != -1) ? (yRight - yQueen -1) : n - yQueen;
        reachableSquares += (yTopL != -1) ? (yQueen - yTopL -1) : Math.min(yQueen - 1, n - xQueen);
        reachableSquares += (xTopR != -1) ? (yTopR - yQueen - 1) : Math.min(n - yQueen, n - xQueen);
        reachableSquares += (xBotL != -1) ? (yQueen - yBotL - 1) : Math.min(yQueen - 1, xQueen - 1);
        reachableSquares += (yBotR != -1) ? (yBotR - yQueen -1) : Math.min(n - yQueen, xQueen - 1);

        System.out.println(reachableSquares);
    }
}