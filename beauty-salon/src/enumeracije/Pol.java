package enumeracije;

// M - musko, Z - zensko, N - nije unet pol
public enum Pol {
    M, Z, N;
	
	public static Pol valueOfString(String s) {
    	try {
        	return Pol.valueOf(s);
        }
        catch(Exception e) {
        	return null; 
        } 
	}
       
}