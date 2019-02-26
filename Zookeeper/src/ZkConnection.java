import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class ZkConnection {

	private static ZooKeeper zoo;
		
	public static void main(String[] args) throws KeeperException, InterruptedException {
		
		String host = "192.168.44.128:2181";
		
		zkStartConnection(host);
		
		String path = "/td";
		
		System.out.println(zoo.exists(path, true));
		
	}
	
	public static void zkStartConnection(String hostname) {
		 
        try {

            zoo = new ZooKeeper(hostname, 1000, new Watcher(){

                @Override
                public void process(WatchedEvent event) {

                    System.out.println(event.getState());

                }

            });

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
