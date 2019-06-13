import org.jinterop.dcom.common.JIException;
import org.openscada.opc.dcom.list.ClassDetails;
import org.openscada.opc.lib.common.AlreadyConnectedException;
import org.openscada.opc.lib.common.ConnectionInformation;
import org.openscada.opc.lib.common.NotConnectedException;
import org.openscada.opc.lib.da.*;
//import org.openscada.opc.lib.list.Categories;
//import org.openscada.opc.lib.list.Category;
//import org.openscada.opc.lib.list.ServerList;


import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Collection;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class Main {
    private static String host ="127.0.0.1";//172.16.4.11//IP
    private static String domain="127.0.0.1";//127.0.0.1
    private static String user="expadmin";//computername
    private static String password="admin";//password
    private static final int PERIOD = 100;
    private static final int SLEEP = 2000;
    public static void main(String[] args) throws JIException, UnknownHostException, AlreadyConnectedException, NotConnectedException, DuplicateGroupException, AddFailedException, InterruptedException, DuplicateGroupException {
//        ServerList serverList = new ServerList(host,user,password,domain);
//        System.out.println("Hello World!");
//        Collection<ClassDetails> classDetails = serverList.listServersWithDetails(new Category[] {
//                Categories.OPCDAServer10, Categories.OPCDAServer20,
//                Categories.OPCDAServer30 }, new Category[] {});
//
//        for (ClassDetails cds : classDetails) {
//            System.out.println(cds.getProgId() + "=" + cds.getDescription());
//        }
        final ConnectionInformation ci = new ConnectionInformation();
        ci.setHost(host);
        //System.out.println(serverList.getClsIdFromProgId ("Knight.OPC.Server.Demo"));
        ci.setClsid("b57c679b-665d-4bb0-9848-c5f2c4a6a280");  //ICONICS.SimulatorOPCDA.2
        //ci.setClsid("Knight.OPC.Server.Demo");
        ci.setUser(user);
        ci.setPassword(password);
        ScheduledExecutorService exec = Executors.newSingleThreadScheduledExecutor();
        Server server = new Server(ci, exec);
        System.out.println("Hello World!1");
        server.connect();


        Group group = server.addGroup("Group1");
        group.setActive ( true );

//        String[] test1 = new String[]{"Local.Valve_A_Fault","Local.WaterLevel_A","Local.WaterLevel_B"};//"a.a.b","a.a.c","a.a.d","a.a.e","a.a.f"
//        Map<String,Item> map = new HashMap<String,Item>();
//        map = group.addItems(test1);
//        System.out.println(map.keySet());
//        System.out.println("Hello World!2");
//        for(String s : map.keySet()){
//            Item it = map.get(s);
//            System.out.println(s + " ==  " + it.read(true).getValue());
//        }
        //final Item item = group.addItem ( "Local.Valve_A_Fault" );
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);
        Calendar c1 = Calendar.getInstance();
        int hour1 = c1.get(Calendar.HOUR_OF_DAY);
        int minute1 = c1.get(Calendar.MINUTE);
        int second1 = c1.get(Calendar.SECOND);
        System.out.println(hour +":"+minute+":"+second);
        long strat_num=0;
        String[] test1 = new String[]{
                "/ASSETS/A000/TEST.AI01.PV","/ASSETS/A000/TEST.AI02.PV","/ASSETS/A000/TEST.AI03.PV",
                "/ASSETS/A000/TEST.AI04.PV","/ASSETS/A000/TEST.AI05.PV","/ASSETS/A000/TEST.AI06.PV",
                "/ASSETS/A000/TEST.AI07.PV","/ASSETS/A000/TEST.AI08.PV","/ASSETS/A000/TEST.AI09.PV",
                "/ASSETS/A000/TEST.AI10.PV","/ASSETS/A000/TEST.AI11.PV","/ASSETS/A000/TEST.A12.PV",
                "/ASSETS/A000/TEST.AI13.PV","/ASSETS/A000/TEST.AI14.PV","/ASSETS/A000/TEST.A15.PV",
                "/ASSETS/A000/TEST.AI16.PV","/ASSETS/A000/TEST.AI17.PV","/ASSETS/A000/TEST.AI18.PV",
                "/ASSETS/A000/TEST.AI19.PV","/ASSETS/A000/TEST.AI20.PV","/ASSETS/A000/TEST.AI21.PV",
                "/ASSETS/A000/TEST.AI22.PV","/ASSETS/A000/TEST.AI23.PV","/ASSETS/A000/TEST.AI24.PV",
                "/ASSETS/A000/TEST.AI25.PV","/ASSETS/A000/TEST.AI26.PV","/ASSETS/A000/TEST.AI27.PV",
                "/ASSETS/A000/TEST.AI28.PV","/ASSETS/A000/TEST.AI29.PV","/ASSETS/A000/TEST.AI30.PV",
                "/ASSETS/A000/TEST.AI31.PV","/ASSETS/A000/TEST.AI32.PV","/ASSETS/A000/TEST.AI33.PV",
                "/ASSETS/A000/TEST.AI34.PV","/ASSETS/A000/TEST.AI35.PV","/ASSETS/A000/TEST.AI36.PV",
                "/ASSETS/A000/TEST.AI37.PV","/ASSETS/A000/TEST.AI38.PV","/ASSETS/A000/TEST.AI39.PV",
                "/ASSETS/A000/TEST.A140.PV","/ASSETS/A000/TEST.AI41.PV","/ASSETS/A000/TEST.AI42.PV",
                "/ASSETS/A000/TEST.AI43.PV","/ASSETS/A000/TEST.AI44.PV","/ASSETS/A000/TEST.AI45.PV",
                "/ASSETS/A000/TEST.AI46.PV","/ASSETS/A000/TEST.AI47.PV","/ASSETS/A000/TEST.AI48.PV",
                "/ASSETS/A000/TEST.AI49.PV","/ASSETS/A000/TEST.AI50.PV",
                "/ASSETS/A000/TEST.AI01_1.PV","/ASSETS/A000/TEST.AI02_1.PV","/ASSETS/A000/TEST.AI03_1.PV",
                "/ASSETS/A000/TEST.AI04_1.PV","/ASSETS/A000/TEST.AI05_1.PV","/ASSETS/A000/TEST.AI06_1.PV",
                "/ASSETS/A000/TEST.AI07_1.PV","/ASSETS/A000/TEST.AI08_1.PV","/ASSETS/A000/TEST.AI09_1.PV",
                "/ASSETS/A000/TEST.AI10_1.PV","/ASSETS/A000/TEST.AI11_1.PV","/ASSETS/A000/TEST.A12_1.PV",
                "/ASSETS/A000/TEST.AI13_1.PV","/ASSETS/A000/TEST.AI14_1.PV","/ASSETS/A000/TEST.A15_1.PV",
                "/ASSETS/A000/TEST.AI16_1.PV","/ASSETS/A000/TEST.AI17_1.PV","/ASSETS/A000/TEST.AI18_1.PV",
                "/ASSETS/A000/TEST.AI19_1.PV","/ASSETS/A000/TEST.AI20_1.PV","/ASSETS/A000/TEST.AI21_1.PV",
                "/ASSETS/A000/TEST.AI22_1.PV","/ASSETS/A000/TEST.AI23_1.PV","/ASSETS/A000/TEST.AI24_1.PV",
                "/ASSETS/A000/TEST.AI25_1.PV","/ASSETS/A000/TEST.AI26_1.PV","/ASSETS/A000/TEST.AI27_1.PV",
                "/ASSETS/A000/TEST.AI28_1.PV","/ASSETS/A000/TEST.AI29_1.PV","/ASSETS/A000/TEST.AI30_1.PV",
                "/ASSETS/A000/TEST.AI31_1.PV","/ASSETS/A000/TEST.AI32_1.PV","/ASSETS/A000/TEST.AI33_1.PV",
                "/ASSETS/A000/TEST.AI34_1.PV","/ASSETS/A000/TEST.AI35_1.PV","/ASSETS/A000/TEST.AI36_1.PV",
                "/ASSETS/A000/TEST.AI37_1.PV","/ASSETS/A000/TEST.AI38_1.PV","/ASSETS/A000/TEST.AI39_1.PV",
                "/ASSETS/A000/TEST.A140_1.PV","/ASSETS/A000/TEST.AI41_1.PV","/ASSETS/A000/TEST.AI42_1.PV",
                "/ASSETS/A000/TEST.AI43_1.PV","/ASSETS/A000/TEST.AI44_1.PV","/ASSETS/A000/TEST.AI45_1.PV",
                "/ASSETS/A000/TEST.AI46_1.PV","/ASSETS/A000/TEST.AI47_1.PV","/ASSETS/A000/TEST.AI48_1.PV",
                "/ASSETS/A000/TEST.AI49_1.PV","/ASSETS/A000/TEST.AI50_1.PV"};
        String[] test2 = new String[]{
                "/ASSETS/A000/TEST0.AI01.PV","/ASSETS/A000/TEST0.AI02.PV","/ASSETS/A000/TEST0.AI03.PV",
                "/ASSETS/A000/TEST0.AI04.PV","/ASSETS/A000/TEST0.AI05.PV","/ASSETS/A000/TEST0.AI06.PV",
                "/ASSETS/A000/TEST0.AI07.PV","/ASSETS/A000/TEST0.AI08.PV","/ASSETS/A000/TEST0.AI09.PV",
                "/ASSETS/A000/TEST0.AI10.PV","/ASSETS/A000/TEST0.AI11.PV","/ASSETS/A000/TEST0.A12.PV",
                "/ASSETS/A000/TEST0.AI13.PV","/ASSETS/A000/TEST0.AI14.PV","/ASSETS/A000/TEST0.A15.PV",
                "/ASSETS/A000/TEST0.AI16.PV","/ASSETS/A000/TEST0.AI17.PV","/ASSETS/A000/TEST0.AI18.PV",
                "/ASSETS/A000/TEST0.AI19.PV","/ASSETS/A000/TEST0.AI20.PV","/ASSETS/A000/TEST0.AI21.PV",
                "/ASSETS/A000/TEST0.AI22.PV","/ASSETS/A000/TEST0.AI23.PV","/ASSETS/A000/TEST0.AI24.PV",
                "/ASSETS/A000/TEST0.AI25.PV","/ASSETS/A000/TEST0.AI26.PV","/ASSETS/A000/TEST0.AI27.PV",
                "/ASSETS/A000/TEST0.AI28.PV","/ASSETS/A000/TEST0.AI29.PV","/ASSETS/A000/TEST0.AI30.PV",
                "/ASSETS/A000/TEST0.AI31.PV","/ASSETS/A000/TEST0.AI32.PV","/ASSETS/A000/TEST0.AI33.PV",
                "/ASSETS/A000/TEST0.AI34.PV","/ASSETS/A000/TEST0.AI35.PV","/ASSETS/A000/TEST0.AI36.PV",
                "/ASSETS/A000/TEST0.AI37.PV","/ASSETS/A000/TEST0.AI38.PV","/ASSETS/A000/TEST0.AI39.PV",
                "/ASSETS/A000/TEST0.A140.PV","/ASSETS/A000/TEST0.AI41.PV","/ASSETS/A000/TEST0.AI42.PV",
                "/ASSETS/A000/TEST0.AI43.PV","/ASSETS/A000/TEST0.AI44.PV","/ASSETS/A000/TEST0.AI45.PV",
                "/ASSETS/A000/TEST0.AI46.PV","/ASSETS/A000/TEST0.AI47.PV","/ASSETS/A000/TEST0.AI48.PV",
                "/ASSETS/A000/TEST0.AI49.PV","/ASSETS/A000/TEST0.AI50.PV",
                "/ASSETS/A000/TEST0.AI01_1.PV","/ASSETS/A000/TEST0.AI02_1.PV","/ASSETS/A000/TEST0.AI03_1.PV",
                "/ASSETS/A000/TEST0.AI04_1.PV","/ASSETS/A000/TEST0.AI05_1.PV","/ASSETS/A000/TEST0.AI06_1.PV",
                "/ASSETS/A000/TEST0.AI07_1.PV","/ASSETS/A000/TEST0.AI08_1.PV","/ASSETS/A000/TEST0.AI09_1.PV",
                "/ASSETS/A000/TEST0.AI10_1.PV","/ASSETS/A000/TEST0.AI11_1.PV","/ASSETS/A000/TEST0.A12_1.PV",
                "/ASSETS/A000/TEST0.AI13_1.PV","/ASSETS/A000/TEST0.AI14_1.PV","/ASSETS/A000/TEST0.A15_1.PV",
                "/ASSETS/A000/TEST0.AI16_1.PV","/ASSETS/A000/TEST0.AI17_1.PV","/ASSETS/A000/TEST0.AI18_1.PV",
                "/ASSETS/A000/TEST0.AI19_1.PV","/ASSETS/A000/TEST0.AI20_1.PV","/ASSETS/A000/TEST0.AI21_1.PV",
                "/ASSETS/A000/TEST0.AI22_1.PV","/ASSETS/A000/TEST0.AI23_1.PV","/ASSETS/A000/TEST0.AI24_1.PV",
                "/ASSETS/A000/TEST0.AI25_1.PV","/ASSETS/A000/TEST0.AI26_1.PV","/ASSETS/A000/TEST0.AI27_1.PV",
                "/ASSETS/A000/TEST0.AI28_1.PV","/ASSETS/A000/TEST0.AI29_1.PV","/ASSETS/A000/TEST0.AI30_1.PV",
                "/ASSETS/A000/TEST0.AI31_1.PV","/ASSETS/A000/TEST0.AI32_1.PV","/ASSETS/A000/TEST0.AI33_1.PV",
                "/ASSETS/A000/TEST0.AI34_1.PV","/ASSETS/A000/TEST0.AI35_1.PV","/ASSETS/A000/TEST0.AI36_1.PV",
                "/ASSETS/A000/TEST0.AI37_1.PV","/ASSETS/A000/TEST0.AI38_1.PV","/ASSETS/A000/TEST0.AI39_1.PV",
                "/ASSETS/A000/TEST0.A140_1.PV","/ASSETS/A000/TEST0.AI41_1.PV","/ASSETS/A000/TEST0.AI42_1.PV",
                "/ASSETS/A000/TEST0.AI43_1.PV","/ASSETS/A000/TEST0.AI44_1.PV","/ASSETS/A000/TEST0.AI45_1.PV",
                "/ASSETS/A000/TEST0.AI46_1.PV","/ASSETS/A000/TEST0.AI47_1.PV","/ASSETS/A000/TEST0.AI48_1.PV",
                "/ASSETS/A000/TEST0.AI49_1.PV","/ASSETS/A000/TEST0.AI50_1.PV"};
        String[] test3 = new String[]{
                "/ASSETS/A000/TEST1.AI01.PV","/ASSETS/A000/TEST1.AI02.PV","/ASSETS/A000/TEST1.AI03.PV",
                "/ASSETS/A000/TEST1.AI04.PV","/ASSETS/A000/TEST1.AI05.PV","/ASSETS/A000/TEST1.AI06.PV",
                "/ASSETS/A000/TEST1.AI07.PV","/ASSETS/A000/TEST1.AI08.PV","/ASSETS/A000/TEST1.AI09.PV",
                "/ASSETS/A000/TEST1.AI10.PV","/ASSETS/A000/TEST1.AI11.PV","/ASSETS/A000/TEST1.AI12.PV",
                "/ASSETS/A000/TEST1.AI13.PV","/ASSETS/A000/TEST1.AI14.PV","/ASSETS/A000/TEST1.AI15.PV",
                "/ASSETS/A000/TEST1.AI16.PV","/ASSETS/A000/TEST1.AI17.PV","/ASSETS/A000/TEST1.AI18.PV",
                "/ASSETS/A000/TEST1.AI19.PV","/ASSETS/A000/TEST1.AI20.PV","/ASSETS/A000/TEST1.AI21.PV",
                "/ASSETS/A000/TEST1.AI22.PV","/ASSETS/A000/TEST1.AI23.PV","/ASSETS/A000/TEST1.AI24.PV",
                "/ASSETS/A000/TEST1.AI25.PV","/ASSETS/A000/TEST1.AI26.PV","/ASSETS/A000/TEST1.AI27.PV",
                "/ASSETS/A000/TEST1.AI28.PV","/ASSETS/A000/TEST1.AI29.PV","/ASSETS/A000/TEST1.AI30.PV",
                "/ASSETS/A000/TEST1.AI31.PV","/ASSETS/A000/TEST1.AI32.PV","/ASSETS/A000/TEST1.AI33.PV",
                "/ASSETS/A000/TEST1.AI34.PV","/ASSETS/A000/TEST1.AI35.PV","/ASSETS/A000/TEST1.AI36.PV",
                "/ASSETS/A000/TEST1.AI37.PV","/ASSETS/A000/TEST1.AI38.PV","/ASSETS/A000/TEST1.AI39.PV",
                "/ASSETS/A000/TEST1.AI40.PV","/ASSETS/A000/TEST1.AI41.PV","/ASSETS/A000/TEST1.AI42.PV",
                "/ASSETS/A000/TEST1.AI43.PV","/ASSETS/A000/TEST1.AI44.PV","/ASSETS/A000/TEST1.AI45.PV",
                "/ASSETS/A000/TEST1.AI46.PV","/ASSETS/A000/TEST1.AI47.PV","/ASSETS/A000/TEST1.AI48.PV",
                "/ASSETS/A000/TEST1.AI49.PV","/ASSETS/A000/TEST1.AI50.PV",
                "/ASSETS/A000/TEST1.AI01_1.PV","/ASSETS/A000/TEST1.AI02_1.PV","/ASSETS/A000/TEST1.AI03_1.PV",
                "/ASSETS/A000/TEST1.AI04_1.PV","/ASSETS/A000/TEST1.AI05_1.PV","/ASSETS/A000/TEST1.AI06_1.PV",
                "/ASSETS/A000/TEST1.AI07_1.PV","/ASSETS/A000/TEST1.AI08_1.PV","/ASSETS/A000/TEST1.AI09_1.PV",
                "/ASSETS/A000/TEST1.AI10_1.PV","/ASSETS/A000/TEST1.AI11_1.PV","/ASSETS/A000/TEST1.AI12_1.PV",
                "/ASSETS/A000/TEST1.AI13_1.PV","/ASSETS/A000/TEST1.AI14_1.PV","/ASSETS/A000/TEST1.AI15_1.PV",
                "/ASSETS/A000/TEST1.AI16_1.PV","/ASSETS/A000/TEST1.AI17_1.PV","/ASSETS/A000/TEST1.AI18_1.PV",
                "/ASSETS/A000/TEST1.AI19_1.PV","/ASSETS/A000/TEST1.AI20_1.PV","/ASSETS/A000/TEST1.AI21_1.PV",
                "/ASSETS/A000/TEST1.AI22_1.PV","/ASSETS/A000/TEST1.AI23_1.PV","/ASSETS/A000/TEST1.AI24_1.PV",
                "/ASSETS/A000/TEST1.AI25_1.PV","/ASSETS/A000/TEST1.AI26_1.PV","/ASSETS/A000/TEST1.AI27_1.PV",
                "/ASSETS/A000/TEST1.AI28_1.PV","/ASSETS/A000/TEST1.AI29_1.PV","/ASSETS/A000/TEST1.AI30_1.PV",
                "/ASSETS/A000/TEST1.AI31_1.PV","/ASSETS/A000/TEST1.AI32_1.PV","/ASSETS/A000/TEST1.AI33_1.PV",
                "/ASSETS/A000/TEST1.AI34_1.PV","/ASSETS/A000/TEST1.AI35_1.PV","/ASSETS/A000/TEST1.AI36_1.PV",
                "/ASSETS/A000/TEST1.AI37_1.PV","/ASSETS/A000/TEST1.AI38_1.PV","/ASSETS/A000/TEST1.AI39_1.PV",
                "/ASSETS/A000/TEST1.AI40_1.PV","/ASSETS/A000/TEST1.AI41_1.PV","/ASSETS/A000/TEST1.AI42_1.PV",
                "/ASSETS/A000/TEST1.AI43_1.PV","/ASSETS/A000/TEST1.AI44_1.PV","/ASSETS/A000/TEST1.AI45_1.PV",
                "/ASSETS/A000/TEST1.AI46_1.PV","/ASSETS/A000/TEST1.AI47_1.PV","/ASSETS/A000/TEST1.AI48_1.PV",
                "/ASSETS/A000/TEST1.AI49_1.PV","/ASSETS/A000/TEST1.AI50_1.PV"};
        String[] test4 = new String[]{
                "/ASSETS/A000/TEST2.AI01.PV","/ASSETS/A000/TEST2.AI02.PV","/ASSETS/A000/TEST2.AI03.PV",
                "/ASSETS/A000/TEST2.AI04.PV","/ASSETS/A000/TEST2.AI05.PV","/ASSETS/A000/TEST2.AI06.PV",
                "/ASSETS/A000/TEST2.AI07.PV","/ASSETS/A000/TEST2.AI08.PV","/ASSETS/A000/TEST2.AI09.PV",
                "/ASSETS/A000/TEST2.AI10.PV","/ASSETS/A000/TEST2.AI11.PV","/ASSETS/A000/TEST2.AI12.PV",
                "/ASSETS/A000/TEST2.AI13.PV","/ASSETS/A000/TEST2.AI14.PV","/ASSETS/A000/TEST2.AI15.PV",
                "/ASSETS/A000/TEST2.AI16.PV","/ASSETS/A000/TEST2.AI17.PV","/ASSETS/A000/TEST2.AI18.PV",
                "/ASSETS/A000/TEST2.AI19.PV","/ASSETS/A000/TEST2.AI20.PV","/ASSETS/A000/TEST2.AI21.PV",
                "/ASSETS/A000/TEST2.AI22.PV","/ASSETS/A000/TEST2.AI23.PV","/ASSETS/A000/TEST2.AI24.PV",
                "/ASSETS/A000/TEST2.AI25.PV","/ASSETS/A000/TEST2.AI26.PV","/ASSETS/A000/TEST2.AI27.PV",
                "/ASSETS/A000/TEST2.AI28.PV","/ASSETS/A000/TEST2.AI29.PV","/ASSETS/A000/TEST2.AI30.PV",
                "/ASSETS/A000/TEST2.AI31.PV","/ASSETS/A000/TEST2.AI32.PV","/ASSETS/A000/TEST2.AI33.PV",
                "/ASSETS/A000/TEST2.AI34.PV","/ASSETS/A000/TEST2.AI35.PV","/ASSETS/A000/TEST2.AI36.PV",
                "/ASSETS/A000/TEST2.AI37.PV","/ASSETS/A000/TEST2.AI38.PV","/ASSETS/A000/TEST2.AI39.PV",
                "/ASSETS/A000/TEST2.AI40.PV","/ASSETS/A000/TEST2.AI41.PV","/ASSETS/A000/TEST2.AI42.PV",
                "/ASSETS/A000/TEST2.AI43.PV","/ASSETS/A000/TEST2.AI44.PV","/ASSETS/A000/TEST2.AI45.PV",
                "/ASSETS/A000/TEST2.AI46.PV","/ASSETS/A000/TEST2.AI47.PV","/ASSETS/A000/TEST2.AI48.PV",
                "/ASSETS/A000/TEST2.AI49.PV","/ASSETS/A000/TEST2.AI50.PV",
                "/ASSETS/A000/TEST2.AI01_1.PV","/ASSETS/A000/TEST2.AI02_1.PV","/ASSETS/A000/TEST2.AI03_1.PV",
                "/ASSETS/A000/TEST2.AI04_1.PV","/ASSETS/A000/TEST2.AI05_1.PV","/ASSETS/A000/TEST2.AI06_1.PV",
                "/ASSETS/A000/TEST2.AI07_1.PV","/ASSETS/A000/TEST2.AI08_1.PV","/ASSETS/A000/TEST2.AI09_1.PV",
                "/ASSETS/A000/TEST2.AI10_1.PV","/ASSETS/A000/TEST2.AI11_1.PV","/ASSETS/A000/TEST2.AI12_1.PV",
                "/ASSETS/A000/TEST2.AI13_1.PV","/ASSETS/A000/TEST2.AI14_1.PV","/ASSETS/A000/TEST2.AI15_1.PV",
                "/ASSETS/A000/TEST2.AI16_1.PV","/ASSETS/A000/TEST2.AI17_1.PV","/ASSETS/A000/TEST2.AI18_1.PV",
                "/ASSETS/A000/TEST2.AI19_1.PV","/ASSETS/A000/TEST2.AI20_1.PV","/ASSETS/A000/TEST2.AI21_1.PV",
                "/ASSETS/A000/TEST2.AI22_1.PV","/ASSETS/A000/TEST2.AI23_1.PV","/ASSETS/A000/TEST2.AI24_1.PV",
                "/ASSETS/A000/TEST2.AI25_1.PV","/ASSETS/A000/TEST2.AI26_1.PV","/ASSETS/A000/TEST2.AI27_1.PV",
                "/ASSETS/A000/TEST2.AI28_1.PV","/ASSETS/A000/TEST2.AI29_1.PV","/ASSETS/A000/TEST2.AI30_1.PV",
                "/ASSETS/A000/TEST2.AI31_1.PV","/ASSETS/A000/TEST2.AI32_1.PV","/ASSETS/A000/TEST2.AI33_1.PV",
                "/ASSETS/A000/TEST2.AI34_1.PV","/ASSETS/A000/TEST2.AI35_1.PV","/ASSETS/A000/TEST2.AI36_1.PV",
                "/ASSETS/A000/TEST2.AI37_1.PV","/ASSETS/A000/TEST2.AI38_1.PV","/ASSETS/A000/TEST2.AI39_1.PV",
                "/ASSETS/A000/TEST2.AI40_1.PV","/ASSETS/A000/TEST2.AI41_1.PV","/ASSETS/A000/TEST2.AI42_1.PV",
                "/ASSETS/A000/TEST2.AI43_1.PV","/ASSETS/A000/TEST2.AI44_1.PV","/ASSETS/A000/TEST2.AI45_1.PV",
                "/ASSETS/A000/TEST2.AI46_1.PV","/ASSETS/A000/TEST2.AI47_1.PV","/ASSETS/A000/TEST2.AI48_1.PV",
                "/ASSETS/A000/TEST2.AI49_1.PV","/ASSETS/A000/TEST2.AI50_1.PV"};
        String[] test5 = new String[]{
                "/ASSETS/A000/TEST3.AI01.PV","/ASSETS/A000/TEST3.AI02.PV","/ASSETS/A000/TEST3.AI03.PV",
                "/ASSETS/A000/TEST3.AI04.PV","/ASSETS/A000/TEST3.AI05.PV","/ASSETS/A000/TEST3.AI06.PV",
                "/ASSETS/A000/TEST3.AI07.PV","/ASSETS/A000/TEST3.AI08.PV","/ASSETS/A000/TEST3.AI09.PV",
                "/ASSETS/A000/TEST3.AI10.PV","/ASSETS/A000/TEST3.AI11.PV","/ASSETS/A000/TEST3.AI12.PV",
                "/ASSETS/A000/TEST3.AI13.PV","/ASSETS/A000/TEST3.AI14.PV","/ASSETS/A000/TEST3.AI15.PV",
                "/ASSETS/A000/TEST3.AI16.PV","/ASSETS/A000/TEST3.AI17.PV","/ASSETS/A000/TEST3.AI18.PV",
                "/ASSETS/A000/TEST3.AI19.PV","/ASSETS/A000/TEST3.AI20.PV","/ASSETS/A000/TEST3.AI21.PV",
                "/ASSETS/A000/TEST3.AI22.PV","/ASSETS/A000/TEST3.AI23.PV","/ASSETS/A000/TEST3.AI24.PV",
                "/ASSETS/A000/TEST3.AI25.PV","/ASSETS/A000/TEST3.AI26.PV","/ASSETS/A000/TEST3.AI27.PV",
                "/ASSETS/A000/TEST3.AI28.PV","/ASSETS/A000/TEST3.AI29.PV","/ASSETS/A000/TEST3.AI30.PV",
                "/ASSETS/A000/TEST3.AI31.PV","/ASSETS/A000/TEST3.AI32.PV","/ASSETS/A000/TEST3.AI33.PV",
                "/ASSETS/A000/TEST3.AI34.PV","/ASSETS/A000/TEST3.AI35.PV","/ASSETS/A000/TEST3.AI36.PV",
                "/ASSETS/A000/TEST3.AI37.PV","/ASSETS/A000/TEST3.AI38.PV","/ASSETS/A000/TEST3.AI39.PV",
                "/ASSETS/A000/TEST3.AI40.PV","/ASSETS/A000/TEST3.AI41.PV","/ASSETS/A000/TEST3.AI42.PV",
                "/ASSETS/A000/TEST3.AI43.PV","/ASSETS/A000/TEST3.AI44.PV","/ASSETS/A000/TEST3.AI45.PV",
                "/ASSETS/A000/TEST3.AI46.PV","/ASSETS/A000/TEST3.AI47.PV","/ASSETS/A000/TEST3.AI48.PV",
                "/ASSETS/A000/TEST3.AI49.PV","/ASSETS/A000/TEST3.AI50.PV",
                "/ASSETS/A000/TEST3.AI01_1.PV","/ASSETS/A000/TEST3.AI02_1.PV","/ASSETS/A000/TEST3.AI03_1.PV",
                "/ASSETS/A000/TEST3.AI04_1.PV","/ASSETS/A000/TEST3.AI05_1.PV","/ASSETS/A000/TEST3.AI06_1.PV",
                "/ASSETS/A000/TEST3.AI07_1.PV","/ASSETS/A000/TEST3.AI08_1.PV","/ASSETS/A000/TEST3.AI09_1.PV",
                "/ASSETS/A000/TEST3.AI10_1.PV","/ASSETS/A000/TEST3.AI11_1.PV","/ASSETS/A000/TEST3.AI12_1.PV",
                "/ASSETS/A000/TEST3.AI13_1.PV","/ASSETS/A000/TEST3.AI14_1.PV","/ASSETS/A000/TEST3.AI15_1.PV",
                "/ASSETS/A000/TEST3.AI16_1.PV","/ASSETS/A000/TEST3.AI17_1.PV","/ASSETS/A000/TEST3.AI18_1.PV",
                "/ASSETS/A000/TEST3.AI19_1.PV","/ASSETS/A000/TEST3.AI20_1.PV","/ASSETS/A000/TEST3.AI21_1.PV",
                "/ASSETS/A000/TEST3.AI22_1.PV","/ASSETS/A000/TEST3.AI23_1.PV","/ASSETS/A000/TEST3.AI24_1.PV",
                "/ASSETS/A000/TEST3.AI25_1.PV","/ASSETS/A000/TEST3.AI26_1.PV","/ASSETS/A000/TEST3.AI27_1.PV",
                "/ASSETS/A000/TEST3.AI28_1.PV","/ASSETS/A000/TEST3.AI29_1.PV","/ASSETS/A000/TEST3.AI30_1.PV",
                "/ASSETS/A000/TEST3.AI31_1.PV","/ASSETS/A000/TEST3.AI32_1.PV","/ASSETS/A000/TEST3.AI33_1.PV",
                "/ASSETS/A000/TEST3.AI34_1.PV","/ASSETS/A000/TEST3.AI35_1.PV","/ASSETS/A000/TEST3.AI36_1.PV",
                "/ASSETS/A000/TEST3.AI37_1.PV","/ASSETS/A000/TEST3.AI38_1.PV","/ASSETS/A000/TEST3.AI39_1.PV",
                "/ASSETS/A000/TEST3.AI40_1.PV","/ASSETS/A000/TEST3.AI41_1.PV","/ASSETS/A000/TEST3.AI42_1.PV",
                "/ASSETS/A000/TEST3.AI43_1.PV","/ASSETS/A000/TEST3.AI44_1.PV","/ASSETS/A000/TEST3.AI45_1.PV",
                "/ASSETS/A000/TEST3.AI46_1.PV","/ASSETS/A000/TEST3.AI47_1.PV","/ASSETS/A000/TEST3.AI48_1.PV",
                "/ASSETS/A000/TEST3.AI49_1.PV","/ASSETS/A000/TEST3.AI50_1.PV"};
        String[] test6 = new String[]{
                "/ASSETS/A000/TEST4.AI01.PV","/ASSETS/A000/TEST4.AI02.PV","/ASSETS/A000/TEST4.AI03.PV",
                "/ASSETS/A000/TEST4.AI04.PV","/ASSETS/A000/TEST4.AI05.PV","/ASSETS/A000/TEST4.AI06.PV",
                "/ASSETS/A000/TEST4.AI07.PV","/ASSETS/A000/TEST4.AI08.PV","/ASSETS/A000/TEST4.AI09.PV",
                "/ASSETS/A000/TEST4.AI10.PV","/ASSETS/A000/TEST4.AI11.PV","/ASSETS/A000/TEST4.AI12.PV",
                "/ASSETS/A000/TEST4.AI13.PV","/ASSETS/A000/TEST4.AI14.PV","/ASSETS/A000/TEST4.AI15.PV",
                "/ASSETS/A000/TEST4.AI16.PV","/ASSETS/A000/TEST4.AI17.PV","/ASSETS/A000/TEST4.AI18.PV",
                "/ASSETS/A000/TEST4.AI19.PV","/ASSETS/A000/TEST4.AI20.PV","/ASSETS/A000/TEST4.AI21.PV",
                "/ASSETS/A000/TEST4.AI22.PV","/ASSETS/A000/TEST4.AI23.PV","/ASSETS/A000/TEST4.AI24.PV",
                "/ASSETS/A000/TEST4.AI25.PV","/ASSETS/A000/TEST4.AI26.PV","/ASSETS/A000/TEST4.AI27.PV",
                "/ASSETS/A000/TEST4.AI28.PV","/ASSETS/A000/TEST4.AI29.PV","/ASSETS/A000/TEST4.AI30.PV",
                "/ASSETS/A000/TEST4.AI31.PV","/ASSETS/A000/TEST4.AI32.PV","/ASSETS/A000/TEST4.AI33.PV",
                "/ASSETS/A000/TEST4.AI34.PV","/ASSETS/A000/TEST4.AI35.PV","/ASSETS/A000/TEST4.AI36.PV",
                "/ASSETS/A000/TEST4.AI37.PV","/ASSETS/A000/TEST4.AI38.PV","/ASSETS/A000/TEST4.AI39.PV",
                "/ASSETS/A000/TEST4.AI40.PV","/ASSETS/A000/TEST4.AI41.PV","/ASSETS/A000/TEST4.AI42.PV",
                "/ASSETS/A000/TEST4.AI43.PV","/ASSETS/A000/TEST4.AI44.PV","/ASSETS/A000/TEST4.AI45.PV",
                "/ASSETS/A000/TEST4.AI46.PV","/ASSETS/A000/TEST4.AI47.PV","/ASSETS/A000/TEST4.AI48.PV",
                "/ASSETS/A000/TEST4.AI49.PV","/ASSETS/A000/TEST4.AI50.PV",
                "/ASSETS/A000/TEST4.AI01_1.PV","/ASSETS/A000/TEST4.AI02_1.PV","/ASSETS/A000/TEST4.AI03_1.PV",
                "/ASSETS/A000/TEST4.AI04_1.PV","/ASSETS/A000/TEST4.AI05_1.PV","/ASSETS/A000/TEST4.AI06_1.PV",
                "/ASSETS/A000/TEST4.AI07_1.PV","/ASSETS/A000/TEST4.AI08_1.PV","/ASSETS/A000/TEST4.AI09_1.PV",
                "/ASSETS/A000/TEST4.AI10_1.PV","/ASSETS/A000/TEST4.AI11_1.PV","/ASSETS/A000/TEST4.AI12_1.PV",
                "/ASSETS/A000/TEST4.AI13_1.PV","/ASSETS/A000/TEST4.AI14_1.PV","/ASSETS/A000/TEST4.AI15_1.PV",
                "/ASSETS/A000/TEST4.AI16_1.PV","/ASSETS/A000/TEST4.AI17_1.PV","/ASSETS/A000/TEST4.AI18_1.PV",
                "/ASSETS/A000/TEST4.AI19_1.PV","/ASSETS/A000/TEST4.AI20_1.PV","/ASSETS/A000/TEST4.AI21_1.PV",
                "/ASSETS/A000/TEST4.AI22_1.PV","/ASSETS/A000/TEST4.AI23_1.PV","/ASSETS/A000/TEST4.AI24_1.PV",
                "/ASSETS/A000/TEST4.AI25_1.PV","/ASSETS/A000/TEST4.AI26_1.PV","/ASSETS/A000/TEST4.AI27_1.PV",
                "/ASSETS/A000/TEST4.AI28_1.PV","/ASSETS/A000/TEST4.AI29_1.PV","/ASSETS/A000/TEST4.AI30_1.PV",
                "/ASSETS/A000/TEST4.AI31_1.PV","/ASSETS/A000/TEST4.AI32_1.PV","/ASSETS/A000/TEST4.AI33_1.PV",
                "/ASSETS/A000/TEST4.AI34_1.PV","/ASSETS/A000/TEST4.AI35_1.PV","/ASSETS/A000/TEST4.AI36_1.PV",
                "/ASSETS/A000/TEST4.AI37_1.PV","/ASSETS/A000/TEST4.AI38_1.PV","/ASSETS/A000/TEST4.AI39_1.PV",
                "/ASSETS/A000/TEST4.AI40_1.PV","/ASSETS/A000/TEST4.AI41_1.PV","/ASSETS/A000/TEST4.AI42_1.PV",
                "/ASSETS/A000/TEST4.AI43_1.PV","/ASSETS/A000/TEST4.AI44_1.PV","/ASSETS/A000/TEST4.AI45_1.PV",
                "/ASSETS/A000/TEST4.AI46_1.PV","/ASSETS/A000/TEST4.AI47_1.PV","/ASSETS/A000/TEST4.AI48_1.PV",
                "/ASSETS/A000/TEST4.AI49_1.PV","/ASSETS/A000/TEST4.AI50_1.PV"};
        // "Textual.Colors","Textual.Memory","Textual.Months","Textual.Numerals","Textual.Random","Textual.Weekdays
        itemsFile itemsAll=new itemsFile();
        strat_num++;
        Item item1=group.addItem("a.a.a");
        ItemState itemState=item1.read(true);
//        for (String s : itemsAll.group1) {
//            System.out.println(s);
//            item1 = group.addItem(s);
//            itemState = item1.read(true);
//            System.out.println("<<< first read: " + itemState.getValue());//itemState.toString()完整信息
//        }
//        for (String s : itemsAll.group2) {
//            System.out.println(s);
//            item1 = group.addItem(s);
//            itemState = item1.read(true);
//            System.out.println("<<< first read: " + itemState.getValue());//itemState.toString()完整信息
//        }
        for(;;)
        {
            strat_num++;
            itemState=item1.read(true);
            //System.out.println("<<< first read: " + itemState.getValue());
//            for (String s : itemsAll.group1) {
//                System.out.println(s);
//                itemState = item1.read(true);
//                System.out.println("<<< first read: " + itemState.getValue());//itemState.toString()完整信息
//            }
//            for (String s : test2) {
//                System.out.println(s);
//                Item item1 = group.addItem(s);
//                ItemState itemState = item1.read(true);
//                System.out.println("<<< first read: " + itemState.getValue());//itemState.toString()完整信息
//            }
            c1 = Calendar.getInstance();
            hour1 = c1.get(Calendar.HOUR_OF_DAY);
            minute1 = c1.get(Calendar.MINUTE);
            second1 = c1.get(Calendar.SECOND);
            if(((hour1-hour)*60+(minute1-minute))>2)
                break;
        }
        System.out.println(hour +":"+minute+":"+second);
        System.out.println(hour1 +":"+minute1+":"+second1);
        System.out.println(strat_num);
//        final String itemId="a.a.b";
//        Group group = server.addGroup("Group1");
//        Item item = group.addItem(itemId); //get item for writing
//
//        ItemState itemState = item.read(true);
//        System.out.println("<<< first read: " + itemState.toString());//getclass

        System.out.println("Hello World!3");
        server.dispose();
    }
}
