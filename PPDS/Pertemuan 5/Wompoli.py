import math
n = int(input())
def wompoli(n):
    koordinat = []
    i = 0
    temp_hasil = 0
    for x in range(n):
        a = input()
        tuples = (int(a.split(" ")[0]),int(a.split(" ")[1]))
        koordinat.append(tuples)

    while i+1<n:
        temp_hasil += math.sqrt(math.pow(koordinat[i+1][0]-koordinat[i][0],2)+math.pow(koordinat[i+1][1]-koordinat[i][1],2))
        i+=1
    print(koordinat)
    print(temp_hasil)
wompoli(n)