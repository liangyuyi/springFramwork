package netty.myClient;

/**
 * Created by liangyuyi on 2017/7/8.
 */
public class ClientMain {
    public static void main(String[] args)throws Exception{
        String serverIp = "127.0.0.1";
        int port = 6777;
        NettyClient client = new NettyClient();
        client.connect(serverIp, port);
    }
}
