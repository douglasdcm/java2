import java.io.IOException;

import org.apache.zookeeper.KeeperException;

public class DeleteZnode {

	//public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
	public static void 
	
		ZookeeperConnection zk = new ZookeeperConnection();
		
		String hostname = "192.168.44.128:2181";
		zk.createConnection(hostname);
		
		String path = "/td";
		int version = -1;
		zk.zoo.delete(path, version);
		
		//System.out.println(zk.zoo.exists(path, false));

	}

}
