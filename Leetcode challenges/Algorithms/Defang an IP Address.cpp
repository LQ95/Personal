/*
Given a valid (IPv4) IP address, return a defanged version of that IP address.

A defanged IP address replaces every period "." with "[.]".

 
*/

class Solution {
public:
    string defangIPaddr(string address) {
        string current_num;
        string newIP="";
        int points=0;
        unsigned int lastPointIndex=0;
        unsigned int beforeLastPoint=0;
        while(points<4)
        {
            lastPointIndex=address.find(".",lastPointIndex+1);
            if(lastPointIndex!=string::npos)
                {
                current_num=address.substr(beforeLastPoint,lastPointIndex-beforeLastPoint);
                if(points<3)
                    {
                    newIP=newIP+current_num+"[.]";
                    }
                else newIP=newIP+current_num;
                }
            points++;
            beforeLastPoint=lastPointIndex+1;
        }
        return newIP;
    }
};