
/**
 * Write a description of class PrettyPrinter here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class PrettyPrinter implements Visitor
{
    private String returnS;

    public PrettyPrinter(){
        this.returnS = "";
    }

    public void prettyPrint(){
        System.out.println(this.returnS);
    }

    public void visit(Add a){
        this.returnS +=("ADD(");
        a.getLeft().accept(this);
        this.returnS +=(",");
        a.getRight().accept(this);
        this.returnS +=(")");
    }

    public void visit(Sub a){
        this.returnS +=("SUB(");
        a.getLeft().accept(this);
        this.returnS +=(",");
        a.getRight().accept(this);
        this.returnS +=(")");
    }

    public void visit(Mult a){
        this.returnS +=("MULT(");
        a.getLeft().accept(this);
        this.returnS +=(",");
        a.getRight().accept(this);
        this.returnS +=(")");
    }

    public void visit(Div a){
        this.returnS +=("DIV(");
        a.getLeft().accept(this);
        this.returnS +=(",");
        a.getRight().accept(this);
        this.returnS +=(")");
    }

    public void visit(Int a){
        this.returnS +=("INT(" + a.getInt()+")");
    }
    
    public void visit(Negative a){
        this.returnS += ("NEGATIVE(");
        a.getExp().accept(this);
        this.returnS += (")");
    }
    
    public void visit(Positive a){
        this.returnS += ("POSITIVE(");
        a.getExp().accept(this);
        this.returnS += (")");
    }
} // PrettyPrinter
