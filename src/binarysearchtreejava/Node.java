
package binarysearchtreejava;

public class Node {
    int data;
    int index;
    Node left;
    Node right;
    Node same;
    
    public Node(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
        this.same = null;
    }
    public Node(int data, int index) {
        this.data = data;
        this.index = index;
        this.left = null;
        this.right = null;
        this.same = null;
    }
}
