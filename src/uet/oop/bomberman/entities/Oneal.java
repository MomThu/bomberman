package uet.oop.bomberman.entities;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.bfs.BFS;
import uet.oop.bomberman.bfs.Point;
import uet.oop.bomberman.getMap.GetMap;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

public class Oneal extends Entity {
    public Oneal(int x, int y, Image img) {
        super(x, y, img);
    }

    public char direction;
    public int ok = 0, ok1 = 0, ok2 = 0;
    public int vt1 = 0, vt2 = 0;

    public void browse_row() {
        if (x >=0 && x <= 30*32) {
            if ((BombermanGame.map[y/32].charAt(x/32 + 1) != '#'
                    && BombermanGame.map[y/32].charAt(x/32 + 1) != '*') && ok == 0) {
                x++;
                if (x%30 == 0) {
                    img = Sprite.oneal_right1.getFxImage();
                }
                else if (x%30 == 10) {
                    img = Sprite.oneal_right2.getFxImage();
                }
                else if (x%30 == 20) {
                    img = Sprite.oneal_right3.getFxImage();
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
                        img = Sprite.oneal_left1.getFxImage();
                    }
                    else if (x%30 == 10) {
                        img = Sprite.oneal_left2.getFxImage();
                    }
                    else if (x%30 == 20) {
                        img = Sprite.oneal_left3.getFxImage();
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
                            img = Sprite.oneal_right1.getFxImage();
                        }
                        else if (x%30 == 10) {
                            img = Sprite.oneal_right2.getFxImage();
                        }
                        else if (x%30 == 20) {
                            img = Sprite.oneal_right3.getFxImage();
                        }
                    }
                    else {
                        x--;
                        if (x%30 == 0) {
                            img = Sprite.oneal_left1.getFxImage();
                        }
                        else if (x%30 == 10) {
                            img = Sprite.oneal_left2.getFxImage();
                        }
                        else if (x%30 == 20) {
                            img = Sprite.oneal_left3.getFxImage();
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
                    img = Sprite.oneal_left1.getFxImage();
                }
                else if (y%30 == 10) {
                    img = Sprite.oneal_left2.getFxImage();
                }
                else if (y%30 == 20) {
                    img = Sprite.oneal_left3.getFxImage();
                }
                ok1 = 0;
            }
            else if (BombermanGame.map[y/32+1].charAt(x/32) == '#'
                    || BombermanGame.map[y/32+1].charAt(x/32) == '*' || ok1 == 1){
                if (ok1 == 0) {
                    y--;
                    if (y%30 == 0) {
                        img = Sprite.oneal_left1.getFxImage();
                    }
                    else if (y%30 == 10) {
                        img = Sprite.oneal_left2.getFxImage();
                    }
                    else if (y%30 == 20) {
                        img = Sprite.oneal_left3.getFxImage();
                    }
                    ok1 = 1;
                }
                else {
                    if (BombermanGame.map[(y-1)/32].charAt(x/32) == '#'
                            || BombermanGame.map[(y-1)/32].charAt(x/32) == '*') {
                        ok1 = 0;
                        y++;
                        if (y%30 == 0) {
                            img = Sprite.oneal_left1.getFxImage();
                        }
                        else if (y%30 == 10) {
                            img = Sprite.oneal_left2.getFxImage();
                        }
                        else if (y%30 == 20) {
                            img = Sprite.oneal_left3.getFxImage();
                        }
                    }
                    else {
                        y--;
                        if (y%30 == 0) {
                            img = Sprite.oneal_left1.getFxImage();
                        }
                        else if (y%30 == 10) {
                            img = Sprite.oneal_left2.getFxImage();
                        }
                        else if (y%30 == 20) {
                            img = Sprite.oneal_left3.getFxImage();
                        }
                    }
                }
            }

        }
    }

    @Override
    public void update() {
        BFS bfs = new BFS();
        Point point2 = new Point(x/32, y/32);
        Point point1 = new Point(BombermanGame.bomberman.getX(), BombermanGame.bomberman.getY());
        if (x%32 == 0 && y%32 == 0) {
            direction = bfs.resultPath(point1, point2).charAt(0);
        }
        if (direction == 'l') x--;
        if (direction == 'r') x++;
        if (direction == 'd') y++;
        if (direction == 'u') y--;
        if (direction == ' ') {
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
}