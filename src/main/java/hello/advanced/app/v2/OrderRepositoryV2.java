package hello.advanced.app.v2;

import org.springframework.stereotype.Repository;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV2;
import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

	private final HelloTraceV2 trace;

	public void save(String itemId, TraceStatus status) {
		try {
			status = trace.beginSync(status.getTraceId(), "OrderRepository.save()");
			//저장 로직
			if (itemId.equals("ex")) {
				throw new IllegalStateException("삐용 삐용");
			}
			sleep(1000);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
	}

	private void sleep(int millis) {
		try {
			Thread.sleep(millis);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
