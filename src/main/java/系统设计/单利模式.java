package 系统设计;

import java.util.concurrent.Callable;

public class 单利模式 {

    static class Singleton {
        private static volatile Singleton instance;

        private Singleton() {
        }

        public static Singleton getInstance() {
            if (instance == null) {
                synchronized (Singleton.class) {
                    if (instance == null) {
                        instance = new Singleton();
                    }
                }
            }
            return instance;
        }
    }


    public static void main(String[] args) {
        Callable<Singleton> callable = new Callable<Singleton>() {
            @Override
            public Singleton call() throws Exception {
                return Singleton.getInstance();
            }
        };
    }

}
