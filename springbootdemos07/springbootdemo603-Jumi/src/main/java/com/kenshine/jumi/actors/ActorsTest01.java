package com.kenshine.jumi.actors;

import fi.jumi.actors.ActorRef;
import fi.jumi.actors.ActorThread;
import fi.jumi.actors.Actors;
import fi.jumi.actors.MultiThreadedActors;
import fi.jumi.actors.eventizers.dynamic.DynamicEventizerProvider;
import fi.jumi.actors.listeners.CrashEarlyFailureHandler;
import fi.jumi.actors.listeners.NullMessageListener;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ：kenshine
 * @date ：Created in 2023/12/19 23:33
 * @description：jumi-actors使用测试
 * @modified By：
 * @version: $
 */
public class ActorsTest01 {
    public static void main(String[] args) {
        // configuration
        ExecutorService actorsThreadPool = Executors.newCachedThreadPool();
        Actors actors = new MultiThreadedActors(
                actorsThreadPool,
                new DynamicEventizerProvider(),
                new CrashEarlyFailureHandler(),
                new NullMessageListener()
        );
        ActorThread actorThread = actors.startActorThread();

            // usage
        ActorRef<Greeter> helloGreeter = actorThread.bindActor(Greeter.class, new Greeter() {
            @Override
            public void sayGreeting(String name) {
                System.out.println("Hello " + name + " from " + Thread.currentThread().getName());
            }
        });
        helloGreeter.tell().sayGreeting("World");
        System.out.println("Wazzup from " + Thread.currentThread().getName());

        // cleanup
        actorThread.stop();
        actorsThreadPool.shutdown();
    }
}
