package woodspring.springcache;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import woodspring.springcache.entity.TrieNode;

public class TestTrieNode {
	private  final static Logger logger = LoggerFactory.getLogger( TestTrieNode.class);

	
	@Test
	public void testTrieNodeBuildFindAndToString() {
		TrieNode aNode = new TrieNode("#");
		
		String retStr = aNode.toString();
		logger.info("retStr:[{}]", retStr);
		assertNotNull(retStr);
		
		boolean bRet = aNode.buildNode( aNode,  "ABC",  0);
		logger.info("build ABC, build:{}, toString:[{}]", bRet, aNode.toString());
		
		
		
		bRet = aNode.buildNode( aNode,  "MNOPQ",  0);
		logger.info("build MNOPQ, build:{}, toString:[{}]", bRet, aNode.toString());
		bRet = aNode.buildNode( aNode,  "WXYZ",  0);
		logger.info("build WXYZ, build:{}, toString:[{}]", bRet, aNode.toString());
		bRet = aNode.buildNode( aNode,  "BaBa",  0);
		logger.info("build BaBa, build:{}, toString:[{}]", bRet, aNode.toString());
		bRet = aNode.buildNode( aNode,  "ABDEF",  0);
		logger.info("build ABDEF, build:{}, toString:[{}]", bRet, aNode.toString());
	}

}
