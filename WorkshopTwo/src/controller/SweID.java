package controller;

//import java.util.Scanner;

public class SweID {
	
	public SweID(){
		
	}
	
	
	
	public String getFirstPart(String str){        //Method getFirstPart
		
		String getFirstPart="";
		
		for(int i=0;i<6;i++)
		{
			
			getFirstPart+=str.charAt(i);
			
		}
		
		
		return getFirstPart;
		
	}
	
    public String getSecondPart(String str){       //Method getSecondPart
		
		String getSecondPart="";
		
		for(int i=7;i<11;i++)
		{
			
			getSecondPart+=str.charAt(i);
			
		}
		
		
		return getSecondPart;
		
	}
	
    public boolean isFemaleNumber(String str){      //Method isFemaleNumber
		
    	String number=str.substring(9, 10);
    	int number2=Integer.parseInt(number);
    	
    	for(int i=0;i<10;i=i+2)
    	{
    		if(number2==i)
    		{
    			return true;
    		}
    		
    		
    	}
    	
    	
    	
    	return false;
    	
    }
	
    public boolean isMaleNumber(String str){        //Method isMaleNumber
		
    	String number=str.substring(9, 10);
    	int number2=Integer.parseInt(number);
    	
    	for(int i=1;i<10;i=i+2)
    	{
    		if(number2==i)
    		{
    			return true;
    		}
    		
    		
    	}
    	
    	
    	
    	return false;
    	
    }
    public boolean areEqual(String one,String two){     //Method areEqual
    	
    	if(one.equals(two))
    	{
    		return true;
    	}
    	
    	
    	return false;
    	
    }
    
    public boolean isCorrect(String str){        //Method isCorrect
    	
    	int[] number=new int[11];                 //start a new array, easier to take number from array than String 
    	
    	for(int i=0;i<11;i++)           
    	{
    		number[i]=str.charAt(i);
    		
    	}
    	
    	
    	
    	int counter=0;
    	
    	for(int i=0;i<6;i++)                //start calculate the right last digit of the number
    	{
    		if(i%2==0)
    		{
    			int tmp=number[i]*2;
    			
    			if(tmp>9)
    			{
    				counter+=tmp/10+tmp%10;
    				
    			}
    			else
    			{
    				counter+=tmp;
    				
    			}
    			
    			
    		}
    		else
    		{
    			int tmp=number[i];
    			counter+=tmp;
    			
    		}
    		
    		
    		
    		
    	}
    	
    	for(int i=7;i<10;i++)
    	{

    		if(i%2!=0)
    		{
    			int tmp=number[i]*2;
    			
    			if(tmp>9)
    			{
    				counter+=tmp/10+tmp%10;
    				
    			}
    			else
    			{
    				counter+=tmp;
    				
    			}
    			
    			
    		}
    		else
    		{
    			int tmp=number[i];
    			counter+=tmp;
    			
    		}
    		
    		
    		
    		
    	}
    	
    	counter=10-counter%10;
    		
    	
    	if(counter>9)
    	{
    		counter=counter%10;
    	}
    	
    	
    	
    	String lastnumber=str.substring(10, 11);
    	int lastnumber2=Integer.parseInt(lastnumber);
    	
    	if(counter!=lastnumber2)                 //compare the right last digit with the original last digit of number
    	{
    		return false;
    		
    	}
    	
    	
    	
    	
    	int year=Integer.parseInt(str.substring(0, 2));
    	int month=Integer.parseInt(str.substring(2, 4));
    	int day=Integer.parseInt(str.substring(4, 6));
    	
    	if(year>9)
    	{
    		year+=1900;
    	}
    	else
    	{
    		year+=2000;
    	}
    	
    	
    	
    	if(month<1 || month>12)       //month must be from 1 to 12
    	 {
    		 return false;
    		 
    	 }
    	 
    	int[] monthLengths=new int[]{0,31,-1,31,30,31,30,31,31,30,31,30,31};
    	
    	if(isLeapYear(year))
    	{
    		monthLengths[2]=29;
    		
    		
    	}
    	else
    	{
    		monthLengths[2]=28;
    		
    	}
    	int monthLength=monthLengths[month];
    	
    	if(day<1 || day>monthLength)
    	{
    		return false;
    	}
    	
    	 
    	
    	
    	return true;
    }
    
    private boolean isLeapYear(int year){                  //determine whether the year is a leap year
    	
    	return((year%4==0&&year%100!=0)||year%400==0);
    }
    
    
    
    
    
    
    public boolean MonthisCorrect(String str){              //determine whether the months are right
    	
    	int month=Integer.parseInt(str.substring(2, 4));
    	
    	if(month<1 || month>12)       //month must be from 1 to 12
   	 {
   		 return false;
   		 
   	 }
    	
    return true;
    }
    
    
    public boolean DayisCorrect(String str){           //determine whether the days are right
    	
    	int year=Integer.parseInt(str.substring(0, 2));
    	int month=Integer.parseInt(str.substring(2, 4));
    	int day=Integer.parseInt(str.substring(4, 6));
    	
    	if(year>9)
    	{
    		year+=1900;
    	}
    	else
    	{
    		year+=2000;
    	}
    	
    	
    	
    	if(month<1 || month>12)       //month must be from 1 to 12
    	 {
    		 return false;
    		 
    	 }
    	 
    	int[] monthLengths=new int[]{0,31,-1,31,30,31,30,31,31,30,31,30,31};
    	
    	if(isLeapYear(year))
    	{
    		monthLengths[2]=29;
    		
    		
    	}
    	else
    	{
    		monthLengths[2]=28;
    		
    	}
    	int monthLength=monthLengths[month];
    	
    	if(day<1 || day>monthLength)
    	{
    		return false;
    	}
    	
    	
    	
    	return true;
    }
    public boolean LastdigitisCorrect(String str){               //determine whether the last digit is right
    	
        int[] number=new int[11];
    	
    	for(int i=0;i<11;i++)
    	{
    		number[i]=str.charAt(i);
    		
    	}
    	
    	
    	
    	int counter=0;
    	
    	for(int i=0;i<6;i++)
    	{
    		if(i%2==0)
    		{
    			int tmp=number[i]*2;
    			
    			if(tmp>9)
    			{
    				counter+=tmp/10+tmp%10;
    				
    			}
    			else
    			{
    				counter+=tmp;
    				
    			}
    			
    			
    		}
    		else
    		{
    			int tmp=number[i];
    			counter+=tmp;
    			
    		}
    		
    		
    		
    		
    	}
    	
    	for(int i=7;i<10;i++)
    	{

    		if(i%2!=0)
    		{
    			int tmp=number[i]*2;
    			
    			if(tmp>9)
    			{
    				counter+=tmp/10+tmp%10;
    				
    			}
    			else
    			{
    				counter+=tmp;
    				
    			}
    			
    			
    		}
    		else
    		{
    			int tmp=number[i];
    			counter+=tmp;
    			
    		}
    		
    		
    		
    		
    	}
    	
    	counter=10-counter%10;
    		
    	
    	if(counter>9)
    	{
    		counter=counter%10;
    	}
    	
    	
    	
    	String lastnumber=str.substring(10, 11);
    	int lastnumber2=Integer.parseInt(lastnumber);
    	
    	if(counter!=lastnumber2)
    	{
    		return false;
    		
    	}
    	
    	
    	
    	
    	return true;
    }
    
    
    
    
    
    
    
    
//    public static void main(String[] args) {
//		
//		Scanner scan = new Scanner(System.in);
//		System.out.print("Please type in an ID number as the single type \"YYMMDD‐NNNN\": ");
//		
//		String number=scan.nextLine();
//		scan.close();
//		boolean whethercorrect=isCorrect(number);
//		boolean girl=isFemaleNumber(number);
//		boolean boy=isMaleNumber(number);
//		boolean month=MonthisCorrect(number);
//		boolean day=DayisCorrect(number);
//		boolean lastdigit=LastdigitisCorrect(number);
//		
//		
//		if(whethercorrect==true)
//		{
//			if(girl==true)
//			{
//			    System.out.println("\n"+number+" is a correct female number");	
//				
//			}
//			else if(boy==true)
//			{
//				System.out.println("\n"+number+" is a correct male number");
//				
//			}
//			
//			
//		}
//		else
//		{
//			if(month==false)
//			{
//			    System.out.println("\n"+number+" is not correct number (unvalid month)");	
//				
//			}
//			else if(day==false)
//			{
//				System.out.println("\n"+number+" is not correct number (unvalid day)");
//				
//			}
//			else if(lastdigit==false)
//			{
//				System.out.println("\n"+number+" is not correct number (unvalid last digit)");
//				
//			}
//			
//			
//			
//		}
//		
//		
//    
//    
//    
//    }  
//    
//    
    
    /*public static void main(String[] args) {
		
		String number ="940523-1235";
		String number2 ="940523-1235";
		
		
		String test1=getFirstPart(number);
		String test2=getSecondPart(number);
		boolean test3=isFemaleNumber(number);
		boolean test4=isMaleNumber(number);
		boolean test5=areEqual(number,number2);
		boolean test6=isCorrect(number);
		
		
		System.out.println(test1);
		System.out.println(test2);
		System.out.println(test3);
		System.out.println(test4);
		System.out.println(test5);
		System.out.println(test6);
		
		
		
	}*/
	
	
	

}
