package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.sound.SoundEffects;

public class DetonatorItem extends Item {
    public DetonatorItem (int x, int y, Image img) {
        super(x, y, img);
    }

    public void collectItem(Bomber bomber) {
        int X = x / 32;
        int Y = y / 32;
        int X1 = (bomber.x + 2) / 32;
        int X2 = (bomber.x + 22) / 32;
        int Y1 = (bomber.y + 2) / 32;
        int Y2 = (bomber.y + 30) / 32;
        if ((X1 == X && Y1 == Y)
                || (X1 == X && Y2 == Y)
                || (X2 == X && Y1 == Y)
                || (X2 == X && Y2 == Y)) {
            setDead(true);
            setTime(0);
            if (BombermanGame.heart < 5) {
                BombermanGame.heart++;
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
