package BUS;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;


public class KiemTra {
	public static KiemTra getInstance() {
		return new KiemTra();
	}

	public String GioiTinh(Boolean gt) {
		if (gt) return "Nam";
		return "Nữ";
		
	}
	public boolean GioiTinh(String gt) {
		if(gt.equalsIgnoreCase("nam")) return true;
		return false;
	}
	public Boolean forMatchDate(String dateString) {
		 String regex = "\\d{4}-\\d{2}-\\d{2}";
		 return Pattern.matches(regex, dateString);
	}
	public Date toDate(String st) {
		SimpleDateFormat dateFormatch = new SimpleDateFormat("yyyy-MM-dd");
		java.sql.Date sqldate = null;
		try {
			java.util.Date utilDate = dateFormatch.parse(st);
			sqldate = new java.sql.Date(utilDate.getTime());
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			return null;
		}
		return sqldate;
	}
	public Boolean checkngaydi(java.util.Date st1) {
		java.util.Date current = new java.util.Date();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 00);
		calendar.set(Calendar.MINUTE, 00);
		calendar.set(Calendar.SECOND, 00);
		calendar.set(Calendar.MILLISECOND, 00);
        current = calendar.getTime();
		if(st1.compareTo(current) < 0) { 
			return false;
		}
		return true;
	}
	
	public java.util.Date toDateUtil(java.sql.Date sqlDate) {
        // Ép kiểu từ java.sql.Date sang java.util.Date
        java.util.Date utilDate = new java.util.Date(sqlDate.getTime());
        return utilDate;
	}
	
	public String formatchString(String str) {
//		\\s đại diện cho bất kỳ ký tự khoảng trắng nào và + biểu thị cho một hoặc nhiều lần lặp lại. 
		try {
			str = str.replaceAll("\\s+", " ").trim();
			
		} catch (Exception e) {
			e.printStackTrace();
			// TODO: handle exception
			return null;
		}
		return str;
	}
	
	public Boolean checkTinhTrang(java.util.Date st1) {
		java.util.Date current = new java.util.Date();
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.HOUR_OF_DAY, 23);
        calendar.set(Calendar.MINUTE, 59);
        calendar.set(Calendar.SECOND, 59);
        current = calendar.getTime();
		if(st1.compareTo(current) < 0 || st1.compareTo(current) == 0) return false;
		return true;
	}
	
	public Boolean checkTinhTrang(java.util.Date st1, java.util.Date st2) {
		if(st1.compareTo(st2) > 0 || st1.compareTo(st2) == 0) return false;
		return true;
	}
	
	public String tinhTrang(Boolean st) {
		if(st) return "Còn hiệu lực";
		return  "Hết hiệu lực";
	}
	
	public Boolean tinhTrang(String st) {
		if(st.equalsIgnoreCase("Còn hiệu lực")) return true;
		return  false;
	}
	public String loaiDV(String madv) {
		String kitu = madv.substring(0, 2);
		if(kitu.equalsIgnoreCase("NH")) return "Nhà hàng";
		if(kitu.equalsIgnoreCase("KS")) return "Khách sạn";
		if(kitu.equalsIgnoreCase("PT")) return "Phương tiện";
		return null;
	}
	
	public String maDV(String loai) {
		if(loai.equalsIgnoreCase("Nhà Hàng")) return "NH";
		if(loai.equalsIgnoreCase("Khách Sạn")) return "KH";
		if(loai.equalsIgnoreCase("Phương tiện")) return "PT";
		return null;
	}
	
	
	public boolean validate_OnlyString(String test	) {
		String regex = "^[\\p{L}\\s]+$";
		 return Pattern.matches(regex, test);
	}
	
	public boolean validate_OnlyNumber(String test	) {
		String regex = "^[0-9]+$";
		 return Pattern.matches(regex, test);
	}
	
	public boolean validate_PhoneNumber(String test) {
		String regex = "^0[0-9]{9}$";
		 return Pattern.matches(regex, test);
	}
	
	public boolean validate_CCCD(String test) {
		String regex = "^[0-9]{12}$";
		 return Pattern.matches(regex, test);
	}
	
	public boolean validate_Email(String test) {
		String regex = "^[^@]+@[^@]+\\.[A-Za-z]{2,}$";
		 return Pattern.matches(regex, test);
	}
}
