// --== CS536 Project 2 File Header ==--
// Name: <Vue Thao>
// CSL Username: <vue>
// Email: <vthao23@wisc.edu>
// Lecture #: <001 @2:30pm>

import java.util.*;
import java.io.*;
import java_cup.runtime.*;  // defines Symbol

/** ͙
 * This program is to be used to test the Gibberish scanner.
 * This version is set up to test all tokens, but you are required to test 
 * other aspects of the scanner (e.g., input that causes errors, character 
 * numbers, values associated with tokens)
 */
public class P2 {
    public static void main(String[] args) throws IOException {
        // exception may be thrown by yylex
        // test all tokens
        System.out.println("testAllTokens");
        testAllTokens();
        CharNum.num = 1;
        
        // tests end of file 
		System.out.println("eofTester");
		eofTester();
		CharNum.num = 1;	
    }

    /**
     * eofTester
     *
     * open and read from file eof 
     * Check that eof is reached and output message "EOF has been reached" to eofTest.out 
     * if input file contains eof, then output recieves a message 
     * if otherwise output file is blank
     */
	private static void eofTester() throws IOException {
		FileReader inFile = null;
		PrintWriter outFile = null;
		try {
			inFile = new FileReader("eofTest.in");
			outFile = new PrintWriter(new FileWriter("eofTest.out"));
		} catch (FileNotFoundException ex) {
			System.err.println("File eofTest.in not found.");
			System.exit(-1);
		} catch (IOException ex) {
			System.err.println("eofTest.out cannot be opened.");
			System.exit(-1);
		}
		Yylex scanner = new Yylex(inFile);
		Symbol token = scanner.next_token();
		while (token.sym != sym.EOF) {
			token = scanner.next_token();
		}
		if (token.sym == sym.EOF){
			outFile.println("EOF has been reached");
		}
		outFile.close();
	}

    /**
     * testAllTokens
     *
     * Open and read from file allTokens.txt
     * For each token read, write the corresponding string to allTokens.out
     * For each token, output the character number and line number as well
     * If the input file contains all tokens, one per line, we can verify
     * correctness of the scanner by comparing the input and output files
     * (e.g., using a 'diff' command).
     */
    private static void testAllTokens() throws IOException {
        // open input and output files
        FileReader inFile = null;
        PrintWriter outFile = null;
        try {
            inFile = new FileReader("allTokens.in");
            outFile = new PrintWriter(new FileWriter("allTokens.out"));
        } catch (FileNotFoundException ex) {
            System.err.println("File allTokens.in not found.");
            System.exit(-1);
        } catch (IOException ex) {
            System.err.println("allTokens.out cannot be opened.");
            System.exit(-1);
        }

        // create and call the scanner
        Yylex scanner = new Yylex(inFile);
        Symbol token = scanner.next_token();
        while (token.sym != sym.EOF) {
            switch (token.sym) {
            case sym.BOOL:
                outFile.print("bool"); 
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
		        break;
			case sym.INT:
                outFile.print("int");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.VOID:
                outFile.print("void");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.TRUE:
                outFile.print("true");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.FALSE:
                outFile.print("false");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.STRUCT:
                outFile.print("struct");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.CIN:
                outFile.print("cin");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.COUT:
                outFile.print("cout");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;				
            case sym.IF:
                outFile.print("if");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.ELSE:
                outFile.print("else");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.WHILE:
                outFile.print("while");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.RETURN:
                outFile.print("return");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.ID:
                outFile.print(((IdTokenVal)token.value).idVal);
                outFile.print(" Line num = ");
                outFile.print(((IdTokenVal)token.value).linenum + " Char num = ");
                outFile.println(((IdTokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.INTLITERAL:  
                outFile.print(((IntLitTokenVal)token.value).intVal);
                outFile.print(" Line num = ");
                outFile.print(((IntLitTokenVal)token.value).linenum + " Char num = ");
                outFile.println(((IntLitTokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.STRINGLITERAL: 
                outFile.print(((StrLitTokenVal)token.value).strVal);
                outFile.print(" Line num = ");
                outFile.print(((StrLitTokenVal)token.value).linenum + " Char num = ");
                outFile.println(((StrLitTokenVal)token.value).charnum + " sym val = " + token.sym);
                break;    
            case sym.LCURLY:
                outFile.print("{");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.RCURLY:
                outFile.print("}");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.LPAREN:
                outFile.print("(");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.RPAREN:
                outFile.print(")");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.SEMICOLON:
                outFile.print(";");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.COMMA:
                outFile.print(",");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.DOT:
                outFile.print(".");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.WRITE:
                outFile.print("<<");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.READ:
                outFile.print(">>");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;				
            case sym.PLUSPLUS:
                outFile.print("++");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.MINUSMINUS:
                outFile.print("--");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;	
            case sym.PLUS:
                outFile.print("+");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.MINUS:
                outFile.print("-");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.TIMES:
                outFile.print("*");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.DIVIDE:
                outFile.print("/");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.NOT:
                outFile.print("!");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.AND:
                outFile.print("&&");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.OR:
                outFile.print("||");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.EQUALS:
                outFile.print("==");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.NOTEQUALS:
                outFile.print("!=");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.LESS:
                outFile.print("<");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
            case sym.GREATER:
                outFile.print(">");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                
                break;
            case sym.LESSEQ:
                outFile.print("<=");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                
                break;
            case sym.GREATEREQ:
                outFile.print(">=");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
			case sym.ASSIGN:
                outFile.print("=");
                outFile.print(" Line num = ");
                outFile.print(((TokenVal)token.value).linenum + " Char num = ");
                outFile.println(((TokenVal)token.value).charnum + " sym val = " + token.sym);
                break;
			default:
				outFile.print("UNKNOWN TOKEN");
            } // end switch

            token = scanner.next_token();
        } // end while
        outFile.close();
    }
}
