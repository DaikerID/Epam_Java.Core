package com.Epam.JavaCore.hw18_29_01_20.storage.initor.fileinitor.saxparserhandlers;

import com.Epam.JavaCore.hw12_27_12_19.cargo.domain.CargoType;
import com.Epam.JavaCore.hw18_29_01_20.cargo.domain.Cargo;
import com.Epam.JavaCore.hw18_29_01_20.cargo.domain.ClothersCargo;
import com.Epam.JavaCore.hw18_29_01_20.cargo.domain.FoodCargo;
import com.Epam.JavaCore.hw18_29_01_20.carrier.domain.Carrier;
import com.Epam.JavaCore.hw18_29_01_20.carrier.domain.CarrierType;
import com.Epam.JavaCore.hw18_29_01_20.storage.initor.fileinitor.BaseFileInitor;
import com.Epam.JavaCore.hw18_29_01_20.transportation.domain.Transportation;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.*;

public class StorageHandler extends DefaultHandler {
    private Map<String, Cargo> cargoMap = new HashMap<>();
    private Cargo currCargo;
    private String currKeyCargo;

    private Map<String, Carrier> carrierMap = new HashMap<>();
    private Carrier currCarrier;
    private String currKeyCarrier;

    private List<BaseFileInitor.ParsedTransportation> transportations = new ArrayList<>();
    private BaseFileInitor.ParsedTransportation parsedTransportation;
    private Transportation currTransportation;

    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.setLength(0);
        switch (qName) {
            case "cargo": {
                currKeyCargo = attributes.getValue("id");
                switch (CargoType.valueOf(attributes.getValue("type"))) {
                    case FOOD: {
                        currCargo = new FoodCargo();
                        break;
                    }
                    case CLOTHERS: {
                        currCargo = new ClothersCargo();
                        break;
                    }
                }
                break;
            }
            case "carrier": {
                currKeyCarrier = attributes.getValue("id");
                currCarrier = new Carrier();
                break;
            }
            case "transportation": {
                parsedTransportation = new BaseFileInitor.ParsedTransportation();
                parsedTransportation.setCargoRef(attributes.getValue("cargoref"));
                parsedTransportation.setCarrierRef(attributes.getValue("carrierref"));
                currTransportation = new Transportation();
                break;
            }
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String data = stringBuilder.toString();

        if (currCargo != null) {
            fillCargoithData(qName, data);
        } else if (currCarrier != null) {
            fillCarrierWithData(qName, data);
        } else if (currTransportation != null) {
            fillTransportationWithData(qName, data);
        }
    }

    private void fillCargoithData(String qName, String data) {
        switch (qName) {
            case "name": {
                currCargo.setName(data);
                break;
            }

            case "weight": {
                currCargo.setWeight(Integer.valueOf(data));
                break;
            }

            case "expirationDate": {
                if (FoodCargo.class.equals(currCargo.getClass())) {
                    try {
                        ((FoodCargo) currCargo).setExpirationDate(parseDate(data));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }

            case "storeTemperature": {
                if (FoodCargo.class.equals(currCargo.getClass())) {
                    ((FoodCargo) currCargo).setStoreTemperature(Integer.valueOf(data));
                }
                break;
            }

            case "size": {
                if (ClothersCargo.class.equals((currCargo.getClass()))) {
                    ((ClothersCargo) currCargo).setSize(data);
                }
                break;
            }

            case "material": {
                if (ClothersCargo.class.equals((currCargo.getClass()))) {
                    ((ClothersCargo) currCargo).setMaterial(data);
                }
                break;
            }

            case "cargo": {
                cargoMap.put(currKeyCargo, currCargo);
                currCargo = null;
                break;
            }
        }
    }

    private void fillCarrierWithData(String qName, String data) {
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
                break;
            }

            case "carrier": {
                carrierMap.put(currKeyCarrier, currCarrier);
                currCarrier = null;
                break;
            }
        }
    }

    private void fillTransportationWithData(String qName, String data) {
        switch (qName) {
            case "billto": {
                currTransportation.setBillTo(data);
                break;
            }

            case "transportationBeginDate": {
                try {
                    currTransportation.setTransportationBeginDate(parseDate(data));
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
            }

            case "description": {
                currTransportation.setDescription(data);
                break;
            }

            case "transportation": {
                parsedTransportation.setTransportation(currTransportation);
                transportations.add(parsedTransportation);
                parsedTransportation = null;
                currTransportation = null;
                break;
            }
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        stringBuilder.append(data);
    }

    private ZonedDateTime parseDate(String data) throws ParseException {

        return ZonedDateTime.of(LocalDate.parse(data, DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                LocalTime.now(),
                ZoneId.of("Europe/Moscow"));
    }

    public Map<String, Cargo> getCargoMap() {
        return cargoMap;
    }

    public Map<String, Carrier> getCarrierMap() {
        return carrierMap;
    }

    public List<BaseFileInitor.ParsedTransportation> getTransportations() {
        return transportations;
    }
}
