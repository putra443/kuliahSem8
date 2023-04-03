jumlah = int(input())
listBinatang = []
for i in range(jumlah):
    x = input()
    temp = x.split(' ')
    tuple = (temp[0], int(temp[1]), int(temp[2]))
    listBinatang.append(tuple)

listBinatangSortedWeight = sorted(listBinatang, key = lambda t: t[1]) 
listBinatangSortedHeight = sorted(listBinatang, key = lambda t: t[2]) 

print(listBinatang)
print()
print('Animals with min & max weight:')
print(listBinatangSortedWeight[0][0], listBinatangSortedWeight[0][1])
print(listBinatangSortedWeight[-1][0], listBinatangSortedWeight[-1][1])

print()
print('Animals with min & max height:')
print(listBinatangSortedHeight[0][0], listBinatangSortedHeight[0][2])
print(listBinatangSortedHeight[-1][0], listBinatangSortedHeight[-1][2])