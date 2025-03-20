package enumeracije;

public enum StanjeTretmana {
	ZAKAZAN, IZVRSEN, OTKAZAO_KLIJENT, OTKAZAO_SALON, NIJE_SE_POJAVIO;
	
	public static StanjeTretmana valueOfString(String s) {
    	try {
        	return StanjeTretmana.valueOf(s);
        }
        catch(Exception e) {
        	return null;
        }
	} 
}