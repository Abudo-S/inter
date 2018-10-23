/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bytecode;

import interpreter.VirtualMachine;

/**
 *
 * @author mt
 */
public class HaltCode extends ByteCode{

    @Override
    public void execute(VirtualMachine aThis) {
        aThis.stop_running();
    } 
}
