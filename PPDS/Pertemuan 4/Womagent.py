n = int(input())


def faktorPrima(n):
    max = -1
    i = 2
    while i * i <= n:
        while n % i == 0:
            max = i
            n = n // i
        i = i + 1
    if n > 1:
        max = n
    return max

def isPrime(n):
    flag = True
    i=2
    for x in range(2,n):
        if(n%x==0):
            flag = False
            break


def womagent(n):
    angka = []
    for x in range(n):
        angka.append(int(input()))
    for y in range(len(angka)):
        if(isPrime(n)):
            print(1)
        else:
            print(faktorPrima(angka[y]))
    

womagent(n)