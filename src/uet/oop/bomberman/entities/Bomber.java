package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.bloom.Bomb;
import uet.oop.bomberman.entities.bloom.Flame;
import uet.oop.bomberman.entities.canDeadEntity.CanDeadEntity;
import uet.oop.bomberman.graphics.Sprite;
import uet.oop.bomberman.sound.SoundEffects;

import java.util.List;

public class Bomber extends Entity {

    private int bombSize = 1;

    private int numOfBomb = 2;

    public int getNumOfBomb() {
        return numOfBomb;
    }

    public void setNumOfBomb(int numOfBomb) {
        this.numOfBomb = numOfBomb;
    }

    public int getBombSize() {
        return bombSize;
    }

    public void setBombSize(int bombSize) {
        this.bombSize = bombSize;
    }

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

    private int speedX = 1;

    private int speedY = 1;

    private int east, west, north, south;

    public int getSpeedX() {
        return speedX;
    }

    public int getSpeedY() {
        return speedY;
    }

    public void setSpeedX(int speedX) {
        this.speedX = speedX;
    }

    public void setSpeedY(int speedY) {
        this.speedY = speedY;
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

    public void set_X(int x) {
        this.x = x;
    }

    public void set_Y(int y) {
        this.y = y;
    }

    public void set_Img(Image img) {
        this.img = img;
    }


    public void gotoEast() {
        east++;
        west = 0;
        north = 0;
        south = 0;
        boolean check = false;
        int X = (x + 2) / 32;
        int Y = (y + 2) / 32;
        int X1 = (x + 22) / 32;
        int Y1 = (y + 30) / 32;
        if (BombermanGame.map[Y].charAt(X) == 'B' || BombermanGame.map[Y].charAt(X1) == 'B'
                || BombermanGame.map[Y1].charAt(X) == 'B' || BombermanGame.map[Y1].charAt(X1) == 'B') {
            check = true;
        }
        x += speedX;
        X = (this.x + 24) / 32;
        Y = (y + 32) / 32;
        boolean checkImage = false;
        if (y % 32 > 3 && y % 32 < 29) {
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                this.x = X * 32 - 24;
                checkImage = true;
            }
            if (BombermanGame.map[Y].charAt(X) == 'B' && check == false) {
                this.x = X * 32 - 24;
                checkImage = true;
            }
            Y = y / 32;
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                this.x = X * 32 - 24;
                checkImage = true;
            }
            if (BombermanGame.map[Y].charAt(X) == 'B' && check == false) {
                this.x = X * 32 - 24;
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
                this.x = X * 32 -24;
                checkImage = true;
            }
            if (BombermanGame.map[Y].charAt(X) == 'B' && check == false) {
                this.x = X * 32 - 24;
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
        boolean check = false;
        int X = (x + 2) / 32;
        int Y = (y + 2) / 32;
        int X1 = (x + 22) / 32;
        int Y1 = (y + 30) / 32;
        if (BombermanGame.map[Y].charAt(X) == 'B' || BombermanGame.map[Y].charAt(X1) == 'B'
                || BombermanGame.map[Y1].charAt(X) == 'B' || BombermanGame.map[Y1].charAt(X1) == 'B') {
            check = true;
        }
        x -= speedX;
        X = this.x / 32;
        Y = (y + 32) / 32;
        boolean checkImage = false;
        if (y % 32 > 3 && y % 32 < 29) {
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                this.x = X * 32 + 32;
                checkImage = true;
            }
            if (BombermanGame.map[Y].charAt(X) == 'B' && check == false) {
                this.x = X * 32 + 32;
                checkImage = true;
            }
            Y = y / 32;
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                this.x = X * 32 + 32;
                checkImage = true;
            }
            if (BombermanGame.map[Y].charAt(X) == 'B' && check == false) {
                this.x = X * 32 + 32;
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
                this.x = X * 32 + 32;
                checkImage = true;
            }
            if (BombermanGame.map[Y].charAt(X) == 'B' && check == false) {
                this.x = X * 32 + 32;
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
        boolean check = false;
        int X = (x + 2) / 32;
        int Y = (y + 2) / 32;
        int X1 = (x + 22) / 32;
        int Y1 = (y + 30) / 32;
        if (BombermanGame.map[Y].charAt(X) == 'B' || BombermanGame.map[Y].charAt(X1) == 'B'
                || BombermanGame.map[Y1].charAt(X) == 'B' || BombermanGame.map[Y1].charAt(X1) == 'B') {
            check = true;
        }
        y -= speedY;
        X = this.x / 32;
        Y = y / 32;
        boolean checkImage = false;
        if (this.x % 32 > 3 && this.x % 32 < 29) {
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                y = Y * 32 + 32;
                checkImage = true;
            }
            if (BombermanGame.map[Y].charAt(X) == 'B' && check == false) {
                y = Y * 32 + 32;
                checkImage = true;
            }
            X = (this.x + 22) / 32;
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                y = Y * 32 + 32;
                checkImage = true;
            }
            if (BombermanGame.map[Y].charAt(X) == 'B' && check == false) {
                y = Y * 32 + 32;
                checkImage = true;
            }
        } else {
            if (this.x % 32 == 30 || this.x % 32 == 31 || this.x % 32 == 29){
                X = this.x / 32 + 1;
            } else {
                X = this.x / 32;
            }
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                y = Y * 32 + 32;
                checkImage = true;
            }
            if (BombermanGame.map[Y].charAt(X) == 'B' && check == false) {
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
        boolean check = false;
        int X = (x + 2) / 32;
        int Y = (y + 2) / 32;
        int X1 = (x + 22) / 32;
        int Y1 = (y + 30) / 32;
        if (BombermanGame.map[Y].charAt(X) == 'B' || BombermanGame.map[Y].charAt(X1) == 'B'
                || BombermanGame.map[Y1].charAt(X) == 'B' || BombermanGame.map[Y1].charAt(X1) == 'B') {
            check = true;
        }
        y += speedY;
        X = (this.x + 22) / 32;
        Y = (y + 32) / 32;
        boolean checkImage = false;
        if (this.x % 32 > 3 && this.x % 32 < 29) {
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                y = Y * 32 - 32;
                checkImage = true;
            }
            if (BombermanGame.map[Y].charAt(X) == 'B' && check == false) {
                y = Y * 32 - 32;
                checkImage = true;
            }
            X = this.x / 32;
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                y = Y * 32 - 32;
                checkImage = true;
            }
            if (BombermanGame.map[Y].charAt(X) == 'B' && check == false) {
                y = Y * 32 - 32;
                checkImage = true;
            }
        } else {
            if (this.x % 32 == 30 || this.x % 32 == 31 || this.x % 32 == 29){
                X = this.x / 32 + 1;
            } else {
                X = this.x / 32;
            }
            if (BombermanGame.map[Y].charAt(X) == '#' || BombermanGame.map[Y].charAt(X) == '*') {
                y = Y * 32 - 32;
                checkImage = true;
            }
            if (BombermanGame.map[Y].charAt(X) == 'B' && check == false) {
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

    public void collideToDead(List<Flame> flames, List<CanDeadEntity> enemies, List<Bomb> bombs) {
        int X1 = (x + 3) / 32;
        int Y1 = (y + 3) / 32;
        int X2 = (x + 21) / 32;
        int Y2 = (y + 29) / 32;
        int X3 = (x + 12) / 32;
        int Y3 = (y + 16) / 32;
        for (Flame flame: flames) {
            if (flame.getX() == X3 && flame.getY() == Y3) {
                setDead(true);
                setTime(0);
            }
        }
        for (CanDeadEntity entity: enemies) {
            if (((entity.get_x() / 32) == X1 && entity.get_y() / 32 == Y1)
                    || (entity.get_x() / 32 == X1 && entity.get_y() / 32 == Y2)
                    || (entity.get_x() / 32 == X2 && entity.get_y() / 32 == Y1)
                    || (entity.get_x() / 32 == X2 && entity.get_y() / 32 == Y2)) {
                setDead(true);
                setTime(0);
            }
        }
        for (Bomb bomb: bombs) {
            if (bomb.get_x() / 32 == X3 && bomb.get_y() / 32 == Y3 && bomb.getTime() >= 180) {
                setDead(true);
                setTime(0);
            }
        }
    }

    public void deadBomber() {
        if (isDead()) {
            if (time == 0) {
                SoundEffects.play("AA126_11");
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
        else if (time ==15) {
            SoundEffects.play("endgame3");
        }
    }

    @Override
    public void update() {
        deadBomber();
        if (isDead) return;
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
