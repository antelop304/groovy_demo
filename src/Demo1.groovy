import groovy.transform.PackageScope

import java.util.concurrent.CountDownLatch
import java.util.concurrent.TimeUnit

/**
 * Created by zhanls on 2019/4/15.
 */

println("hello groovy~")
println("hello world!")
println(Math.cos(30))


// 多重方法
int method(String arg) {
    return 1;
}
int method(Object arg) {
    return 2;
}
Object obj = "Object"
int result = method(obj)
println(result)


// 数组、map
int[] arr = [1, 2, 3]
System.err.println(arr[1])
def arr2 = [4, 5, 6] as int[]
println arr2[1]
def colors = [red: '#FF0000', green: '#00FF00', blue: '#0000FF']
println colors['red']
colors.green = '#00FG00'
println colors.green
colors["pink"] = '#FF00FF'
println colors.pink
colors.yellow = '#FFFF00'
println colors.yellow
def keyval = "name"
def p = [keyval: "zhangsan"]
println p.name
println p.keyval
p = [(keyval): "lisi"]
println p.name
println p.keyval



for (int step : 1..5) {
    println step
}


// POJO getter setter
class Person {
    @PackageScope Integer age
    String name
    String skill
}
def person = new Person(name: "李四")
person.age = 18
println(person.age)
println(person.name)
person.setProperty("skill", "java")
println(person.getProperty("skill"))



class A {
    static class B {}
}
def ab = new A.B()
Runnable runnable = { println 'run'}


// Lambda 表达式
List<String> strList = ["a1", "a2", "a3"]
strList.each {
    println it
}



def a = 1
println a.getClass()
a = 2147483648
println a.getClass()
a = 1.23
println a.getClass()



// GString groovy字符串
def name = "zhangsan"
println "my name is $name"
def lines = '''\
line one
    line two
        line three\
'''
println lines



// def 定义变量
def static add(def a, def b) {
    a + b
}
println add(1, 2)
println add(1.2, 2.3)


// 闭包 一段可执行的代码 def closure = { [closureParameters -> ] statements }
def str = "hello"
def closure = {
    println "$str $it"
}
closure()
def closure2 = {
    param -> println param
}
closure2("hello c21")
closure2 "hello c22"
closure2.call("hello c23")
def closure3 = {
    arg1, int arg2 -> println "arg1:$arg1, arg2:$arg2"
}
closure3("a1", 2)
closure3 "a2", 3
def eachLine = {
    lineList, myClosure ->
        for (String line : lineList) {
            myClosure(line)
        }
}
eachLine('a'..'z', { println it })
eachLine('x'..'z') { println "other $it" }

Eval.me("println 'hello eval'")
println Eval.me("age", 22, "if(age<18){'未成年'}else{'成年'}")
println Eval.x(4, '2*x')



