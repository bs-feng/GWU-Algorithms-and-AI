import java.awt.Point;
import java.lang.reflect.Array;
import java.util.*;

public class Convexhull {

	public static void main (String[] args)
	{
		//n is the number of points
		int n = 10000;
	
		//initialize the points and print all the points
		Point [] points = new Point [n];
		for(int i=0;i<n;i++)
			points[i] = new Point ((int)(Math.random()*10000),(int)(Math.random() * 10000));
		
//		System.out.println("Random " + n +" points are shown below:");
//		for(int i=0;i<n;i++)
//		  System.out.println(i+1 + ". " + points[i]);
//		
		//start to calculate the time cost
		double t1 = System.currentTimeMillis();
		
		//1. sort all the points by their x value
		Arrays.sort(points, new MyComparator());
		System.out.println("Random " + n +" points are shown below:");
		for(int i=0;i<n;i++)
		  System.out.println(i+1 + ". " + points[i]);
		//2. use functions and divide and conquer method to get the results
		LinkedList <Point> list = new LinkedList <Point> ();
		for(int i=0;i<n;i++)
			list.add(points[i]);
		LinkedList <Point> result = ConvexHulls (list);
		double t2 = System.currentTimeMillis();
		
		//calculate the time
		double t = t2 - t1;
		
		//print the results: time cost and the convex points
		System.out.println("Time cost is: " + t + "ms");
		System.out.println("There are " + result.size() + " Convex Hull points and they are:");
		Iterator<Point> it = result.iterator();
		int i=1;
		while(it.hasNext())
		{
			Point next = (Point) it.next();
			System.out.println(i + ". " + next);
			i++;
		}
	}
		
	
	//to find the point is on the left or on the right of a line
	private static int leftOrright (Point target, Point p1, Point p2)
	{
		int x1 = p1.x, y1 = p1.y;
		int x2 = p2.x, y2 = p2.y;
		int x3 = target.x, y3 = target.y;
		
		int s = x1*y2 + x3*y1 + x2*y3 - x3*y2 - x2*y1 - x1*y3;
		if (s > 0)
			return 1; //left
		else
			return 0; //right
	}

	//ConvexHull function: divide and conquer
	private static LinkedList <Point> ConvexHulls(LinkedList<Point> list)
	{
		LinkedList <Point> result = new LinkedList <Point> ();
		//min x and max x value points are in the convex hull points
		Point t1 = list.removeFirst();
		Point t2 = list.removeLast();
		result.add(t1);
		result.add(t2);
		
		LinkedList <Point> leftlist = new LinkedList <Point> ();
		LinkedList <Point> rightlist = new LinkedList <Point> ();
		
		//divide the points into two groups: left and right of a line
		Iterator<Point> it = list.iterator();
		while (it.hasNext())
		{
			Point target = (Point) it.next();
			if(leftOrright(target,t1,t2)==1)
				leftlist.add(target);
			else
				rightlist.add(target);
		}
		
		//conquer the problem
		dealconvex(t1,t2,leftlist,result);
		dealconvex(t2,t1,rightlist,result);

		return result;
	}

	//divide and conquer
	private static void dealconvex (Point p1, Point p2, LinkedList<Point> list, LinkedList<Point> result)
	{
		//find the point which is in the convex hull points
		if(list.size()!=0)
		{
			Iterator<Point> it = list.iterator();
			Point vertex = null;
			int smax = 0;
			
			while(it.hasNext())
			{
				Point target = (Point) it.next();
				int x1 = p1.x, y1 = p1.y;
				int x2 = p2.x, y2 = p2.y;
				int x3 = target.x, y3 = target.y;
				
				int s = x1*y2 + x3*y1 + x2*y3 - x3*y2 - x2*y1 - x1*y3;
				if(s>smax)
				{
					smax = s;
					vertex = target;
				}
			}
			
			//divide the points into two groups
			if(vertex != null)
			{
				result.add(vertex);
				list.remove(vertex);
				
				LinkedList <Point> leftlist = new LinkedList <Point> ();
				LinkedList <Point> rightlist = new LinkedList <Point> ();
				
				Iterator<Point> it2 = list.iterator();
				while (it2.hasNext())
				{
					Point target = (Point) it2.next();
					if(leftOrright(target,p1,vertex)==1)
						leftlist.add(target);
					if(leftOrright(target,vertex,p2)==1)
						rightlist.add(target);
				}
				
				//conquer the problem
				dealconvex(p1,vertex,leftlist,result);
				dealconvex(vertex,p2,rightlist,result);
				
			}
		}
	}
	
}


/////////////////References
//http://www.cnblogs.com/kkgreen/archive/2011/06/12/2078668.html
//http://blog.csdn.net/stalice/article/details/3081043
//http://www.csie.ntnu.edu.tw/~u91029/ConvexHull.html
//http://blog.csdn.net/tmljs1988/article/details/7263691
//http://blog.csdn.net/d2457638978/article/details/50200017
//http://www.cnblogs.com/xudong-bupt/p/3168618.html
//http://www.cnblogs.com/xudong-bupt/p/3168618.html
/////////////////