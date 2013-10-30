package spatials;

import com.artemis.Entity;
import com.artemis.World;
import components.CardComponent;
import components.Transform;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import java.awt.*;
import java.io.File;

public class Card extends Spatial {

	CardComponent card;
	Transform transform;
	UnicodeFont pixelFont;
	
	public Card(World world, Entity owner) {
		super(world, owner);
	}

	@Override
	public void initialize() {
		this.card = world.getMapper(CardComponent.class).get(owner);
		this.transform = world.getMapper(Transform.class).get(owner);

		try{
			pixelFont = new UnicodeFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/pixel.ttf")).deriveFont(Font.PLAIN, 16));
			pixelFont.getEffects().add(new ColorEffect(java.awt.Color.white));
			pixelFont.addAsciiGlyphs();
			pixelFont.loadGlyphs();
		} catch(Exception e){
			e.printStackTrace();
		}
		
	
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.white);
		g.fillRoundRect(transform.getX(), transform.getY(), 100, 100, 5);
		g.setColor(Color.black);
		g.fillRoundRect(transform.getX() + 2, transform.getY() + 2, 96, 96, 5);
		g.setColor(Color.white);
		g.fillRoundRect(transform.getX() + 4, transform.getY() + 4, 92, 92, 5);
		g.setColor(Color.black);
		g.fillRect(transform.getX() + 23, transform.getY() + 8, 53, 20);
		g.setColor(Color.white);
		g.setFont(pixelFont);
		g.drawString("INVERT", transform.getX() + 25, transform.getY() + 12);
	}

}
