package domain.decorator;
import domain.properties.Money;
import domain.repos.Cart;

public abstract class CartDecorator extends Cart {
   public abstract Money getTotal();
}
