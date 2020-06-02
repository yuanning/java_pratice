/**
 * @Title:
 * @Package thread
 * @Description: // TODO
 * @author: Administrator
 * @date: 2020-06-01 16:05
 * @version V1.0
 * @Copyright: Copyright (C) 2020 Sailing, Inc. All rights reserved.
 */
package thread;

/**
 * @ClassName: ThreadSleep
 * @Description: // TODO 
 * @author: Administrator
 * @date: 2020-06-01 16:05 
 * @Copyright: Copyright (C) 2020 Sailing, Inc. All rights reserved.
 */
public class ThreadSleep implements Runnable {

    @Override
    public void run()  {
//        while (true) {
//            try {
//                Thread currentThread = Thread.currentThread();
//                Thread.State state = currentThread.getState();
//                System.out.println(state.name());
//                System.out.println(currentThread.getName());
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                System.out.println("before="+Thread.currentThread().isInterrupted());
//                Thread.currentThread().interrupt();
//                System.out.println("after="+Thread.currentThread().isInterrupted());
//                return;
//            }
//        }
//        while (!Thread.currentThread().isInterrupted()) {
//            try {
//                Thread currentThread = Thread.currentThread();
//                Thread.State state = currentThread.getState();
//                System.out.println(state.name());
//                System.out.println(currentThread.getName());
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                System.out.println("before="+Thread.currentThread().isInterrupted());
//                Thread.currentThread().interrupt();
//                System.out.println("after="+Thread.currentThread().isInterrupted());
//            }
//        }
        try {
            while (true) {
                Thread currentThread = Thread.currentThread();
                Thread.State state = currentThread.getState();
                System.out.println(state.name());
                System.out.println(currentThread.getName());
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSleep threadSleep = new ThreadSleep();
        Thread t1 = new Thread(threadSleep);
        t1.start();
        Thread.sleep(3000);
        t1.interrupt();
    }

}