import second.Block;
import CSLib.DrawingBox;

public class Client {

	public static void main(String[] args) 
	{
		DrawingBox box = new DrawingBox();
		Block block1 = new Block();
		Block block2 = new Block(100,250);
		
		// Displays the 2 blocks
		block1.display(box);
		block2.display(box);
		
		// Moves block1 to (300, 175)
		block1.setPosition(300, 175);
		block1.display(box);
		
		// Moves block2 to (200, 400)
		block2.setPosition(200, 400);
		block2.display(box);
		
		// Moves block1 to (700, 200) and doubles its
		// width and depth.
		block1.setPosition(700,200);
		block1.setDimensions((block1.getWidth()*2), 
				block1.getHeight(), (block1.getDepth()*2));
		block1.display(box);
		
		// Makes a loop to draw 5 blocks
		Block[] fiveBlocks = new Block[5];
		DrawingBox newBox = new DrawingBox();
		
		for (int i = 0; i < 5; i++)
		{
			fiveBlocks[i] = new Block(100, (i+1)*100);
			fiveBlocks[i].display(newBox);
		}
	}

}
