package au.com.ionprogramming.spacegame.entities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.*;

/**
 * Created by Lucas on 3/08/2015.
 */

public class Entity {


    private Vector2 loc;
	private Vector2 size;
    private Body body;
	private Color color;

    public Entity(boolean moving, float x, float y, float width, float height, World world, Color col){

		color = col;

        loc = new Vector2(x, y);

		size = new Vector2(width, height);

		PolygonShape shape = new PolygonShape();
		shape.setAsBox(size.x / 2, size.y/ 2);

		BodyDef bodyDef = new BodyDef();

		bodyDef.position.set(x + width/2 , y + height / 2);

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
        else{
            bodyDef.type = BodyDef.BodyType.StaticBody;

			body = world.createBody(bodyDef);

			body.createFixture(shape, 0.0f);

       }

		shape.dispose();
    }

    public void render(ShapeRenderer r){

		r.setColor(color);
		r.rect(body.getPosition().x - size.x/2, body.getPosition().y - size.y/2, size.x / 2, size.y / 2, size.x, size.y, 1, 1, (float)Math.toDegrees(body.getAngle()));

	}
}