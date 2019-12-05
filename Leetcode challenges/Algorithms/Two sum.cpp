/* 
Given an array of integers, return indices of the two numbers such that they add up to a specific target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
*/
class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        int index1,index2,i,j;
        std::vector<int> solution;
        int size=nums.size();
        for(index1=0;index1<size-1;index1++)
            {
                for(index2=index1+1;index2<size;index2++)
                {
                    if((nums[index1]+nums[index2])==target)
                        {
                        solution.push_back(index1);
                        solution.push_back(index2);
                        
                        return solution;
                        }
                }
            }
    return solution;
    }
    
};