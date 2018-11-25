package com.java.ntt.datastructures.linearlist;

import java.util.NoSuchElementException;

/**
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 *
 * @author niutongtong
 * @Title: LinkQueue
 * @ProjectName dataStructuresAlgorithms
 * @Description:
 * 1.分别设置front和rear指向队头结点和队尾结点，使用单链表的头尾访问时间复杂度为O(1)。
   2.设置初始化空队列，使用front=rear=null，并且约定条件front==null&&rear==null成立时，队列为空。
   3.出队操作时，若队列不为空获取队头结点元素，并删除队头结点元素，更新front指针的指向为front=front.next
   4.入队操作时，使插入元素的结点在rear之后并更新rear指针指向新插入元素。
   5.当第一个元素入队或者最后一个元素出队时，同时更新front指针和rear指针的指向
---------------------
 *
 * @date 2018/11/25  6:04 PM
 */
public class LinkQueue<T>  implements Queue<T>  {
  //front==null&&rear==null时,队列为空
  /**
   * 对头节点
   */
  private LinkNode<T> front;
  /**
   *队尾节点
   */
  private LinkNode<T> rear;

  private int size;
  /**
   * 用于控制最大容量,默认128,offer方法使用
   */
  private int maxSize;


  public LinkQueue(){
    this.front=this.rear=null;
  }




  /**
   * 方法描述:
   *
   * @Author: niutongtong
   * @Date: 2018/11/24 6:42 PM
   * @Param: []
   * @return: int
   */
  @Override
  public int size() {
    return size;
  }

  /**
   * 方法描述:
   *
   * @Author: niutongtong
   * @Date: 2018/11/24 6:43 PM
   * @Param: []
   * @return: boolean
   */
  @Override
  public boolean isEmpty() {
    return this.front==null&&this.rear==null;
  }

  /**
   * 方法描述:
   *
   * @param data
   * @Author: niutongtong
   * @Date: 2018/11/24 6:43 PM
   * @Param: [data]
   * @return: boolean
   */
  @Override
  public boolean add(T data) {
    LinkNode<T> node=new LinkNode<T>(data);
    if(isEmpty()){
        this.front=node;
    }else {
      this.rear.setNext(node);
    }
    this.rear=node;
    size++;
    return true;
  }

  /**
   * 方法描述:
   *
   * @param data
   * @Author: niutongtong
   * @Date: 2018/11/24 6:43 PM
   * @Param: [data]
   * @return: boolean
   */
  @Override
  public boolean offer(T data) {
    if (data==null) {
      throw new NullPointerException("The data can\'t be null");
    }
    if (size>=maxSize) {
      throw new IllegalArgumentException("The capacity of LinkedQueue has reached its maxSize:128");
    }
    return  add(data);
  }

  /**
   * 方法描述:
   *
   * @Author: niutongtong
   * @Date: 2018/11/24 6:43 PM
   * @Param: []
   * @return: T
   */
  @Override
  public T peek() {
    return this.isEmpty()?null:this.front.getData();
  }

  /**
   * 方法描述:
   *
   * @Author: niutongtong
   * @Date: 2018/11/24 6:43 PM
   * @Param: []
   * @return: T
   */
  @Override
  public T element() {
     if(isEmpty()){
       throw new NoSuchElementException("The LinkedQueue is empty");
     }
    return this.front.getData();
  }

  /**
   * 方法描述:
   *
   * @Author: niutongtong
   * @Date: 2018/11/24 6:43 PM
   * @Param: []
   * @return: T
   */
  @Override
  public T poll() {
    if (isEmpty()){
      return null;
    }
    T t=this.front.getData();
    this.front=this.front.getNext();
    if(this.front==null){
      this.rear=null;
    }
    size--;
    return t;
  }

  /**
   * 方法描述:
   *
   * @Author: niutongtong
   * @Date: 2018/11/24 6:43 PM
   * @Param: []
   * @return: T
   */
  @Override
  public T remove() {
    if (isEmpty()){
      throw new NoSuchElementException("The LinkedQueue is empty");
    }
    T t=this.front.getData();
    this.front=this.front.getNext();
    if(this.front==null){
      this.rear=null;
    }
    size--;
    return t;
  }

  /**
   * 方法描述:
   *
   * @Author: niutongtong
   * @Date: 2018/11/24 6:44 PM
   * @Param: []
   * @return: void
   */
  @Override
  public void clearQueue() {
    this.front=this.rear=null;
    size=0;
  }
}
