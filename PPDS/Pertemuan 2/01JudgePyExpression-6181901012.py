x= int(input())
jam = x//3600
menit = (x-(jam*3600))//60
detik = (x -(jam*3600))-(menit*60)
print (x,"s = ",jam ,"h + " , menit , "m + " , detik ,  "s")