var MyJavaClass = Java.type('com.kenshine.nashron.TestClass');
var result = MyJavaClass.fun1('kenshine');
print(result);
// 不同类型处理
MyJavaClass.fun2(123);
// class java.lang.Integer
MyJavaClass.fun2(49.99);
// class java.lang.Double
MyJavaClass.fun2(true);
// class java.lang.Boolean
MyJavaClass.fun2("hi there")
// class java.lang.String
MyJavaClass.fun2(new Number(23));
// class jdk.nashorn.internal.objects.NativeNumber
MyJavaClass.fun2(new Date());
// class jdk.nashorn.internal.objects.NativeDate
MyJavaClass.fun2(new RegExp());
// class jdk.nashorn.internal.objects.NativeRegExp
MyJavaClass.fun2({foo: 'bar'});
// class jdk.nashorn.internal.scripts.JO4

// 传递js对象
MyJavaClass.fun3({
    foo: 'bar',
    bar: 'foo'
});

function Person(firstName, lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
    this.getFullName = function() {
        return this.firstName + " " + this.lastName;
    }
}
var person1 = new Person("Peter", "Parker");
MyJavaClass.fun4(person1);

