def juaraDua(N):
    list_angka = []
    angka = input()
    for x in range (N):
        list_angka.append(angka.split(" ")[x])
        
    max1 = max(list_angka)
    temp = 0
    for x in range(N):
        if(int(list_angka[x])>int(temp) and int(list_angka[x])<int(max1)):
            temp = list_angka[x]
    print(temp)
    
N = input()
juaraDua(int(N))