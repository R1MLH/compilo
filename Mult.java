
/**
 * Write a description of class Mult here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Mult extends Exp
{
    private Exp left;
    private Exp right;

    /**
     * Default constructor for objects of class Mult
     */
    public Mult(Exp p_left, Exp p_right)
    {
        this.left = p_left;
        this.right = p_right;
        super.setType(Type.INT);
    } // Mult()

    public void accept(Visitor v){
        v.visit(this);
    }
    
    
    public Exp getLeft(){return this.left;}
    public Exp getRight(){return this.right;}
} // Mult
