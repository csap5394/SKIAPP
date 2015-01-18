package model;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JFileChooser;









import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Excel {
	
	public static final double PERCENTAGE_PRIORITY_PLACES = 0.2;
	
	private static Workbook workbook;
	/**
	 * 
	 * @param args
	 *  list daten aus datei aus und sp
	 */
	public static List<Lift> importLiftData(){
		JFileChooser fileChooser = new JFileChooser();
		int returnValue = fileChooser.showOpenDialog(null);
		if(returnValue == JFileChooser.APPROVE_OPTION){
			try {
				Workbook workbook = new HSSFWorkbook(new FileInputStream(fileChooser.getSelectedFile()));//HSSF XSSF
				Sheet sheet = workbook.getSheetAt(0);
				List<Lift> lifts = new ArrayList<Lift>();
				for(Row row: sheet){
					if(row.getRowNum() >= 3){
						Lift lift = new Lift();
						for(Cell cell: row){
							switch(cell.getColumnIndex()){
							case 0:
								if(cell.getStringCellValue() != null ){
									lift.setName(cell.getStringCellValue());
								}
								break;
							case 1:
								switch(cell.getCellType()) {
								case Cell.CELL_TYPE_STRING:
									if(!cell.getStringCellValue().equals("")) {
										lift.setID(Integer.parseInt(cell.getStringCellValue()));
									}
									break;
								case Cell.CELL_TYPE_NUMERIC:
									lift.setID((int)cell.getNumericCellValue());
									break;
								default:
									break;
								}
								break;
							case 2:
								switch(cell.getCellType()) {
								case Cell.CELL_TYPE_STRING:
									if(!cell.getStringCellValue().equals("")) {
										lift.setPLZ(Integer.parseInt(cell.getStringCellValue()));
									}
									break;
								case Cell.CELL_TYPE_NUMERIC:
									lift.setPLZ((int)cell.getNumericCellValue());
									break;
								default:
									break;
								}
								break;
							case 10:
								lift.setTyp(cell.getStringCellValue());
								break;
							case 14:
								switch(cell.getCellType()) {
									case Cell.CELL_TYPE_NUMERIC:
										lift.setNumberPlaces((int)cell.getNumericCellValue());
										break;
									default:
										break;
								}
							default:
								break;
								}
							
						}
						//System.out.println();
						int numPriorityPlaces = (int)(lift.getNumberPlaces() * PERCENTAGE_PRIORITY_PLACES);
						if(numPriorityPlaces < 1) {
							numPriorityPlaces = 1;
						}
						lift.setNonPriorityPlaces(lift.getNumberPlaces() - numPriorityPlaces);
						lift.setMaxPriorityPlaces(numPriorityPlaces);
						lifts.add(lift);
					}
						
					
				}
				return lifts;
				
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return new ArrayList<Lift>();
	}

}
