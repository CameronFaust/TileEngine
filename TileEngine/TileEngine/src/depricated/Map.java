package depricated;

import entities.Block;
import interfaces.Constants;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.HashMap;

public class Map implements Constants {

	// Have fun messing around the variables here!
	int noiseBlend = 1; // This is my preferred setting. Setting it higher will
						// give a balanced effect of smoothness.
	int noiseSmooth = 2; // Setting this higher will result in an overall
							// flat-like terrain.
	int noiseDetail = 0; // Setting this higher will result in more defined
							// chunks.
	int levelData[] = genMap(55, 2); // The first number is a place holder for a
										// seed. The second is the height limit.
	int blockData[] = genBlocks(levelData); // blockdata is just a copy of
											// leveldata but with image
											// references.
	HashMap<String, Image> ImageMap = new HashMap<String, Image>(); // References
																	// the names
																	// of images
																	// to their
																	// corresponding
																	// image.
																	// This is
																	// useful
																	// when
																	// combining
																	// the
																	// direction
																	// string
																	// with the
																	// animation
																	// position
																	// string.
	Image block0, block1, block2, block3, block4, block5, player0, player1, player2, player3,
			player0up, player1up, player2up, player3up, player4up, player0down, player1down,
			player2down, player3down, player4down, player0left, player1left, player2left,
			player3left, player4left, player0right, player1right, player2right, player3right,
			player4right, player0righthold, player1righthold, player2righthold, player3righthold,
			player4righthold, player0lefthold, player1lefthold, player2lefthold, player3lefthold,
			player4lefthold, sun0, sun1, moon0, moon1;

	public int[] getBlockData() {
		return blockData;
	}

	public int[] getLevelData() {
		return levelData;
	}

	public HashMap<String, Image> getImageMap() {
		return ImageMap;
	}

	public Map() {
		ImageMap.put("block0", block0 = Toolkit.getDefaultToolkit().getImage("src/assets/sky.png"));
		ImageMap.put("block1",
				block1 = Toolkit.getDefaultToolkit().getImage("src/assets/grass.png"));
		ImageMap.put("block2", block2 = Toolkit.getDefaultToolkit().getImage("src/assets/dirt.png"));
		ImageMap.put("block3",
				block3 = Toolkit.getDefaultToolkit().getImage("src/assets/stone.png"));
		ImageMap.put("block4",
				block4 = Toolkit.getDefaultToolkit().getImage("src/assets/diamond.png"));
		ImageMap.put("block5",
				block5 = Toolkit.getDefaultToolkit().getImage("src/assets/bedrock.png"));
		ImageMap.put("player0",
				player0 = Toolkit.getDefaultToolkit().getImage("src/assets/stand1.png"));
		ImageMap.put("player1",
				player1 = Toolkit.getDefaultToolkit().getImage("src/assets/stand2.png"));
		ImageMap.put("player2",
				player2 = Toolkit.getDefaultToolkit().getImage("src/assets/stand3.png"));
		ImageMap.put("player3",
				player3 = Toolkit.getDefaultToolkit().getImage("src/assets/stand4.png"));
		ImageMap.put("player0up",
				player0up = Toolkit.getDefaultToolkit().getImage("src/assets/white.png"));
		ImageMap.put("player1up",
				player1up = Toolkit.getDefaultToolkit().getImage("src/assets/white.png"));
		ImageMap.put("player2up",
				player2up = Toolkit.getDefaultToolkit().getImage("src/assets/white.png"));
		ImageMap.put("player3up",
				player3up = Toolkit.getDefaultToolkit().getImage("src/assets/white.png"));
		ImageMap.put("player4up",
				player4up = Toolkit.getDefaultToolkit().getImage("src/assets/white.png"));
		ImageMap.put("player0down",
				player0down = Toolkit.getDefaultToolkit().getImage("src/assets/white.png"));
		ImageMap.put("player1down",
				player1down = Toolkit.getDefaultToolkit().getImage("src/assets/white.png"));
		ImageMap.put("player2down",
				player2down = Toolkit.getDefaultToolkit().getImage("src/assets/white.png"));
		ImageMap.put("player3down",
				player3down = Toolkit.getDefaultToolkit().getImage("src/assets/white.png"));
		ImageMap.put("player4down",
				player4down = Toolkit.getDefaultToolkit().getImage("src/assets/white.png"));
		ImageMap.put("player0left",
				player0left = Toolkit.getDefaultToolkit().getImage("src/assets/walkleft1.png"));
		ImageMap.put("player1left",
				player1left = Toolkit.getDefaultToolkit().getImage("src/assets/walkleft2.png"));
		ImageMap.put("player2left",
				player2left = Toolkit.getDefaultToolkit().getImage("src/assets/walkleft3.png"));
		ImageMap.put("player3left",
				player3left = Toolkit.getDefaultToolkit().getImage("src/assets/walkleft4.png"));
		ImageMap.put("player4left",
				player4left = Toolkit.getDefaultToolkit().getImage("src/assets/walkleft5.png"));
		ImageMap.put("player0right",
				player0right = Toolkit.getDefaultToolkit().getImage("src/assets/walkright1.png"));
		ImageMap.put("player1right",
				player1right = Toolkit.getDefaultToolkit().getImage("src/assets/walkright2.png"));
		ImageMap.put("player2right",
				player2right = Toolkit.getDefaultToolkit().getImage("src/assets/walkright3.png"));
		ImageMap.put("player3right",
				player3right = Toolkit.getDefaultToolkit().getImage("src/assets/walkright4.png"));
		ImageMap.put("player4right",
				player4right = Toolkit.getDefaultToolkit().getImage("src/assets/walkright5.png"));
		ImageMap.put(
				"player0righthold",
				player0righthold = Toolkit.getDefaultToolkit().getImage(
						"src/assets/walkrighthold1.png"));
		ImageMap.put(
				"player1righthold",
				player1righthold = Toolkit.getDefaultToolkit().getImage(
						"src/assets/walkrighthold2.png"));
		ImageMap.put(
				"player2righthold",
				player2righthold = Toolkit.getDefaultToolkit().getImage(
						"src/assets/walkrighthold1.png"));
		ImageMap.put(
				"player3righthold",
				player3righthold = Toolkit.getDefaultToolkit().getImage(
						"src/assets/walkrighthold2.png"));
		ImageMap.put(
				"player4righthold",
				player4righthold = Toolkit.getDefaultToolkit().getImage(
						"src/assets/walkrighthold1.png"));
		ImageMap.put(
				"player0lefthold",
				player0lefthold = Toolkit.getDefaultToolkit().getImage(
						"src/assets/walklefthold1.png"));
		ImageMap.put(
				"player1lefthold",
				player1lefthold = Toolkit.getDefaultToolkit().getImage(
						"src/assets/walklefthold2.png"));
		ImageMap.put(
				"player2lefthold",
				player2lefthold = Toolkit.getDefaultToolkit().getImage(
						"src/assets/walklefthold1.png"));
		ImageMap.put(
				"player3lefthold",
				player3lefthold = Toolkit.getDefaultToolkit().getImage(
						"src/assets/walklefthold2.png"));
		ImageMap.put(
				"player4lefthold",
				player4lefthold = Toolkit.getDefaultToolkit().getImage(
						"src/assets/walklefthold1.png"));
		ImageMap.put("sun0", sun0 = Toolkit.getDefaultToolkit().getImage("src/assets/sun0.png"));
		ImageMap.put("sun1", sun1 = Toolkit.getDefaultToolkit().getImage("src/assets/sun1.png"));
		ImageMap.put("moon0", moon0 = Toolkit.getDefaultToolkit().getImage("src/assets/moon0.png"));
		ImageMap.put("moon1", moon1 = Toolkit.getDefaultToolkit().getImage("src/assets/moon1.png"));
		// TODO: Narrow animations down to 4 frames to make repetition work.
	}

	// public Block[] generateMap(int maxHeight) {

	// }

	/**
	 * genMap has the simple purpose of turning the noise into a map of solids
	 * and non-solids. There are two for loops. The first one goes through and
	 * lowers anything above the height limit. The second loop fills in anything
	 * underneath the noise, to make it a solid platform.
	 * 
	 * @param seed
	 * @param maxHeight
	 * @return
	 */
	public int[] genMap(int seed, int maxHeight) {
		// TODO: The height cut off is currently reversed, or not working.
		int[] map1d = genNoise(CHUNK_SIZE);
		int[] map2d = new int[CHUNK_SIZE * CHUNK_SIZE];
		int heightLimit = CHUNK_SIZE - maxHeight;
		for (int i = 0; i < map1d.length; i++) {
			int height = CHUNK_SIZE - map1d[i];
			if (height > heightLimit) { // If the block goes too high, simply
										// don't let it pass this level.
				map2d[CHUNK_SIZE * heightLimit + i] = 1;
			} else {
				map2d[CHUNK_SIZE * height + i] = 1;
			}
		}
		for (int y = maxHeight; y < CHUNK_SIZE; y++) { // Start at the maxHeight
														// to shorten the loop.
			for (int x = 0; x < CHUNK_SIZE; x++) {
				if (map2d[CHUNK_SIZE * (y - 1) + x] == 1) { // If the block
															// above is
															// solid...then
															// everything
															// underneath must
															// be solid.
					map2d[CHUNK_SIZE * y + x] = 1;
				}
			}
		}
		return map2d;
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

	/**
	 * genBlocks takes a map made up of solids and non-solids (1s and 0s), and
	 * gives it life. The first step is to check whether or not it is a solid.
	 * If it's not a solid, then by default, it must be sky. The second step,
	 * assuming that it is not a solid, is to determine what level of depth the
	 * block is on. At dirt-level, it will check to see if the block above is
	 * sky, and if so, this dirt will have grass. At rock-level, there is a
	 * chance that dirt may cascade down. There is also a rare chance that ores
	 * may appear! In this instance, diamond has been implemented. At
	 * bedrock-level, it is a barrier that cannot be moved. 0=sky 1=grass 2=dirt
	 * 3=stone 4=diamond 5=bedrock
	 * 
	 * @param map
	 * @return
	 */
	public int[] genBlocks(int[] map) {
		int diamondProb = 10; // Probability of diamonds appearing.
		int dirtProb = 3; // Probability of dirt cascading into rock.
		int rockLayer = 12; // The layer at which dirt turns to rock.
		// TODO: Add clouds. Add water (lakes) to random gaps below a certain
		// level.
		int[] newMap = new int[CHUNK_SIZE * CHUNK_SIZE];
		for (int i = 0; i < map.length; i++) { // map.length and CHUNK_SIZE are
												// interchangeable
			if (map[i] == 0) {
				newMap[i] = 0;
			} else {
				if (i / CHUNK_SIZE < rockLayer) { // If the depth is above this
													// level, generate dirt.
					if (map[i - CHUNK_SIZE] == 0) { // If the block above is
													// sky, then this dirt will
													// have grass.
						newMap[i] = 1;
					} else {
						newMap[i] = 2;
					}
				} else if (i / CHUNK_SIZE == CHUNK_SIZE - 1) {
					newMap[i] = 5; // Bottom layer is Bedrock.
				} else {
					if ((newMap[i - CHUNK_SIZE] == 1 || newMap[i - CHUNK_SIZE] == 2)
							&& 1 + (int) (Math.random() * ((dirtProb - 1) + 1)) == 1) {
						newMap[i] = 2;
					} else {
						newMap[i] = 3; // TODO: Make it so random occurences
										// will be the same for seed numbers.
						if (1 + (int) (Math.random() * ((diamondProb - 1) + 1)) == 1) { // This
																						// is
																						// putting
																						// a
																						// random
																						// number
																						// in
																						// the
																						// range
																						// of
																						// 1-diamondProb.
																						// this
																						// is
																						// also
																						// the
																						// probability
																						// that
																						// diamond
																						// will
																						// appear.
																						// 1,
																						// in
																						// 10.
							newMap[i] = 4;
						}
					}
				}
			}
		}
		return newMap;
	}

	/**
	 * This is where the magic happens! In this little method, it will take a
	 * noise generation sequence and fit it into a 1d block-like world.
	 * Currently it is using a custom sin(x) value, which I would like to
	 * replace with Perlin noise once I can understand it.
	 * 
	 * @param length
	 * @return
	 */
	public int[] genNoise(int length) { // TODO: Add seed variable.
		int map[] = new int[length];
		for (int i = 0; i < length; i++) {
			map[i] = (int) (7 + 10 * Math.sin(i)); // TODO: Perlin noise!
		}
		smoothNoise(map, noiseBlend, noiseSmooth, noiseDetail); // So glad I
																// implemented
																// this
																// smoothness
																// feature, how
																// fun!
		return map;
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
}