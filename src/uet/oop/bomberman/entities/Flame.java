package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.graphics.Sprite;

import java.util.List;

public class Flame extends Entity{

    private String typeExplosion;

    private int time = 0;

    public int getX() {
        return x / 32;
    }

    public int getY() {
        return y / 32;
    }

    public String getTypeExplosion() {
        return typeExplosion;
    }

    public void setTypeExplosion(String typeExplosion) {
        this.typeExplosion = typeExplosion;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public Flame(int xUnit, int yUnit, Image img, String typeExplosion) {
        super(xUnit, yUnit, img);
        this.typeExplosion = typeExplosion;
    }

    public void killObjects(List<CanDeadEntity> canDeadObjects) {
        int X = x / 32;
        int Y = y / 32;
        for (CanDeadEntity entity: canDeadObjects) {
            int X1 = entity.x / 32;
            int X2 = (entity.x + 32) / 32;
            int Y1 = entity.y / 32;
            int Y2 = (entity.y + 32) / 32;
            if ((X1 == X && Y1 == Y)
                    || (X1 == X && Y2 == Y)
                    || (X2 == X && Y1 == Y)
                    || (X2 == X && Y2 == Y)) {
                entity.setDead(true);
                entity.setTime(0);
            }
        }
    }

    @Override
    public void update() {
        time ++;
        if (time == 3) {
            switch (typeExplosion) {
                case "horizontal":
                    img = Sprite.explosion_horizontal.getFxImage();
                    break;
                case "vertical":
                    img = Sprite.explosion_vertical.getFxImage();
                    break;
                case "horizontal_right":
                    img = Sprite.explosion_horizontal_right_last.getFxImage();
                    break;
                case "horizontal_left":
                    img = Sprite.explosion_horizontal_left_last.getFxImage();
                    break;
                case "vertical_down":
                    img = Sprite.explosion_vertical_down_last.getFxImage();
                    break;
                case "vertical_top":
                    img = Sprite.explosion_vertical_top_last.getFxImage();
                    break;
            }
        }
        else if (time == 6) {
            switch (typeExplosion) {
                case "horizontal":
                    img = Sprite.explosion_horizontal1.getFxImage();
                    break;
                case "vertical":
                    img = Sprite.explosion_vertical1.getFxImage();
                    break;
                case "horizontal_right":
                    img = Sprite.explosion_horizontal_right_last1.getFxImage();
                    break;
                case "horizontal_left":
                    img = Sprite.explosion_horizontal_left_last1.getFxImage();
                    break;
                case "vertical_down":
                    img = Sprite.explosion_vertical_down_last1.getFxImage();
                    break;
                case "vertical_top":
                    img = Sprite.explosion_vertical_top_last1.getFxImage();
                    break;
            }
        }
        else if(time == 10) {
            switch (typeExplosion) {
                case "horizontal":
                    img = Sprite.explosion_horizontal2.getFxImage();
                    break;
                case "vertical":
                    img = Sprite.explosion_vertical2.getFxImage();
                    break;
                case "horizontal_right":
                    img = Sprite.explosion_horizontal_right_last2.getFxImage();
                    break;
                case "horizontal_left":
                    img = Sprite.explosion_horizontal_left_last2.getFxImage();
                    break;
                case "vertical_down":
                    img = Sprite.explosion_vertical_down_last2.getFxImage();
                    break;
                case "vertical_top":
                    img = Sprite.explosion_vertical_top_last2.getFxImage();
                    break;
            }
        }
    }
}

