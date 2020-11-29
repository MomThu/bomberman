package uet.oop.bomberman.entities.canDeadEntity.enemies;

import javafx.scene.image.Image;
import uet.oop.bomberman.BombermanGame;
import uet.oop.bomberman.entities.canDeadEntity.CanDeadEntity;
import uet.oop.bomberman.graphics.Sprite;

import java.util.Random;

public class RedCoin extends CanDeadEntity {
    int ok = 0, ok1 = 0, ok2 = 0;
    int speed = 1;

    public RedCoin(int x, int y, Image img) {
        super(x, y, img);
    }

    public void browse_row() {
        if (x >=0 && x <= (BombermanGame.WIDTH - 1)*32) {
            if ((BombermanGame.map[y/32].charAt(x/32 + 1) != '#'
                    && BombermanGame.map[y/32].charAt(x/32 + 1) != '*'
                    && BombermanGame.map[y/32].charAt(x/32 + 1) != 'B') && ok == 0) {
                x+=speed;
                if (x%30 == 0) {
                    img = Sprite.redcoin_right1.getFxImage();
                }
                else if (x%30 == 10) {
                    img = Sprite.redcoin_right2.getFxImage();
                }
                else if (x%30 == 20) {
                    img = Sprite.redcoin_right3.getFxImage();
                }
                ok = 0;
            }
            else if (BombermanGame.map[y/32].charAt(x/32 + 1) == '#'
                    || BombermanGame.map[y/32].charAt(x/32 + 1) == '*'
                    || BombermanGame.map[y/32].charAt(x/32 + 1) == 'B' || ok == 1){
                if (ok == 0) {
                    x-=speed;
                    if (x%30 == 0) {
                        img = Sprite.redcoin_left1.getFxImage();
                    }
                    else if (x%30 == 10) {
                        img = Sprite.redcoin_left2.getFxImage();
                    }
                    else if (x%30 == 20) {
                        img = Sprite.redcoin_left3.getFxImage();
                    }
                    ok = 1;
                }
                else {
                    if (BombermanGame.map[y/32].charAt((x-1)/32) == '#'
                            || BombermanGame.map[y/32].charAt((x-1)/32) == '*'
                            || BombermanGame.map[y/32].charAt((x-1)/32) == 'B') {
                        ok = 0;
                        x+=speed;
                        if (x%30 == 0) {
                            img = Sprite.redcoin_right1.getFxImage();
                        }
                        else if (x%30 == 10) {
                            img = Sprite.redcoin_right2.getFxImage();
                        }
                        else if (x%30 == 20) {
                            img = Sprite.redcoin_right3.getFxImage();
                        }
                    }
                    else {
                        x-=speed;
                        if (x%30 == 0) {
                            img = Sprite.redcoin_left1.getFxImage();
                        }
                        else if (x%30 == 10) {
                            img = Sprite.redcoin_left2.getFxImage();
                        }
                        else if (x%30 == 20) {
                            img = Sprite.redcoin_left3.getFxImage();
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
                    img = Sprite.redcoin_left1.getFxImage();
                }
                else if (y%30 == 10) {
                    img = Sprite.redcoin_left2.getFxImage();
                }
                else if (y%30 == 20) {
                    img = Sprite.redcoin_left3.getFxImage();
                }
                ok1 = 0;
            }
            else if (BombermanGame.map[y/32+1].charAt(x/32) == '#'
                    || BombermanGame.map[y/32+1].charAt(x/32) == '*'
                    || BombermanGame.map[y/32+1].charAt(x/32) == 'B'|| ok1 == 1){
                if (ok1 == 0) {
                    y-=speed;
                    if (y%30 == 0) {
                        img = Sprite.redcoin_left1.getFxImage();
                    }
                    else if (y%30 == 10) {
                        img = Sprite.redcoin_left2.getFxImage();
                    }
                    else if (y%30 == 20) {
                        img = Sprite.redcoin_left3.getFxImage();
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
                            img = Sprite.redcoin_left1.getFxImage();
                        }
                        else if (y%30 == 10) {
                            img = Sprite.redcoin_left2.getFxImage();
                        }
                        else if (y%30 == 20) {
                            img = Sprite.redcoin_left3.getFxImage();
                        }
                    }
                    else {
                        y-=speed;
                        if (y%30 == 0) {
                            img = Sprite.redcoin_left1.getFxImage();
                        }
                        else if (y%30 == 10) {
                            img = Sprite.redcoin_left2.getFxImage();
                        }
                        else if (y%30 == 20) {
                            img = Sprite.redcoin_left3.getFxImage();
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
                img = Sprite.redcoin_dead.getFxImage();
            }
            time++;
        }
    }

    @Override
    public void update() {
        deadMoment();
        if (isDead()) return;
        int value;
        Random rd = new Random();
        value = rd.nextInt(2) + 1;
        if (ok2 == 0) browse_row();
        if (ok2 == 1) browse_column();
        if (y%32 == 0 && value == 2 && ((BombermanGame.map[y/32].charAt(x/32+1) != '#'
                && BombermanGame.map[y/32].charAt(x/32+1) != '*'
                && BombermanGame.map[y/32].charAt(x/32+1) != 'B')
                || (BombermanGame.map[y/32].charAt((x-1)/32) != '#'
                && BombermanGame.map[y/32].charAt((x-1)/32) != '*'
                && BombermanGame.map[y/32].charAt((x-1)/32) != 'B'))) {
            ok2 = 0;
        }

        if (x%32 == 0 && value == 1 && ((BombermanGame.map[y/32+1].charAt(x/32) != '#'
                && BombermanGame.map[y/32+1].charAt(x/32) != '*'
                && BombermanGame.map[y/32+1].charAt(x/32) != 'B')
                || (BombermanGame.map[(y-1)/32].charAt(x/32) != '#'
                && BombermanGame.map[(y-1)/32].charAt(x/32) != '*'
                && BombermanGame.map[(y-1)/32].charAt(x/32) != 'B'))) {
            ok2 = 1;
        }
    }
}
