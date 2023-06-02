package ShoppingService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.aot.generate.GeneratedMethod;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Document
@Component
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShoppingCart {


    @Id
    @Generated
    public String cartNumber;
    public ShoppingCart(String cartNumber){
        this.cartNumber = cartNumber;
        cartLineList = new ArrayList<>();
    }
    public List<CartLine> cartLineList;


    public void addToCart(CartLine cartLine){
        cartLineList.add(cartLine);
    }
    public void removeFromCart(CartLine cartLine){
        cartLineList.remove(cartLine);
    }
    public void changeQuantity(int lineID,int quantity){
        cartLineList.get(lineID).setQuantity(quantity);
    }
    public void checkOut(){
        System.out.println("checking out");
    }

}
