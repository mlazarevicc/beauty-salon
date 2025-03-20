package utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AppSettings {
	private String klijentFilename, menadzerFilename, kozmeticarFilename, recepcionerFilename, tipTretmanaFilename, tretmanFilename, 
				   kozmetickiSalonFilename, zakazanTretmanFilename;
	
	public AppSettings(String klijentFilename, String menadzerFilename, String kozmeticarFilename, String recepcionerFilename,
			String tipTretmanaFilename, String tretmanFilename, String kozmetickiSalonFilename, String zakazanTretmanFilename) {
		super();
		this.klijentFilename = klijentFilename;
		this.menadzerFilename = menadzerFilename;
		this.kozmeticarFilename = kozmeticarFilename;
		this.recepcionerFilename = recepcionerFilename;
		this.tipTretmanaFilename = tipTretmanaFilename;
		this.tretmanFilename = tretmanFilename;
		this.kozmetickiSalonFilename = kozmetickiSalonFilename;
		this.zakazanTretmanFilename = zakazanTretmanFilename;
	}

	public String getKlijentFilename() {
		return klijentFilename;
	}
	public String getMenadzerFilename() {
		return menadzerFilename;
	}
	public String getTipTretmanaFilename() {
		return tipTretmanaFilename;
	}
	public String getRecepcionerFilename() {
		return recepcionerFilename;
	}
	public String getTretmanFilename() {
		return tretmanFilename;
	}
	public String getKozmeticarFilename() {
		return kozmeticarFilename;
	}
	public String getKozmetickiSalonFilename() {
		return kozmetickiSalonFilename;
	}
	public String getZakazanTretmanFilename() {
		return zakazanTretmanFilename;
	}
	
	public static LocalDateTime parseDate(String s) {
		if(!s.equals("null")) {
			return LocalDateTime.parse(s,DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
		}
		return null;
	}
	
	public static String formatDate(LocalDateTime datum, String format) {
		if(datum != null) {
			return datum.format(DateTimeFormatter.ofPattern(format));
		}
		return null;
		
	}
	
}