/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RamaFS
 */
public class Tester {
    public static void main(String[] args) {
        BinarySearchTree<Integer> bst = new BinarySearchTree<Integer>();
        bst.insert(5);
        bst.insert(14);
        bst.insert(8);
        bst.insert(3);
        bst.insert(11);
        bst.insert(10);
        System.out.println(bst);
        
        System.out.println(bst.search(10));
        System.out.println(bst.search(3));
        System.out.println(bst.search(12));
        
        System.out.println(bst.max());
        System.out.println(bst.min());
        
        System.out.println(bst.delete(11));
    }
}
