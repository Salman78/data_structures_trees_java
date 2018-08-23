
package binarysearchtreejava;

public class TreeStructure {
    Node root;
    
    public void addNode(int data, Node parent) {
        
        if(root == null) {  //this section will not execute in recursive calls
            parent = new Node(data);
            root = parent;            
        }
              
        else {
            if(data < parent.data) {
                if(parent.left == null) {
                    parent.left = new Node(data);
                }
                else addNode(data, parent.left);
            }
            else {
                if(parent.right == null) {
                    parent.right = new Node(data);
                }
                else addNode(data, parent.right);
            }
        }
    }
    
    public Node addNode2(int data, int index, Node parent) {
        
        if(parent == null) {   //parent is often written as ''root'' 
            parent = new Node(data, index);            
        }
        else if(data < parent.data) {
            parent.left = addNode2(data, index, parent.left);
        }
        else if(data > parent.data) {
            parent.right = addNode2(data, index, parent.right);
        }
        //if data is equal
        else {
            if(index > parent.index) {                
                parent.same = addNode2(data, parent.index, parent.same); //we are not really switching the nodes
                parent.index = index;                                    //we are just swaping the index value by copying
            }
            else {
                parent.same = addNode2(data, index, parent.same);
            }
            return parent;
        }
        return parent;
                
    }
    
    public void removeNode(int data, Node parent) { 
        //if main root is to be removed
        if(root.data == data) {
            if(root.left != null && root.right == null) {  //case1
                root = root.left;
            }
            else if(root.left == null && root.right != null) { //case2
                root = root.right;
            }
            else if(root.left == null && root.right == null) { //case3
                root = null;
            }
            else { //case 4
                Node temp = root.right;
                
                while(temp.left.left != null) { //important logic 
                    temp = temp.left;
                }
                root.data = temp.left.data;
                temp.left = null;
            }
        }
        //when node to be removed is not absolute root
        else {
            Node temp = parent;
            boolean left = true;
            if(temp.left != null) {
                if(data == temp.left.data) {
                    temp = temp.left;  // ei line er jonno if(data == temp.data) condition must be true
                }
            }                        
            if(temp.right != null) {  
                if(data == temp.right.data) { //first if block executed holey ei if block executed hobe nah karon same value is not allowed in the tree
                    temp = temp.right; // ei line er jonno if(data == temp.data) condition must be true
                    left = false;
                }
            }
                        
            if(data == temp.data) { //this block has to execute if either of the upper if block executed
                //now we start to check all the four possible cases
                if(temp.left != null && temp.right == null) {  //case1
                    if(left) {
                        parent.left = temp.left;
                    }
                    else parent.right = temp.left;
                    //temp = null; GC should handle this
                }
                else if((temp.left == null && temp.right != null) || (temp.left == null && temp.right == null)) { //case2 & case3
                    if(left) {
                        parent.left = temp.right;
                    }
                    else parent.right = temp.right;
                    //temp = null;
                }
                else { //case4
                    if(left) {
                        parent = parent.left;
                    }
                    else parent = parent.right;
                    
                    temp = parent.right;
                    Node traverse1 = temp;
                    Node traverse2 = temp.left;
                    
                    if(traverse2 == null) {
                        parent.data = traverse1.data;
                        parent.right = traverse1.right;
                        //temp/traversal1 gets abandoned and hence removed
                    }
                    else {
                        while(traverse2.left != null) {
                            traverse1 = traverse1.left;
                            traverse2 = traverse2.left;
                        }
                        parent.data = traverse2.data;
                        traverse1.left = null; //abandones traverse2 (i.e smallest node in right side of parent) 
                    }                    
                }
                
                
            }
            //following conditional blocks contain recursion and updates parent in every recursion call based on the date being smaller or larger
            else if(data < temp.data) { 
                removeNode(data, temp.left);
            }
            else removeNode(data, temp.right);
        }
    }
    
    public void inOrderPrint(Node parent) {
        if(parent != null) {
            inOrderPrint(parent.left);
            System.out.println("[ node: " + parent.data + "]");
            inOrderPrint(parent.right);
        }
    }
    
    public void inOrderPrint2(Node parent) {
        if(parent != null) {
            inOrderPrint2(parent.left);
            System.out.println("[ node: " + parent.data + ", " + parent.index + " ]");
            inOrderPrint2(parent.same);
            //System.out.println("[ node: " + parent.data + ", " + parent.index + " ]");
            inOrderPrint2(parent.right);
        }
    }
    
    public Node removeNode2(int data, int index, Node parent) {
        if(parent == null) {
            return null;
        }
        else if(data < parent.data) {
            parent.left = removeNode2(data, index, parent.left);
        }
        else if(data > parent.data) {
            parent.right = removeNode2(data, index, parent.right);
        }
        else if(data == parent.data && index != parent.index) {
            parent.same = removeNode2(data, index, parent.same);
        }
        else if(data == parent.data && index == parent.index) {
            if(parent.same == null) {
                if(parent.left == null) {
                    parent = parent.right;
                }                                
                else {
                    findMax(parent.left).right = parent.right;
                    parent = parent.left;
                }
            }
            else {
                parent.data = parent.same.data;
                parent.index = parent.same.index;
                parent.same = removeNode2(parent.data, parent.index, parent.same);
            }
        }
        return parent;
        
    }
    
    public Node findMin(Node root) {
        if (root == null) {
            return null;
        }
        else if(root.left == null) {
            return root;
        }
        else return findMin(root.left);
    }
    
    public Node findMax(Node root) {
        if (root == null) {
            return null;
        }
        else if(root.right == null) {
            return root;
        }
        else return findMax(root.right);
    }
    
    public Node removeNodeFinal(int data, Node parent) {
        if(parent == null) {
            return null;
        }
        if(data < parent.data) {
            parent.left = removeNodeFinal(data, parent.left);
        }
        else if(data > parent.data) {
            parent.right = removeNodeFinal(data, parent.right);
        }
        //meaning data is equal to parent.data
        else if(parent.left == null) { //either of these two if blocks also handle the case when both are null
            parent = parent.right;            
        }
        else if(parent.right == null) {
            parent = parent.left;            
        }
        else {
            parent.data = findMin(parent.right).data;
            parent.right = removeNodeFinal(parent.data, parent.right);            
        }
        return parent;
        
    }
}

