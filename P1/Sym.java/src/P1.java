// --== CS536 Project File Header ==--
// Name: <Vue Thao>
// CSL Username: <vue>
// Email: <vthao23@wisc.edu>
// Lecture #: <001 @2:30pm>

/**
 * P1 personal 
 * This class tests all of the Sym and SymTable operations and all 
 * situations under which exceptions are thrown.
 * Testing both “boundary” and “non-boundary” cases.
 * The one exception to this approach is that P1.java will need to test 
 * the print method of the SymTable class and that will cause an
 * output to be produced.
 *
 */
public class P1 {
    
    public static void main(String[] args) {
        testSym();
        testSymTableConstructor();
        testAddDecl();
        testAddScope();
        testLookupLocal(); 
        testLookupGlobal(); 
        testRemoveScope();
        testPrint();
    }

    /**
     * Test the methods of the class Sym()
     */
    private static void testSym() {
        // Test the constructor of Sym
        try {
            Sym sym = new Sym("symType");
        } catch (Exception e) {
            System.out.println("testSym: Unexpected exception thrown");
        }
    
        // Test the getType() method for Sym
        try {
            Sym sym = new Sym("symType");          
            if (!sym.getType().equals("symType")) {
                System.out.println("testSymGetType: Incorrect type");
            }
        } catch (Exception e) {
            System.out.println("testSymGetType: Unexpected exception thrown");
        }
        
        // Test the toString() method for Sym
        try {
            Sym sym = new Sym("symType");
            if (!sym.toString().equals("symType")) {
                System.out.println("testSymToString: Incorrect type");
            }
        } catch (Exception e) {
            System.out.println("testSymToString: Unexpected exception thrown");
        }
    }


    /**
     * Test the constructor of SymTable()
     */
    private static void testSymTableConstructor() {
        try {
            SymTable symTable = new SymTable();
        } catch (Exception e) {
            System.out.println("testConstructor: Unexpected exception thrown");
        }
    }

    /**
     * Test the AddDecl() method of SymTable()
     */
    private static void testAddDecl() {
        // addDecl should throw EmptySymTableException when 
        // symbol table is empty
        try {
            SymTable symTable = new SymTable();
            symTable.removeScope();
            symTable.addDecl("Name", new Sym("symType"));
            System.out.println("testAddDecl: " +
                    "Empty exception is not thrown when table is empty");
        } catch (EmptySymTableException e) {
            // This should happen
        } catch (Exception e) {
            System.out.println("testAddDecl: Unexpected exception thrown");
        }
        
        // addDecl should throw IllegalArgumentException when Name is null
        try {
            SymTable symTable = new SymTable();
            symTable.addDecl(null, new Sym("symType"));
        } catch (IllegalArgumentException e) {
            // This should happen 
        } catch (Exception e) {
            System.out.println("testAddDecl: Unexpected exception thrown");
        }
        
        // addDecl should throw IllegalArgumentException when sym is null
        try {
            SymTable symTable = new SymTable();
            symTable.addDecl("Name", null);
        } catch (IllegalArgumentException e) {
            // This should happen
        } catch (Exception e) {
            System.out.println("testAddDecl: Unexpected exception thrown");
        }
    
        // addDecl should throw IllegalArgumentException when
        // both Name and sym are null
        try {
            SymTable symTable = new SymTable();
            symTable.addDecl(null, null);
        } catch (IllegalArgumentException e) {
            // This should happen
        } catch (Exception e) {
            System.out.println("testAddDecl: Unexpected exception thrown");
        }
    
        // addDecl should throw DuplicateSymException when 
        // sym with duplicate Name are inserted
        try {
            SymTable symTable = new SymTable();
            symTable.addDecl("Name", new Sym("1"));
            symTable.addDecl("Name", new Sym("2"));
        } catch (DuplicateSymException e) {
            // This should happen
        } catch (Exception e) {
            System.out.println("testAddDecl: Unexpected exception thrown");
        }
    
        // addDecl should not throw any exception if working normally
        try {
            SymTable symTable = new SymTable();
            symTable.addDecl("NameX", new Sym("X"));
            symTable.addDecl("NameY", new Sym("Y"));
            symTable.addDecl("NameZ", new Sym("Z"));
            Sym sym = symTable.lookupLocal("NameZ");
            if (sym == null) {
                System.out.println("testLookupLocal: name not found");
            }
        } catch (Exception e) {
            System.out.println("testAddDecl: Unexpected exception thrown");
        }
    }

    /**
     * Test the AddScope() method of SymTable()
     */
    private static void testAddScope() {
        // addScope should not throw any exception if working normally
        try {
            SymTable symTable = new SymTable();
            symTable.addScope();
            symTable.addScope(); 
        } catch (Exception e) {
            System.out.println("testAddScope: Unexpected exception thrown");
        }

        // Test if doing local search after adding a scope will find anything.
        try{
            SymTable symTable = new SymTable();
            symTable.addDecl("Name", new Sym("11"));
            symTable.addScope();
            //Should not find anything
            if (symTable.lookupLocal("Name") != null) {
                System.out.println("testAddScope: After adding a new scope and doing local search, " +
                "got an invalid value when expecting a null");
            }
        }catch (Exception e){
            System.out.println("testAddScope: Unexpected exception thrown");
        }
    }

    /**
     * Test the LookupLocal() method of SymTable()
     */
    private static void testLookupLocal() {
        // lookupLocal should throw EmptySymTableException when table is empty
        try {
            SymTable symTable = new SymTable();
            symTable.removeScope();
            symTable.lookupLocal("Name");
            System.out.println("testLookupLocal: " +
                    "Empty exception is not thrown when table is empty");
        } catch (EmptySymTableException e) {
            // This should happen
        } catch (Exception e) {
            System.out.println("testLookupLocal: Unexpected exception thrown");
        }

        // correctly return the correct local sym and not throw any exceptions
        try {
            SymTable symTable = new SymTable();
            symTable.addDecl("Name1", new Sym("11"));
            symTable.addDecl("Name2", new Sym("22"));
            symTable.addScope();
            symTable.addDecl("Name1", new Sym("1"));
            symTable.addDecl("Name2", new Sym("2"));

            Sym sym = symTable.lookupLocal("Name2");
            if (sym == null) {
                System.out.println("testLookupLocal: sym not found");
            } else if (!sym.getType().equals("2")) {
                System.out.println("testLookupLocal: Incorrect sym found");
            }
        } catch (Exception e) {
            System.out.println("testLookupLocal: Unexpected exception thrown");
        }

        // should return null when name not found locally
        try {
            SymTable symTable = new SymTable();
            symTable.addDecl("NameX", new Sym("X"));
            symTable.addDecl("NameY", new Sym("Y"));
            symTable.addScope(); // new map, local
            symTable.addDecl("NameZ", new Sym("Z"));
            Sym sym = symTable.lookupLocal("NameX");
            if (sym != null) {
                System.out.println("testLookupLocal: name should not have been found "
                    + " but returned a non-null name");
            }
        } catch (Exception e) {
            System.out.println("testLookupLocal: Unexpected exception thrown");
        }
    }

    /**
     * Test the LookupGlobal() method of SymTable()
     */
    private static void testLookupGlobal() {
        // lookupGlobal should throw EmptySymTableException when table is empty
        try {
            SymTable symTable = new SymTable();
            symTable.removeScope();
            symTable.lookupGlobal("Name");
            System.out.println("testLookupGlobal: " +
                    "Empty exception is not thrown when table is empty");
        } catch (EmptySymTableException e) {
            // This should happen
        } catch (Exception e) {
            System.out.println("testLookupGlobal: Unexpected exception thrown");
        }

        // lookupGlobal should correctly return the correct sym and not throw any exceptions
        try {
            SymTable symTable = new SymTable();
            symTable.addScope(); // Map 1
            Sym symOne = new Sym("int");
            symTable.addDecl("Name1", symOne);
            symTable.addScope(); // Map 2
            Sym symTwo = new Sym("Char"); 
            symTable.addDecl("Name2", symTwo);
            symTable.addDecl("Name5", symTwo);
            symTable.addScope(); // Local Map 3
            Sym symThree = new Sym("double");
            symTable.addDecl("Name3", symThree);

            if (symTable.lookupLocal("Name1") != null) {
                System.out.println("testLookupGlobal: lookupLocal " +
                        "found a non-null name when in Map 1 non-local");
            }
            if (symTable.lookupGlobal("Name1") != symOne) {
                System.out.println("testLookupGlobal: lookupGlobal " +
                "did not find the correct name with specific sym in Map 1");
            }

            if (symTable.lookupLocal("Name2") != null) {
                System.out.println("testLookupGlobal: lookupLocal " +
                "found a non-null name when in Map 2 non-local");
            }
            if (symTable.lookupLocal("Name5") != null) {
                System.out.println("testLookupGlobal: lookupLocal " +
                "found a non-null name when in Map 2 non-local");
            }
            if (symTable.lookupGlobal("Name5") != symTwo) {
                System.out.println("testLookupGlobal: lookupGlobal " +
                "did not find the correct name with specific sym in Map 2");
            }

            if (symTable.lookupLocal("Name3") != symThree) {
                System.out.println("testLookupGlobal: lookupLocal " +
                        "did not find name with correct sym in local map");
            }
            if (symTable.lookupGlobal("Name3") != symThree) {
                System.out.println("testLookupGlobal: lookupGlobal " +
                "did not find the correct name with specific sym in Map 3");
            }
        } catch (EmptySymTableException e) {
            System.out.println("testLookupGlobal: Empty excpetion should not be thrown");
        } catch (Exception e) {
            System.out.println("testLookupGlobal: Unexpected exception thrown");
        }
    
        // lookupGlobal should return null when name not found globally
        try {
            SymTable symTable = new SymTable();
            symTable.addDecl("NameX", new Sym("X"));
            symTable.addDecl("NameY", new Sym("Y"));
            Sym sym = symTable.lookupGlobal("NameAABB");
            if (sym != null) {
                System.out.println("testLookupGlobal: name should not have been found "
                    + "but returned a non-null name");
            }
        } catch (Exception e) {
            System.out.println("testLookupGlobal: Unexpected exception thrown");
        }
    }

    /**
     * Test the RemoveScope() method of SymTable()
     */
    private static void testRemoveScope() {
        // should throw EmptySymTableException when scope is empty
        try {
            SymTable symTable = new SymTable();
            symTable.addScope(); 
            symTable.removeScope();
            symTable.removeScope();
            symTable.removeScope(); // should catch emtpy exception before getting to next line
            symTable.addScope(); 
            System.out.println("testRemoveScope: " +
                    "Empty exception is not thrown when table is empty");
        } catch (EmptySymTableException e) {
            // This should happen
        } catch (Exception e) {
            System.out.println("testRemoveScope: Unexpected exception thrown");
        }

        // should not throw exception when scope is not empty
        try {
            SymTable symTable = new SymTable();
            symTable.addScope(); 
            symTable.addScope(); 
            symTable.addScope(); 
            symTable.removeScope();
        } catch (EmptySymTableException e) {
            System.out.println("testRemoveScope: Table should not be empty");
        } catch (Exception e) {
            System.out.println("testRemoveScope: Unexpected exception thrown");
        }
    }

    /**
     * Test the print() method of SymTable()
     */
    private static void testPrint() {
        // print should not thrown any exception and should print out expected output
        try {
            SymTable symTable = new SymTable();
            symTable.print();
        } catch (Exception e) {
            System.out.println("testPrint: Unexpected exception thrown");
        }
    }
}