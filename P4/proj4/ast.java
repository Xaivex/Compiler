import java.io.*;
import java.util.*;

// **********************************************************************
// The ASTnode class defines the nodes of the abstract-syntax tree that
// represents a C-- program.
//
// Internal nodes of the tree contain pointers to children, organized
// either in a list (for nodes that may have a variable number of
// children) or as a fixed set of fields.
//
// The nodes for literals and ids contain line and character number
// information; for string literals and identifiers, they also contain a
// string; for integer literals, they also contain an integer value.
//
// Here are all the different kinds of AST nodes and what kinds of children
// they have.  All of these kinds of AST nodes are subclasses of "ASTnode".
// Indentation indicates further subclassing:
//
//     Subclass            Children
//     --------            ----
//     ProgramNode         DeclListNode
//     DeclListNode        linked list of DeclNode
//     DeclNode:
//       VarDeclNode       TypeNode, IdNode, int
//       FnDeclNode        TypeNode, IdNode, FormalsListNode, FnBodyNode
//       FormalDeclNode    TypeNode, IdNode
//       StructDeclNode    IdNode, DeclListNode
//
//     FormalsListNode     linked list of FormalDeclNode
//     FnBodyNode          DeclListNode, StmtListNode
//     StmtListNode        linked list of StmtNode
//     ExpListNode         linked list of ExpNode
//
//     TypeNode:
//       IntNode           -- none --
//       BoolNode          -- none --
//       VoidNode          -- none --
//       StructNode        IdNode
//
//     StmtNode:
//       AssignStmtNode      AssignNode
//       PostIncStmtNode     ExpNode
//       PostDecStmtNode     ExpNode
//       ReadStmtNode        ExpNode
//       WriteStmtNode       ExpNode
//       IfStmtNode          ExpNode, DeclListNode, StmtListNode
//       IfElseStmtNode      ExpNode, DeclListNode, StmtListNode,
//                                    DeclListNode, StmtListNode
//       WhileStmtNode       ExpNode, DeclListNode, StmtListNode
//       RepeatStmtNode      ExpNode, DeclListNode, StmtListNode
//       CallStmtNode        CallExpNode
//       ReturnStmtNode      ExpNode
//
//     ExpNode:
//       IntLitNode          -- none --
//       StrLitNode          -- none --
//       TrueNode            -- none --
//       FalseNode           -- none --
//       IdNode              -- none --
//       DotAccessNode       ExpNode, IdNode
//       AssignNode          ExpNode, ExpNode
//       CallExpNode         IdNode, ExpListNode
//       UnaryExpNode        ExpNode
//         UnaryMinusNode
//         NotNode
//       BinaryExpNode       ExpNode ExpNode
//         PlusNode
//         MinusNode
//         TimesNode
//         DivideNode
//         AndNode
//         OrNode
//         EqualsNode
//         NotEqualsNode
//         LessNode
//         GreaterNode
//         LessEqNode
//         GreaterEqNode
//
// Here are the different kinds of AST nodes again, organized according to
// whether they are leaves, internal nodes with linked lists of children, or
// internal nodes with a fixed number of children:
//
// (1) Leaf nodes:
//        IntNode,   BoolNode,  VoidNode,  IntLitNode,  StrLitNode,
//        TrueNode,  FalseNode, IdNode
//
// (2) Internal nodes with (possibly empty) linked lists of children:
//        DeclListNode, FormalsListNode, StmtListNode, ExpListNode
//
// (3) Internal nodes with fixed numbers of children:
//        ProgramNode,     VarDeclNode,     FnDeclNode,     FormalDeclNode,
//        StructDeclNode,  FnBodyNode,      StructNode,     AssignStmtNode,
//        PostIncStmtNode, PostDecStmtNode, ReadStmtNode,   WriteStmtNode
//        IfStmtNode,      IfElseStmtNode,  WhileStmtNode,  RepeatStmtNode,
//        CallStmtNode
//        ReturnStmtNode,  DotAccessNode,   AssignExpNode,  CallExpNode,
//        UnaryExpNode,    BinaryExpNode,   UnaryMinusNode, NotNode,
//        PlusNode,        MinusNode,       TimesNode,      DivideNode,
//        AndNode,         OrNode,          EqualsNode,     NotEqualsNode,
//        LessNode,        GreaterNode,     LessEqNode,     GreaterEqNode
//
// **********************************************************************

// **********************************************************************
// ASTnode class (base class for all other kinds of nodes)
// **********************************************************************

abstract class ASTnode {
    // every subclass must provide an unparse operation
    abstract public void unparse(PrintWriter p, int indent);

    // this method can be used by the unparse methods to do indenting
    protected void addIndentation(PrintWriter p, int indent) {
        for (int k = 0; k < indent; k++) p.print(" ");
    }
}

// **********************************************************************
// ProgramNode,  DeclListNode, FormalsListNode, FnBodyNode,
// StmtListNode, ExpListNode
// **********************************************************************

class ProgramNode extends ASTnode {
    public ProgramNode(DeclListNode L) {
        myDeclList = L;
    }

    public void unparse(PrintWriter p, int indent) {
        myDeclList.unparse(p, indent);
    }

    public void algoNames() throws EmptySymTableException {
        symt = new SymTable();
        myDeclList.algoNames(symt, symt);
    }

    private DeclListNode myDeclList;
    private SymTable symt;
}

class DeclListNode extends ASTnode {
    public DeclListNode(List<DeclNode> symt) {
        myDecls = symt;
    }

    public void unparse(PrintWriter p, int indent) {
        Iterator it = myDecls.iterator();
        try {
            while (it.hasNext()) {
                ((DeclNode)it.next()).unparse(p, indent);
            }
        } catch (NoSuchElementException ex) {
            System.err.println("unexpected NoSuchElementException in DeclListNode.print");
            System.exit(-1);
        }
    }

    public void algoNames(SymTable structTable, SymTable varTable) throws EmptySymTableException {
        Iterator it = myDecls.iterator();
        try {
            while(it.hasNext()) {
                DeclNode node = (DeclNode) it.next();
                if (node instanceof VarDeclNode) {
                    ((VarDeclNode) node).algoNames(structTable, varTable);
                } else {
                    node.algoNames(varTable);
                }
            }
        } catch (NoSuchElementException ex) {
            System.err.println("unexpected NoSuchElementException in DeclListNode.print");
            System.exit(-1);
        }
    }

    private List<DeclNode> myDecls;
}

class FormalsListNode extends ASTnode {
    public FormalsListNode(List<FormalDeclNode> symt) {
        myFormals = symt;
    }

    public void unparse(PrintWriter p, int indent) {
        Iterator<FormalDeclNode> it = myFormals.iterator();
        if (it.hasNext()) { // if there is at least one element
            it.next().unparse(p, indent);
            while (it.hasNext()) {  // print the rest of the list
                p.print(", ");
                it.next().unparse(p, indent);
            }
        }
    }

    public void algoNames(FuncTSym func, SymTable symt) {
        for (FormalDeclNode formal : myFormals) {
            formal.algoNames(func, symt);
        }
    }

    private List<FormalDeclNode> myFormals;
}

class FnBodyNode extends ASTnode {
    public FnBodyNode(DeclListNode declList, StmtListNode stmtList) {
        myDeclList = declList;
        myStmtList = stmtList;
    }

    public void unparse(PrintWriter p, int indent) {
        myDeclList.unparse(p, indent);
        myStmtList.unparse(p, indent);
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myDeclList.algoNames(symt, symt);
        myStmtList.algoNames(symt);
    }

    private DeclListNode myDeclList;
    private StmtListNode myStmtList;
}

class StmtListNode extends ASTnode {
    public StmtListNode(List<StmtNode> symt) {
        myStmts = symt;
    }

    public void unparse(PrintWriter p, int indent) {
        Iterator<StmtNode> it = myStmts.iterator();
        while (it.hasNext()) {
            it.next().unparse(p, indent);
        }
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        Iterator<StmtNode> it = myStmts.iterator();
        while (it.hasNext()) {
            it.next().algoNames(symt);
        }
    }

    private List<StmtNode> myStmts;
}

class ExpListNode extends ASTnode {
    public ExpListNode(List<ExpNode> symt) {
        myExps = symt;
    }

    public void unparse(PrintWriter p, int indent) {
        Iterator<ExpNode> it = myExps.iterator();
        if (it.hasNext()) { // if there is at least one element
            it.next().unparse(p, indent);
            while (it.hasNext()) {  // print the rest of the list
                p.print(", ");
                it.next().unparse(p, indent);
            }
        }
    }

    public void algoNames(SymTable symt) throws EmptySymTableException{
        if (myExps == null) {
            return;
        }

        Iterator<ExpNode> it = myExps.iterator();
        try {
            while(it.hasNext()) {
                ((ExpNode)it.next()).algoNames(symt);
            }
        } catch (NoSuchElementException ex) {
            System.err.println("unexpected NoSuchElementException in ExpListNode.print");
            System.exit(-1);
        } 
    }

    private List<ExpNode> myExps;
}

// **********************************************************************
// DeclNode and its subclasses
// **********************************************************************

abstract class DeclNode extends ASTnode {
    abstract public void algoNames(SymTable symt) throws EmptySymTableException;
}

class VarDeclNode extends DeclNode {
    public VarDeclNode(TypeNode type, IdNode id, int size) {
        myType = type;
        myId = id;
        mySize = size;
    }

    public void unparse(PrintWriter p, int indent) {
        addIndentation(p, indent);
        myType.unparse(p, 0);
        p.print(" ");
        myId.unparse(p, 0);
        p.println(";");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        this.algoNames(symt, symt);
    }

    public void algoNames(SymTable structTable, SymTable symt) throws EmptySymTableException {
        String typeName = myType.getTypeSym().getType();
        if(typeName.equals("void")) {
            ErrMsg.fatal(myId.getLineNum(), myId.getCharNum(),
                "Non-function declared void");    
            return;
        }

        // Check if the type is of type struct
        if(typeName.equals("struct")) {
            String structId = ((StructNode)myType).getId();
            if(symt.lookupGlobal(structId) == null) {
                ErrMsg.fatal(myId.getLineNum(), myId.getCharNum(),
                "Invalid name of struct type");    
                return;
            } 
            else {
                // valid
                if(!symt.lookupGlobal(structId).getType().equals("struct")) {
                    return;
                }
            }
            
            TypeSymDef symDef = (TypeSymDef)(symt.lookupGlobal(structId));
            TypeDeclSym symDel = new TypeDeclSym(symDef, structId);
            try {
                structTable.addDecl(myId.getString(), symDel);
            } catch (DuplicateSymException ex) {
                ErrMsg.fatal(myId.getLineNum(), myId.getCharNum(),
                    "Multiply declared identifier");    
            } catch (EmptySymTableException ex) { 
                System.err.println("Caught EmptySymTableException!");
            } catch (Exception ex) {
                System.err.println(ex);
            }
            return;
	    }

        try {
            structTable.addDecl(myId.getString(), myType.getTypeSym());
        } catch (DuplicateSymException ex) {
            ErrMsg.fatal(myId.getLineNum(), myId.getCharNum(),
                "Multiply declared identifier");    
        } catch (EmptySymTableException ex) { 
            System.err.println("Caught EmptySymTableException!");
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    private TypeNode myType;
    private IdNode myId;
    private int mySize;  // use value NOT_STRUCT if this is not a struct type

    public static int NOT_STRUCT = -1;
}

class FnDeclNode extends DeclNode {
    public FnDeclNode(TypeNode type,
                      IdNode id,
                      FormalsListNode formalList,
                      FnBodyNode core) {
        myType = type;
        myId = id;
        myFormalsList = formalList;
        myBody = core;
    }

    public void unparse(PrintWriter p, int indent) {
        addIndentation(p, indent);
        myType.unparse(p, 0);
        p.print(" ");
        myId.unparse(p, 0);
        p.print("(");
        myFormalsList.unparse(p, 0);
        p.println(") {");
        myBody.unparse(p, indent+4);
        p.println("}\n");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        FuncTSym onCurrent = new FuncTSym(myType.getTypeSym(), "func");
        try {
            symt.addDecl(myId.getString(), onCurrent);
        } catch (DuplicateSymException ex) {
            ErrMsg.fatal(myId.getLineNum(), myId.getCharNum(),
                "Multiply declared identifier");    
        } catch (EmptySymTableException ex) { 
            System.err.println("Caught EmptySymTableException!");
        } catch (Exception ex) {
            System.err.println(ex);
        }
        
        symt.addScope();
        myFormalsList.algoNames(onCurrent, symt);
        myBody.algoNames(symt);
        try {
            symt.removeScope(); 
        } catch (EmptySymTableException ex) {
            System.err.println("Caught EmptySymTableException!"); 
        }
    }

    private TypeNode myType;
    private IdNode myId;
    private FormalsListNode myFormalsList;
    private FnBodyNode myBody;
}

class FormalDeclNode extends DeclNode {
    public FormalDeclNode(TypeNode type, IdNode id) {
        myType = type;
        myId = id;
    }

    public void unparse(PrintWriter p, int indent) {
        myType.unparse(p, 0);
        p.print(" ");
        myId.unparse(p, 0);
    }

    @Override
    public void algoNames(SymTable symt){}

    public void algoNames(FuncTSym func, SymTable symt) {
        String typeName = myType.getTypeSym().getType();
        if(typeName.equals("void")) {
            ErrMsg.fatal(myId.getLineNum(), myId.getCharNum(),
                "Non-function declared void");    
            return;
        }

        try {
            symt.addDecl(myId.getString(), myType.getTypeSym());
            func.addFormals(myType.getTypeSym().toString());
        } catch (DuplicateSymException ex) {
            ErrMsg.fatal(myId.getLineNum(), myId.getCharNum(), 
                "Multiply declared identifier");    
        } catch (EmptySymTableException ex) { 
            System.err.println("Caught EmptySymTableException!");
        } catch (Exception ex) {
            System.err.println(ex);
        }
        
    }

    private TypeNode myType;
    private IdNode myId;
}

class StructDeclNode extends DeclNode {
    public StructDeclNode(IdNode id, DeclListNode declList) {
        myId = id;
        myDeclList = declList;
    }

    public void unparse(PrintWriter p, int indent) {
        addIndentation(p, indent);
        p.print("struct ");
        myId.unparse(p, 0);
        p.println("{");
        myDeclList.unparse(p, indent+4);
        addIndentation(p, indent);
        p.println("};\n");

    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
	    SymTable structTable = new SymTable();
	    myDeclList.algoNames(structTable, symt);

        TypeSymDef onCurrent = new TypeSymDef(structTable, "struct");
        try {
            symt.addDecl(myId.getString(), onCurrent);
        } catch (DuplicateSymException ex) {
            ErrMsg.fatal(myId.getLineNum(), myId.getCharNum(), 
                "Multiply declared identifier");    
        } catch (EmptySymTableException ex) { 
            System.err.println("Caught EmptySymTableException!");
        } catch (Exception ex) {
            System.err.println(ex);
        }
    }

    private IdNode myId;
    private DeclListNode myDeclList;
}

// **********************************************************************
// TypeNode and its Subclasses
// **********************************************************************

abstract class TypeNode extends ASTnode {
    abstract public TSym getTypeSym();
}

class IntNode extends TypeNode {
    public IntNode() {
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("int");
    }

    public TSym getTypeSym() {
        return new TSym("int");
    }
}

class BoolNode extends TypeNode {
    public BoolNode() {
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("bool");
    }

    public TSym getTypeSym() {
        return new TSym("bool");
    }
}

class VoidNode extends TypeNode {
    public VoidNode() {
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("void");
    }

    public TSym getTypeSym() {
        return new TSym("void");
    }
}

class StructNode extends TypeNode {
    public StructNode(IdNode id) {
        myId = id;
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("struct ");
        myId.unparse(p, 0);
    }

    public TSym getTypeSym() {
        return new TSym("struct");
    }

    public String getId() {
        return myId.getString();
    }

    private IdNode myId;
}

// **********************************************************************
// StmtNode and its subclasses
// **********************************************************************

abstract class StmtNode extends ASTnode {
    abstract public void algoNames(SymTable symt) throws EmptySymTableException;
}

class AssignStmtNode extends StmtNode {
    public AssignStmtNode(AssignNode assign) {
        myAssign = assign;
    }

    public void unparse(PrintWriter p, int indent) {
        addIndentation(p, indent);
        myAssign.unparse(p, -1); // no parentheses
        p.println(";");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myAssign.algoNames(symt);
    }

    private AssignNode myAssign;
}

class PostIncStmtNode extends StmtNode {
    public PostIncStmtNode(ExpNode exp) {
        myExp = exp;
    }

    public void unparse(PrintWriter p, int indent) {
        addIndentation(p, indent);
        myExp.unparse(p, 0);
        p.println("++;");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp.algoNames(symt);
    }

    private ExpNode myExp;
}

class PostDecStmtNode extends StmtNode {
    public PostDecStmtNode(ExpNode exp) {
        myExp = exp;
    }

    public void unparse(PrintWriter p, int indent) {
        addIndentation(p, indent);
        myExp.unparse(p, 0);
        p.println("--;");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp.algoNames(symt);
    }

    private ExpNode myExp;
}

class ReadStmtNode extends StmtNode {
    public ReadStmtNode(ExpNode e) {
        myExp = e;
    }

    public void unparse(PrintWriter p, int indent) {
        addIndentation(p, indent);
        p.print("cin >> ");
        myExp.unparse(p, 0);
        p.println(";");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp.algoNames(symt);
    }

    private ExpNode myExp;
}

class WriteStmtNode extends StmtNode {
    public WriteStmtNode(ExpNode exp) {
        myExp = exp;
    }

    public void unparse(PrintWriter p, int indent) {
        addIndentation(p, indent);
        p.print("cout << ");
        myExp.unparse(p, 0);
        p.println(";");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp.algoNames(symt);
    }

    private ExpNode myExp;
}

class IfStmtNode extends StmtNode {
    public IfStmtNode(ExpNode exp, DeclListNode dlist, StmtListNode slist) {
        myDeclList = dlist;
        myExp = exp;
        myStmtList = slist;
    }

    public void unparse(PrintWriter p, int indent) {
        addIndentation(p, indent);
        p.print("if (");
        myExp.unparse(p, 0);
        p.println(") {");
        myDeclList.unparse(p, indent+4);
        myStmtList.unparse(p, indent+4);
        addIndentation(p, indent);
        p.println("}");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp.algoNames(symt);
        addScope(symt);
        myDeclList.algoNames(symt, symt);
        myStmtList.algoNames(symt);
        removeScope(symt);
    }
    
    private void addScope(SymTable symt) {
        symt.addScope();
    }
    
    private void removeScope(SymTable symt) {
        try {
            symt.removeScope(); 
        } catch (EmptySymTableException ex) {
            System.err.println("Caught EmptySymTableException!"); 
        }
    }

    private ExpNode myExp;
    private DeclListNode myDeclList;
    private StmtListNode myStmtList;
}

class IfElseStmtNode extends StmtNode {
    public IfElseStmtNode(ExpNode exp, DeclListNode dlist1,
                          StmtListNode slist1, DeclListNode dlist2,
                          StmtListNode slist2) {
        myExp = exp;
        myThenDeclList = dlist1;
        myThenStmtList = slist1;
        myElseDeclList = dlist2;
        myElseStmtList = slist2;
    }

    public void unparse(PrintWriter p, int indent) {
        addIndentation(p, indent);
        p.print("if (");
        myExp.unparse(p, 0);
        p.println(") {");
        myThenDeclList.unparse(p, indent+4);
        myThenStmtList.unparse(p, indent+4);
        addIndentation(p, indent);
        p.println("}");
        addIndentation(p, indent);
        p.println("else {");
        myElseDeclList.unparse(p, indent+4);
        myElseStmtList.unparse(p, indent+4);
        addIndentation(p, indent);
        p.println("}");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp.algoNames(symt);
        processStmtList(symt, myThenDeclList, myThenStmtList);
        processStmtList(symt, myElseDeclList, myElseStmtList);
    }
    
    private void processStmtList(SymTable symt, DeclListNode declList, StmtListNode stmtList) throws EmptySymTableException {
        symt.addScope();
        declList.algoNames(symt, symt);
        stmtList.algoNames(symt);
        symt.removeScope();
    }

    private ExpNode myExp;
    private DeclListNode myThenDeclList;
    private StmtListNode myThenStmtList;
    private StmtListNode myElseStmtList;
    private DeclListNode myElseDeclList;
}

class WhileStmtNode extends StmtNode {
    public WhileStmtNode(ExpNode exp, DeclListNode dlist, StmtListNode slist) {
        myExp = exp;
        myDeclList = dlist;
        myStmtList = slist;
    }

    public void unparse(PrintWriter p, int indent) {
        addIndentation(p, indent);
        p.print("while (");
        myExp.unparse(p, 0);
        p.println(") {");
        myDeclList.unparse(p, indent+4);
        myStmtList.unparse(p, indent+4);
        addIndentation(p, indent);
        p.println("}");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp.algoNames(symt);
        addAndRemoveScope(symt, myDeclList, myStmtList);
    }

    private void addAndRemoveScope(SymTable symt, DeclListNode dlist, StmtListNode slist) 
        throws EmptySymTableException {
        symt.addScope();
        dlist.algoNames(symt, symt);
        slist.algoNames(symt);
        symt.removeScope();
    }

    private ExpNode myExp;
    private DeclListNode myDeclList;
    private StmtListNode myStmtList;
}

class RepeatStmtNode extends StmtNode {
    public RepeatStmtNode(ExpNode exp, DeclListNode dlist, StmtListNode slist) {
        myExp = exp;
        myDeclList = dlist;
        myStmtList = slist;
    }

    public void unparse(PrintWriter p, int indent) {
	addIndentation(p, indent);
        p.print("repeat (");
        myExp.unparse(p, 0);
        p.println(") {");
        myDeclList.unparse(p, indent+4);
        myStmtList.unparse(p, indent+4);
        addIndentation(p, indent);
        p.println("}");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp.algoNames(symt);
        handleScope(symt, () -> {
            try {
                myDeclList.algoNames(symt, symt);
            } catch (EmptySymTableException e) {
                System.err.println("Caught EmptySymTableException!"); 
            }
            
            try {
                myStmtList.algoNames(symt);
            } catch (EmptySymTableException e) {
                System.err.println("Caught EmptySymTableException!"); 
            }
        });
    }

    private void handleScope(SymTable symt, Runnable code) throws EmptySymTableException {
        symt.addScope();
        code.run();
        symt.removeScope();
    }

    private ExpNode myExp;
    private DeclListNode myDeclList;
    private StmtListNode myStmtList;
}

class CallStmtNode extends StmtNode {
    public CallStmtNode(CallExpNode call) {
        myCall = call;
    }

    public void unparse(PrintWriter p, int indent) {
        addIndentation(p, indent);
        myCall.unparse(p, indent);
        p.println(";");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myCall.algoNames(symt);
    }

    private CallExpNode myCall;
}

class ReturnStmtNode extends StmtNode {
    public ReturnStmtNode(ExpNode exp) {
        myExp = exp;
    }

    public void unparse(PrintWriter p, int indent) {
        addIndentation(p, indent);
        p.print("return");
        if (myExp != null) {
            p.print(" ");
            myExp.unparse(p, 0);
        }
        p.println(";");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        if(myExp != null) {
            myExp.algoNames(symt);
        }
    }

    private ExpNode myExp; // possibly null
}

// **********************************************************************
// ExpNode and its subclasses
// **********************************************************************

abstract class ExpNode extends ASTnode {
    abstract public void algoNames(SymTable symt) throws EmptySymTableException;
}

class IntLitNode extends ExpNode {
    public IntLitNode(int lineNum, int charNum, int intVal) {
        myLineNum = lineNum;
        myCharNum = charNum;
        myIntVal = intVal;
    }

    public void unparse(PrintWriter p, int indent) {
        p.print(myIntVal);
    }

    public void algoNames(SymTable symt) {
    }

    private int myLineNum;
    private int myCharNum;
    private int myIntVal;
}

class StringLitNode extends ExpNode {
    public StringLitNode(int lineNum, int charNum, String strVal) {
        myLineNum = lineNum;
        myCharNum = charNum;
        myStrVal = strVal;
    }

    public void unparse(PrintWriter p, int indent) {
        p.print(myStrVal);
    }

    public void algoNames(SymTable symt) {
    }

    private int myLineNum;
    private int myCharNum;
    private String myStrVal;
}

class TrueNode extends ExpNode {
    public TrueNode(int lineNum, int charNum) {
        myLineNum = lineNum;
        myCharNum = charNum;
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("true");
    }

    public void algoNames(SymTable symt) {
    }

    private int myLineNum;
    private int myCharNum;
}

class FalseNode extends ExpNode {
    public FalseNode(int lineNum, int charNum) {
        myLineNum = lineNum;
        myCharNum = charNum;
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("false");
    }

    public void algoNames(SymTable symt) {
    }

    private int myLineNum;
    private int myCharNum;
}

class IdNode extends ExpNode {
    public IdNode(int lineNum, int charNum, String strVal) {
        myLineNum = lineNum;
        myCharNum = charNum;
        myStrVal = strVal;
    }

    public void unparse(PrintWriter p, int indent) {
        p.print(myStrVal);
        if(this.TSym != null) {
            p.print("(");
            p.print(TSym.getType());
            p.print(")");
        }
    }

    public TSym getTypeSym() {
        return TSym;
    }

    public String getString() {
        return myStrVal;
    }

    public int getCharNum() {
        return myCharNum;
    }

    public int getLineNum() {
        return myLineNum;
    }

    public void setDot(TSym sd) {
        this.TSym = sd;
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        TSym local = symt.lookupLocal(this.myStrVal);
        if(local != null) {
            this.TSym = local;
            return;
        }

        TSym global = symt.lookupGlobal(this.myStrVal);
        if(global != null) {
            this.TSym = global;
            return;
        }

        ErrMsg.fatal(this.myLineNum, this.getCharNum(),
            "Undeclared identifier");    
    }

    private int myLineNum;
    private int myCharNum;
    private String myStrVal;
    private TSym TSym;
}

class DotAccessExpNode extends ExpNode {
    
    public DotAccessExpNode(ExpNode loc, IdNode id) {
        myLoc = loc;
        myId = id;
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(");
        myLoc.unparse(p, 0);
        p.print(").");
        myId.unparse(p, 0);
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        badAcc = false;
        myLoc.algoNames(symt);
    
        if (myLoc instanceof IdNode) {
            // Check if left-hand side of dot-access is a struct
            if (!(((IdNode) myLoc).getTypeSym() instanceof TypeDeclSym)) {
                ErrMsg.fatal(((IdNode) myId).getLineNum(), ((IdNode) myId).getCharNum(),
                    "Dot-access of non-struct type");
                badAcc = true;
                return;
            }
    
            TypeDeclSym left = (TypeDeclSym) ((IdNode) myLoc).getTypeSym();
            TypeSymDef type = left.getCore();
            SymTable structTable = type.getList();
    
            // Check if right-hand side of dot-access is a valid field name for the struct
            if (structTable.lookupLocal(myId.getString()) == null) {
                ErrMsg.fatal(myId.getLineNum(), myId.getCharNum(),
                    "Invalid struct field name");
                badAcc = true;
                return;
            }
            // Set the type of the id node to the field'symt type
            myId.setDot(structTable.lookupLocal(myId.getString()));
        } else if (myLoc instanceof DotAccessExpNode) {
            if (((DotAccessExpNode) myLoc).badAcc == true) {
                badAcc = true;
                return;
            }
            TypeDeclSym left = ((DotAccessExpNode) myLoc).prev;
            if (left == null) {
                badAcc = true;
                return;
            }
            TypeSymDef type = left.getCore();
            SymTable structTable = type.getList();
    
            // Check if right-hand side of dot-access is a valid field name for the struct
            if (structTable.lookupLocal(myId.getString()) == null) {
                ErrMsg.fatal(myId.getLineNum(), myId.getCharNum(),
                    "Invalid struct field name");
                badAcc = true;
                return;
            }
    
            // Set the type of the id node to the field'symt type
            myId.setDot(structTable.lookupLocal(myId.getString()));
        }
    }
    

    private ExpNode myLoc;
    private IdNode myId;
    private boolean badAcc;
    private TypeDeclSym prev;
}

class AssignNode extends ExpNode {
    public AssignNode(ExpNode lhs, ExpNode exp) {
        myLhs = lhs;
        myExp = exp;
    }

    public void unparse(PrintWriter p, int indent) {
        if (indent != -1)  p.print("(");
        myLhs.unparse(p, 0);
        p.print(" = ");
        myExp.unparse(p, 0);
        if (indent != -1)  p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myLhs.algoNames(symt);
        myExp.algoNames(symt);
    }

    private ExpNode myLhs;
    private ExpNode myExp;
}

class CallExpNode extends ExpNode {
    public CallExpNode(IdNode name, ExpListNode elist) {
        myId = name;
        myExpList = elist;
    }

    public CallExpNode(IdNode name) {
        myId = name;
        myExpList = new ExpListNode(new LinkedList<ExpNode>());
    }

    public void unparse(PrintWriter p, int indent) {
        myId.unparse(p, 0);
        p.print("(");
        if (myExpList != null) {
            myExpList.unparse(p, 0);
        }
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myId.algoNames(symt);
        if(myExpList != null)
        myExpList.algoNames(symt);
    }

    private IdNode myId;
    private ExpListNode myExpList;  
}

abstract class UnaryExpNode extends ExpNode {
    public UnaryExpNode(ExpNode exp) {
        myExp = exp;
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp.algoNames(symt);
    }

    protected ExpNode myExp;
}

abstract class BinaryExpNode extends ExpNode {
    public BinaryExpNode(ExpNode exp1, ExpNode exp2) {
        myExp1 = exp1;
        myExp2 = exp2;
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp1.algoNames(symt);
        myExp2.algoNames(symt);
    }

    protected ExpNode myExp1;
    protected ExpNode myExp2;
}

// **********************************************************************
// Subclasses of UnaryExpNode
// **********************************************************************

class UnaryMinusNode extends UnaryExpNode {
    public UnaryMinusNode(ExpNode exp) {
        super(exp);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(-");
        myExp.unparse(p, 0);
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp.algoNames(symt);
    }
}

class NotNode extends UnaryExpNode {
    public NotNode(ExpNode exp) {
        super(exp);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(!");
        myExp.unparse(p, 0);
        p.print(")");
    }
    
    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp.algoNames(symt);
    }
}

// **********************************************************************
// Subclasses of BinaryExpNode
// **********************************************************************

class PlusNode extends BinaryExpNode {
    public PlusNode(ExpNode exp1, ExpNode exp2) {
        super(exp1, exp2);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(");
        myExp1.unparse(p, 0);
        p.print(" + ");
        myExp2.unparse(p, 0);
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp1.algoNames(symt);
        myExp2.algoNames(symt);
    }
}

class MinusNode extends BinaryExpNode {
    public MinusNode(ExpNode exp1, ExpNode exp2) {
        super(exp1, exp2);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(");
        myExp1.unparse(p, 0);
        p.print(" - ");
        myExp2.unparse(p, 0);
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp1.algoNames(symt);
        myExp2.algoNames(symt);
    }
}

class TimesNode extends BinaryExpNode {
    public TimesNode(ExpNode exp1, ExpNode exp2) {
        super(exp1, exp2);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(");
        myExp1.unparse(p, 0);
        p.print(" * ");
        myExp2.unparse(p, 0);
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp1.algoNames(symt);
        myExp2.algoNames(symt);
    }
}

class DivideNode extends BinaryExpNode {
    public DivideNode(ExpNode exp1, ExpNode exp2) {
        super(exp1, exp2);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(");
        myExp1.unparse(p, 0);
        p.print(" / ");
        myExp2.unparse(p, 0);
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp1.algoNames(symt);
        myExp2.algoNames(symt);
    }
}

class AndNode extends BinaryExpNode {
    public AndNode(ExpNode exp1, ExpNode exp2) {
        super(exp1, exp2);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(");
        myExp1.unparse(p, 0);
        p.print(" && ");
        myExp2.unparse(p, 0);
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp1.algoNames(symt);
        myExp2.algoNames(symt);
    }
}

class OrNode extends BinaryExpNode {
    public OrNode(ExpNode exp1, ExpNode exp2) {
        super(exp1, exp2);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(");
        myExp1.unparse(p, 0);
        p.print(" || ");
        myExp2.unparse(p, 0);
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp1.algoNames(symt);
        myExp2.algoNames(symt);
    }
}

class EqualsNode extends BinaryExpNode {
    public EqualsNode(ExpNode exp1, ExpNode exp2) {
        super(exp1, exp2);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(");
        myExp1.unparse(p, 0);
        p.print(" == ");
        myExp2.unparse(p, 0);
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp1.algoNames(symt);
        myExp2.algoNames(symt);
    }
}

class NotEqualsNode extends BinaryExpNode {
    public NotEqualsNode(ExpNode exp1, ExpNode exp2) {
        super(exp1, exp2);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(");
        myExp1.unparse(p, 0);
        p.print(" != ");
        myExp2.unparse(p, 0);
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp1.algoNames(symt);
        myExp2.algoNames(symt);
    }
}

class LessNode extends BinaryExpNode {
    public LessNode(ExpNode exp1, ExpNode exp2) {
        super(exp1, exp2);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(");
        myExp1.unparse(p, 0);
        p.print(" < ");
        myExp2.unparse(p, 0);
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp1.algoNames(symt);
        myExp2.algoNames(symt);
    }
}

class GreaterNode extends BinaryExpNode {
    public GreaterNode(ExpNode exp1, ExpNode exp2) {
        super(exp1, exp2);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(");
        myExp1.unparse(p, 0);
        p.print(" > ");
        myExp2.unparse(p, 0);
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp1.algoNames(symt);
        myExp2.algoNames(symt);
    }
}

class LessEqNode extends BinaryExpNode {
    public LessEqNode(ExpNode exp1, ExpNode exp2) {
        super(exp1, exp2);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(");
        myExp1.unparse(p, 0);
        p.print(" <= ");
        myExp2.unparse(p, 0);
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp1.algoNames(symt);
        myExp2.algoNames(symt);
    }
}

class GreaterEqNode extends BinaryExpNode {
    public GreaterEqNode(ExpNode exp1, ExpNode exp2) {
        super(exp1, exp2);
    }

    public void unparse(PrintWriter p, int indent) {
        p.print("(");
        myExp1.unparse(p, 0);
        p.print(" >= ");
        myExp2.unparse(p, 0);
        p.print(")");
    }

    public void algoNames(SymTable symt) throws EmptySymTableException {
        myExp1.algoNames(symt);
        myExp2.algoNames(symt);
    }
}
