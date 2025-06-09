public interface UserRepository extends JpaRepository<User, Long> {}
public interface ProductRepository extends JpaRepository<Product, Long> {}
public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByUserId(Long userId);
}
public interface OrderRepository extends JpaRepository<Order, Long> {}
