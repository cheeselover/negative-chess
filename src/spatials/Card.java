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
	
	public Card(World world, Entity owner, UnicodeFont pixelFont) {
		super(world, owner);
		this.pixelFont = pixelFont;
	}

	@Override
	public void initialize() {
		this.card = world.getMapper(CardComponent.class).get(owner);
		this.transform = world.getMapper(Transform.class).get(owner);
	}

	@Override
	public void render(Graphics g) {
		if(!card.isHidden()){
			g.setColor(card.getColor());
			g.fillRoundRect(transform.getX(), transform.getY(), 100, 100, 5);
			g.setColor((card.getColor() == Color.black) ? Color.white : Color.black);
			g.fillRoundRect(transform.getX() + 2, transform.getY() + 2, 96, 96, 5);
			g.setColor(card.getColor());
			g.fillRoundRect(transform.getX() + 4, transform.getY() + 4, 92, 92, 5);
			g.setColor((card.getColor() == Color.black) ? Color.white : Color.black);
			g.fillRect(transform.getX() + 23, transform.getY() + 8, 53, 20);
			g.setColor(card.getColor());
			g.setFont(pixelFont);
			g.drawString(card.getType(), transform.getX() + 25, transform.getY() + 12);
		}
	}

}
