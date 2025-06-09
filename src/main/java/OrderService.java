@Service
@RequiredArgsConstructor
public class OrderService {
    private final CartItemRepository cartItemRepo;
    private final OrderRepository orderRepo;
    private final UserRepository userRepo;

    public Order checkout(Long userId) {
        List<CartItem> items = cartItemRepo.findByUserId(userId);
        double total = items.stream()
                .mapToDouble(i -> i.getProduct().getPrice() * i.getQuantity())
                .sum();

        Order order = new Order(null, userRepo.findById(userId).orElseThrow(), LocalDateTime.now(), total);
        orderRepo.save(order);

        cartItemRepo.deleteAll(items); // Clear cart
        return order;
    }
}
