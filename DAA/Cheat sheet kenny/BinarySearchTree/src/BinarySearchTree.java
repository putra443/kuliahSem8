/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RamaFS
 */
public class BinarySearchTree<T extends Comparable<T>> {
    private Node root;
    
    private class Node{
        T info;
        Node left, right, parent;
        
        Node(T info){
            this.info=info;
        }
        
        @Override
        public String toString(){
            return "[" + this.info.toString() + "]";
        }
    }
    
    public void insert (T data){
        Node newNode = new Node(data);
        Node curr = this.root;
        Node parent = null;
        
        if (this.root == null){
            this.root = newNode;
        }else{
            while (curr!=null){
                parent = curr;
                if (data.compareTo(curr.info)<0){
                    curr = curr.left;
                }else{
                    curr = curr.right;
                }
            }
            
            newNode.parent = parent;
            if (data.compareTo(parent.info)<0){
                parent.left = newNode;
            }else{
                parent.right = newNode;
            }
        }
    }
    
    @Override
    public String toString(){
        return inorder(this.root);
    }
    
    private String inorder(Node x){
        if (x==null){
            return "";
        }
        if (x.left==null && x.right==null){
            return x.toString();
        }else{
            return inorder(x.left) + x.toString() + inorder(x.right);
        }
    }
    
    public T search(T data){
        Node result = search(data, this.root);
        if (result==null){
            return null;
        }else{
            return result.info;
        }
    }
    
    private Node search(T data, Node curr){
        if (curr==null){
            return null;
        }else if (curr.info.compareTo(data)==0){
            return curr;
        }else if (curr.info.compareTo(data)<0){
            return search(data, curr.right);
        }else{
            return search(data, curr.left);
        }
    }
    
    public T min(){
        Node result = min(this.root);
        if (result==null){
            return null;
        }else{
            return result.info;
        }
    }
    
    private Node min(Node curr){
        if (curr==null){
            return curr;
        }else{
            while (curr.left!=null){
                curr = curr.left;
            }
            return curr;
        }
    }
    
    public T max(){
        Node result = max(this.root);
        if (result==null){
            return null;
        }else{
            return result.info;
        }
    }
    
    private Node max(Node curr){
        if (curr==null){
            return curr;
        }else{
            while (curr.right!=null){
                curr = curr.right;
            }
            return curr;
        }
    }
    
    public T successor(){
        Node result = successor(this.root);
        if (result==null){
            return null;
        }else{
            return result.info;
        }
    }
    
    private Node successor(Node curr){
        if (curr.right!=null){
            return min(curr.right);
        }else{
            Node y = curr.parent;
            while (y!=null && curr==y.right){
                curr = y;
                y = y.parent;
            }
            return y;
        }
    }
    
    public T predecessor(){
        Node result = predecessor(this.root);
        if (result==null){
            return null;
        }else{
            return result.info;
        }
    }
    
    public Node predecessor(Node curr){
        if (curr.left!=null){
            return max(curr.left);
        }else{
            Node y = curr.parent;
            while (y!=null && curr==y.left){
                curr = y;
                y = y.parent;
            }
            return y;
        }
    }
    
    public boolean delete(T data){
        Node del = search(data, this.root);
        if (del==null){
            return false;
        }else{
            delete(del);
            return true;
        }
    }
    
    private void delete(Node del){
        Node parent = null;
        
        if (del.left==null && del.right==null){
            if (del!=root){
                if (parent.left==del){
                    parent.left=null;
                }else{
                    parent.right=null;
                }
            }else{
                root=null;
            }
        }else if (del.left!=null && del.right!=null){
            Node successor = successor(del);
            T val = successor.info;
            delete(successor);
            del.info=val;
        }else{
            Node child = (del.left!=null)? del.left: del.right;
            if (del!=root){
                if (del==parent.left){
                    parent.left = child;
                }else{
                    parent.right = child;
                }
            }
        }
    }
}
