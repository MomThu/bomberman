package uet.oop.bomberman.entities.canDeadEntity;

import javafx.scene.image.Image;
import uet.oop.bomberman.entities.Entity;

public abstract class CanDeadEntity extends Entity {
    protected boolean dead;

    protected int time;

    public CanDeadEntity(int x, int y, Image img) {
        super(x, y, img);
        dead = false;
        time = 0;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int timing) {
        this.time = timing;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }

    public abstract void deadMoment();
}
