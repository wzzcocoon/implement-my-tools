package cn.wzz.interview2021;

public class StringPool58Demo {

    public static void main(String[] args) {

        /**
         *  String:intern()是一个本地方法，它的作用是如果字符串常量池中已经包含一个等于此String对象的
         *  字符串，则返回代表池中这个字符串的String对象的引用；否则，会将此String对象包含的字符串添加
         *  到常量池中，并且返回此String对象的引用。
         */
        String str1 = new StringBuilder("58").append("tongcheng").toString();
        System.out.println(str1);
        System.out.println(str1.intern());
        System.out.println(str1 == str1.intern());

        /**
         * sum.misc.Version类会在JDK类库的初始化中被加载并初始化,而在初始化时它需要对静态常量字段根据指定的
         * 常量值(ConstantValue)做默认初始化,此时sum.misc.Version.launcher静态常量字段所引用的"java"字符串字面
         * 量就被intern到HotSpot VM的字符串常量池 - StringTable
        里了
        str2对象是堆中的
        str.intern()是返回的是JDK出娘胎自带的,在加载sum.misc.version这个类的时候进入常量池
        */
        String str2 = new StringBuilder("ja").append("va").toString();
        System.out.println(str2);
        System.out.println(str2.intern());
        System.out.println(str2 == str2.intern());
    }

}
