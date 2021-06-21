public class ThreadDemo97 {
    public static void main(String[] args) {
        // 创建信号量，
        Semaphore semaphore = new Semaphore(2);

        // 创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10,
                0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(1000));

        // 执行任务 1
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        " 到达停车场门口");
                try {
                    Thread.sleep(1000);
                    // 尝试获取锁
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 执行到此行代码表示已经获取到了停车位
                System.out.println(Thread.currentThread().getName() +
                        " 进入了停车场");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +
                        " 离开了停车场");
                // 释放锁
                semaphore.release();
            }
        });

        // 执行任务 2，新创建一个线程来执行的
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        " 到达停车场门口");
                try {
                    Thread.sleep(1000);
                    // 尝试获取锁
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 执行到此行代码表示已经获取到了停车位
                System.out.println(Thread.currentThread().getName() +
                        " 进入了停车场");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +
                        " 离开了停车场");
                // 释放锁
                semaphore.release();
            }
        });

        // 执行任务 3
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        " 到达停车场门口");
                try {
                    Thread.sleep(1000);
                    // 尝试获取锁
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 执行到此行代码表示已经获取到了停车位
                System.out.println(Thread.currentThread().getName() +
                        " 进入了停车场");
                try {
                    Thread.sleep(1500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +
                        " 离开了停车场");
                // 释放锁
                semaphore.release();
            }
        });

        // 执行任务 4
        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() +
                        " 到达停车场门口");
                try {
                    Thread.sleep(1000);
                    // 尝试获取锁
                    semaphore.acquire();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                // 执行到此行代码表示已经获取到了停车位
                System.out.println(Thread.currentThread().getName() +
                        " 进入了停车场");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() +
                        " 离开了停车场");
                // 释放锁
                semaphore.release();
            }
        });

    }
}