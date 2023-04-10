def panitiaLomba():
    string_harga = input()
    harga_hijau = string_harga.split(" ")[0]
    harga_ungu = string_harga.split(" ")[1]
    jumlah_peserta = input()
    tantangan_a = []
    tantangan_b = []
    for x in range(int(jumlah_peserta)):
        status_tantangan = input()
        tantangan_a.append(status_tantangan.split(" ")[0])
        tantangan_b.append(status_tantangan.split(" ")[1])
        
    total_tantangan_A = 0
    total_tantangan_B = 0
    
    for x in range(int(jumlah_peserta)):
        total_tantangan_A+= int(tantangan_a[x])
        total_tantangan_B+= int(tantangan_b[x])
        
    
    
    totalBayar1 = (int(total_tantangan_A)*int(harga_hijau))+(int(total_tantangan_B)*int(harga_ungu))
    totalBayar2 = (int(total_tantangan_B)*int(harga_hijau))+(int(total_tantangan_A)*int(harga_ungu))
    
    print (min(totalBayar1, totalBayar2))
n = input()
for x in range(int(n)):
    panitiaLomba()
    
    