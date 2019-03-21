
/**
 * Write a description of class LessThan here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class LessThan extends Exp
{
    // instance variables - replace the example below with your own
    private Exp left;
    private Exp right;

    /**
     * Default constructor for objects of class LessThan
     */
    public LessThan(Exp p_left, Exp p_right)
    {
        // initialise instance variables
        this.left = p_left;
        this.right = p_right;
    } // LessThan()

    public void accept(Visitor v){
        v.visit(this);
    }
    
    public Exp getLeft(){return this.left;}
    public Exp getRight(){return this.right;}
} // LessThan
