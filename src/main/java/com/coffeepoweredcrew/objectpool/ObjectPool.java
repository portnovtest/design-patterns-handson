package com.coffeepoweredcrew.objectpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.function.Supplier;
import java.util.stream.IntStream;

//The object pool, here we are pre-creating all objects
public class ObjectPool<T extends Poolable> {

    private final BlockingQueue<T> availablePool;

    public ObjectPool(Supplier<T> creator, int preCache) {
        availablePool = new LinkedBlockingQueue<>();
        IntStream.range(0, preCache).forEach(i -> availablePool.offer(creator.get()));
    }

    //get method must decide what to do if pool is empty. It can create new object and return that or wait until
    //one becomes available
    public T get() {
        try {
            //We are going to wait if none free. NOTE this has severe -ve impact!
            return availablePool.take();
        } catch (InterruptedException e) {
            System.err.println("take() interrupted waiting on pooled queue");
        }
        return null;
    }

    public void release(T obj) {
        obj.reset();
        try {
            availablePool.put(obj);
        } catch (InterruptedException e) {
            System.err.println("put() interrupted waiting on pooled queue");
        }
    }
}
