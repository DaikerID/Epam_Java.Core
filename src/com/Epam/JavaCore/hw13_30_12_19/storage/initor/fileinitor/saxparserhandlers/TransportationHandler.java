package com.Epam.JavaCore.hw13_30_12_19.storage.initor.fileinitor.saxparserhandlers;

import com.Epam.JavaCore.hw13_30_12_19.transportation.domain.Transportation;
import com.Epam.JavaCore.hw13_30_12_19.storage.initor.fileinitor.BaseFileInitor;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TransportationHandler extends DefaultHandler {
    List<BaseFileInitor.ParsedTransportation> transportations = new ArrayList<>();
    BaseFileInitor.ParsedTransportation parsedTransportation;
    Transportation currTransportation;

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.setLength(0);
        if (qName == "transportation") {
            parsedTransportation = new BaseFileInitor.ParsedTransportation();
            parsedTransportation.setCargoRef(attributes.getValue("cargoref"));
            parsedTransportation.setCarrierRef(attributes.getValue("carrierref"));
            currTransportation = new Transportation();
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String data = stringBuilder.toString();
        switch (qName) {
            case "billto": {
                if (currTransportation != null) {
                    currTransportation.setBillTo(data);
                }
                break;
            }
            case "transportationBeginDate": {
                if (currTransportation != null) {
                    try {
                        currTransportation.setTransportationBeginDate(parseDate(data));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
            case "description": {
                if (currTransportation != null) {
                    currTransportation.setDescription(data);
                }
            }
            case "transportation": {
                if (currTransportation != null) {
                    parsedTransportation.setTransportation(currTransportation);
                    transportations.add(parsedTransportation);
                    parsedTransportation = null;
                    currTransportation = null;
                }

                break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        stringBuilder.append(data);
    }

    private Date parseDate(String data) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date date = format.parse(data);
        return date;
    }

    public List<BaseFileInitor.ParsedTransportation> getTransportations() {
        return transportations;
    }
}
