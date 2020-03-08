package codes.crazy.study16;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

//使用Callable和Future创建线程
//Java提供了Callable接口，该接口提供一个call()方法可以作为线程执行体，但是call()比run()功能更强大：
//1. call()方法可以有返回值：
//2.call()方法可以声明抛出异常
//
public class ThirdThread {
    //创建并启动有返回值的线程步骤如下：
    //1.创建Callable接口的实现类，并实现call()方法，该call()方法将作为线程执行体，且该call()方法有返回值，再创建Callable实现类的实例。
    //2.使用FutureTask类来包装Callable对象，该FutureTask对象封装了该Callable对象的call()方法的返回值
    //3.使用FutureTask对象作为Thread对象的target创建并启动新线程
    //4.调用FutureTask对象的get()方法来获得子线程执行结束后的返回值
    public static void main(String[] args) {
        //创建Callable对象
        ThirdThread rt=new ThirdThread();
        //使用Lambda表达式创建Callable<Integer>对象
        //使用FutureTask来包装Callable对象
        FutureTask<Integer> task=new FutureTask<Integer>((Callable<Integer>)()->{
            int i=0;
            for(;i<100;i++){
                System.out.println(Thread.currentThread().getName()+"的循环变量i的值"+i);

            }
            //实质上还是以Callable对象来创建并启动线程
            return i;
        }) ;
        for(int i=0;i<100;i++){
            System.out.println(Thread.currentThread().getName()+" 的循环变量i的值" + i);
            if(i == 20){
                SecondThread st=new SecondThread();
                //获取线程返回值
                new Thread(task,"有返回值的线程").start();

            }
        }
        try {
            System.out.println("子线程的返回值："+task.get());
        }
        catch (Exception ex){
            ex.printStackTrace();
        }

    }
}


/**Future接口里定义了如下几个公共方法来控制它关联的Callable任务
 * 1.boolean cancel (boolean mayInterruptIfRunning) 取消任务的执行。参数指定是否立即中断任务执行，或者等等任务结束
 * 2.boolean isCancelled () 任务是否已经取消，任务正常完成前将其取消，则返回 true
 * 3.boolean isDone () 任务是否已经完成。需要注意的是如果任务正常终止、异常或取消，都将返回true
 * 4.V get (long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException
 * 同上面的get功能一样，多了设置超时时间。参数timeout指定超时时间，uint指定时间的单位，在枚举类TimeUnit中有相关的定义。
 * 如果计算超时，将抛出TimeoutException
 * 5.V get () throws InterruptedException, ExecutionException  等待任务执行结束，然后获得V类型的结果。调用该方法会导致程序阻塞，必须等到子线程结束后才能得到返回值
 * InterruptedException 线程被中断异常，
 * ExecutionException任务执行异常，
 * 如果任务被取消，还会抛出CancellationException
*/






























