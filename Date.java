import java.util.Scanner;
import java.util.StringTokenizer;

/**
  * this class defines and provides verification of Date objects

  @author Shimank Dhondiyal
  @author Michael Cardoso
  */
public class Date
{
   private int  day;
   private int  month;
   private int  year;
   /**
    * constructor using string parameter to collect Date attributes
    * by StringTokenizer
    *
    * @param d string to tokenize
    */
   public Date(String d)
   {
     //tokenize the string
	   StringTokenizer tokens = new StringTokenizer(d, "/");
	   //add values to attributes
	   this.month = Integer.parseInt(tokens.nextToken());
	   this.day = Integer.parseInt(tokens.nextToken());
	   this.year = Integer.parseInt(tokens.nextToken());
   }

   /**
    * standard constructor using Data structure
    *
    * @param d Date data type used to construct Date object
    */
   public Date(Date d)
   {
	   this.day = d.day;
	   this.month = d.month;
	   this.year = d.year;
   }

   /**
    * this method is used to verify that given date is valid; it will check
    * day/month relation
    *
    * @return true if valid date, false otherwise
    */
   public boolean isValid()
   {
     //these variables will be called to verify the date
     final int minimumValue = 1;
     final int maximumYear = 2020;
     //verify that day is valid day
     if(this.day > Month.DAYS_ODD || this.day < minimumValue)
     {
      return false;
     }
     //verify that month is valid month
     if(this.month > Month.DEC || this.month < minimumValue)
     {
         return false;
     }
     //year cannot be later than current year (2020)
     if(this.year > maximumYear)
     {
       return false;
     }
    //make note of whether year is leap year
    boolean isLeapYear = isLeapYear(this.year);
    //make sure that months that do not have 31 days are valid
    switch(this.month)
    {
      case Month.FEB:
         if(this.day > Month.DAYS_FEB && !isLeapYear)
         {
            return false;
         }
         else break;
      case Month.APR:
      case Month.JUN:
      case Month.SEP:
      case Month.NOV:
        if(this.day == Month.DAYS_ODD) return false;
        else break;
    }
      return true;
   }

   /**
   * if the year is evenly divisible by 4, 100, and 400,
   * then it is a leap year
   *
   * @param year	the year to verity
   * @return true if leap year, false otherwise
   */
   private boolean isLeapYear(int year) {
    if (((year % Month.QUADRENNIAL == 0) &&
               !(year % Month.CENTENNIAL == 0))
               || (year % Month.QUATERCENTENNIAL == 0)) {
      return true;
    }
    return false;
   }

   /**
   * convert Date object to string for printing
   *
   * @return string formed from Date object
   */
   @Override
   public String toString()
   {
       //use the format "month/day/year"
	   String output = "";
	   output += Integer.toString(this.month) + "/"
			  + Integer.toString(this.day) + "/"
			  + Integer.toString(this.year);
	   return output;
   }

   /**
   * check to see whether or not one object is the same as another
   *
   * @param obj object to compare
   * @return true if objects have same value
   */
   @Override
   public boolean equals(Object obj)
   {
	   if(!(obj instanceof Date)) {
		   return false;
	   }
	   Date objDate = (Date) obj;
	   return this.day == objDate.day
			   && this.month == objDate.month
			   && this.year == objDate.year;
   }

   public static void main(String[] args) {
     System.out.println("Enter date (mm/dd/yyyy)");
     Scanner s = new Scanner(System.in);
     String first = s.nextLine();
     //test constructor
     Date firstDate = new Date(first);
     //test second constructor
     Date firstDateCopy = new Date(firstDate);

     //test methods:
     //1.validity
     System.out.println(firstDate.isValid()); //returns true
     Date badDate = new Date("24/12/9876");
     System.out.println(badDate.isValid());   //returns false

     //2.toString
     System.out.println(firstDate.toString());

     //3.equality
     System.out.println(firstDate.equals(firstDateCopy));  //returns true
     Date secondDate = new Date("05/02/2004");
     System.out.println(firstDate.equals(secondDate));  //returns false

     //close the scanner to prevent memory leaks
     s.close();
   }

}
