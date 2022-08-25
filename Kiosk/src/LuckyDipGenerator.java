
public class LuckyDipGenerator
{
  private int randomNumber;
  
  /**
   * Default Constructor for RLuckyDipGenerator
   */
  public LuckyDipGenerator()
  {
      
  }
  
  /**
   * Parameterised Constructor for setting maximum value
   * 
   * @param limit is the integer value entered
   * 
   */
  public LuckyDipGenerator(int limit)
  {
      getLuckyDipGenerator(limit);
  }
  
  /**
   * Generate random number
   * 
   * @param limit The maximum value, inclusive, for random number generation
   * @return random integer from 1 to limit, inclusive 
   */
  public int getLuckyDipGenerator(int limit)
  {
      randomNumber = 1 + (int) (Math.random() * limit);
      return randomNumber;
  }
  
  /**
   * Get random number 
   * 
   * @return Integer value of the random number, no maximum value specified 
   */
  public int getLuckyDipGenerator()
  {
      return randomNumber;
  }
}
