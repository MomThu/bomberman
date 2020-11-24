package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.bfs.BFS;
import uet.oop.bomberman.bfs.Point;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

public class Kondoria extends CanDeadEntity{
    public Kondoria(int x, int y, Image img) {
        super(x, y, img);
    }

    public char direction;
    public int ok = 0, ok1 = 0, ok2 = 0;

    @Override
    public void deadMoment() {

    }

    public void browse_row() {
        if (x >=0 && x <= 30*32) {
            if (BombermanGame.map[y/32].charAt(x/32 + 1) != '#' && ok == 0) {
                x++;
                if (x%30 == 0) {
                    img = Sprite.kondoria_right1.getFxImage();
                }
                else if (x%30 == 10) {
                    img = Sprite.kondoria_right2.getFxImage();
                }
                else if (x%30 == 20) {
                    img = Sprite.kondoria_right3.getFxImage();
                }
                ok = 0;
            }
            else if (BombermanGame.map[y/32].charAt(x/32 + 1) == '#' || ok == 1){
                if (ok == 0) {
                    x--;
                    if (x%30 == 0) {
                        img = Sprite.kondoria_left1.getFxImage();
                    }
                    else if (x%30 == 10) {
                        img = Sprite.kondoria_left2.getFxImage();
                    }
                    else if (x%30 == 20) {
                        img = Sprite.kondoria_left3.getFxImage();
                    }
                    ok = 1;
                }
                else {
                    if (BombermanGame.map[y/32].charAt((x-1)/32) == '#') {
                        ok = 0;
                        x++;
                        if (x%30 == 0) {
                            img = Sprite.kondoria_right1.getFxImage();
                        }
                        else if (x%30 == 10) {
                            img = Sprite.kondoria_right2.getFxImage();
                        }
                        else if (x%30 == 20) {
                            img = Sprite.kondoria_right3.getFxImage();
                        }
                    }
                    else {
                        x--;
                        if (x%30 == 0) {
                            img = Sprite.kondoria_left1.getFxImage();
                        }
                        else if (x%30 == 10) {
                            img = Sprite.kondoria_left2.getFxImage();
                        }
                        else if (x%30 == 20) {
                            img = Sprite.kondoria_left3.getFxImage();
                        }
                    }
                }
            }
        }
    }

    public void browse_column() {
        if (y >=0 && y <= 12*32) {
            if (BombermanGame.map[y/32+1].charAt(x/32) != '#' && ok1 == 0) {
                y++;
                if (y%30 == 0) {
                    img = Sprite.kondoria_left1.getFxImage();
                }
                else if (y%30 == 10) {
                    img = Sprite.kondoria_left2.getFxImage();
                }
                else if (y%30 == 20) {
                    img = Sprite.kondoria_left3.getFxImage();
                }
                ok1 = 0;
            }
            else if (BombermanGame.map[y/32+1].charAt(x/32) == '#' || ok1 == 1){
                if (ok1 == 0) {
                    y--;
                    if (y%30 == 0) {
                        img = Sprite.kondoria_left1.getFxImage();
                    }
                    else if (y%30 == 10) {
                        img = Sprite.kondoria_left2.getFxImage();
                    }
                    else if (y%30 == 20) {
                        img = Sprite.kondoria_left3.getFxImage();
                    }
                    ok1 = 1;
                }
                else {
                    if (BombermanGame.map[(y-1)/32].charAt(x/32) == '#') {
                        ok1 = 0;
                        y++;
                        if (y%30 == 0) {
                            img = Sprite.kondoria_left1.getFxImage();
                        }
                        else if (y%30 == 10) {
                            img = Sprite.kondoria_left2.getFxImage();
                        }
                        else if (y%30 == 20) {
                            img = Sprite.kondoria_left3.getFxImage();
                        }
                    }
                    else {
                        y--;
                        if (y%30 == 0) {
                            img = Sprite.kondoria_left1.getFxImage();
                        }
                        else if (y%30 == 10) {
                            img = Sprite.kondoria_left2.getFxImage();
                        }
                        else if (y%30 == 20) {
                            img = Sprite.kondoria_left3.getFxImage();
                        }
                    }
                }
            }

        }
    }

    @Override
    public void update() {
        int value;
        Random rd = new Random();
        value = rd.nextInt(2) + 1;
        if (ok2 == 0) browse_row();
        if (ok2 == 1) browse_column();
        if (y%32 == 0 && value == 2 && (BombermanGame.map[y/32].charAt(x/32+1) != '#'
                || BombermanGame.map[y/32].charAt((x-1)/32) != '#')) {
            ok2 = 0;
        }

        if (x%32 == 0 && value == 1 && (BombermanGame.map[y/32+1].charAt(x/32) != '#'
                || BombermanGame.map[(y-1)/32].charAt(x/32) != '#')) {
            ok2 = 1;
        }
    }
}
