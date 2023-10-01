package multi_Level;

public class PocessInfo {

    int Pno;
    int ArrivalTime;
    int BurstTime;
    private int numOfSwitches;
    private int responseTime;
    private int waitingTime;
    private int turnaroundTime;
   public PocessInfo(int pno, int arrivalTime, int burstTime) {
       this.Pno = pno;
       this.ArrivalTime = arrivalTime;
       this.BurstTime = burstTime;
   }


   public int getPno() {
       return Pno;
   }

   public int getArrivalTime() {
       return ArrivalTime;
   }

   public int getBurstTime() {
       return BurstTime;
   }

   public void setBurstTime(int burstTime) {
       this.BurstTime = burstTime;
   }

   public int getResponseTime() {
       return responseTime;
   }

   public void setResponseTime(int responseTime) {
       this.responseTime = responseTime;
   }

   public int getWaitingTime() {
       return waitingTime;
   }

   public void setWaitingTime(int waitingTime) {
       this.waitingTime += waitingTime;
   }

   public int getTurnaroundTime() {
       return turnaroundTime;
   }

   public void setTurnaroundTime(int turnaroundTime) {
       this.turnaroundTime += turnaroundTime;
   }
   public void setNumOfSwitches(int s) {
	   this.numOfSwitches +=s;
   }
   public int getNumOfSwitchis() {return this.numOfSwitches;}
}
