import java.util.ArrayList;
import java.util.List;

public class TSym {
    private String type;
    
    public TSym(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String toString() {
        return type;
    }
}

class TypeDeclSym extends TSym {
	private TypeSymDef core;

	public TypeDeclSym(TypeSymDef core, String nameID) {
		super(nameID);
		this.core = core;
	}        

	public TypeSymDef getCore() {
		return this.core;
	}
}

class TypeSymDef extends TSym {
	private String type;
	private SymTable structList;

	public TypeSymDef(SymTable s, String type) {
		super(type);
		this.type = type;
        this.structList = s;
	}        

	public String getType() {
		return type;
	}
	
	public SymTable getList() {
		return this.structList;
	}

	public String toString() {
		return type;
	}
}

class FuncTSym extends TSym {
	private String type;
	private TSym param;
    List<String> theList;

	public FuncTSym(TSym param, String type) {
		super(type);
		this.type = type;
        this.param = param;
        theList = new ArrayList<>();
	}        

	@Override
	public String getType() {
        if(theList.size() == 0)
            return "->" + this.param.getType();
        String format = "";
        for(int i = 0;i < this.theList.size();i++) {
            if(i == theList.size() - 1)
                format += this.theList.get(i) + "->" + this.param.getType();
            else
                format += this.theList.get(i) + ",";
        }
        return format;
	}

	public void addFormals(String type) {
        this.theList.add(type);
    }

	public String toString() {
		return type;
	}
}
