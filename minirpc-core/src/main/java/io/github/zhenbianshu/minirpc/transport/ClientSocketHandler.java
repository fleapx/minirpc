package io.github.zhenbianshu.minirpc.transport;

import com.alibaba.fastjson.JSON;
import io.github.zhenbianshu.minirpc.core.Response;
import io.github.zhenbianshu.minirpc.core.ResponseFuture;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.CompletableFuture;

/**
 * @author zbs
 * @date 2019/9/5
 */
public class ClientSocketHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) {
        String body = (String) msg;
        System.out.println(body);

        Response response = JSON.parseObject(body, Response.class);

        CompletableFuture<Object> future = ResponseFuture.REQUEST_TO_FUTURE.remove(response.getRequestId());
        future.complete(response.getResponseVal());
    }
}