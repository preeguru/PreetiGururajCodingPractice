
public class MultithreadingSample implements Runnable {
	
	private int threadNumber;
	public MultithreadingSample(int x) {
		this.threadNumber=x;
	}
	
	@Override
	public void run() {
		for(int i=1;i<5;i++) {
			System.out.println(i + " from Thread Number" +threadNumber);
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
}
