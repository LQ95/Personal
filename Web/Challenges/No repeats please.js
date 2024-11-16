function replaceAt (str,index, replacement) {
    return str.substring(0, index) + replacement + str.substring(index + replacement.length);
}

function swap(str,index1,index2){
  let char1=str[index1];
  let char2=str[index2];
  str=replaceAt(str,index1,char2);
  str=replaceAt(str,index2,char1);
  return str;
}

function permAlone_recursive(str){
  let returned=0;
  if(str.length==1)
  {
    return 1;
  }
  else{
    let sub,i;
    for(i=0;i<str.length;i++){
      if(str[i]!=str[0])
          {
            sub=swap(str,1,i);
            returned=returned+permAlone_recursive(sub.substring(1));
          }
      
    }
    return returned;
  }
}

function permAlone(str) {
  let sub,i,sum=0;
    for(i=0;i<str.length;i++){
      sub=swap(str,0,i);
      sum+=permAlone_recursive(sub);
    }
    return sum;
}
