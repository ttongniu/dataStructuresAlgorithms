package com.java.ntt.datastructures.linearlist;

/**
 * @author niutongtong
 * @Title: Array
 * @ProjectName dataStructuresAlgorithms
 * @Description: TODO
 * @date 2018/11/185:40 PM
 */
public class Array<E> {

  private E[] data;
  private int size;
  /**
  　　* @Description: 构造函数，传入数组的容量capacity构造Array
  　　* @param ${tags} 
  　　* @return ${return_type} 
  　　* @throws
  　　* @author ${ntt}
  　　* @date 2018/11/18 5:45 PM 
  　　*/
  public Array (int capacity){

    data= (E[]) new Object[capacity];
    size=0;

  }

  /**
  　　* @Description: 无参数的构造函数，默认数组的容量capacity=10
  　　* @param ${tags} 
  　　* @return ${return_type} 
  　　* @throws
  　　* @author ${ntt}
  　　* @date 2018/11/18 5:45 PM
  　　*/
  public Array(){
    this(10);
  }

  /**
  　　* @Description: 获取数组中的元素个数
  　　* @param ${tags}
  　　* @return ${return_type}
  　　* @throws
  　　* @author ${ntt}
  　　* @date 2018/11/18 5:48 PM
  　　*/
  public int getSize(){
    return  size;
  }
  /**
  　　* @Description: 获取数组的容量
  　　* @param ${tags}
  　　* @return ${return_type}
  　　* @throws
  　　* @author ${ntt}
  　　* @date 2018/11/18 5:48 PM
  　　*/
  public int getCapacity(){
    return  data.length;
  }

   /**
   　　* @Description: 返回数组是否为空
   　　* @param ${tags} 
   　　* @return ${return_type} 
   　　* @throws
   　　* @author ${ntt}
   　　* @date 2018/11/18 6:21 PM 
   　　*/
  public boolean isEmpty(){
    return  size==0;
  }
 /**
 　　* @Description: 在第index个位置插入一个新元素e,O(n/2)=O(n)
  　 * @param ${tags}
 　　* @return ${return_type} 
 　　* @throws
 　　* @author ${ntt}
 　　* @date 2018/11/18 6:21 PM 
 　　*/
  public void add(int index,E e){

    if(index<0||index>size){
      throw new IllegalArgumentException("Add failed!,Require index >= 0 and index <= size.");
    }
    if(size==data.length){
       resize(2*data.length);
    }
    for(int i=size-1;i>=index;i--) {
      data[i + 1] = data[i];
    }
    data[index]=e;
    size++;


  }
/**
　　* @Description: 在所有元素前添加一个新元素,O(1)
　　* @param ${tags} 
　　* @return ${return_type} 
　　* @throws
　　* @author ${ntt}
　　* @date 2018/11/18 6:21 PM 
　　*/
  public void addFirst(E e){
      add(0,e);
  }
/**
　　* @Description: 在所有元素后添加一个新元素,O(1)
　　* @param ${tags} 
　　* @return ${return_type} 
　　* @throws
　　* @author ${ntt}
　　* @date 2018/11/18 6:22 PM 
　　*/
  public void addLast(E e){
    add(size,e);
  }
  
  /**
  　　* @Description: 获取index索引位置的元素,O(1)
  　　* @param ${tags} 
  　　* @return ${return_type} 
  　　* @throws
  　　* @author ${ntt}
  　　* @date 2018/11/18 6:22 PM 
  　　*/
  public E get(int index){
    if(index<0||index>=size){
      throw new IllegalArgumentException("Get failed.Index is illegal.");
    }
    return  data[index];
  }

/**
　　* @Description: 修改index索引位置的元素为e,O(1)
　　* @param ${tags} 
　　* @return ${return_type} 
　　* @throws
　　* @author ${ntt}
　　* @date 2018/11/18 6:22 PM 
　　*/
  public void set(int index,E e){
    if(index<0||index>=size){
      throw new IllegalArgumentException("Get failed.Index is illegal.");
    }
      data[index]=e;
  }
/**
　　* @Description: 查找数组中是否有元素e,O(n)
　　* @param ${tags} 
　　* @return ${return_type} 
　　* @throws
　　* @author ${ntt}
　　* @date 2018/11/18 6:22 PM 
　　*/
  public boolean contains(E e){
     for(int i=0;i<size;i++){
       if(data[i].equals(e)){
         return  true;
       }
     }
     return  false;
  }
/**
　　* @Description: 查找数组中元素e所在的索引，如果不存在元素e，则返回-1,O(n)
　　* @param ${tags} 
　　* @return ${return_type} 
　　* @throws
　　* @author ${ntt}
　　* @date 2018/11/18 6:22 PM 
　　*/
  public int find(E e){
    for(int i=0;i<size;i++){
      if(data[i].equals(e)){
        return  i;
      }
    }
    return  -1;
  }


/**
　　* @Description: 从数组中删除index位置的元素, 返回删除的元素,O(n)
　　* @param ${tags} 
　　* @return ${return_type} 
　　* @throws
　　* @author ${ntt}
　　* @date 2018/11/18 6:52 PM 
　　*/
public E remove(int index){

    if(index<0||index>=size){
      throw new IllegalArgumentException("Remove failed.Index is illegal.");
    }

    E ret=data[index];
    for(int i=index+1;i<size;i++){
           data[i-1]=data[i];
     }
      size--;
    data[size]=null;
    if(size<data.length/2){
      resize(data.length/2);
    }
    return  ret;

}
/**
　　* @Description: 从数组中删除第一个元素, 返回删除的元素
　　* @param ${tags} 
　　* @return ${return_type} 
　　* @throws
　　* @author ${ntt}
　　* @date 2018/11/18 6:52 PM 
　　*/
public E removeFirst(){
     return  remove(0);
}
/**
　　* @Description:  从数组中删除最后一个元素, 返回删除的元素
　　* @param ${tags} 
　　* @return ${return_type} 
　　* @throws
　　* @author ${ntt}
　　* @date 2018/11/18 6:53 PM 
　　*/
public E removeLast(){
    return  remove(size-1);
}
/**
　　* @Description:  从数组中删除元素e
 　　* @param ${tags}
　　* @return ${return_type} 
　　* @throws
　　* @author ${ntt}
　　* @date 2018/11/18 6:53 PM 
　　*/
public void  removeElement(E e){
    int index=find(e);
    if(index!=-1){
      remove(index);
    }
}


  @Override
  public String toString(){
    StringBuilder res=new StringBuilder();
    res.append(String.format("Array: size = %d , capacity = %d\n", size, data.length));
    res.append('[');
    for(int i =0;i<size;i++){
      res.append(data[i]);
      if(i!=size-1) {
        res.append(",");
      }
    }
    res.append(']');
    return res.toString();
  }
  /**
  　　* @Description: 将数组空间的容量变成newCapacity大小
  　　* @param ${tags} 
  　　* @return ${return_type} 
  　　* @throws
  　　* @author ${ntt}
  　　* @date 2018/11/18 6:53 PM
  　　*/
  private void resize(int capacity) {
    E[] newData= (E[]) new Object[capacity];
    for(int i=0;i<size;i++){
        newData[i]=data[i];
    }
    data=newData;


  }


  public static void main(String[] args) {

    Array<Integer> arr=new Array<>();
    for (int i=0;i<10;i++){
      arr.addLast(i);
    }
    System.out.println(arr);

    arr.add(1,100);
    System.out.println(arr);

    arr.addFirst(-1);
    System.out.println(arr);

    arr.remove(2);
    System.out.println(arr);

    arr.removeElement(4);
    System.out.println(arr);

    arr.removeFirst();
    System.out.println(arr);


  }



}
