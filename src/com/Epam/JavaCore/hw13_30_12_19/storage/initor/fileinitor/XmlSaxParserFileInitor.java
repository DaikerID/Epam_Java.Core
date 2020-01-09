package com.Epam.JavaCore.hw13_30_12_19.storage.initor.fileinitor;

import com.Epam.JavaCore.hw13_30_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw13_30_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw13_30_12_19.common.solutions.utils.FileUtils;
import com.Epam.JavaCore.hw13_30_12_19.storage.initor.fileinitor.saxParserHandlers.CargoHandler;
import com.Epam.JavaCore.hw13_30_12_19.storage.initor.fileinitor.saxParserHandlers.CarrierHandler;
import com.Epam.JavaCore.hw13_30_12_19.storage.initor.fileinitor.saxParserHandlers.TransportationHandler;
import com.Epam.JavaCore.hw13_30_12_19.transportation.domain.Transportation;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.*;


public class XmlSaxParserFileInitor extends BaseFileInitor {
    private static final String FILE = "/ru/Epam/JavaCore/lesson_12_io_nio/initdata/xmldata.xml";
    private static final String STATIC_FILE = "C:\\Users\\igorh\\IdeaProjects\\Epam_Java.Core\\resourses\\com\\Epam\\JavaCore\\lesson_12_io_nio\\initdata\\xmldata.xml";
    @Override
    public void initStorage() throws IOException, ParserConfigurationException, SAXException {
        //File file = getFileWithInitData();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        CargoHandler cargoHandler = new CargoHandler();
        CarrierHandler carrierHandler = new CarrierHandler();
        TransportationHandler transportationHandler = new TransportationHandler();

        saxParser.parse(new File(STATIC_FILE), cargoHandler);
        saxParser.parse(new File(STATIC_FILE), carrierHandler);
        saxParser.parse(new File(STATIC_FILE), transportationHandler);

       Map<String, Cargo> cargoMap = cargoHandler.getCargoMap();
        Map<String, Carrier> carrierMap = carrierHandler.getCarrierMap();
        List<ParsedTransportation> transportations = transportationHandler.getTransportations();
        setReferencesBetweenEntities(cargoMap, carrierMap, transportations);

        persistCargos(cargoMap.values());
        persistCarriers(carrierMap.values());
        List<Transportation> transportationList = getTransportationsFromParsedObject(transportations);
        persistTransportations(transportationList);
    }

    private File getFileWithInitData() throws IOException {
        return FileUtils.createFileFromResource("init-data", "lesson12", FILE);
    }
}
