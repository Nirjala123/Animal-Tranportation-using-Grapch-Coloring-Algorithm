/**
Name - Nirjala Parajuli
Due date: Friday, April 13, 2018, 11:55 PM
This class is used to store the details of a species 
*/
public class Species 
{
   // instance variables
   private String name;
   private String classification;
   private String order;
   private String conS;
   private double weight;
   /**
   Constructor to initialize the instance variables
   @param name name of the species
   @param classification classification of the species
   @param order order of the species
   @param conS status of the species
   @param weight weight of an average adult
   */
   public Species(String name, String classification, String order, String conS, double weight)
   {
      this.name = name;
      this.classification = classification;
      this.order = order;
      this.conS = conS;
      this.weight = weight;
   }
   /**
   Method to get the classificaton of a species
   @return return classification
   */
   public String getClassification()
   {
      return classification;
   }
   /**
   Method to get the order of a species
   @return return order
   */
   public String getOrder()
   {
      return order;
   }
   /**
   Method to ger the status of a species
   @return return status
   */
   public String getStatus()
   {
      return conS;
   }
   /**
   Method to get the name of a species
   @return return name
   */
   public String getName()
   {
      return name;
   }
}