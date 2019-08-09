package com.supconit.service.impl;

import com.supconit.dao.domain.TicketDo;
import com.supconit.dao.mapper.TicketMapper;
import com.supconit.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;
    @Override
    public int getTicket1() {
        TicketDo ticketDo = ticketMapper.getTicketById(1l);
        int stock = ticketDo.getStock();
        if(stock > 0){
            stock = stock -1;
            ticketDo.setStock(stock);
            return ticketMapper.updateById(ticketDo);
        }
        return 0;
    }


    public int test1() throws InterruptedException {
        CountDownLatch countDown = new CountDownLatch(1);
        CountDownLatch await = new CountDownLatch(100);

        // 依次创建并启动处于等待状态的5个MyRunnable线程
        for (int i = 0; i < 100; ++i) {
            new Thread(new MyRunnable(countDown, await)).start();
        }

        System.out.println("用于触发处于等待状态的线程开始工作......");
        System.out.println("用于触发处于等待状态的线程工作完成，等待状态线程开始工作......");
        countDown.countDown();
        await.await();
        return 1;
    }

    public class MyRunnable implements Runnable {

        private final CountDownLatch countDown;
        private final CountDownLatch await;

        public MyRunnable(CountDownLatch countDown, CountDownLatch await) {
            this.countDown = countDown;
            this.await = await;
        }

        public void run() {
            try {
                countDown.await();//等待主线程执行完毕，获得开始执行信号...
                int result = getTicket1();
                System.out.println("当前线程："+Thread.currentThread().getName()+",result:" + result);
                await.countDown();//完成预期工作，发出完成信号...
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
