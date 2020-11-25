package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

import java.util.ArrayList;
import java.util.List;

public class Bomb extends Entity {

    private int time = 0;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public Bomb (int x, int y, Image img) {
        super(x, y, img);
    }


    public List<Flame> createFlame(Bomber bomber, List<Brick> bricks) {
        /**List<Flame> newFlames = new ArrayList<>();
        int X = (x + 16) / 32;
        int Y = (y + 16) / 32;
        int X1 = X - 1;
        int X2 = X + 1;
        int Y1 = Y - 1;
        int Y2 = Y + 1;
        if (time == 120) {
            if (BombermanGame.map[Y1].charAt(X) != '#') {
                Flame newFlame = new Flame(X, Y1, Sprite.explosion_vertical.getFxImage(),"vertical");
                newFlames.add(newFlame);
            }
            if (BombermanGame.map[Y2].charAt(X) != '#') {
                Flame newFlame = new Flame(X, Y2, Sprite.explosion_vertical.getFxImage(), "vertical");
                newFlames.add(newFlame);
            }
            if (BombermanGame.map[Y].charAt(X1) != '#') {
                Flame newFlame = new Flame(X1, Y, Sprite.explosion_horizontal.getFxImage(), "horizontal");
                newFlames.add(newFlame);
            }
            if (BombermanGame.map[Y].charAt(X2) != '#') {
                Flame newFlame = new Flame(X2, Y, Sprite.explosion_horizontal.getFxImage(), "horizontal");
                newFlames.add(newFlame);
            }
        } else if (time >= 135) {
            newFlames.clear();
        }
        return newFlames;*/
        List<Flame> newFlames = new ArrayList<>();
        int X = this.get_x() / Sprite.SCALED_SIZE;
        int Y = this.get_y() / Sprite.SCALED_SIZE;
        int lengthOfBoom = bomber.getBombSize();
        for (int i = X + 1; i <= X + lengthOfBoom; ++i) {
            if (BombermanGame.map[Y].charAt(i) == '#') {
                break;
            }
            if (BombermanGame.map[Y].charAt(i) == '*') {
                Flame boomExploded = new Flame(i, Y, Sprite.explosion_horizontal_right_last.getFxImage(), "horizontal_right");
                newFlames.add(boomExploded);
                break;
            }
            if ((i < X + lengthOfBoom && BombermanGame.map[Y].charAt(i + 1) == '#')
                    || (i == X + lengthOfBoom)) {
                Flame boomExploded = new Flame(i, Y, Sprite.explosion_horizontal_right_last.getFxImage(), "horizontal_right");
                newFlames.add(boomExploded);
                break;
            }
            Flame boomExploded = new Flame(i, Y, Sprite.explosion_horizontal.getFxImage(), "horizontal");
            newFlames.add(boomExploded);
        }
        for (int i = X - 1; i >= X - lengthOfBoom; --i) {
            if (BombermanGame.map[Y].charAt(i) == '#') {
                break;
            }
            if (BombermanGame.map[Y].charAt(i) == '*') {
                Flame boomExploded = new Flame(i, Y, Sprite.explosion_horizontal_right_last.getFxImage(), "horizontal_left");
                newFlames.add(boomExploded);
                break;
            }
            if ((i > X - lengthOfBoom && BombermanGame.map[Y].charAt(i - 1) == '#')
                    || (i == X - lengthOfBoom)) {
                Flame boomExploded = new Flame(i, Y, Sprite.explosion_horizontal_left_last.getFxImage(), "horizontal_left");
                newFlames.add(boomExploded);
                break;
            }
            Flame boomExploded = new Flame(i, Y, Sprite.explosion_horizontal.getFxImage(), "horizontal");
            newFlames.add(boomExploded);
        }
        for (int j = Y + 1; j <= Y + lengthOfBoom; ++j) {
            if (BombermanGame.map[j].charAt(X) == '#') {
                break;
            }
            if (BombermanGame.map[j].charAt(X) == '*') {
                Flame boomExploded = new Flame(X, j, Sprite.explosion_vertical_down_last.getFxImage(), "vertical_down");
                newFlames.add(boomExploded);
                break;
            }
            if ((j < Y + lengthOfBoom && BombermanGame.map[j + 1].charAt(X) == '#')
                    || j == Y + lengthOfBoom) {
                Flame boomExploded = new Flame(X, j, Sprite.explosion_vertical_down_last.getFxImage(), "vertical_down");
                newFlames.add(boomExploded);
                break;
            }
            Flame boomExploded = new Flame(X, j, Sprite.explosion_vertical.getFxImage(), "vertical");
            newFlames.add(boomExploded);
        }
        for (int j = Y - 1; j >= Y - lengthOfBoom; --j) {
            if (BombermanGame.map[j].charAt(X) == '#') {
                break;
            }
            if (BombermanGame.map[j].charAt(X) == '*') {
                Flame boomExploded = new Flame(X, j, Sprite.explosion_vertical_top_last.getFxImage(), "vertical_top");
                newFlames.add(boomExploded);
                break;
            }
            if ((j > Y - lengthOfBoom && BombermanGame.map[j - 1].charAt(X) == '#')
                    || j == Y - lengthOfBoom) {
                Flame boomExploded = new Flame(X, j, Sprite.explosion_vertical_top_last.getFxImage(), "vertical_top");
                newFlames.add(boomExploded);
                break;
            }
            Flame boomExploded = new Flame(X, j, Sprite.explosion_vertical.getFxImage(), "vertical");
            newFlames.add(boomExploded);
        }
        return newFlames;
    }

    @Override
    public void update() {
        if (time == 0) {
            int X = x / 32;
            int Y = y / 32;
            BombermanGame.map[Y] = BombermanGame.map[Y].substring(0, X) + "B" + BombermanGame.map[Y].substring(X + 1);
        }
        if (time == 134) {
            int X = x / 32;
            int Y = y / 32;
            BombermanGame.map[Y] = BombermanGame.map[Y].substring(0, X) + "B" + BombermanGame.map[Y].substring(X + 1);
        }
        time ++;
        if (time >= 130) {
            img = Sprite.bomb_exploded2.getFxImage();
        }
        else if ( time >= 125) {
            img = Sprite.bomb_exploded1.getFxImage();
        }
        else if (time % 30 == 1) {
            img = Sprite.bomb.getFxImage();
        }
        else if (time % 30 == 10) {
            img = Sprite.bomb_1.getFxImage();
        }
        else if (time % 30 == 20) {
            img = Sprite.bomb_2.getFxImage();
        }
    }
}
