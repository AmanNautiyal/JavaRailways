
package railways;
import java.io.*;
public class General
{
 BufferedReader Br=new BufferedReader(new InputStreamReader(System.in));
 Trains obj;
 void menu()
 {
  try
  {  
      Thread.sleep(2000);
   for(int p=0;p<50;p++)
     System.out.println();
   System.out.println("\n\n\t\t\t\tWelcome to the Ticket Counter");
   System.out.println("\n\n\t\t\t\tInput origin city-");
   String org=Br.readLine();
   System.out.println("\n\n\t\t\t\tInput destination city-");
   String dest=Br.readLine();
   obj=new Trains(org,dest);
   int x=obj.journey();
   if(!obj.check_or())
      System.out.println("\n\t\t\tSorry,train is not available "
              + "from this station");
   else if(!obj.check_dest())
      System.out.println("\n\t\t\tSorry,train is not available upto this "
              + "station"); 
   else if(x==1|| x==1000)
      System.out.println("\n\t\t\tSorry,train is not available between these "
              + "stations"); 
   else
     obj.general();
  }
  catch(NumberFormatException e)
  {
    System.out.println("\n\t\t\tWrong  input type");
  }
  catch(IOException e)
  {
   System.out.println("\n\t\t\tI/O error");
  }
  catch(Exception e)
  {
   System.out.println("\n\t\t\tAn error occured");
  }
 }
 
}
