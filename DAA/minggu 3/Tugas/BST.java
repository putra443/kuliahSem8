import java.util.Scanner;
class BST <T extends Comparable<T>>{
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
                if(data.compareTo(curr.info)<0){
                    curr = curr.left;
                }
                else{
                    curr = curr.right;
                }
            }
            newNode.parent = parent;
            if(data.compareTo(parent.info) <0){
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
    public T min(){
        Node result = min (this.root);
        if(result == null)
            return null;
        else
            return result.info;
    }
    private Node min(Node curr){
        if(curr == null)
            return curr;
        
        else
            while(curr.left != null)
                curr = curr.left;
            return curr;
    }
    public T max() {
        Node result = max (this.root);
        if(result == null)
            return null;
        else
            return result.info;
    }
    private Node max (Node curr){
        if(curr==null)
            return null;
        else
            while(curr.right != null)
                curr = curr.right;
            return curr;
    }
    private Node successor(Node curr){
        Node y = curr.parent;
        if(curr.right != null)
            return min(curr.right);
        else   
            y = curr.parent;
            while(y !=null && curr == y.right)
                curr = y;
                y = y.parent;
            return y;  
    }
    private Node predecessor(Node curr){
        Node y = curr.parent;
        if(curr.right != null)
            return max(curr.left);
        else
            y = curr.parent;
            while(y !=null && curr == y.left)
                curr = y;
                y = y.parent;
            return y;
    }
    public boolean delete(T data){
        Node del = search(data, this.root);
        if(del == null)
            return false;
        
        else
            delete(del);
            return true;
    }
    private void delete(Node del){
        //kalo gapunya anak
        if(del.left ==null && del.right == null){
            del = null;
        }
        // kalo anaknya satu, anak kiri
        else if(del.left !=null && del.right==null){
            del = del.left;
            del.left = null;
        }
        //kalo anaknya satu, anak kanan
        else if(del.left ==null && del.right!=null){
            del = del.right;
            del.right = null;
        }
        // anaknya 2 
        else{
            del = successor(del);
        }     
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
        String input = sc.nextLine();
        int i = 0;
        while(i<input.length()){
            if(input.charAt(i)-48>=0){
                if(input.charAt(i+1)-48>=0){
                    bst.insert(Integer.parseInt((input.charAt(i))-48+""+(input.charAt(i+1)-48)));
                    i+=2;
                }
                else if(input.charAt(i+1)==' '){
                    bst.insert(input.charAt(i)-48);
                    i++;
                }
            }
            else if(input.charAt(i)=='-'){
                i+=2;
            }
            else{
                i++;
            }
        }
        bst.printPaths(bst.root);
        System.out.println(bst.temp);
    }
}