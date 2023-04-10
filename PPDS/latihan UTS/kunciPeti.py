jumlah_bilangan = input()

def kunciPeti(jumlah_bilangan):
    arr_bilangan = []
    deretan_bilangan = input()
    for x in range(int(jumlah_bilangan)):
        arr_bilangan.append(deretan_bilangan.split(" ")[x])
    print(arr_bilangan)
    string_bilangan1 = ""
    string_bilangan2 = ""
    for x in range(int(jumlah_bilangan)):
        if(x<int(int(jumlah_bilangan)/2)):
            string_bilangan1 += arr_bilangan[x][0]
        else:
            string_bilangan2 += arr_bilangan[x][int(len(arr_bilangan[x])-1)]
    
    string_gabungan = string_bilangan1+string_bilangan2
    if(int(string_gabungan)%11==0):
        return "OUI"
    else:
        return "NON"
print(kunciPeti(jumlah_bilangan))