package hello.advanced.app.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import hello.advanced.trace.TraceStatus;
import hello.advanced.trace.hellotrace.HelloTraceV1;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1")
@RequiredArgsConstructor
public class OrderControllerV1 {

	private final OrderServiceV1 orderService;
	private final HelloTraceV1 trace;

	@GetMapping("/request")
	public String request(String itemId) {
		TraceStatus status = null;
		try {
			status = trace.begin("OrderController.request()");
			orderService.orderItem(itemId);
			trace.end(status);
		} catch (Exception e) {
			trace.exception(status, e);
			throw e;
		}
		return "ok";
	}
}
