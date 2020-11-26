package uet.oop.bomberman;

import com.sun.org.apache.xpath.internal.operations.Or;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
import uet.oop.bomberman.entities.*;
import uet.oop.bomberman.getMap.GetMap;
import uet.oop.bomberman.graphics.Sprite;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;
    public static int level = 1;
    public static int heart = 3;
    public static String[] map = GetMap.getMap("res/levels/Level1.txt");

    //di chuyen bomber

    public static boolean gotoEast;
    public static boolean gotoWest;
    public static boolean gotoNorth;
    public static boolean gotoSouth;
    
    private GraphicsContext gc;
    private Canvas canvas;
    public static Bomber bomberman;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();
    private List<Bomb> bombs = new ArrayList<>();
    private List<Flame> flames = new ArrayList<>();
    private List<Brick> bricks = new ArrayList<>();
    private List<Portal> portals = new ArrayList<>();
    private List<Item> items = new ArrayList<>();
    //brick+enemies
    //private List<CanDeadEntity> canDeadObjects = new ArrayList<>();
    private List<CanDeadEntity> enemies = new ArrayList<>();


    public static void main(String[] args) {
        Application.launch(BombermanGame.class);
    }

    @Override
    public void start(Stage stage) {
        // Tao Canvas
        canvas = new Canvas(Sprite.SCALED_SIZE * WIDTH, Sprite.SCALED_SIZE * HEIGHT);
        gc = canvas.getGraphicsContext2D();

        // Tao root container
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        //input huong di chuyen bomber
        scene.setOnKeyPressed(event -> {
            switch (event.getCode()) {
                case UP: gotoNorth = true;
                break;
                case DOWN: gotoSouth = true;
                break;
                case LEFT: gotoWest = true;
                break;
                case RIGHT: gotoEast = true;
                break;
                case SPACE: {
                    Bomb bomb = new Bomb(bomberman.getX(), bomberman.getY(), Sprite.bomb.getFxImage());
                    if (bombs.size() < bomberman.getNumOfBomb()) {
                        bombs.add(bomb);
                    }
                }
            }
        });

        scene.setOnKeyReleased(event -> {
            switch (event.getCode()) {
                case UP: gotoNorth = false;
                    break;
                case DOWN: gotoSouth = false;
                    break;
                case LEFT: gotoWest = false;
                    break;
                case RIGHT: gotoEast = false;
                    break;
            }
        });

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();

        loadMap();

        bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
    }

    public void createMap() {
        for (int i = 0; i < WIDTH; i++) {
            for (int j = 0; j < HEIGHT; j++) {
                Entity object;
                if (j == 0 || j == HEIGHT - 1 || i == 0 || i == WIDTH - 1) {
                    object = new Wall(i, j, Sprite.wall.getFxImage());
                }
                else {
                    object = new Grass(i, j, Sprite.grass.getFxImage());
                }
                stillObjects.add(object);
            }
        }
    }

    public void loadMap() {
        for(int j = 0; j < WIDTH; j++) {
            for (int i = 0; i < HEIGHT; i++) {
                Entity object;
                if (map[i].charAt(j) == '#') {
                    object = new Wall(j, i, Sprite.wall.getFxImage());
                    stillObjects.add(object);
                }
                else if (map[i].charAt(j) == '*') {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    object = new Brick(j, i, Sprite.brick.getFxImage());
                    bricks.add((Brick)object);
                }
                else if (map[i].charAt(j) == 'x') {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    object = new Brick(j, i, Sprite.brick.getFxImage());
                    bricks.add((Brick)object);
                    object = new Portal(j, i, Sprite.portal.getFxImage());
                    portals.add((Portal)object);
                    BombermanGame.map[i] = BombermanGame.map[i].substring(0, j) + "*" +
                            BombermanGame.map[i].substring(j+1, BombermanGame.map[i].length());
                }
                else if (map[i].charAt(j) == 'p') {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    bomberman = new Bomber(j, i, Sprite.player_right.getFxImage());
                }
                else if (map[i].charAt(j) == '1') {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    object = new Balloom(j, i, Sprite.balloom_left1.getFxImage());
                    enemies.add((Balloom)object);
                }
                else if (map[i].charAt(j) == '2') {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    object = new Oneal(j, i, Sprite.oneal_left1.getFxImage());
                    enemies.add((Oneal)object);
                }
                else if (map[i].charAt(j) == '3') {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    object = new Kondoria(j, i, Sprite.kondoria_left1.getFxImage());
                    enemies.add((Kondoria)object);
                }
                else if (map[i].charAt(j) == '4') {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    object = new RedCoin(j, i, Sprite.redcoin_left1.getFxImage());
                    enemies.add((RedCoin)object);
                }
                else if (map[i].charAt(j) == 's') {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    object = new Brick(j, i, Sprite.brick.getFxImage());
                    bricks.add((Brick)object);
                    object = new SpeedItem(j, i, Sprite.powerup_speed.getFxImage());
                    items.add((SpeedItem)object);
                    BombermanGame.map[i] = BombermanGame.map[i].substring(0, j) + "*" +
                            BombermanGame.map[i].substring(j+1, BombermanGame.map[i].length());
                }
                else if (map[i].charAt(j) == 'f') {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    object = new Brick(j, i, Sprite.brick.getFxImage());
                    bricks.add((Brick)object);
                    object = new FlameItem(j, i, Sprite.powerup_flames.getFxImage());
                    items.add((FlameItem)object);
                    BombermanGame.map[i] = BombermanGame.map[i].substring(0, j) + "*" +
                            BombermanGame.map[i].substring(j+1, BombermanGame.map[i].length());
                }
                else if (map[i].charAt(j) == 'b') {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                    object = new Brick(j, i, Sprite.brick.getFxImage());
                    bricks.add((Brick)object);
                    object = new BombItem(j, i, Sprite.powerup_bombs.getFxImage());
                    items.add((BombItem)object);
                    BombermanGame.map[i] = BombermanGame.map[i].substring(0, j) + "*" +
                            BombermanGame.map[i].substring(j+1, BombermanGame.map[i].length());
                }
                else {
                    object = new Grass(j, i, Sprite.grass.getFxImage());
                    stillObjects.add(object);
                }
            }
        }
    }


    public void updateBomb() {
        for (int i = 0; i< bombs.size(); i++) {
            if (bombs.get(i).getTime() == 120) {
                List<Flame> newFlames = bombs.get(i).createFlame(bomberman, bricks);
                for (Flame flame : newFlames) {
                    flames.add(flame);
                    //flame.killObjects(canDeadObjects);
                }
            }
            if (bombs.get(i).getTime() >= 135) {
                bombs.remove(i);
                i--;
            }
        }
        for (int i = 0; i < flames.size(); i ++) {
            if (flames.get(i).getTime() == 0) {
                flames.get(i).killObjects(enemies,bricks);
            }
            if (flames.get(i).getTime() >= 15) {
                flames.remove(i);
                i--;
            }
        }
        for (int i = 0; i < enemies.size(); i ++) {
            if (enemies.get(i).getTime() >= 5) {
                if (enemies.get(i) instanceof RedCoin) {
                    OrangeCoin orangeCoin = new OrangeCoin(enemies.get(i).get_x() / 32,
                            enemies.get(i).get_y() / 32, Sprite.orangecoin_left1.getFxImage());
                    enemies.add(orangeCoin);
                }
                enemies.remove(i);
                i--;
            }
        }
        for (int i = 0; i < bricks.size(); i ++) {
            if (bricks.get(i).getTime() >= 20) {
                bricks.remove(i);
                i--;
            }
        }
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).isDead()) {
                items.remove(i);
                i--;
            }
        }
        for (int i = 0; i < portals.size(); i++) {
            if (portals.get(i).goToNewLevel(bomberman) == level && enemies.size() == 0) {
                clear();
                map = GetMap.getMap("res/levels/Level"+ level + ".txt");
                loadMap();
            }
        }
        if (bomberman.isDead() && heart >= 1 && bomberman.getTime() > 20) {
            bomberman.set_X(32);
            bomberman.set_Y(32);
            bomberman.set_Img(Sprite.player_right.getFxImage());
            bomberman.setDead(false);
            bomberman.setTime(0);
            heart--;
        }
        bomberman.collideToDead(flames, enemies);
    }

    public void clear() {
        entities.clear();
        stillObjects.clear();
        bombs.clear();
        flames.clear();
        bricks.clear();
        portals.clear();
        items.clear();
        enemies.clear();
    }

    public void update() {
        entities.forEach(Entity::update);
        enemies.forEach(Entity::update);
        bricks.forEach(Entity::update);
        items.forEach(Entity::update);
        bombs.forEach(Bomb::update);
        flames.forEach(Flame::update);
        bomberman.update();
        updateBomb();
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        portals.forEach(g -> g.render(gc));
        items.forEach(g -> g.render(gc));
        bricks.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
        enemies.forEach(g -> g.render(gc));
        bombs.forEach(g -> g.render(gc));
        flames.forEach(g -> g.render(gc));
        bomberman.render(gc);
    }
}
