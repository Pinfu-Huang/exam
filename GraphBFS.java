package com.pinfall.exam;

import java.util.*;

public class GraphBFS {
    private Map<Character, LinkedList<Character>> adjacencyList;

    // 构造函数，初始化邻接表
    public GraphBFS() {
        adjacencyList = new HashMap<>();
    }

    // 向图中添加边
    public void addEdge(char v, char[] w) {
        adjacencyList.computeIfAbsent(v, k -> new LinkedList<>());
        for (char neighbor : w) {
            adjacencyList.get(v).add(neighbor);
        }
    }

    // 广度优先搜索方法
    public void BFS(char s) {
        // 标记所有顶点为未访问
        Set<Character> visited = new HashSet<>();

        // 创建一个队列用于 BFS
        LinkedList<Character> queue = new LinkedList<>();

        // 标记当前节点为已访问并将其加入队列
        visited.add(s);
        queue.add(s);

        while (queue.size() != 0) {
            // 从队列中取出一个顶点并打印
            s = queue.poll();
            System.out.print(s + " ");

            // 获取与当前顶点相邻的所有顶点
            if (adjacencyList.containsKey(s)) {
                Iterator<Character> i = adjacencyList.get(s).listIterator();
                while (i.hasNext()) {
                    char n = i.next();
                    if (!visited.contains(n)) {
                        // 若相邻顶点未访问，则标记为已访问并加入队列
                        visited.add(n);
                        queue.add(n);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        // 创建一个图
        GraphBFS g = new GraphBFS();

        // 添加边
        g.addEdge('A', new char[]{'B', 'C'});
        g.addEdge('B', new char[]{'A', 'D', 'E'});
        g.addEdge('C', new char[]{'A', 'F'});
        g.addEdge('D', new char[]{'B'});
        g.addEdge('E', new char[]{'B', 'F'});
        g.addEdge('F', new char[]{'C', 'E'});

        System.out.println("从顶点 A 开始的搜索结果:");
        g.BFS('A');
    }
}