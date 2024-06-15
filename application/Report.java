package application;

import java.util.ArrayList;

/**
 * A class to represent a financial report.
 * @author wellswa
 *
 */
public class Report {

    protected int id; //the unique identifier of the report, in the event of multiple reports
    protected double subtotal; //the running total of expenses
    private ArrayList<CategorizedReport> groups; //the expenses broken down to categories
    private ArrayList<Expense> expenses; //the expenses as a conglomerate
    
    
    /**
     * Single param constructor to create a blank report with an ID
     * @param id the unique identifier of the report
     */
    public Report(int id) {
        this.subtotal = 0.0;
        this.id = id;
        
        groups = new ArrayList<CategorizedReport>();
        expenses = new ArrayList<Expense>();
    }
    
    
    /**
     * Method to add an expense to the generic expenses as well as the appropriate categorized expense group
     * @param toAdd the expense to be added to the aforementioned groups
     * @return true if the operation succeeded, false otherwise.
     */
    public boolean addExpense(Expense toAdd) {
        
        boolean success = false;
        
        
        int catID = getCategoryID(toAdd); //find the category it belongs
        CategorizedReport toIncrement = getReport(catID); //find the report 
        
        if (toIncrement == null) { //if expense category DNE, create category report
            toIncrement = new CategorizedReport(catID, Category.findCategory(catID));
        }
        toIncrement.addExpense(toAdd);
        
        expenses.add(toAdd); //add to generic expense breakdown
        subtotal += toAdd.getPrice();
        
        success = true;
        
        return success;
    }
    
    /**
     * Gets the unique identifier of this report.
     * @return the int id of the report.
     */
    public int getID() {
        return this.id;
    }
    
    /**
     * Gets the total price of all expenses on the report
     * @return
     */
    public double getPrice() {
        return this.subtotal; //TODO
    }
    
    /**
     * Gets all of the categories used in the report.
     * @return String list of the categories used
     */
    public String getCategories() {
        return null; //TODO
    }
    
    /**
     * Helper method to identify category ID of each expense.
     * @param toAdd the expense to be identified
     * @return the int category ID for the given expense
     */
    private int getCategoryID(Expense toAdd) {
       return toAdd.getCategory().getID();
    }
    
    /**
     * Pulls the categorized report from groups list based on catID. 
     * @param catID the unique Category ID assigned to each categorized report.
     * @return the report if it exists, null otherwise.
     */
    private CategorizedReport getReport(int catID) {
        CategorizedReport key = null;
        
        for (CategorizedReport current: groups) {
            if (current.getID() == catID) key = current;
        }        
        
        return key;
    }
    
}
