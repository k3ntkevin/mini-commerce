@RestController
@RequestMapping("/cart")
@RequiredArgsConstructor
public class CartController {
    private final CartService cartService;

    @PostMapping("/add")
    public void add(@RequestParam Long userId, @RequestParam Long productId, @RequestParam int quantity) {
        cartService.addToCart(userId, productId, quantity);
    }

    @GetMapping
    public List<CartItem> getCart(@RequestParam Long userId) {
        return cartService.getCart(userId);
    }
}
