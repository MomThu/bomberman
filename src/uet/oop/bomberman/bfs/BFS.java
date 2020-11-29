package uet.oop.bomberman.bfs;

import uet.oop.bomberman.BombermanGame;

import java.util.LinkedList;

public class BFS {
    boolean[][] visited = new boolean[BombermanGame.WIDTH][BombermanGame.HEIGHT];
    String[][] path = new String[BombermanGame.WIDTH][BombermanGame.HEIGHT];
    public void bfs (Point point) {
        for (int i = 0; i < BombermanGame.WIDTH; i++) {
            for (int j = 0; j < BombermanGame.HEIGHT; j++) {
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
            if (X <= BombermanGame.WIDTH - 1 && BombermanGame.map[Y].charAt(X) != '#'
                    && BombermanGame.map[Y].charAt(X) != '*'
                    && BombermanGame.map[Y].charAt(X) != 'B') {
                if (visited[X][Y] != true) {
                    visited[X][Y] = true;
                    Point newPoint = new Point(X, Y);
                    linkedList.add(newPoint);
                    path[X][Y] = "r";
                }
            }
            X = point1.x - 1; Y = point1.y;
            if (X >= 0 && BombermanGame.map[Y].charAt(X) != '#'
                    && BombermanGame.map[Y].charAt(X) != '*'
                    && BombermanGame.map[Y].charAt(X) != 'B') {
                if (visited[X][Y] != true) {
                    visited[X][Y] = true;
                    Point newPoint = new Point(X, Y);
                    linkedList.add(newPoint);
                    path[X][Y] = "l";
                }
            }
            X = point1.x; Y = point1.y + 1;
            if (Y <= BombermanGame.HEIGHT - 1 && BombermanGame.map[Y].charAt(X) != '#'
                    && BombermanGame.map[Y].charAt(X) != '*'
                    && BombermanGame.map[Y].charAt(X) != 'B') {
                if (visited[X][Y] != true) {
                    visited[X][Y] = true;
                    Point newPoint = new Point(X, Y);
                    linkedList.add(newPoint);
                    path[X][Y] = "d";
                }
            }
            X = point1.x; Y = point1.y - 1;
            if (Y >= 0 && BombermanGame.map[Y].charAt(X) != '#'
                    && BombermanGame.map[Y].charAt(X) != '*'
                    && BombermanGame.map[Y].charAt(X) != 'B') {
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
