import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.ACL;

public class CreateZnode {

	static ZooKeeper zoo;
	
	//public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
	
	public static void createZnode(String path, byte[] data, List<ACL> acl, CreateMode createMode) throws IOException, KeeperException, InterruptedException {
		
		String hostname = "192.168.44.128:2181";
		
		createConnection(hostname);
		
		/*
		String path = "/td";
		byte[] data = "We can learn most of the Tech here".getBytes();
		List<ACL> acl = ZooDefs.Ids.OPEN_ACL_UNSAFE;
		CreateMode createMode = CreateMode.PERSISTENT;
		*/
		
		zoo.create(path, data, acl, createMode);
		
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
