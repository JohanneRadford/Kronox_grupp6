package se.mah.k3;

import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.io.InputStream;
import java.util.Enumeration;

import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

//L�gg till denna filen iert proj samt fonterna i fonts.
public class FontMethods {
	
	public static void setStyle(){
		InputStream is = null;
		Font font = null;
			//Ladda ner o l�gg till egna fonter samt bara l�s in dem h�r
			//is = FontMethods.class.getResourceAsStream("/fonts/Lobster-Regular.ttf"); //Import a font
			//Make sure that the fonts you use have ���
			//is = FontMethods.class.getResourceAsStream("/fonts/MountainsofChristmas-Bold.ttf");
			//is = FontMethods.class.getResourceAsStream("/fonts/SFDigitalReadoutHeavy.ttf");
			is = FontMethods.class.getResourceAsStream("/fonts/TheGirlNextDoor.ttf");
			//font =new Font("Arial", Font.BOLD, 20);  /7Set a new standarfont all over the place
			//font =new Font("Arial", Font.ITALIC, 20);

		 try {
			 GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
			if (font==null){
				font = Font.createFont(Font.TRUETYPE_FONT, is);  //OM det �r en tff font s� l�ses den in h�r
			}
			ge.registerFont(font);
			setUIFont(new FontUIResource(font.deriveFont(Font.TRUETYPE_FONT, 20)));  //FontSize if fontfile
		   } catch (Exception e) {
			   System.out.println("Couldn't load or register font");
		   }
	}
	
	public static void setUIFont(FontUIResource f) {  //Denna metoden s�tter fonterf�r alla komponenter 
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
