import org.jinterop.dcom.common.JIException;
import org.openscada.opc.lib.common.AlreadyConnectedException;
import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.da.Group;
import org.openscada.opc.lib.da.Item;
import org.openscada.opc.lib.da.ItemState;
import org.openscada.opc.lib.da.Server;

import java.net.UnknownHostException;
import java.security.KeyStore;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.Executors;

public class opctest1 {
    private static String host ="127.0.0.1";//172.16.4.11//IP
    private static String user="expadmin";//computername
    private static String password="admin";//password
    public static void main(String[] args) throws Exception{
        final ConnectionInformation ci = new ConnectionInformation();
        ci.setHost(host);
        ci.setClsid("b57c679b-665d-4bb0-9848-c5f2c4a6a280");
        ci.setUser(user);
        ci.setPassword(password);
        Server server=new Server(ci,Executors.newSingleThreadScheduledExecutor());
        server.connect();
        Group group=server.addGroup();
        itemsFile itemsAll=new itemsFile();
        Map<String,Item> items_1=group.addItems(itemsAll.group1);
        Map<String,Item> items_2=group.addItems(itemsAll.group2);
        long numbers=0;
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        Calendar c1 = Calendar.getInstance();
        int hour1 = c1.get(Calendar.HOUR_OF_DAY);
        int minute1 = c1.get(Calendar.MINUTE);
        int second1 = c1.get(Calendar.SECOND);
        long numbers2=0;
        boolean aaa = false;
        float bbb = 0;
        Date date;
        Calendar timeaa;
        for(;;) {
            numbers++;
            for (Map.Entry<String, Item> temp : items_1.entrySet()) {
                aaa = temp.getValue().read(false).getValue().getObjectAsBoolean();
                System.out.println(aaa);
            }
            for (Map.Entry<String, Item> temp : items_2.entrySet()) {
                bbb = temp.getValue().read(false).getValue().getObjectAsFloat();
                System.out.println(bbb);
                //System.out.println(bbb);
                //dumpItem(temp.getValue());
            }
            c1 = Calendar.getInstance();
            hour1 = c1.get(Calendar.HOUR_OF_DAY);
            minute1 = c1.get(Calendar.MINUTE);
            second1 = c1.get(Calendar.SECOND);
            if(((hour1-hour)*60+(minute1-minute))>-1)
                break;
        }
        System.out.println(hour +":"+minute+":"+second);
        System.out.println(hour1 +":"+minute1+":"+second1);
        System.out.println(numbers);
        System.out.println(numbers2);
    }
    private static void dumpItem(Item item) throws JIException{
        System.out.println(item.getId()+item.read(false).getValue());
    }
}
