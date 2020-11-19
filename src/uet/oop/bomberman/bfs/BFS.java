package uet.oop.bomberman.bfs;

import uet.oop.bomberman.BombermanGame;

import javax.swing.plaf.IconUIResource;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    boolean[][] visited = new boolean[31][13];
    String[][] path = new String[31][13];
    public void bfs (Point point) {
        for (int i = 0; i < 31; i++) {
            for (int j = 0; j < 13; j++) {
                visited[i][j] = false;
                Point p = new Point(i, j);
                path[i][j] = "";
            }
        }
        LinkedList<Point> linkedList = new LinkedList<>();
        visited[point.x][point.y] = true;
        linkedList.add(point);
        while (linkedList.isEmpty() != true) {
            Point point1 = linkedList.pollFirst();
            int X, Y;
            X = point1.x + 1; Y = point1.y;
            if (X <= 30 && BombermanGame.map[Y].charAt(X) != '#'
            && BombermanGame.map[Y].charAt(X) != '*') {
                if (visited[X][Y] != true) {
                    visited[X][Y] = true;
                    Point newPoint = new Point(X, Y);
                    linkedList.add(newPoint);
                    path[X][Y] = "r";
                }
            }
            X = point1.x - 1; Y = point1.y;
            if (X >= 0 && BombermanGame.map[Y].charAt(X) != '#'
                    && BombermanGame.map[Y].charAt(X) != '*') {
                if (visited[X][Y] != true) {
                    visited[X][Y] = true;
                    Point newPoint = new Point(X, Y);
                    linkedList.add(newPoint);
                    path[X][Y] = "l";
                }
            }
            X = point1.x; Y = point1.y + 1;
            if (Y <= 12 && BombermanGame.map[Y].charAt(X) != '#'
                    && BombermanGame.map[Y].charAt(X) != '*') {
                if (visited[X][Y] != true) {
                    visited[X][Y] = true;
                    Point newPoint = new Point(X, Y);
                    linkedList.add(newPoint);
                    path[X][Y] = "d";
                }
            }
            X = point1.x; Y = point1.y - 1;
            if (Y >= 0 && BombermanGame.map[Y].charAt(X) != '#'
                    && BombermanGame.map[Y].charAt(X) != '*') {
                if (visited[X][Y] != true) {
                    visited[X][Y] = true;
                    Point newPoint = new Point(X, Y);
                    linkedList.add(newPoint);
                    path[X][Y] = "u";
                }
            }
        }
    }

    public String resultPath (Point point1, Point point2) {
        String result = " ";
        bfs(point2);
        if (visited[point1.x][point1.y] == false) return " ";

        System.out.println(point2.x + " " + point2.y);
        while (point1.equals(point2) != true) {
            System.out.println(point1.x + " " + point1.y);
            String direction = path[point1.x][point1.y];
            result = direction + result;
            if (direction == "l") {
                point1.x ++;
            }
            else if (direction == "r") {
                point1.x --;
            }
            else if (direction == "d") {
                point1.y --;
            }
            else if (direction == "u") {
                point1.y ++;
            }
        }
        return result;
    }
}
