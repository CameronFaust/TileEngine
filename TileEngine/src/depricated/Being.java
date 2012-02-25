package depricated;

import interfaces.Constants;
import interfaces.Inventory;

public class Being implements Constants, Inventory {

	/*----Declarations----*/
	private int playerLoc = 32;
	protected int playerLocX, playerLocY, playerLocXX, playerLocYY;
	protected int playerX, playerY, playerDX, playerDY, viewDX, viewDY;
	private int xSpeed = 4; // This should stay at 1, 2, or 4 to keep bugs
							// minimal. The move method is not tuned to work
							// with speeds yet.
	private int ySpeed = 8; // Currently, the player will both jump and fall at
							// this speed.
	protected int lastDir = 2;
	private int jump = 0;
	private int jumpHeight = 6;
	protected boolean keyLeft, keyUp, keyRight, keyDown;
	private int block, blockType;
	/*----End Declarations----*/

	/**
	 * Creates a new instance of the Character class.
	 */
	public Being() {
		// I plan to make it so that this is an Entity class, and the Character
		// class will inherit it.
	}

	/**
	 * Creates a new being with a specified location.
	 * 
	 * @param playerLoc
	 *            an int representing the Beings locations.
	 */
	public Being(int playerLoc) {
		this.playerLoc = playerLoc;
	}

	/**
	 * This method is used to check if the player is grounded or airborne.
	 * 
	 * @return a boolean. False if the character is grounded, true if the
	 *         character is airborne.
	 * @author Cameron Faust
	 */
	public boolean isAirborne(int levelData[]) {
		if (levelData[playerLoc + CHUNK_SIZE] == 0) {
			return true; // Being is airborne
		}
		return false; // Being is grounded.
	}

	/*----Custom code fold added by [C.F] dont remove please!----*/
	// <editor-fold defaultstate="collapsed" desc="Getters and Setters">
	/**
	 * 
	 * @return value of block as an int.
	 */
	public int getBlock() {
		return block;
	}

	/**
	 * 
	 * @return value of blockType as an int.
	 */
	public int getBlockType() {
		return blockType;
	}

	/**
	 * 
	 * @return value of jump as an int.
	 */
	public int getJump() {
		return jump;
	}

	/**
	 * 
	 * @return value of jumpHeight as an int.
	 */
	public int getJumpHeight() {
		return jumpHeight;
	}

	/**
	 * 
	 * @return value of keyDown as a bool.
	 */
	public boolean isKeyDown() {
		return keyDown;
	}

	/**
	 * 
	 * @return value of keyLeft as a bool.
	 */
	public boolean isKeyLeft() {
		return keyLeft;
	}

	/**
	 * 
	 * @return value of keyRight as a bool.
	 */
	public boolean isKeyRight() {
		return keyRight;
	}

	/**
	 * 
	 * @return value of keyUp as a bool.
	 */
	public boolean isKeyUp() {
		return keyUp;
	}

	/**
	 * 
	 * @return value of lastDir as an int.
	 */
	public int getLastDir() {
		return lastDir;
	}

	public int getPlayerLoc() {
		return playerLoc;
	}

	public int getPlayerLocX() {
		return playerLocX;
	}

	public int getPlayerLocXX() {
		return playerLocXX;
	}

	public int getPlayerLocY() {
		return playerLocY;
	}

	public int getPlayerLocYY() {
		return playerLocYY;
	}

	public int getPlayerDX() {
		return playerDX;
	}

	public int getPlayerDY() {
		return playerDY;
	}

	public int getPlayerX() {
		return playerX;
	}

	public int getPlayerY() {
		return playerY;
	}

	public int getViewDX() {
		return viewDX;
	}

	public int getViewDY() {
		return viewDY;
	}

	public int getXSpeed() {
		return xSpeed;
	}

	public int getYSpeed() {
		return ySpeed;
	}

	public void setBlock(int block) {
		this.block = block;
	}

	public void setBlockType(int blockType) {
		this.blockType = blockType;
	}

	public void setJump(int jump) {
		this.jump = jump;
	}

	public void setJumpHeight(int jumpHeight) {
		this.jumpHeight = jumpHeight;
	}

	public void setKeyDown(boolean keyDown) {
		this.keyDown = keyDown;
	}

	public void setKeyLeft(boolean keyLeft) {
		this.keyLeft = keyLeft;
	}

	public void setKeyRight(boolean keyRight) {
		this.keyRight = keyRight;
	}

	public void setKeyUp(boolean keyUp) {
		this.keyUp = keyUp;
	}

	public void setLastDir(int lastDir) {
		this.lastDir = lastDir;
	}

	public void setPlayerDX(int playerDX) {
		this.playerDX = playerDX;
	}

	public void setPlayerDY(int playerDY) {
		this.playerDY = playerDY;
	}

	public void setPlayerLoc(int playerLoc) {
		this.playerLoc = playerLoc;
	}

	public void setPlayerLocX(int playerLocX) {
		this.playerLocX = playerLocX;
	}

	public void setPlayerLocXX(int playerLocXX) {
		this.playerLocXX = playerLocXX;
	}

	public void setPlayerLocY(int playerLocY) {
		this.playerLocY = playerLocY;
	}

	public void setPlayerLocYY(int playerLocYY) {
		this.playerLocYY = playerLocYY;
	}

	public void setPlayerX(int playerX) {
		this.playerX = playerX;
	}

	public void setPlayerY(int playerY) {
		this.playerY = playerY;
	}

	public void setViewDX(int viewDX) {
		this.viewDX = viewDX;
	}

	public void setViewDY(int viewDY) {
		this.viewDY = viewDY;
	}

	public void setxSpeed(int xSpeed) {
		this.xSpeed = xSpeed;
	}

	public void setySpeed(int ySpeed) {
		this.ySpeed = ySpeed;
	}

// </editor-fold>
/*----Custom code fold added by [C.F] dont remove please!----*/

/**
 * // * This method controls the ability of the player to pick up, and place
 * blocks. // * @param levelData // * @param blockData // * // * TODO: Fix
 * errors/bugs when trying to pick up or place blocks on the left or right side
 * of the map. // * //
 */
// public void placeBlock(int levelData[], int blockData[]) {
// int blockPos;
// if (block == 0) { //If a block is not being held...
// switch (lastDir) {
// case 1: //Facing Left
// blockPos = playerLoc - 1; //Block to the left.
// if (levelData[blockPos] != 0) { //If there is a solid block in front of the
// player...
// if (playerLocXX == 0 && blockData[blockPos] != 5) { //If the player is
// touching the block, and it is not Bedrock...
// block = levelData[blockPos]; //Pick it up!
// blockType = blockData[blockPos]; //Also pick up the image.
// levelData[blockPos] = 0; //Remove boundary.
// blockData[blockPos] = 0; //Set image to sky.
// }
// } else {
// blockPos = playerLoc + CHUNK_SIZE - 1; //Block below to the left.
// if (blockData[blockPos] != 5) { //ELSE, if there is a solid block blow to the
// left...
// block = levelData[blockPos]; //Pick that one up!
// blockType = blockData[blockPos];
// levelData[blockPos] = 0;
// blockData[blockPos] = 0;
// }
// }
// break;
// case 2: //Facing Right
// blockPos = playerLoc + 1; //Block to the right.
// if (levelData[blockPos] != 0 && blockData[blockPos] != 5) {
// if (playerLocXX <= 0) {
// block = levelData[blockPos];
// blockType = blockData[blockPos];
// levelData[blockPos] = 0;
// blockData[blockPos] = 0;
// }
// } else {
// blockPos = playerLoc + CHUNK_SIZE + 1; //Block below to the right.
// if (blockData[blockPos] != 5) {
// block = levelData[blockPos];
// blockType = blockData[blockPos];
// levelData[blockPos] = 0;
// blockData[blockPos] = 0;
// }
// }
// break;
// }
// } else { //If a block is being held...
// switch (lastDir) {
// case 1: //Left
// blockPos = playerLoc - 1;
// if (levelData[blockPos] == 0) { //If the attempted spot is empty...
// levelData[blockPos] = block; //Place the block!
// blockData[blockPos] = blockType; //Apply the corresponding image.
// block = 0; //Remove the block from above the player.
// } else {
// blockPos = playerLoc - CHUNK_SIZE - 1;
// if (levelData[blockPos] == 0) {
// levelData[blockPos] = block;
// blockData[blockPos] = blockType;
// block = 0;
// }
// }
// break;
// case 2: //Right
// if (playerLocXX == 0) { //If the player is standing directly on top of a
// block...
// blockPos = playerLoc + 1; //The block he is holding will be placed in front
// of him.
// } else {
// blockPos = playerLoc + 2; //The block he is holding will be placed one in
// front of him.
// }
// if (levelData[blockPos] == 0) {
// levelData[blockPos] = block;
// blockData[blockPos] = blockType;
// block = 0;
// } else {
// if (playerLocXX == 0) {
// blockPos = playerLoc - CHUNK_SIZE + 1;
// } else {
// blockPos = playerLoc - CHUNK_SIZE + 2;
// }
// if (levelData[blockPos] == 0) {
// levelData[blockPos] = block;
// blockData[blockPos] = blockType;
// block = 0;
// }
// }
// break;
// }
// }
// }
//
 /**
 * With playerLoc, playerLocX, and the corresponding Y values, the player's
 * position in the map can be determined by the top left corner of the
 * "imaginary" block. playerLocXX and playerLocYY then determine the exact
 * position on the map.
 * @param levelData
 */
public void move(int levelData[]) {
	//TODO: Speed needs to be better taken into account so that the player doesnot go through blocks.
	//TODO: It is still possible to go into another block if walking diagonally.Any other similar bugs are due to the speed.
	//TODO: Fine tuning has only recently been applied *correctly*. I still needto go through and fix some variables so that the player does not occasionallywalk through blocks (usually occurring when walking left in the latesttesting).
	/*---------------LEFT---------------*/
	if (keyLeft) {
		if (playerLocXX <= 0 && levelData[playerLoc - 1] == 1
				|| playerLocXX == 0 && playerLocX == 0) { //The player cannot go out ofboundaries.
			playerDX = 0; //Stops the player from trying to move.
		} else {
			playerDX = -1; //Lets the player move.
		}
	}
	/*---------------RIGHT---------------*/
	if (keyRight) {
		if (levelData[playerLoc + 1] == 1
				|| playerLocX == CHUNK_SIZE - 1) {
			playerDX = 0;
		} else {
			playerDX = 1;
		}
	}
	/*----------------GRAVITY---------------*/
	//By removing the keyDown check, gravity is automatic.
	if (playerLocYY <= 0 && ( //No boundary check is done because the playercannot go past Bedrock.
			levelData[playerLoc + CHUNK_SIZE] == 1 || //Down
			(levelData[playerLoc + CHUNK_SIZE + 1] == 1 && playerLocXX > 0))) { //DownLeft (this is just some fine tuning)
		playerDY = 0;
	} else {
		playerDY = 1;
	}
	/*--------------------------------------*/

	if (keyUp) { //Jumping is checked after gravity so that it forces the playerto go up.
		if (playerLoc < CHUNK_SIZE || //The player cannot go above boundaries.
				playerLocYY <= 0 && ( //Top Boundary
						levelData[playerLoc - CHUNK_SIZE] == 1 || //Top Left
						(levelData[playerLoc - CHUNK_SIZE + 1] == 1 && playerLocXX > 0))) { //TopRight (again, fine tuning)
			playerDY = 0;
			keyUp = false;
		} else {
			if (jump < jumpHeight) { //TODO: Add a gradual effect so that the player isbeing pulled down by gravity.
				playerDY = -1;
				jump++;
			} else {
				jump = 0;
				keyUp = false;
			}
		}
	}

	/*
	 * The boundary checks have been done. Everything below simply makes
	 * the player move in the array and on the screen in a way that mimics
	 * real movement.
	 */
	playerLocXX += playerDX * xSpeed;
	playerLocYY += playerDY * ySpeed;
	/*---------------RIGHT---------------*/
	if (playerLocXX >= TILE_SIZE) {
		playerLoc += playerLocXX / TILE_SIZE;
		playerLocXX = playerLocXX % TILE_SIZE;
		/*---------------LEFT---------------*/
	} else if (playerLocXX < 0) {
		//-1 because 1/16 is considered 0.
		playerLoc += playerLocXX / TILE_SIZE - 1;
		playerLocXX = TILE_SIZE + playerLocXX % TILE_SIZE;
	}
	//TODO: When the CHUNK_SIZE is above 19, this part of the method does notbehave correctly.
	/*---------------DOWN---------------*/
	if (playerLocYY >= TILE_SIZE) {
		playerLoc += playerLocYY / TILE_SIZE * CHUNK_SIZE;
		playerLocYY = playerLocYY % CHUNK_SIZE;
		/*---------------UP---------------*/
	} else if (playerLocYY < 0) {
		playerLoc -= (playerLocYY / TILE_SIZE + 1) * CHUNK_SIZE;
		playerLocYY = TILE_SIZE + playerLocYY % CHUNK_SIZE;
	}
	playerLocX = playerLoc % CHUNK_SIZE;
	playerLocY = playerLoc / CHUNK_SIZE;
	//This is the exact location of the player, considering real X and Y valuesof the window.
	playerX = playerLocX * TILE_SIZE + playerLocXX;
	playerY = playerLocY * TILE_SIZE + playerLocYY;
	//System.out.println("[" + playerLoc + "][" + levelData[playerLoc] + "] : " +"(" + playerLocX + ", " + playerLocY + "), (" + playerLocXX + ", " +playerLocYY + ")");
}
}
