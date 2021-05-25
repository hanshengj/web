public class Singledemo {
//    //恶汉模式
//    //第一步，先将构造方法私有化
//    private Singledemo(){}
//    //第二步，创建一个私有的静态变量
//    private static Singledemo singledemo = new Singledemo();
//    //第三步，对外提供获取单例的方法
//    public static Singledemo getSingledemo(){
//        return singledemo;
//    }




    //懒汉模式
    //1、先将构造方法私有化
    private Singledemo(){}
    //2、创建一个私有的静态变量，用来返回
    private static volatile  Singledemo singledemo = null;//先不用实例化，需要的时候在实例化
    //对外提供获取单例的方法

    //public static Singledemo synchronized getSingledemo();犁度太大，效率低
    public static Singledemo getSingledemo(){
        if(singledemo == null){
            synchronized (Singledemo.class){
                if(singledemo == null){
                    singledemo = new Singledemo();//两个if进行双重校验，
                    // singledemo = new Singledemo();是非原子的操作，还有可能进行指令重排，需要volatile修饰变量
                }
            }

        }
        return singledemo;
    }
}