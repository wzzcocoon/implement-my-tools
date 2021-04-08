package cn.wzz.interview_second.lockdemo;

import java.util.concurrent.atomic.AtomicReference;

class User{
    String userName;
    int age;
    public User(String userName, int age) {
        this.userName = userName;
        this.age = age;
    }
    @Override
    public String toString() {
        return String.format("User [userName=%s, age=%s]", userName, age);
    }
}

public class AtomicReferenceDemo {
    public static void main(String[] args){
        User z3 = new User( "z3",22);
        User li4 = new User("li4" ,25);
        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(z3);
        //AtomicReference原子引用类，将普通对象包装成原子类。
        System.out.println(atomicReference.compareAndSet(z3, li4)+"\t"+atomicReference.get().toString());
        System.out.println(atomicReference.compareAndSet(z3, li4)+"\t"+atomicReference.get().toString());

    }
}


