package com.liujj.queue;

/**
 * @program: leetcode-learn
 * @description:
 * @author: liujunjie
 * @create: 2019-12-25 10:40
 **/
public class MyCircularQueue {
  private int[] data;
  private int size;
  private int head;
  private int tail;
  /** Initialize your data structure here. Set the size of the queue to be k. */
  public MyCircularQueue(int k) {
        data = new int[k];
        size = k;
        head = -1;
        tail = -1;
  }

  /** Insert an element into the circular queue. Return true if the operation is successful. */
  public boolean enQueue(int value) {
    if (isFull()){
      return false;
    }
    if (isEmpty()){
      head = 0;
      tail = 0;
    }else {
      tail = (tail + 1 )% size;
    }
    data[tail] = value;
    return true;
  }

  /** Delete an element from the circular queue. Return true if the operation is successful. */
  public boolean deQueue() {
      if (isEmpty()){
        return false;
      }
      if (head == tail){
        head = -1;
        tail = -1;
        return true;
      }
      head = (head + 1) % size;
      return true;
  }

  /** Get the front item from the queue. */
  public int front() {
    return data[head];
  }

  /** Get the last item from the queue. */
  public int rear() {
     return data[tail];
  }

  /** Checks whether the circular queue is empty or not. */
  public boolean isEmpty() {
       return head == -1;
  }

  /** Checks whether the circular queue is full or not. */
  public boolean isFull() {
      return ((tail + 1) % size) == head;
  }

  public static void main(String[] args){
    MyCircularQueue queue = new MyCircularQueue(5);
    queue.enQueue(5);
    queue.enQueue(3);
    queue.enQueue(5);
    queue.enQueue(5);
    queue.enQueue(6);
    queue.deQueue();
    queue.enQueue(8);
    System.out.println(queue.front());
    System.out.println(queue.rear());
  }
}
