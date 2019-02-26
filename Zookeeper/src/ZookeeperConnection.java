import java.io.IOException;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

public class ZookeeperConnection {

	static ZooKeeper zoo;
	
	public static void main(String[] args) throws IOException, InterruptedException {

		String hostname = "192.168.44.128:2181";
		
		createConnection(hostname);

		while(true) {
			Thread.sleep(1000);
			
			System.out.println("Zookeeper Notificationd === " + zoo.getState());
			
		}
		
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
