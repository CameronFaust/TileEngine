/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaces;

import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @author Cameron
 */
public interface BlockImages {
          final Image SKY = Toolkit.getDefaultToolkit().getImage("src/assets/sky.png");
          final Image GRASS = Toolkit.getDefaultToolkit().getImage("src/assets/grass.png");
          final Image DIRT = Toolkit.getDefaultToolkit().getImage("src/assets/dirt.png");
          final Image STONE = Toolkit.getDefaultToolkit().getImage("src/assets/stone.png");
          final Image DIAMOND = Toolkit.getDefaultToolkit().getImage("src/assets/diamond.png");
          final Image BEDROCK = Toolkit.getDefaultToolkit().getImage("src/assets/bedrock.png");
}
