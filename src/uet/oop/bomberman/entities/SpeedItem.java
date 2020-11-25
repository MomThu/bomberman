package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;

import java.util.List;

public class SpeedItem extends Item{
    public SpeedItem (int x, int y, Image img) {
        super(x, y, img);
    }

    public void collectItem(Bomber bomber) {
        int X = x / 32;
        int Y = y / 32;
        int X1 = (bomber.x + 2) / 32;
        int X2 = (bomber.x + 30) / 32;
        int Y1 = (bomber.y + 2) / 32;
        int Y2 = (bomber.y + 30) / 32;
        if ((X1 == X && Y1 == Y)
                || (X1 == X && Y2 == Y)
                || (X2 == X && Y1 == Y)
                || (X2 == X && Y2 == Y)) {
            this.setDead(true);
            this.setTime(0);
            bomber.setSpeedX(bomber.getSpeedX() + 1);
            bomber.setSpeedY(bomber.getSpeedY() + 1);
        }
    }

    @Override
    public void update() {
        collectItem(BombermanGame.bomberman);
    }

    @Override
    public void deadMoment() {

    }
}
