package org.stock.web;

import java.awt.Color;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.springframework.stereotype.Service;

@Service
public class ExportData {
	List<String> headerTables = new ArrayList<String>();
	@PostConstruct
	public void init()
	{

		headerTables.add("Creation Quarter");
		headerTables.add("Region");
		headerTables.add("Country Committee");
		headerTables.add("GRR Spreadsheet Type");
		headerTables.add("Responsible");
		headerTables.add("GRR Spreadsheet status");
		headerTables.add("Counterparty Name");
		headerTables.add("RMPM ID");
		headerTables.add("Business Group");
		headerTables.add("Managing site");
		headerTables.add("Default date");
		headerTables.add("Coverage");
		headerTables.add("VPG TT officer name");
		headerTables.add("Secured or Not");
	}
	public byte[] exportContent(List<ExportDto> data) throws IOException
	{
		
		Workbook wb = new HSSFWorkbook();
		Sheet sheet = wb.createSheet("Sheet");
		this.createHeader(sheet,wb);
		this.createHeaderCells(sheet ,wb);
		this.exportContent( sheet , wb, data);
		this.autoSizeColumns(wb);
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		try {
		    wb.write(bos);
		} finally {
		    bos.close();
		}
		return bos.toByteArray();
	}
	
	public void exportContent(Sheet sheet ,Workbook wb,List<ExportDto> data)
	{
		int row=2;
		for(int content = 0;content<data.size();content++)
		{
				Row rows = sheet.createRow(row++);
			
				this.createContent(sheet ,wb,0, rows,data.get(content));
			
		}
	}
	
	public Row createContent(Sheet sheet ,Workbook wb,int colnum,Row row,ExportDto data)
	{
		
		Cell cellPeriod = row.createCell(0);
		cellPeriod.setCellValue(data.getPeriod()!=null?data.getPeriod().name():null);
	 
		Cell cellRegion = row.createCell(1);
		cellRegion.setCellValue(data.getRegion());
		
		Cell cellCountryComitee = row.createCell(2);
		cellCountryComitee.setCellValue(data.getCountry());
		
		Cell cellCountryType = row.createCell(3);
		cellCountryType.setCellValue(data.getGrrSpreadSheetType()!=null?data.getGrrSpreadSheetType().name():"");
		
		Cell cellResponsible= row.createCell(4);
		cellResponsible.setCellValue(data.getResponsible());
		
		Cell cellStatus = row.createCell(5);
		cellStatus.setCellValue(data.getGrrSpreadSheetStatus()!=null?data.getGrrSpreadSheetStatus().name():"");
		
		Cell cellCounterPartyNameCells= row.createCell(6);
		cellCounterPartyNameCells.setCellValue(data.getCounterPartyName());
		
		Cell cellRmpmId= row.createCell(7);
		cellRmpmId.setCellValue(data.getRMPMID());
		
		Cell cellBusinessGroup= row.createCell(8);
		cellBusinessGroup.setCellValue(data.getBusinessGroup());
		
		Cell cellManagingsite= row.createCell(9);
		cellManagingsite.setCellValue(data.getManagingSite());
		
		Cell cellDefaultDate= row.createCell(10);
		cellDefaultDate.setCellValue(data.getDefaultDate());
		
		
		Cell cellCoverage= row.createCell(11);
		if(CollectionUtils.isNotEmpty(data.getCoverage()))
		cellCoverage.setCellValue(data.getCoverage().stream().collect(Collectors.joining(",")));
		
		Cell cellVpgttOfficer= row.createCell(12);
		cellVpgttOfficer.setCellValue(data.getVpgttOfficier());
		
		Cell cellSecured= row.createCell(13);
		cellSecured.setCellValue(this.yesNo(data.isSecured()));
		
		
		return row;
	}
	
	private String yesNo(boolean isSecured)
	{
		return isSecured?"yes":"no";
	}
	public void createHeaderCells(Sheet sheet ,Workbook wb)
	{
		Row row = sheet.createRow(1);
		for(int col =0;col< this.headerTables.size();col++)
		{
			
			this.createHeaderTable(sheet ,wb,col,this.headerTables.get(col), row);
		}
	}
	
	public Row createHeaderTable(Sheet sheet ,Workbook wb,int colnum,String value,Row row)
	{
		
		Cell cell = row.createCell(colnum);
		cell.setCellValue(value);
	
		Font font = wb.createFont();
		font.setFontHeightInPoints((short)11);
		font.setFontName("Calibri");
		//font.setBold(true);
		font.setColor(IndexedColors.WHITE.index);
		CellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setFillBackgroundColor(IndexedColors.LIGHT_BLUE.index);
		style.setFillPattern(FillPatternType.ALT_BARS);
		style.setAlignment(HorizontalAlignment.CENTER);
		cell.setCellStyle(style);
		
		return row;
	}
	
	
	
	public Row createHeader(Sheet sheet ,Workbook wb )
	{
		Row row = sheet.createRow(0);
		Cell cell = row.createCell(0);
		cell.setCellValue("Wadoop GRR List#CIB");
		sheet.addMergedRegion(new CellRangeAddress(
		        0, //first row (0-based)
		        0, //last row  (0-based)
		        0, //first column (0-based)
		        14  //last column  (0-based)
		));
		Font font = wb.createFont();
		font.setFontHeightInPoints((short)24);
		font.setFontName("Courier New");
		font.setBold(true);		
		CellStyle style = wb.createCellStyle();
		style.setFont(font);
		style.setAlignment(HorizontalAlignment.CENTER);
		cell.setCellStyle(style);
		
		return row;
	}
	
	public void autoSizeColumns(Workbook workbook) {
	    int numberOfSheets = workbook.getNumberOfSheets();
	    for (int i = 0; i < numberOfSheets; i++) {
	        Sheet sheet = workbook.getSheetAt(i);
	        if (sheet.getPhysicalNumberOfRows() > 0) {
	        	 Iterator<Row> rowIterator = sheet.rowIterator();
	        	 while (rowIterator.hasNext()) {
	            Row row = rowIterator.next();
	            Iterator<Cell> cellIterator = row.cellIterator();
	            while (cellIterator.hasNext()) {
	                Cell cell = cellIterator.next();
	                int columnIndex = cell.getColumnIndex();
	                sheet.autoSizeColumn(columnIndex);
	            }
	        	 }
	        }
	    }
	}
}
