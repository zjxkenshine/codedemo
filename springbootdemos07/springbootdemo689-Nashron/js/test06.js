// 使用java arraylist
var ArrayList = Java.type('java.util.ArrayList');
var list = new ArrayList();
list.add('a');
list.add('b');
list.add('c');
for each (var el in list) print(el);
// 使用hashmap
var map = new java.util.HashMap();
map.put('foo', 'val1');
map.put('bar', 'val2');
for each (var e in map.keySet()) print(e);
for each (var e in map.values()) print(e);