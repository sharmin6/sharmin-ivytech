
public class Main{
    
	public static void main(String[] args) {
		System.out.print("Feet       Meters    |   ");
	    System.out.println("Meters      Feet      ");
	    System.out.println("------------------------------------------------");
	    
	    System.out.println("1.0        " + footToMeter(1.0) + "     |   " + "20.0         " + meterToFoot(20.0));
	    System.out.println("2.0        " + footToMeter(2.0) + "      |   " + "25.0         " + meterToFoot(25.0));
        System.out.println("3.0        " + footToMeter(3.0) + "     |   " + "30.0         " + meterToFoot(30.0));
        System.out.println("4.0        " + footToMeter(4.0) + "      |   " + "35.0         " + meterToFoot(35.0));
        System.out.println("5.0        " + footToMeter(5.0) + "     |   " + "40.0         " + meterToFoot(40.0));
        System.out.println("6.0        " + footToMeter(6.0) + "      |   " + "45.0         " + meterToFoot(45.0));
        System.out.println("7.0        " + footToMeter(7.0) + "     |   " + "50.0         " + meterToFoot(50.0));
        System.out.println("8.0        " + footToMeter(8.0) + "      |   " + "55.0         " + meterToFoot(55.0));
        System.out.println("9.0        " + footToMeter(9.0) + "     |   " + "50.0         " + meterToFoot(60.0));
        System.out.println("10.0       " + footToMeter(10.0) + "      |   " + "65.0         " + meterToFoot(65.0));
	    
	}
	
		public static double footToMeter(double foot) {
	    
	    double meter;
	    meter = 0.305 * foot;
	    
	    return meter;
	}
	
	public static double meterToFoot(double meter) {
	    
	    double foot;
	    foot = 3.279 * meter;
	    
	    return foot;
	}
}
