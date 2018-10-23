/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;
import java.io.*;
/*
* Interpreter class runs the interpreter:
* 1. Perform all initializations
* 2. Load the bytecodes from file
* 3. Run the virtual machine
*/
/**
 *
 * @author mt
 */
public class Interpreter {

    /**
     * @param args the command line arguments
     */
  private ByteCodeLoader bcl;
        public Interpreter(String codeFile) {
            try {
            CodeTable.init();
            bcl = new ByteCodeLoader(codeFile);            
            } catch (IOException e) {
            System.out.println("**** " + e);
            }
        }
        void run() {
            Program program = bcl.loadCodes();
            VirtualMachine vm = new VirtualMachine(program);
            vm.executeProgram();
        }
        public static void main(String args[]) {
            if (args.length == 0) {
            System.out.println("***Incorrect usage, try: java interpreter.Interpreter <file>");
            System.exit(1);
            }
            (new Interpreter(args[0])).run();
           //(new Interpreter("D:/java/interpreter/src/interpreter/zByteCodes.txt")).run();
        }
    
}
