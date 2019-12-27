package com.liujj.queue;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @program: leetcode-learn
 * @description:
 * @author: liujj
 * @create: 2019-12-26 17:03
 **/
public class OpenLock {

  public static int openLock(String[] deadends, String target) {
    Set<String> dead = Stream.of(deadends).collect(Collectors.toSet());
    Set<String> seen = new HashSet<>();
    String init = "0000";
    if (dead.contains(init)) {
      return -1;
    }
    seen.add(init);
    int index = 0;
    LinkedList<String> queue = new LinkedList<>();
    queue.offer(init);
    queue.offer(null);
    while (!queue.isEmpty()) {
      String root = queue.poll();
      if (root == null){
         index++;
        if (queue.peek() != null){
          queue.offer(null);
        }
      }else if (target.equals(root)) {
        return index;
      } else if (!dead.contains(root)) {
        char[] chars = root.toCharArray();
        int size = chars.length;
        for (int i = 0; i < size; i++) {
          //可能存在+1和-1两种情况，每个root可产生8个根节点
          for (int j = -1; j < 2; j += 2) {
            //‘0’ - ‘9’ 对应 48 - 57
            int number = (chars[i] - '0' + j + 10) % 10;
            String assemble = root.substring(0, i) + number + root.substring(i + 1);
            if (!seen.contains(assemble)) {
              seen.add(assemble);
              queue.offer(assemble);
            }
          }
        }
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    String[] deadends = {"0201", "0101", "0102", "1212", "2002"};
    String target = "0202";
    int index = openLock(deadends, target);
    System.out.println(index);
  }
}
