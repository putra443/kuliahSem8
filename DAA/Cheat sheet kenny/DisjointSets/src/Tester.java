/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author i18051
 */
public class Tester {
    public static void main(String[] args){ 
        int n = 5; 
        DisjointSets dus = new DisjointSets(n);
        
        for(int i=0;i<n;i++){
            System.out.print(dus.parents[i]);
        }
        System.out.println("");   
        
        for(int i=0;i<n;i++){
            System.out.print(dus.ranks[i]);
        }
        System.out.println("");
        System.out.println("");
        
        dus.union(0, 2); 

        for(int i=0;i<n;i++){
            System.out.print(dus.parents[i]);
        }
        System.out.println(""); 
        
        for(int i=0;i<n;i++){
            System.out.print(dus.ranks[i]);
        }
        System.out.println(""); 
        
        dus.union(4, 2); 

        for(int i=0;i<n;i++){
            System.out.print(dus.parents[i]);
        }
        System.out.println(""); 
        
        for(int i=0;i<n;i++){
            System.out.print(dus.ranks[i]);
        }
        System.out.println(""); 
        
        dus.union(3, 1); 

        for(int i=0;i<n;i++){
            System.out.print(dus.parents[i]);
        }
        System.out.println(""); 
        
        for(int i=0;i<n;i++){
            System.out.print(dus.ranks[i]);
        }
        System.out.println(""); 
    } 
}
