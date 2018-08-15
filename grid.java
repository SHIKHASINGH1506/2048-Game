import java.util.*;
import java.util.Random;
class grid
{   static int copy[][] = new int[4][4];
	static int gt=0, quit=0;
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
	 int que[] =new int[4];
	 int i,j,k,y=0,g=-1;
int col=-1, mod=-1; 
int rec[] = new int[2];
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
			mod = 0;
		}
	}
}
rec = check(b);
que[0]= rec[0];
que[1] = win(b);
que[2] = mod;
que[3] = rec[1];
return que;
}
 
public  static int[] MoveRight(int b[][])
{
	int que[] =new int[4];
	int i,j,k,y=0,g=-1;
int col=-1, mod= -1;
int rec[] = new int[2];
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
				mod = 0;
			}
		}
	}
	rec = check(b);
que[0]= rec[0];
que[1] = win(b);
que[2] = mod;
que[3] = rec[1];
return que; 
}

public static int[] MoveDown(int b[][])
{
	int que[] =new int[4];
	int i,j,k,y=0,g=-1;
	int col=-1, mod = -1;
	int rec[] = new int[2];
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
			mod = 0;
		}
    }
}

rec = check(b);
que[0]= rec[0];
que[1] = win(b);
que[2] = mod;
que[3] = rec[1];
return que;
}
public static int[] MoveUp(int b[][])
{
	int que[] =new int[4];
	int rec[] = new int[2];
	int i,j,k,y=0;
	int col=-1, mod = -1;
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
			mod = 0;
		}
	}
}

rec = check(b);
que[0]= rec[0];
que[1]= win(b);
que[2]= mod;
que[3]= rec[1];
return que;
}
//To find empty spaces
public  static int[] check(int b[][])
{
	int i,j,x=0,y=0,r=0,count=0, ri=0, rj=0, w=0,val=0;
	int e[][]= new int [2][16];
	int rep[] = new int [2];
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
	{
		if(gt==0)
		{
		copy = b;
		gt++;
		}
	  w = 1;
	if(copy == b)
	quit++;
	copy = b;
	}
	Random rand = new Random();
	if(count!=0)
	{ 
	val = rand.nextInt(count);
	int v = rand.nextInt(100);
	ri = e[0][val];
	rj = e[1][val];
	if(v>=0 && v<=70)
		b[ri][rj]=2;
	else
		b[ri][rj]=4;
	}
	display(b);
	rep[0] = w;
	rep[1] = quit;
	return rep;
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
	return v;
}

//MAIN METHOD
public static void main(String args[])
{
	Scanner sc= new Scanner(System.in);
int b[][]=new int[4][4];
//int copy[][] = new int [4][4];
char ch;
int i,j;
b[2][0]=4;
b[3][3]=2;
int anw[] = new int[4];
display(b);
c1 : do
{
System.out.println("Press U for upward, D for downward, L for leftword, and R for rightword");
ch=sc.next().charAt(0);
switch(ch)
{
//Move Upward
 case 'U' :
 case 'u' :
            anw = MoveUp(b);
            if(anw[1]==1)
               break c1;
		    if(anw[3]==4)
			{
			 System.out.println("Oops! you lost your game. Try once more.");
             break c1;	
			}
           else if(anw[0]==1 && anw[2] ==-1)
			{
				//copy = b;
			  System.out.println("No modificiations is possible in this move : ");
              System.out.println("Choose another move: ");
			}
           		  
            break;
 //move down
case 'D' : 
case 'd' :
               anw = MoveDown(b);
               if(anw[1]==1)
				  break c1;
			   if(anw[3]==4)
                  break c1;	
			 else if(anw[0]==1 && anw[2] == -1)
			  {
				  System.out.println("No modifications is possible in this move : ");
				  System.out.println("Choose another move: ");
			  }
			  
           break;

//MOVE LEFT
case 'L' :
case 'l' :         
		   anw = MoveLeft(b);
           if(anw[1]==1)
			   break c1;
		   if(anw[3] == 4)
			   break c1;
		   else if(anw[0]==1 && anw[2] ==-1)
		   {
			   System.out.println("No modifications is possible in this move : ");
			   System.out.println("Choose another move: ");
		   }
		  
		   break;
		   
//MOVE RIGHT
case 'R': 
case 'r':
          anw = MoveRight(b);
          if(anw[1]==1)
			  break c1;
		  if(anw[3] == 4)
			   break c1;
		  else if(anw[0]==1 && anw[2] == -1)
		  {
			  System.out.println("No modifications is possible in this move : ");
			  System.out.println("Choose another move: ");
		  }
		  break;
default : break;		  

}
}while(ch=='L' || ch=='l' || ch=='R' || ch=='r' || ch=='U' || ch=='u' || ch=='D' || ch=='d');	
 }	 
}

