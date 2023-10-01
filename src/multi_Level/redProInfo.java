package multi_Level;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class redProInfo {
	
	
	Queue<PocessInfo> redPro(String filePath){
		//ArrayList to store the jobs
	Queue<PocessInfo> jobs = new  LinkedList<PocessInfo>();
			try {
			 BufferedReader br = new BufferedReader(new FileReader(filePath));
			 String line;
			 while ((line = br.readLine()) != null) {
			     // Split the line by space
				 
			     String[] values = line.split(" ");
////			     System.out.println(values[2]);
			     int pno = Integer.parseInt(values[2]);
//			     for(int i=0;i<values.length;i++)
//			     System.out.println(values[i]+"  "+i);
			     int arrivalTime = Integer.parseInt(values[5]);
//			     System.out.println(arrivalTime);
			     int burstTime = Integer.parseInt(values[8]);
//			     System.out.println(pno);
//			     // Create a new Job object with the values
			     PocessInfo Info = new PocessInfo(pno, arrivalTime, burstTime);
			     // Add the job to the ArrayList
			     jobs.add(Info);
			 }
			 br.close();
			} catch (IOException e) {
			 e.printStackTrace();
			}
			return jobs;

	}
}
