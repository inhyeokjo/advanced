package hello.advanced.trace.thredlocal.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadLocalService {
	private final ThreadLocal<String> nameStore = new ThreadLocal<>();

	public String logic(String name) {
		log.info("์ ์ฅ name={} -> nameStore={}", name, nameStore.get());
		nameStore.set(name);
		sleep(1000);
		log.info("์กฐํ nameStore={}", nameStore.get());

		String returnValue = nameStore.get();
		nameStore.remove();
		return returnValue;
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
