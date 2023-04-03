import java.util.Scanner;
/*
ide:
- Membuat kelas tree yang dapat dicompare komponennya.
- Membuat innerclass node yang merupakan komponen dari tree
- Membuat method - method pendukung seperti insert, search, max, min untuk operasi tree.
*/
class BST <T extends Comparable<T>>{
    private Node root;                      //attribute kelas tree

    @Override
    public String toString(){
        return inorder(this.root);
    }                                       //membuat tree dapat di print sebagai string

    private String inorder(Node x){             //membuat tree yang akan di print dengan susunan inorder
        if(x==null)
            return ";";                         //jika node bernilai null, maka return ;
        if(x.left == null && x.right == null)   //jika anak kiri dan kanan node bernilai null maka return node;
            return x.toString();
        else
            return inorder(x.left) + x.toString() + inorder(x.right); //jika memiliki anak kanan / anak kiri return dengan urutan anak kiri , node x , anak kanan
    }
    //inner class Node yang merupakan attribute dari class tree
    private class Node{
        T info;                     //setiap node dianggap 1 tree dengan memiliki attribute info
        Node left, right, parent;   //node memiliki attribute juga anak kiri, kanan, dan parent

        Node(T info){
            this.info = info;       //inisialisasi attribute
        }

        @Override
        public String toString(){
            return "["+this.info.toString() + "]"; //per node nantinya dapat di print dengan format [Node]
        }
    }
    //method untuk insert node dengan parameter info node
    public void insert(T data){         
        Node newNode = new Node(data);  //membuat node baru
        Node curr = this.root;          //untuk menyimpan node current
        Node parent = null;             //inisialisasi parent untuk node baru

        if(this.root == null){          //jika root dari tree = null
            this.root = newNode;        //node baru menjadi root
        }
        else{
            while(curr!=null){                      //selama current node = null
                parent = curr;                      //variable parent dijadikan current node
                if(data.compareTo(curr.info)<0){    //jika node baru lebih kecil dari current node
                    curr = curr.left;               //geser current node ke anak kiri
                }
                else{
                    curr = curr.right;              //geser current node ke anak kanan
                }
            }
            newNode.parent = parent;                //set parent node baru dengan current node
            if(data.compareTo(parent.info) <0){     //jika node baru lebih kecil dari parent
                parent.left = newNode;              //set anak kiri dari parent menjadi node baru
            }                                        
            else{                                   
                parent.right = newNode;             //set anak kanan dari  parent menjadi node baru
            }
        }
    }
    //method yang akan dipanggil untuk mencari node tertentu dengan parameter data node
    public T search(T data){
        Node result = search(data, this.root);      //set node res = method search
        if(result == null)                          //jika hasil null
            return null;                            // return null
        else
            return result.info;                     //return info dari res
    }
    //method private untuk mencari node tertentu dengan parameter data node dan curr node
    private Node search (T data, Node curr){        
        if(curr == null)                            //jika current node = null
            return null;                            //return null
        else if(curr.info.compareTo(data)== 0)      //jika current node = dari data node
            return curr;                            //return cuurent node
        else if(curr.info.compareTo(data)< 0)       //jika current node < data node
            return search(data, curr.right);        // search lagi dengan parameter data node, dan anak kanan dari current node
        return search(data, curr.left);             //search lagi dengan parameter data ndoe dan anak kiri dari current node

    }
    //method yang akan dipanggil untuk mencari node terkecil
    public T min(){
        Node result = min (this.root);        //inisialisasi node res = pemanggilan method private min 
        if(result == null)                    //jika res = null
            return null;                      //return null
        else
            return result.info;               //return info dari res
    }
    //private method untuk mencari node terkecil
    private Node min(Node curr){
        if(curr == null)                      //jika current node bernilai null
            return curr;                      //return current node
        
        else                                
            while(curr.left != null)          //selama anak kiri current node tidak sama dengan null
                curr = curr.left;             //ganti curr node dengan anak kiri dari curr node
            return curr;                      //return current node
    }
    //method yang akan dipanggil untuk mencari max node
    public T max() {                        
        Node result = max (this.root);      //inisialisasi node res = pemanggilan method private max
        if(result == null)                  //jika res = null
            return null;                    //return null
        else                                
            return result.info;             //return info dari res
    }
    //method private untuk mencari max node
    private Node max (Node curr){
        if(curr==null)                      //jika current node bernilai null
            return null;                    //return current node
        else
            while(curr.right != null)       //selama anak kiri current node tidak sama dengan null
                return curr.right;          //ganti curr node dengan anak kiri dari curr node
            return curr;                    //return current node
    }
    //method private untuk mencari successor dari node tertentu
    private Node successor(Node curr){
        Node y = curr.parent; 
        if(curr==null){
            return null;
        }                                    //node y =  current node parent
        if(curr.right != null)              //jika anak kanan curr node !=null
            return min(curr.right);         //return nilai terkecil dari anak kanan curr node
        else   
            y = curr.parent;                        //y = curr node parent
            while(y !=null && curr.info == y.right)      //selama y!=null dan curr node =anak kanan dari node y
                curr = y;                           //curr node= y
                y = y.parent;                       //y = parent dari y
            return y;                               //return y
    }
    //method private untuk mencari predecessor dari node tertentu
    private Node predecessor(Node curr){
        Node y = curr.parent;                   //node y =  current node parent
        if(curr.left != null)                  //jika anak kiri curr node !=null
            return max(curr.left);              //return nilai terbesar dari anak kiri curr node
        else
            y = curr.parent;                    //y = curr node parent
            while(y !=null && curr == y.left)   //selama y!=null dan curr node =anak kiri dari node y
                curr = y;                       //curr node= y
                y = y.parent;                   //y = parent dari y
            return y;                           //return y
    }
    //method yang akan dipanggil di tester delete node tertentu
    public boolean delete(T data){
        Node del = search(data, this.root);
        if(del == null)
            return false;
        
        else
            delete(del);
            return true;
    }
    //private method untuk delete node tertentu
    private void delete(Node del){
        //kalo gapunya anak
        if(del.left ==null && del.right == null){
            if(del.parent.left==del){
                del.parent.left = null;
            }
            else{
                del.parent.right = null;
            }
        }
        // kalo anaknya satu, anak kiri
        else if(del.left !=null && del.right==null){
            if(del.parent.left==del){
                del.parent.left = del.left;
            }
            else{
                del.parent.right = del.left;
            }
        }
        //kalo anaknya satu, anak kanan
        else if(del.left ==null && del.right!=null){
            if(del.parent.left==del){
                del.parent.left = del.right;
            }
            else{
                del.parent.right = del.right;
            }
        }
        // anaknya 2 
        else{
            Node successor = successor(del);
            del.info = successor.info;
            delete(successor);


        }     
    }
}

class testerBST{
    public static void main (String[]args){
        BST<Integer> bst = new BST<Integer>();
        bst.insert(5);          //insert node
        bst.insert(14);         //insert node
        bst.insert(8);          //insert node
        bst.insert(3);          //insert node
        bst.insert(11);         //insert node
        bst.insert(10);         //insert node

        System.out.println(bst);
        System.out.println(bst.search((10)));
        System.out.println(bst.search(3));
        System.out.println(bst.search(5));
        bst.delete(10);
        System.out.println(bst);

    }
}