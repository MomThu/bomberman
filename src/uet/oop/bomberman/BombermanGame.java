package uet.oop.bomberman;

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
import java.util.List;

public class BombermanGame extends Application {
    
    public static final int WIDTH = 31;
    public static final int HEIGHT = 13;
    public static String[] map = GetMap.getMap("res/levels/Level1.txt");

    //di chuyen bomber

    public static boolean gotoEast;
    public static boolean gotoWest;
    public static boolean gotoNorth;
    public static boolean gotoSouth;
    
    private GraphicsContext gc;
    private Canvas canvas;
    private List<Entity> entities = new ArrayList<>();
    private List<Entity> stillObjects = new ArrayList<>();


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

        //createMap();
        loadMap();

        Entity bomberman = new Bomber(1, 1, Sprite.player_right.getFxImage());
        entities.add(bomberman);
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
                        object = new Portal(j, i, Sprite.portal.getFxImage());
                        entities.add(object);
                    }
                    /*else if (textInALine.charAt(j) == 'p') {
                        object = new Bomber(j, i, Sprite.player_down.getFxImage());
                        entities.add(object);
                    }*/
                    else if (textInALine.charAt(j) == '1') {
                        object = new Balloom(j, i, Sprite.balloom_left1.getFxImage());
                        entities.add(object);
                    }
                    else if (textInALine.charAt(j) == '2') {
                        object = new Oneal(j, i, Sprite.oneal_left1.getFxImage());
                        entities.add(object);
                    }
                    else if (textInALine.charAt(j) == 's') {
                        object = new SpeedItem(j, i, Sprite.powerup_speed.getFxImage());
                        entities.add(object);
                    }
                    else if (textInALine.charAt(j) == 'f') {
                        object = new FlameItem(j, i, Sprite.powerup_flames.getFxImage());
                        entities.add(object);
                    }
                    else if (textInALine.charAt(j) == 'b') {
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
    }

    public void update() {
        entities.forEach(Entity::update);
    }

    public void render() {
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        stillObjects.forEach(g -> g.render(gc));
        entities.forEach(g -> g.render(gc));
    }
}
