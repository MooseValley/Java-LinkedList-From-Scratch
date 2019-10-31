class Node
{
   private String name;
   private Node   nextNode;
   private Node   priorNode;

   public Node () // Default
   {
      this("");
      //name      = "";
      //nextNode  = null;
      //priorNode = null;
   }

   public Node (String n)  // Parameterised
   {
      name = n;
      nextNode  = null;
      priorNode = null;
   }

   public String getName ()
   {
      return name;
   }

   public void setName (String n)
   {
      name = n;
   }

   public void setNextNode  (Node n)
   {
      nextNode = n;
   }

   public Node getNextNode()
   {
      return nextNode;
   }

   public void setPriorNode  (Node n)
   {
      priorNode = n;
   }

   public Node getPriorNode()
   {
      return priorNode;
   }
} // class Node


public class LinkedListFromScratch
{
   public static void main (String[] agrs)
   {
      Node node1 = new Node ("Moose");
      Node node2 = new Node ("Bella");
      Node node3 = new Node ("Frankie");
      Node node4 = new Node ("Samuel");
      Node node5 = new Node ("Hank");

      node1.setNextNode (node2);
      node2.setNextNode (node5);
      node3.setNextNode (node4);
      node5.setNextNode (node3);

      node2.setPriorNode (node1);
      node5.setPriorNode (node2);
      node4.setPriorNode (node3);
      node3.setPriorNode (node5);


      System.out.println ("Forwards traversal:");
      Node currNode = node1;
      while (currNode != null)
      {
         System.out.println (currNode.getName() );
         currNode = currNode.getNextNode();
      }

      System.out.println ("Backwards traversal:");
      currNode = node4;
      while (currNode != null)
      {
         System.out.println (currNode.getName() );
         currNode = currNode.getPriorNode();
      }
   }
}