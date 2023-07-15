package Lets;
      
import java.text.DecimalFormat;
import java.text.ParseException;

public class Main {

	public static void main(String[] args) throws ParseException {
//		LocalTime lt = LocalTime.now();
//		System.out.println(lt);
//		DateTimeFormatter format = DateTimeFormatter.ofPattern("HH*mm");
//		System.out.println(lt.format(format));
//
//		String st = "13:00";
//
//		LocalTime time = LocalTime.parse(st);
//
////		System.out.println(time);
//
////		LocalTime newtime = time.plusHours(2);
//
//		System.out.println(time +" "+lt);
//		System.out.println(lt.compareTo(time));
//		Random random = new Random();
//		String id = String.format("%04d", random.nextInt(10000));
//		System.out.println(id);
		DecimalFormat decfor = new DecimalFormat("0.00");  
		  
		//defining a number of type double   
		double num = 123.905656465484567;  
		System.out.println("Double Number: " + num);  
		System.out.println("Double Number: " + decfor.format(num));    //123.99  
		//DecimalFormat, default is RoundingMode.HALF_EVEN  
	}
}
