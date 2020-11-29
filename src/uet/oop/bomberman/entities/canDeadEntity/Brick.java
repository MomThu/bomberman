package uet.oop.bomberman.entities.canDeadEntity;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.graphics.Sprite;

public class Brick extends CanDeadEntity {

    public Brick (int x, int y, Image img) {
        super(x, y, img);
    }

    @Override
    public void deadMoment() {
        if (isDead()) {
            if (time == 0) {
                img = Sprite.brick_exploded.getFxImage();
            }
            time ++;
        }
        if (time == 5) {
            img = Sprite.brick_exploded1.getFxImage();
        } else if (time == 10) {
            img = Sprite.brick_exploded2.getFxImage();
        } else if (time > 10) {
            int Y = y / 32;
            int X = x / 32;
            BombermanGame.map[Y] = BombermanGame.map[Y].substring(0, X) + " " + BombermanGame.map[Y].substring(X+1, BombermanGame.map[Y].length());
        }
    }

    @Override
    public void update() {
        deadMoment();
    }
}
