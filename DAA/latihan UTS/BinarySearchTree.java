import java.util.*;
public class BinarySearchTree<T extends Comparable<T>> {
    public Node root;

    @Override
    public String toString(){
        return preorder(this.root);
    }

    private String preorder(Node x){
        if(x==null)
            return ";";
        if(x.left == null && x.right == null)
            return x.toString();
        else
            return x.toString() + preorder(x.left) + preorder(x.right);
    }

    private class Node{
        T info;
        Node left, right, parent;

        Node(T info){
            this.info = info;
        }

        @Override
        public String toString(){
            return "["+this.info.toString() + "]";
        }
    }
    public void insert(T data){
        Node newNode = new Node(data);
        Node curr = this.root;
        Node parent = null;

        if(this.root == null){
            this.root = newNode;
        }
        else{
            while(curr!=null){
                parent = curr;
                if(curr.left==null){
                    curr = curr.left;
                }
                else{
                    curr = curr.right;
                }
            }
            newNode.parent = parent;
            if(parent.left==null) {
                parent.left = newNode;
            }
            else{
                parent.right = newNode;
            }
        }
    }
}
class testerBST{
    public static void main (String[]args){
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(5);
        bst.insert(14);
        bst.insert(8);
        bst.insert(3);
        bst.insert(11);
        bst.insert(10);
        System.out.println(bst);
    }
}
