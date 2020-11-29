package uet.oop.bomberman.entities.stillObjects;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.Bomber;
import uet.oop.bomberman.entities.Entity;

public class Portal extends Entity {
    public Portal (int x, int y, Image img) {
        super(x, y, img);
    }

    public int goToNewLevel(Bomber bomber) {
        int X = (x + 16) / 32;
        int Y = (y + 16) / 32;
        int X1 = (bomber.get_x() + 12) / 32;
        int Y1 = (bomber.get_y() + 16) / 32;
        if (X1 == X && Y1 == Y && BombermanGame.level <= 5) {
            return 1;
        }
        return 0;
    }

    @Override
    public void update() {
        goToNewLevel(BombermanGame.bomberman);
    }
}
