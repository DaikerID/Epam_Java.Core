package com.Epam.JavaCore.hw13_30_12_19.storage.initor.fileinitor.saxparserhandlers;

import com.Epam.JavaCore.hw13_30_12_19.carrier.domain.Carrier;
import com.Epam.JavaCore.hw13_30_12_19.carrier.domain.CarrierType;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class CarrierHandler extends DefaultHandler {

    private Map<String, Carrier> carrierMap = new HashMap<>();
    private Carrier currCarrier;
    private String currKeyCarrier;
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
        if (currCarrier != null) {
            switch (qName) {
                case "name": {
                    currCarrier.setName(data);
                    break;
                }
                case "address": {
                    currCarrier.setAddress(data);
                    break;
                }
                case "type": {
                    currCarrier.setCarrierType(CarrierType.valueOf(data));
                }
                case "carrier": {
                    carrierMap.put(currKeyCarrier, currCarrier);
                    //currCarrier = null;
                    break;
                }
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

