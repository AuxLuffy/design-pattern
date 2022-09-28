package com.luffy.design_pattern.command;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 服务器收到客户端发过来的请求后，将命令封装为对象存储在内存队列中，再从队列中取出一定数量的命令来执行，执行完成后再开始新一轮的轮询
 *
 * @author sunzhangfei
 * @since 2022/8/31 2:26 下午
 */
public class GameApplication {
    private static final int MAX_HANDLED_REQ_COUNT_PER_LOOP = 100;
    private Queue<Command> mQueue = new LinkedList<>();

    public void mainLoop() {
        while (true) {
            List<Request> requests = new ArrayList<>();
            //省图从epoll或者select中获取数据并封装成Request的逻辑
            //注意设置超时时间，如果很长时间未收到请求，就继续下面的逻辑处理
            for (Request request : requests) {
                Event event = request.getEvent();
                Command command = null;
                if (event.equals(Event.GOT_DIAMOND)) {
                    command = new GotDiamondCommand(request.getData());
                } else if (event.equals(Event.GOT_STAR)) {
                    command = new GotStarCommand(request.getData());
                }
                //....其他命令的例化
                mQueue.add(command);
            }
            int handledCount = 0;
            while (handledCount < MAX_HANDLED_REQ_COUNT_PER_LOOP) {
                if (mQueue.isEmpty()) {
                    break;
                }
                Command command = mQueue.poll();
                command.excute();
                handledCount++;
            }
        }
    }
}
