@RestController
@RequestMapping("/orders")
@RequiredArgsConstructor
public class OrderController {
    private final OrderService orderService;

    @PostMapping("/checkout")
    public Order checkout(@RequestParam Long userId) {
        return orderService.checkout(userId);
    }
}
