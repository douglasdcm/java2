import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

public class GetZnodeData {

	static ZooKeeper zoo;
	
	//public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
	
	//public static void getZnodeData(String host) throws IOException, KeeperException, InterruptedException {
	public static void getZnode(String path, boolean watcher, Stat stat) throws IOException, KeeperException, InterruptedException {

		//connect
		String hostname = "192.168.44.128:2181";
		createConnection(hostname);
		
		ZookeeperConnection zk = new ZookeeperConnection();
		
		/*
		String path = "/tutorialdrive";
		//Stat stat = new Stat();	//
		 */
		//byte[] dataBytes = zoo.getData(path, false, null);
		byte[] dataBytes = zoo.getData(path, watcher, stat);
		
		
		String str = new String(dataBytes, "UTF-8"); //decode the dataByto to UTF-8
		
		System.out.println(str);

	}
	
	public static void createConnection(String host) throws IOException {
		
		zoo = new ZooKeeper(host, 3000, new Watcher() {
			
			@Override
			public void process(WatchedEvent event) {
				
				System.out.println("Watcher Notification === " + event.getState());
				
			}
		});
		
		
	}

}
