package bakery.entities.bakedFoods;

import bakery.entities.bakedFoods.interfaces.BakedFood;

import static bakery.common.ExceptionMessages.*;

public abstract class BaseFood implements BakedFood {
    private String name;
    private double portion;
    private double price;

    protected BaseFood(String name, double portion, double price) {
        setName(name);
        setPortion(portion);
        setPrice(price);
    }

    public void setName(String name) {
        if(name.trim().isEmpty() || name == null){
            throw  new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    public void setPrice(double price) {
        if(price <= 0){
            throw new IllegalArgumentException(INVALID_PRICE);
        }
        this.price = price;
    }

    public void setPortion(double portion) {
        if(portion <= 0){
            throw new IllegalArgumentException(INVALID_PORTION);
        }
        this.portion = portion;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getPortion() {
        return this.portion;
    }

    @Override
    public double getPrice() {
        return this.price;
    }



    @Override
    public String toString() {
        // "{currentBakedFoodName}: {currentPortion - formatted to the second digit}g - {currentPrice - formatted to the second digit}"
        return String.format("%s: %.2fg - %.2f",getName(),getPortion(),getPrice());
    }
}
