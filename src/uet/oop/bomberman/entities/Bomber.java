package uet.oop.bomberman.entities;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

import java.util.List;

public class Bomber extends Entity {

    private boolean isDead;

    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    private int time;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

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

    public int getX() {
        return (x + 12) / 32;
    }

    public int getY() {
        return (y + 16) / 32;
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
        } else if (east % 8 <= 3) {
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
        } else if ( west % 8 <= 3) {
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
        } else if (north % 8 <= 3) {
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
        } else if (south % 8 <= 3) {
            img = Sprite.player_down_1.getFxImage();
        } else {
            img = Sprite.player_down_2.getFxImage();
        }
    }

    public void collideToDead(List<Flame> flames, List<Balloom> ballooms, List<Oneal> oneals) {
        int X1 = (x + 3) / 32;
        int Y1 = (y + 3) / 32;
        int X2 = (x + 24) / 32;
        int Y2 = (y + 32) / 32;
        for (Flame flame: flames) {
            if ((flame.getX() == X1 && flame.getY() == Y1)
                    || (flame.getX() == X1 && flame.getY() == Y2)
                    || (flame.getX() == X2 && flame.getY() == Y1)
                    || (flame.getX() == X2 && flame.getY() == Y2)) {
                setDead(true);
                setTime(0);
            }
        }
        for (Balloom balloom: ballooms) {
            if ((balloom.getX() == X1 && balloom.getY() == Y1)
                    || (balloom.getX() == X1 && balloom.getY() == Y2)
                    || (balloom.getX() == X2 && balloom.getY() == Y1)
                    || (balloom.getX() == X2 && balloom.getY() == Y2)) {
                setDead(true);
                setTime(0);
            }
        }
        for (Oneal oneal: oneals) {
            if ((oneal.getX() == X1 && oneal.getY() == Y1)
                    || (oneal.getX() == X1 && oneal.getY() == Y2)
                    || (oneal.getX() == X2 && oneal.getY() == Y1)
                    || (oneal.getX() == X2 && oneal.getY() == Y2)) {
                setDead(true);
                setTime(0);
            }
        }
    }

    public void deadBomber() {
        if (isDead) {
            if (time == 0) {
                img = Sprite.player_dead1.getFxImage();
            }
            time ++;
        }
        if (time == 5) {
            img = Sprite.player_dead2.getFxImage();
        }
        else if (time == 10) {
            img = Sprite.player_dead3.getFxImage();
        }

    }

    @Override
    public void update() {
        deadBomber();
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
