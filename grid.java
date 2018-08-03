import java.util.*;
import java.util.Random;
class grid
{
public static void display(int b[][])
{
int i,j;	
for(i=0; i<4; i++)
{
for(j=0; j<4; j++)
{
  System.out.print(b[i][j]+ " ");
}
System.out.println();
}
}

public  static void MoveLeft(int b[][])
 {
	 int i,j,k,y=0;
int col=-1; 
for(i=0; i<4; i++)
{
	col=-1;
	for(j=0; j<4; j++)
	{
		if(b[i][j]==0)
			continue;
		if(col==-1)
		{
			col=j; 
			continue;
		}
		if(b[i][col]!=b[i][j])
		{
			col=j;
			continue;
		}
		
		if(b[i][col]==b[i][j])
		{
			b[i][col]= b[i][j]+b[i][col];
			b[i][j]=0;
			col=-1;
		}
	}
	for(k=0; k<16; k++)
	{
		y=k%4;
		if(y==3)
        continue;
		if(b[i][y]==0&& b[i][y+1]!=0)
		{
			b[i][y]=b[i][y+1];
			b[i][y+1]=0;
		}
	}
}
check(b);
}
 
public  static void MoveRight(int b[][])
{
	int i,j,k,y=0;
int col=-1;
	for(i=0; i<4; i++)
	{
		col=-1;
		for(j=3; j>=0; j--)
		{
			if(b[i][j]==0)
				continue;
			if(col==-1)
			{
				col=j;
				continue;
			}
			if(b[i][col]!=b[i][j])
			{
				col=j;
				continue;
			}
			if(b[i][j]==b[i][col])
			{
				b[i][col]=b[i][col]+b[i][j];
				b[i][j]=0;
				col=-1;
			}
		}
		for(k=15; k>=0; k--)
		{
			y=k%4;
			if(y==0)
            continue;
			if(b[i][y]==0 && b[i][y-1]!=0)
            {
				b[i][y]=b[i][y-1];
				b[i][y-1]=0;
			}
		}
	}
	// NEW TILE ADDED
 check(b);				
}

public static void MoveDown(int b[][])
{
	int i,j,k,y=0;
	int col=-1;
for(j=0; j<4; j++)
{
	col=-1;
	for(i=3; i>=0; i--)
	{
		if(b[i][j]==0)
			continue;
		if(col==-1)
		{
			col=i;
			continue;
		}
		if(b[col][j]!=b[i][j])
		{
			col=i;
			continue;
		}
		if(b[col][j]==b[i][j])
		{
			b[col][j] = b[col][j]+b[i][j];
			b[i][j]=0;
			col=-1;
		}
	}
	for (k = 4*4- 1; k >= 0; k--)
    {
        y = k % 4;
        
        if (y == 0) 
			continue;
        if (b[y][j] == 0 && b[y - 1][j] != 0)  
        {
			
            b[y][j] = b[y - 1][j]; 
            b[y - 1][j] = 0;
		}
    }
}
check(b);
//display(b);
}

public static void MoveUp(int b[][])
{
	int i,j,k,y=0;
	int col=-1;
 for(j=0; j<4; j++)
{
	col=-1;
	for(i=0; i<4; i++)
	{
		if(b[i][j]==0)
			continue;
		if(col==-1)
		{
			col=i;
			continue;
		}
		if(b[col][j]!=b[i][j])
		{
			col=i;
			continue;
		}
		if(b[col][j]==b[i][j])
		{
			b[col][j]= b[col][j]+b[i][j];
			b[i][j]=0;
			col=-1;
		}
	}
	for(k=0; k<16; k++)
	{
		y=k%4;
		if(y==3)
          continue;
		if(b[y][j]==0 && b[y+1][j]!=0)
		{
			b[y][j]=b[y+1][j];
			b[y+1][j]=0;
		}
	}
}

check(b);

//display(b);
}


//To find empty spaces
public  static void check(int b[][])
{
	int i,j,x=0,y=0,count=0, ri=0, rj=0;
	int e[][]= new int [2][16];
	
	for(i=0; i<4; i++)
	{
		for(j=0; j<4; j++)
		{
			if(b[i][j]==0)
			{
				e[0][x]=i;
				x++;
				e[1][y]=j;
				y++;
				count++;
			}
		}
	}
	Random rand = new Random();
	int val = rand.nextInt(count);
	int v = rand.nextInt(100);
	ri = e[0][val];
	rj = e[1][val];
	if(v>=0 && v<=70)
		b[ri][rj]=2;
	else
		b[ri][rj]=4;
	display(b);
}


//MAIN METHOD
public static void main(String args[])
{
	Scanner sc= new Scanner(System.in);
int b[][]=new int[4][4];
//int i,j,col=-1,k,y=0;
char ch;
int i,j;
/*System.out.println("Enter matrix");
for(i=0; i<4; i++)
{
for(j=0; j<4; j++)
{
  b[i][j]=sc.nextInt();
}
}*/
b[2][0]=4;
b[3][3]=2;

do
{
System.out.println("Press U for upward, D for downward, L for leftword, and R for rightword :");
ch=sc.next().charAt(0);
switch(ch)
{
//Move Upward
 case 'U' : MoveUp(b);	
            break;
 //move down
case 'D' : MoveDown(b);
           break;

//MOVE LEFT
case 'L' : MoveLeft(b);
           break;
		   
//MOVE RIGHT
case 'R': MoveRight(b);
          break;
}
}while(ch=='L' || ch=='R'  || ch=='U' || ch=='D');	
 }	 
}

