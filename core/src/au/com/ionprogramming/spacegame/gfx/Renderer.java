package au.com.ionprogramming.spacegame.gfx;

import au.com.ionprogramming.spacegame.entities.Computer;
import au.com.ionprogramming.spacegame.entities.Cube;
import au.com.ionprogramming.spacegame.entities.Entity;
import au.com.ionprogramming.spacegame.entities.Player;
import au.com.ionprogramming.spacegame.logic.Physics;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;

/**
 * Created by Lucas on 3/08/2015.
 */
public class Renderer {


    public static ArrayList<Entity> cubes = new ArrayList<Entity>();
    public static ArrayList<Entity> entities = new ArrayList<Entity>();

    private float camWidth = 50;
    private float camHeight = 50;

    private OrthographicCamera cam;

    private SpriteBatch batch;
    private ShapeRenderer shapeRenderer;

    public Renderer(Physics physics, Lighting lighting){

        float w = Gdx.graphics.getWidth();
        float h = Gdx.graphics.getHeight();
        cam = new OrthographicCamera(camWidth, camHeight * (h / w));
        cam.position.set(cam.viewportWidth / 2f, cam.viewportHeight / 2f, 0);
        cam.update();

        batch = new SpriteBatch();
        shapeRenderer = new ShapeRenderer();

        cubes.add(new Cube(true, 40, 20, 4, 4, physics.getWorld(), new Color(1, 0, 0, 1), lighting));
        cubes.add(new Cube(true, 37, 26, 4, 4, physics.getWorld(), new Color(1, 0, 0, 1), lighting));
        cubes.add(new Cube(true, 33, 32, 4, 4, physics.getWorld(), new Color(1, 0, 0, 1), lighting));
        cubes.add(new Cube(true, 29, 38, 4, 4, physics.getWorld(), new Color(1, 0, 0, 1), lighting));
        cubes.add(new Cube(true, 25, 45, 4, 4, physics.getWorld(), new Color(1, 0, 0, 1), lighting));
        cubes.add(new Cube(true, 21, 50, 4, 4, physics.getWorld(), new Color(1, 0, 0, 1), lighting));


        cubes.add(new Cube(false, 1, 1, 48, 5, physics.getWorld(), new Color(0, 1, 0, 1), lighting));

        entities.add(new Computer(false, 9, 11, 10, 10, physics.getWorld(), Images.computer, lighting));
        entities.add(new Player(20, 20, 5, 10, physics.getWorld(), Images.player, lighting));


    }

    public void render(){

        cam.update();

        Gdx.gl.glClearColor(0.1f, 0.1f, 0.1f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        shapeRenderer.setProjectionMatrix(cam.combined);
        batch.setProjectionMatrix(cam.combined);

        shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            for(int i = 0; i < cubes.size(); i++){
                cubes.get(i).render(shapeRenderer, batch);
            }
        shapeRenderer.end();

        batch.begin();
            for(int i = 0; i < entities.size(); i++){
                entities.get(i).render(shapeRenderer, batch);
            }

        batch.end();

        System.out.println("FPS: " + Gdx.graphics.getFramesPerSecond());

    }

    public void setCamBounds(float width, float height){
        //TODO: Implement camera scaling properly
//        cam.viewportWidth = camHeight;
//        cam.viewportHeight = camWidth * height/width;
//
//        cam.update();
    }

    public OrthographicCamera getCam() {
        return cam;
    }

}
