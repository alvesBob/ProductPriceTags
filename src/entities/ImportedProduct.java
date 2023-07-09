package entities;

public class ImportedProduct extends Product {
    private static Double customsFee;

    public ImportedProduct(String name, Double price, Double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public static Double getCustomsFee() {
        return customsFee;
    }

    public void setCustomsFee(Double customsFee) {
        this.customsFee = customsFee;
    }


    public Double totalPrice(){
        return getPrice() + getCustomsFee();
    }
    @Override
    public String priceTag() {
        return "$ " + totalPrice().toString();
    }

}
