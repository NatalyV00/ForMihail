package main;

import domain.decorator.AdditionalDeliver;
import domain.product.*;
import domain.properties.Money;
import domain.providers.MoneyProvider;
import domain.repos.Cart;
import domain.repos.DataRepo;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner myInput = new Scanner( System.in );

//        Money money = MoneyProvider.getInstance().getMoney(1000);
//        DataRepo.getInstance().save(money);
//        money = DataRepo.getInstance().load(Money.class);
//        System.out.println(money);

//        create a new fake product and get price in different currency
//        Product fakeProduct = (Product)ProductFactory.getInstance().getFakeProduct();
//        System.out.println(fakeProduct);

//        fakeProduct.setPrice(fakeProduct.getPrice().toCurrency("RON"));
//        System.out.println(fakeProduct);


        for(int i = 0; i != 6;)
        {
            System.out.println("\n\nSelect an option:\n" +
                                    "1) Show the cart\n" +
                                    "2) Add a new concrete product\n" +
                                    "3) Add a new fake product\n" +
                                    "4) Remove the product from cart\n" +
                                    "5) Get total price of cart\n" +
                                    "6) Get total price of cart with delivery\n" +
                                    "7) Exit\n");
            i = myInput.nextInt();
            switch (i)
            {
                case 1:
                    System.out.println(Cart.getInstance().findAll());
                    break;
                case 2:
                    Product product = (Product) ProductFactory.getInstance()
                            .getProduct("Gorgeous Marble Table", 15.99f, 1, 156,
                                    10, 25, "China", "Concrete Product");
                    DataRepo.getInstance().save(product);
                    product = DataRepo.getInstance().load(product.getClass());
                    Cart.getInstance().add(product);
                    System.out.println(product);
                    //Set the new quantity for product with id=1
                    Cart.getInstance().updateQuantity(1,20);
                    break;
                case 3:
                    int amount;
                    System.out.println("Enter quantity of fake products to add to the cart: ");
                    Scanner in = new Scanner(System.in);
                    amount = in.nextInt();
                    List<AbstractProduct> fakeProducts = ProductFactory.getInstance().getListOfFakeProducts(amount);
                    //System.out.println(fakeProducts);
                    for (AbstractProduct products:fakeProducts) {
                        DataRepo.getInstance().save(products);
                        products = DataRepo.getInstance().load(products.getClass());
                        Cart.getInstance().add((Product) products);
                    }
                    break;
                case 4:
                    int id;
                    System.out.println("Enter id of product you want to delete: ");
                    in = new Scanner(System.in);
                    id = in.nextInt();
                    Cart.getInstance().delete(id);
                    break;
                case 5:
                    Money total = Cart.getInstance().getTotal();
                    System.out.println("Total = " + total);
                    break;
                case 6:
                    total = Cart.getInstance().getTotal();
                    AdditionalDeliver total_del = new AdditionalDeliver(total);
                    total_del.getTotal();
                case 7:
                    break;
                default:
                    System.out.println("Wrong option!");
            }
        }
    }
}
