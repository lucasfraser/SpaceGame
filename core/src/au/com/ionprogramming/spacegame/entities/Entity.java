package au.com.ionprogramming.spacegame.entities;

import au.com.ionprogramming.spacegame.gfx.Lighting;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;
import javafx.scene.effect.Light;

/**
 * Created by Lucas on 3/08/2015.
 */

public class Entity {


    protected Vector2 loc;
	protected Vector2 size;
    protected Body body;

    public Entity(boolean moving, float x, float y, float width, float height, World world, Lighting lighting, boolean lockRotation){

        loc = new Vector2(x, y);

		size = new Vector2(width, height);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(size.x / 2, size.y/ 2);

		BodyDef bodyDef = new BodyDef();

		bodyDef.position.set(loc.x + width/2 , loc.y + height / 2);
		bodyDef.fixedRotation = lockRotation;

        if(moving){
		    bodyDef.type = BodyDef.BodyType.DynamicBody;

			FixtureDef fixtureDef = new FixtureDef();
			fixtureDef.shape = shape;
			fixtureDef.density = 0.5f;
			fixtureDef.friction = 0.4f;
			fixtureDef.restitution = 0.6f;

			body = world.createBody(bodyDef);

			Fixture fixture = body.createFixture(fixtureDef);
        }
        else {
            bodyDef.type = BodyDef.BodyType.StaticBody;

			body = world.createBody(bodyDef);

			body.createFixture(shape, 0.0f);
       }

		shape.dispose();
    }

	public void render(ShapeRenderer r, SpriteBatch batch){



	}
}
