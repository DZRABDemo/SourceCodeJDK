package com.xufeifan.langStudy.Root;

import org.junit.Test;

import java.io.IOException;

/**
 * Class Function Analysis:
 * 每个Java应用程序都有一个Runtime类的Runtime ，
 * 允许应用程序与运行应用程序的环境进行接口。
 * 当前运行时可以从getRuntime方法获得。
 * 应用程序无法创建自己的此类的实例。
 */
public class Info_Runtime {
    @Test
    public void testClassStructure(){
        /*
        * public class Runtime{}
        */
    }

    @Test
    public void testBlock(){
        System.out.println("this is no block");
    }

    @Test
    public void testConstruction(){
        //private Runtime() {}
    }

    @Test
    public void testField(){
        //1.private static Runtime currentRuntime = new Runtime();
        //很显然 这是饿汉式单例设计模式
    }

    @Test
    public void testMethod(){
        //part1 内存方法
        //1.public native long maxMemory();
        //2.public native long totalMemory();
        //3.public native long freeMemory();
        //testMemoryMethod();

        /*part2用于对系统退出 参数是状态值
        4.public void exit(int status) {
            SecurityManager security = System.getSecurityManager();
            if (security != null) {
                security.checkExit(status);
            }
            Shutdown.exit(status);
        }
        */
        //testExit();

        //5.public native void gc();
        //这里进行垃圾回收

        //6.public native int availableProcessors();
        //testProcessNum();

        //7.exec() 这是一系列的方法
        // testExec();

        /* 这里是增加一个新的虚拟机挂钩
        * 8.public void addShutdownHook(Thread hook) {
                SecurityManager sm = System.getSecurityManager();
                if (sm != null) {
                    sm.checkPermission(new RuntimePermission("shutdownHooks"));
                }
                ApplicationShutdownHooks.add(hook);
            }
        */
        testShutdownHook();
    }

    /**
     * 返回Java虚拟机将尝试使用的内存量
     * 这里分别是最大内存量
     * 当前内存量和空闲内存量
     */
    public static void testMemoryMethod(){
        //获得运行时的实例对象
        Runtime runtime = Runtime.getRuntime();

        long maxMemory = runtime.maxMemory();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();

        long size = (1024*1024);

        System.out.println(maxMemory/size);
        System.out.println(totalMemory/size);
        System.out.println(freeMemory/size);
    }

    /**
     * 通过启动其关闭序列来终止当前正在运行的Java虚拟机。
     * 此方法从不正常返回。该参数作为状态代码;
     * 按照惯例，非零状态码表示异常终止。
     */
    public static void testExit(){
        /*
        * 虚拟机的关机顺序由两个阶段组成。
        * 在第一阶段，所有注册的shutdown hooks
        * （如果有的话）以某种未指定的顺序启动，并允许同时运行直到完成。
        * 在第二阶段，如果所有未调用的终结器运行finalization-on-exit已启用。
        * 一旦完成了虚拟机halts 。
        * 如果在虚拟机已经开始关闭序列之后调用此方法，
        * 那么如果关闭挂钩正在运行，则此方法将无限期地阻止。
        * 如果关闭挂钩已经运行，并且已启用了退出完成，
        * 那么如果状态为非零，则此方法将使用给定状态代码暂停虚拟机;
        * 否则，它将无限期地阻止。
        * System.exit方法是调用此方法的常规和方便的方法
        */
        Runtime runtime = Runtime.getRuntime();
        System.out.println("start testExit method");

        runtime.exit(0);
        //Process finished with exit code 0

        System.out.println("end testExit method");
    }

    /**
     * 运行垃圾回收器。
     * 调用此方法表明，Java虚拟机花费了回收未使用对象的努力，
     * 以使其当前占用的内存可用于快速重用。 当控制从方法调用返回时，
     * 虚拟机已尽全力回收所有丢弃的对象。
     * 名称gc代表“垃圾收集器”。
     * 根据需要在虚拟机自动执行此再循环过程，
     * 在单独的线程中，即使gc方法没有显式调用
     */
    public static void testGC(){
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
    }

    public void testProcessNum(){
        Runtime runtime = Runtime.getRuntime();
        System.out.println
                ("处理器的数量是:"+runtime.availableProcessors());
    }

    /**
     * 在单独的进程中执行指定的字符串命令。
     */
    public void testExec(){
        Runtime runtime = Runtime.getRuntime();

        try {
            runtime.exec("calc");
            //这里可以启动计算器
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册一个新的虚拟机关机挂钩。
     * Java虚拟机关闭两种事件:
     * 1.在程序正常退出 ，当最后一个非守护线程退出时或者
     * 当（等价地，exit System.exit ）方法被调用，或
     * 2.虚拟机被终止在响应于用户中断，如键入^C，
     * 或一个全系统的事件，如用户注销或系统关闭。
     *
     * 一个关机钩子只是一个初始化但未启动的线程。
     * 当虚拟机开始关闭序列时，
     * 它将以一些未指定的顺序启动所有注册的关闭挂钩，
     * 并让它们同时运行。
     * 当所有的钩子都完成后，如果已经启用了最终确定的退出，
     * 它将运行所有未被终止的终结器。
     * 最后，虚拟机将停止。
     * 请注意，守护程序线程将在关闭序列期间继续运行，
     * 非守护线程如果通过调用exit方法启动关闭，
     * 则该守护程序线程也将继续
     */
    public static void testShutdownHook(){
        Runtime runtime = Runtime.getRuntime();

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    System.out.println(i);
                }
            }
        });

        runtime.addShutdownHook(thread);
    }

}
