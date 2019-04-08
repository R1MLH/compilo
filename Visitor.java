
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
    public void visit(IfThenElse a);
    public void visit(GreaterOrEqual a);
    public void visit(LessThan a);
    public void visit(GreaterThan a);
    public void visit(LessOrEqual a);
    public void visit(Strexp a);
    public void visit(Equals a);
    public void visit(Different a);
    public void visit(InstrExp a);
    public void visit(LetInEnd a);
    public void visit(Print a);
    public void visit(Declaration a);
    public void visit(Variable a);
} // Visitor
