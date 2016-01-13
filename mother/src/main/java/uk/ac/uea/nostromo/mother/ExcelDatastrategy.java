package uk.ac.uea.nostromo.mother;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.Log;

//import org.apache.poi.hssf.usermodel.HSSFWorkbook;
//import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
//import org.apache.poi.openxml4j.opc.OPCPackage;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.CreationHelper;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.apache.poi.util.IOUtils;
//import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * !_TODO__ [Barry Wright] : Write this piece of documentation.
 *
 * @author	Barry Wright {@literal <barry.wright@uea.ac.uk>}
 * @version	v1.0.0
 * @since	!_TODO__ [Barry Wright] : Update this label before new release.
 */
public class ExcelDatastrategy extends DataIOStrategy<DataObject> {

    private InputStream inputStream;

    public ExcelDatastrategy(String location, InputStream inputStream) {
        this.location = location;
        this.inputStream = inputStream;
    }

    @Override
    public void writeData(DataObject objects) {

    }

    @Override
    public DataObject readData() {
        DataObject<List<String>> dataObject = new DataObject<List<String>>();

//        // Use a file
//        try {
//            File f = stream2file(inputStream);
//            Workbook wb = WorkbookFactory.create(f);
//
//
//
//            for (int i = 0; i < wb.getNumberOfSheets(); i++ ) {
//                Sheet sheet = wb.getSheetAt(i);
//                for (Row row : sheet) {
//                    List<String> columnData = new ArrayList<String>();
//                    for (Cell cell : row) {
//                        columnData.add(cell.getStringCellValue());
//                    }
//                    dataObject.addData(columnData);
//                }
//            }
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InvalidFormatException e) {
//            e.printStackTrace();
//        }

        return dataObject;
    }

//    public static final String PREFIX = "stream2file";
//    public static final String SUFFIX = ".tmp";
//    private File stream2file (InputStream in) throws IOException {
//        final File tempFile = File.createTempFile(PREFIX, SUFFIX);
//        tempFile.deleteOnExit();
//        try{
//            FileOutputStream out = new FileOutputStream(tempFile);
//            IOUtils.copy(in, out);
//        }catch (Exception ex){
//
//        }
//        return tempFile;
//    }
}
