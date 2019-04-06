/**
Name - Nirjala Parajuli
Due date: Friday, April 13, 2018, 11:55 PM
This class calculates the minimum number of containers required to transport a set of animals and the 
containers with it's respecitive animals
*/
import java.util.*;
import java.io.*;
public class AnimalTransport
{
   // instances variables
   // Map to store the name and species
   private Map<String, Species> speciesMap;
   // Arraylist to store all the containers
   private ArrayList<Container> containers;
   /**
   Constructor to fill the map with the name and species 
   @param filename the file that has the details of all the species
   */
   public AnimalTransport(String filename)
   {
      // try
      try{
         File file = new File(filename);
         speciesMap = new HashMap<String, Species>();
         containers = new ArrayList<Container>();
         Scanner scan = new Scanner(file);
         while(scan.hasNextLine())
         {
            Scanner s = new Scanner(scan.nextLine()).useDelimiter("\\s*,\\s*");
            if(s.hasNext())
            {
               String name = s.next();
               String classification = s.next();
               String order = s.next();
               String conS = s.next();
               double weight = s.nextDouble();
               Species sp = new Species(name, classification, order, conS, weight);
               // storing in the map
               speciesMap.put(name, sp);
            }
         }
         scan.close();
      }
      // catch to handle file not found exception
      catch(FileNotFoundException e)
      {
         e.printStackTrace();
      }
  }
  /**
  Method to return the minimum number of containers required to transport given animals
  @param animals animals to be transported
  @return returns the minimum number of containers
  */
  public int minContainers(String animals)
  {
      containers.clear();
      Scanner scan = new Scanner(animals);
      scan.useDelimiter(",");
      Container firstCage = new Container();
      containers.add(firstCage); 
      while(scan.hasNext())
      {
         // name of the species
         String speciesName = scan.next();
         int i = 0;
         // going over all the containers to check if the species fits into one
         for(i = 0; i < containers.size(); i++)
         {
            // container
            Container cage = containers.get(i);
            // checking if the container is promising,i.e. the species can bet kept in a particula cage      
            if(cage.isPromising(speciesMap.get(speciesName)))
            {
               cage.addAnimal(speciesMap.get(speciesName));
               break;
            }
         }
         // checking if all the containers are checked
         if((i+1) > containers.size())
         {
            // if all containers are check, then add new container
            Container cage = new Container();
            cage.addAnimal(speciesMap.get(speciesName));
            containers.add(cage);
         }
      }
      // return the number of containers
      return containers.size();
  }
  /**
  Method to get the containers and it's respective animals
  @param animals the animals to be transported
  @return return the string with the containers and it's respective animals
  */
  public String getListing(String animals)
  {
      int minContainers = minContainers(animals);
      String all = "";
      for(int i = 0; i < minContainers; i++)
      {
         all += "\nContainer "+(i+1)+":\n";
         // get the names of all the animals for a container
         all += containers.get(i).giveNamesOfAnimals() + " ";
      }
      return all; 
  }
}