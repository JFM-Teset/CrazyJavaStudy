package codes.crazy.study16;
//实现Runnable接口创建线程类
public class SecondThread implements Runnable{
    //实现Runnable接口创建并启动多线程的步骤如下：
    //1.定义Runnable接口的实现类，并重写改接口的run()方法，该run()方法同样是该线程的线程执行体
    //2.创建Runnable实现类的实例，并以此实例作为Thread的target来创建Thread对象，该Thread对象才是真正的线程对象
    //3.调用线程对象的start()方法来启动该线程
    private int i;
    public void run(){
        for(;i<100;i++){
            //当线程类实现Runnable接口时
            //如果想获取当前线程，只能用Thread.currentThread()方法
            System.out.println(Thread.currentThread().getName() +" "+i);
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        for(int i=0;i<100;i++){
            //调用Thread的currentThread()方法获取当前线程
            System.out.println(Thread.currentThread().getName()+" " + i);
            if(i == 20){
                SecondThread st=new SecondThread();

                //通过new Thread(target,name)方法创建新线程
                new Thread(st,"新线程1").start();
                new Thread(st,"新线程2").start();
            }
        }
    }
}
//此方法多个线程共享一个target，所以多个线程可以共享同一个线程类（实际上应该是线程的target类）的实例变量。