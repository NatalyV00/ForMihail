package domain.decorator;

import domain.properties.Money;
import domain.providers.MoneyProvider;
import domain.repos.Cart;

public class AdditionalDeliver extends CartDecorator{
    private Money money, totall;

    public AdditionalDeliver(Money money){
        this.money = money;

    }

    @Override
    public Money getTotal(){
        this.totall = MoneyProvider.getInstance().getMoney(money.getAmount()+200f);
        System.out.println("Total with delivery = " + totall);
        return totall;
    }
}

