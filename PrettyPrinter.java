
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

    public void visit(GreaterOrEqual a){
        this.returnS +=("GreaterOrEqual(");
        a.getLeft().accept(this);
        this.returnS +=(",");
        a.getRight().accept(this);
        this.returnS +=(")");
    }

    public void visit(GreaterThan a){
        this.returnS +=("GreaterThan(");
        a.getLeft().accept(this);
        this.returnS +=(",");
        a.getRight().accept(this);
        this.returnS +=(")");
    }

    public void visit(LessThan a){
        this.returnS +=("LessThan(");
        a.getLeft().accept(this);
        this.returnS +=(",");
        a.getRight().accept(this);
        this.returnS +=(")");
    }

    public void visit(LessOrEqual a){
        this.returnS +=("LessOrEqual(");
        a.getLeft().accept(this);
        this.returnS +=(",");
        a.getRight().accept(this);
        this.returnS +=(")");
    }

    public void visit(Different a){
        this.returnS +=("Different(");
        a.getLeft().accept(this);
        this.returnS +=(",");
        a.getRight().accept(this);
        this.returnS +=(")");
    }

    public void visit(IfThenElse a){
        this.returnS += ("IF(");
        a.getCondition().accept(this);
        this.returnS += (") THEN ( ");
        a.getThen().accept(this);
        this.returnS += (") ELSE (");
        a.getElse().accept(this);
        this.returnS += ")";
    }    

    public void visit(Equals a){
        this.returnS +=("Equals(");
        a.getLeft().accept(this);
        this.returnS +=(",");
        a.getRight().accept(this);
        this.returnS +=(")");
    }

    public void visit(Strexp e){
        this.returnS += "STRING (" + e.getString()+ ")";
    }

    public void visit(InstrExp a)
    {
        this.returnS += ("InstrExp(");
        a.getExp().accept(this);
        this.returnS += (")");
    }

    public void visit(LetInEnd a)
    {
        this.returnS += ("LET(");
        //a.getCondition().accept(this);
        for(Declaration e: a.getDecls()){
            e.accept(this);
        }
        this.returnS += (") IN ( ");
        for(Instruction e: a.getInstructions()){
            e.accept(this);
        }
        this.returnS += (") END ");
    }

    public void visit(Print a)
    {
        this.returnS += ("Print(");
        a.getExp().accept(this);
        this.returnS += (")");
    }
    
     public void visit(Declaration a)
    {
        this.returnS += ("DECLARATION( " + a.getName() + " := ");
        a.getExp().accept(this);
        this.returnS += (")");
    }
    
    public void visit(While a){
        this.returnS+= ("WHILE(");
        a.getCondition().accept(this);
        this.returnS += ("){");
        for(Instruction e: a.getInstructions()){
            e.accept(this);
            this.returnS+=(";");
        }
        this.returnS += ("}");
    }
    public void visit(Variable a){
        this.returnS += ("VARIABLE:"+a.getName());
    }
    
      public void visit(Affectation a)
    {
        this.returnS += ("Affectation( " + a.getName() + " :=  ");
        a.getExp().accept(this);
        this.returnS += (")");
    }
} // PrettyPrinter
