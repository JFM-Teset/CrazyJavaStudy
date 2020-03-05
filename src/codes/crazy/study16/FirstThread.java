package codes.crazy.study16;


/*通过继承Thread类来创建并启动多线程的步骤如下：
1.定义Thread类的子类，并重写该类的run()的方法，run()方法的方法体就代表了线程需要完成的任务。因此把run()方法称为线程执行体
2.创建Thread子类的示例，就是要创建线程对象
3.调用线程对象的start()方法来启动该线程




*/
public class FirstThread extends  Thread{
    private int i;
    //重写run()方法，它就是线程执行体
    public void run(){
        for(;i<100;i++){
            //当线程类继承Thread类时，直接使用this即可获取当前线程
            //Thread对象的getName()返回当前线程的名字
            //因此，可以直接调用getName()方法返回当前线程的名字
            System.out.println(getName()+" " + i);
        }
    }
    public static void main(String[] args){
        for(int i=0;i<100;i++){
            //调用Thread的currentThread()方法获取当前线程
            System.out.println(Thread.currentThread().getName()+" " + i);
            if(i == 20){
                //创建并启动第一个线程
                new FirstThread().start();
                //创建并启动第二个线程
                new FirstThread().start();
            }
        }
    }

}

//注意:进行多线程编程是不要忘了Java程序运行时默认的主线程，main()方法的方法体就是主线程的线程执行体
//使用继承Thread类的方法来创建线程类时，多个线程之间无法共享线程类的实例
//程序可以通过setName(String name)方法为线程设置名字，在默认情况下，主线程名字为main，其他线程名字依次为Thread-0 ......    Thread-n
