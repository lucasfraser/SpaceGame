package au.com.ionprogramming.spacegame.entities;

import au.com.ionprogramming.spacegame.gfx.Lighting;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.physics.box2d.World;

import java.util.Random;

/**
 * Created by Lucas on 7/08/2015.
 */

public class Computer extends Entity{

    private Sprite tex;

    Random ran = new Random();

    public Computer(boolean moving, float x, float y, float width, float height, World world, Texture tex, Lighting lighting){
        super(moving, x, y, width, height, world, lighting, true);
        this.tex = new Sprite(tex);
        lighting.addPointLight(x+width/2, y+height/2, 15, Color.BLUE, false, world);

    }

    @Override
    public void render(ShapeRenderer r, SpriteBatch batch){

        Pixmap pixmap = new Pixmap( 52, 43, Pixmap.Format.RGBA8888 );
        pixmap.setColor( 0, 0, 1, 1 );
        pixmap.fillRectangle(0, 0, 52, 43);
        pixmap.setColor(Color.GRAY);
        pixmap.drawLine(5, 10, ran.nextInt(20), 10 );
        pixmap.drawLine(5, 40, ran.nextInt(30), 40 );
        pixmap.drawLine(5, 25, ran.nextInt(25), 25 );

        Texture pixmaptex = new Texture( pixmap );
        pixmap.dispose();

        batch.draw(tex, body.getPosition().x - size.x/2, body.getPosition().y - size.y/2, size.x, size.y);
        batch.draw(pixmaptex, body.getPosition().x - size.x/2 + ((size.x/64)*5), body.getPosition().y - size.y/2 + ((size.y/64)*14), (size.x/64)*54, (size.y/64)*45);

    }

}
