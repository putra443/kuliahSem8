string_plat = input()
def penyusup(string_plat):
    sebelahan1 = int(string_plat[0])+int(string_plat[1])
    sebelahan2 = int(string_plat[3])+int(string_plat[4])
    sebelahan3 = int(string_plat[4])+int(string_plat[5])
    sebelahan4 = int(string_plat[7])+int(string_plat[8])
    huruf = string_plat[2]
    if(sebelahan1%2==0 and sebelahan2%2==0 and sebelahan3%2==0 and sebelahan4%2==0 and (huruf=="A" or huruf=="I" or huruf=="U" or huruf=="E" or huruf=="O")):
        return True
    else:
        return False
    
hasil = penyusup(string_plat)
if(hasil==True):
    print("valid")
else:
    print("invalid")
    