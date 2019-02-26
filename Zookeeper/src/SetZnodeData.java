import java.io.IOException;

import org.apache.zookeeper.KeeperException;

public class SetZnodeData {

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
		
		ZookeeperConnection zk = new ZookeeperConnection();
		
		String hostname = "192.168.44.128:2181";
		
		zk.createConnection(hostname);
		
		String path = "/tutorialdrive";
		byte[] data = new String("this is just a test2").getBytes();
		int version = -1;
		
		zk.zoo.setData(path, data, version);
		
		byte[] dataBytes = zk.zoo.getData(path, false, null);
		
		String str = new String(dataBytes, "UTF-8"); //decode the dataByto to UTF-8	
		
		System.out.println(str);

	}

}
