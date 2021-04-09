package bakery.entities.tables;

import bakery.entities.bakedFoods.interfaces.BakedFood;
import bakery.entities.drinks.interfaces.Drink;
import bakery.entities.tables.interfaces.Table;

import java.util.ArrayList;
import java.util.Collection;

import static bakery.common.ExceptionMessages.INVALID_NUMBER_OF_PEOPLE;
import static bakery.common.ExceptionMessages.INVALID_TABLE_CAPACITY;

public abstract class BaseTable implements Table {

    private Collection<BakedFood> foodOrders;
    private  Collection<Drink> drinkOrders;

    private int tableNumber;
    private  int capacity;
    private double pricePerPerson;

    private boolean isReserved;
    private int numberOfPeople;
    private double price;

    protected BaseTable(int tableNumber, int capacity, double pricePerPerson) {
        this.tableNumber = tableNumber;
        setCapacity(capacity);
        this.pricePerPerson = pricePerPerson;
        foodOrders = new ArrayList<>();
        drinkOrders = new ArrayList<>();
        this.isReserved = false;
    }

    @Override
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getTableNumber() {
        return tableNumber;
    }

    @Override
    public int getNumberOfPeople() {
        return numberOfPeople;
    }

    @Override
    public double getPricePerPerson() {
        return pricePerPerson;
    }

    @Override
    public boolean isReserved() {
        return isReserved;
    }

    @Override
    public double getPrice() {
        price = pricePerPerson * numberOfPeople;
        return price;}

    public void setCapacity(int capacity) {
        if(capacity < 0){
            throw new IllegalArgumentException(INVALID_TABLE_CAPACITY);
        }
        this.capacity = capacity;
    }

    public void setNumberOfPeople(int numberOfPeople) {
        if(numberOfPeople <= 0){
            throw new IllegalArgumentException(INVALID_NUMBER_OF_PEOPLE);
        }
        this.numberOfPeople = numberOfPeople;
    }

    @Override
    public  void reserve(int numberOfPeople){
        setNumberOfPeople(numberOfPeople);
        this.price = this.getPricePerPerson() * numberOfPeople;
        this.isReserved = true;
    }

    @Override
    public void orderFood(BakedFood food) {
        foodOrders.add(food);
    }

    @Override
    public void orderDrink(Drink drink) {
        drinkOrders.add(drink);
    }

    @Override
    public double getBill() {
        double bill = 0.00;
        if(!drinkOrders.isEmpty()){
            for (Drink drinkOrder : drinkOrders) {
                bill = bill + drinkOrder.getPrice();
            }
        }

        if(!foodOrders.isEmpty()){
            for (BakedFood foodOrder : foodOrders) {
                bill += foodOrder.getPrice();
            }
        }
        return bill;
    }

    @Override
    public void clear() {
        foodOrders.clear();
        drinkOrders.clear();
        this.isReserved = false;
        this.numberOfPeople = 0;
        this.price = 0;
    }

    @Override
    public String getFreeTableInfo() {
        StringBuilder sb = new StringBuilder();
        sb .append("Table: ").append(getTableNumber()).append(System.lineSeparator())
                .append("Type: ").append(this.getClass().getSimpleName()).append(System.lineSeparator())
                .append("Capacity: ").append(getCapacity()).append(System.lineSeparator())
                .append(String.format("Price per Person: %.2f",getPricePerPerson()));

        return sb.toString();
    }


}
