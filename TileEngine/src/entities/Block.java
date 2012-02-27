/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.awt.Image;

import enums.BlockIDString;

import interfaces.Constants;

/**
 * 
 * @author Cameron
 */
public class Block extends BlockType implements Constants {

	private int arrayX, arrayY, x, y;
	private BlockIDString typeID;

	public Block(int rowX, int colY, BlockIDString typeID) {
		super(typeID);
		this.typeID = typeID;
		arrayX = x; // Array index X
		arrayY = y; // Array Index Y
		x = rowX * TILE_SIZE; // True X
		y = colY * TILE_SIZE; // True Y
	}
	public Block(BlockIDString typeID) {
		super(typeID);
		this.typeID = typeID;
	}

	public Image getImage() {
		return super.img;
	}

	public int getArrayX() {
		return arrayX;
	}

	public void setArrayX(int arrayX) {
		this.arrayX = arrayX;
	}

	public int getArrayY() {
		return arrayY;
	}

	public void setArrayY(int arrayY) {
		this.arrayY = arrayY;
	}

	public BlockIDString getTypeID() {
		return typeID;
	}

	public void setTypeID(BlockIDString typeID) {
		this.typeID = typeID;
		super.changeType(this.typeID);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

}
