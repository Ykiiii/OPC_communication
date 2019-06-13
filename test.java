import java.util.Collection;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

import org.openscada.opc.dcom.list.ClassDetails;
import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.da.AccessBase;
import org.openscada.opc.lib.da.DataCallback;
import org.openscada.opc.lib.da.Item;
import org.openscada.opc.lib.da.ItemState;
import org.openscada.opc.lib.da.Server;
import org.openscada.opc.lib.da.SyncAccess;
import org.openscada.opc.lib.list.Categories;
import org.openscada.opc.lib.list.Category;
import org.openscada.opc.lib.list.ServerList;


/**
 *
 * @author Freud
 *
 */
public class test {


    private static final int PERIOD = 100;
    private static final int SLEEP = 4000;
    private static String host ="127.0.0.1";//172.16.4.11
    private static String domain="127.0.0.1";//127.0.0.1
    private static String user="800xAInstaller";
    private static String password="ABBabb123@";
    public static void main(String[] args) throws Exception {
        ServerList serverList = new ServerList(host,user,password,domain);
        Collection<ClassDetails> classDetails = serverList.listServersWithDetails(new Category[] {
                Categories.OPCDAServer10, Categories.OPCDAServer20,
                Categories.OPCDAServer30 }, new Category[] {});

        for (ClassDetails cds : classDetails) {
            System.out.println(cds.getProgId() + "=" + cds.getDescription());
        }
//		Server server = new Server(
//				BaseConfiguration.getCLSIDConnectionInfomation(),
//				Executors.newSingleThreadScheduledExecutor());
//
//		server.connect();
        final ConnectionInformation ci = new ConnectionInformation();
        ci.setHost(host);
        ci.setClsid(serverList.getClsIdFromProgId ("Knight.OPC.Server.Demo"));  //ICONICS.SimulatorOPCDA.2
        //ci.setClsid("Knight.OPC.Server.Demo");
        ci.setUser(user);
        ci.setPassword(password);
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        Server server = new Server(ci, exec);
        System.out.println("Hello World!");
        server.connect();

        AccessBase access = new SyncAccess(server, PERIOD);

        access.addItem("a.a.b", new DataCallback() {
            private int i;
            public void changed(Item item, ItemState itemstate) {
                System.out.println("[" + (++i) + "],ItemName:[" + item.getId()
                        + "],value:" + itemstate.getValue());
            }
        });
        access.bind();
        Thread.sleep(SLEEP);
        access.unbind();
        server.dispose();
    }
}

