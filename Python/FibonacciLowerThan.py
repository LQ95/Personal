
def FibonacciLowerThan(cap):

    a,b=0,1
    c=0
    swap=0
    index=1

    while c in range(0,cap):
        print("c = " + str(c) + "\n" +"indice successione:" + str(index) +"\n")
   
        a=0
        b=1
        while a <= c:
            print(a)
            swap=a
            a=b
            b=swap+b
        c=b
        index=index+1
        print("\n")

FibonacciLowerThan(300)
FibonacciLowerThan(1000)
FibonacciLowerThan(3000)