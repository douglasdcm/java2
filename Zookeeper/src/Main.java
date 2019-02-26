import java.io.IOException;
import java.util.List;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.data.ACL;

public class Main {

	public static void main(String[] args) throws IOException, KeeperException, InterruptedException {
	
		String path = "/td5";
		byte[] data = "We can learn most of the Tech here".getBytes();
		List<ACL> acl = ZooDefs.Ids.OPEN_ACL_UNSAFE;
		CreateMode createMode = CreateMode.PERSISTENT;
		
		
		CreateZnode.createZnode(path, data, acl, createMode);
		
		Thread.sleep(3000);
		
		GetZnodeData.getZnode(path, false, null);
		
		
	}
	
}
