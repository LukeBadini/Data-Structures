/** 
 * Draws and manipulates rectangles
 * 
 * @author Luke Badini Lab 01
 * @version 4/9/2015
 */

import CSLib.DrawingBox;
import CSLib.OutputBox;
import java.awt.Rectangle;

public class RectangleTester
{
	public static void main(String[] args) 
	{
		DrawingBox myBoard;
		myBoard = new DrawingBox();
		myBoard.setVisible(true);
		//myBoard.drawRect(320,230,120,180);
		
		Rectangle myRectangle;
		myRectangle = new Rectangle(320,230,120,180);
		myBoard.drawRect(myRectangle);
		
		myRectangle.grow(20,20);
		myBoard.drawRect(myRectangle);
		
		myRectangle.translate(280, -50);
		myBoard.drawRect(myRectangle);
		
		myRectangle.setLocation(75,250);
		myBoard.drawRect(myRectangle);
		
		myRectangle.setLocation(75, 50);
		myRectangle.setSize(200,150);
		myBoard.drawRect(myRectangle);
		
		//Putting it all together
		DrawingBox myBox;
		myBox = new DrawingBox();
		OutputBox myOutBox;
		myOutBox = new OutputBox();
		Rectangle Rect1;
		Rectangle Rect2;
		Rect1 = new Rectangle(50, 180, 120, 180);
		Rect2 = new Rectangle(100, 240, 150, 200);
		
		myBox.drawRect(Rect1);
		myBox.drawRect(Rect2);
		
		if (Rect1.intersects(Rect2))
		{
			myOutBox.println("The two rectangles intersect");
		}
		else
		{
			myOutBox.println("The two rectangles don't intersect");
		}
		
		Rectangle boundingRect = Rect1.union(Rect2);
		myBox.drawRect(boundingRect);
		
		if (boundingRect.contains(Rect1) && 
				boundingRect.contains(Rect2))
		{
			myOutBox.print("The bounding rectangle contains "
					+ "both Rect1 and Rect 2");
		}
		else
		{
			myOutBox.print("The bounding rectangle does not contain "
					+ "both Rect 1 and Rect 2");
		}
		
	}

}
