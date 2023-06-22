import java.util.*;

/* helper ini dibuat berdasarkan kunci jawaban milik J. Helga */

/** IDE UTAMA:
- perhatikan bahwa peta bisa diisi oleh huruf (W/K) maupun angka. Untuk memudahkan, kita kodekan W = -1 dan K = -2 dan kosong = -3 (0 untuk "belum ditentukan isinya")
- (lihat contoh kasus di soal) ada 6 kotak {(0,1),(0,2),(1,0),(1,2),(2,0),(2,1)} yang mungkin diisi wombat (-1) atau kapibara (-2) atau dibiarkan kosong (0). 
- jadi ada n=6 posisi yang bisa diisi dengan k=3 kemungkinan isi setiap posisi --> k-ary string:
	misal: 000000 berarti semuanya kosong atau 0-10-200-1 berarti ada wombat di posisi (0,2) dan (2,1), ada kapibara di posisi (1,2), sisanya kosong. 
	kemudian akan dicari semua 3-ary string yang mungkin. Backtracking di sini adalah, setelah mencoba mengisi posisi yang kosong dengan -1/-2/0 dilakukan pemeriksaan apakah solusi masih valid. Jika tidak, maka dilakukan backtracking 
- untuk mempermudah, posisi kosong dibuat dalam struktur data tersendiri (emptyCell)

*/
 
class DodoSweeper{
    private int[][] peta;				//peta
    private int size, wombat, kapibara; 	//ukuran peta, banyaknya wombat, banyaknya kapibara
    private int nEmpty;				//banyaknya kotak kosong
	private int[][] emptyCell;			//menyimpan posisi dari kotak kosong. Misal untuk kotak kosong keempat (1,2) --> emptycell[3][0]-->1 dan emptycell[3][1] -->2
 
    public DodoSweeper(int size, int[][] peta, int wombat, int kapibara){
 
		//isi instance variabel size, peta, wombat, dan kapibara

        emptyCell = new int[size*size][2]; 	//inisialisasi emptycell
 
        //bangun array emptyCell yang berisi koordinat semua cell peta yang 0
        for(int i=0; i<size; i++){
            for(int j=0; j<size;j++){
                if(peta[i][j]==0){
                    emptyCell[nEmpty][0] = i;
                    emptyCell[nEmpty][1] = j;
                }
            }
        }
		//jangan lupa catat banyaknya kotak kosong di nEmpty
        nEmpty++;
    }
 
    private int count(int i, int j){	//menghitung berapa score di poisisi peta[i][j]
        int result = 0;		//result adalah skor di posisi i,j
		//hitung di sini
        if(peta[i][j-1]==-1 || peta[i][j+1]==-1){
            result--;
        }
        if(peta[i][j-1]==-2 || peta[i][j+1]==-2){
            result-=2;
        }
        if(peta[i-1][j-1]==-1 || peta[i+1][j+1]==-1){
            result--;
        }
        if(peta[i-1][j-1]==-2 || peta[i+1][j+1]==-2){
            result-=2;
        }
        if(peta[i-1][j]==-1 || peta[i+1][j]==-1){
            result--;
        }
        if(peta[i-1][j]==-2 || peta[i+1][j]==-2){
            result-=2;
        }
        return result;
    }
 
    //penempatan saat ini merupakan solusi kalau semua
    //count() di posisi wombat/kapibara cocok dengan score peta
    private boolean isSolution(){
        boolean flag = true;	//dianggap solusi, false jika bukan solusi
		//jika di satu posisi isinya bilangan positif, 
		//hitung apakah penempatan wombat, kapibara, dan "kosong"-nya sesuai dengan bilangan di posisi itu 
        for(int i=0; i<size; i++){
            for(int j=0; j<size; j++){
                if(peta[i][j]>0){
                peta[i][j] = count(i, j);
                if(peta[i][j]<0){
                    flag = false;
                    return flag;
                }
                }
            }
        }
        return flag;
    }
  
    //masih valid kalau penempatan wombat & kapibara saat ini belum melebihi score yang ada di peta
	//bedakan isVALID dan isSOLUTION, isValid hanya memeriksa apakah peta saat ini masih benar
	//artinya mungkin di posisi tertentu, belum semua wombat atau kapibara ditempatkan di sebelah2nya
    private boolean isValid(){
        boolean flag = true;
 		//jika di satu posisi isinya bilangan positif, 
		//hitung apakah penempatan wombat, kapibara, dan "kosong"-nya masih kurang dari bilangan di posisi itu 
		//kalau masih kurang berarti masih valid, kalah lebih berarti tidak valid
        for(int i=0; i<size; i++){
            for(int j=0; j<size;j++){
                if(peta[i][j]>0){
                    peta[i][j] = count(i,j);
                    if(peta[i][j])
                }
            }
        }
        return flag;
    }

    public int solve(){
        return solve(0);
    }

 
    //solver rekursif
    private int solve(int idx){			//idx adalah posisi pada k-ary string (kotak kosong) yang akan diisi
        int nSolution=0;		//jumlah solusi jika poisisi idx "diisi" sesuatu 
							//(jumlah solusi jika diisi wombat + jml solusi jika diisi kapibara + jml solusi jika kosong)
 
        if(idx == nEmpty){    	//jika idx == nEmpty, berarti keseluruhan kotak sudah terisi wombat/kapibara/kosong dan bisa dievaluasi hasilnya 
            if(true){         //cek apakah k-ary strig sekarang adalah solusinya
                return 1;		//jika ya, return 1, berarti 1 solusi sudah ditemukan
            }
            else {
                return 0;		//jika bukan solusi, return 0
			}
        }
        else{    			//idx < nEmpty, berarti saatnya mencoba mengisi posisi ke idx
            int row, col; 	//posisi idx di peta
            row = emptyCell[idx][0];
            col = emptyCell[idx][1];
			
			//coba isi dengan wombat
            if(wombat>0){	//coba taruh wombat kalau masih ada wombat yg bisa ditaruh
				//taruh wombat di peta
                peta[row][col] = -1;
				//wombat yg belum ditaruh berkurang satu 
                wombat--;
                if(isValid())  {                         //cek apakah solusi SEMENTARA ini VALID atau tidak (bukan apakah ini SOLUSI sebenarnya atau bukan)
                    nSolution = nSolution + solve(idx+1); //jika solusi sementara valid, berarti kita coba mengisi posisi k-ary string yang berikutnya 
													//dan hasilnya ditambahkan ke nSolustion saat ini 
				}	
				//backtrack:
				//cabut wombat dari peta
                peta[row][col]=0;
                //wombat yg belum ditaruh bertambah satu
                wombat++; 
            }
			
			/*lalu sekarang coba isi dengan kapibara*/
			if(kapibara>0){	//coba taruh kapibara kalau masih ada wombat yg bisa ditaruh
				//taruh wombat di peta
                peta[row][col] = -2;
				//wombat yg belum ditaruh berkurang satu 
                kapibara--;
                if(isValid())  {                         //cek apakah solusi SEMENTARA ini VALID atau tidak (bukan apakah ini SOLUSI sebenarnya atau bukan)
                    nSolution = nSolution + solve(idx+1); //jika solusi sementara valid, berarti kita coba mengisi posisi k-ary string yang berikutnya 
													//dan hasilnya ditambahkan ke nSolustion saat ini 
				}	
				//backtrack:
				//cabut wombat dari peta
                peta[row][col]=0;
                //wombat yg belum ditaruh bertambah satu
                kapibara++; 
            }
			/*lalu sekarang coba isi dengan" kosong*/
            if(true){	//coba taruh kosong 
				//taruh wombat di peta
                peta[row][col] = -3;

				//backtrack:
				//cabut wombat dari peta
                peta[row][col]=0;

            }
			//tidak perlu dicek valid atau gak ya, karena kan kalo kosong tuh pasti bener, gak pengaruh ke sebelah2nya 
 
            return nSolution;
        }
    }
}
 
class Tester{
    public static void main(String[] args){ 	//main program
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();			//ukuran peta
        int wombat = sc.nextInt();			//banyaknya wombat
        int kapibara = sc.nextInt();			//banyaknya kapibara
        int peta[][] = new int[size][size];	//inisialisasi peta
 
        //baca input dan isi peta
        for(int i=0; i<size;i++){
            for(int j=0; j<size; j++){
                peta[i][j] = sc.nextInt();
            }
        }
        //solve + print solusi
        DodoSweeper solver = new DodoSweeper(size, peta, wombat, kapibara);
        System.out.println(solver.solve());
    }
}