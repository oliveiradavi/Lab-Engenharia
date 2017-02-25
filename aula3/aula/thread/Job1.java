package aula.thread;

public class Job1 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 1000000; i++) {
			System.out.printf("Job - 1\n");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
