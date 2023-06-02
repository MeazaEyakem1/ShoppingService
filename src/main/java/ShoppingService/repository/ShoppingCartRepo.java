package ShoppingService.repository;

import ShoppingService.domain.ShoppingCart;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ShoppingCartRepo extends MongoRepository<ShoppingCart,ObjectId> {
    public ShoppingCart findShoppingCartByCartNumber(String cartNumber);
}
