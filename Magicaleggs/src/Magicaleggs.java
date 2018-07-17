
public class Magicaleggs {

	public static void main(String[] args) {
		
		//Given egg eggs and an floor floors building
		int egg = 2;
		int floor = 100;
		//store minimized step in result[0], and the starting floor in result[1]
		int result[] = new int [2];


		//start to calculate the time cost
		double t1 = System.currentTimeMillis();
		result = miniEggDrop(egg, floor);
		double t2 = System.currentTimeMillis();
		double t = t2 - t1;
		
		//print the result
		System.out.println("For " + egg + " eggs and " + floor + " floors building:");
		System.out.println("The minimized number of throws is:" + result[0]);
		System.out.println("The floor from which to drop the first egg is: " + result[1]);
		System.out.println("The processing time is: " + t + " ms");
	}

	private static int [] miniEggDrop (int egg, int floor){
		
		//use result[2] to store the result
		int temp;
		int result[] = new int [2];
		
		//creat eggdrop[][] to store the minimized steps for different combinations of different eggs and floors
		int eggdrop [][] = new int [egg+1][floor+1];
		
		//initiate the eggdrop[][] when there are only one eggs, the worst result is to try each floor
		for(int i=1;i<=floor;i++){
			eggdrop[1][i] = i;
			eggdrop[0][i] = 0;
		}
		
		//initiate the eggdrop[][], when there are only one floor, we only need to try one time
		for(int i=1;i<=egg;i++){
			eggdrop[i][1] = 1;
			eggdrop[i][0] = 0;
		}
		
		//when there is only one egg, or the building only has one floor, we have to start from the first floor
		if(egg == 1 || floor == 1)
			result[1] = 1;
		
		//otherwise for eggs and floors
		for(int i=2;i<=egg;i++)
			for(int j=2;j<=floor;j++){
				
				//initiate the eggdrop[i][j]
				eggdrop[i][j] = Integer.MAX_VALUE;
			
				//we have to try from the k-th floor and get the minimal value
				for(int k=1;k<=j;k++){
					
					//dynamic programming formulation
					temp = 1 + Math.max(eggdrop[i-1][k-1], eggdrop[i][j-k]);
					//find the minimal value and the starting floor
					if(temp<eggdrop[i][j])
					{
						eggdrop[i][j] = temp;
						//get the starting floor
						if(i==egg&&j==floor)
						result[1] = k;
					}
				}
			}
		
		result[0] = eggdrop[egg][floor];
		
		//return the result
		return result;
	}
}


///////////////////
//Reference:
//http://www.geeksforgeeks.org/dynamic-programming-set-11-egg-dropping-puzzle/
//http://www.programmerinterview.com/index.php/puzzles/2-eggs-100-floors-puzzle/
//http://blog.csdn.net/fuyukai/article/details/46882603
//http://blog.csdn.net/joylnwang/article/details/6769160
///////////////////