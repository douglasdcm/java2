import java.io.IOException;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.Watcher;

public class GetChildInfo {

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {

		
		String hostname = "192.168.44.128:2181";
		ZookeeperConnection zk = new ZookeeperConnection();
		
		ZookeeperConnection.createConnection(hostname);
		
		String path ="/";
		System.out.println(zk.zoo.getChildren(path, false));
		
	}

}
