package com.java.ntt.datastructures.linearlist;

/**
 * @author niutongtong
 * @Title: LinkStack
 * @ProjectName dataStructuresAlgorithms
 * @Description: 链栈(LinkStack)用链表来实现，主要有四个元素：2状态2操作。
 * 2状态：栈空？；栈满（逻辑上永远都不会栈满，除非你的电脑没内存了^_^）。
 * 2操作：压栈push；弹栈pop。
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
    this.top.data=null;
    this.top.next=null;
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
    return top.next==null?true:false;
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


  class LinkNode<T>{
    /**
     * 数据域
     */
    private T data;
    /**
     * 指针域
     */
    private LinkNode<T> next;

    public LinkNode(){
      this.data=null;
      this.next=null;
    }

    public  LinkNode(T t){
      super();
      this.data=t;
      this.next=null;
    }


    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }

    public LinkNode<T> getNext() {
      return next;
    }

    public void setNext(LinkNode<T> next) {
      this.next = next;
    }


  }



}
