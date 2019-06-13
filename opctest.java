import org.jinterop.dcom.common.JIException;
import org.openscada.opc.dcom.list.ClassDetails;
import org.openscada.opc.lib.common.AlreadyConnectedException;
import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.common.NotConnectedException;
import org.openscada.opc.lib.da.*;
import org.openscada.opc.lib.list.Categories;
import org.openscada.opc.lib.list.Category;
import org.openscada.opc.lib.list.ServerList;


import java.net.UnknownHostException;
import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class opctest {
    /*IP地址和主机名称密码*/
    private static String host ="127.0.0.1";//172.16.4.11//IP
    private static String domain="127.0.0.1";//127.0.0.1
    private static String user="expadmin";//computername
    private static String password="admin";//password
    public static void main(String[] args) throws JIException, UnknownHostException, AlreadyConnectedException, NotConnectedException, DuplicateGroupException, AddFailedException, InterruptedException, DuplicateGroupException {
        ServerList serverList = new ServerList(host,user,password,domain);//获取服务器列表
        System.out.println("Hello World!");//检测点
        Collection<ClassDetails> classDetails = serverList.listServersWithDetails(new Category[] {
                Categories.OPCDAServer10, Categories.OPCDAServer20,
                Categories.OPCDAServer30 }, new Category[] {});
        //打印IP地址中的server列表
        for (ClassDetails cds : classDetails) {
            System.out.println(cds.getProgId() + "=" + cds.getDescription());
        }
        //创建server对象属性
        final ConnectionInformation ci = new ConnectionInformation();
        ci.setHost(host);
        /*server端名称，需要更改*/
        ci.setClsid(serverList.getClsIdFromProgId ("Knight.OPC.Server.Demo"));  //ICONICS.SimulatorOPCDA.2   Knight.OPC.Server.Demo
        ci.setUser(user);
        ci.setPassword(password);
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        Server server = new Server(ci, exec);//创建server
        System.out.println("Hello World!1");//检测点2
        server.connect();//连接服务端

        Group group = server.addGroup("Group1");//创建group
        group.setActive ( true );//激活点组
        //创建点组及相关名称
        String[] test2 = new String[]{"a.a.a","a.a.b","a.a.c","a.a.c"};//
        for(String s : test2) {
            System.out.println(s);
            Item item1 = group.addItem(s);
            //获取点的数据
            ItemState itemState = item1.read(true);
            System.out.println("<<< first read: " + itemState.getValue());//itemState.toString()完整信息
        }
        //单点读数
//        final String itemId="a.a.b";
//        Group group = server.addGroup("Group1");
//        Item item = group.addItem(itemId); //get item for writing
//
//        ItemState itemState = item.read(true);
//        System.out.println("<<< first read: " + itemState.toString());//getclass

        System.out.println("Hello World!3");//检测点3
        server.dispose();//关闭server对象
    }
}
