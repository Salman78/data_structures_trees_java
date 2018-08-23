
package binarysearchtreejava;

public class BinarySearchTreeJava {

    public static void main(String[] args) {
        TreeStructure tree1 = new TreeStructure();
        /*
        tree1.addNode(7, tree1.root);
        tree1.addNode(4, tree1.root);
        tree1.addNode(9, tree1.root);
        tree1.addNode(13, tree1.root);
        tree1.addNode(2, tree1.root);
        tree1.addNode(15, tree1.root);
        tree1.addNode(3, tree1.root);
        tree1.addNode(1, tree1.root);
        tree1.addNode(8, tree1.root);
        tree1.addNode(11, tree1.root);
        */
        
        tree1.root = tree1.addNode2(7, 10, tree1.root);
        tree1.root = tree1.addNode2(7, 15, tree1.root);
        tree1.root = tree1.addNode2(7, 13, tree1.root);
        tree1.root = tree1.addNode2(4, 12, tree1.root);
        tree1.root = tree1.addNode2(4, 10, tree1.root);
        tree1.root = tree1.addNode2(4, 15, tree1.root);
        tree1.root = tree1.addNode2(9, 0, tree1.root);
        tree1.root = tree1.addNode2(13, 5, tree1.root);
        tree1.root = tree1.addNode2(13, 7, tree1.root);
        tree1.root = tree1.addNode2(13, 2, tree1.root);
        tree1.root = tree1.addNode2(5, 2, tree1.root);
        tree1.root = tree1.addNode2(2, 10,tree1.root);
        tree1.root = tree1.addNode2(15, 7, tree1.root);
        tree1.root = tree1.addNode2(3, 8, tree1.root);
        tree1.root = tree1.addNode2(1, 4, tree1.root);
        tree1.root = tree1.addNode2(8, 8, tree1.root);
        tree1.root = tree1.addNode2(11, 20, tree1.root);
        
        
        
                
        tree1.root = tree1.removeNode2(13, 2, tree1.root);
                
        tree1.inOrderPrint2(tree1.root);
        System.out.println(tree1.root.data + " " + tree1.root.index);
    }
    
}
