package datasources;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import models.Person;

/**
 * This class implements a simple CSV data-provider, which is of IDataSource 
 * interface type. This data-provider extracts persons dataset from following 
 * resource >> CSV flat-file.
 * @author Nash
 */
public class CsvDataProvider implements IDataSource {
	
	private String filePath = null;
	private BufferedReader buffReader = null;
	private String rowItem = "";
	private String columnSeparator = ",";
	private String[] personItem = null;
	private final ArrayList<String[]> personsRawData = new ArrayList<>();
	protected final ArrayList<Person> dataCollection = new ArrayList<>();

	/**
	 * This constructors a csv data provider with a specified csv file
	 * @param filePath location of the csv file
	 */
	public CsvDataProvider(String filePath) {
		this.filePath = filePath;
	}
	
	/* -----------------
	 * INTERFACE METHODS
	 * -----------------
	 */
	/**
	 * This method implements the extraction mechanics for obtaining persons 
	 * dataset from CSV flat-file (i.e. the resource).
	 * @return persons collection 
	 */
	@Override
	public ArrayList<Person> getPersons() {
		extractRawDataFromCsvFile();
		populateDataCollection(true);
		return dataCollection;
	}
	
	/* -------------
	 * LOCAL METHODS
	 * -------------
	 */
	private void extractRawDataFromCsvFile() {
		openFileReader();
		personsRawData.clear();
		while ((rowItem = readNextLine()) != null) {
			personsRawData.add(rowItem.split(columnSeparator));
		}
		closeFileReader();
	}
	
	private String readNextLine() {
		String line = null;
		try {
			line = buffReader.readLine();
		} catch(IOException e) {
			e.printStackTrace();
		}
		return line;
	}
	
	private void closeFileReader() {
		if (buffReader != null) {
			try {
				buffReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void openFileReader() {
		try {
			buffReader = new BufferedReader(new FileReader(filePath));
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}		
	}
	
	protected void populateDataCollection(boolean headerPresent) {
		dataCollection.clear();
		for(int i=getStartingIndexOfRawData(headerPresent); i<personsRawData.size(); i++) {
			personItem = personsRawData.get(i);
			dataCollection.add(new Person(Integer.parseInt(personItem[0]), 
										  personItem[1], 
										  personItem[2], 
										  Integer.parseInt(personItem[3]), 
										  personItem[4], 
										  personItem[5]));
		}
	}
	
	private int getStartingIndexOfRawData(boolean headerPresent) {
		int rawDataBeginsAtIndex = 0;
		if(headerPresent) {
			rawDataBeginsAtIndex++;
		}
		return rawDataBeginsAtIndex;
	}
}
