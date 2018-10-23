/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bytecode;

import interpreter.RunTimeStack;
import interpreter.VirtualMachine;
import java.util.Scanner;

/**
 *
 * @author mt
 */
public class ReadCode extends ByteCode{

    @Override
    public void execute(VirtualMachine aThis) {
       RunTimeStack rts=aThis.get_rts();
       // try{
        Scanner sc=new Scanner(System.in);
        System.out.println("'READ'-Enter a value to continue: ");
        int x=sc.nextInt();
        if(x<0){
            System.out.println("Can't add a negative number.");
        }
        rts.push(x);
        aThis.update_rts(rts);
        /*}catch(Exception e){
            System.out.println("Not a valid integer for command 'READ': "+e);
        }*/
    }
    
    
}
