/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author i18051
 */
public class TesterHash {
    public static void main(String[] args) {
        ModularHashString<String> h = new ModularHashString<String>(11);
        h.insert("5", "John Smith");
        h.insert("ab", "Jane Smith");
        System.out.println(h.search("5"));
        System.out.println(h.search("ab"));
    }
}
