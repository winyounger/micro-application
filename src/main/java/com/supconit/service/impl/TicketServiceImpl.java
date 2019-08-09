package com.supconit.service.impl;

import com.supconit.dao.domain.TicketDo;
import com.supconit.dao.mapper.TicketMapper;
import com.supconit.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.CountDownLatch;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private TicketMapper ticketMapper;
    @Override
    public int getTicket1() {
        System.out.println("方法内部，当前线程："+Thread.currentThread().getName());
        TicketDo ticketDo = ticketMapper.getTicketById(1l);
        int stock = ticketDo.getStock();
        if(stock > 0){
            stock = stock -1;
            ticketDo.setStock(stock);
            return ticketMapper.updateById(ticketDo);
        }
        return -1;
    }


    public int test1() throws InterruptedException {
        CountDownLatch await = new CountDownLatch(100);

        // 依次创建并启动处于等待状态的5个MyRunnable线程
        for (int i = 0; i < 100; ++i) {
            new Thread(new MyRunnable(await)).start();
            await.countDown();
            System.out.println("当前线程111："+Thread.currentThread().getName() + ",count:" + await.getCount());
        }
        System.out.println("用于触发处于等待状态的线程开始工作......");
        System.out.println("用于触发处于等待状态的线程工作完成，等待状态线程开始工作......");

        return 1;
    }

    public class MyRunnable implements Runnable {
        private final CountDownLatch await;

        public MyRunnable( CountDownLatch await) {
            this.await = await;
        }

        public void run() {
            try {
                await.await();
                //countDown.await();//等待主线程执行完毕，获得开始执行信号...
                int result = getTicket1();
                //完成预期工作，发出完成信号...
                System.out.println("当前线程："+Thread.currentThread().getName()+",result:" + result + ",count:" + await.getCount());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
