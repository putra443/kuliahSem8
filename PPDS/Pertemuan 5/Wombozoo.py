n = int(input())
def wombozoo(n):
    list_info = []
    for x in range(n):
        a = input()
        tuples = (a.split(" ")[0],int(a.split(" ")[1]),int(a.split(" ")[2]))
        list_info.append(tuples)

    list_infoWeight = sorted(list_info,key=lambda t: t[1])
    list_infoHeight = sorted(list_info,key=lambda t: t[2])
    print(list_info)
    print()
    print("Animals with min & max weight:")
    print(list_infoWeight[0][0],list_infoWeight[0][1])
    print(list_infoWeight[n-1][0],list_infoWeight[n-1][1])
    print("Animals with min& max height")
    print(list_infoHeight[0][0],list_infoHeight[0][2])
    print(list_infoHeight[n-1][0],list_infoHeight[n-1][2])


wombozoo(n)