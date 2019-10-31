class Employee
{
   private String name;

   public Employee ()
   {
      name = "";
   }

   public String getName ()
   {
      return name;
   }

   public void setName (String n)
   {
      name = n;
   }
}

public class EmployeeTester
{
   public static void main(String[] args)
   {
      Employee emp1 = new Employee();
      emp1.setName("Moose");

      Employee emp2 = new Employee();
      emp2.setName("Bella");

      emp1 = emp2;
      emp1.setName ("Frankie");

      System.out.println (emp2.getName() );

   }
}