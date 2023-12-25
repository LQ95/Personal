#The 11th exercise from the Elementary section at: https://adriann.github.io/programming_problems.html

#the assigment reads as follows:
#Write a program that computes the sum of an alternating series,
#where each element of the series is an expression of the form ((-1)^k+1)/(2*k-1)
#for each value of k from 1 to a million, multiplied by 4.


def SeriesSum():
    k=0
    k2=1
    currterm=0
    series_sum=0
    backspace=""

    for k2 in range(1,1000000):
        k=0
        while k<k2:
            series_sum=+currterm
            currterm=pow(-1,k+1)/(2*k+1)
            k=k+1
        series_sum=series_sum*4
        if series_sum <0:
            backspace="\b"
        print("per k= " + str(k) + u" la somma moltiplicata per 4 è : " + backspace + str(series_sum),end='\r')
        series_sum=0
        backspace=""

       
        

SeriesSum()