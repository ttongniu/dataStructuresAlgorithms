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
   /**
     * 方法描述: 按照节点删除
     * @Author: niutongtong
     * @Date: 2018/12/5 11:25 PM
     * @Param: [node]
     * @return: void
     */
    public  void deleteByNode(LinkNode node){
          if(node==null||head==null){
            return;
          }

          if(node==head){
             head=head.getNext();
             return;
          }
         LinkNode q=head;
          //找到它
          while (q!=null&&q.getNext()!=node){
               q=q.getNext();

            }
            //删除它
        q.setNext(q.getNext().getNext());

    }
   /**
     * 方法描述: 按照值删除
     * @Author: niutongtong
     * @Date: 2018/12/5 11:25 PM
     * @Param: [t]
     * @return: void
     */
      public void deleteByValue(T t){

       if (head==null){
         return;
       }
       LinkNode node=head;
       LinkNode q=null;
       while (node!=null&&node.getData()!=t){
           q=node;
           node=node.getNext();

       }
       if(node==null){
         return;
       }

       if(q== null){
        head=head.getNext();
       }else {
         q.setNext(q.getNext().getNext());
       }

   }
    /**
      * 方法描述:
     使用快慢两个指针找到链表中点，慢指针每次前进一步，快指针每次前进两步。在慢指针前进的过程中，同时修改其 next 指针，使得链表前半部分反序。最后比较中点两侧的链表是否相等。
      * @Author: niutongtong
      * @Date: 2018/12/5 11:40 PM
      * @Param: []
      * @return: boolean
      */
   public boolean   isPalindrome(LinkNode node){

     if(node==null||node.getNext()==null){
        return  true;
     }

     LinkNode  prev=null;
     LinkNode fast=node;
     LinkNode slow=node;

     while (fast!=null&&fast.getNext()!=null){
       fast=fast.getNext().getNext();
       LinkNode next=slow.getNext();
       slow.setNext(prev);
       prev=slow;
       slow=next;
     }
    if(fast!=null){
     slow=slow.getNext();
   }

   while (slow!=null){
       if(!slow.getData().equals(prev.getData())){
         return false;
       }
       slow= slow.getNext();
       prev=prev.getNext();
   }
   return true;
   }

}
