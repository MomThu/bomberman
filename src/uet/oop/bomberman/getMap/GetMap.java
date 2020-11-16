package uet.oop.bomberman.getMap;

import java.io.File;
import java.util.Scanner;

public class GetMap {
    public static String[] getMap(String address) {
        try {
            Scanner scanner = new Scanner(new File(address));
            int level = scanner.nextInt();
            int height = scanner.nextInt();
            int width = scanner.nextInt();
            String[] maps = new String[height];
            maps[0] = scanner.nextLine();
            for(int i = 0; i < height; ++i) {
                maps[i] = scanner.nextLine();
            }
            return maps;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            String[] maps = new String[0];
            return maps;
        }
    }
}