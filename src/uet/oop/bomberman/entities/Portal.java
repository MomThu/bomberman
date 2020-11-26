package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.getMap.GetMap;

public class Portal extends Entity {
    public Portal (int x, int y, Image img) {
        super(x, y, img);
    }

    public int goToNewLevel(Bomber bomber) {
        int X = (x + 16) / 32;
        int Y = (y + 16) / 32;
        int X1 = (bomber.x + 12) / 32;
        int Y1 = (bomber.y + 16) / 32;
        if (X1 == X && Y1 == Y && BombermanGame.level <= 5) {
            BombermanGame.level++;
            return BombermanGame.level;
        }
        return 0;
    }

    @Override
    public void update() {
        goToNewLevel(BombermanGame.bomberman);
    }
}
