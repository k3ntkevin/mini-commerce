@Service
@RequiredArgsConstructor
public class CartService {
    private final CartItemRepository cartItemRepo;
    private final ProductRepository productRepo;
    private final UserRepository userRepo;

    public void addToCart(Long userId, Long productId, int qty) {
        User user = userRepo.findById(userId).orElseThrow();
        Product product = productRepo.findById(productId).orElseThrow();

        CartItem item = new CartItem(null, user, product, qty);
        cartItemRepo.save(item);
    }

    public List<CartItem> getCart(Long userId) {
        return cartItemRepo.findByUserId(userId);
    }
}
