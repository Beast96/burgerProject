package model;

public class Bill {

    Burger burger;
    private static int taxPercent=15;
    private static int orderNo=1;
    private int currentOrderNo;
    public Bill(Burger burger){
        this.burger = burger;
        currentOrderNo = orderNo++;
    }

    public double getTotal(){
        double total = getSubTotal();
        double netTotal= total + getTax();

        return netTotal;
    }
    public double getTax(){
        return getSubTotal() * taxPercent/100;
    }
    public int getOrderNo(){return currentOrderNo;}

    public double getSubTotal(){
        double tempTotal = 0;

        tempTotal += burger.getPrice();

        for (Topping topping: burger.getToppings()) {
            tempTotal += topping.getPrice();
        }

        return tempTotal;
    }


}
