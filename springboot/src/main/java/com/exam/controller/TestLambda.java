package com.exam.controller;

/**
 * @Auther gty
 * @Date 2022/1/11
 */
public class TestLambda {
    public static void main(String[] args) {
        Ilike ilike = new Like();
            ilike.lambda();
    }
}


interface  Ilike{
    void lambda();
}

class Like implements Ilike{

    @Override
    public void lambda() {
        System.out.println("i like lambda");
    }
}
