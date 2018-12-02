package com.java.ntt.datastructures.linearlist;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 *
 * @author niutongtong
 * @Title: LRULinkedHashMap
 * @ProjectName dataStructuresAlgorithms
 * @Description:
 * 1. 新数据插入到链表头部；
2. 每当缓存命中（即缓存数据被访问），则将数据移到链表头部；
3. 当链表满的时候，将链表尾部的数据丢弃。
分析
【命中率】
当存在热点数据时，LRU的效率很好，但偶发性的、周期性的批量操作会导致LRU命中率急剧下降，缓存污染情况比较严重
LinkedHashMap自身已经实现了顺序存储，默认情况下是按照元素的添加顺序存储，
也可以启用按照访问顺序存储，即最近读取的数据放在最前面，最早读取的数据放在最后面，
然后它还有一个判断是否删除最老数据的方法，默认是返回false，即不删除数据，
我们使用LinkedHashMap实现LRU缓存的方法就是对LinkedHashMap实现简单的扩展，
 */
public class LRULinkedHashMap<K,V> extends LinkedHashMap<K,V>{

    private final int maxCapacity;
    private  static final float DFFAUL_LOAD_FACTOR=0.75f;
    private final Lock lock=new ReentrantLock();
    /** 
  * 方法描述: LinkedHashMap的一个构造函数，
     * 当参数accessOrder为true时，
     * 即会按照访问顺序排序，最近访问的放在最前，最早访问的放在后面
  * @Author: niutongtong
  * @Date: 2018/12/2 5:09 PM
  * @Param: [maxCapacity]
  * @return: 
  */ 
    public LRULinkedHashMap(int maxCapacity){
      super(maxCapacity,DFFAUL_LOAD_FACTOR,true);
      this.maxCapacity = maxCapacity;
    }

  /** 
    * 方法描述: //LinkedHashMap自带的判断是否删除最老的元素方法，默认返回false，即不删除老数据
    * 我们要做的就是重写这个方法，当满足一定条件时删除老数据
    * @Author: niutongtong
    * @Date: 2018/12/2 5:10 PM
    * @Param: [eldest]
    * @return: boolean
    */ 
  @Override
  protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
    return size()>maxCapacity;
  }

  @Override
  public V get(Object key) {
    try {
      lock.lock();
      return super.get(key);
    }finally {
      lock.unlock();
    }

  }

  @Override
  public V put(K key, V value) {
    try{
      lock.lock();
      return super.put(key, value);
    }finally {
      lock.unlock();
    }

  }

  @Override
  public int size() {
    try{
      lock.lock();
      return  super.size();
    }finally {
      lock.unlock();
    }
  }

  @Override
  public void clear() {
   try{
     lock.lock();
     super.clear();
   }finally {
     lock.unlock();
   }
  }

  public Collection<Map.Entry<K, V>> getAll() {
    try {
      lock.lock();
      return new ArrayList<Map.Entry<K, V>>(super.entrySet());
    } finally {
      lock.unlock();
    }
  }

}
