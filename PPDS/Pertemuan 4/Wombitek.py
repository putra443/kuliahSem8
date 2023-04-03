t = int(input())

def wombitek(t):
    for x in range(t):
        counter = 0;
        bilangan = int(input())
        while(bilangan!=1):
            if(bilangan%2==0):
                counter+=1
                bilangan = bilangan/2
            else:
                counter+=1
                bilangan = (bilangan*3)+1
        print(counter+1)

wombitek(t)
        