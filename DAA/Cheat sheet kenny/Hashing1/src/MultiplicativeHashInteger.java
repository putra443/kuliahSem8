/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author i18051
 */
class MultiplicativeHashInteger<V> extends HashTable<Integer, V>{
    public MultiplicativeHashInteger(int capacity){
        super(capacity);
    }
    
    protected int hashFunction(Integer key){
        return (int) ((key*0.61803398875)%1);
    }
}
