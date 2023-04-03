/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
import java.util.*;
/**
 *
 * @author Fransiskus Putra
 */
//public class Tugas2 {
//
//    /**
//     * @param args the command line arguments
//     */
//
//    
//}
public class Tugas2{
    int vertex;
    int [][] matrix;
    
    public Tugas2(int vertex){
        this.vertex = vertex;
        this.matrix = new int[vertex][vertex];
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
    
//    public String cekEuler(Tugas2 g,int edge){
//        String euler = "";
//        if(g.vertex==1 && edge == 0){
//        euler = "EULER";
//        return euler;
//        }
//        else{
//            for(int i =0; i<g.vertex;i++){
//            int counter  =0;
//            if(counter % 2 >0){
//                euler = "!EULER";
//                return euler;
//            }
//            for(int j = 0; j<g.vertex; j++){
//                counter += g.matrix[i][j];
//            }
//            if(counter % 2 >0){
//                euler = "!EULER";
//                return euler;
//            }
//            if(counter % 2 ==0){
//                euler = "EULER";
//                return euler;
//            }
//        }
//        
//        euler = "EULER";
//        return euler;
//        }
//        
//    }
        public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        int vertex = sc.nextInt();
        int edge = sc.nextInt();
        
        int [] arrTitik1 = new int[edge];
        int [] arrTitik2 = new int[edge];
        
        for(int i =0; i<edge; i++){
            arrTitik1[i] = sc.nextInt();
            arrTitik2[i] = sc.nextInt();
        }
        
        Tugas2 G = new Tugas2(vertex);
        G.initiate();
        for(int i = 0; i<edge; i++){
            G.addEdge(arrTitik1[i]-1,arrTitik2[i]-1);
            G.addEdge(arrTitik2[i]-1,arrTitik1[i]-1);
        }
        
        for(int i = 0; i<vertex; i++){
            System.out.println();
            for(int j = 0; j<vertex; j++){
                System.out.print(G.matrix[i][j] + " ");
            }
        }
        
        String euler = "";
        
        for(int i=0; i<G.vertex;i++){
            int counter = 0;
            for(int j=0; j<G.vertex;j++){
                counter += G.matrix[i][j];
            }
            if(counter%2>0){
                euler = "!EULER";
                break;
            }
            else{
                euler = "EULER";
            }
        }
        System.out.println();
        System.out.println(euler);
    }
}