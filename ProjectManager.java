import java.util.Scanner;
import java.util.StringTokenizer;

/**

 @author Shimank Dhondiyal
 @author Michael Cardoso
 */

public class ProjectManager
{
   Scanner stdin;
   Team cs213;
   Date date;
   String memberDate;
   String name;
   TeamMember member;
   public void run()
   {
      boolean done = false;
      cs213 = new Team();
      System.out.println("Let's start a new team!");
      while ( !done )
      {
         stdin = new Scanner(System.in);
         String input = stdin.nextLine();
         StringTokenizer tokens = new StringTokenizer(input, " ");
         String s = tokens.nextToken();
         switch (s)
         {
           case "A":
             name = tokens.nextToken();
             memberDate = tokens.nextToken();
             date = new Date(memberDate);
             add();
             break;
           case "R":
             name = tokens.nextToken();
             memberDate = tokens.nextToken();
             date = new Date(memberDate);
             remove();
             break;
           case "P":
             print();
             break;
           case "Q":
             print();
             System.out.println("The team is ready to go!");
             System.exit(0);
           default:
             System.out.println("Command '" + s + "' not supported!");
         }
      }
      //write java code before you terminate the program
   } //run()

   /**
   * Adds TeamMembers to Team
   * First checks if Date is valid, then checks if
   * TeamMember with that Date and Name are already
   * present in the Team, if not they are added
   */
   private void add()
   {
      //must check if the date is valid
      if(!date.isValid())
      {
        System.out.println(date + " is not a valid date!");
      }
      else
      {
        member = new TeamMember(name, date);
        //must call the contains() method to check if a given
        //team member is in the team already
        if(cs213.contains(member))
        {
          System.out.println(name + " is already in the team.");
        }
        else
        {
          cs213.add(member);
          System.out.println(member.toString() + " has joined the team");
        }
      }
   }
   /**
   * Removes TeamMembers from Team
   * First checks if Date is valid, then checks if
   * TeamMember with that Date and Name are already
   * present in the Team, if they are they are removed
   */
   private void remove()
   {
      //if date invalid
      if(!date.isValid())
      {
        System.out.println(date + " is not a valid date!");
      }
      else
      {
        member = new TeamMember(name, date);
        //if member is not in array
        if(!cs213.contains(member))
        {
          System.out.println(member.toString() + " is not a team member.");
        }
        else
        {
          cs213.remove(member);
          System.out.println(member.toString() + "has left the team");
        }
      }
   }
   /**
   * Prints all TeamMembers present on the Team
   * If Team contains no TeamMembers print Team is empty
   * Otherwise prints all TeamMembers
   */
   private void print()
   {
     //must check if the team has 0 members.
     if(cs213.isEmpty())
     {
       System.out.println("We have 0 team members!");
     }
     else
     {
       cs213.print();
     }

   }
} //ProjectManager
