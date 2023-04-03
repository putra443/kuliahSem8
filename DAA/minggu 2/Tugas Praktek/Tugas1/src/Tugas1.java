/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.*;
/**
 *
 * @author Fransiskus Putra
 */
public class Tugas1 {
    int vertex;
    int [][] matrix;
    boolean [] isVisited;
    int counter;
    Stack s ;
    
    public Tugas1(int vertex){
        this.vertex = vertex;
        this.matrix = new int[vertex][vertex];
        this.isVisited = new boolean[vertex];
        this.counter = 0;
        this.s = new Stack();
    }
    
    public void initiate (){
        for(int i = 0; i<this.vertex; i++){
            for(int j = 0; j<this.vertex; j++){
                this.matrix[i][j] = 0;
            }
        }
    }
    
    public void addEdge(int v1, int v2){
        this.matrix[v1][v2] = 1;
        this.matrix[v2][v1] = 1;
    }
    
    public Stack DFS(Tugas1 G, boolean [] isVisited){
        int[] ord_in = new int[this.vertex];
        int[] ord_out = new int[this.vertex];
        for(int i = 0; i<this.vertex; i++){
            if(this.isVisited[i]==false){
                DFSRecursive(i, this.isVisited, G, ord_in, ord_out);
            }
        }
        return this.s;
    }
    public void DFSRecursive(int idx, boolean [] isVisited, Tugas1 G, int[] ord_in, int[] ord_out){
        ord_in[idx] = this.counter;
        this.counter +=1;
        process(idx);
        
        for(int i=0;i<this.isVisited.length;i++){
            if(this.isVisited[i]==false && G.matrix [i][idx]==1){
                if(ord_in[i]!=0 && ord_out[i]==0){
                    break;
                }
                else if(ord_in[i]==0 && this.isVisited[i]==false){
                    DFSRecursive(i,this.isVisited,G, ord_in, ord_out);
                }
            }
            
        }
        this.isVisited[idx] = true;
        this.s.push(idx);
        ord_out[idx] = this.counter;
        this.counter +=1;
    }
    
    private void process(int v){
        System.out.print((v+1)+" ");
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        
        while(vertex!=0 && edge !=0){
            Tugas1 G = new Tugas1(vertex);
            for(int i =0; i<edge; i++){
                int v1 = sc.nextInt();
                int v2 = sc.nextInt();
                
                G.addEdge(v1-1, v2-1);
            }
            
            for(int i =0; i< vertex; i++){
                System.out.println();
                for(int j=0; j<vertex; j++){
                    System.out.print(G.matrix[i][j]);
                }
            }
            System.out.println();
            G.DFS(G, G.isVisited);
            vertex = sc.nextInt();
            edge = sc.nextInt();
        }
        
        
        // TODO code application logic here
    }
    
}
