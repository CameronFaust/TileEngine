package gui;

import entities.Being;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import interfaces.Constants;
import interfaces.SkyImages;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Composite;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class Board extends JPanel implements ActionListener, KeyListener, Constants, SkyImages {

	/*----Declarations----*/
	private Timer timer;
	private Dimension d;
	private Image ii;
	private Being player;
	private Map map;
	private String action = "";
	// private int radianTracker = 0;
	/*----End Declarations----*/

	public Board() {
		map = new Map();
		player = new Being(map.getPlayerSpawn(), map.getMap());
		addKeyListener(this);
		setFocusable(true);
		d = new Dimension(400, 400);
		setDoubleBuffered(true);
		// This will constantly update the screen and moving variables at the
		// given rate.
		timer = new Timer(REFRESH_RATE, this);
		timer.start();
	}

	public void drawStats(Graphics2D g2d) {
		g2d.drawString("Player:", TILE_SIZE, (NUM_CHUNKS + 1) * TILE_SIZE); // Header
		g2d.drawString("X: " + player.getX(), 2 * TILE_SIZE, (NUM_CHUNKS + 2) * TILE_SIZE); // X
		g2d.drawString("Y: " + player.getY(), 2 * TILE_SIZE, (NUM_CHUNKS + 3) * TILE_SIZE); // Y
		g2d.drawString("dX: " + player.getDx(), 2 * TILE_SIZE, (NUM_CHUNKS + 4) * TILE_SIZE); // dX
		g2d.drawString("dY: " + player.getDy(), 2 * TILE_SIZE, (NUM_CHUNKS + 5) * TILE_SIZE); // dY
		g2d.drawString("Cell X: " + player.getXMapIndex(), 2 * TILE_SIZE, (NUM_CHUNKS + 6)
				* TILE_SIZE); // cellX
		g2d.drawString("Cell Y: " + player.getYMapIndex(), 2 * TILE_SIZE, (NUM_CHUNKS + 7)
				* TILE_SIZE); // cellY
		g2d.drawString("Up: " + player.isUp(), TILE_SIZE * TILE_SIZE, (NUM_CHUNKS + 1) * TILE_SIZE);
		g2d.drawString("Down: " + player.isDown(), TILE_SIZE * TILE_SIZE, (NUM_CHUNKS + 2) * TILE_SIZE);
		g2d.drawString("Left: " + player.isLeft(), TILE_SIZE * TILE_SIZE, (NUM_CHUNKS + 3) * TILE_SIZE);
		g2d.drawString("Right: " + player.isRight(), TILE_SIZE * TILE_SIZE, (NUM_CHUNKS + 4) * TILE_SIZE);
		g2d.drawString("Is Holding: " + player.isHoldingObject(), TILE_SIZE * TILE_SIZE, (NUM_CHUNKS + 5) * TILE_SIZE);
	}

	// TODO Make this work properly with all sizes of maps ie: squares, and
	// rectangles.
	// /**
	// * Draws an animated sun as well as simulate day and night.
	// *
	// * @author Cameron Faust
	// * @param g2d
	// */
	// private void drawSun(Graphics2D g2d) {
	// // Note if player is below ground shut the sun off!
	// final float MAX_ALPHA = 0.50F;
	// float alpha = 0; // Used to set the transparency.
	// int x, y, x2, y2; // X and Y Coords of the sun and moon.
	// int radius = DRAW_AREA_WIDTH; // The radius of the circle around whos
	// // circumfrence we will draw the sun and
	// // moon.
	// int split = 2 * radius * SUN_SPEED; // How many points around the circle
	// // will the sun and moon be drawn.
	// // more == slower.
	// double radian = Math.PI * radianTracker / (split / 2); // Suns radian
	// double radian2 = radian + Math.PI; // Moons radian oposite the sun.
	// // Sun
	// x = (int) Math.round((radius / 2) + radius * Math.cos(radian));
	// y = (int) Math.round(radius + (radius * Math.sin(radian)));
	// // Moon
	// x2 = (int) Math.round((radius / 2) + radius * Math.cos(radian2));
	// y2 = (int) Math.round(radius + (radius * Math.sin(radian2)));
	// // If were on the last radian reset the tracker to zero since the sun is
	// // at its original position.
	// if (radianTracker++ == split) {
	// radianTracker = 0; // Resetting.
	// }
	// // Alternate the image used to animate the sun and moon.
	// // TODO: Could be done better to get a more consistent animation, maybe
	// // even a pulse. IE: .5 sec/image.
	// // Draw Images.
	// // TODO Alternate image drawn.
	// g2d.drawImage(moon0, x, y, this);
	// g2d.drawImage(sun0, x2, y2, this);
	// try {
	// /*
	// * To best describe this code think of the board as a graph, with
	// * quadrant I II III and IV, the origin being the middle of the
	// * bottom of the map. X = DRAW_AREA WIDTH / 2, Y = DRAW_AREA_WIDTH
	// * [DRAW_AREA_WIDTH = CHUNK_SIZE * TILE_SIZE] That being said the
	// * code should be more easily understood.
	// */
	// // While the suns top left corner is in quadrant I or IV
	// /* SUN RISE */
	// if (radian < 0.5F * Math.PI || radian >= 1.5 * Math.PI && radianTracker <
	// split * 0.75) {
	// if (radian < 0.5F * Math.PI) { // While in I
	// // Calculate the alpha by using the percentage of how far
	// // the radian is in its sector.
	// alpha = (float) ((MAX_ALPHA / 2) - ((MAX_ALPHA / 2) * (radian / (0.5F *
	// Math.PI))));
	// } else if (radian > 1.5 * Math.PI) { // While in IV
	// // Calculate the alpha by using the percentage of how far
	// // the radian is in its sector.
	// alpha = (float) (MAX_ALPHA - ((MAX_ALPHA / 2) * (radian / (2F *
	// Math.PI))));
	// }
	// /* SUN SET */
	// } else { // While the suns top left corner is in quadrant II or III
	// if (radian < (1.5 * Math.PI)) { // While in III
	// // Calculate the alpha by using the percentage of how far
	// // the radian is in its sector.
	// alpha = (float) (MAX_ALPHA * ((radian - (0.5F * Math.PI)) / Math.PI));
	// } else { // While in II
	// // Calculate the alpha by using the percentage of how far
	// // the radian is in its sector.
	// alpha = (float) (MAX_ALPHA - ((MAX_ALPHA / 2) * ((radian - (1.5 *
	// Math.PI)) / (Math.PI * 0.5))));
	// }
	// }
	// Composite originalComposite = g2d.getComposite(); // Store the
	// // original
	// // composite.
	// g2d.setColor(Color.black); // Setting the color for the composite to
	// // be drawn in.
	// // Setting the composite with the calulcated alpha.
	// g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER,
	// alpha));
	// g2d.fillRect(0, 0, DRAW_AREA_WIDTH, DRAW_AREA_WIDTH); // Drawing a
	// // rectangle
	// // with the
	// // composite.
	// g2d.setComposite(originalComposite); // Setting the composite back
	// // to normal.
	// } catch (Exception e) { // Catch any errors. Most likely related to the
	// // alpha being negative or > 1.
	// System.out.print(e.getLocalizedMessage() + '\n');
	// System.out.print("Alpha = " + Float.toString(alpha) + '\n');
	// }
	//
	// // <editor-fold defaultstate="collapsed" desc="Dubugging Stats!">
	// // Debugging
	// g2d.setColor(Color.red);
	// g2d.drawString("Radian Tracker: " + Integer.toString(radianTracker), 150,
	// DRAW_AREA_WIDTH + 10);
	// g2d.drawString(
	// "Radian Tracker * SUN_SPEED: " + Integer.toString(radianTracker *
	// SUN_SPEED), 150,
	// DRAW_AREA_WIDTH + 20);
	// g2d.drawString(
	// "Radian Tracker * SUN_SPEED / 2: "
	// + Integer.toString(radianTracker * SUN_SPEED / 2), 150,
	// DRAW_AREA_WIDTH + 30);
	// g2d.drawString("Split: " + Integer.toString(split), 150, DRAW_AREA_WIDTH
	// + 40);
	// g2d.drawString("Radian: " + Double.toString(radian), 150, DRAW_AREA_WIDTH
	// + 50);
	// g2d.drawString("Radian2: " + Double.toString(radian2), 150,
	// DRAW_AREA_WIDTH + 60);
	// g2d.drawString("Alpha Rise: " + Float.toString(alpha), 150,
	// DRAW_AREA_WIDTH + 70);
	// g2d.setColor(Color.black);
	// // </editor-fold>
	// }

	// /**
	// *
	// * @param g2d
	// */
	// public void drawPlayer(Graphics2D g2d) {
	// if (player.getBlock() == 0) {
	// action = "";
	// } else {
	// action = "hold";
	// }
	// if (player.getLastDir() == 1) {
	// dispFrame(g2d, "left" + action);
	// } else if (player.getLastDir() == 2) {
	// dispFrame(g2d, "right" + action);
	// }
	// }

	// public void dispFrame(Graphics2D g2d, String dir) {
	// g2d.drawImage(map.getImageMap().get("player" + (int) animPos + dir),
	// player.getPlayerX(), player.getPlayerY(), this);
	// //g2d.drawImage(map.getImageMap().get("player0up"),
	// player.getPlayerLocX() * TILE_SIZE, player.getPlayerLocY() * TILE_SIZE,
	// this);
	// if (player.getBlock() != 0) { //if the player is holding a block, put it
	// above his head.
	// g2d.drawImage(map.getImageMap().get("block" + player.getBlockType()),
	// player.getPlayerX(), player.getPlayerY() - CHUNK_SIZE, this);
	// }
	// }

	public void PlayGame(Graphics2D g2d) {
		player.draw(g2d, this, map.getMap());
		// drawSun(g2d);
		drawStats(g2d);
		g2d.dispose();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		map.drawMap(g2d, this); //
		PlayGame(g2d);
		g2d.dispose();
		g.dispose();
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W :
				if (!player.isAirborne()) {
					player.setUp(true);
				}
				break;
			case KeyEvent.VK_S :
				player.setDown(true);
				break;
			case KeyEvent.VK_A :
				player.setLeft(true);
				break;
			case KeyEvent.VK_D :
				player.setRight(true);
				break;
			case KeyEvent.VK_SPACE :
				player.pickUpObject();
				break;
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch (e.getKeyCode()) {
			case KeyEvent.VK_W :
				player.setUp(false);
				break;
			case KeyEvent.VK_S :
				player.setDown(false);
				break;
			case KeyEvent.VK_A :
				player.setLeft(false);
				break;
			case KeyEvent.VK_D :
				player.setRight(false);
				break;
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}
}
