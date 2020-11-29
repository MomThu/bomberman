package uet.oop.bomberman.entities.canDeadEntity.enemies;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.bfs.BFS;
import uet.oop.bomberman.bfs.Point;
import uet.oop.bomberman.entities.canDeadEntity.CanDeadEntity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

public class Oneal extends CanDeadEntity {
    public Oneal(int x, int y, Image img) {
        super(x, y, img);
    }

    public int getX() {
        return x / 32;
    }

    public int getY() {
        return y / 32;
    }

    public char direction;
    public int ok = 0, ok1 = 0, ok2 = 0;
    public int vt1 = 0, vt2 = 0;
    public int speed = 1;

    public void browse_row() {
        if (x >=0 && x <= (BombermanGame.WIDTH - 1)*32) {
            if ((BombermanGame.map[y/32].charAt(x/32 + 1) != '#'
                    && BombermanGame.map[y/32].charAt(x/32 + 1) != '*'
                    && BombermanGame.map[y/32].charAt(x/32 + 1) != 'B') && ok == 0) {
                x+=speed;
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
                    || BombermanGame.map[y/32].charAt(x/32 + 1) == '*'
                    || BombermanGame.map[y/32].charAt(x/32 + 1) == 'B' || ok == 1){
                if (ok == 0) {
                    x-=speed;
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
                            || BombermanGame.map[y/32].charAt((x-1)/32) == '*'
                            || BombermanGame.map[y/32].charAt((x-1)/32) == 'B') {
                        vt2 = x;
                        ok = 0;
                        x+=speed;
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
                        x-=speed;
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
        if (y >=0 && y <= (BombermanGame.HEIGHT - 1)*32) {
            if ((BombermanGame.map[y/32+1].charAt(x/32) != '#'
                    && BombermanGame.map[y/32+1].charAt(x/32) != '*'
                    && BombermanGame.map[y/32+1].charAt(x/32) != 'B') && ok1 == 0) {
                y+=speed;
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
                    || BombermanGame.map[y/32+1].charAt(x/32) == '*'
                    || BombermanGame.map[y/32+1].charAt(x/32) == 'B' || ok1 == 1){
                if (ok1 == 0) {
                    y-=speed;
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
                            || BombermanGame.map[(y-1)/32].charAt(x/32) == '*'
                            || BombermanGame.map[(y-1)/32].charAt(x/32) == 'B') {
                        ok1 = 0;
                        y+=speed;
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
                        y-=speed;
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
    public void deadMoment() {
        if (isDead()) {
            if (time == 0) {
                img = Sprite.oneal_dead.getFxImage();
            }
            time ++;
        }
    }

    @Override
    public void update() {
        deadMoment();
        if (isDead()) return;
        BFS bfs = new BFS();
        Point point2 = new Point(x/32, y/32);
        Point point1 = new Point(BombermanGame.bomberman.getX(), BombermanGame.bomberman.getY());
        if (x%32 == 0 && y%32 == 0) {
            if (BombermanGame.bomberman.getTime() == 0) {
                direction = bfs.resultPath(point1, point2).charAt(0);
            } else {
                direction = ' ';
            }
        }
        if (Math.abs(x/32 - BombermanGame.bomberman.getX()) < 5
                && Math.abs(y/32 - BombermanGame.bomberman.getY()) < 5 && x % 2 == 0 && y % 2 == 0) {
            speed = 2;
        } else {
            speed = 1;
        }
        if (direction == 'l') {
            x -= speed;
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
        if (direction == 'r') {
            x+=speed;
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
        if (direction == 'd') {
            y+=speed;
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
        if (direction == 'u') {
            y-=speed;
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
        if (direction == ' ') {
            int value;
            Random rd = new Random();
            value = rd.nextInt(2) + 1;
            if (ok2 == 0) browse_row();
            if (ok2 == 1) browse_column();
            if (y%32 == 0 && value == 2 && ((BombermanGame.map[y/32].charAt(x/32+1) != '#'
                    && BombermanGame.map[y/32].charAt(x/32+1) != '*' && BombermanGame.map[y/32].charAt(x/32+1) != 'B')
                    || (BombermanGame.map[y/32].charAt((x-1)/32) != '#'
                    && BombermanGame.map[y/32].charAt((x-1)/32) != '*' && BombermanGame.map[y/32].charAt((x-1)/32) != 'B'))) {
                ok2 = 0;
            }

            if (x%32 == 0 && value == 1 && ((BombermanGame.map[y/32+1].charAt(x/32) != '#'
                    && BombermanGame.map[y/32+1].charAt(x/32) != '*' && BombermanGame.map[y/32+1].charAt(x/32) != 'B')
                    || (BombermanGame.map[(y-1)/32].charAt(x/32) != '#'
                    && BombermanGame.map[(y-1)/32].charAt(x/32) != '*' && BombermanGame.map[(y-1)/32].charAt(x/32) != 'B'))) {
                ok2 = 1;
            }
        }
    }
}
