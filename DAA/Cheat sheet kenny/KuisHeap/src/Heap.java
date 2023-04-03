
import java.util.*;
import java.io.*;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author RamaFS
 */
public class Heap {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            tree root = null;
            btree bt = new btree();
            int Length = sc.nextInt();
            for (int j = 0; j < Length; j++) {
                if (root == null) {
                    root = new tree(Integer.parseInt(sc.nextLine()));
                } else {
                    bt.insert(root, Integer.parseInt(sc.nextLine()));
                }
            }
            if (bt.isHeap(root) == true) {
                System.out.println("MAXIMUM");
            } else {
                System.out.println("NONE");
            }
        }
    }
    
    int countNodes(tree root) {
        if (root == null) {
            return 0;
        }
        return (1 + countNodes(root.left) + countNodes(root.right));
    }

    boolean complete(tree root, int index, int number_nodes) {
        if (root == null) {
            return true;
        }
        if (index >= number_nodes) {
            return false;
        }
        return complete(root.left, 2 * index + 1, number_nodes)
                && complete(root.right, 2 * index + 2, number_nodes);
    }

    boolean heap(tree root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.right == null) {
            return root.data >= root.left.data;
        } else {
            if (root.data >= root.left.data && root.data >= root.right.data) {
                return heap(root.left) && heap(root.right);
            } else {
                return false;
            }
        }
    }
    
    boolean isHeap(tree root) {
        if (root == null) {
            return true;
        }

        // These two are used in isCompleteUtil() 
        int node_count = countNodes(root);

        if (complete(root, 0, node_count) == true && heap(root) == true) {
            return true;
        }
        return false;
    }
}

class tree {

    int data;
    tree left;
    tree right;

    tree(int value) {
        this.data = value;
    }
}

class btree {

    tree temp;

    void insert(tree node, int value) {
        if (value < node.data) {
            if (node.left != null) {
                insert(node.left, value);
            } else {;
                node.left = new tree(value);
            }
        } else if (value > node.data) {
            if (node.right != null) {
                insert(node.right, value);
            } else {
                node.right = new tree(value);
            }
        }
    }
    
    int countNodes(tree root) {
        if (root == null) {
            return 0;
        }
        return (1 + countNodes(root.left) + countNodes(root.right));
    }

    boolean complete(tree root, int index, int number_nodes) {
        if (root == null) {
            return true;
        }
        if (index >= number_nodes) {
            return false;
        }
        return complete(root.left, 2 * index + 1, number_nodes)
                && complete(root.right, 2 * index + 2, number_nodes);
    }

    boolean heap(tree root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.right == null) {
            return root.data >= root.left.data;
        } else {
            if (root.data >= root.left.data && root.data >= root.right.data) {
                return heap(root.left) && heap(root.right);
            } else {
                return false;
            }
        }
    }
    
    boolean isHeap(tree root) {
        if (root == null) {
            return true;
        }

        // These two are used in isCompleteUtil() 
        int node_count = countNodes(root);

        if (complete(root, 0, node_count) == true && heap(root) == true) {
            return true;
        }
        return false;
    }
}
