public class ThreadPoolDemo {
    public static void main(String[] args) {

        // 创建一个固定个数的线程池
        ExecutorService executorService =
                Executors.newFixedThreadPool(10);
        for (int i = 0; i < 2; i++) {
            // 执行任务
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" +
                            Thread.currentThread().getName());
                }
            });
        }


    }
}


----------------------------------------------------------------------------------------------
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建带缓存的线程池
        ExecutorService executorService =
                Executors.newCachedThreadPool();
        for (int i = 0; i < 100; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" +
                            Thread.currentThread().getName());
                }
            });
        }
    }
}
----------------------------------------------------------------------------------------------
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 自定义线程工厂
        MyThreadFactory threadFactory = new MyThreadFactory();
        ExecutorService executorService =
                Executors.newFixedThreadPool(10, threadFactory);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    Thread thread = Thread.currentThread();
                    System.out.println("线程名：" +
                            thread.getName() +
                            ",优先级：" + thread.getPriority());
                }
            });
        }
    }

    private static int count = 1;

    static class MyThreadFactory implements ThreadFactory {

        @Override
        public Thread newThread(Runnable r) {
            Thread thread = new Thread(r);
            // 自定义线程池的名称规则
            thread.setName("mythreadpool-" + count++);
            // 设置优先级
            thread.setPriority(10);
            return thread;
        }
    }

}
---------------------------------------------------------------------------------------------
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建执行定时任务的线程池
        ScheduledExecutorService scheduledExecutorService =
                Executors.newScheduledThreadPool(1);
        System.out.println("设置定时任务：" + new Date());
//        // 执行定时任务
//        scheduledExecutorService.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                System.out.println("执行任务：" + new Date());
//            }
//        }, 1, 3, TimeUnit.SECONDS);

//        scheduledExecutorService.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("执行任务：" + new Date());
//            }
//        }, 1, TimeUnit.SECONDS);

        scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务：" + new Date());
            }
        }, 1, 3, TimeUnit.SECONDS);

    }
}
-----------------------------------------------------------------------------------------------
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建单个执行定时任务的线程池
        ScheduledExecutorService service =
                Executors.newSingleThreadScheduledExecutor();
        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("执行任务：" + new Date());
            }
        }, 1, 3, TimeUnit.SECONDS);

    }
}
----------------------------------------------------------------------------------------------------
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建单个线程的线程池
        ExecutorService service = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" +
                            Thread.currentThread().getName() +
                            ",I=" + finalI);
                }
            });
        }

    }
}
-----------------------------------------------------------------------------------------------
public class ThreadPoolDemo {
    public static void main(String[] args) {
        // 创建一个异步根据当前CPU生产的线程池
        ExecutorService service = Executors.newWorkStealingPool();
        for (int i = 0; i < 10; i++) {
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名：" +
                            Thread.currentThread().getName());
                }
            });
        }

        // 等待线程池执行完成
        while (!service.isTerminated()) {
        }

    }
}