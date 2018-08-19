/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package railways;
import java.io.*;
/**
 *
 * @author dpn
 */
public class Info 
{
    BufferedReader Br= new BufferedReader(new InputStreamReader(System.in));
 void menu()
 {
  try
  {
      Thread.sleep(2000);
   for(int p=0;p<50;p++)
     System.out.println();
   System.out.println("\n\n\t\t\t\tChoose the train you want information on..");
   System.out.println("1.Uttaranchal Exprss\n2.Ujjaini Express"
      + "\n3.Mussoorie Express\n4.Exit\n\n\n\t\t\t\tInput your choice-");
   int ch=Integer.parseInt(Br.readLine());
   switch(ch)
   {
       case 1:
           Uttaranchal();break;
       case 2:
           Ujjaini();break;
       case 3:
           Mussoorie();break;
       case 4:
           return;   
   }
  }
  catch(NumberFormatException e)
  {
   System.out.println("\n\t\t\tWrong input type");
  }
  catch(Exception e)
  {
   System.out.println("\n\t\t\tAn error occured");
  }
  menu();
 }
 void Uttaranchal()
 {
   for(int p=0;p<50;p++)
     System.out.println();
  System.out.println("\n\t\t\tTravels from Dehradun to Okha\n\n\t\t\tThe train"
          + " travels through Gujarat, Rajasthan, Haryana, NCT, Uttara Pradesh"
          + " and Uttarakhand\n\n\t\t\tTravel Time: 35h 20m    31 halts   "
          + " Distance: 1671 km    Avg Speed: 47 km/hr\n\n\t\t\tTravels only "
          + "on Monday, Tuesday, Wednesday and Thursday\n\n\t\t\tList "
          + "of stations visited:\nDehradun,Haridwar,"
          + "Roorkee,Deoband,Muzaffarnagar,Meerut,Ghaziabad,New Delhi,"
          + "Delhi Sarai,Delhi Cantt.,Gurgaon,Rewari,Alwar,Jaipur,"
          + "Ajmer,Beawar,Abu Road,Palanpur,Siddhpur,Viramgam,Surendranagar"
          + ",Rajkot,Jamnagar,Dwarka,Okha");
    try
    {
      Thread.sleep(10000);
    }
    catch(InterruptedException e)
    {
     System.out.println("\n\t\t\tAn error occured");
    }
 }
 void Ujjaini()
 {
     for(int p=0;p<50;p++)
     System.out.println();
  System.out.println("Travels from Dehradun to Ujjain\n\n\t\t\tThe train "
+"travels through Madhya Pradesh, Rajasthan, Haryana, NCT, Uttara Pradesh and"
          + " Uttarakhand\n\n\t\t\tTravel Time: 27h 15m  27 halts    Distance: "
          + "1243 km  Avg Speed: 45 km/hr\n\n\t\t\tTravels only on Monday,"
          + "Tuesday,Thursday and Friday\n\n\t\t\tList of stations visited:"
          + "\n\n\t\t\tDehradun,Haridwar,Roorkee,Saharanpur,Deoband,"
          + "Muzaffarnagar,Meerut,Ghaziabad,Delhi,Faridabad,"
          + "Mathura,Agra,Morena,Gwalior,Jhansi,Ashok Nagar,Shajapur,Maksi,"
          + "Ujjain Junction");
  try
    {
      Thread.sleep(10000);
    }
    catch(InterruptedException e)
    {
     System.out.println("\n\t\t\tAn error occured");
    }
 }
 void Mussoorie()
 {
     for(int p=0;p<50;p++)
     System.out.println();
  System.out.println("Travels from Dehradun to Delhi NCT\n\n\t\t\tThe train"
          + " travels through  NCT, Uttara Pradesh and Uttarakhand"+
          "\n\n\t\t\tTravel Time: Travel Time: "
          + "10h 15m    16 halts    Distance: 335 km    Avg Speed: 32 km/hr"
          + "\n\n\t\t\tTravels only on Tuesday,Wednesday,Friday and Saturday"
          + "\n\n\t\t\tList of stations visited:Dehradun,Doiwala,Raiwala,"
          + "Haridwar,Jwalapur,Laksar,Najibabad,Bijnor,Chandpur,Gajraula,Hapur,"
          + "Ghaziabad,Old Delhi,Delhi Sarai");
  try
    {
      Thread.sleep(10000);
    }
    catch(InterruptedException e)
    {
     System.out.println("\n\t\t\tAn error occured");
    }
 }
}
