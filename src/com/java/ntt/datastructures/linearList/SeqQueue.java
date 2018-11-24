package com.java.ntt.datastructures.linearlist;

import java.util.NoSuchElementException;

/**
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 *
 * @author niutongtong
 * @Title: SeqQueue
 * @ProjectName dataStructuresAlgorithms
 * @Description:
 * 1.front为队头元素的下标，rear则指向下一个入队元素的下标
   2.当front=rear时，我们约定队列为空。
   3.出队操作改变front下标指向，入队操作改变rear下标指向，size代表队列容量。
   4.约定队列满的条件为front=(rear+1)%size,注意此时队列中仍有一个空的位置，此处留一个空位主要用于避免与队列空的条件front=rear相同。
   5.队列内部的数组可扩容，并按照原来队列的次序复制元素数组
 * @date 2018/11/24  6:45 PM
 */
public class SeqQueue<T> implements  Queue<T> {

public static final int  DEFAULT_SIZE=10;

public T[] elementData;

private int  front;

private int rear;

private int size;

  public SeqQueue() {
     this.elementData= (T[]) new Object[DEFAULT_SIZE];
     this.front=this.rear=0;
  }

  public SeqQueue(int capacity){
    this.elementData= (T[]) new Object[capacity];
    this.front=this.rear=0;
  }

  @Override
  public boolean add(T data) {
    //是否队列满
    if(this.front==(this.rear+1)%this.elementData.length){
      ensureCapacity(this.elementData.length*2+1);
    }
    elementData[this.rear]=data;
    rear =(rear+1)%this.elementData.length;
    size++;
    return true;
  }




  @Override
  public boolean isEmpty() {
    return front==rear;
  }


  @Override
  public boolean offer(T data) {
    if(data==null){
      throw  new NullPointerException("this data cannot be null");
    }
    if(this.front==(this.rear+1)%this.elementData.length){
     throw  new IllegalArgumentException("The capacity of SeqQueue has reached its maximum");
    }

    elementData[this.rear]=data;
    rear =(rear+1)%this.elementData.length;
    size++;
    return true;

  }

  @Override
  public int size() {
    return size;
  }

  @Override
  public T element() {
    if(isEmpty()){
      throw  new NoSuchElementException("this Queue is isEmpty!");
    }
    return elementData[front];
  }


  @Override
  public T peek() {
    return elementData[front];
  }

  @Override
  public T poll() {
    T temp=this.elementData[this.front];
    front=(front+1)%this.elementData.length;
    size--;
    return temp;
  }


  @Override
  public T remove() {
    if(isEmpty()){
      throw  new NoSuchElementException("this Queue is empty");
    }
    return poll();
  }


  @Override
  public void clearQueue() {


    for(int i= this.front;i!=this.rear;i=(i+1)%this.elementData.length){
      elementData[i]=null;

    }
    this.front=this.rear=0;
    size=0;

  }

    public void ensureCapacity(int capacity){
    if(capacity<size){
       return;
    }

    T[] old=this.elementData;
    elementData=(T[]) new Object[capacity];

    int j=0;
    for(int i=this.front; i!=this.rear;i=(i+1)%this.elementData.length){
           elementData[j++]=old[i];
    }

    this.front=0;
    this.rear=j;

  }


  public static void main(String[] args) {

  }

}



