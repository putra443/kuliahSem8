def folding(jumlah_angka):
    arr_angka = []
    angka= input()
    pembagi = 0
    for x in range(int(jumlah_angka)+1):
        if(int(x)<int(jumlah_angka)):
            arr_angka.append(angka.split(" ")[x])
        else:
            pembagi = angka.split(" ")[x]
            
    for x in range(int(jumlah_angka)):
        print(arr_angka[x])

    
    
    
n = input()    
folding(n)
        