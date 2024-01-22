function Transfer(content, baseurl){
 var result = "";
 if(content.indexOf('<body>') > -1 && content.indexOf('</body>') > -1){
     result = content.substring(content.indexOf('<body>') + 6,content.indexOf('</body>'));
 }
 return result;
}