package application;

public class CategorizedReport extends Report {
    
    private Category reportCategory;
    

    public CategorizedReport(int id, Category reportCategory) {
        super(id);
        this.reportCategory = reportCategory;
        
    }
    
    
    public Category getCategory() {
        return this.reportCategory;
    }
    
    public boolean addExpense(Expense toAdd) {
        boolean success = false;
        
        this.subtotal += toAdd.getPrice();
        
        
        return success;
    }


}
