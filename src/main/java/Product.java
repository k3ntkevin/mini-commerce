@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    @Id @GeneratedValue
    private Long id;
    private String name;
    private Double price;
}
