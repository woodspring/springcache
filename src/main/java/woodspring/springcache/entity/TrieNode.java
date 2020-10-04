package woodspring.springcache.entity;

import java.util.concurrent.ConcurrentSkipListMap;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



public class TrieNode {
	private  final static Logger logger = LoggerFactory.getLogger( TrieNode.class);
	
	private ConcurrentSkipListMap<Character, TrieNode> child = new ConcurrentSkipListMap<>();
	private boolean isWord = false;
	private String theString = "";
	
	
	
	public TrieNode(String aString) {
		this.theString = aString;
		if ( aString.contentEquals("#") && aString.length() == 1) isWord = true;
		//this.buildNode( this, aString, 0);
	}


	public boolean insertNode(Character aChar) {
		
		return true;
	}
	
	public boolean buildNode(TrieNode curNode, String aString, int posInd) {
		logger.info("-0- sString:[{}], posInd:{}", aString, posInd);
		int strLen = aString.length();
		if (posInd >= strLen) return false;	
		boolean bRet = true;
		if (curNode == null)  return bRet;
		
		Character keyChar = aString.charAt( posInd);
		logger.info("-1- sString:[{}], posInd:{}, strLen:{}, keyChar:{}", aString, posInd, strLen, keyChar);
		if (child.containsKey(keyChar) ) {
			bRet = child.get( keyChar).buildNode( child.get(keyChar),  aString,  posInd+1);
		} else {
			TrieNode aNode = new TrieNode( aString);
			if ( posInd == (strLen-1)) aNode.setWord( true);
			child.put(keyChar,  aNode);
			bRet = aNode.buildNode( aNode,  aString, posInd+1);
		}	
		logger.info("-2- sString:[{}], posInd:{}", aString, posInd);
		return true;
	}
	

	public String findString(TrieNode curNode, String aString, int posInd) {
		String retStr = null;
		int strLen = aString.length();
		if (!(posInd < strLen)) return retStr;		
		if (curNode == null)  return retStr;
		
		
		Character keyChar = aString.charAt(posInd);
		if ( child.containsKey(keyChar)) {
			TrieNode aNode = child.get(keyChar);
			if ( posInd == ( strLen -1)) 
				retStr = aNode.getTheString();
			else {
				retStr = child.get( keyChar).findString( child.get(keyChar),  aString, posInd++);
			}			
		} 
		return retStr;
		
	}

	public boolean isWord() {
		return isWord;
	}



	public void setWord(boolean isWord) {
		this.isWord = isWord;
	}



	public String getTheString() {
		return theString;
	}



	public void setTheString(String theString) {
		this.theString = theString;
	}
	
	
	public String toString() {
		StringBuffer strBuf = new StringBuffer();
		
		strBuf.append("{ theString:["+ this.theString+"]  isWord:"+ this.isWord);
		this.child.keySet().stream().forEach( key -> strBuf.append(" keyChar: "+ key +" ->["+this.child.get( key).toString() +"]"));
		strBuf.append("}");
		return strBuf.toString();
	}
	
	

}
