package com.bridgelabz.service;
import com.bridgelabz.exception.StatesCensusAnalyserException;
import com.bridgelabz.model.CSVStatesCensus;
import com.bridgelabz.model.CSVStatesPojoClass;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.stream.StreamSupport;

public class StatesCensusAnalyser {

    OpenCSV openCSV = new OpenCSV();

    public Integer readFile(String filePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(Paths.get(filePath))
        ) {
            Iterator<CSVStatesCensus> stateCSVIterator = OpenCSV.CSVfileIterator(reader, CSVStatesCensus.class);
            Iterable<CSVStatesCensus> csvIterable = () -> stateCSVIterator;
            int numOfRecords = (int) StreamSupport.stream(csvIterable.spliterator(), false).count();
            return numOfRecords;

        } catch (NoSuchFileException e) {
            throw new StatesCensusAnalyserException("Enter a right file name and type", StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new StatesCensusAnalyserException("Check delimiter and header", StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT);
        }
    }
    // Read state code csv file
    public Integer loadIndianStateCodeData(String csvFilePath) throws Exception {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            Iterator<CSVStatesPojoClass> statesCSVIterator = OpenCSV.CSVfileIterator(reader, CSVStatesPojoClass.class);
            Iterable<CSVStatesPojoClass> iterableStateCode = () -> statesCSVIterator;
            int countRecord = (int) StreamSupport.stream(iterableStateCode.spliterator(), false).count();
            return countRecord;
        }catch (NoSuchFileException e) {
            throw new StatesCensusAnalyserException("Enter a right file name and type", StatesCensusAnalyserException.ExceptionType.FILE_NOT_FOUND);
        } catch (RuntimeException e) {
            throw new StatesCensusAnalyserException("Check delimiter and header", StatesCensusAnalyserException.ExceptionType.DELIMITER_AND_HEADER_INCORRECT);
        }
    }

}
