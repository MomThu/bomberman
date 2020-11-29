package uet.oop.bomberman.entities.item;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.sound.SoundEffects;

public class FlameItem extends Item {
    public FlameItem (int x, int y, Image img) {
        super(x, y, img);
    }

    public void collectItem(Bomber bomber) {
        int X = x / 32;
        int Y = y / 32;
        int X1 = (bomber.get_x() + 2) / 32;
        int X2 = (bomber.get_x() + 22) / 32;
        int Y1 = (bomber.get_y() + 2) / 32;
        int Y2 = (bomber.get_y() + 30) / 32;
        if ((X1 == X && Y1 == Y)
                || (X1 == X && Y2 == Y)
                || (X2 == X && Y1 == Y)
                || (X2 == X && Y2 == Y)) {
            this.setDead(true);
            this.setTime(0);
            if (bomber.getBombSize() < 4) {
                bomber.setBombSize(bomber.getBombSize() + 1);
            }
        }
    }

    @Override
    public void update() {
        collectItem(BombermanGame.bomberman);
        if (isDead()) {
            if (time == 0) {
                SoundEffects.play("Item");
            }
        }
    }

    @Override
    public void deadMoment() {

    }
}
