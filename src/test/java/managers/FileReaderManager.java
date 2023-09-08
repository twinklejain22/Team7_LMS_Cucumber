package managers;

import readers.ConfigReader;
import readers.ExcelReader;

public class FileReaderManager {

	private static FileReaderManager fileReaderManager = new FileReaderManager();
	private static ConfigReader configReader;
	private static ExcelReader excelReader;

	private FileReaderManager() {
	}

	 public static FileReaderManager getInstance( ) {
	      return fileReaderManager;
	 }

	 public ConfigReader getConfigReader() {
		 return (configReader == null) ? new ConfigReader() : configReader;
	 }
	 
	 public ExcelReader getExcelReader() {
		 return (excelReader == null) ? new ExcelReader() : excelReader;
	 }
}