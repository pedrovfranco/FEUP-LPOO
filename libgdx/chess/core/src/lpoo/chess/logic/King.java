package lpoo.chess.logic;

import java.util.ArrayList;

public class King extends Character
{
	int moveCount = 0;
	
	public King()
	{
		super('K');
	}
	
	public King(int player, int x, int y)
	{
		super(player, x, y, 'p');
	}

	public ArrayList<int[]> getPossible(Map map)
	{
		ArrayList<int[]> ret = new ArrayList<int[]>();
		int[] relativePos = new int[2]; // {x, y}
		int[] absolutePos = new int[2]; // {x, y}
				
		int xadd, yadd;
		
		for (int i = 0; i < 8; i++)
		{
			if (i == 0) //Up
			{
				xadd = 0;
				yadd = 1;
			}
			else if (i == 1) //Up-Right
			{
				xadd = 1;
				yadd = 1;
			}
			else if (i == 2) //Right
			{
				xadd = 1;
				yadd = 0;
			}
			else if (i == 3) //Down-Right
			{
				xadd = 1;
				yadd = -1;
			}
			else if (i == 4) //Down
			{
				xadd = 0;
				yadd = -1;
			}
			else if (i == 5) //Down-Left
			{
				xadd = -1;
				yadd = -1;
			}
			else if (i == 6) //Left
			{
				xadd = -1;
				yadd = 0;
			}
			else // Up-Left
			{
				xadd = -1;
				yadd = 1;
			}
			
			relativePos[0] = xadd;
			relativePos[1] = yadd;
			absolutePos = this.getMovePosition(relativePos);
						
			if (map.isWithinBounds(absolutePos) && (map.getMap()[absolutePos[1]][absolutePos[0]] instanceof Floor || map.getMap()[absolutePos[1]][absolutePos[0]].player != this.player))
			{
				ret.add(absolutePos);
			}
		}
		
		
		return ret;
	}
	
	public void loadTexture()
	{
		if (player == 0)//White
		{
			super.setTexture("../core/src/lpoo/chess/gui/images/white/king.png");
		}
		else			//Black
		{
			super.setTexture("../core/src/lpoo/chess/gui/images/black/king.png");
		}
	}
}