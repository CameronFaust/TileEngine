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
          setSize(CHUNK_SIZE * TILE_SIZE + CHUNK_SIZE, NUM_CHUNKS * TILE_SIZE + CHUNK_SIZE);
          //setResizable(false);
          setLocationRelativeTo(null);
          setVisible(true);
     }

     public static void main(String[] args) {
          new Game();
     }
}
