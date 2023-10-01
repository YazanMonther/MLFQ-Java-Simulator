package multi_Level;

import java.util.LinkedList;
import java.util.Queue;


public class mlfq {
	private Queue<PocessInfo> queue = new LinkedList<PocessInfo>();
    // Queue 1: Round Robin with quantum of 7
    private Queue<PocessInfo> queue1 = new LinkedList<PocessInfo>();
    // Queue 2: Round Robin with quantum of 10
    private Queue<PocessInfo> queue2 = new LinkedList<PocessInfo>();
    // Queue 3: First In First Out
    private Queue<PocessInfo> queue3 = new LinkedList<PocessInfo>();
    private int timeQuantum1 ;
    private int timeQuantum2 ;
    private int currentTime = 0;
    private int totalResponseTime = 0;
    private int totalWaitingTime = 0; 
    private int totalTurnaroundTime = 0;
    private int totalProcesses ;
    int countNotWork=0;
    int countNumOfSwitches=0;
    boolean flag=false;
    	public mlfq(Queue<PocessInfo> proInfo,int totalProcesses,int Q1,int Q2) {
			this.queue=proInfo;
			this.totalProcesses=totalProcesses;
			this.timeQuantum1=Q1;
			this.timeQuantum2=Q2;
		}
		public void calculate() {
		while (!queue1.isEmpty() || !queue2.isEmpty() || !queue3.isEmpty() || !queue.isEmpty()) {
		// Adding process to q1 Dynmicly
	     while(!queue.isEmpty() && currentTime>= queue.peek().ArrivalTime) {
				PocessInfo p=queue.remove();
				queue1.add(p);
				
				}
				
		while(!queue1.isEmpty() || !queue2.isEmpty() || !queue3.isEmpty()) {
		if(queue1.size()>0) 
			this.FirstRR();
					
		else if(queue2.size()>0) 
			this.SecoundRR();
		
		else if (queue3.size()>0) 
			this.FifoQ();
		
				}
        		if(!queue.isEmpty()) {
				PocessInfo p=queue.remove();
				queue1.add(p);
        		}
        	
            }
            System.out.println("All processes have finished execution");
            
    System.out.println("Average response time: " + (float) totalResponseTime / totalProcesses);
    System.out.println("Average waiting time: " + (float) totalWaitingTime/ totalProcesses );
    System.out.println("Average turnaround time: " + (float) totalTurnaroundTime / totalProcesses);
    System.out.println("Number of Context Switching: "+countNumOfSwitches);
    System.out.println("CPU Utilization :"+((float)(currentTime-countNotWork)/currentTime)*100+"%");
		}
		
		void printPInfo(int p,int ArrivalTime,int Brust,int WaitingTime,int ProcessWorkingTime) {
			System.out.print("P "+p); 
			System.out.print("   A "+ArrivalTime); 
			System.out.print("   B "+Brust);
			System.out.print("   W "+(WaitingTime-ArrivalTime));
			System.out.print("   R "+(WaitingTime));
			System.out.println("   TT "+(ProcessWorkingTime-ArrivalTime));
		}
		
		// Q methods !
		
		void FirstRR(){
			
			System.out.println("1");
			    while (!queue1.isEmpty()) {
	if(queue2.size()>0 && ((queue2.peek().ArrivalTime<queue1.peek().ArrivalTime)||(queue.peek().ArrivalTime<queue1.peek().ArrivalTime) ))
			break;
			    System.out.println(currentTime);
			        PocessInfo p = queue1.remove();
			        if (p.getArrivalTime() > currentTime) {
			        	countNotWork+=p.getArrivalTime()-currentTime;
			            currentTime = p.getArrivalTime();
			            System.out.println("Process " + p.getPno() + " is waiting for its arrival time at " + currentTime);
			        }
			    	p.setWaitingTime(currentTime - p.getArrivalTime());
			    	totalWaitingTime += currentTime - p.getArrivalTime();
			    	int burstTime = p.getBurstTime();
			        p.setResponseTime(currentTime - p.getArrivalTime());
			        totalResponseTime += p.getResponseTime();
			        System.out.println("Process " + p.getPno() + " is in the processor at time " + currentTime);
			        if (burstTime > timeQuantum1) {
			        	currentTime += timeQuantum1; 
			        	p.setTurnaroundTime(currentTime - p.getArrivalTime());
			            p.setBurstTime(burstTime - timeQuantum1);
			            p.ArrivalTime=currentTime;
			            p.setNumOfSwitches(1);
			            countNumOfSwitches++;
			            queue2.add(p);
			              
			        } else {
			        	currentTime += burstTime;
			            p.setTurnaroundTime(currentTime - p.getArrivalTime());
			            totalTurnaroundTime += p.getTurnaroundTime();
			            
			            System.out.println("Process " + p.getPno() + " finished execution in queue 1");
			        }
			        
			    }
		 }
		
		void SecoundRR() {
			System.out.println("2");
		    while (!queue2.isEmpty()) {
		    	// checking if which p to 
if(queue1.size()>0 && ((queue1.peek().ArrivalTime<queue2.peek().ArrivalTime)||(queue.peek().ArrivalTime<queue1.peek().ArrivalTime)))
					break;
		System.out.println(currentTime);
    	PocessInfo p = queue2.remove();
    	int burstTime = p.getBurstTime();
    	if(p.getArrivalTime() > currentTime) {
    		countNotWork+=p.getArrivalTime()-currentTime;
    	currentTime = p.getArrivalTime();
    	System.out.println("Process " + p.getPno() + " is waiting for its arrival time at " + currentTime);
    	} 
    	p.setWaitingTime(currentTime - p.getArrivalTime());
    	totalWaitingTime += currentTime - p.getArrivalTime();
    	System.out.println("Process " + p.getPno() + " is in the processor at time " + currentTime);
    	if (burstTime > timeQuantum2) {
    	p.setBurstTime(burstTime - timeQuantum2);
    	currentTime += timeQuantum2;
    	p.setTurnaroundTime(currentTime  - p.getArrivalTime());
    	p.ArrivalTime=currentTime;
    	p.setNumOfSwitches(1);
        countNumOfSwitches++;
    	queue3.add(p);
    	} else {
    		currentTime += burstTime;
    	p.setTurnaroundTime(currentTime  - p.getArrivalTime());
    	totalTurnaroundTime += currentTime  - p.getArrivalTime();
    	System.out.println("Process " + p.getPno() + " finished execution in queue 2");
    	}
    	}
    	 
    	}
		    
		    void FifoQ() {
		    	while (!queue3.isEmpty()) { 
		    		System.out.println("3");
	        		if(!queue1.isEmpty() )
				    	if(queue1.peek().ArrivalTime<= currentTime ||flag ) 	    		
				    		break;
	        		if( !queue2.isEmpty())
	        		if(queue2.peek().ArrivalTime<=currentTime)
	        			break;
	        		System.out.println(currentTime);
	        	PocessInfo p = queue3.remove();
	        	if(p.getArrivalTime() > currentTime) {
	        		countNotWork+=p.getArrivalTime()-currentTime;
	        	currentTime = p.getArrivalTime();
	        	System.out.println("Process " + p.getPno() + " is waiting for its arrival time at " + currentTime);
	        	}
	            int burstTime =p.getBurstTime();
	            p.setWaitingTime(currentTime - p.getArrivalTime() );
	            totalWaitingTime +=currentTime - p.getArrivalTime();
	            
	            System.out.println("Process " + p.getPno() + " is in the processor at time " + currentTime);
	            currentTime +=burstTime;
	            p.setTurnaroundTime(currentTime  - p.getArrivalTime());
	            totalTurnaroundTime += currentTime  - p.getArrivalTime();
	            System.out.println("Process " + p.getPno() + " finished execution in queue 3");
	            System.out.println(currentTime);
	            
	            }
		    
		}
		
		
}
