 public class Customer
 {
    private String name; //name of the customer
    private int currentCredit; //customer's current credit
    private int totalCredit; //customer's total credit
    private int totalItemPurchased; //customer's total purchased item
    private String items; //customer's purchased item
    
    /**
     * Default Constructor for objects of class Customer
     */
    public Customer()
    {
        totalItemPurchased = 0; //initialise totalItemPurchased variable
        items = "";            //initialise items string
    }
    
    /**
     * Parameterised Constructor for objects of class Customer
     * 
     * @param customerName A name entered by Customer 
     */
    public Customer( String customerName)
    {
        name = customerName;
    }
    
     /**
     * Display Customer details
     * 
     * @return Customer's information 
     */
    public String displayCustomerInfo()
    {
        String information;
        information = "Customer Name: " +name+ "\n" + "Current Credit balance : $" + currentCredit + "\n" + 
                      "Total expenditure : $" + totalCredit + "\n" + "Toatal item purchased: " + totalItemPurchased  + "\n"
                       + "Purchased items are:";
        return information;
    }
    
    /**
     * Accessor method to get Current Credit
     * 
     * @return an integer value to return current credit
     */
    public int getCurrentCredit()
    {
        return currentCredit;
    }
    
    /**
     * Accessor method to get Customer name
     * 
     * @return a single string to return the customer name
     */
    public String getCustomerName()
    {
     return name;
    }
    
     /**
     * Accessor method to get Total Credit
     * 
     * @return an integer value to return total credit
     */
    public int getTotalCredit()
    {  
     return totalCredit;
    }
 
    /**
     * Accessor method to get Total Item Purchased
     * 
     * @return an integer value to return total purchased item
     */
    public int getTotalItemPurchased()
    {
        return totalItemPurchased;
    }
    
    /**
     * Accessor method to get Purchased Item
     * 
     * @return an integer value of Total Credit
     */
    public String getPurchasedItem()
    {
        return items;
    }
    
    /**
     * Method to set Customer name
     * 
     * @param customerName is a single string paased
     */
    public void setCustomerName(String customerName)
    {
      name = customerName;
    }
    
     /**
     * Mutator method to set Current Credit
     * 
     * @param currentCredit an integer value entered
     */
    public void setCurrentCredit(int credit)
    {
        currentCredit = credit;
    }
   
    /**
     * Method to set Total Credit
     * 
     * @param totalCredit an integer value entered
     */
    public void setTotalCredit(int total)
    {
      totalCredit = total;
    }
    
    /**
     * Method to set purchased item in the items string
     * 
     * @param choice is an integer number to purchase item entered
     */
    public void setPurchasedItem(int choice )
    
    {
        switch (choice)
        {
            case 1:
                items = items + "PEN\n"; break;
            case 2:
                items = items + "BOOK\n"; break;
            case 3:
                items = items + "DVD\n"; break;
            case 4:
                items = items + "MOUSE\n"; break;
            case 5:
                items = items + "KEYBOARD\n"; break;
        }
        
    }
    public void setTotalItemPurchased()
    {
       ++totalItemPurchased;
    }
  
 }
