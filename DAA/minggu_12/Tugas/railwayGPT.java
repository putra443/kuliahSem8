import java.util.*;

public class railwayGPT {
    public static int findMaxOverlap(int[] arrivals, int[] departures) {
        int n = arrivals.length;

        // Mengurutkan array kedatangan dan keberangkatan secara terpisah
        Arrays.sort(arrivals);
        Arrays.sort(departures);

        int maxOverlap = 0;
        int currentOverlap = 0;
        int arrivalIndex = 0;
        int departureIndex = 0;
        System.out.println(Arrays.toString(arrivals));
        System.out.println(Arrays.toString(departures));

        // Melakukan pencarian jumlah maksimal overlap
        while (arrivalIndex < n && departureIndex < n) {
            if (arrivals[arrivalIndex] < departures[departureIndex]) {
                // Interval kedatangan
                currentOverlap++; // Meningkatkan jumlah overlap
                maxOverlap = Math.max(maxOverlap, currentOverlap);

                arrivalIndex++; // Mengecek interval kedatangan berikutnya
            } else {
                // Interval keberangkatan
                currentOverlap--; // Mengurangi jumlah overlap

                departureIndex++; // Mengecek interval keberangkatan berikutnya
            }
        }

        return maxOverlap;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] waktuMasuk = new int[n];
        int[] waktuKeluar = new int[n];

        for(int i=0; i<n; i++){
            int masuk = Integer.valueOf(sc.next()+sc.next());
            int keluar = Integer.valueOf(sc.next()+sc.next());
            waktuMasuk[i] = masuk;
            waktuKeluar[i] = keluar;
        }
        int tumpuk = findMaxOverlap(waktuMasuk, waktuKeluar);
        System.out.println(tumpuk);
    }
}