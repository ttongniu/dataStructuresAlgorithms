package com.java.ntt.datastructures.linearlist;

/**
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 *
 * @author niutongtong
 * @Title: LinkNode
 * @ProjectName dataStructuresAlgorithms
 * @Description:
 * @date 2018/11/25  2:43 PM
 */
public class LinkNode<T> {

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
