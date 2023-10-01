package multi_Level;

import java.util.LinkedList;
import java.util.Queue;

public class RandomlyGenerate {
	private int n;
	public static Queue<ProcessInfo>  q1 = new LinkedList<ProcessInfo>();;
		
		public RandomlyGenerate(int n) {
			this.n=n;
		} 

		public Queue<ProcessInfo> generateRandomly() {
			int A=1;
//			generate process randomly 
			for(int i=0;i<n;i++) {
				if(i==0)
				A=0;
				else
					A=(int) (A+Math.random()*10);
				int B=(int) (1+Math.random()*20);
				ProcessInfo p=new ProcessInfo(i,B,A);

				RandomlyGenerate.q1.add(p); 	
	  
			 
			}
			return RandomlyGenerate.q1;
		}
}
