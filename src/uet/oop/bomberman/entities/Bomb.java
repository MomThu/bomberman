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


    public List<Flame> createFlame() {
        List<Flame> newFlames = new ArrayList<>();
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
        return newFlames;
    }

    @Override
    public void update() {
        createFlame();
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
