
public class MultithreadingSample2 extends Thread {
	
	private int threadNumber;
	public MultithreadingSample2(int x) {
		threadNumber=x;
	}
	
	@Override
	public void run() {
		String s = "hello";
		System.out.println(s + " from Thread Alphabet" +threadNumber);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
    
}
