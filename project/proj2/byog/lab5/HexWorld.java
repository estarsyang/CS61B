package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    /**
     * 1. initial a windows.
     * 2. initialize tiles
     * 3. fill a block
     * 4. render
     */
    private static final int WIDTH = 60;
    private static final int HEIGHT = 30;
    TETile[][] world;

    public void initialWindow(){
        TERenderer ter = new TERenderer();
        ter.initialize(WIDTH, HEIGHT);
    }

    public void initalTiles(){
        // initialize tiles
        world = new TETile[WIDTH][HEIGHT];
        for (int x = 0; x < WIDTH; x += 1) {
            for (int y = 0; y < HEIGHT; y += 1) {
                world[x][y] = Tileset.NOTHING;
            }
        }
    }
    public void fillBlocks(){

    }

    public static void addHexagon(){
        creatHexagonList(3);
    }
    public static void creatHexagonList(int size){
        for (int i=0;i<size;i++){
            // size = 3
            // print space
            // i = 0 1 2
            // space 2, 1, 0
            for (int j=size - 1;j>i;j--){
                System.out.print(" ");
            }
            // i = 0, 1, 2
            // a   3, 5, 7
            for (int k=0;k<i*2 + size;k++) {
                System.out.print("a");
            }
            System.out.println();
        }
        for (int i=size - 1;i>=0;i--){
            // size = 3
            // print space
            // i = 2 1 0
            // space 0, 1, 2
            for (int j= size - 1;j > i;j--){
                System.out.print(" ");
            }
            // size = 3
            // i = 2, 1, 0
            // a   7, 5, 3
            for (int k=i*2 + size;k>0;k--) {
                System.out.print("a");
            }
            System.out.println();
        }
    }

    public static void main(String[] args){
        addHexagon();
    }

}
