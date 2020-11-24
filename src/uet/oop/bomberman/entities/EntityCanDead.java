package uet.oop.bomberman.entities;

import javafx.scene.image.Image;

public abstract class EntityCanDead extends Entity {
    protected boolean dead;

    public EntityCanDead(int x, int y, Image img) {
        super(x, y, img);
        dead = false;
    }

    public boolean getDead() {
        return dead;
    }
    public void setDead(boolean dead) {
        this.dead = dead;
    }
    public abstract void whenDead();
}
