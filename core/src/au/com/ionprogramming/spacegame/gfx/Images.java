package au.com.ionprogramming.spacegame.gfx;

import com.badlogic.gdx.graphics.Texture;

/**
 * Created by Lucas on 3/08/2015.
 */

public class Images {
    public static Texture computer;
    public static Texture player;

    public static void loadImages(){
        computer = new Texture("computer.png");
        player = new Texture("player.png");
    }
}
