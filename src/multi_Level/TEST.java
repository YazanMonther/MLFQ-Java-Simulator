package multi_Level;

public class TEST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		redProInfo red=new redProInfo();
		var proInfo=red.redPro("C:\\Users\\DELL\\Downloads\\schedulingDATA(1000).txt");
		
		//RandomlyGenerate proInfo=new RandomlyGenerate(5);
		//var generateInfo=proInfo.generateRandomly();
		mlfq MLFQ=new mlfq(proInfo,1000,13,10);
		MLFQ.calculate();
	}

}
