package netty.myserver;

import code.messagePack.MsgpackDecode;
import code.messagePack.MsgpackEncoder;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.string.StringDecoder;

/**
 * netty 服务器端
 * Created by liangyuyi on 2017/7/6.
 */
public class NettyServer {
    public void bind(int port) throws Exception{
        //配置服务端的NIO线程组,一个用于服务端接受客户端的连接，另一个用于进行网络读写
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        ServerBootstrap serverBootstrap = new ServerBootstrap();
        serverBootstrap.group(bossGroup, workerGroup);//将两个线程组加进ServerBootstrap
        serverBootstrap.channel(NioServerSocketChannel.class);
        serverBootstrap.option(ChannelOption.SO_BACKLOG, 1024);
        serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
            @Override
            protected void initChannel(SocketChannel socketChannel)throws Exception{
                ChannelPipeline channelPipeline = socketChannel.pipeline();
                //.....这里可以添加上自己的编码和解码规则
                //以下编码支持粘包
                //channelPipeline.addLast(new LineBasedFrameDecoder(1024));//LineBasedFrameDecoder遍历ByteBuf中的可读字节，遇见\n或\r\n就结束，是以换行符为结束标识

                //根据自定义分隔符来解码
//                ByteBuf delimiter = Unpooled.copiedBuffer("$_".getBytes());
//                channelPipeline.addLast(new DelimiterBasedFrameDecoder(1024,delimiter));
//                channelPipeline.addLast(new StringDecoder());

                channelPipeline.addLast("decode", new MsgpackDecode());
                channelPipeline.addLast("encode",new MsgpackEncoder());

                channelPipeline.addLast(new ServerHandler());
            }
        });

        //绑定端口，同步等待成功
        ChannelFuture future = serverBootstrap.bind(port).sync();
        //等待服务端监听端口关闭
        future.channel().closeFuture().sync();
    }
}
