package aula.thread;

public class TesteThread {

	public static void main(String[] args) {

		Job1 job1 = new Job1();
		Job2 job2 = new Job2();

		Thread t1 = new Thread(job1);
		Thread t2 = new Thread(job2);

		t1.start();
		t2.start();

		for (int i = 0; i < 1000000; i++) {
			System.out.println("principal");
			try {
				Thread.sleep(1);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
