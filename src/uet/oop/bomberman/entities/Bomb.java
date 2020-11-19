package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

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


    @Override
    public void update() {
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
