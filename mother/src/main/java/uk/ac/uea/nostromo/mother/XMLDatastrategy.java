package uk.ac.uea.nostromo.mother;

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

import android.util.Xml;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * !_TODO__ [Barry Wright] : Write this piece of documentation.
 *
 * @author	Barry Wright {@literal <barry.wright@uea.ac.uk>}
 * @version	v1.0.0
 * @since	!_TODO__ [Barry Wright] : Update this label before new release.
 */
public class XMLDatastrategy extends DataIOStrategy<DataObject> {

    private InputStream inputStream;

    public XMLDatastrategy(String location, InputStream inputStream) {
        this.location = location;
        this.inputStream = inputStream;
    }

    @Override
    public void writeData(DataObject objects) {

    }

    @Override
    public DataObject readData() {
        DataObject<List<MapRow>> dataObject = new DataObject<List<MapRow>>();
        List<MapRow> mapData = new ArrayList<MapRow>();

        MapRow curMapRow = null;

        String curText = "";

        try{
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            XmlPullParser xmlpp = factory.newPullParser();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            xmlpp.setInput(reader);

            int event = xmlpp.getEventType();

            while(event != XmlPullParser.END_DOCUMENT){
                String tag = xmlpp.getName();

                switch (event){
                    case XmlPullParser.START_TAG:{
                        if(tag.equalsIgnoreCase("dataRow")){
                            curMapRow = new MapRow();
                        }
                    }
                    break;
                    case XmlPullParser.TEXT: {
                        curText = xmlpp.getText();
                    }
                    break;
                    case XmlPullParser.END_TAG: {
                        if(tag.equalsIgnoreCase("dataRow")){
                            mapData.add(curMapRow);
                        }
                        else if(tag.equalsIgnoreCase("type")){
                            curMapRow.setType(curText);
                        }
                        else if(tag.equalsIgnoreCase("name")){
                            curMapRow.setName(curText);
                        }
                        else if(tag.equalsIgnoreCase("lat")){
                            double lat = Double.parseDouble(curText);
                            curMapRow.setLat(lat);
                        }
                        else if(tag.equalsIgnoreCase("long")){
                            double longitude = Double.parseDouble(curText);
                            curMapRow.setLongitude(longitude);
                        }
                        else if(tag.equalsIgnoreCase("id")){
                            curMapRow.setId(curText);
                        }
                        else if(tag.equalsIgnoreCase("fac")){
                            curMapRow.setFac(curText);
                        }
                        else if(tag.equalsIgnoreCase("description")){
                            curMapRow.setDescription(curText);
                        }
                        else if(tag.equalsIgnoreCase("abbr")){
                            curMapRow.setAbbr(curText);
                        }
                        else if(tag.equalsIgnoreCase("openingtimes")){
                            curMapRow.setOpentimes(curText);
                        }
                        else if(tag.equalsIgnoreCase("image")){
                            curMapRow.setImage(curText);
                        }
                        else if(tag.equalsIgnoreCase("link")){
                            curMapRow.setLink(curText);
                        }
                    }
                    break;
                    default: break;
                }

                event = xmlpp.next();
            } //end of while

        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new DataObject(mapData);
    }

    public class MapRow {
        String type;
        String name;
        double lat;
        double longitude;
        String id;
        String fac;
        String description;
        String abbr;
        String opentimes;
        String image;
        String link;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public double getLat() {
            return lat;
        }

        public void setLat(double lat) {
            this.lat = lat;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getFac() {
            return fac;
        }

        public void setFac(String fac) {
            this.fac = fac;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getAbbr() {
            return abbr;
        }

        public void setAbbr(String abbr) {
            this.abbr = abbr;
        }

        public String getOpentimes() {
            return opentimes;
        }

        public void setOpentimes(String opentimes) {
            this.opentimes = opentimes;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getLink() {
            return link;
        }

        public void setLink(String link) {
            this.link = link;
        }
    }
}
