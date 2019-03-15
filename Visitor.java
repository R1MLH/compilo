
/**
 * Write a description of interface Visitor here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public interface Visitor
{
    /**
     * An example of a method header - replace it with your own
     *
     * @param  pY a sample parameter for the method
     * @return    the result produced by sampleMethod
     */
    public void visit(Add a);
    public void visit(Sub a);
    public void visit(Mult a);
    public void visit(Div a);
    public void visit(Int a);
    public void visit(Negative a);
    public void visit(Positive a);
} // Visitor
