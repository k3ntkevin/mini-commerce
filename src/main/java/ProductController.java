@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductRepository productRepo;

    @GetMapping
    public List<Product> all() {
        return productRepo.findAll();
    }

    @PostMapping
    public Product create(@RequestBody Product p) {
        return productRepo.save(p);
    }
}
