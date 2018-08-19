package railways;
import java.io.*;
class Railways
{
 BufferedReader Br= new BufferedReader(new InputStreamReader(System.in));
 void menu()
 {
  try
  {
      Thread.sleep(2000);
   for(int p=0;p<50;p++)
     System.out.println();
   System.out.println("\n\n\t\t\t\tWelcome to the Railways department..");
   System.out.println("\n\t\t\t\t1.Reservations Counter\n\n\t\t\t\t2.Tickets"
           + " Counter\n\n\t\t\t\t3.Trains info\n\n\t\t\t\t4.Help"
           + "\n\n\t\t\t\t5.Exit\n\n\n\t\t\t\tInput your choice-");
   int ch=Integer.parseInt(Br.readLine());
   switch(ch)
   {
       case 1:
           Reservations obj1=new Reservations();
           obj1.reserve();break;
       case 2:
           General obj2=new General();
           obj2.menu();break;
       case 3:
           Info obj3=new Info();
           obj3.menu();break;
       case 4:
           help();break;
       case 5:
           System.out.println("\n\t\t\tGoodbye.. Have a safe Journey..");
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
 void help()
 {
   for(int p=0;p<50;p++)
     System.out.println();
  System.out.println("\n\n\t\t\t\tHELP INFO\n1.The "
          + "reservations counter can be visited to"
          + " reserve the seats beforehand.\n\n\t\t\tThere is a limited no. of"
          + " reserved seats.\n\n\t\t\t2.The tickets counter can be used to "
          + "take general tickets.\n\n\t\t\t3.Info contains facts about"
          + " the three trains.i.e Ujjaini Express, Uttaranchal Express and the"
          + " Mussoorie Express.\n4.The tickets cannot be issued and the "
          + "reservations cannot be done before 2 months.\n\n\t\t\t5.The "
          + "reports of bookings and travels can be availed from root "
          + "directory.\n\n\t\t\tThe files are of names of type "
          + "s_train_y-m-d.txt\n\n\t\t\t where:\n\n\t\t\t.s is'gen' or 'res', "
          + "signifying general and reservation report resp.\n\n\t\t\t.train"
          + " is the train name.\n\n\t\t\t.y-m-d signify date of boarding"
          + " in yyyy-mm-dd format..\n\n\n Happy To Help You..");
  try
    {
      Thread.sleep(10000);
    }
    catch(InterruptedException e)
    {
     System.out.println("\n\t\t\tAn error occured");
    }
 }
 public static void main(String args[])
 {
  try
  {
   Railways obj=new Railways();
   obj.menu();
  }
  catch(Exception e)
  {
   System.out.println("\n\t\t\tAn error occured");
  }
 }
}
