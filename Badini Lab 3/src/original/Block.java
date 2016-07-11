package original;
/**
 * Creates and manipulates Block objects.
 * X and Y positions represent the top-left corner
 * of the block.
 * 
 * @author Luke Badini
 * @version 4/16/2015
 */

import CSLib.DrawingBox;

public class Block 
{
	private int width;
	private int height;
	private int depth;
	private int xPos;
	private int yPos;

	/**
	 * Constructs a block with the default parameters.
	 */
	public Block()
	{
		width = 50;
		height = 50;
		depth = 50;
		xPos = 100;
		yPos = 100;
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
		this();
		xPos = xCoord;
		yPos = yCoord;
	}
	
	/**
	 * Returns the width of the block
	 */
	public int getWidth()
	{
		return width;
	}
	
	/**
	 * Returns the height of the block
	 */
	public int getHeight()
	{
		return height;
	}
	
	/**
	 * Returns the depth of the block
	 */
	public int getDepth()
	{
		return depth;
	}
	
	/**
	 * Returns the X position of the block
	 */
	public int getXPos()
	{
		return xPos;
	}
	
	/**
	 * Returns the Y position of the block
	 */
	public int getYPos()
	{
		return yPos;
	}
	
	/**
	 * Sets the X and Y positions of the block to new values
	 * 
	 * @param newXPos; new X position of the block
	 * @param newYPos; new Y position of the block
	 */
	public void setPosition(int newXPos, int newYPos)
	{
		xPos = newXPos;
		yPos = newYPos;
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
		width = newWidth;
		height = newHeight;
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
			box.drawRect(xPos+(i), yPos+(i), height, width);
		}
		
	}
}
