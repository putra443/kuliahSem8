/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author RamaFS
 */
class TesterHash {
    public static void main(String[] args) {
        ModularHashInteger<String> h = new ModularHashInteger<String>(11, 3, 2);
        h.insert(5, "Alice");
        h.insert(16, "Bob");
        h.insert(27, "Charlie");
        
        h.delete(16);
        
        System.out.println(h.search(5));
        System.out.println(h.search(16));
        System.out.println(h.search(27));
    }
}
