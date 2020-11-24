package uet.oop.bomberman.entities;

public class Enemy {
    /*
    BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader("res/levels/Level1.txt"));
            String textInALine;
            String s;
            int row;
            int column;
            s = br.readLine();
            Entity object;
            String[] words = s.split("\\s");
            row = Integer.parseInt(words[1]);
            column = Integer.parseInt(words[2]);
            for (int i = 0; i < row; i++) {
                textInALine = br.readLine();
                for (int j = 0; j < column; j++) {
                    if (textInALine.charAt(j) == '#') {
                        object = new Wall(j, i, Sprite.wall.getFxImage());
                        stillObjects.add(object);
                    }
                    else if (textInALine.charAt(j) == '*') {
                        object = new Brick(j, i, Sprite.brick.getFxImage());
                        entities.add(object);
                    }
                    else if (textInALine.charAt(j) == 'x') {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                        object = new Portal(j, i, Sprite.portal.getFxImage());
                        entities.add(object);
                    }
                    else if (textInALine.charAt(j) == 'p') {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                        bomberman = new Bomber(j, i, Sprite.player_right.getFxImage());
                    }
                    else if (textInALine.charAt(j) == '1') {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                        object = new Balloom(j, i, Sprite.balloom_left1.getFxImage());
                        entities.add(object);
                    }
                    else if (textInALine.charAt(j) == '2') {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                        object = new Oneal(j, i, Sprite.oneal_left1.getFxImage());
                        entities.add(object);
                    }
                    else if (textInALine.charAt(j) == '3') {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                        object = new Kondoria(j, i, Sprite.kondoria_left1.getFxImage());
                        entities.add(object);
                    }
                    else if (textInALine.charAt(j) == 's') {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                        object = new SpeedItem(j, i, Sprite.powerup_speed.getFxImage());
                        entities.add(object);
                    }
                    else if (textInALine.charAt(j) == 'f') {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                        object = new FlameItem(j, i, Sprite.powerup_flames.getFxImage());
                        entities.add(object);
                    }
                    else if (textInALine.charAt(j) == 'b') {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                        object = new Bomb(j, i, Sprite.powerup_bombs.getFxImage());
                        entities.add(object);
                    }
                    else {
                        object = new Grass(j, i, Sprite.grass.getFxImage());
                        stillObjects.add(object);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    */
}
