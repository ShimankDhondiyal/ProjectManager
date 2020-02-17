/**
  Team is a container class that holds a group of TeamMember objects,
  and defines
  the property and method of a TeamMember entity.

  @author  Shimank Dhondiyal
  @author  Michael Cardoso
 */
public class Team
{
   private final int NOT_FOUND = -1;
   private final int GROW_SIZE = 4; //initial and grow size
   private TeamMember [] team; //array team comprised of TeamMember objects
   private int numMembers;

   public Team()
   {
      //this is the default constructor
   }

   /**
    * Search through array using linear search to find element m
    * without checking
    * for duplicates
    *
    * @param m TeamMember to be found
    */
   private int find(TeamMember m)
   {
	   if(this.team == null) {
		   return NOT_FOUND;
	   }
     //iterate through the array
     //keep track of index so that if found, index can be returned
     int index = 0;
     for(TeamMember element : team){
       if(m.equals(element)) {
         //element has been found
         return index;
       }//m.equals(team[index])
       index++;
     }
     //element has not been found
     return NOT_FOUND;
   }

   /**
    * if the array is filled, call this method to grow by GROW_SIZE
    */
   private void grow()
   {
     //create array with size = original + GROW_SIZE
     TeamMember [] newTeam = new TeamMember[team.length + GROW_SIZE];
     //need to copy data from old array to new one
     int index = 0;
     while(index < numMembers) {
       newTeam[index] = team[index];
       index++;
     }

     //reinitialize team array
     team = new TeamMember[newTeam.length];
     //copy original data back
     for(index = 0; index < team.length; index++) {
       team[index] = newTeam[index];
     }
   }

   /**
    * method to check whether the array has any TeamMembers within it
    */
   public boolean isEmpty()
   {
      if(numMembers == 0)
      {
        return true;
      }
      else
      {
        return false;
      }
   }

   /**
    * Appends an item to the end of the array, if array filled, create new array
    * with DOUBLE OR ADD 4?? the size, then add
    *
    * @param m item to be added to end of array
    */
   public void add(TeamMember m)
   {
     //check if array is empty
     if(isEmpty()) {
       team = new TeamMember[GROW_SIZE];
       int START_INDEX = 0;
       team[START_INDEX] = m;
       numMembers++;
       return;
     }

     //keep track of index
     //total number of members
     //numMembers = team.length;
     if(numMembers == team.length - 1)
     {
       grow();
     }
     if(team[numMembers] == null)
     {
       team[numMembers] = m;
       numMembers++;
     }
   }

   /**
   * Removes TeamMember from Team
   * Checks if the TeamMember exists, and finds its index
   * If the TeamMember doesn't exist, returns false otherwise
   * Once the index is found, it is replaced with the last element
   * and the former last element is nullified, and the
   * number of members is decremented
   @param m TeamMember to be removed
   */
   public boolean remove(TeamMember m)
   {

     if(find(m) == NOT_FOUND)
     {
       return false;
     }
     else
     {
       int removalIndex = find(m);
       team[removalIndex] = team[team.length - 1];
       team[numMembers - 1] = null;
       numMembers--;
       return true;

      }
   }
   /**
    * Checks to see if a TeamMember is contained on the Team
    * @param m item to be checked for
    */
   public boolean contains(TeamMember m)
   {
      if(find(m) != NOT_FOUND)
      {
        return true;
      }
      else
      {
        return false;
      }
   }

   /**
    * Print the team array
    */
   public void print()
   {
     //set up a for loop and call the toString() method
     System.out.println("We have the following team members: ");
     for(int TeamMemberCounter = 0; TeamMemberCounter < numMembers; TeamMemberCounter++)
     {
       System.out.println(team[TeamMemberCounter].toString());
     }
     System.out.println("-- end of the list --");
   }
}
