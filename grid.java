import java.util.*;
import java.util.Random;
class grid
{
	static int que[] = new int[2];
public static void display(int b[][])
{
int i,j, no=0,t=0;
int c = allign(b);	
for(i=0; i<4; i++)
{
for(j=0; j<4; j++)
{  
  no = String.valueOf(b[i][j]).length();
  t = (c - no)+c;
  System.out.print(b[i][j]);
  {
    for(int k=0; k<t; k++)
		System.out.print(" ");
  }
}
System.out.println();
}
}


public static int allign(int b[][])
{
int i,j, max=0,digits=0;
for(i=0; i<4; i++)
{
for(j=0; j<4; j++)
{
	int val = b[i][j];
digits = String.valueOf(val).length();
if(digits>max)
max = digits;	
}
}

return max;
}


public  static int[] MoveLeft(int b[][])
 {
	 int i,j,k,y=0,g=-1;
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
que[0] = check(b);
que[1] = win(b);
return que;
}
 
public  static int[] MoveRight(int b[][])
{
	int i,j,k,y=0,g=-1;
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
 que[0] = check(b);
que[1] = win(b);
return que; 
}

public static int[] MoveDown(int b[][])
{
	int i,j,k,y=0,g=-1;
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
que[0] = check(b);
que[1] = win(b);
return que;
}

public static int[] MoveUp(int b[][])
{
	int i,j,k,y=0;
	int col=-1;
	int que[] = new int[2];
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

que[0] = check(b);
que[1] = win(b);
return que;
//display(b);
}


//To find empty spaces
public  static int check(int b[][])
{
	int i,j,x=0,y=0,r=0,count=0, ri=0, rj=0, w=0;
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
	if (count==0)
		w = 1;
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
	return w;
}

//Wining condition
public static int win(int b[][])
{
	int i,j, v=-1;
	for(i=0; i<4; i++)
	{
		for(j=0; j<4; j++)
		{
			if(b[i][j]==2048)
			     v=1;
		}
	}
	//System.out.println(v);
	return v;
}

//MAIN METHOD
public static void main(String args[])
{
	Scanner sc= new Scanner(System.in);
int b[][]=new int[4][4];
char ch;
int i,j;
b[2][0]=4;
b[3][3]=2;
int ans[] = new int[2];
display(b);
c1 : do
{
System.out.println("Press U for upward, D for downward, L for leftword, and R for rightword");
ch=sc.next().charAt(0);
switch(ch)
{
//Move Upward
 case 'U' :
            ans = MoveUp(b);
            if(ans[0]==1 || ans[1]==1)
               break c1;				
            break;
 //move down
case 'D' : ans = MoveDown(b);
               if(ans[0]==1 || ans[1]==1)
				  break c1;
           break;

//MOVE LEFT
case 'L' : ans = MoveLeft(b);
           if(ans[0]==1 || ans[1]==1)
			   break c1;
		   break;
		   
//MOVE RIGHT
case 'R': ans = MoveRight(b);
          if(ans[0]==1 || ans[1]==1)
			  break c1;
		  break;
		  

}
}while(ch=='L' || ch=='R'  || ch=='U' || ch=='D');	
 }	 
}

