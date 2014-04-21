// Nader K
// 
// Date: 10/17/2013
// Filename: HealthyPerson.java


public class HealthyPerson extends Person
{
   private double weight;
   private double height;
   
   
   public HealthyPerson()
   {
   
   }
   
   public HealthyPerson (String n, double w, double h)
   {
   
       super(n);
       weight= w;
       height = h;
   
   }
   
   public void setWeight(double w)
   {
       weight = w;
   
   }

   public void setHeight(double h)
   {
   
      height = h;
   }
   
   public double getWeight()
   {
   
      return weight;
   
   }
   
   
   public double getHeight()
   {
   
      return height; 
      
   }
   
        
   public double calBMI()
   {
      
      return (getWeight() * 703) / Math.pow(getHeight(), 2);
    
   }
   
   public String toString()
   {
      return super.toString()+ " BMI is:  " + Math.round(calBMI());   
   }

}

