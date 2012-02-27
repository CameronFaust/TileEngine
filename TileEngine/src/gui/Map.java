package gui;

import java.awt.Graphics2D;
import java.awt.Point;
import java.util.Random;
import javax.swing.JPanel;
import interfaces.Constants;
import entities.Block;
import enums.BlockIDString;

public class Map implements Constants {

	//TODO Document this shit.
	
	// Constants
	private final int HEIGHT_LIMIT = 11; // Max height will be 1 less
	private final int DIRT_DEPTH = 2;
	private final int NOISE_BLEND = 1;// This is my preferred setting. Setting
										// it
										// higher will give a balanced effect of
										// smoothness.
	private final int NOISE_SMOOTH = 2; // Setting this higher will result in an
										// overall flat-like terrain.
	private final int NOISE_DETAIL = 0; // Setting this higher will result in
										// more defined chunks.
	//Variables/Classes
	private Block[][] map = new Block[CHUNK_SIZE][CHUNK_SIZE];
	private Point playerSpawn;

	public Map() {
		generateMap();
	}
	
	public Block[][] getMap() {
		return map;
	}

	public Point getPlayerSpawn() {
		return playerSpawn;
	}
	
	public void drawMap(Graphics2D g2d, JPanel rootPanel) {
		for (int x = 0; x < CHUNK_SIZE; x++) {
			for (int y = 0; y < NUM_CHUNKS; y++) {
				try {
					g2d.drawImage(map[x][y].getImage(), map[x][y].getX(), map[x][y].getY(),
							rootPanel);
				} catch (Exception e) {
					System.out.print(e.getMessage());
				}
			}
		}
	}

	private void generateMap() {
		final int ONE_HUNDRED = 100;
		final int SKY_RANGE = 10;
		final int DIAMOND_RANGE = 8;
		final int STONE_RANGE = 20;
		final int STONE_LAYER = NUM_CHUNKS - (HEIGHT_LIMIT / DIRT_DEPTH);
		final int FIRST_STONE_LAYER_DIRT_RANGE = 30;
		// EVERYTHING below this point must be rock.
		// index = col, num_chunks - val = height
		int[] surfaceMap = generateSurface();
		Random random = new Random();
		// First generate the surface
		for (int i = 0; i < surfaceMap.length; i++) {
			// grass/air is used as the default surface to start with
			if (random.nextInt(ONE_HUNDRED) <= SKY_RANGE) {
				map[i][NUM_CHUNKS - surfaceMap[i]] = new Block(i, NUM_CHUNKS - surfaceMap[i],
						BlockIDString.SKY);
			} else {
				map[i][NUM_CHUNKS - surfaceMap[i]] = new Block(i, NUM_CHUNKS - surfaceMap[i],
						BlockIDString.GRASS);
			}
			if (i == 0) {
				playerSpawn = new Point(i, NUM_CHUNKS - surfaceMap[i] - 1);
			}
		}
		// Now generate the rest of the map column by column
		boolean aboveGround;
		for (int x = 0; x < CHUNK_SIZE; x++) { // Col
			aboveGround = true;
			for (int y = 0; y < NUM_CHUNKS; y++) { // Row
				if (map[x][y] != null && aboveGround) {
					aboveGround = false; // Were now at surface level
				} else if (!aboveGround) { // If were at surface level or lower
					if (y == NUM_CHUNKS - 1) { // Bedrock

						map[x][y] = new Block(x, y, BlockIDString.BEDROCK);
					} else if (y > STONE_LAYER) {
						if (random.nextInt(ONE_HUNDRED) <= DIAMOND_RANGE) {
							map[x][y] = new Block(x, y, BlockIDString.DIAMOND);
						} else {
							map[x][y] = new Block(x, y, BlockIDString.STONE);
						}
					} else if (y == STONE_LAYER) {
						if (random.nextInt(ONE_HUNDRED) <= FIRST_STONE_LAYER_DIRT_RANGE) {
							map[x][y] = new Block(x, y, BlockIDString.DIRT);
						} else {
							map[x][y] = new Block(x, y, BlockIDString.STONE);
						}
					} else if (y < STONE_LAYER) {
						if (random.nextInt(ONE_HUNDRED) <= STONE_RANGE) {
							map[x][y] = new Block(x, y, BlockIDString.STONE);
						} else {
							map[x][y] = new Block(x, y, BlockIDString.DIRT);
						}
					}
				} else if (map[x][y] == null) { // Sky
					map[x][y] = new Block(x, y, BlockIDString.SKY);
				}
			}
		}
	}

	private int[] generateSurface() {
		int[] surfaceMap = new int[CHUNK_SIZE];
		Random random = new Random();
		int randomSeed = random.nextInt();
		for (int i = randomSeed; i < randomSeed + surfaceMap.length - 1; i++) {
			surfaceMap[i - randomSeed] = (int) (HEIGHT_LIMIT + 10 * Math.sin(i));
			if (i == 0) { // Getting the players spawn loc
				playerSpawn = new Point(i, surfaceMap[i - randomSeed]);
			}
		}
		smoothNoise(surfaceMap, NOISE_BLEND, NOISE_SMOOTH, NOISE_DETAIL);
		return surfaceMap;
	}

	/**
	 * smoothNoise simply takes advantage of the possibilities of using the
	 * smooth method. By having multiple variables, the map can be very unique
	 * and still look smooth, instead of being all uniform.
	 * 
	 * @param map
	 * @param blend
	 * @param smoothness
	 * @param detail
	 */
	public void smoothNoise(int[] map, int blend, int smoothness, int detail) {
		int length = map.length;
		int maxDenom = length - 1; // Highest Denominator
		int minDenom = 2; // Lowest Denominator
		while (length % maxDenom != 0) {
			maxDenom--;
		}
		while (length % minDenom != 0) {
			minDenom++;
		}
		while (smoothness > 0) {
			smooth(map, maxDenom);
			smoothness--;
		}
		while (detail > 0) {
			smooth(map, minDenom);
			detail--;
		}
		while (blend > 0) {
			smooth(map, length);
			blend--;
		}
	}

	/**
	 * This method "smooths" an array of numbers dividing the numbers into
	 * groups, and then going through each group with the following process: 1.
	 * Find the median of the group. (median1) 2. Find the median of each number
	 * within that group, with median1. 3. Go to the next group. The purpose of
	 * dividing the numbers into groups is to preserve occasional unique
	 * structures.
	 * 
	 * @param map
	 * @param denom
	 *            (denominator) can now be manually set, which allows for custom
	 *            smoothness.
	 */
	public void smooth(int[] map, int denom) {
		int length = map.length;
		int pass = length / denom;
		for (int i = 0; i < pass; i++) {
			int median = 0;
			for (int j = 0; j < denom; j++) {
				median += map[i * denom + j]; // i*denom ensures that it starts
												// at the beginning of each
												// section.
			}
			median /= denom;
			for (int j = 0; j < denom; j++) { // Now that the median has been
												// found, this loop will go
												// through every number,
												// creating a median between the
												// *median* and new number.
				map[i * denom + j] = (map[i * denom + j] + median) / 2;
			}
		}
	}
}
