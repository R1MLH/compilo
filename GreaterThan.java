
/**
 * Write a description of class GreaterThan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GreaterThan extends Exp
{
    // instance variables - replace the example below with your own
    private Exp left;
    private Exp right;

    /**
     * Default constructor for objects of class GreaterThan
     */
    public GreaterThan(Exp p_left, Exp p_right)
    {
        // initialise instance variables
        this.left = p_left;
        this.right = p_right;
    } // GreaterThan()

    public void accept(Visitor v){
        v.visit(this);
    }
    
    public Exp getLeft(){return this.left;}
    public Exp getRight(){return this.right;}
} // GreaterThan
