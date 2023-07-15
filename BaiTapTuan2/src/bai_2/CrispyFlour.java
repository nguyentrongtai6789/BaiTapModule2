package bai_2;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class CrispyFlour extends Material implements Discount{
    private int quantity;

    public CrispyFlour(String id, String name, LocalDate manufacturingDate, int cost, int quantity) {
        super(id, name, manufacturingDate, cost);
        this.quantity = quantity;
    }
    @Override
    public double getRealMoney() {
        LocalDate date2 = getExpiryDate();
        LocalDate date1 = LocalDate.from(LocalDateTime.now());
        if(date1.until(date2).getMonths() < 2) {
            return getCost()*60/100;
        } else if (date1.until(date2).getMonths() < 4) {
            return getCost()*80/100;
        } else {
            return getCost()*95/100;
        }

    }
    @Override
    public double getAmount() {
        return quantity*super.getCost();
    }

    @Override
    public LocalDate getExpiryDate() {
        return super.getManufacturingDate().plusYears(1);
    }
    @Override
    public String toString() {
        return super.toString() + ", quantity: " + quantity;
    }
}
