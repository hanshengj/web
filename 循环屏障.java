/**
 * 循环屏障
 */
public class ThreadDemo99 {
    public static void main(String[] args) {

      

        CyclicBarrier cyclicBarrier =
                new CyclicBarrier(2, new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("-----------到达了屏障-----------");
                    }
               });

       ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10,
               0, TimeUnit.SECONDS,
               new LinkedBlockingQueue<>(1000));

        for (int i = 1; i < 5; i++) {
            final int finalI = i;
           executor.execute(new Runnable() {
               @Override
                public void run() {
                    try {
                        Thread.sleep(finalI * 1000);
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
                    System.out.println(Thread.currentThread().getName() +
                            " 进入了任务");
                    try {
                        // 等待其他线程执行
                       cyclicBarrier.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (BrokenBarrierException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +
                            " 执行结束");
                }
            });
        }


    }
}
