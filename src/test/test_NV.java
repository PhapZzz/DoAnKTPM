	package test;
	
	import DTO.NhanVienDTO;
	
	import static org.junit.Assert.assertEquals;
	import static org.junit.Assert.assertNotEquals;
	
	import java.sql.Date;
	import java.text.ParseException;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	
	import org.junit.Test;
	import org.junit.jupiter.api.Assertions;
	
	import BUS.NhanVienBUS;
	
	public class test_NV {
	    NhanVienBUS nvBUS = new NhanVienBUS();
	    String long_name = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
	    
	    // _________________ Test Validation _________________
	    @Test
	    public void testValidateLongFirstName() {
	    	System.out.println("_____ 1. Validate: first name too long _____");
	        try {
	        	int before = nvBUS.getEmployeeNumber();
	        	System.out.println("Before adding employee: " + before);
	            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	            NhanVienDTO nv = new NhanVienDTO("nv6", "haha", long_name, "0909090909", "082208220822", new java.sql.Date(sdf.parse("2025-05-08").getTime()), new java.sql.Date(sdf.parse("2005-01-01").getTime()), true);
	            nvBUS.themNV(nv);
	            int after = nvBUS.getEmployeeNumber();
	            System.out.println("After adding employee: " + after);
	            assertEquals(0, after - before);
	        } catch (ParseException e) {
	            e.printStackTrace();
	        }
	    	System.out.println();
	    }
	
	    @Test
	    public void testValidateLongLastName() {
	    	System.out.println("_____ 2. Validate last name too long _____");
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	        	int before = nvBUS.getEmployeeNumber();
	        	System.out.println("Before adding employee: " + before);
	        	Date ngaysinh = new java.sql.Date(sdf.parse("2005-01-01").getTime());
	        	Date ngayvl = new java.sql.Date(sdf.parse("2025-05-08").getTime());
	        	NhanVienDTO nv = new NhanVienDTO("nv12", long_name, "Nguyen Van A", "0909090909", "082208220822", ngayvl, ngaysinh, true);
	            nvBUS.themNV(nv);
	            int after = nvBUS.getEmployeeNumber();
	            System.out.println("After adding employee: " + after);
	            assertEquals(0, after - before);
	            System.out.println();
	        } catch (ParseException e) {
	        	e.printStackTrace();
	        }
	    }
	    
	    @Test
	    public void testValidateWrongPhoneNumber() {
	    	System.out.println("_____ 3. Validate incorrect format of phone number _____");
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	        	int before = nvBUS.getEmployeeNumber();
	        	System.out.println("Before adding employee: " + before);
	        	Date ngaysinh = new java.sql.Date(sdf.parse("2005-01-01").getTime());
	        	Date ngayvl = new java.sql.Date(sdf.parse("2025-05-08").getTime());
	        	NhanVienDTO nv = new NhanVienDTO("nv12", "Nguyen Van", "A", "1234567890", "082208220822", ngayvl, ngaysinh, true);
	            nvBUS.themNV(nv);
	            int after = nvBUS.getEmployeeNumber();
	            System.out.println("After adding employee: " + after);
	            assertEquals(0, after - before);
	            System.out.println();
	        } catch (ParseException e) {
	        	e.printStackTrace();
	        }
	    }
	    
	    @Test 
	    public void testDuplicatePhoneNumber() {
	    	System.out.println("_____ 4. Check existed phone number _____");
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	        	int before = nvBUS.getEmployeeNumber();
	        	System.out.println("Before adding employee: " + before);
	        	Date ngaysinh = new java.sql.Date(sdf.parse("2005-01-01").getTime());
	        	Date ngayvl = new java.sql.Date(sdf.parse("2025-05-08").getTime());
	        	NhanVienDTO nv = new NhanVienDTO("nv12", "Nguyen Van", "A", "0987654321", "082208220822", ngayvl, ngaysinh, true);
	            nvBUS.themNV(nv);
	            int after = nvBUS.getEmployeeNumber();
	            System.out.println("After adding employee: " + after);
	            assertEquals(0, after - before);
	            System.out.println();
	        } catch (ParseException e) {
	        	e.printStackTrace();
	        }
	    }
	    
	    @Test
	    public void testWrongIDNumber() {
	    	System.out.println("_____ 5. Validate incorrect format of phone number _____");
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	        	int before = nvBUS.getEmployeeNumber();
	        	System.out.println("Before adding employee: " + before);
	        	Date ngaysinh = new java.sql.Date(sdf.parse("2005-01-01").getTime());
	        	Date ngayvl = new java.sql.Date(sdf.parse("2025-05-08").getTime());
	        	NhanVienDTO nv = new NhanVienDTO("nv12", "Nguyen Van", "A", "0902060801", "123456789012", ngayvl, ngaysinh, true);
	            nvBUS.themNV(nv);
	            int after = nvBUS.getEmployeeNumber();
	            System.out.println("After adding employee: " + after);
	            assertEquals(0, after - before);
	            System.out.println();
	        } catch (ParseException e) {
	        	e.printStackTrace();
	        }
	    }
	    
	    @Test
	    public void testDuplicateIDNumber() {
	    	System.out.println("_____ 6. Check duplicate ID number _____");
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	        	int before = nvBUS.getEmployeeNumber();
	        	System.out.println("Before adding employee: " + before);
	        	Date ngaysinh = new java.sql.Date(sdf.parse("2005-01-01").getTime());
	        	Date ngayvl = new java.sql.Date(sdf.parse("2025-05-08").getTime());
	        	NhanVienDTO nv = new NhanVienDTO("nv12", "Nguyen Van", "A", "0902060801", "094204013379", ngayvl, ngaysinh, true);
	            nvBUS.themNV(nv);
	            int after = nvBUS.getEmployeeNumber();
	            System.out.println("After adding employee: " + after);
	            assertEquals(0, after - before);
	            System.out.println();
	        } catch (ParseException e) {
	        	e.printStackTrace();
	        }
	    }
	    
	    @Test
	    public void testBirthDate() {
	    	System.out.println("_____ 7. Validate birth date (Employee's age < 18) _____");
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	        	int before = nvBUS.getEmployeeNumber();
	        	System.out.println("Before adding employee: " + before);
	        	Date ngaysinh = new java.sql.Date(sdf.parse("2015-01-01").getTime());
	        	Date ngayvl = new java.sql.Date(sdf.parse("2025-05-08").getTime());
	        	NhanVienDTO nv = new NhanVienDTO("nv12", "Nguyen Van", "A", "0902060801", "093123572348", ngayvl, ngaysinh, true);
	            nvBUS.themNV(nv);
	            int after = nvBUS.getEmployeeNumber();
	            System.out.println("After adding employee: " + after);
	            assertEquals(0, after - before);
	            System.out.println();
	        } catch (ParseException e) {
	        	e.printStackTrace();
	        }
	    }
	    
	    @Test
	    public void testApplyDate() {
	    	System.out.println("_____ 8. Validate apply date (The date must not go after today) _____");
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	        try {
	        	int before = nvBUS.getEmployeeNumber();
	        	System.out.println("Before adding employee: " + before);
	        	Date ngaysinh = new java.sql.Date(sdf.parse("2005-01-01").getTime());
	        	Date ngayvl = new java.sql.Date(sdf.parse("2025-05-16").getTime());
	        	NhanVienDTO nv = new NhanVienDTO("nv12", "Nguyen Van", "A", "0902060801", "093123572348", ngayvl, ngaysinh, true);
	            nvBUS.themNV(nv);
	            int after = nvBUS.getEmployeeNumber();
	            System.out.println("After adding employee: " + after);
	            assertEquals(0, after - before);
	            System.out.println();
	        } catch (ParseException e) {
	        	e.printStackTrace();
	        }
	    }
	    // _________________ Test Validation _________________
	    
	    // _________________ Test Search Feature _________________
	    
	    @Test
	    public void searchEmployeeFirstName_False() {
	    	System.out.println("_____ 9. Search: name (false) _____");
	        String name = "zzz";
	        ArrayList <NhanVienDTO> list = nvBUS.timKiem(name, "Tên");
	        int list_size = list.size();
	        System.out.println("List size after searching employee: " + list_size);
	        assertEquals(nvBUS.getEmployeeNumber(), list_size);
	        System.out.println();
	    }
	    
	    @Test
	    public void searchEmployeeFirstName_True() {
	    	System.out.println("_____ 10. Search: name (true) _____");
	    	int before = nvBUS.getEmployeeNumber();
	    	System.out.println("Before adding employee: " + before);
	        String name = "Sang";
	        nvBUS.timKiem(name, "Tên");
	        int after = nvBUS.getEmployeeNumber();
	        System.out.println("After adding employee: " + after);
	        assertNotEquals("It should find some names here", 1, after - before);
	        System.out.println();
	    }
	    
	    @Test
	    public void searchEmployeeFullName_True() {
	    	System.out.println("_____ 11. Search: full name (true) _____");
	        String name = "Trinh Cao Sang";
	        ArrayList <NhanVienDTO> list = nvBUS.timKiem(name, "Họ Tên");
	        int list_size = list.size();
	        System.out.println("List size after searching employee: " + list_size);
	        assertEquals(nvBUS.getEmployeeNumber(), list_size);
	        System.out.println();
	    }
	    
	    @Test
	    public void searchEmployeeLastName_False() {
	    	System.out.println("_____ 12. Search: full name (false) _____");
	        String name = "zzzz";
	        ArrayList <NhanVienDTO> list = nvBUS.timKiem(name, "Họ Tên");
	        int list_size = list.size();
	        System.out.println("List size after searching employee: " + list_size);
	        assertEquals(nvBUS.getEmployeeNumber(), list_size);
	        System.out.println();
	    }
	   
	    @Test
	    public void searchEmployeeId_True() {
	    	System.out.println("_____ 13. Search: id (true) _____");
	        String name = "nv2";
	        ArrayList <NhanVienDTO> list = nvBUS.timKiem(name, "Mã số");
	        int list_size = list.size();
	        System.out.println("List size after searching employee: " + list_size);
	        assertEquals(1, list_size);
	        System.out.println();
	    }
	    
	    @Test
	    public void searchEmployeeId_False() {
	    	System.out.println("_____ 14. Search: id (false) _____");
	        String name = "Trinh Cao Sang";
	        ArrayList <NhanVienDTO> list = nvBUS.timKiem(name, "Mã số");
	        int list_size = list.size();
	        System.out.println("List size after searching employee: " + list_size);
	        assertEquals(nvBUS.getEmployeeNumber(), list_size);
	        System.out.println();
	    }
	    
	    @Test
	    public void searchApplyDate_True() {
	    	System.out.println("_____ 15. Search: Ngày làm việc (true) _____");
	        String name = "2024-03-17";
	        ArrayList <NhanVienDTO> list = nvBUS.timKiem(name, "Ngày vào làm");
	        int list_size = list.size();
	        System.out.println("List size after searching employee: " + list_size);
	        assertEquals(5, list_size);
	        System.out.println();
	    }
	    
	    @Test
	    public void searchApplyDate_False() {
	    	System.out.println("_____ 16. Search: Ngày làm việc (false) _____");
	        String name = "2000-03-15";
	        ArrayList <NhanVienDTO> list = nvBUS.timKiem(name, "Ngày vào làm");
	        int list_size = list.size();
	        System.out.println("List size after searching employee: " + list_size);
	        assertEquals(nvBUS.getEmployeeNumber(), list_size);
	        System.out.println();
	    }
	    
	    // _________________ Test Search Feature _________________
	}
	
