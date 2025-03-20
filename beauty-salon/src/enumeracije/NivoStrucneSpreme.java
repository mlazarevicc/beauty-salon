package enumeracije;

public enum NivoStrucneSpreme {
	BEZ_KVALIFIKACIJE, OPSTA, STRUCNA, AKADEMSKA, STRUKOVNA;
	
	public static NivoStrucneSpreme valueOfString(String s) {
    	try {
        	return NivoStrucneSpreme.valueOf(s);
        }
        catch(Exception e) {
        	return null; 
        } 
	}
};