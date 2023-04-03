/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author i18051
 */
public class DisjointSets {
    int[] parents;
    int[] ranks;
    int numOfElements;
    
    DisjointSets(int numOfElements){
        this.numOfElements=numOfElements;
        this.parents=new int[numOfElements];
        this.ranks=new int[numOfElements];
        int i;
        for (i=0;i<numOfElements;i++){
            this.parents[i]=i;
            this.ranks[i]=0;
        }
    }
    
    public int findSets(int element){
        if (this.parents[element]==element){
            return element;
        }else{
            int result=findSets(this.parents[element]);
            parents[element]=result;
            return result;
        }
    }
    
    public void union(int element1, int element2){
        int rep1=this.findSets(element1);
        int rep2=this.findSets(element2);
        
        if (rep1==rep2){
            return;
        }
        
        int rank1=ranks[rep1];
        int rank2=ranks[rep2];
        
        if (rank1<rank2){
            this.parents[rep1]=rep2;
        }else if(rank2<rank1){
            this.parents[rep2]=rep1;
        }else{
            this.parents[rep1]=rep2;
            ranks[rep2]++;
        }
    }
}
