package com.janliao.compare;

public class PersonImpl extends AbstractPerson implements IPerson {
//    @Override
//    public void test() {
//        System.out.println("impl test--------");
//    }

    public static void main(String[] args) {
        IPerson p = new PersonImpl();
        p.test();
    }
}
