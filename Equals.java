
/**
 * Write a description of class Equals here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Equals extends Exp
{
    // instance variables - replace the example below with your own
    private Exp left;
    private Exp right;

    /**
     * Default constructor for objects of class Equals
     */
    public Equals(Exp p_left, Exp p_right)
    {
        // initialise instance variables
        this.left = p_left;
        this.right = p_right;
        super.setType(Type.INT);
    } // Equals()

    public void accept(Visitor v){
        v.visit(this);
    }
    
    public Exp getLeft(){return this.left;}
    public Exp getRight(){return this.right;}
} // Equals
