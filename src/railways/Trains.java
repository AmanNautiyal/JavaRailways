package railways;
import java.io.*;
import java.util.*;
public class Trains
{
 String org,dest;
 BufferedReader Br= new BufferedReader(new InputStreamReader(System.in));
 String[] Ujjaini={"Dehradun","Haridwar","Roorkee","Saharanpur","Deoband",
     "Muzaffarnagar","Meerut","Ghaziabad","Delhi","Faridabad","Mathura","Agra",
     "Morena","Gwalior","Jhansi","Ashok Nagar","Shajapur","Maksi",
     "Ujjain Junction"};
 String[] Mussoorie={"Dehradun","Doiwala","Raiwala","Haridwar","Jwalapur",
     "Laksar","Najibabad","Bijnor","Chandpur","Gajraula","Hapur","Ghaziabad"
         ,"Old Delhi","Delhi Sarai"};
 String[] Uttaranchal={"Dehradun","Haridwar","Roorkee","Deoband","Muzaffarnagar"
         ,"Meerut","Ghaziabad","New Delhi","Delhi Sarai","Delhi Cantt.",
         "Gurgaon","Rewari","Alwar","Jaipur","Ajmer","Beawar","Abu Road",
         "Palanpur","Siddhpur","Viramgam","Surendranagar","Rajkot","Jamnagar",
     "Dwarka","Okha"};
 //The seven indices signify whether train travels on that day of week
 int[] sc_Ujjaini={0,1,1,0,-1,-1,0};
 int[] sc_Uttaranchal={0,1,1,-1,-1,0,0};
 int[] sc_Mussoorie={0,0,1,1,0,-1,-1};
 double fare;
 /*Format of ardep is arrival time at 0 and 1 indices,departure time at 
  * 2 and 3 indices,day of journey at fourth index,distance from origin 
  * station(Dehradun) at 5th index and average speed at 6th index */
int ardep1_Ujjaini[][]={{25,61,5,50,1,0,36},{7,15,7,45,1,52,65},
    {8,25,8,30,1,93,35},{9,30,9,55,1,128,76},{10,22,10,24,1,162,85},
    {10,41,10,43,1,186,76},{11,27,11,30,1,242,57},{12,20,12,22,1,289,27},
    {13,15,13,45,1,313,62},{14,5,14,7,1,333,71},{15,48,15,53,1,447,75},
    {16,55,17,0,1,500,90},{18,0,18,2,1,580,61},{18,40,18,50,1,618,38},
    {21,25,21,35,1,716,40},{2,53,2,55,2,944,66},{7,13,7,15,2,1174,26},
    {8,20,8,22,2,1202,57},{9,5,25,61,2,1243,57}};
int ardep2_Ujjaini[][]={{9,5,25,61,2,1243,36},{8,20,8,22,2,1191,65},
    {7,13,7,15,2,1150,35},{2,53,2,55,2,1115,76},{21,25,21,35,1,1081,85},
    {18,40,18,50,1,1057,76},{18,0,18,2,1,1001,57},{16,55,17,0,1,954,27},
    {15,48,15,53,1,930,62},{14,5,14,7,1,910,71},{13,15,13,45,1,796,75},
    {12,20,12,22,1,743,90},{11,27,11,30,1,663,61},{10,41,10,43,1,625,38},
    {10,22,10,24,1,527,40},{9,30,9,55,1,299,66},{8,25,8,30,1,69,26},
    {7,15,7,45,1,41,57},{25,61,5,50,1,0,57}};
int ardep1_Uttaranchal[][]={{25,61,5,50,1,0,36},{7,15,7,45,1,52,62},
    {8,28,8,30,1,93,21},{10,22,10,24,1,153,85},{10,41,10,43,1,177,76},
    {11,27,11,30,1,233,57},{12,20,12,23,1,280,32},{13,10,13,30,1,305,16},
    {13,50,13,52,1,311,36},{14,8,14,10,1,320,69},{14,25,14,27,1,337,58},
    {15,20,15,22,1,389,84},{16,20,16,23,1,464,56},{19,5,19,20,1,614,62},
    {21,30,21,40,1,749,75},{22,22,22,24,1,801,74},{2,35,2,45,2,1056,33},
    {4,18,4,20,2,1107,63},{4,48,4,50,2,1136,51},{7,1,7,3,2,1238,45},
    {8,30,8,32,2,1304,47},{11,0,11,7,2,1420,64},{12,32,12,34,2,1504,59},
    {15,28,15,30,2,1642,38},{16,15,25,61,2,1671,38}};
int ardep2_Uttaranchal[][]={{16,15,25,61,2,1671,36},{15,28,15,30,2,1619,62},
    {12,32,12,34,2,1578,21},{11,0,11,7,2,1318,85},{8,30,8,32,2,1494,76},
    {7,1,7,3,2,1438,57},{4,48,4,50,2,1391,32},{4,18,4,20,2,1366,16},
    {2,35,2,45,2,311,36},{22,22,22,24,1,320,69},{21,30,21,40,1,337,58},
    {19,5,19,20,1,1282,84},{16,20,16,23,1,1207,56},{15,20,15,22,1,1057,62},
    {14,25,14,27,1,922,75},{14,8,14,10,1,870,74},{13,50,13,52,1,615,33},
    {13,10,13,30,1,1107,63},{12,20,12,23,1,1136,51},{11,27,11,30,1,1238,45},
    {10,41,10,43,1,367,47},{10,22,10,24,1,251,64},{8,28,8,30,1,167,59},
    {7,15,7,45,1,29,38},{25,61,5,50,1,0,38}};
int ardep1_Mussoorie[][]={{25,61,21,2,1,0,42},{21,53,21,55,1,20,40},
    {22,26,22,28,1,40,30},{22,50,23,15,1,52,48},{23,20,23,22,1,56,49},
    {23,50,23,53,1,78,72},{0,28,1,3,2,120,68},{1,48,1,50,2,157,41},
    {3,0,3,2,2,192,34},{4,20,4,45,2,228,65},{5,32,5,57,2,278,48},
    {6,57,6,59,2,315,43},{7,40,8,0,2,335,9},{8,30,21,65,2,339,9}};
int ardep2_Mussoorie[][]={{8,30,21,65,2,339,42},{7,40,8,0,2,319,40},
    {6,57,6,59,2,299,30},{5,32,5,57,2,287,48},{4,20,4,45,2,283,49},
    {3,0,3,2,2,261,72},{1,48,1,50,2,215,68},{0,28,1,3,2,182,41},
    {23,50,23,53,1,147,34},{23,20,23,22,1,111,65},{22,50,23,15,1,61,48},
    {22,26,22,28,1,24,43},{21,53,21,55,1,4,9},{25,61,21,2,1,0,9}};
 Trains(String or,String de)
 {
  org=or;
  dest=de;
 }
 boolean check_or()
 {
  for(int i=0;i<Ujjaini.length;i++) 
     if(org.equalsIgnoreCase(Ujjaini[i]))
         return true;
  for(int i=0;i<Uttaranchal.length;i++) 
     if(org.equalsIgnoreCase(Uttaranchal[i]))
         return true;
  for(int i=0;i<Mussoorie.length;i++) 
     if(org.equalsIgnoreCase(Mussoorie[i]))
         return true;
  return false;
 }
 boolean check_dest()
 {
  for(int i=0;i<Ujjaini.length;i++) 
     if(dest.equalsIgnoreCase(Ujjaini[i]))
         return true;
  for(int i=0;i<Uttaranchal.length;i++) 
     if(dest.equalsIgnoreCase(Uttaranchal[i]))
         return true;
  for(int i=0;i<Mussoorie.length;i++) 
     if(dest.equalsIgnoreCase(Mussoorie[i]))
         return true;
  return false;
 }
 int journey()
 {
     int x=1;
  if(org.equalsIgnoreCase(dest))
    return 1;
  int o=-1,d=-1;
  for(int i=0;i<Ujjaini.length;i++)
  {
   if(org.equalsIgnoreCase(Ujjaini[i]))
     o=i;
   if(dest.equalsIgnoreCase(Ujjaini[i]))
     d=i;
  }
  x*=10;
  if(o!=-1 && d!=-1)
    x++;
  d=o=-1;
  for(int i=0;i<Uttaranchal.length;i++)
  {
   if(org.equalsIgnoreCase(Uttaranchal[i]))
     o=i;
   if(dest.equalsIgnoreCase(Uttaranchal[i]))
     d=i;
  }
  x*=10;
  if(o!=-1 && d!=-1)
      x++;
  d=o=-1;
  for(int i=0;i<Mussoorie.length;i++)
  {
   if(org.equalsIgnoreCase(Mussoorie[i]))
     o=i;
   if(dest.equalsIgnoreCase(Mussoorie[i]))
     d=i;
  }
  x*=10;
  if(o!=-1 && d!=-1)
    x++;
  return x;
 }
 void general()
 {
  try
  {
      Thread.sleep(2000);
   for(int x=0;x<50;x++)
     System.out.println();
   int x=journey();
   int trains[]=new int[3];
   for(int i=0;i<3;i++,x/=10)
       trains[i]=x%10;
   System.out.println("\n\n\t\t\t\tWhich train would you like to travel by..?");
   System.out.print("\n\n\t\t\t\t1.Mussoorie Express..\t\t");
   if(trains[0]==1)
       System.out.println("Available");
   else
       System.out.println("Not Available");
   System.out.print("\n\n\t\t\t\t2.Uttaranchal Express..\t\t");
   if(trains[1]==1)
       System.out.println("Available");
   else
       System.out.println("Not Available");
   System.out.print("\n\n\t\t\t\t3.Ujjaini Express..\t\t");
   if(trains[2]==1)
       System.out.println("Available");
   else
       System.out.println("Not Available");
   System.out.println("\n\n\t\t\t\t4.Back");
   System.out.print("\n\n\t\t\t\tInput choice-");
   int a=Integer.parseInt(Br.readLine());
   if(a==4)
      return;
   else if(a>4 ||a<1 ||trains[a-1]==0)
     System.out.println("\n\t\t\tWrong choice");
   else
    tickets(a); 
  }
  catch(NumberFormatException e)
  {
   System.out.println("\n\t\t\tWrong input");
  }
  catch(IOException e)
  {
   System.out.println("\n\t\t\tI/o error");
  }
  catch(Exception e)
  {
   System.out.println("\n\t\t\tAn unexpected error occured here");
  }
  general();
 }
 void tickets(int x)
 {
  try
  {
      Thread.sleep(2000);
   for(int p=0;p<50;p++)
     System.out.println();
   System.out.print("\n\n\t\t\t\tInput the date you want to board the train on-");
   System.out.print("\n\n\t\tmonth(1-12)-");
   int mon=Integer.parseInt(Br.readLine());
   while(!(mon<=12 && mon>=0))
   {
       System.out.print("\n\n\t\t\tInvalid...\nReinput-");
       mon=Integer.parseInt(Br.readLine());
   }
   System.out.print("\n\t\tDate-");
   int date=Integer.parseInt(Br.readLine());
   while(true)
   {
    boolean d=false;
    if(mon==1||mon==3||mon==5||mon==7||mon==8||mon==10||mon==12)
      d=true;
    if(date<1 ||date>31||(!d && date>30))
    {
      System.out.print("\n\n\t\t\tInvalid...\n\n\t\tReinput-");
      date=Integer.parseInt(Br.readLine());
    }
    else
     break;
   }
   System.out.print("\n\t\tyear(1990-2100)-");
   int year=Integer.parseInt(Br.readLine());
   while(!(year>=1990 && year<=2100))
   {
       System.out.print("\n\t\t\tInvalid...\n\n\t\tReinput-");
       year=Integer.parseInt(Br.readLine());
   }
   Calendar ca=Calendar.getInstance();
   Calendar calendar2 = 
           Calendar.getInstance();
   calendar2.set(year,mon-1,date);
   //In Calendar class, january is assigned 0 and so on.
   long millis=calendar2.getTimeInMillis()-ca.getTimeInMillis();
   millis/=1000;millis/=3600; millis/=24;
   if(millis<0)
    System.out.println("\n\t\t\tDate has already passed");
   else if((millis/=30)>2)
    System.out.println("\n\t\t\tTicket can only be issued before two months "
            + "atmost\n\n\t\t\tTime gap is "+ millis+" months");
   else
   {
    int ard=findno(x);
    if(!schedule(ard,calendar2,x))
    {
      System.out.println("\n\t\t\tTrain not available at this date..");
      Thread.sleep(3000);
      return;
    }
   for(int p=0;p<50;p++)
     System.out.println();
    System.out.println("\n\n\t\t\t\tIssue tickets?"
            + "(Input 0 for Yes or any other no. for No-");
    int a =Integer.parseInt(Br.readLine());
    if(a==0)
        issue(ca,calendar2,false,x);
   }
  }
  catch(NumberFormatException e)
  {
   System.out.println("\n\t\t\tWrong input type...");
  }
  catch(IOException e)
  {
   System.out.println("\n\t\t\tI/O Exception...");
  }
  catch(Exception e)
  {
   System.out.println("\n\t\t\tAn unexpected error occured..");
  }
 }
 int no_of_seats(int x,Calendar c)
 {
  int d,y,m;
  d=y=m=0;
  String n=null;
   try
   {
    d=c.get(c.DAY_OF_MONTH);
    m=c.get(c.MONTH);
    y=c.get(c.YEAR);
    switch(x)
    {
        case 1:
            n="Mussoorie";break;
        case 2:
            n="Uttaranchal";break;
        case 3:
            n="Ujjaini";break;
    }
    FileInputStream Fi= new FileInputStream(d+"_"+m+"_"+y+"_"+n+".bin");
    DataInputStream Di=new DataInputStream(Fi);
    int no=Di.readInt();
    int tot=Di.readInt();
    Di.close();
    Fi.close();
    return(tot-no);
   }
   catch(FileNotFoundException e)
   {
    try
    {
     FileOutputStream Fo = new FileOutputStream(y+"_"+m+"_"+d+"_"+n+".bin"); 
     DataOutputStream Do=new DataOutputStream(Fo);
     Do.writeInt(0);
     switch(x)
     {
         case 1:
           Do.writeInt(600);break;
         case 2:
           Do.writeInt(500);break;
         case 3:
           Do.writeInt(400);break;
     }
     Do.close();
     Fo.close();
    }
    catch(Exception ex)
    {
     System.out.println("\n\t\t\tan error occured");
    }
   }
   catch(IOException e)
   {
    System.out.println("\n\t\t\tI/O error");
   }      
    return 0;
 }
 int findno(int x)
 {
  try
  {
   int o=-1,d=-1;
   String[] ordest=null;
   switch(x)
   {
       case 1:
        ordest=Mussoorie;break;
       case 2:
        ordest=Uttaranchal;break;
       case 3:
        ordest=Ujjaini;break;     
   }
   int i=0;
   while(o==-1 || d==-1)
   {
    if(org.equalsIgnoreCase(ordest[i]))
      o=i; 
    if(dest.equalsIgnoreCase(ordest[i]))
      d=i;  
    i++;
   }
   return (o-d);
  }
  catch(Exception e)
  {
   System.out.println("\n\t\t\tAn unexpected error occured");
  }
  return 0;
 }
 boolean schedule(int ar,Calendar cal,int x)
 {
  try
  {
      Thread.sleep(2000);
   for(int p=0;p<50;p++)
     System.out.println();
   String[] ordest=null;
   int [][] ardep=null;
   int[] sch=null;
   int day=cal.get(cal.DAY_OF_WEEK);
   switch(x)
   {
       case 1:
        ordest=Mussoorie;
        sch=sc_Mussoorie;
          if(ar<0)
            ardep=ardep1_Mussoorie;
          else
            ardep=ardep2_Mussoorie;
        break;
       case 2:
        ordest=Uttaranchal;
        sch=sc_Uttaranchal;
         if(ar<0) 
          ardep=ardep1_Uttaranchal;
         else 
          ardep=ardep2_Uttaranchal;
        break;    
       case 3:
           ordest=Ujjaini;
        sch=sc_Ujjaini;
         if(ar<0) 
            ardep=ardep1_Ujjaini;
         else  
            ardep=ardep2_Ujjaini;
        break; 
   }
   int o=-1,d=-1;
   for(int i=0;i<ordest.length;i++)
   {
     if(org.equalsIgnoreCase(ordest[i]))
      o=i;
     else if(dest.equalsIgnoreCase(ordest[i]))
      d=i;
      
   }
   int day2=day+1;
   if(day2==8)
       day2=1;
   if((ar<0 && sch[day-1]!=-1)||(ar>0 && sch[day-1]!=1)||
  ((sch[day2-1]!=-1)&&(ar<0)&&(ardep[o][4]==2))||
   ((sch[day2-1]!=1)&&(ar>0)&&(ardep[o][4]==2)))
     return false;
   System.out.println("\n\t\t\tTime of train's departure from "+org+" is "
           +ardep[o][2]+"."+ardep[o][3]);
   System.out.print("\n\t\t\tTrain arrives at "+dest+ " at "+ardep[d][0]+"."
           +ardep[d][1]+" on ");
   day2=cal.get(cal.DATE);
   if(ardep[d][4]==2 && ardep[o][4]==1)
   {
    Calendar temp=cal;
    temp.add(cal.DATE, 1);
    day2=temp.get(temp.DATE);
   }
   System.out.println(day2);
   double spd,dist;
   spd=dist=0.0d;
   int s,e;
   s=o;e=d;
   while(s!=e)
   {
    spd+=ardep[s][6];
    if(ar<0)
        s++;
    else
        s--;
   }
   spd/=(Math.abs(ar));
   if(ar<0)
     dist=ardep[d][5]-ardep[o][5];
   else
     dist=ardep[o][5]-ardep[d][5];
   fare=spd*dist*.02+75; 
   fare=Math.ceil(fare);
   System.out.println("\n\t\t\tTotal fare is: Rs."+fare+" per person");
   System.out.println("\n\t\t\tFare for disabled: Rs."+(fare-(fare*.25))+
           " per disabled person");
   Thread.sleep(10000);
   return true;
  }
  catch(Exception e)
  {
   System.out.println("\n\t\t\tAn error occured ");
  }
  return false;
 }
 void issue(Calendar d,Calendar b,boolean x,int t)
 {
  try
  {
      Thread.sleep(2000);
   for(int p=0;p<50;p++)
     System.out.println();
   String train=null;
   switch(t)
   {
       case 1:
         train="Mussoorie";break;
       case 2:
         train="Uttaranchal";break;
       case 3:
         train="Ujjaini";break;
   }
   int d1,m1,y1;
   int d2,y2,m2;
   d1=d.get(d.DATE);
   m1=d.get(d.MONTH);
   y1=d.get(d.YEAR);
   d2=b.get(b.DATE);
   m2=b.get(b.MONTH);
   y2=b.get(b.YEAR);
   System.out.print("\n\n\t\t\t\tInput no. of people travelling-");
   int n=Integer.parseInt(Br.readLine());
   int se;
   if((se=no_of_seats(t,b))>n)
   {
    System.out.println("\n\t\t\tOnly "+se+" seats available");
    Thread.sleep(3000);
    return;
   }
   String[] str=new String[n];
   System.out.println("\n\n\t\t\t\tInput names-");
   for(int i=0;i<n;i++)
       str[i]=Br.readLine();
   System.out.print("\n\n\t\t\t\tInput the no. of disabled people among you-");
   int dis=Integer.parseInt(Br.readLine());
   if(dis>n || dis<0)
   {
    System.out.println("\n\t\t\tWrong input..Re-enter:");
    dis=Integer.parseInt(Br.readLine());
   }
   String s="gen";
   if(x)
    s="res";
   FileWriter Fw= new FileWriter(s+"_"+train+"_"+y2+"-"+m2+"-"+d2+".txt");
   BufferedWriter Bw= new BufferedWriter(Fw);
   PrintWriter Pw=new PrintWriter(Bw);
   Pw.println("\n\t\t\tDate of issue:"+d1+"-"+m1+"-"+y1);
   Pw.println("\n\t\t\tNames of passengers-");
   for(int i=0;i<n;i++)
      Pw.print(str[i]+",");
   Pw.println();
   Pw.println("\n\t\t\tNo. of disabled-"+dis);
   Pw.println("\n\t\t\tJourney from "+org+" to "+dest);
   double totfare=fare*(n-dis)+dis*(fare-fare*.25);
   System.out.println("\n\t\t\tTotal fare-"+totfare);
   Pw.println("\n\t\t\tTotal fare-"+totfare);
   Pw.close();
   Bw.close();
   Fw.close();
   if(x)
   {
    FileInputStream Fi= new FileInputStream(y1+"_"+m1+"_"+d1+"_"+train+".bin");
    DataInputStream Di=new DataInputStream(Fi); 
    int no=Di.readInt();
    int tot=Di.readInt();
    Di.close();
    Fi.close();
    FileOutputStream Fo= new FileOutputStream(y2+"_"+m2+"_"+d2+"_"+train+".bin");
    DataOutputStream Do=new DataOutputStream(Fo);
    no+=n;
    Do.writeInt(no);
    Do.writeInt(tot);
    Do.close();
    Fo.close();
    Thread.sleep(10000);
   }
  }
  catch(NumberFormatException e)
  {
   System.out.println("\n\t\t\tWrong input");
  }
  catch(IOException e)
  {
   System.out.println("\n\t\t\tI/o error");
  }
  catch(Exception e)
  {
   System.out.println("\n\t\t\tAn error occured");
  }
 }
 void reservation()
 {
  try
  {
      Thread.sleep(2000);
   for(int p=0;p<50;p++)
     System.out.println();
   int x=journey();
   int trains[]=new int[3];
   for(int i=0;i<3;i++,x/=10)
       trains[i]=x%10;
   System.out.println("\n\n\t\t\t\tWhich train would you like to travel by..?");
   System.out.print("\n\n\t\t\t\t1.Mussoorie Express..\t\t");
   if(trains[0]==1)
       System.out.println("Available");
   else
       System.out.println("Not Available");
   System.out.print("\n\n\t\t\t\t2.Uttaranchal Express..\t\t");
   if(trains[1]==1)
       System.out.println("Available");
   else
       System.out.println("Not Available");
   System.out.print("\n\n\t\t\t\t3.Ujjaini Express..\t\t");
   if(trains[2]==1)
       System.out.println("Available");
   else
       System.out.println("Not Available");
   System.out.println("\n\n\t\t\t\t4.Back");
   System.out.print("\n\n\t\t\t\tInput choice-");
   int a=Integer.parseInt(Br.readLine());
   if(a==4)
     return;
   else if(a>4 ||a<1 ||trains[a-1]==0)
     System.out.println("\n\t\t\tWrong choice");
   else
    reserve(a); 
  }
  catch(NumberFormatException e)
  {
   System.out.println("\n\t\t\tWrong input");
  }
  catch(IOException e)
  {
   System.out.println("\n\t\t\tI/o error");
  }
  catch(Exception e)
  {
   System.out.println("\n\t\t\tAn unexpected error occured");
  }
  reservation();
 }
 void reserve(int x)
 {
  try
  {
      Thread.sleep(2000);
   for(int p=0;p<50;p++)
     System.out.println();
   System.out.print("\n\n\t\t\t\tInput the date you want to board the train on-");
   System.out.print("\n\n\t\tmonth(1-12)-");
   int mon=Integer.parseInt(Br.readLine());
   while(!(mon<=12 && mon>=0))
   {
       System.out.print("\n\n\t\t\tInvalid...\nReinput-");
       mon=Integer.parseInt(Br.readLine());
   }
   System.out.print("\n\t\tDate-");
   int date=Integer.parseInt(Br.readLine());
   while(true)
   {
    boolean d=false;
    if(mon==1||mon==3||mon==5||mon==7||mon==8||mon==10||mon==12)
      d=true;
    if(date<1 ||date>31||(!d && date>30))
    {
      System.out.print("\n\n\t\t\tInvalid...\n\n\t\tReinput-");
      date=Integer.parseInt(Br.readLine());
    }
    else
     break;
   }
   System.out.print("\n\t\tyear(1990-2100)-");
   int year=Integer.parseInt(Br.readLine());
   while(!(year>=1990 && year<=2100))
   {
       System.out.print("\n\t\t\tInvalid...\n\n\t\tReinput-");
       year=Integer.parseInt(Br.readLine());
   }
   Calendar ca=Calendar.getInstance();
   Calendar calendar2 = Calendar.getInstance();
   calendar2.set(year,mon-1,date);
   long millis=calendar2.getTimeInMillis()-ca.getTimeInMillis();
   millis/=100;millis/=3600; millis/=24;
   if(millis<0)
   {
    System.out.println("\n\t\t\tDate has already passed");
    Thread.sleep(3000);
    return;
   }
   millis/=31;
   if(millis>2)
   {
    System.out.println("\n\t\t\tTicket can only be issued before two months"
            + " atmost\n\n\t\t\tTime gap is "+ millis+" months");
    return;
   }
   int ard=findno(x);
   if(!schedule(ard,calendar2,x))
   {
     System.out.println("\n\t\t\tTrain not available at this date..");
     return;
   }
   if(no_of_seats(x,calendar2)==0)
   {
    System.out.println("\n\t\t\tNo more seats available");
    return;
   }
   for(int p=0;p<50;p++)
     System.out.println();
   System.out.println("\n\n\t\t\t\tIssue tickets?"
           + "(Input 0 for Yes or any other no. for No-");
   int a =Integer.parseInt(Br.readLine());
   if(a==0)
       issue(ca,calendar2,true,x);
  }
  catch(NumberFormatException e)
  {
   System.out.println("\n\t\t\tWrong input type...");
  }
  catch(IOException e)
  {
   System.out.println("\n\t\t\tI/O Exception...");
  }
  catch(Exception e)
  {
   System.out.println("\n\t\t\tAn unexpected error occured..");
  }
 }
}

