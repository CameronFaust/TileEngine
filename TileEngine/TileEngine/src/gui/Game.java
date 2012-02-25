package gui;
import interfaces.Constants;

import javax.swing.JFrame;

/**
 * 
 * @author Joey Schooley
 */
@SuppressWarnings("serial")
public class Game extends JFrame implements Constants {

     public Game() {
          add(new Board());
          setTitle("Game");
          setDefaultCloseOperation(EXIT_ON_CLOSE);
          // I'm not entirely sure why I need to add the extra space. It could be because it takes the size of the -[]X bar and resize bars into account as well.
          setSize(CHUNK_SIZE * TILE_SIZE + CHUNK_SIZE, NUM_CHUNKS * TILE_SIZE + CHUNK_SIZE);
          //setResizable(false);
          setLocationRelativeTo(null);
          setVisible(true);
     }

     public static void main(String[] args) {
          new Game();
     }
}
