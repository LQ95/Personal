function rangeOfNumbers(startNum, endNum) {
  if(startNum>endNum)
  return [];
  else if(startNum===endNum)
  {
    const arr=rangeOfNumbers(startNum+1, endNum-1)
    arr.push(startNum);
    return arr;
  }
  else{
    const arr2=rangeOfNumbers(startNum+1, endNum-1)
    arr2.push(endNum);
    arr2.unshift(startNum);
    return arr2
  }

};

console.log(rangeOfNumbers(1, 5));