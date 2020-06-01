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
        while (!Thread.currentThread().isInterrupted()) {
            try {
                Thread currentThread = Thread.currentThread();
                Thread.State state = currentThread.getState();
                System.out.println(state.name());
                System.out.println(currentThread.getName());
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                Thread.currentThread().interrupt();
            }
        }
//        while (true) {
//            try {
//                Thread currentThread = Thread.currentThread();
//                Thread.State state = currentThread.getState();
//                System.out.println(state.name());
//                System.out.println(currentThread.getName());
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//                Thread.currentThread().interrupt();
//                return;
//            } finally {
//                System.out.println("finally");
//            }
//        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadSleep threadSleep = new ThreadSleep();
        Thread t1 = new Thread(threadSleep);
        t1.start();
        Thread.sleep(3000);
        t1.interrupt();
    }

}