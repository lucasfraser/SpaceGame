package au.com.ionprogramming.spacegame;

import au.com.ionprogramming.spacegame.gfx.Images;
import au.com.ionprogramming.spacegame.gfx.Lighting;
import au.com.ionprogramming.spacegame.gfx.Renderer;
import au.com.ionprogramming.spacegame.logic.Physics;
import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;

public class SpaceGame extends ApplicationAdapter {

	private Physics physics;
	private Renderer renderer;
	private Lighting lighting;


	@Override
	public void create () {

		Images.loadImages();

		physics = new Physics();
		renderer = new Renderer(physics);
		lighting = new Lighting(physics);

	}

	@Override
	public void render () {

		renderer.render();

		physics.render(renderer.getCam());

		lighting.render(renderer.getCam());

		physics.doPhysicsStep(Gdx.graphics.getDeltaTime());


	}

	@Override
	public void resize(int width, int height){
		renderer.setCamBounds(width, height);
	}
}
