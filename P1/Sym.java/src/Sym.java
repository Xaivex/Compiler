// --== CS536 Project File Header ==--
// Name: <Vue Thao>
// CSL Username: <vue>
// Email: <vthao23@wisc.edu>
// Lecture #: <001 @2:30pm>

/**
 * This class represents a symbol in a symbol table
 * Sym will be the type of the identifier, represented 
 * using a String.
 */
public class Sym {

    /**
     * The type of the symbol
     */
    private String type;

    /**
     * Constructor Sym
     * Initialize the Sym to have the given type
     *
     * @param type the type of the symbol
     */
    public Sym(String type) {
        this.type = type;
    }
    
    /**
     * @return this Sym's type
     */
    public String getType() {
        return this.type;
    }
    
    /**
     * @return the string of the object
     * Return this Sym's type
     */
    @Override
    public String toString() {
        return this.type;
    }
}