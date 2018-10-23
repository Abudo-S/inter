/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interpreter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 *
 * @author mt
 */
public class RunTimeStack {
    private Stack<Integer> FramePointer=new Stack<Integer>();//used for each index of stack beginning
    private  ArrayList<Integer> runStack=new ArrayList<Integer>();
    public RunTimeStack(){
        
    }
    public void dump(){
        String st="";
       int size=this.get_frameP_size();
       String[] all=new String[size];
       int start=0;
       int end=0;
       int rts_size=this.get_size();
       for(int j=0;j<size;j++){
           end=rts_size;
            st+="[ ";
            start=this.FramePointer.get(j);
            if(j!=(size-1)){
                end=this.FramePointer.get(j+1);
            }
           // System.out.println(start+","+end);
           // System.out.println(rts_size+","+this.FramePointer.get(j));
            for(int i=start;i<end;i++){
                st+=this.runStack.get((i));
                if(i!=(end-1)){
                 st+=",";
                }
            }
            st+="] ";
            all[j]=st;
            st="";
        }
       for(String x: all){
       System.out.print(x);
       }
       System.out.println();
    }
    public int peek(){
        if(this.get_size()==0){
            return -1;
        }
        return this.runStack.get(this.runStack.size()-1);
    }
    public int pop(){
        int siz=this.runStack.size()-1;
        int x=-1;
         if(siz>=0){
            x=this.runStack.get(siz);
            this.runStack.remove(siz);
            /*if(FramePointer.size()>0){ //remove a frame pointer when it's empty
                int y=this.FramePointer.peek();
                if((siz)<y){
                    this.FramePointer.pop();
                }
            }*/
        }
        return x;
    }
    public int push(int i){
        if(this.get_frameP_size()==0){
            this.newFrameAt(0);
        }
        this.runStack.add(i);
        return i;
    }
    public void newFrameAt(int offset){
        offset=this.get_size()-offset;
       if(offset<=this.get_size())
        this.FramePointer.add(offset);
       //System.out.println("sys:"+offset);
    
    }
    public int[] popFrame(){
      //  int x=this.peek();
        int first=this.FramePointer.pop();
        int dif=this.runStack.size()-first;
        //System.out.println(dif);
        int[] res=new int[dif];
        int i=0;
        //System.out.println(first);
        while(dif>0){
            res[i]=this.pop();
            dif--;
            i++;
        }
        return res;
    } 
    public int store(int offset){
        int x=-1;
        int z=offset+this.FramePointer.peek();
        //System.out.println("+++"+z);
        if(z<this.runStack.size()){
            x=this.pop();
         this.runStack.set(z,x);
        }
        return x;
    }
    public int load(int offset){
        int x=-1;
        int z=this.FramePointer.peek()+offset;
        //System.out.println(this.FramePointer.size());
         if(z<this.runStack.size()){
             x=this.runStack.get(z);
            //this.runStack.remove(z);
            this.push(x);
         }         
        return x;
    }
    public Integer push(Integer val){       
        return this.push((int)val);
    }
    public int get_size(){
        return this.runStack.size();
    }
    public int get_frameP_size(){
        return this.FramePointer.size();
    }
    public int popFP(){
        return this.FramePointer.pop();
    }
     public int peekFP(){
        return this.FramePointer.peek();
    }
     public void clear(){
         this.runStack.clear();
         this.FramePointer.clear();
     }
     public void add_dir_fp(int x){
         this.FramePointer.push(x);
     }
}
