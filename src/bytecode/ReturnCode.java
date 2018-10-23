/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bytecode;

import interpreter.RunTimeStack;
import interpreter.VirtualMachine;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author mt
 */
public class ReturnCode extends ByteCode{

    @Override
    public void execute(VirtualMachine aThis) {
        RunTimeStack rts=aThis.get_rts();
         int x=rts.peek();      
         rts.popFrame();
         //rts.popFP();  
          //  System.out.println(arr[i]);
          String st="";
          int[] arr;
           Stack<Integer> new_rts_V=new Stack<Integer>();
            Stack<Integer> new_rts_FP=new Stack<Integer>();
         // new_rts.newFrameAt(0);
               rts.push(x);
              int size=rts.get_frameP_size();
              String[] all=new String[size];
          //System.out.println( rts.get_frameP_size());
        while(size>0){
            st+="[ ";
            new_rts_FP.push(rts.peekFP());
             //System.out.println(rts.peekFP());
            arr=rts.popFrame();
            
          // System.out.println(Arrays.toString(arr));
            for(int i=arr.length-1;i>=0;i--){
                if(i==arr.length-1){
                 st+=arr[i];
                }else{
                    st+=","+arr[i];
                }
                //new_rts_V.push(arr[i]);
            }
            for(int i=0;i<arr.length;i++){
                new_rts_V.push(arr[i]);
            }
            st+="] ";
            size--;
            all[size]=st;
            st="";
        }
       // System.out.println(new_rts_FP.size()+","+new_rts_V.size());
        size=new_rts_FP.size();
        for(int i=0;i<size;i++){
           // System.out.println(new_rts_FP.peek());
            rts.add_dir_fp(new_rts_FP.pop());
        }
        size=new_rts_V.size();
        for(int i=0;i<size;i++){
           // System.out.println(new_rts_V.peek());
            rts.push(new_rts_V.pop());
        }
        //System.out.println(rts.get_size()+","+rts.get_frameP_size());
        aThis.update_rts(rts);
        for(String s:all){
         System.out.print(s);
        }
        System.out.println();
        String st1=aThis.get_return_N();
        size=aThis.get_return_add();
        if(size!=-1||!st1.equals("-1"))
        System.out.println("\nreturned from last function call:-"+st1+":"+size);
        //rts.clear();
        
    }
    
   
    
}
