/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bytecode;

import interpreter.RunTimeStack;
import interpreter.VirtualMachine;

/**
 *
 * @author mt
 */
public class BopCode extends ByteCode{

    @Override
    public void execute(VirtualMachine aThis) {
        try{
        RunTimeStack rts=aThis.get_rts();
         String st=this.get_value();
         int y=rts.pop();
         int x=rts.pop(); 
         if(x!=-1&&y!=-1){
         //System.out.println(x+","+y);
       if(st.matches("[+-//*<>=|&]")){
         int z=0;
         if(st.matches(".\\s+")){
             st=st.substring(0,1);
         }
         switch(st){
             case "+":
                 z=x+y;
                 break;
             case "-":
                 z=x-y;
                 break;
             case "/":
                 if(y==0){
                     rts.push(x);
                    System.out.println("'BOP'command:Can't divide by zero&values are pushed again"); 
                 }else{
                    z=x/y;
                 }
                 break;
             case "*":
                 z=x*y;
                 break;
             case "==":
                 if(x==y){
                     z=1;
                 }else{
                     z=0;
                 }
                 break; 
              case "!=":
                  if(x!=y){
                      z=1;
                  }else{
                      z=0;
                  }
                 break;
              case "<=":
                  if(x<=y){
                      z=1;
                  }else{
                      z=0;
                  }
                 break; 
              case ">":
                  if(x>y){
                      z=1;
                  }else{
                      z=0;
                  }
                 break;   
              case ">=":
                  if(x>=y){
                      z=1;
                  }else{
                      z=0;
                  }
                 break;   
               case "<":
                   if(x<y){
                       z=1;
                   }else{
                       z=0;
                   }
                 break;
               case "|":
                   z=x|y;
                 break;
               case "&":
                   z=x&y;
                   break;
         }
         rts.push(z);
         aThis.update_rts(rts);        
       }
       else{
         System.out.println("Can't apply 'PC': "+aThis.cur_pc());
        }
        // for(int i=0;i<RunTimeStack.runStack.size();i++){
         // System.out.println(RunTimeStack.runStack.size());
        //}
       }
        }catch(Exception e){
               System.out.println("Not a valid input for command 'Store': "+e);
        }
     }
}
    
