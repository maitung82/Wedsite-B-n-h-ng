package IT16308_Assignment.ultils;

import org.mindrot.jbcrypt.BCrypt;

public class EncryptUtil {
	public static String encrypted(String origin) {
		String encrypted = BCrypt.hashpw(origin, BCrypt.gensalt());
		return encrypted;
	}
	
	public static boolean check(String origin , String encrypted) {
		return BCrypt.checkpw(origin, encrypted);
	}
}
