
/**
 * Write a description of class Int here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Int extends Exp
{
    // instance variables - replace the example below with your own
    private int value;

    /**
     * Default constructor for objects of class Int
     */
    public Int(int i)
    {
        super.setType(Type.INT);
        this.value = i;
    } 
    
     public void accept(Visitor v){
        v.visit(this);
    }
    
    public int getInt(){return this.value;}
} // Int
