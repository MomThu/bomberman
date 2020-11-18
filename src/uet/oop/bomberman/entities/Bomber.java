package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

public class Bomber extends Entity {

    private static int speedX = 1;

    private static int speedY = 1;

    private int east, west, north, south;

    public static int getSpeedX() {
        return speedX;
    }

    public static int getSpeedY() {
        return speedY;
    }

    public static void setSpeedX(int speedX) {
        Bomber.speedX = speedX;
    }

    public static void setSpeedY(int speedY) {
        Bomber.speedY = speedY;
    }

    public Bomber(int x, int y, Image img) {
        super( x, y, img);
    }

    public void gotoEast() {
        east++;
        west = 0;
        north = 0;
        south = 0;
        x += speedX;
        int X = (x + 24) / 32;
        int Y = (y + 32) / 32;
        boolean checkImage = false;
        if (y % 32 > 3 && y % 32 < 29) {
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                x = X * 32 - 24;
                checkImage = true;
            }
            Y = y / 32;
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                x = X * 32 - 24;
                checkImage = true;
            }
        } else {
            if (y % 32 == 31 || y % 32 == 30 || y % 32 == 29) {
                Y = y / 32 + 1;
            }
            else {
                Y = y / 32;
            }
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                x = X * 32 -24;
                checkImage = true;
            }
        }
        if (checkImage) {
            img = Sprite.player_right.getFxImage();
        } else if (east % 4 <= 3) {
            img = Sprite.player_right_1.getFxImage();
        } else {
            img = Sprite.player_right_2.getFxImage();
        }
    }

    public void gotoWest() {
        east = 0;
        west++;
        north = 0;
        south = 0;
        x -= speedX;
        int X = x / 32;
        int Y = (y + 32) / 32;
        boolean checkImage = false;
        if (y % 32 > 3 && y % 32 < 29) {
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                x = X * 32 + 32;
                checkImage = true;
            }
            Y = y / 32;
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                x = X * 32 + 32;
                checkImage = true;
            }
        } else {
            if (y % 32 == 31 || y % 32 == 30 || y % 32 == 29) {
                Y = y / 32 + 1;
            }
            else {
                Y = y / 32;
            }
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                x = X * 32 + 32;
                checkImage = true;
            }
        }
        if (checkImage) {
            img = Sprite.player_left.getFxImage();
        } else if ( west % 4 <= 3) {
            img = Sprite.player_left_1.getFxImage();
        } else {
            img = Sprite.player_left_2.getFxImage();
        }
    }

    public void gotoNorth() {
        east = 0;
        west = 0;
        north++;
        south = 0;
        y -= speedY;
        int X = x / 32;
        int Y = y / 32;
        boolean checkImage = false;
        if (x % 32 > 3 && x % 32 < 29) {
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                y = Y * 32 + 32;
                checkImage = true;
            }
            X = (x + 22) / 32;
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                y = Y * 32 + 32;
                checkImage = true;
            }
        } else {
            if (x % 32 == 30 || x % 32 == 31 || x % 32 == 29){
                X = x / 32 + 1;
            } else {
                X = x / 32;
            }
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                y = Y * 32 + 32;
                checkImage = true;
            }
        }
        if (checkImage) {
            img = Sprite.player_up.getFxImage();
        } else if (north % 4 <= 3) {
            img = Sprite.player_up_1.getFxImage();
        } else {
            img = Sprite.player_up_2.getFxImage();
        }
    }

    public void gotoSouth() {
        east = 0;
        west = 0;
        north = 0;
        south++;
        y += speedY;
        int X = (x + 22) / 32;
        int Y = (y + 32) / 32;
        boolean checkImage = false;
        if (x % 32 > 3 && x % 32 < 29) {
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                y = Y * 32 - 32;
                checkImage = true;
            }
            X = x / 32;
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                y = Y * 32 - 32;
                checkImage = true;
            }
        } else {
            if (x % 32 == 30 || x % 32 == 31 || x % 32 == 29){
                X = x / 32 + 1;
            } else {
                X = x / 32;
            }
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                y = Y * 32 - 32;
                checkImage = true;
            }
        }
        if (checkImage) {
            img = Sprite.player_down.getFxImage();
        } else if (south % 4 <= 3) {
            img = Sprite.player_down_1.getFxImage();
        } else {
            img = Sprite.player_down_2.getFxImage();
        }
    }

    @Override
    public void update() {
        if (BombermanGame.gotoEast) {
            gotoEast();
        } else if (BombermanGame.gotoWest) {
            gotoWest();
        } else if (BombermanGame.gotoNorth) {
            gotoNorth();
        } else if (BombermanGame.gotoSouth) {
            gotoSouth();
        } else {
            if (east > 0) img = Sprite.player_right.getFxImage();
            else if (west > 0) img = Sprite.player_left.getFxImage();
            else if (north > 0) img = Sprite.player_up.getFxImage();
            else if (south > 0) img = Sprite.player_down.getFxImage();
        }
    }
}
