package com.liujjl.link;


import java.util.LinkedList;

/**
 * @program: leetcode-learn
 * @description:
 * @author: liujj
 * @create: 2020-01-14 09:38
 **/
public class SingleLinkReverse {

  public static void main(String[] args){
      SingleLinkedList<Integer> linkedList = new SingleLinkedList<>();
      linkedList.addLast(1);
      linkedList.addLast(2);
      linkedList.addLast(3);
      linkedList.addLast(4);
      linkedList.addLast(5);
      linkedList.addLast(6);
      linkedList.reverse();
      System.out.println(linkedList);
  }





  static class SingleLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public void addLast(T t){
      if (head == null){
        head = new Node<>(t, null);
        tail = head;
      } else{
        Node<T> tNode = new Node<>(t, null);
        tail.setNext(tNode);
        tail = tNode;
      }
      size ++;
    }
    public SingleLinkedList<T> reverse(){
      if (size == 0){
        return null;
      }
      Node<T> tNode = head;
      while (tNode.next != null){
         Node<T> cNode = tNode.next;
         cNode.setNext(tNode);
         tNode = tNode.next;
      }
    }

    public int getSize() {
      return size;
    }

    private static class Node<T>{
      private T data;
      private Node<T> next;

     private Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
      }

     public T getData() {
       return data;
     }

     public void setData(T data) {
       this.data = data;
     }

     public Node<T> getNext() {
       return next;
     }

     public void setNext(Node<T> next) {
       this.next = next;
     }
   }

  }


}
