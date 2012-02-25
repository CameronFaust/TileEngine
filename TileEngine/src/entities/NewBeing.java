package entities;

import interfaces.Constants;
import interfaces.PlayerImages;

import java.awt.Graphics2D;
import java.awt.Point;

import javax.swing.JPanel;

public class NewBeing implements Constants, PlayerImages {

	// Constants
	final double PLAYER_FRAME_DELAY = 0.2;
	/*--Variables--*/
	private boolean left, right, up, down, pick;
	private int x, y, dx, dy;
	private int chunkX, chunkY;
	private int xSpeed = 4;
	private int ySpeed = 8;
	private int jumpHeight = 6;
	private boolean isAirborne = false;
	private double frameNumber = 0;
	/*--End Variables--*/

	// Default Constructor
	public NewBeing(Point spawnPoint) {
		this.x = spawnPoint.x * TILE_SIZE;
		this.y = spawnPoint.y * TILE_SIZE;
	}

	public boolean isLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean isRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean isUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean isDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean isPick() {
		return pick;
	}

	public void setPick(boolean pick) {
		this.pick = pick;
	}

	public void draw(Graphics2D g2d, JPanel rootPane, Block[][] map) {
		frameNumber += PLAYER_FRAME_DELAY;
		if (((int) frameNumber) > 3 && !left && !right) {
			frameNumber = 0;
		} else if (left || right) {
			if (((int) frameNumber) > 4) {
				frameNumber = 0;
			}
		}
		if (left) {
			g2d.drawImage(walkLeftImages[(int) frameNumber], x, y, rootPane);
		} else if (right) {
			g2d.drawImage(walkRightImages[(int) frameNumber], x, y, rootPane);
		} else { // Standing, jumping, or falling.
			g2d.drawImage(standImages[(int) frameNumber], x, y, rootPane);
		}
		move(map);
	}

	public void move(Block[][] map) {
		// bounds check
				if (up) {
					if(map[chunkX][chunkY - 1].isSolid) {
						return;
					}
				} else if (left) {
					if(map[chunkX - 1][chunkY].isSolid) {
						return;
					}
				} else if (right) {
					if(map[chunkX + 1][chunkY].isSolid) {
						return;
					}
				} else {
					if(map[chunkX][chunkY + 1].isSolid) {
						return;
					}
				}
		if (up) {
			dy = -ySpeed;
		} else if (left) {
			dx = -xSpeed;
		} else if (right) {
			dx = xSpeed;
		} else {
			dx = 0;
			dy = ySpeed;
		}
		// move
		x += dx;
		y += dy;
		//Location in relation to the map array [y][x]
		chunkX = x / TILE_SIZE;
		chunkY = y / TILE_SIZE;
		
	}
}
