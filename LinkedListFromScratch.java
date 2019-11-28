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


class LinkedList
{
   private Node firstNode;
   private Node lastNode;
   private int  count;

   public LinkedList ()
   {
      firstNode = null;
      lastNode  = null;
      count     = 0;
   }

   public void addNode (String name)
   {
      if (firstNode == null)
      {
         Node node = new Node (name);
         firstNode = node;
         lastNode  = node;
         count++;
      }
      else
      {
         Node node = new Node (name);

         Node currLastNode = lastNode;
         lastNode          = node;
         currLastNode.setNextNode (node);
         node.setPriorNode        (currLastNode);
         count++;
      }
   }

   public void addNode (int index, String name)
   {
      if (index == 0)
      {
         if (firstNode == null)
         {
            addNode (name);
         }
         else
         {
            Node node = new Node (name);

            Node currFirstNode = firstNode;
            firstNode          = node;
            node.setNextNode          (currFirstNode);
            currFirstNode.setPriorNode (node);
            count++;
         }
      }
      else if (index < count)
      {
         Node node = new Node (name);

         Node currNode = firstNode;
         int nodeCount = 1;
         while (nodeCount < index)
         {
            currNode = currNode.getNextNode();
            nodeCount++;
         }

         Node currNextNode       = currNode.getNextNode();
         node.setNextNode          (currNextNode);
         currNextNode.setPriorNode (node);

         currNode.setNextNode      (node);
         node.setPriorNode         (currNode);
         count++;
      }
      else
      {
         System.out.println ("Error: cannot add a node outside of the list.");
      }
   }

   public void forwardTraversal ()
   {
      System.out.println ("Forwards traversal: " + count + " nodes ...");
      Node currNode = firstNode;
      while (currNode != null)
      {
         System.out.println (currNode.getName() );
         currNode = currNode.getNextNode();
      }
   }

   public void backwardTraversal ()
   {
      System.out.println ("Backwards traversal: " + count + " nodes ...");
      Node currNode = lastNode;
      while (currNode != null)
      {
         System.out.println (currNode.getName() );
         currNode = currNode.getPriorNode();
      }
   }

   public int getCount()
   {
      return count;
   }

   public void removeNode (int index)
   {
      if (count == 0)
      {
         System.out.println ("Error: linked list is empty - cannot remove a node !");
      }
      else if ((index < 0) || (index >= count))
      {
         System.out.println ("Error: cannot remove a node outside of linked list !");
      }
      else
      {
         Node currNode = firstNode;
         int nodeCount = 0;
         while (nodeCount < index)
         {
            currNode = currNode.getNextNode();
            nodeCount++;
         }
         System.out.println ("Deleting node: " + currNode.getName() );

         //
         Node currPriorNode       = currNode.getPriorNode();
         Node currNextNode        = currNode.getNextNode();

         if (currPriorNode != null)
            currPriorNode.setNextNode (currNextNode);

         if (currNextNode != null)
            currNextNode.setPriorNode (currPriorNode);

         if (firstNode == currNode)
            firstNode = currNextNode;

         if (lastNode == currNode)
            lastNode = currPriorNode;

         count--;
      }
   }
}

public class LinkedListFromScratch
{
   public static void main (String[] agrs)
   {
      LinkedList linkedList = new LinkedList ();
      linkedList.addNode ("Moose");
      linkedList.addNode ("Bella");
      linkedList.addNode ("Hank");

      //linkedList.addNode (2, "Frankie");


      linkedList.removeNode (1);

      linkedList.forwardTraversal ();
      linkedList.backwardTraversal ();


      /*
      Node mooseNode   = new Node ("Moose");
      Node bellaNode   = new Node ("Bella");
      Node hankNode    = new Node ("Hank");
      Node frankieNode = new Node ("Frankie");
      Node samuelNode  = new Node ("Samuel");

      mooseNode.setNextNode    (bellaNode);
      bellaNode.setPriorNode   (mooseNode);

      bellaNode.setNextNode    (hankNode);
      hankNode.setPriorNode    (bellaNode);

      hankNode.setNextNode     (frankieNode);
      frankieNode.setPriorNode (hankNode);

      frankieNode.setNextNode  (samuelNode);
      samuelNode.setPriorNode  (frankieNode);


      System.out.println ("Forwards traversal:");
      Node currNode = mooseNode;
      while (currNode != null)
      {
         System.out.println (currNode.getName() );
         currNode = currNode.getNextNode();
      }

      System.out.println ("Backwards traversal:");
      currNode = samuelNode;
      while (currNode != null)
      {
         System.out.println (currNode.getName() );
         currNode = currNode.getPriorNode();
      }
      */
   }
}