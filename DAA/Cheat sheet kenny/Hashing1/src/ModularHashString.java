/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author i18051
 */
class ModularHashString<V> extends HashTable<String, V>{
    public ModularHashString(int capacity){
        super(capacity);
    }
    
    protected int hashFunction(String key){
        int res = 0;
        char[] ch = new char[key.length()]; 
        for (int i = 0; i < key.length(); i++) { 
            ch[i] = key.charAt(i); 
        } 
        for (int i = 0; i<key.length(); i++){
            res+=(int)ch[i];
        }
        return res%this.capacity;
    }
}