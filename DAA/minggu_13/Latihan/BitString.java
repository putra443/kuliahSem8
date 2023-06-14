// package minggu_13.Latihan;
import java.util.Scanner;
import java.util.Arrays;


class BitString {
	static int[] abs;	//menyimpan bit string
	static int length;	//panjang dari bit string

	static void generateBS(int len) { //len menunjukkan index abs yang akan dicoba diisi dengan 0 atau 1
		if (len==-1) {	//jika len == -1, berarti satu bitstring sudah selesai dibuat
			System.out.println(Arrays.toString(abs));	//proses bisa apa saja, ini print ke layar
		}
		else {	// jika len != -1, kita coba isi di posisi tersebut
			abs[len]=0;			//coba diisi dengan 0
			if (abs[len]==0) {		//cek pengisian, ini bisa digunakan untuk mengecek hal2 lain
				generateBS(len-1);	//jika sesuai, isi bit string di posisi depannya (len-1)
			}
			abs[len]=-1;			//pos len akan diisi dengan yang lain, kembalikan dulu ke state awal

			abs[len]=1;		//coba diisi dengan 1
			if (abs[len]==1) {		//cek pengisian, ini bisa digunakan untuk mengecek hal2 lain
				generateBS(len-1);	//jika sesuai, isi bit string di posisi depannya (len-1)
			}
			abs[len]=-1;			//pos len akan diisi dengan yang lain, kembalikan dulu ke state awal
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		length = sc.nextInt();		//masukan panjang bit-string dari user
		abs = new int[length];		//deklarasi array abs sepanjang length
		Arrays.fill(abs,-1);			//inisialisasi array dengan nilai -1
		generateBS(length-1);			//mulai membuat bit string dari posisi length-1 (paling belakang)
	}
	
}