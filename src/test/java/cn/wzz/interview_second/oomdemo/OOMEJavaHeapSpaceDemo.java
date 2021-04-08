package cn.wzz.interview_second.oomdemo;

public class OOMEJavaHeapSpaceDemo {

    /**
     *
     * 设置JVM启动参数： -Xms10m -Xmx10m
     *
     * @param args
     */
    public static void main(String[] args) {
        byte[] array = new byte[80 * 1024 * 1024];
    }

}

