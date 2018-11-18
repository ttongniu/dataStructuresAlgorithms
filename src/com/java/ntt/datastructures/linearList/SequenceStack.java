package com.java.ntt.datastructures.linearlist;

/**
 * @author niutongtong
 * @Title: SequenceStack
 * @ProjectName dataStructuresAlgorithms
 * @Description:  顺序栈(SqStack)一般用数组来实现，主要有四个元素：2状态2操作。
 * 2状态：栈空？；栈满？
 * 2操作：压栈push；弹栈pop。
 * @date 2018/11/189:06 PM
 */
public class SequenceStack<T> {
  /**
   * /用数组表示栈元素
   */

  private T data[];
  /**
   * 栈空间大小
   */
  private int maxSize;
  /**
   * 栈顶指针
   */
  private int top;


  public SequenceStack(int maxSize){
      this.maxSize=maxSize;
      this.data= (T[]) new Object[maxSize];
      //有的书中使用0，但这样会占用一个内存
      this.top=-1;

  }

  public  SequenceStack(){

  }

  /**
  　　* @Description: 是否栈空
  　　* @param ${tags}
  　　* @return ${return_type}
  　　* @throws
  　　* @author ${ntt}
  　　* @date 2018/11/18 9:22 PM
  　　*/
  public boolean isEmpty(){
    return  top<=-1?true:false;
  }

  /**
  　　* @Description: 是否栈满
  　　* @param ${tags}
  　　* @return ${return_type}
  　　* @throws
  　　* @author ${ntt}
  　　* @date 2018/11/18 9:23 PM
  　　*/
  public boolean isFull(){
    return  top==maxSize-1?true:false;
  }

 /**
 　　* @Description: 压栈
 　　* @param ${tags}
 　　* @return ${return_type}
 　　* @throws
 　　* @author ${ntt}
 　　* @date 2018/11/18 9:23 PM
 　　*/
  public boolean push(T t){
    if(isFull()){
      return  false;
    }else{
      data[++top] =t;
      return  true;
    }

  }

  /**
  　　* @Description: 弹栈
  　　* @param ${tags}
  　　* @return ${return_type}
  　　* @throws
  　　* @author ${ntt}
  　　* @date 2018/11/18 9:23 PM
  　　*/
  public T pop(){
     if(isEmpty()){
       return  null;
     }else{
        T t=data[top];
        --top;
        return t;
     }
  }


  public static void main(String[] args) {

    //初始化栈(char类型)
    SequenceStack<Character> stack = new SequenceStack<>(10);

    //2状态
    System.out.println("栈是否为空："+stack.isEmpty());
    System.out.println("栈是否已满："+stack.isFull());

    //2操作
    //依次压栈
    stack.push('a');
    stack.push('b');
    stack.push('c');
    //依次弹栈
    System.out.println("弹栈顺序：");
    System.out.println(stack.pop());
    System.out.println(stack.pop());
    System.out.println(stack.pop());

  }

}
