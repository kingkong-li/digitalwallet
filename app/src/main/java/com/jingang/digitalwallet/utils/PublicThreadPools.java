package com.jingang.digitalwallet.utils;

import android.os.Process;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @Description: 线程池
 * @Author: kingkong
 * @CreateTime: 2020/8/25-2:23 PM
 */
public class PublicThreadPools {

    public static ExecutorService getService(){
        return service;
    }
    private  static ExecutorService service= Executors.newFixedThreadPool(
            Runtime.getRuntime().availableProcessors(), new ThreadFactory() {
        @Override
        public Thread newThread(Runnable r) {
            Thread thread=new Thread(r);
            Process.setThreadPriority(Process.THREAD_PRIORITY_DEFAULT);
            thread.setName("PublicThreadPools");
            return thread;
        }
    });

}
