
/*
Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.
The idea is:from 1 to 9,1 appears once,from 10 to infinity it appears 10^a-1 times
same with 1x,1xx,etc,they all appear 10^a-1 times,for every power of 10 bigger.
*/
class Solution {
public:
    int countDigitOne(int n) {
        int occurrences,remainder,exponent,quotient;
        if(n<10 && n>0)
            return 1;
        else if(n<10 && n==0)  
            return 0;
        else if(n>=10)
        {
            exponent=floor(log10(n));
            quotient=n/pow(10,exponent);
            remainder=n - pow(10,exponent)*quotient;
            occurrences= countDigitOne(remainder); //needs fixing
            if(quotient==1)
                occurrences+=remainder+1 +exponent;
            else occurrences+=pow(10,exponent)+ pow(10,exponent-1)*quotient; //and so does this
            
        }
        else if(n<0)
            return 0;
        return occurrences;
    }
};