package com.java.ntt.datastructures.linearlist;

/**
 * When I wrote this, only God and I understood what I was doing
 * Now, God only knows
 *
 * @author niutongtong
 * @Title: Queue
 * @ProjectName dataStructuresAlgorithms
 * @Description:
 * @date 2018/11/24  4:55 PM
 */
public interface Queue<T> {
   /** 
     * 方法描述:  返回队列长度
     * @Author: niutongtong
     * @Date: 2018/11/24 6:42 PM
     * @Param: []
     * @return: int
     */ 
   int size();
   /** 
     * 方法描述: 判断队列是否为空
     * @Author: niutongtong
     * @Date: 2018/11/24 6:43 PM
     * @Param: []
     * @return: boolean
     */ 
   boolean isEmpty();
   /** 
     * 方法描述: data 入队,添加成功返回true,否则返回false,可扩容
     * @Author: niutongtong
     * @Date: 2018/11/24 6:43 PM
     * @Param: [data]
     * @return: boolean
     */ 
   boolean add(T data);
   /** 
     * 方法描述: offer 方法可插入一个元素,这与add 方法不同，
    * 该方法只能通过抛出未经检查的异常使添加元素失败。
    * 而不是出现异常的情况，例如在容量固定（有界）的队列中
    * NullPointerException:data==null时抛出
     * @Author: niutongtong
     * @Date: 2018/11/24 6:43 PM
     * @Param: [data]
     * @return: boolean
     */ 

   boolean offer(T data);
  /** 
    * 方法描述: 返回队头元素,不执行删除操作,若队列为空,返回null
    * @Author: niutongtong
    * @Date: 2018/11/24 6:43 PM
    * @Param: []
    * @return: T
    */ 
   T peek();
   /** 
     * 方法描述: 返回队头元素,不执行删除操作,若队列为空,抛出异常:NoSuchElementException
     * @Author: niutongtong
     * @Date: 2018/11/24 6:43 PM
     * @Param: []
     * @return: T
     */ 
   T element();
  /** 
    * 方法描述: 出队,执行删除操作,返回队头元素,若队列为空,返回null
    * @Author: niutongtong
    * @Date: 2018/11/24 6:43 PM
    * @Param: []
    * @return: T
    */ 
   T poll();
   /** 出队,执行删除操作,若队列为空,抛出异常:NoSuchElementException
     * 方法描述: 
     * @Author: niutongtong
     * @Date: 2018/11/24 6:43 PM
     * @Param: []
     * @return: T
     */ 
   T remove();
   /** 
     * 方法描述: 清空队列
     * @Author: niutongtong
     * @Date: 2018/11/24 6:44 PM
     * @Param: []
     * @return: void
     */ 
   void clearQueue();

   
}
