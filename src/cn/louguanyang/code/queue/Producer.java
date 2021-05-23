package cn.louguanyang.code.queue;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 生产者
 *
 * @author louguanyang
 * @createAt 2021/5/13 10:00 下午
 */
public class Producer implements Runnable{

    private BlockingQueue<Integer> queue;
    private final int poisonPill;
    private final int poisonPillPerProducer;

    public Producer(BlockingQueue<Integer> queue, int poisonPill, int poisonPillPerProducer) {
        this.queue = queue;
        this.poisonPill = poisonPill;
        this.poisonPillPerProducer = poisonPillPerProducer;
    }

    @Override
    public void run() {
        try {

            generateNumbers();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void generateNumbers() throws InterruptedException {
        for (int i = 0; i < 100; i++) {
            queue.put(ThreadLocalRandom.current().nextInt(100));
        }
        for (int i = 0; i < poisonPillPerProducer; i++) {
            queue.put(poisonPill);
        }
    }
}
