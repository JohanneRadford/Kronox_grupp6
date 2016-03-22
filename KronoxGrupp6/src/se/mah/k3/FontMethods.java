package se.mah.k3;


import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;
import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

//Lägg till denna filen iert proj samt fonterna i fonts.
public class FontMethods {
	
	public static void setStyle(){
		InputStream is = null;
		Font font = null;
			//Ladda ner o lägg till egna fonter samt bara läs in dem här
			is = FontMethods.class.getResourceAsStream("/fonts/Futura-SC-T-OT-Book_19037.ttf"); //Import a font
			//Make sure that the fonts you use have åäö
			//is = FontMethods.class.getResourceAsStream("/fonts/MountainsofChristmas-Bold.ttf");
			//is = FontMethods.class.getResourceAsStream("/fonts/SFDigitalReadoutHeavy.ttf");
			//is = FontMethods.class.getResourceAsStream("/fonts/TheGirlNextDoor.ttf");
			//font =new Font("Futura", Font.BOLD, 20);  //7Set a new standarfont all over the place
			//font =new Font("Arial", Font.ITALIC, 20);

		 try {
			 GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			if (font==null){
				font = Font.createFont(Font.TRUETYPE_FONT, is);  //OM det är en tff font så läses den in här
			}
			ge.registerFont(font);
			setUIFont(new FontUIResource(font.deriveFont(Font.TRUETYPE_FONT, 20)));  //FontSize if fontfile
		   } catch (Exception e) {
			   System.out.println("Couldn't load or register font");
		   }
	}
	
	public static void setUIFont(FontUIResource f) {  //Denna metoden sätter fonterför alla komponenter 
        Enumeration keys = UIManager.getDefaults().keys();
        while (keys.hasMoreElements()) {
            Object key = keys.nextElement();
            Object value = UIManager.get(key);
            if (value instanceof FontUIResource) {
                FontUIResource orig = (FontUIResource) value;
                Font font = new Font(f.getFontName(), orig.getStyle(), f.getSize());
                UIManager.put(key, new FontUIResource(font));
            }
        }
    }
}