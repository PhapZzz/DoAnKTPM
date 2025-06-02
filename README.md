BỘ GIÁO DỤC VÀ ĐÀO TẠO
TRƯỜNG ĐẠI HỌC SÀI GÒN
KHOA CÔNG NGHỆ THÔNG TIN 

BÁO CÁO ĐỒ ÁN KIỂM THỬ PHẦN MỀM
QUẢN LÝ TOUR DU LỊCH
 
 
             	Giảng viên: Nguyễn Lê Thanh Trúc
             	Môn: Kiểm thử phần mềm
             	Nhóm: 9
             	Sinh viên thực hiện:
             	Nguyễn Phát Tín                    	MSSV: 3123410381
             	Dương Tùng Thiện                	MSSV: 3123410350
             	Huỳnh Thanh Phúc Thạnh   	MSSV: 3122560070
		Trần Anh Pháp				MSSV: 3121560065
 
MỤC LỤC
Lời cảm ơn	6
Chương Ⅰ: Tổng Quan	7
1. Đặc tả hệ thống	7
2. Mục tiêu xây dựng hệ thống	8
3. Chức năng của hệ thống	9
4. Business Requirement Document(BRD)	11
5. Technical Requirements Document (TRD)	21
6. Requirement Traceability Matrix	35
Chương II : Kiểm Thử Thủ Công	36
1. Test Scenarios	36
2. Test Case	56
3. Defect Report	136
Chương Ⅲ: Kiểm thử hộp đen	146
1. Kĩ thuật phân chia lớp tương đương - Phân tích giá trị biên	146
1.1 Chức năng kiểm thử: Thêm khuyến mãi	146
1.2 Chức năng kiểm thử: Sửa khuyến mãi	161
2. Kĩ thuật phân tích miền	173
2.1 Chức năng kiểm thử: Thêm kế hoạch tour và chọn ngày đi/ngày về.	173
3. Kỹ thuật bảng quyết định -  Đồ thị nhân quả	176
3.1 Đồ thị nhân quả:	176
3.2. Bảng quyết định:	178
3.3. Testcase:	179
4. Kỹ thuật kiểm thử cặp đôi	183
4.1 Chức năng kiểm thử: Lọc tour	183
4.2. Chức năng kiểm thử: Đặt vé	196
5. Kỹ thuật sơ đồ chuyển trạng thái	209
5.1 Chức năng kiểm thử: Sửa khách hàng	209
5.2 Chức năng kiểm thử: Xóa khách hàng	212
6. Kỹ thuật Use case	214
6.1 Chức năng kiểm thử: Tìm kiếm tour	214
6.2 Chức năng kiểm thử: Sửa tour	218
6.3 Chức năng kiểm thử: Thêm tour	222
6.4. Chức năng kiểm thử: Xóa tour	226
Chương Ⅳ: Kiểm thử hộp trắng	231
Kiểm thử dòng trạng thái + mức độ bao phủ + dòng dữ liệu	231
1 Sự kiện comboBox trong ThongKe	231
1.1: Mô tả chức năng	231
1.2. Code:	232
1.3. Đồ thị dòng điều khiển:	232
1.4. Độ phức tạp: M = E - N + 2P = 11 - 11 + 2 * 1 = 2.	233
1.5. Đường độc lập:	233
1.6. Mức độ bao phủ	234
1.7. Đồ thị dòng dữ liệu:	235
1.7.1. Tổng quát:	235
1.7.2. Biến lblNewLabel_3:	236
1.7.3. Biến employeeScrollPane:	237
1.7.4. Biến scrollPane:	238
1.7.5. Biến comboBox:	240
1.7.6. Biến ActionListener:	241
1.7.7. Biến e:	243
1.7.8. Biến selectedOption:	244
2. Sự kiện year_cbo trong ThongKe:	245
2.1. Mô tả chức năng:	245
2.2. Code:	245
2.3. Đồ thị dòng điều khiển:	246
2.4. Độ phức tạp:	246
2.5. Đường độc lập:	246
2.6. Độ bao phủ:	247
2.7. Đồ thị dòng dữ liệu:	248
2.7.1. Tổng quát:	248
2.7.2. Biến year_cbo:	250
2.7.3. Biến ItemListener:	251
2.7.4. Biến e:	253
2.8. Sửa code xử lý bất thường:	254
2.8.1. Tổng quát:	255
2.8.2. Biến year_cbo:	256
2.8.3. Biến ItemListener:	257
2.8.4. Biến e:	258
3. Chức năng lấy tổng chi của khách hàng ở ThongKeDAO	259
3.1 Mô tả chức năng:	259
3.2. Code cũ:	259
3.3. Code mới	262
3.4. Đồ thị dòng điều khiển	264
3.5. Độ phức tạp:	265
3.6. Đường độc lập:	265
3.7. Độ Bao phủ:	265
3.8. Đồ thị dòng điều khiển	266
3.8.1. Tổng quát:	266
3.8.2. Biến Total:	267
3.8.3. Biến Con	268
3.8.4. Biến e	269
3.8.5. Biến st	270
3.8.6. Biến sql	271
3.8.7. Biến rs:	272
3.8.8: Biến year	274
3.9. Sửa lại code	275
3.9.1. Tổng quát	278
3.9.2. Biến con	280
3.9.2. Biến year	281
3.9.4. Biến e	282
3.9.5. Biến st	283
3.9.6. Biến sql	285
3.9.7. Biến rs	286
Chương Ⅴ: Kiểm thử tự động	287
CHương Ⅵ: Kết luận	287
Tổng kết	287
1. Tổng kết lỗi	287
2. Defect Report	287
3. Tổng kết số test case trong quá trình kiểm thử	303
4. Kết quả đạt được và hướng phát triển trong tương lai	304
4.1 kết quả đạt được:	304
4.2 Hướng phát triển trong tương lai	304
 
