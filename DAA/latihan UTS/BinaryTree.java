import java.util.*;
public class BinaryTree<T extends Comparable<T>> {
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
    public T search(T data){
        Node result = search(data, this.root);
        if(result == null)
            return null;
        else
            return result.info;
    }
    private Node search (T data, Node curr){
        if(curr == null)
            return null;
        else if(curr.info.compareTo(data)== 0)
            return curr;
        else if(curr.info.compareTo(data)< 0)
            return search(data, curr.right);
        
        return search(data, curr.left);

    }
    
    void printPaths(Node node)
    {
        int path[] = new int[1000];
        printPathsRecur(node, path, 0);
    }
    
    void printPathsRecur(Node node, int path[], int pathLen)
    {
        if (node == null)
            return;
    

        path[pathLen] = (Integer)node.info;
        pathLen++;
    
        
        if (node.left == null && node.right == null)
            printArray(path, pathLen);
        else
        {

            printPathsRecur(node.left, path, pathLen);
            printPathsRecur(node.right, path, pathLen);
        }
    }
    
    public int temp = 0;
    void printArray(int ints[], int len)
    {
        int i;
        int counter = 0;
        for (i = 0; i < len; i++)
        {
            counter+=ints[i];
            if(i==len-1){
                if(this.temp<counter){
                    temp=counter;              
                }
            }
        }
        // System.out.println("");
    }    
    
}
class testerBST{
    public static void main (String[]args){
        BST<Integer> bst = new BST<Integer>();
        
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()){
            int input = sc.nextInt();
            
        }
        

        bst.printPaths(bst.root);
        System.out.println(bst.temp);
    }
}
