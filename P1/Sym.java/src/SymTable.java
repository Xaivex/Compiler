// --== CS536 Project File Header ==--
// Name: <Vue Thao>
// CSL Username: <vue>
// Email: <vthao23@wisc.edu>
// Lecture #: <001 @2:30pm>

import java.util.*;

/*
 * Symbol Table stores the symbols that are in source code.
 */
public class SymTable {

    // List of HashMap storing symbols in different scopes
    private List<HashMap<String, Sym>> symTable = new LinkedList<>();
    
    /*
     * Constructor 
     * It initialize the SymTable's List field to contain 
     * a single, empty HashMap.
     */
    public SymTable() {
        this.symTable.add(new HashMap<>());
    }
    
    /**
     * Adds the given name and sym to the first HashMap in the list.
     * 
     * @param name the added name 
     * @param sym  the added symbol 
     * @throws DuplicateSymException  
     * @throws EmptySymTableException 
     * @throws IllegalArgumentException 
     */
    public void addDecl(String name, Sym sym) throws EmptySymTableException, 
    DuplicateSymException, IllegalArgumentException {
        // If this SymTable's list is empty, throw an EmptySymTableException.
        if (symTable.isEmpty()) {
            throw new EmptySymTableException();
        }
        // If either name or sym (or both) is null, throw a 
        // IllegalArgumentException.
        if (name == null || sym == null) {
            throw new IllegalArgumentException();
        }
        // If the first HashMap in the list already contains the given
        // name as a key, throw a DuplicateSymException.
        if (this.symTable.get(0).containsKey(name)) {
            throw new DuplicateSymException();
        }
        // Add the given name and sym to the first HashMap in the list.
        this.symTable.get(0).put(name, sym);
    }
    
    /**
     *  Add a new, empty HashMap to the front of the list.
     */
    public void addScope() {
        this.symTable.add(0, new HashMap<>());
    }
    
    /**
     * If the first HashMap in the list contains name as a key, return 
     * the associated Sym; otherwise, return null.
     * 
     * @param name the name for a symbol
     * @return the symbol if first HashMap in the list contains
     * specified name as a key, if not found return null
     * @throws EmptySymTableException 
     */
    public Sym lookupLocal(String name) throws EmptySymTableException {
        // If this SymTable's list is empty, throw an EmptySymTableException.
        if (this.symTable.isEmpty()) {
            throw new EmptySymTableException();
        }
        
        return this.symTable.get(0).getOrDefault(name, null);
    }
    
    /**
     * If any HashMap in the list contains name as a key, return the 
     * first associated Sym.
     * 
     * @param name the name for a symbol
     * @return the symbol if the a HashMap in the list contains
     * the specified name as a key, if not found return null
     * @throws EmptySymTableException 
     */
    public Sym lookupGlobal(String name) throws EmptySymTableException {
        // If this SymTable's list is empty, throw an EmptySymTableException.
        if (this.symTable.isEmpty()) {
            throw new EmptySymTableException();
        }
        
        for (HashMap<String, Sym> map : symTable) {
            if (map.containsKey(name)) {
                return map.get(name);
            }
        }
        
        return null;
    }
    
    /**
     * Remove the HashMap from front of the list.
     *
     * @throws EmptySymTableException 
     */
    public void removeScope() throws EmptySymTableException {
        // If this SymTable's list is empty, throw an EmptySymTableException.
        if (this.symTable.isEmpty()) {
            throw new EmptySymTableException();
        }
        // remove hashmap
        this.symTable.remove(0);
    }
    
    /**
     * Prints the HashMaps stored in Symbol Table
     */
    public void print() {
        StringBuilder outputStr = new StringBuilder();
        outputStr.append("\nSym Table\n");
        // for each HashMap M in the list, print M.toString() 
        // followed by a newline.
        for (HashMap<String, Sym> map : symTable) {
            outputStr.append(map.toString());
            outputStr.append("\n");
        }
        outputStr.append("\n");
        System.out.print(outputStr.toString());
        
    }
}