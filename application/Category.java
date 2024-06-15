package application;

public enum Category {
    
    HOUSING(0, "Mortgage, rent, etc."),
    TRANSPORTATION(1, "Car payment, fuel, maintenance, etc."),
    GROCERIES(2, "Food to cook with"),
    UTILITIES(3, "Water, electric, gas, etc"),
    SAVINGS(4, "Money into savings accounts"),
    INVESTMENTS(5, "Money into investment accounts"),
    DEBTS(6, "Existing bills/debts that were paid"),
    DINING_OUT(7, "Going to restaurants, fast food, etc."),
    TOILETRIES(8, "Whatever health/beauty/quality-of-life"),
    SHOPPING(9, "Personal expenses or otherwise");

    private final int id;
    private final String DESCRIPTION;
    
    private Category(int id, String info) {
        this.id = id;
        this.DESCRIPTION = info;
    }
    
    public int getID() {
        return this.id;
    }
    
    public static Category findCategory(int ID) {
        
        Category result = HOUSING; 
        
        switch(ID) {
        case 1: result = TRANSPORTATION;
        case 2: result = GROCERIES;
        case 3: result = UTILITIES;
        case 4: result = SAVINGS; 
        case 5: result = INVESTMENTS;
        case 6: result = DEBTS;
        case 7: result = DINING_OUT;
        case 8: result = TOILETRIES;
        case 9: result = SHOPPING;
        default: System.out.println("ERROR");
        }
        
        return result;
    }
    
    public String getDescription() {
        return DESCRIPTION;
    }
}
