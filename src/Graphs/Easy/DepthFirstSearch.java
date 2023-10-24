package Graphs.Easy;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class DepthFirstSearch {

    public static void main(String[] args) {

        Node root = buildGraph();

        List<String> dfs = root.depthFirstSearchRecursive(new ArrayList<>());
        System.out.println(dfs);

        List<String> dfs2 = new ArrayList<>();
        root.depthFirstSearchRecursive2(dfs2);
        System.out.println(dfs2);

        List<String> dfs3 = root.depthFirstSearchIterative(new ArrayList<>());
        System.out.println(dfs3);

    }

    public static Node buildGraph() {

        Node a = new Node("A");
        Node b = new Node("B");
        Node c = new Node("C");
        Node d = new Node("D");
        Node e = new Node("E");
        Node f = new Node("F");
        Node g = new Node("G");
        Node h = new Node("H");
        Node i = new Node("I");
        Node j = new Node("J");
        Node k = new Node("K");

        a.addChild(b);
        a.addChild(c);
        a.addChild(d);

        b.addChild(e);
        b.addChild(f);

        d.addChild(g);
        d.addChild(h);

        f.addChild(i);
        f.addChild(j);

        g.addChild(k);

        return a;

    }

}

class Node {

    String name;
    List<Node> children;

    public Node(String name) {

        this.name = name;
        this.children = new ArrayList<>();

    }

    public void addChild(Node child) {

        children.add(child);

    }

    public List<String> depthFirstSearchRecursive(List<String> nodes) {

        nodes.add(this.name);

        for (Node child : this.children) child.depthFirstSearchRecursive(nodes);

        return nodes;

    }

    public void depthFirstSearchRecursive2(List<String> nodes) {

        depthFirstSearchRecursive2(this, nodes);

    }

    public void depthFirstSearchRecursive2(Node node, List<String> nodes) {

        nodes.add(node.name);

        for (Node child : node.children) depthFirstSearchRecursive2(child, nodes);

    }

    public List<String> depthFirstSearchIterative(List<String> nodes) {

        Deque<Node> stack = new LinkedList<>();

        stack.push(this);

        Node current;

        while (!stack.isEmpty()) {

            current = stack.pop();

            nodes.add(current.name);

            for (int i = current.children.size() - 1; i >= 0; i--) {

                stack.push(current.children.get(i));

            }

        }

        return nodes;

    }

}
