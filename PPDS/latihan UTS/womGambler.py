jumlahTahun = int(input())

jumlahPendapatan = input()

jumlahPendapatanSplit = jumlahPendapatan.split(' ')

for i in range(len(jumlahPendapatanSplit)):
    jumlahPendapatanSplit[i] = int(jumlahPendapatanSplit[i])


hasilTerbesar = []

for x in range(jumlahTahun):
    hasil = []
    i = 0
    j = 1

    pertambahani = 1
    pertambahanj = 2

    while j <= len(jumlahPendapatanSplit):
        jumlahPerTahun = jumlahPendapatanSplit[i:j]
        i += pertambahani
        j += pertambahanj

        pertambahani += 1
        pertambahanj += 1

        jumlahTotal = sum(jumlahPerTahun)
        hasil.append(jumlahTotal)

    hasilTerbesar.append(sum(hasil))
    jumlahPendapatanSplit.pop(0)


print(max(hasilTerbesar))