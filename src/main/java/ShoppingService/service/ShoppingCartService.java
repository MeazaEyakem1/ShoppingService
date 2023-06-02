package ShoppingService.service;

import ShoppingService.domain.CartLine;
import ShoppingService.domain.Product;
import ShoppingService.domain.ShoppingCart;
import ShoppingService.dto.ProductRequest;
import ShoppingService.repository.ShoppingCartRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShoppingCartService {

    @Autowired
    ShoppingCartRepo shoppingCartRepo;
    @Autowired
    ModelMapper modelMapper;

    public ShoppingCart addToCart(String cartNumber, ProductRequest productRequest) {
        System.out.println("request:" + productRequest.getProductNumber() +""+ productRequest.getPrice());

        Product product = modelMapper.map(productRequest, Product.class);
        CartLine cartLine = new CartLine(1,product);
        System.out.println("mapped:" + product.getProductNumber() +""+ product.getPrice());

        ShoppingCart cart = shoppingCartRepo.findShoppingCartByCartNumber(cartNumber);
        if(cart==null){
            cart = new ShoppingCart(cartNumber);
        }
        cart.addToCart(cartLine);
        shoppingCartRepo.save(cart);
        return cart;
    }

    public List<ShoppingCart> getCart() {
        return shoppingCartRepo.findAll();
    }

    public ShoppingCart getCartByID(String cartNumber) {
        return shoppingCartRepo.findShoppingCartByCartNumber(cartNumber);
    }
}
