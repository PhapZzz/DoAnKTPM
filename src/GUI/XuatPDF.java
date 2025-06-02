package GUI;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.ArrayList;

import com.itextpdf.kernel.colors.DeviceRgb;
//import com.itextpdf.kernel.counter.SystemOutEventCounterFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
//import com.itextpdf.layout.property.TextAlignment;

import DTO.HoaDonDTO;
import DTO.VeDTO;

public class XuatPDF {
	
	public XuatPDF(HoaDonDTO hd,ArrayList<VeDTO> veList) {
		String path="src/PdfFiles/"+hd.getMahd()+".pdf";
		System.out.println(path);
		try {
			
			PdfWriter pdfWriter=new PdfWriter(path);
			PdfDocument pdfDocument=new PdfDocument(pdfWriter);
			pdfDocument.addNewPage();
			pdfDocument.setDefaultPageSize(PageSize.A4);
			Document document=new Document(pdfDocument);
			float threecol=490f;
			float twocol=285f;
			float twocol150=twocol+150f;
			float twocolumnWidth[]= {twocol150,twocol};
			float fullwidth[]= {threecol};
			float threeColumnWidth[]= {threecol,threecol,threecol};
			float fourColumnWidth[]= {threecol,threecol,threecol,threecol};
			Paragraph onesp=new Paragraph("\n");
			Table table=new Table(twocolumnWidth);
			table.addCell(new Cell().add(new Paragraph("Invoice")).setFontSize(20f).setBorder(Border.NO_BORDER).setBold());
			Border gb=new SolidBorder(1f/2f);
			Table divider=new Table(fullwidth);
			divider.setBorder(gb);
			document.add(table);
			document.add(onesp);
			document.add(divider);
			document.add(onesp);
			
			Table twoColTable=new Table(twocolumnWidth);
			twoColTable.addCell(getBillingandShippingCell("Thông tin hóa đơn"));
			document.add(twoColTable.setMarginBottom(12f));
			
			Table twoColTable2=new Table(twocolumnWidth);
			twoColTable2.addCell(getCell10fLeft("Mã HD:", false));
			twoColTable2.addCell(getCell10fLeft(hd.getMahd(), true));
			twoColTable2.addCell(getCell10fLeft("Mã Nhân viên:", false));
			twoColTable2.addCell(getCell10fLeft(hd.getManv(), false));
			twoColTable2.addCell(getCell10fLeft("Mã Khách hàng:", false));
			twoColTable2.addCell(getCell10fLeft(hd.getMakh(), false));
			twoColTable2.addCell(getCell10fLeft("Invoice Date:", true));
			twoColTable2.addCell(getCell10fLeft(hd.getNgaytao().toString(), true));
			
			document.add(twoColTable2);
			
			
			
			Table tableDivider2=new Table(fullwidth);
			Border dgb=new DashedBorder(0.5f);
			document.add(tableDivider2.setBorder(dgb));
			
			Paragraph productPara=new Paragraph("Thông tin vé");
			document.add(productPara.setBold());
			Table fourColtable1=new Table(fourColumnWidth);
			fourColtable1.setBackgroundColor(new DeviceRgb(0, 0, 0), 0.7f);
			fourColtable1.addCell(new Cell().add(new Paragraph("Mã Vé")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setBorder(Border.NO_BORDER));
			fourColtable1.addCell(new Cell().add(new Paragraph("Mã KHT")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
			fourColtable1.addCell(new Cell().add(new Paragraph("Mã KM")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
			fourColtable1.addCell(new Cell().add(new Paragraph("Giá vé")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
			document.add(fourColtable1);
			

			
	        Table fourColtable2=new Table(fourColumnWidth);
//	        float totalSum=0;
	        DecimalFormat decimalFormat = new DecimalFormat("#,##0");
	        for (VeDTO ve:veList)
	        {
	        	String formattedNumber = decimalFormat.format(ve.getGiave()) + " VND";
	            fourColtable2.addCell(new Cell().add(new Paragraph(ve.getMave())).setBorder(Border.NO_BORDER)).setMarginLeft(10f);
	            fourColtable2.addCell(new Cell().add(new Paragraph(String.valueOf(ve.getMakht()))).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
	            fourColtable2.addCell(new Cell().add(new Paragraph(String.valueOf(ve.getMakm()))).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
	            fourColtable2.addCell(new Cell().add(new Paragraph(String.valueOf(formattedNumber))).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
	        }
	        document.add(fourColtable2.setMarginBottom(20f));
	        
	        String formattedNumber = decimalFormat.format(hd.getTongtien()) + " VND";
	        String formattedNumber2 = decimalFormat.format(hd.getTongcong_truocgg()) + " VND";
	        
	        Table fourColTable3=new Table(fourColumnWidth);
	        fourColTable3.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER)).setMarginLeft(0f);
	        fourColTable3.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER)).setMarginLeft(0f);
	        fourColTable3.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER)).setMarginLeft(0f);
	        fourColTable3.addCell(new Cell().add(new Paragraph("Total: "+String.valueOf(formattedNumber2))).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
	        fourColTable3.addCell(new Cell().add(new Paragraph("Thành tiền: "+String.valueOf(formattedNumber))).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
	        
	        document.add(fourColTable3);
	        document.add(new Paragraph("\n"));
	        document.add(divider.setBorder(new SolidBorder(1)).setMarginBottom(35f));
			document.close();
//			System.out.println("OK");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	static Cell getHeaderTextCell(String textValue) {
		return new Cell().add(new Paragraph(textValue)).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.RIGHT);
	}
	
	static Cell getHeaderTextCellValue(String textValue) {
		return new Cell().add(new Paragraph(textValue)).setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
	}
	
	static Cell getBillingandShippingCell(String textValue) {
		return new Cell().add(new Paragraph(textValue)).setFontSize(12f).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
	}
	
	static Cell getCell10fLeft(String textValue,Boolean isBold) {
		Cell myCell=new Cell().add(new Paragraph(textValue)).setFontSize(10f).setBold().setBorder(Border.NO_BORDER).setTextAlignment(TextAlignment.LEFT);
		return isBold?myCell.setBold():myCell;
	}
	
	
	
	
}
