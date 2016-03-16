package info.joseluismartin.socket;

import java.net.InetAddress;
import java.net.Socket;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class Connect {
	private static Log log = LogFactory.getLog(Connect.class);
	public static void main(String[] args) {
		InetAddress ia;
		try {
			ia = InetAddress.getByName("localhost");
			System.out.println(ia);
			Socket socket = new java.net.Socket(ia,25);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
