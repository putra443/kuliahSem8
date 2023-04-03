/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author i18051
 */
class FoldingHashInteger<V> extends HashTable<Integer, V> {

    public FoldingHashInteger(int capacity) {
        super(capacity);
    }

    protected int hashFunction(Integer key) {
        int res = 0;
        int sisa = key;
        boolean stat = true;
        while (sisa > 0) {
            if (stat) {
                res += key % 1000;
                stat=false;
            } else {
                int num = sisa%1000;
                while (num != 0) {
                    int digit = num % 10;
                    res = res * 10 + digit;
                    num /= 10;
                }
                stat=true;
            }
            sisa = sisa / 1000;
        }
        return (res%1000)%this.capacity;
    }
}
