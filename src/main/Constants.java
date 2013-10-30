package main;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Constants {

	public static final String[] CARD_TYPES = {"MOVE", "PLACE", "INVERT", "XOR"};

	public static UnicodeFont getPixelFont() throws IOException, FontFormatException, SlickException {
		UnicodeFont pixelFont = new UnicodeFont(Font.createFont(Font.TRUETYPE_FONT, new File("res/pixel.ttf")).deriveFont(Font.PLAIN, 16));
		pixelFont.getEffects().add(new ColorEffect(Color.white));
		pixelFont.addAsciiGlyphs();
		pixelFont.loadGlyphs();

		return pixelFont;
	}
	
}
