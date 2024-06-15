package application;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Expense {

    private double price;
    private String name;
    private String purchDesc;
    private LocalDate date;
    private Category category;
    
    
    
    
    public Expense(String name, double price, Category category, LocalDate date, String purchDesc) {
        
        this.name = name;
        this.price = price;
        this.category = category;
        this.date = date;
        this.purchDesc = purchDesc;
    }
    
    public String getName() {
        return this.name;
    }
    
    public String getDOP() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/d/uu");
        String toDisplay = date.format(formatter);
        
        return toDisplay;
    }
    
    public Category getCategory() {
        return this.category;
    }
    
    public double getPrice() {
        return this.price;
    }
    
    public String getDesc() {
        return this.purchDesc;
    }
    
    
    private boolean setCategory() {
        return false; //TODO
    }
    
}
