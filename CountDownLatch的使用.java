public class ThreadDemo98 {
    public static void main(String[] args) throws InterruptedException {
        // 创建 CountDownLatch
        CountDownLatch countDownLatch =
                new CountDownLatch(3);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10,
                0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(100));

        for (int i = 0; i < 6; i++) {
            // 执行任务
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName() +
                            " 开跑");
                    int num = new Random().nextInt(5);
                    num += 1;
                    try {
                        Thread.sleep(num * 1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() +
                            " 到达了终点");
                    // 计数器 -1
                    countDownLatch.countDown();
                }
            });
        }
       

        // 等待所有的选手都到达终点，等待计时器为 0
        countDownLatch.await();

        System.out.println("比赛结束，宣布成绩");

    }
}