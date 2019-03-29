
/**
 * Write a description of class Add here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class GreaterOrEqual extends Exp
{
    // instance variables - replace the example below with your own
    private Exp left;
    private Exp right;

    /**
     * Default constructor for objects of class Add
     */
    public GreaterOrEqual(Exp p_left, Exp p_right)
    {
        // initialise instance variables
        this.left = p_left;
        this.right = p_right;
        super.setType(Type.INT);
    } // Add()

    public void accept(Visitor v){
        v.visit(this);
    }
    
    public Exp getLeft(){return this.left;}
    public Exp getRight(){return this.right;}
} // 
