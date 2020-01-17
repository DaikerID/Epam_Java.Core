package com.Epam.JavaCore.hw14_13_01_19.storage.initor.fileinitor;

import com.Epam.JavaCore.hw14_13_01_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw14_13_01_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw14_13_01_19.common.solutions.utils.FileUtils;
import com.Epam.JavaCore.hw14_13_01_19.storage.initor.fileinitor.saxparserhandlers.StorageHandler;
import com.Epam.JavaCore.hw14_13_01_19.transportation.domain.Transportation;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;


public class XmlSaxParserFileInitor extends BaseFileInitor {
    private static final String FILE = "/com/Epam/JavaCore/lesson_12_io_nio/initdata/xmldata.xml";

    @Override
    public void initStorage() throws IOException, ParserConfigurationException, SAXException {
        File file = getFileWithInitData();
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser saxParser = factory.newSAXParser();

        StorageHandler storageHandler = new StorageHandler();
        saxParser.parse(file, storageHandler);

        Map<String, Cargo> cargoMap = storageHandler.getCargoMap();
        Map<String, Carrier> carrierMap = storageHandler.getCarrierMap();
        List<ParsedTransportation> transportations = storageHandler.getTransportations();

        setReferencesBetweenEntities(cargoMap, carrierMap, transportations);

        persistCargos(cargoMap.values());
        persistCarriers(carrierMap.values());
        List<Transportation> transportationList = getTransportationsFromParsedObject(transportations);
        persistTransportations(transportationList);
    }

    private File getFileWithInitData() throws IOException {
        return FileUtils.createFileFromResource(XmlSaxParserFileInitor.class, "init-data", "lesson12", FILE);
    }
}
