def tahunKabisat(tahun):
    if(tahun%4==0):
        if(tahun%100==0):
            if(tahun%400==0):
                return True
            else:
                return False
        else:
            return True

    else:
        return False
    
def kalender(tanggal, bulan, tahun):
    #jika tahun kabisat
    if(tanggal==28 and bulan == 2):
        if(tahunKabisat(tahun)==True):
            print(int(tanggal)+1, '0'+str(bulan), tahun)
        else:
            tanggal = 1
            bulan +=1
            print('0'+str(tanggal), '0'+str(bulan), tahun)
    #jika tanggal 30 dengan bulan yang tanggalnya sampai 31
    elif(tanggal==30 and (bulan==1 or bulan==3 or bulan==5 or bulan==7 or bulan==8 or bulan==10 or bulan==12) and bulan<9):
        tanggal+=1
        print(tanggal, '0'+str(bulan), tahun)
    elif(tanggal==30 and (bulan==1 or bulan==3 or bulan==5 or bulan==7 or bulan==8 or bulan==10 or bulan==12) and bulan>9):
        tanggal+=1
        print(tanggal, bulan, tahun)
    #jika tanggal 31 
    elif(tanggal==31 and (bulan==1 or bulan==3 or bulan==5 or bulan==7 or bulan==8 or bulan==10 or bulan==12)):
        tanggal=1
        bulan+=1
        if(bulan<9):
            print('0'+str(tanggal), '0'+str(bulan), tahun)
        else:
            print('0'+str(tanggal), bulan, tahun)

    #jika tanggal 30 dengan bulan yang tanggalnya sampai 30
    elif(tanggal==30 and (bulan==2 or bulan==4 or bulan==6 or bulan==9 or bulan==11)):
        tanggal=1
        bulan+=1
        if(bulan<9):
            print('0'+str(tanggal), '0'+str(bulan), tahun)
        else:
            tanggal=1
            bulan+=1
            print('0'+str(tanggal), bulan, tahun)
    #jika ganti tahun
    elif (tanggal==31 and bulan ==12):
        tanggal =1
        tahun+=1
        bulan = 1
        print('0'+str(tanggal), '0'+str(bulan), tahun)
    #jika ganti tanggal biasa
    else:
        tanggal+=1
        if(tanggal<9):
            if(bulan<=9):
                print('0'+str(tanggal), '0'+str(bulan), tahun)
            else:
                print('0'+str(tanggal), bulan, tahun)
        elif(tanggal>9):
            if(bulan<=9):
                print(tanggal, '0'+str(bulan), tahun)
            else:
                print(tanggal, bulan, tahun)     

string_input = input()
tanggal = int(string_input.split(" ")[0])
bulan = int(string_input.split(" ")[1])
tahun = int(string_input.split(" ")[2])

kalender(tanggal, bulan, tahun)
