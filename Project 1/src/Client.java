/** 
 * This is a client for the BenfordTester, i.e. a program/class that
 * uses the BenfordTester.
 *
 * @author Luke Badini
 * @version 4/8/2015
 */



/**
 * The main method (which is where the Java interpreter starts when
 * executing a program). Here we create an instance of the
 * BenfordTester (a BenfordTester object), and then you can call
 * BenfordTester methods using that object.
 */
public class Client 
{

    public static void main(String[] args) 
    {

	/*
	 *  Creating an object of Type BenfordTester
	 */
	BenfordTester benford = new BenfordTester();
	
	/*
	 * Calling BenfordTester methods for each
	 * of the files.
	 */
	System.out.println("sunspots.txt");
	System.out.println("___________________");
	benford.count("src/sunspots.txt");
	benford.graph(3);
	System.out.println();
	benford = new BenfordTester();
	
	System.out.println("livejournal.txt");
	System.out.println("___________________");
	benford.count("src/livejournal.txt");
	benford.graph(15);
	System.out.println();
	benford = new BenfordTester();
	
	System.out.println("librarybooks.txt");
	System.out.println("___________________");
	benford.count("src/librarybooks.txt");
	benford.graph(100);
	System.out.println();
	benford = new BenfordTester();
	
	System.out.println("stars.txt");
	System.out.println("___________________");
	benford.count("src/stars.txt");
	benford.graph(1);
	System.out.println();
	benford = new BenfordTester();
	
	System.out.println("fibonacci.txt");
	System.out.println("___________________");
	benford.count("src/fibonacci.txt");
	benford.graph(1);
    }
}
