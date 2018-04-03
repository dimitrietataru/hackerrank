/**
 *              61 | EMA'S SUPERCOMPUTER
 * Domain       ALGORITHMS
 * Sub domain   IMPLEMENTATION
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("input.txt");
        Scanner scan = new Scanner(file);
        int n = scan.nextInt();
        int m = scan.nextInt();
        int[][] matrix = new int[n][m];
        for (int i = 0; i < n; i++) {
            String line = scan.next();
            for (int j = 0; j < m; j++) {
                char ch = line.charAt(j);
                matrix[i][j] = (ch == 'G') ? 0 : -1;
            }
        }
        scan.close();

        emasSupercomputer(matrix, n, m);
    }

    private static void emasSupercomputer(int[][] matrix, int n, int m) {
        ArrayList<Point> points = getPlusPositions(matrix, n, m);

        int result = getProduct(points);
        System.out.println(result);
    }

    private static ArrayList<Point> getPlusPositions(int[][] matrix, int n, int m) {
        ArrayList<Point> points = new ArrayList<>();

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                int len = 1;
                if (matrix[i][j] >= 0) {
                    while ((i - len >= 0) && (i + len < n) && (j - len >= 0) && (j + len < m)) {
                        if (!((matrix[i - len][j] >= 0) && (matrix[i + len][j] >= 0)
                                && (matrix[i][j - len] >= 0) && (matrix[i][j + len] >= 0))) {
                            break;
                        }
                        len++;
                    }
                    while (len >= 2) {
                        points.add(new Point(i, j, len - 1));
                        len--;
                    }
                }
            }
        }

        points.sort(new PointComparator());
        return points;
    }

    private static int getProduct(ArrayList<Point> points) {
        int maxProduct = 1;
        for (int i = 0; i < points.size() - 1; ++i) {
            for (int j = i + 1; j < points.size(); j++) {
                Point p1 = points.get(i);
                Point p2 = points.get(j);

                if (!isOverlapping(p1, p2)) {
                    j = points.size();
                    int currentProduct = p1.getSize() * p2.getSize();
                    maxProduct = Math.max(currentProduct, maxProduct);
                }
            }
        }

        return (maxProduct == 1) ? (points.size() != 0) ? points.get(0).getSize() : 1 : maxProduct;
    }

    private static boolean isOverlapping(Point p1, Point p2) {
        /* X-axis */
        if (p1.getX() == p2.getX()) {
            if (Math.abs(p1.getY() - p2.getY()) <= (p1.getLen() + p2.getLen())) {
                return true;
            }
        }

        /* Y-axis */
        if (p1.getY() == p2.getY()) {
            if (Math.abs(p1.getX() - p2.getX()) <= (p1.getLen() + p2.getLen())) {
                return true;
            }
        }

        /* Quarter 1 - TOP-LEFT */
        if (p1.getX() > p2.getX() && p1.getY() > p2.getY()) {
            if ((p2.getY() + p2.getLen() >= p1.getY() && p1.getX() - p1.getLen() <= p2.getX()) ||
                    (p2.getX() + p2.getLen() >= p1.getX() && p1.getY() - p1.getLen() <= p2.getY())) {
                return true;
            }
        }

        /* Quarter 2 - TOP-RIGHT */
        if (p1.getX() > p2.getX() && p1.getY() < p2.getY()) {
            if ((p2.getY() - p2.getLen() <= p1.getY() && p1.getX() - p1.getLen() <= p2.getX()) ||
                    (p2.getX() + p2.getLen() >= p1.getX() && p1.getY() + p1.getLen() >= p2.getY())) {
                return true;
            }
        }

        /* Quarter 3 - BOTTOM-LEFT */
        if (p1.getX() < p2.getX() && p1.getY() > p2.getY()) {
            if ((p2.getY() + p2.getLen() >= p1.getY() && p1.getX() + p1.getLen() >= p2.getX()) ||
                    (p2.getX() - p2.getLen() <= p1.getX() && p1.getY() - p1.getLen() <= p2.getY())) {
                return true;
            }
        }

        /* Quarter 4 - BOTTOM-RIGHT */
        if (p1.getX() < p2.getX() && p1.getY() < p2.getY()) {
            if ((p2.getY() - p2.getLen() <= p1.getY() && p1.getX() + p1.getLen() >= p2.getX()) ||
                    (p2.getX() - p2.getLen() <= p1.getX() && p1.getY() + p1.getLen() >= p2.getY())) {
                return true;
            }
        }

        return false;
    }
}

class Point {
    private int x;
    private int y;
    private int length;

    Point(int x, int y, int length) {
        this.x = x;
        this.y = y;
        this.length = length;
    }

    int getX() {
        return x;
    }

    int getY() {
        return y;
    }

    int getLen() {
        return length;
    }

    int getSize() {
        return (((length) * 4) + 1);
    }
}

class PointComparator implements Comparator<Point> {
    @Override
    public int compare(Point p1, Point p2) {
        if (p1.getLen() == p2.getLen()) {
            return 0;
        } else {
            return (p1.getLen() > p2.getLen()) ? -1 : 1;
        }
    }
}