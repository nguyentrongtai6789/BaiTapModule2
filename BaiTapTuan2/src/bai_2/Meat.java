package bai_2;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Meat extends Material implements Discount {
    private double weight;

    public Meat(String id, String name, LocalDate manufacturingDate, int cost, double weight) {
        super(id, name, manufacturingDate, cost);
        this.weight = weight;
    }

    @Override
    public double getRealMoney() {
        LocalDate date2 = getExpiryDate();
        LocalDate date1 = LocalDate.from(LocalDateTime.now());
        if(date1.until(date2).getDays() <= 5) {
            return getCost()*70/100;
        } else {
            return getCost()*90/100;
        }
    }

    @Override
    public double getAmount() {
        return weight*super.getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusDays(7);
    }
    @Override
    public String toString() {
        return super.toString() + ", weight: " + weight;
    }
}
