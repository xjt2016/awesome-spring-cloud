package io.gitee.xjt2016.modules;

import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang.math.RandomUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Log4j2
public class Stress {
//    ConcurrentLinkedQueue<StressInfo> queue = new ConcurrentLinkedQueue<>();

    //单用户
    private static StressInfo postSync() {
        int loop = 0;
        long start = System.currentTimeMillis();
        List<SubStressInfo> subStressInfoList = new ArrayList<>();
        while (!Thread.currentThread().isInterrupted()) {
            loop++;
            SubStressInfo stressInfo = new SubStressInfo();
            stressInfo.setStart(System.currentTimeMillis());
            try {
                TimeUnit.MILLISECONDS.sleep(RandomUtils.nextInt(100));
                stressInfo.setSuccess(1);
            } catch (InterruptedException e) {
                break;
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            } finally {
                stressInfo.setEnd(System.currentTimeMillis());
                subStressInfoList.add(stressInfo);
            }
        }
        long end = System.currentTimeMillis();
        log.debug("thread:{},loop:{},time cast:{}ms:", Thread.currentThread().getName(), loop, (end - start));
        return new StressInfo(start, end, loop, subStressInfoList);
    }

    private static class Task implements Callable<StressInfo> {
        private final CyclicBarrier cyclicBarrier;

        public Task(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public StressInfo call() throws Exception {
            // 等待所有任务准备就绪
            cyclicBarrier.await();
            //测试路径
            return postSync();
        }
    }

    public static void doStress(int num, int timeout) throws ExecutionException, InterruptedException {
        //线程池准备
        CyclicBarrier cyclicBarrier = new CyclicBarrier(num);
        ExecutorService executorService = Executors.newFixedThreadPool(num);
        long now = System.currentTimeMillis();//开始时间

        //提交多线程任务
        List<Future<StressInfo>> futures = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            Future<StressInfo> future = executorService.submit((new Task(cyclicBarrier)));
            futures.add(future);
        }

        //多线程任务执行多长时间（timeout），后中断
        try {
            TimeUnit.SECONDS.sleep(timeout);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            executorService.shutdownNow();
        }

        //等待线程池销毁
        while (!executorService.isShutdown()) {
            try {
                TimeUnit.MILLISECONDS.sleep(100);
            } catch (Exception e) {
                log.error(e.getMessage(), e);
            }
        }

        //获取多线程执行结果，汇总
        for (Future<StressInfo> future : futures) {
            StressInfo stressInfo = future.get();
            log.info("stressInfo info: total:{}ms,loop:{}", stressInfo.getTotal(), stressInfo.loop);
        }

        long end = System.currentTimeMillis();//结束时间
        log.debug("总共耗时!---------{}ms", (end - now));//总共耗时
    }

    public static void main(String[] args) throws Exception {
        //压力测试，JVM设置；发压机器状态
        //普通发压，梯度发压，动态调压
        //用户数量：10个，总执行时长：3s
        //用户数量：10个，总执行次数：1000
        doStress(10, 3);
    }

    @Data
    private static class StressInfo {
        private long start;
        private long end;
        private long loop;
        private List<SubStressInfo> subStressInfoList;

        public StressInfo(long start, long end, long loop, List<SubStressInfo> subStressInfoList) {
            this.start = start;
            this.end = end;
            this.loop = loop;
            this.subStressInfoList = subStressInfoList;
        }

        public long getTotal() {
            return end - start;
        }
    }

    @Data
    private static class SubStressInfo {
        private long start;
        private long end;
        private int success = 0;
    }

}
