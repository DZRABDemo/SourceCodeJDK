package com.xufeifan.langStudy.Root;

import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * Class Function Analysis:
 * System类包含几个有用的类字段和方法。它不能被实例化。
 * 1.输入流、输出流和错误流
 * 2.输出环境变量
 * 3.用于对数组进行复制
 * 4.加载文件和库
 */

@SuppressWarnings(value = "all")
public class Info_System {
    @Test
    public void testClassStructure(){
        //public final class System {}
    }

    @Test
    public void testBlock(){
        /*
        static {
            registerNatives();
        }
        这里对本地方法进行注册
        */
    }

    @Test
    public void testConstruction(){
        System.out.println("这个类只有私有的构造方法");
    }

    @Test
    public void testField(){
        //1.public final static InputStream in = null;
        //2.public final static PrintStream out = null;
        //3.public final static PrintStream err = null;
        testPrintStream();
        testInputStream();
    }

    @Test
    public void testMethod(){
        //1.输出环境变量
        //outputEnv();

        //2.加载库文件
        //testLibrary();

        //3.进行数组复制
        //testArraycopy();

        //4.进行其他方法的分析
        testOther();
    }

    /**
     * 这里对输出流和错误流进行分析
     */
    public static void testPrintStream(){
        File file =
                new File("test/com/xufeifan/langStudy/Root/print.txt");

        PrintStream ps = null;

        try {
            ps = new PrintStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        System.setOut(ps);

        System.out.println("测试输出流");
        //success

        System.setErr(ps);

        System.err.println("测试错误流");
        //success
    }

    public static void testInputStream(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("输出数字");
        int i = scanner.nextInt();
        System.out.println(i);
    }

    public static void outputEnv(){
        Map<String, String> getenv = System.getenv();

        Set<Map.Entry<String, String>> entries = getenv.entrySet();

        Iterator<Map.Entry<String, String>> iterator = entries.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    public static void testLibrary(){
        //这里暂时不做分析
    }

    public static void testArraycopy(){
        int num1[]={1,2,3,4};
        int num2[]={11,12,13,14};

        System.arraycopy(num1,0,num2,0,4);

        for (int i:
             num2) {
            System.out.println(i);
        }
    }

    public static void testOther(){
        //1.时间方法
        System.out.println(System.currentTimeMillis());

        System.out.println(System.nanoTime());

        System.out.println(System.identityHashCode(new Info_System()));
        //这里是获得原始哈希值
    }
}
