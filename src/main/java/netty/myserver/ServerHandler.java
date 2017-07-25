package netty.myserver;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * netty 服务器的handler
 * Created by liangyuyi on 2017/7/6.
 */
public class ServerHandler extends ChannelInboundHandlerAdapter{
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg)throws Exception{
        ByteBuf buf = (ByteBuf) msg;
        byte [] req = new byte[buf.readableBytes()];
        buf.readBytes(req);
        String body = new String(req, "UTF-8");//将byte转成String
        System.out.println("the date from client is:" + body);

        String serverStr = "hello, I am server";
        ByteBuf resp = Unpooled.copiedBuffer(serverStr.getBytes());
        ctx.write(resp);
    }

//    int counter = 0;
//    //自定义分隔符
//    @Override
//    public void channelRead(ChannelHandlerContext ctx, Object msg)throws Exception{
//        ByteBuf buf = (ByteBuf) msg;
//        byte [] req = new byte[buf.readableBytes()];
//        buf.readBytes(req);
//        String body = new String(req, "UTF-8");//将byte转成String
//        System.out.println(++counter + " the date from client is:" + body);
//
//        String serverStr = "hello, I am server";
//        serverStr += "$_";
//        ByteBuf resp = Unpooled.copiedBuffer(serverStr.getBytes());
//        ctx.write(resp);
//    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx)throws  Exception{
        ctx.flush();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause){
        ctx.close();
    }
}
