var list = new java.util.ArrayList();
list.add("s1");
list.add("s2");
list.add("s3");
//转js数组
var jsArray = Java.from(list);
print(jsArray);                                  // s1,s2,s3
print(Object.prototype.toString.call(jsArray));  // [object Array]