
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main
{
    // instance variables - replace the example below with your own
    
    /**
     * Default constructor for objects of class main
     */
    public main()
    {
        Exp a = new Add(new Mult( new Int(6), new Int(7)), new Int(8));
        
        Visitor v = new PrettyPrinter();
        a.accept(v);
    } // main()

   
} // main
