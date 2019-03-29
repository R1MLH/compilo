
/**
 * Write a description of class Sub here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Sub extends Exp
{
    // instance variables - replace the example below with your own
    private Exp left;
    private Exp right;

    /**
     * Default constructor for objects of class Sub
     */
    public Sub(Exp p_left, Exp p_right)
    {
        this.left = p_left;
        this.right = p_right;
        super.setType(Type.INT);
    } // Sub()
    
    public void accept(Visitor v){
        v.visit(this);
    }
    
    
    public Exp getLeft(){return this.left;}
    public Exp getRight(){return this.right;}
} // Sub
