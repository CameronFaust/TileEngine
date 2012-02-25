package interfaces;

import java.awt.Image;
import java.awt.Toolkit;

public interface PlayerImages {

	Image[] standImages = new Image[]{
			Toolkit.getDefaultToolkit().getImage("src/assets/stand1.png"),
			Toolkit.getDefaultToolkit().getImage("src/assets/stand2.png"),
			Toolkit.getDefaultToolkit().getImage("src/assets/stand3.png"),
			Toolkit.getDefaultToolkit().getImage("src/assets/stand4.png")};
	
	Image[] walkLeftImages = new Image[]{
			Toolkit.getDefaultToolkit().getImage("src/assets/walkleft1.png"),
			Toolkit.getDefaultToolkit().getImage("src/assets/walkleft2.png"),
			Toolkit.getDefaultToolkit().getImage("src/assets/walkleft3.png"),
			Toolkit.getDefaultToolkit().getImage("src/assets/walkleft4.png"),
			Toolkit.getDefaultToolkit().getImage("src/assets/walkleft5.png")};
	
	Image[] walkRightImages = new Image[]{
			Toolkit.getDefaultToolkit().getImage("src/assets/walkright1.png"),
			Toolkit.getDefaultToolkit().getImage("src/assets/walkright2.png"),
			Toolkit.getDefaultToolkit().getImage("src/assets/walkright3.png"),
			Toolkit.getDefaultToolkit().getImage("src/assets/walkright4.png"),
			Toolkit.getDefaultToolkit().getImage("src/assets/walkright5.png")};
	
	Image[] walkRightHoldImages = new Image[]{
			Toolkit.getDefaultToolkit().getImage("src/assets/walkrighthold1.png"),
			Toolkit.getDefaultToolkit().getImage("src/assets/walkrighthold2.png")};
	
	Image[] walkLeftHoldImages = new Image[]{
			Toolkit.getDefaultToolkit().getImage("src/assets/walkleftthold1.png"),
			Toolkit.getDefaultToolkit().getImage("src/assets/walkleftthold2.png")};

}
