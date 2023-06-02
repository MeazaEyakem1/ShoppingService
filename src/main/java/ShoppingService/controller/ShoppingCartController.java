package ShoppingService.controller;

import ShoppingService.ShoppingServiceApplication;
import ShoppingService.domain.ShoppingCart;
import ShoppingService.dto.ProductRequest;
import ShoppingService.service.ShoppingCartService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.bson.types.ObjectId;
import java.util.List;

@RequestMapping("/carts")
@RestController
public class ShoppingCartController {

    @Autowired
    ShoppingCartService shoppingCartService;
    @PostMapping("/{cartNumber}")
    public ShoppingCart addProductToCart(@PathVariable String cartNumber, @RequestBody ProductRequest productRequest){

        return shoppingCartService.addToCart(cartNumber, productRequest);
    }

    @GetMapping("/{cartNumber}")
    public ShoppingCart getShoppingCart(@PathVariable String cartNumber){
        return shoppingCartService.getCartByID(cartNumber);
    }

    @GetMapping
    public List<ShoppingCart> ShippingCart(){
        return shoppingCartService.getCart();
    }
}
