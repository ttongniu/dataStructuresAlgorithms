package com.java.ntt.datastructures.linearlist;

/**
 * @author niutongtong
 * @Title: LinkStack
 * @ProjectName dataStructuresAlgorithms
 * @Description: 链栈(LinkStack)用链表来实现，主要有四个元素：2状态2操作。
 * 2状态：栈空？；栈满（逻辑上永远都不会栈满，除非你的电脑没内存了^_^）。
 * 2操作：压栈push；弹栈pop。
 *
 * 栈结构是很基本的一种数据结构，所以栈的应用也很常见，根据栈结构“先进后出”的特点，
 * 我们可以在很多场景中使用栈，下面我们就是使用上面我们已经实现的栈进行一些常见的应用：
 * 十进制转N进制、行编辑器、校验括号是否匹配、中缀表达式转后缀表达式、表达式求值等
 * @date 2018/11/189:29 PM
 */
public class LinkStack<T> {
  /**
   * 栈顶节点
   */
  private LinkNode<T> top;


  private LinkStack(){
    this.top=new LinkNode<T>();
  }
  /**
  　　* @Description: 初始化栈
  　　* @param ${tags}
  　　* @return ${return_type}
  　　* @throws
  　　* @author ${ntt}
  　　* @date 2018/11/18 10:04 PM
  　　*/
  private void  initStack(){
    this.top.setData(null);
    this.top.setNext(null);
  }

  /**
  　　* @Description: 是否栈空
  　　* @param ${tags}
  　　* @return ${return_type}
  　　* @throws
  　　* @author ${ntt}
  　　* @date 2018/11/18 10:05 PM
  　　*/

  public boolean isEmpty(){
    return top.getNext()==null?true:false;
  }
 /**
 　　* @Description: 压栈
 　　* @param ${tags}
 　　* @return ${return_type}
 　　* @throws
 　　* @author ${ntt}
 　　* @date 2018/11/18 10:04 PM
 　　*/
 public void push(LinkNode<T> node){
    if(isEmpty()){
      //栈空 则为第一次插入
      top.setNext(node);
      node.setNext(null);

    }else{
      node.setNext(top.getNext());
      top.setNext(node);
    }
 }
/**
　　* @Description: 弹栈
　　* @param ${tags}
　　* @return ${return_type}
　　* @throws
　　* @author ${ntt}
　　* @date 2018/11/18 10:03 PM
　　*/

 public LinkNode<T> pop(){
    if(isEmpty()){
      //为栈空 无法弹栈
      return null;
    }else {
      LinkNode<T> node = top.getNext();
      top.setNext(top.getNext().getNext());
      return  node;
    }
 }

}
