input = int(input())

def WomboTek(a):
    jumlah_baris = input+(2*(input+1)) 
    for x in range(jumlah_baris):
        if((x+1)%3==0 and x!=0):
            print("*****")
        else:
            print("*   *")

WomboTek(input)
