package byog.lab5;
import org.junit.Test;
import static org.junit.Assert.*;

import byog.TileEngine.TERenderer;
import byog.TileEngine.TETile;
import byog.TileEngine.Tileset;

import javax.swing.text.Position;
import java.net.SocketOption;
import java.util.Random;

/**
 * Draws a world consisting of hexagonal regions.
 */
public class HexWorld {
    HexWorld hexWorld =new HexWorld();

    public static int hexRowWith (int s, int i) {

    }
    public static int hexRownOffset(int s, int i) {

    }

    public static void addRow(TETile[][] world, Position p,int width ,TETile t) {

    }

    public static void addHexgon(TETile[][] world,Position p, int size, TETile t) {
        if(size == 1) {
            System.out.println("a");
            return;
        }
        for(int i = 1; i<=size;i++) {
            for(int j=1;j<=size-i;j++) {
                System.out.print(' ');
            }
            for (int j=1;j<=size+(i-1)*2;j++) {
                System.out.print('a');
            }
            System.out.println();
        }
        for (int i=size;i>=1;i--) {
            for(int j=1;j<=size-i;j++) {
                System.out.print(' ');
            }
            for (int j=1;j<=size+(i-1)*2;j++) {
                System.out.print('a');
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        addHexgon(5);
    }

}
