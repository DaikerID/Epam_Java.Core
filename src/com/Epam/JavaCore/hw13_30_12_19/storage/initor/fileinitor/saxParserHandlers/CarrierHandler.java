package com.Epam.JavaCore.hw13_30_12_19.storage.initor.fileinitor.saxParserHandlers;

import com.Epam.JavaCore.hw13_30_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw13_30_12_19.carrier.domain.CarrierType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class CarrierHandler extends DefaultHandler {

    Map<String, Carrier> carrierMap = new HashMap<>();
    Carrier currCarrier;
    String currKeyCarrier;
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.setLength(0);

        if (qName == "carrier"){
            currKeyCarrier = attributes.getValue("id");
            currCarrier = new Carrier();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String data = stringBuilder.toString();
        switch (qName) {
            case "name": {
                if (currCarrier != null){
                    currCarrier.setName(data);
                }
                break;
            }
            case "address": {
                if (currCarrier != null) {
                    currCarrier.setAddress(data);
                }
                break;
            }
            case "type": {
                if (currCarrier != null) {
               currCarrier.setCarrierType(CarrierType.valueOf(data));
                }
            }
            case "carrier": {
                carrierMap.put(currKeyCarrier, currCarrier);
                break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        stringBuilder.append(data);
    }

    public Map<String, Carrier> getCarrierMap() {
        return carrierMap;
    }

}

