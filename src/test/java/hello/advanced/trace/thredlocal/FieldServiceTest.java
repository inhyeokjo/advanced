package hello.advanced.trace.thredlocal;

import org.junit.jupiter.api.Test;

import hello.advanced.trace.thredlocal.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FieldServiceTest {

	private ThreadLocalService service = new ThreadLocalService();

	@Test
	void field() throws InterruptedException {
		log.info("main start");
		Runnable userA = () -> {
			service.logic("userA");
		};
		Runnable userB = () -> {
			service.logic("userB");
		};

		Thread threadA = new Thread(userA);
		threadA.setName("thread-A");
		Thread threadB = new Thread(userB);
		threadB.setName("thread-B");

		threadA.start();
		// sleep(2000);
		threadB.start();
		sleep(3000);
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
