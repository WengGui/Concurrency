package com.weng.concurrency.singleton;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LazyModel2 {
    private static LazyModel2 instant = null;

    private LazyModel2(){
    }

    public static LazyModel2 getInstant(){
        if(instant == null){
            synchronized (LazyModel2.class){
                if(instant == null){
                    instant = new LazyModel2();
                }
            }
        }
        return instant;
    }

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(() -> {
            LazyModel2 instant = LazyModel2.getInstant();
            System.out.println(instant.hashCode());
        });
        service.execute(() -> {
            LazyModel2 instant = LazyModel2.getInstant();
            System.out.println(instant.hashCode());
        });
        service.execute(() -> {
            LazyModel2 instant = LazyModel2.getInstant();
            System.out.println(instant.hashCode());
        });
        service.execute(() -> {
            LazyModel2 instant = LazyModel2.getInstant();
            System.out.println(instant.hashCode());
        });

    }
}
