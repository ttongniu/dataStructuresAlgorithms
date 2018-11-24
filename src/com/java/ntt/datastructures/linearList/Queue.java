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
     * 方法描述: 
     * @Author: niutongtong
     * @Date: 2018/11/24 6:42 PM
     * @Param: []
     * @return: int
     */ 
   int size();
   /** 
     * 方法描述: 
     * @Author: niutongtong
     * @Date: 2018/11/24 6:43 PM
     * @Param: []
     * @return: boolean
     */ 
   boolean isEmpty();
   /** 
     * 方法描述: 
     * @Author: niutongtong
     * @Date: 2018/11/24 6:43 PM
     * @Param: [data]
     * @return: boolean
     */ 
   boolean add(T data);
   /** 
     * 方法描述: 
     * @Author: niutongtong
     * @Date: 2018/11/24 6:43 PM
     * @Param: [data]
     * @return: boolean
     */ 

   boolean offer(T data);
  /** 
    * 方法描述: 
    * @Author: niutongtong
    * @Date: 2018/11/24 6:43 PM
    * @Param: []
    * @return: T
    */ 
   T peek();
   /** 
     * 方法描述: 
     * @Author: niutongtong
     * @Date: 2018/11/24 6:43 PM
     * @Param: []
     * @return: T
     */ 
   T element();
  /** 
    * 方法描述: 
    * @Author: niutongtong
    * @Date: 2018/11/24 6:43 PM
    * @Param: []
    * @return: T
    */ 
   T poll();
   /** 
     * 方法描述: 
     * @Author: niutongtong
     * @Date: 2018/11/24 6:43 PM
     * @Param: []
     * @return: T
     */ 
   T remove();
   /** 
     * 方法描述: 
     * @Author: niutongtong
     * @Date: 2018/11/24 6:44 PM
     * @Param: []
     * @return: void
     */ 
   void clearQueue();

   
}
