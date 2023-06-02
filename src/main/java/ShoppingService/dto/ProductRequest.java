package ShoppingService.dto;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
public class ProductRequest {
    private long productNumber;
    private double price;
}
