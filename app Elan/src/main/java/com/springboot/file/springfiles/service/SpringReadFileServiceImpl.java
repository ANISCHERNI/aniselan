package com.springboot.file.springfiles.service;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.springboot.file.springfiles.model.User;
import com.springboot.file.springfiles.repository.SpringReadFileRepository;

@Service
@Transactional
public class SpringReadFileServiceImpl implements SpringReadFileService {

	@Autowired
	private SpringReadFileRepository springReadFileRepository ;

	@Override
	public List<User> findAll() {
		
		return (List<User>) springReadFileRepository.findAll();
	}

	@Override
	public boolean saveDataFromUploadFile(MultipartFile file) {
	boolean isFlag=false ;
	
	String extention=FilenameUtils.getExtension(file.getOriginalFilename());
	
	if(extention.equalsIgnoreCase("json")) {
		isFlag=readDataFromJson(file);
	}
	else if(extention.equalsIgnoreCase("csv")) {
		
		isFlag=readDataFromCsv(file);
		
	}
	
	
else if(extention.equalsIgnoreCase("xls")||extention.equalsIgnoreCase("xlsx")) {
		
		isFlag=readDataFromExcel(file);
		
	}
	return isFlag;
	}
	
	
	
	private boolean readDataFromExcel(MultipartFile file) {
		Workbook workBook = getWorBook(file);
		Sheet sheet =workBook.getSheetAt(0);
		Iterator<Row> rows = sheet.iterator();
		rows.next();
		while (rows.hasNext()) {
			Row row = rows.next();
			User user = new User() ;
			
			
			if(row.getCell(0).getCellType()==Cell.CELL_TYPE_NUMERIC) {
				String numFacture = NumberToTextConverter.toText(row.getCell(0).getNumericCellValue());
				user.setNumFacture(numFacture);
			}
				else  if(row.getCell(0).getCellType()==Cell.CELL_TYPE_STRING) {
					 user.setNumFacture(row.getCell(0).getStringCellValue());
				}
			
			
			
			if(row.getCell(1).getCellType()==Cell.CELL_TYPE_NUMERIC) {
				String val = NumberToTextConverter.toText(row.getCell(1).getNumericCellValue());
				user.setVal(val);
			}
				else  if(row.getCell(1).getCellType()==Cell.CELL_TYPE_STRING) {
					 user.setVal(row.getCell(1).getStringCellValue());
				}
			
		
				
				
				if(row.getCell(2).getCellType()==Cell.CELL_TYPE_NUMERIC) {
					String codeClient = NumberToTextConverter.toText(row.getCell(2).getNumericCellValue());
					user.setCodeClient(codeClient);
				}
					else  if(row.getCell(2).getCellType()==Cell.CELL_TYPE_STRING) {
					 user.setCodeClient(row.getCell(2).getStringCellValue());
					}
				
				
				
				
				if(row.getCell(3).getCellType()==Cell.CELL_TYPE_NUMERIC) {
					String societe = NumberToTextConverter.toText(row.getCell(3).getNumericCellValue());
					user.setSociete(societe);
				}
					else  if(row.getCell(3).getCellType()==Cell.CELL_TYPE_STRING) {
					 user.setSociete(row.getCell(3).getStringCellValue());
					}
				
				
				if(row.getCell(4).getCellType()==Cell.CELL_TYPE_NUMERIC) {
					String totalHT = NumberToTextConverter.toText(row.getCell(4).getNumericCellValue());
					user.setTotalHT(totalHT);
				}
					else  if(row.getCell(4).getCellType()==Cell.CELL_TYPE_STRING) {
					 user.setTotalHT(row.getCell(4).getStringCellValue());;
					}
				
				if(row.getCell(5).getCellType()==Cell.CELL_TYPE_NUMERIC) {
					String totalTVA = NumberToTextConverter.toText(row.getCell(5).getNumericCellValue());
					user.setTotalTVA(totalTVA);
				}
					else  if(row.getCell(5).getCellType()==Cell.CELL_TYPE_STRING) {
					 user.setTotalTVA(row.getCell(5).getStringCellValue());
					}
				
				
				
				if(row.getCell(6).getCellType()==Cell.CELL_TYPE_NUMERIC) {
					String totalTTC = NumberToTextConverter.toText(row.getCell(6).getNumericCellValue());
					user.setTotalTTC(totalTTC);
				}
					else  if(row.getCell(6).getCellType()==Cell.CELL_TYPE_STRING) {
					 user.setTotalTTC(row.getCell(6).getStringCellValue());
					}
				
				
				
				
				if(row.getCell(7).getCellType()==Cell.CELL_TYPE_NUMERIC) {
					String acompte = NumberToTextConverter.toText(row.getCell(7).getNumericCellValue());
					user.setAcompte(acompte);
				}
					else  if(row.getCell(7).getCellType()==Cell.CELL_TYPE_STRING) {
					 user.setAcompte(row.getCell(7).getStringCellValue());
					}
				
				
				
				if(row.getCell(8).getCellType()==Cell.CELL_TYPE_NUMERIC) {
					String mantantRegle = NumberToTextConverter.toText(row.getCell(8).getNumericCellValue());
					user.setMantantRegle(mantantRegle);
				}
					else  if(row.getCell(8).getCellType()==Cell.CELL_TYPE_STRING) {
					 user.setMantantRegle(row.getCell(8).getStringCellValue());
					}
				
				
				if(row.getCell(9).getCellType()==Cell.CELL_TYPE_NUMERIC) {
					String soldeDu = NumberToTextConverter.toText(row.getCell(9).getNumericCellValue());
					user.setSoldeDu(soldeDu);
				}
					else  if(row.getCell(9).getCellType()==Cell.CELL_TYPE_STRING) {
					 user.setSoldeDu(row.getCell(9).getStringCellValue());
					}
				
				
			


				
				user.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
				springReadFileRepository.save(user);
			
		}
		
		return true;
	}

	
	
	


	private Workbook getWorBook(MultipartFile file) {
			Workbook workbook = null ;
			String extention=FilenameUtils.getExtension(file.getOriginalFilename());
			
			try {
				
				if(extention.equalsIgnoreCase("xlsx")) {
					 workbook= new XSSFWorkbook(file.getInputStream());
				}
				else if(extention.equalsIgnoreCase("xls")) {
					
				 workbook= new HSSFWorkbook(file.getInputStream());
					
				}
				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		return workbook;
	}

	
	
	
	private boolean readDataFromCsv(MultipartFile file) {
		
		try {
			
			InputStreamReader reader  = new  InputStreamReader(file.getInputStream());
			CSVReader csvReader =  new CSVReaderBuilder(reader).withSkipLines(1).build();
			List<String[]> rows= csvReader.readAll();
			for (String[] row :rows) {
				springReadFileRepository.save(new User(null, row[0] ,row[1] , row[2] , row[3], row[4], row[5], row[6], row[7], row[8], row[9] ,FilenameUtils.getExtension(file.getOriginalFilename())));
			}
			return true ;
			
		} catch (Exception e) {
			return false;
		}
		
	}
	
	
	

	private boolean readDataFromJson(MultipartFile file) {
		
		
		
		try {
			InputStream inputStream =file.getInputStream();
			ObjectMapper mapper= new ObjectMapper() ;
			List<User> users =Arrays.asList(mapper.readValue(inputStream, User.class));
			if(users!=null && users.size()>0) {
				for (User user :users) {
					user.setFileType(FilenameUtils.getExtension(file.getOriginalFilename()));
					springReadFileRepository.save(user);
				}
			}
			
			return true ;
			
		} catch (Exception e) {
			
		}
		
		return false;
	}
	
	
	

}
	