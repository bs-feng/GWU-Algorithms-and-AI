import java.awt.Point;
import java.util.Comparator;

//it is used to sort the points by x value
class MyComparator implements Comparator {
    public int compare(Object p1, Object p2) {
        Point pt1= (Point)p1;
        Point pt2= (Point)p2;
        if(pt1.x != pt2.x)
            return pt1.x>pt2.x? 1:-1;
        else
            return pt1.y>pt2.y? 1:-1;
    }
    
}
