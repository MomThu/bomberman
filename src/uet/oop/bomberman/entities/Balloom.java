package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.getMap.GetMap;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Random;

public class Balloom extends Entity {
    int ok = 0, ok1 = 0, ok2 = 0;
    int vt1 = 0, vt2 = 0;

    private int time;
    private boolean isDead;

    public void setTime(int time) {
        this.time = time;
    }

    public int getTime() {
        return time;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    public boolean isDead() {
        return isDead;
    }

    public Balloom(int x, int y, Image img) {
        super(x, y, img);
    }

    public int getX() {
        return x / 32;
    }

    public int getY() {
        return y / 32;
    }

    public void browse_row() {
        if (x >=0 && x <= 30*32) {
            if ((BombermanGame.map[y/32].charAt(x/32 + 1) != '#'
                    && BombermanGame.map[y/32].charAt(x/32 + 1) != '*') && ok == 0) {
                x++;
                if (x%30 == 0) {
                    img = Sprite.balloom_right1.getFxImage();
                }
                else if (x%30 == 10) {
                    img = Sprite.balloom_right2.getFxImage();
                }
                else if (x%30 == 20) {
                    img = Sprite.balloom_right3.getFxImage();
                }
                ok = 0;
            }
            else if (BombermanGame.map[y/32].charAt(x/32 + 1) == '#'
                    || BombermanGame.map[y/32].charAt(x/32 + 1) == '*' || ok == 1){
                if (BombermanGame.map[y/32].charAt(x/32 + 1) == '#'
                        || BombermanGame.map[y/32].charAt(x/32 + 1) == '*') {
                    vt1 = x;
                }
                if (ok == 0) {
                    x--;
                    if (x%30 == 0) {
                        img = Sprite.balloom_left1.getFxImage();
                    }
                    else if (x%30 == 10) {
                        img = Sprite.balloom_left2.getFxImage();
                    }
                    else if (x%30 == 20) {
                        img = Sprite.balloom_left3.getFxImage();
                    }
                    ok = 1;
                }
                else {
                    if (BombermanGame.map[y/32].charAt((x-1)/32) == '#'
                            || BombermanGame.map[y/32].charAt((x-1)/32) == '*') {
                        vt2 = x;
                        ok = 0;
                        x++;
                        if (x%30 == 0) {
                            img = Sprite.balloom_right1.getFxImage();
                        }
                        else if (x%30 == 10) {
                            img = Sprite.balloom_right2.getFxImage();
                        }
                        else if (x%30 == 20) {
                            img = Sprite.balloom_right3.getFxImage();
                        }
                    }
                    else {
                        x--;
                        if (x%30 == 0) {
                            img = Sprite.balloom_left1.getFxImage();
                        }
                        else if (x%30 == 10) {
                            img = Sprite.balloom_left2.getFxImage();
                        }
                        else if (x%30 == 20) {
                            img = Sprite.balloom_left3.getFxImage();
                        }
                    }
                }
            }
        }
    }

    public void browse_column() {
        if (y >=0 && y <= 12*32) {
            if ((BombermanGame.map[y/32+1].charAt(x/32) != '#'
                    && BombermanGame.map[y/32+1].charAt(x/32) != '*') && ok1 == 0) {
                y++;
                if (y%30 == 0) {
                    img = Sprite.balloom_left1.getFxImage();
                }
                else if (y%30 == 10) {
                    img = Sprite.balloom_left2.getFxImage();
                }
                else if (y%30 == 20) {
                    img = Sprite.balloom_left3.getFxImage();
                }
                ok1 = 0;
            }
            else if (BombermanGame.map[y/32+1].charAt(x/32) == '#'
                    || BombermanGame.map[y/32+1].charAt(x/32) == '*' || ok1 == 1){
                if (ok1 == 0) {
                    y--;
                    if (y%30 == 0) {
                        img = Sprite.balloom_left1.getFxImage();
                    }
                    else if (y%30 == 10) {
                        img = Sprite.balloom_left2.getFxImage();
                    }
                    else if (y%30 == 20) {
                        img = Sprite.balloom_left3.getFxImage();
                    }
                    ok1 = 1;
                }
                else {
                    if (BombermanGame.map[(y-1)/32].charAt(x/32) == '#'
                            || BombermanGame.map[(y-1)/32].charAt(x/32) == '*') {
                        //vt2 = x;
                        ok1 = 0;
                        y++;
                        if (y%30 == 0) {
                            img = Sprite.balloom_left1.getFxImage();
                        }
                        else if (y%30 == 10) {
                            img = Sprite.balloom_left2.getFxImage();
                        }
                        else if (y%30 == 20) {
                            img = Sprite.balloom_left3.getFxImage();
                        }
                    }
                    else {
                        y--;
                        if (y%30 == 0) {
                            img = Sprite.balloom_left1.getFxImage();
                        }
                        else if (y%30 == 10) {
                            img = Sprite.balloom_left2.getFxImage();
                        }
                        else if (y%30 == 20) {
                            img = Sprite.balloom_left3.getFxImage();
                        }
                    }
                }
            }

        }
    }

    public void collideFlame(List<Flame> flames) {

    }

    @Override
    public void update() {
        int value;
        Random rd = new Random();
        value = rd.nextInt(2) + 1;
        if (ok2 == 0) browse_row();
        if (ok2 == 1) browse_column();
        if (y%32 == 0 && value == 2 && ((BombermanGame.map[y/32].charAt(x/32+1) != '#'
                && BombermanGame.map[y/32].charAt(x/32+1) != '*')
                || (BombermanGame.map[y/32].charAt((x-1)/32) != '#'
                && BombermanGame.map[y/32].charAt((x-1)/32) != '*'))) {
            ok2 = 0;
        }

        if (x%32 == 0 && value == 1 && ((BombermanGame.map[y/32+1].charAt(x/32) != '#'
                && BombermanGame.map[y/32+1].charAt(x/32) != '*')
                || (BombermanGame.map[(y-1)/32].charAt(x/32) != '#'
                && BombermanGame.map[(y-1)/32].charAt(x/32) != '*'))) {
            ok2 = 1;
        }
    }
}
