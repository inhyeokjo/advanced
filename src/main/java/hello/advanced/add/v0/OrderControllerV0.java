package hello.advanced.add.v0;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController("/v0")
@RequiredArgsConstructor
public class OrderControllerV0 {

	private final OrderServiceV0 orderService;

	@GetMapping("/request")
	public String request(String itemId) {
		orderService.orderItem(itemId);
		return "ok";
	}
}
