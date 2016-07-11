package second;
/**
 * Creates and manipulates Block objects.
 * X and Y positions represent the top-left corner
 * of the block.
 * 
 * @author Luke Badini
 * @version 4/16/2015
 */

import java.awt.Rectangle;
import CSLib.DrawingBox;

public class Block 
{
	private Rectangle frontFace;
	private int depth;

	/**
	 * Constructs a block with the default parameters.
	 */
	public Block()
	{
		frontFace = new Rectangle (100, 100, 50, 50);
		depth = 50;
	}
	
	/**
	 * Constructs a block with default width, height, and depth
	 * but with defined X and Y positions.
	 * 
	 * @param xCoord; defined xPos for the block
	 * @param yCoord; defined yPos for the block
	 */
	public Block(int xCoord, int yCoord)
	{
		frontFace = new Rectangle (xCoord, yCoord, 50, 50);
		depth = 50;
	}
	
	/**
	 * Returns the width of the block as an integer
	 */
	public int getWidth()
	{
		return (int) frontFace.getWidth();
	}
	
	/**
	 * Returns the height of the block as an integer
	 */
	public int getHeight()
	{
		return (int) frontFace.getHeight();
	}
	
	/**
	 * Returns the depth of the block
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * Returns the X position of the block as an integer
	 */
	public int getXPos()
	{
		return (int) frontFace.getX();
	}
	
	/**
	 * Returns the Y position of the block as an integer
	 */
	public int getYPos()
	{
		return (int) frontFace.getY();
	}
	
	/**
	 * Sets the X and Y positions of the block to new values
	 * 
	 * @param newXPos; new X position of the block
	 * @param newYPos; new Y position of the block
	 */
	public void setPosition(int newXPos, int newYPos)
	{
		frontFace.setLocation(newXPos, newYPos);
	}
	
	/**
	 * Sets the width, height, and depth of the block to new values
	 * 
	 * @param newWidth; new width of the block
	 * @param newHeight; new height of the block
	 * @param newDepth; new depth of the block
	 */
	public void setDimensions(int newWidth, 
			int newHeight, int newDepth)
	{
		frontFace.setSize(newWidth, newHeight);
		depth = newDepth;
	}
	
	/**
	 * Creates a DrawingBox and draws the 3D block
	 * in the DrawingBox.
	 * 
	 * @param box; a defined DrawingBox object
	 */
	public void display(DrawingBox box)
	{
		box.setVisible(true);
		
		for (int i = 0; i <= depth/2; i += 2)
		{
			box.drawRect((int)frontFace.getX()+(i), 
					(int)frontFace.getY()+(i),
					(int)frontFace.getHeight(), 
					(int)frontFace.getWidth());
		}
		
	}
}
