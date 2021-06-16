线程中断的方式

1.自定义全局标识来实现中断，比较温柔的方式，不会立马终止，而是等待当前的一次任务执行完在终止。


// 全局变量
    private static boolean flag = false;

    public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (!flag) {
                System.out.println("我正在转账...");
//                try {
//                    // 休眠线程
//                    Thread.sleep(100);
//                    System.out.println("我正在转账...");
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                    break;
//                }
            }
            System.out.println("啊？差点误了大事。");
        }, "张三");
        // 开启任务
        t1.start();

        // 休眠主线程一段时间
        Thread.sleep(310);

        // 终止线程
        System.out.println("停止交易，有内鬼.");
        flag = true;
    }


2.使用Thread的intrrupted来中断。使用系统的 Intrruput()可以及时立马的终止线程，比较暴力。

 public static void main(String[] args) throws InterruptedException {

        Thread t1 = new Thread(() -> {
            while (!Thread.interrupted()) {
//另一种判断线程终止的方法
//while ( ! Thread.currentThread().isInterrupted()) {

                try {
                    // 休眠线程
                    Thread.sleep(100);
                    System.out.println("我正在转账...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    break;
                }
            }
            System.out.println("啊？差点误了大事。");
        }, "张三");
        // 开启任务
        t1.start();

        // 休眠主线程一段时间
        Thread.sleep(310);

        // 终止线程
        System.out.println("停止交易，有内鬼.");
        t1.interrupt();

    }