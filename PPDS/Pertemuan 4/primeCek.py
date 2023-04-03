def primenumber(cek):
    flag = True
    for z in range(2,cek):
        if(cek%z==0):
            flag=False
            break
    return flag


print(primenumber(int(input())))