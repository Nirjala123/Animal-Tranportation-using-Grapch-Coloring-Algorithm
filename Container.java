/**
Name - Nirjala Parajuli
Due date: Friday, April 13, 2018, 11:55 PM
This class is used to find if a animal can be transported using the particular container 
*/
import java.util.*;
public class Container
{
   // arraylist to store all the species in the container
   private ArrayList<Species> allSpecies;
   /**
      Constructor to intialize the arraylist that stores all the species
   */
   public Container()
   {
      allSpecies = new ArrayList<Species>();
   }
   /**
      Method to check if a species can be placed in the container
      @param checkSpecies the species to be checked
      @return true if can be placed else return false
   */
   public boolean isPromising(Species checkSpecies)
   {
      // check if there is species in the container
      if(allSpecies.size() > 0)
      {
         String status = checkSpecies.getStatus();
         // return false if endangered
         if(status.equals("en"))
            {
               return false;
            }
         String classification = checkSpecies.getClassification();
         String order = checkSpecies.getOrder();
         for(int i = 0; i < allSpecies.size(); i++)
         {
            String inClassfication = allSpecies.get(i).getClassification();
            String inOrder = allSpecies.get(i).getOrder();
            String inStatus = allSpecies.get(i).getStatus();
            // return false if endangered
            if(inStatus.equals("en"))
            {
               return false;
            }
            // check if carnivore and herbivore and also check if domisticated or not
            if((classification.equals("carnivore") && inClassfication.equals("herbivore")) || (classification.equals("herbivore") && inClassfication.equals("carnivore")))
            {
               if(!(status.equals("do") && inStatus.equals("do")))
                  return false;         
            }
            // check if carnivore and vulnerable or near theretned
            if(((status.equals("nt") || status.equals("vu")) && inClassfication.equals("carnivore")) || ((inStatus.equals("nt") || inStatus.equals("vu")) && classification.equals("carnivore")))
               return false;
         }
         // return true if none of the animals are connected
         return true;
      }
      // if no species in the container then return true
      else
         return true;
   }
   /**
   Method to add the species to the container
   @param s the species to be added
   */
   public void addAnimal(Species s)
   {
      allSpecies.add(s);
   }
   /**
   Method to get the number of animals in the container
   @return return the number of species in the container
   */
   public int getNumberOfAnimals()
   {
      return allSpecies.size();
   }
   /**
   Method to give the names of the animals in a container
   @return the string with the names of the animals in a container
   */
   public String giveNamesOfAnimals()
   {
      String animals = "";
      for(int i = 0; i < allSpecies.size(); i++)
      {
         if((i+1) == allSpecies.size())
         {
            animals += allSpecies.get(i).getName();
         }
         else
         {
            animals += allSpecies.get(i).getName()+ ", ";
         }
      }
      return animals;
   }
}