import java.util.*;
public class Kiosk
{
    private String name; //name of the customer
    private int buyCredit; //Buy credit
    private int moreCredit; //Buy more credit
    private int currentCredit; //Current credit of the current user
    private int totalCredit;//Total spent credit by the customer
    private int firstChoice;  //the firstChoice selected by the customer
    private int choice;  // choice after first choice and choosing item
    Customer customer = new Customer();  //create instance of Customer class
    LuckyDipGenerator luck = new LuckyDipGenerator();  //create instance of LuckyDipGenerator class
    Scanner console = new Scanner(System.in);
    
    /**
     * 
     * Constructor for objects of class Kiosk
     */
    public Kiosk()
    {    
        totalCredit = 0 ; //initialise totalCredit variable
        checkFirstChoice();
    }
    
    public static void main(String[] args)
    {
    	Kiosk kiosk = new Kiosk();
    	kiosk.display();
 		
    }
    
    /**
     * 
     *display welcomemassage and Main Menu to the customer
     */
    public void display()
    {
        System.out.println("===============================================");
        System.out.println("==== Hi!'Welcome to Super Fantastic Kiosk' ====");
        System.out.println("===============================================");
        System.out.println();
        System.out.println("1. Create A New Order");
        System.out.println("2. Buy More Credit");
        System.out.println("3. Purchase An Item");
        System.out.println("4. What Have I Ordered So Far?");
        System.out.println("5. Collect My Order");
        System.out.println("6. Display Help");
        System.out.println("7. Leave Kiosk");
        System.out.println("Choose an option: ");
    }
    
    /**
     * 
     * Check if each character of the name is an alphabet  
     * @return Boolean value for check result
     */
    public boolean isCharNumber(char charAt)
    {
        if (Character.isDigit(charAt))
        return true;
        else
        return false;
    }
    
    /**
     * 
     * Check if the name contains only alphabetic characters 
     * @return Boolean value for check result 
     */
    public boolean isNameChar()
    {
        int i = 0;
        boolean isNumeric = false;
        while (i < name.length() && !(isNumeric))
        {
            if (isCharNumber(name.charAt(i)) == false)
            {
                i++; //check the next char 
            }
            else
            {
                isNumeric = true;
            }
        }
        return isNumeric;
    }
    
    /**
     * 
     * Method to check if customer name is valid i.e. contains only characters
     */
     public void checkCustomerName()
    {
        if ((name.trim().length() == 0) || (name == null))
        {
            System.out.println("Name cannot be blank");
            setName();
        }
        else if ( (isNameChar() == true) )
        {
            System.out.println("Name can only contain characters (A to Z)");
            setName();
        }
    }
    
    /**
     * 
     * Method for Prompt for Customer's name
     */
    
     public void setName()
    {
        console = new Scanner(System.in);
        System.out.println("Please enter your name: ");
        name = console.nextLine();
        checkCustomerName();
    }
    
    /**
     * 
     * Check first choice of the customer
     * check first choice is must be 1
     * if first choice is in between(2-5) show appropiate error massage 
     * display  main menu
     */
     public void checkFirstChoice()
    {
        display(); 
        firstChoice = console.nextInt();  //check first choice
        switch (firstChoice)
        {
            case 1:
                setName();
                buyCredit(); break; //buy credit
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("You haven't create an order yet. Create an order first");
                checkFirstChoice(); break;
            case 6:
                displayHelp();
                checkFirstChoice(); break;
            case 7:
                System.out.println("Thank you for visiting."); break;  
            default:
                System.out.println("Invaild. Your choice must be between 1-7"); 
                checkFirstChoice();   
        }
    }
    
    /**
     * 
     * after creating order
     * customer has to buy some credit to shop
     * check buying credit not equal to 0 
     */ 
    public void buyCredit()
    {
        customer.setCustomerName(name); 
        currentCredit = 0;  //initialise currentCredit variable
        System.out.println("Buy some credits please: $");
        buyCredit = console.nextInt();  //check credit greater than 0
        if ( buyCredit > 0 )
        {
            currentCredit = currentCredit + buyCredit;
            checkChoice();
        }
        else
        {
            System.out.println("Credit must be greater than 0 .");
            buyCredit();
        }
    }
    
    /**
     * 
     * Control the flow of choosing option on kiosk after first choice
     */
    public void checkChoice()
    {
        display();
        choice = console.nextInt();
        switch (choice)
        {
            case 1: 
                finalisedOrder();
                setName();
                buyCredit(); break;
            case 2:
                buyMoreCredit(); break;
            case 3:
                item(); break;
            case 4:
                customerInformation();
                checkChoice(); break;
            case 5:
                collectOrder(); break;
            case 6:
                displayHelp(); 
                checkChoice(); break;
            case 7:
                System.out.println("Thank you! Hope to see you soon!"); break;
            default:
                System.out.println("Invaild. Your choice must be between 1-7"); 
                checkChoice();
                
        }
        
    }
    
    /**
     * 
     * customer can add more credit to current credit
     * calculate the new current credit
     */
  
    public void buyMoreCredit()
    {
        System.out.println("How much credits you want to buy: $");
        moreCredit = console.nextInt(); //check buy more credit is greater than 0
        if ( moreCredit > 0)
        {
            currentCredit = currentCredit + moreCredit;
            System.out.println("Your new credit balance: $"+currentCredit);
            checkChoice();
        }
        else
        {
            System.out.println("Credit must be greater than 0 ."); 
            checkChoice();
        }
    }
    
    /**
     * 
     * display the available item list with it's worth
     */
    public void displayItem()
    {
        System.out.println("1.PEN, worth $10.");
        System.out.println("2.BOOK, worth $20.");
        System.out.println("3.DVD, worth $30.");
        System.out.println("4.MOUSE, worth $40.");
        System.out.println("5.KEYBOARD, worth $50.");
        System.out.println("6.Let ME pick a random item for you!!!");
        System.out.println("7.Main Menu");
        System.out.println("Which item you want to buy? Choose a number between 1-6 : ");
    }
    
    
    /**
     * 
     * check item purchase choice enter by customer
     * check choosen item 
     * check according to current credit customer can buy the selected item or not
     * if not possible show a appropiate error massage
     * if possible then calculate current credit and total credit
     */
     public void calculateBalance()
     {
           choice = console.nextInt();
           switch (choice)
           {
               case 1:
                   if (currentCredit  >= 10)
                    {
                    currentCredit = currentCredit - 10;
                    totalCredit = totalCredit + 10;
                    customer.setTotalCredit(totalCredit);
                    System.out.println("You have bought a pen, worth $10.");
                    System.out.println("Your new credit balance is now:"+currentCredit);
                    customer.setTotalItemPurchased();  //store number of purchased items
                    customer.setPurchasedItem(choice); //store the name of purchased items
                    }
                    else
                    {
                    System.out.println("You can't buy a PEN, worth $10.");
                    System.out.println("Your credit balance "+currentCredit);
                    }
                   break;
               case 2:
                   if (currentCredit >= 20)
                    {
                        currentCredit = currentCredit - 20;
                        totalCredit = totalCredit + 20;
                        customer.setTotalCredit(totalCredit);
                        System.out.println("You have bought a BOOK, worth $20.");
                        System.out.println("Your new credit balance is now: $"+currentCredit);
                        customer.setTotalItemPurchased();
                        customer.setPurchasedItem(choice);
                    }
                    else
                    {
                        System.out.println("You can't buy a BOOK, worth $20.");
                        System.out.println("Your credit balance $"+currentCredit); break;
                    }
                   break;
               case 3:     
                   if (currentCredit >= 30)
                    {
                    currentCredit = currentCredit - 30;
                    totalCredit = totalCredit + 30;
                    customer.setTotalCredit(totalCredit);
                    System.out.println("You have bought a DVD, worth $30.");
                    System.out.println("Your new credit balance is now : $"+currentCredit);
                    customer.setTotalItemPurchased();
                    customer.setPurchasedItem(choice);
                    }
                    else
                    {
                    System.out.println("You can't buy a DVD, worth $30.");
                    System.out.println("Your credit balance $"+currentCredit); 
                    }
                    break;
               case 4:
                   if (currentCredit >= 40)
                    {
                    currentCredit = currentCredit - 40;
                    totalCredit = totalCredit + 40;
                    customer.setTotalCredit(totalCredit);
                    System.out.println("You have bought a MOUSE, worth $40.");
                    System.out.println("Your new credit balance is now: $"+currentCredit);
                    customer.setTotalItemPurchased();
                    customer.setPurchasedItem(choice);
                    }
                    else
                    {
                    System.out.println("You can't buy a MOUSE, worth $40.");
                    System.out.println("Your credit balance $"+currentCredit);
                    }
                    break;
               case 5:
                   if (currentCredit >= 50)
                    {
                    currentCredit = currentCredit - 50;
                    totalCredit = totalCredit + 50;
                    customer.setTotalCredit(totalCredit);
                    System.out.println("You have bought a KEYBOARD, worth $50.");
                    System.out.println("Your new credit balance is now: $"+currentCredit);
                    customer.setTotalItemPurchased();
                    customer.setPurchasedItem(choice);
                    }
                    else
                    {
                    System.out.println("You can't buy a KEYBOARD, worth $50.");
                    System.out.println("Your credit balance $"+currentCredit);
                   }
                   break;
               case 6:
                   randomItem(); break;
               case 7: 
                   checkChoice(); break;
               default:
                   System.out.println("Invaild. Your choice must be between 1-7"); 
                   displayItem();
           }
    }
    
    /**
     * 
     * check the current credit of customer
     * check which items is appropiate according to customer's current credit
     * select an item randomly for the customer
     */
    public void randomItem()
    {
        int limit;    //limit for generate random number
        
        if (currentCredit >= 50)
        {
            limit = luck.getLuckyDipGenerator(5);
        }
        else if (currentCredit >= 40)
        {
            limit = luck.getLuckyDipGenerator(4);
        }
        else if (currentCredit >= 30)
        {
            limit = luck.getLuckyDipGenerator(3);
        }
        else if (currentCredit >= 20)
        {
            limit = luck.getLuckyDipGenerator(2);
        }
        else if (currentCredit >= 10)
        {
            limit = luck.getLuckyDipGenerator(1);
        }
        else
        {
            limit = 0;
        }
        switch (limit)
        {
           case 0:
               System.out.println("OOPS!!SPRRY!!You don't have enough credit to purchase any item.");
               break;
           case 1:
               currentCredit = currentCredit - 10;
               totalCredit = totalCredit + 10;
               customer.setTotalCredit(totalCredit);
               System.out.println ("Your credit balance $"+currentCredit);
               customer.setTotalItemPurchased();
               customer.setPurchasedItem(limit);  
               break;
           case 2:
               System.out.println("I have chossen BOOK for you!");
               currentCredit = currentCredit - 20;
               totalCredit = totalCredit + 20;
               customer.setTotalCredit(totalCredit);
               System.out.println("Your credit balance $"+currentCredit);
               customer.setTotalItemPurchased();
               customer.setPurchasedItem(limit); 
               break;
           case 3:
               System.out.println("I have chossen DVD for you!");
               currentCredit = currentCredit - 30;
               totalCredit = totalCredit + 30;
               customer.setTotalCredit(totalCredit);
               System.out.println("Your credit balance $"+currentCredit);
               customer.setTotalItemPurchased();  
               customer.setPurchasedItem(limit); 
               break;
           case 4:
               System.out.println("I have chossen MOUSE for you!");
               currentCredit = currentCredit - 40;
               totalCredit = totalCredit + 40;
               customer.setTotalCredit(totalCredit);
               System.out.println("Your credit balance $"+currentCredit);
               customer.setTotalItemPurchased(); 
               customer.setPurchasedItem(limit); 
               break;
           case 5:
               System.out.println("I have chossen KEYBOARD for you!");
               currentCredit = currentCredit - 50;
               totalCredit = totalCredit + 50;
               customer.setTotalCredit(totalCredit);
               System.out.println("Your credit balance $"+currentCredit);
               customer.setTotalItemPurchased();
               customer.setPurchasedItem(limit);
               break;
        }
    }
    
    /**
     * 
     * display available item list
     * after buying items
     * display main menu
     */
    
    public void item()
    {
        displayItem();
        calculateBalance();
        checkChoice();
    }
    
    /**
     * 
     * customer details
     * customer's order details
     * customer's purchased item
     */
    public void customerInformation()
    {
        customer.setCurrentCredit(currentCredit);             //store current credit
        System.out.println(customer.displayCustomerInfo());   //display customer information
        System.out.println(customer.getPurchasedItem());      //display the name of purchased items
    }
    
    /**
     * 
     * display help instructions for the customer
     */
    public void displayHelp()
    
   {
        System.out.println("====================");
        System.out.println("====   Help!!   ====");
        System.out.println("====================");
        System.out.println("Step-1: Create an order.");
        System.out.println("Step-2: Buy Credit.");
        System.out.println("Step-3: Purchase any item you want from the given list.");
        System.out.println("Note: If you choose option 6 from itemlist,then I will choose a item for you.");
        System.out.println("Step-4: Finalize your order");
        System.out.println("For further assistance please ask help from our customer represntative");
    }
    
    /**
     * 
     * display customer's order details
     * instruction for collecting order
     */
    public void finalisedOrder()
    {
        customerInformation();
        System.out.println("Thank you for shopping with us."); 
        System.out.println("Please collect your items and your remaining balance at the front desk.");
    }
    
    /**
     * 
     * finalised an order
     * prepare for another order
     */
    public void collectOrder()
    {
        finalisedOrder();
        checkFirstChoice();
    }
 }
