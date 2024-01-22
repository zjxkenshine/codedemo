// 函数字面值
function sqr(x) x * x;
print(sqr(3));    // 9
// 属性绑定
var o1 = {};
var o2 = { foo: 'bar'};
Object.bindProperties(o1, o2);
print(o1.foo);    // bar
o1.foo = 'BAM';
print(o2.foo);    // BAM
// 字符串去空白
print("   hehe".trimLeft());            // hehe
print("hehe    ".trimRight() + "he");   // hehehe
// 位置
print(__FILE__, __LINE__, __DIR__);
// 作用域
var imports = new JavaImporter(java.io, java.lang);
with (imports) {
    var file = new File(__FILE__);
    System.out.println(file.getAbsolutePath());
    // /path/to/my/script.js
}
// 数组转换
