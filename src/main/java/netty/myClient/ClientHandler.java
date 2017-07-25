package netty.myClient;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import netty.POJO.UserInfo;

/**
 * Created by liangyuyi on 2017/7/6.
 */
public class ClientHandler extends ChannelInboundHandlerAdapter {

    private ByteBuf clientMessage;
    private int counter;
    private int sendNum = 10;

    public ClientHandler(){
        String string = "this is client $_";
        byte [] req = string.getBytes();
        clientMessage = Unpooled.buffer(req.length);
        clientMessage.writeBytes(req);
    }
    //读取服务端的信息
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        ByteBuf buf = (ByteBuf)msg;
        byte [] result = new byte[buf.readableBytes()];
        buf.readBytes(result);
        String body = new String(result,"UTF-8");
        System.out.println("the message of client is " + body);
    }

        //当连接建立的时候向服务器发送信息
    @Override
    public void channelActive(ChannelHandlerContext ctx){
        //ctx.writeAndFlush(clientMessage);

//        for(int i = 0; i < 10; i++){
//            ctx.writeAndFlush(Unpooled.copiedBuffer(clientMessage));
//        }

        UserInfo [] infos = setUserInfos();
        for(UserInfo info:infos){
            ctx.write(info);
        }
        ctx.flush();
    }

    private UserInfo [] setUserInfos(){
        UserInfo [] userInfos = new UserInfo[sendNum];
        UserInfo userInfo = null;
        for(int i = 0; i < sendNum; i++){
            userInfo = new UserInfo();
            userInfo.setAge(i);
            userInfo.setName("hello"+i);
            userInfos[i] = userInfo;
        }
        return userInfos;
    }
}
