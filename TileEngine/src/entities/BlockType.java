/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import interfaces.BlockImages;
import java.awt.Image;

import enums.BlockIDString;

/**
 * 
 * @author Cameron
 */
public class BlockType implements BlockImages {

	protected Image img;
	protected boolean isSolid;
	protected String typeName;

	public BlockType(BlockIDString typeID) {
		switch (typeID) {
			case SKY :
				typeName = "sky";
				img = SKY;
				isSolid = false;
				break;
			case GRASS :
				typeName = "grass";
				img = GRASS;
				isSolid = true;
				break;
			case DIRT :
				typeName = "dirt";
				img = DIRT;
				isSolid = true;
				break;
			case STONE :
				typeName = "stone";
				img = STONE;
				isSolid = true;
				break;
			case DIAMOND :
				typeName = "diamond";
				img = DIAMOND;
				isSolid = true;
				break;
			case BEDROCK :
				typeName = "bedrock";
				img = BEDROCK;
				isSolid = true;
				break;
		}
	}

	
	
	protected boolean isSolid() {
		return isSolid;
	}



	protected void changeType(BlockIDString typeID) {
		switch (typeID) {
			case SKY :
				typeName = "sky";
				img = SKY;
				isSolid = false;
				break;
			case GRASS :
				typeName = "grass";
				img = GRASS;
				isSolid = true;
				break;
			case DIRT :
				typeName = "dirt";
				img = DIRT;
				isSolid = true;
				break;
			case STONE :
				typeName = "stone";
				img = STONE;
				isSolid = true;
				break;
			case DIAMOND :
				typeName = "diamond";
				img = DIAMOND;
				isSolid = true;
				break;
			case BEDROCK :
				typeName = "bedrock";
				img = BEDROCK;
				isSolid = true;
				break;
		}
	}
}
