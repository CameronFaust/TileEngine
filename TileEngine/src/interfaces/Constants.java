package interfaces;

/**
 * Stores various constants that are used throughout the program.
 */
public interface Constants {
	
     final int TILE_SIZE = 16;
     final int CHUNK_SIZE = 64; // "Cols"
     final int NUM_CHUNKS = 32; // "Rows"
     final int DRAW_AREA_WIDTH = CHUNK_SIZE * TILE_SIZE;
     final int REFRESH_RATE = 40;
     final int SUN_SPEED = 2; //Must be higher than 1
     
}