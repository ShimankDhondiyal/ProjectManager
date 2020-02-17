/**
* this class will define a TeamMember object and its respective functions

 @author Shimank Dhondiyal
 @author Micahel Cardoso
 */
public class TeamMember
{
   private String name;
   private Date startDate;

   /**
   Constructs TeamMember objects

   @param nm name
   @param date startDate
   */
   public TeamMember(String nm, Date date)
   {
       name = nm;
       startDate = date;
   }

   /**
   * returns startDate
   */
   public Date getStartDate()
   {
      return this.startDate;
   }

   /**
   * compares two objects and determines whether values are same
   *
   * @param obj object to compare
   * @return true if same object and value, false otherwise
   */
   public boolean equals(Object obj)
   {
     if(!(obj instanceof TeamMember)) {
		   return false;
	   }
	   TeamMember teamObj = (TeamMember) obj;
	   
	   return this.name.equals(teamObj.name) && this.startDate.equals(teamObj.startDate);
   }

   /**
   * method used to convert teamMember to string for printing
   *
   * @return teamMember String encapsulating all information
   */
   public String toString()
   {
       String teamMember = name + " " + startDate;
       return teamMember;
   }

   public static void main(String [] args)
   {
     //dates are assumed to be correct because this main is to test the
     //functionality of TeamMember
      Date firstDate = new Date("01/18/2009");
      Date secondDate = new Date("10/22/1987");
      TeamMember a = new TeamMember("personA", firstDate);
      TeamMember b = new TeamMember("personB", secondDate);

      System.out.println(a.getStartDate());
      System.out.println(a.toString());
      System.out.println(a.equals(b));
   }
}
