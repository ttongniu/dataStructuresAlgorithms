package com.java.ntt.datastructures.linearlist;

/**
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 *
 * @author niutongtong
 * @Title: SinglyLikedList
 * @ProjectName dataStructuresAlgorithms
 * @Description:单链表的插入、删除、查找操作；
 * 以及回文字符串问题
 * @date 2018/12/4  11:28 PM
 */
public class SinglyLikedList<T> {

  private   LinkNode<T>  head=null;
  /** 
    * 方法描述: 查找
    * @Author: niutongtong
    * @Date: 2018/12/4 11:51 PM
    * @Param: [t]
    * @return: com.java.ntt.datastructures.linearlist.LinkNode
    */ 
  public LinkNode findByValue(T t){
    LinkNode p=head;
    while (p!=null&&p.getData().equals(t)){
      p=p.getNext();
    }
    return  p;
  }

  /** 
    * 方法描述: 头插入
    * @Author: niutongtong
    * @Date: 2018/12/4 11:51 PM
    * @Param: [node]
    * @return: void
    */ 
   public  void insertToHead(LinkNode node){
    if(head==null){
       head=node;
    }else{
       node.setNext(head);
       head=node;
    }
   }
  /** 
    * 方法描述: 尾插入
    * @Author: niutongtong
    * @Date: 2018/12/4 11:51 PM
    * @Param: [node]
    * @return: void
    */ 
   public void insertToTail(LinkNode node){
    if(head==null){
      head=node;
    }else {
      LinkNode p=head;
      while (p.getNext()!=null){
        p=p.getNext();
      }
      node.setNext(p.getNext());
      p.setNext(node);
    }
   }




}
