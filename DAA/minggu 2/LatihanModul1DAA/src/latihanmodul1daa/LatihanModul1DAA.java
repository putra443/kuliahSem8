/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package latihanmodul1daa;
import java.util.LinkedList;
import java.util.Queue;
/**
 *
 * @author Fransiskus Putra
 */

class Graph {
int vertex;
boolean [] isVisited;
int [] parent;
int [] ord;
int[][] matrix;
int counter;

    public Graph(int vertex){
        this.vertex = vertex;
        this.matrix = new int[vertex][vertex];
        this.isVisited = new boolean[vertex];
        this.parent = new int [vertex];
        this.ord = new int [vertex];
        this.counter = 1;
    }
    
    public void addEdge(int v1, int v2){
        this.matrix[v1][v2] = 1;
        this.matrix[v2][v1] = 1;
    }
    
    public void addEdge(int v1, int v2, int bobot){
        this.matrix[v1][v2] = bobot;
        this.matrix[v2][v1] = bobot;
    }
    
    public void removeEdge(int v1, int v2){
        this.matrix[v1][v2] = 0;
        this.matrix[v2][v1] = 0;
    }
    
    public int isEdgeExist(int v1, int v2){
        return this.matrix[v1][v2];
    }
    
    public void DFS(Graph G, boolean[] isVisited){
        this.ord = new int[G.vertex];
        this.parent = new int[G.vertex];
        for(int i =0; i<this.isVisited.length; i++){
            if(this.isVisited[i]==false){
                DFSRecursive(i, this.isVisited,G);
            }
        }
    }
    
    public void DFSRecursive(int idx, boolean [] isVisited, Graph G){
        this.ord[idx] = this.counter;
        this.counter += 1;
        this.isVisited[idx] = true;
        process(idx);
        for(int i  =  0; i< this.isVisited.length;i++){
            if(G.matrix[i][idx]>=1 && this.isVisited[i]==false){
                this.parent[i] = idx;
                DFSRecursive(i, this.isVisited, G);
            }
        }
    }
    
    public void BFS(Graph G){
        Queue <Integer> queue = new LinkedList<>();
        this.isVisited = new boolean[G.vertex];
        this.parent = new int [G.vertex];
        this.ord = new int[G.vertex];
        
        for(int i = 0 ; i<this.isVisited.length; i++ ){
            if(this.isVisited[i] == false){
                queue.add(i);
                this.ord[i]= this.counter;
                this.counter+=1;
                this.isVisited[i] = true;
                while(!queue.isEmpty()){
                  int x = queue.remove();
                  process(x);
                
                  for(int j=0;j<this.isVisited.length;j++){
                    if(G.matrix[i][j]>=1 && this.isVisited[j]==false){
                        this.parent[j]=x;
                        this.ord[x] = this.counter;
                        this.counter+=1;
                        this.isVisited[j]=true;
                        queue.add(j);
                    }
                  }
                }
                
            }
        }
    }
    
    private void process(int v){
        System.out.print(v+" ");
    }
}

public class LatihanModul1DAA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Graph g = new Graph(6);
        g.addEdge(0,1);
        g.addEdge(1,2);
        g.addEdge(2,3);
        g.addEdge(1,3);
        g.addEdge(5,1);
        g.addEdge(1,3);
        g.addEdge(5,4);
        g.addEdge(3,4);
        
        for(int i =0; i<g.vertex; i++){
            for(int j = 0; j<g.vertex; j++){
                System.out.print(g.matrix[i][j]);
            }
            System.out.println();
        }
        System.out.println("Hasil DFS");
        g.DFS(g,g.isVisited);
        System.out.println();
        System.out.println("Parent DFS");
        for(int i =0;i<g.vertex;i++){
            System.out.print(g.parent[i]+" ");
        }
        System.out.println();
        System.out.println("ord DFS");

        for(int i =0;i<g.vertex;i++){
            System.out.print(g.ord[i]+" ");
        }
        System.out.println();
        System.out.println("hasil BFS");
        g.BFS(g);
        System.out.println();
        System.out.println("parent bfs");
        System.out.println();
        for(int i =0;i<g.vertex;i++){
            System.out.print(g.parent[i]+" ");
        }
        System.out.println();
        System.out.println("ord BFS");
        for(int i =0;i<g.vertex;i++){
            System.out.print(g.parent[i]+" ");
        }
        
    }
}
