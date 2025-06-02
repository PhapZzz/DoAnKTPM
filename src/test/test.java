package test;

import java.awt.Color;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.properties.TextAlignment;
//import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.kernel.colors.DeviceRgb;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.borders.Border;
import com.itextpdf.layout.borders.DashedBorder;
import com.itextpdf.layout.borders.SolidBorder;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.IBlockElement;
import com.itextpdf.layout.element.Paragraph;
//import com.itextpdf.layout.properties.TextAlignment;
import DAO.QlyToursDAO;
import GUI.QuanLyTour;
import Util.JDBCUtil;

public class test {

	public static void main(String[] args) {
		String path="src/PdfFiles/invoice.pdf";
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
//			Table nestedtable=new Table(new float[] {twocol/2,twocol/2});
//			nestedtable.addCell(getHeaderTextCell("Invoice No."));
//			nestedtable.addCell(getHeaderTextCellValue("MaHD"));
//			nestedtable.addCell(getHeaderTextCell("Invoice Date"));
//			nestedtable.addCell(getHeaderTextCellValue("Ngày tạo"));	
//			table.addCell(new Cell().add(nestedtable).setBorder(Border.NO_BORDER));
			Border gb=new SolidBorder(1f/2f);
			Table divider=new Table(fullwidth);
			divider.setBorder(gb);
			document.add(table);
			document.add(onesp);
			document.add(divider);
			document.add(onesp);
			
			Table twoColTable=new Table(twocolumnWidth);
			twoColTable.addCell(getBillingandShippingCell("Billing Information"));
//			twoColTable.addCell(getBillingandShippingCell("Shipping Information"));
			document.add(twoColTable.setMarginBottom(12f));
			
			Table twoColTable2=new Table(twocolumnWidth);
			twoColTable2.addCell(getCell10fLeft("Mã HD:", false));
			twoColTable2.addCell(getCell10fLeft("HD01", true));
			twoColTable2.addCell(getCell10fLeft("Mã Nhân viên:", false));
			twoColTable2.addCell(getCell10fLeft("NV01", false));
			twoColTable2.addCell(getCell10fLeft("Mã Khách hàng:", false));
			twoColTable2.addCell(getCell10fLeft("KH01", false));
			twoColTable2.addCell(getCell10fLeft("Invoice Date:", true));
			twoColTable2.addCell(getCell10fLeft("27/04/2024", true));
			
			document.add(twoColTable2);
			
//			Table twoColTable3=new Table(twocolumnWidth);
//			twoColTable3.addCell(getCell10fLeft("Name", true));
//			twoColTable3.addCell(getCell10fLeft("Address", true));
//			twoColTable3.addCell(getCell10fLeft("Arlyn Puttergill", false));
//			twoColTable3.addCell(getCell10fLeft("8570 Gulseth Terra, 3224 Eastwood\nSpringfi, Ma, 01114", false));
//			document.add(twoColTable3);
			
//			float oneColoumnwidth[]= {twocol150};
			
//			Table oneColTable1=new Table(oneColoumnwidth);
//			oneColTable1.addCell(getCell10fLeft("Address", true));
//			oneColTable1.addCell(getCell10fLeft("8570 Gulseth Terra, 3224 Eastwood\\nSpringfi, Ma, 01114", false));
//			oneColTable1.addCell(getCell10fLeft("Email", true));
//			oneColTable1.addCell(getCell10fLeft("qaz@gmail.com", false));
//			document.add(oneColTable1.setMarginBottom(10f));
			
			
			Table tableDivider2=new Table(fullwidth);
			Border dgb=new DashedBorder(0.5f);
			document.add(tableDivider2.setBorder(dgb));
			
			Paragraph productPara=new Paragraph("Thông tin vé");
			document.add(productPara.setBold());
			Table fourColtable1=new Table(fourColumnWidth);
			fourColtable1.setBackgroundColor(new DeviceRgb(0, 0, 0), 0.7f);
			fourColtable1.addCell(new Cell().add(new Paragraph("Mã Vé")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setBorder(Border.NO_BORDER));
			fourColtable1.addCell(new Cell().add(new Paragraph("Mã KHT")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
			fourColtable1.addCell(new Cell().add(new Paragraph("Mã KM")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER).setMarginRight(0f));
			fourColtable1.addCell(new Cell().add(new Paragraph("Giá vé")).setBold().setFontColor(new DeviceRgb(255, 255, 255)).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER).setMarginRight(0f));
			document.add(fourColtable1);
			
			List<Product> productList=new ArrayList<>();
	        productList.add(new Product("apple",2,15933));
	        productList.add(new Product("mango",4,20533));
	        productList.add(new Product("banana",2,9033));
	        productList.add(new Product("grapes",3,1033));
	        productList.add(new Product("apple",5,15933));
	        productList.add(new Product("kiwi",2,9033));
			
	        Table fourColtable2=new Table(fourColumnWidth);
	        float totalSum=0;
	        for (Product product:productList)
	        {
	            float total=product.getQuantity()*product.getPriceperpeice();
	            totalSum+=total;
	            fourColtable2.addCell(new Cell().add(new Paragraph(product.getPname())).setBorder(Border.NO_BORDER)).setMarginLeft(10f);
	            fourColtable2.addCell(new Cell().add(new Paragraph(String.valueOf(product.getQuantity()))).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
	            fourColtable2.addCell(new Cell().add(new Paragraph(String.valueOf(total))).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
	            fourColtable2.addCell(new Cell().add(new Paragraph(String.valueOf(total))).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
	        }
	        document.add(fourColtable2.setMarginBottom(20f));
	        
//	        float onetwo[]={threecol+125f,threecol*2};
//	        Table threeColTable4=new Table(onetwo);
//	        threeColTable4.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER));
//	        threeColTable4.addCell(tableDivider2.setBorder(Border.NO_BORDER));
//	        document.add(threeColTable4);
	        
	        
//	        document.add(tableDivider2);
	        Table fourColTable3=new Table(fourColumnWidth);
	        fourColTable3.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER)).setMarginLeft(0f);
	        fourColTable3.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER)).setMarginLeft(0f);
	        fourColTable3.addCell(new Cell().add(new Paragraph("")).setBorder(Border.NO_BORDER)).setMarginLeft(0f);
//	        fourColTable3.addCell(new Cell().add(new Paragraph("Total")).setTextAlignment(TextAlignment.CENTER).setBorder(Border.NO_BORDER));
	        fourColTable3.addCell(new Cell().add(new Paragraph("Total: "+String.valueOf(totalSum))).setTextAlignment(TextAlignment.RIGHT).setBorder(Border.NO_BORDER));
	        document.add(fourColTable3);
//	        document.add(tableDivider2);
	        document.add(new Paragraph("\n"));
	        document.add(divider.setBorder(new SolidBorder(1)).setMarginBottom(35f));
			document.close();
			System.out.println("OK");
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

class Product{
	private String pname;
	private int quantity;
	private float priceperpeice;
	
	public Product() {

	}

	public Product(String pname, int quantity, float priceperpeice) {
		this.pname = pname;
		this.quantity = quantity;
		this.priceperpeice = priceperpeice;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getPriceperpeice() {
		return priceperpeice;
	}

	public void setPriceperpeice(float priceperpeice) {
		this.priceperpeice = priceperpeice;
	}
	
}

