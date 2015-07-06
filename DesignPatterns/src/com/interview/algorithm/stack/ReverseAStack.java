package com.interview.algorithm.stack;


/**
 * void insert_at_bottom(node **stack, int data)
{
     if( isempty(*stack) ){
          push(stack,data);
          return;
     }
     int temp=pop(stack);
     insert_at_bottom(stack,data);
     push(stack,temp);
}  


void rev_stack(node **stack)
{
     if( isempty(*stack) ) return;
     int temp = pop(stack);
     rev_stack(stack);
     insert_at_bottom(stack,temp);
}
 * @author Varun
 *
 */
public class ReverseAStack {

}
