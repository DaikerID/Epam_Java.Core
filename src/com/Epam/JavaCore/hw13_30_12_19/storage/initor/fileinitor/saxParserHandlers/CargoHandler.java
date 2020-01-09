package com.Epam.JavaCore.hw13_30_12_19.storage.initor.fileinitor.saxParserHandlers;

import com.Epam.JavaCore.hw12_27_12_19.cargo.domain.CargoType;
import com.Epam.JavaCore.hw13_30_12_19.cargo.domain.Cargo;
import com.Epam.JavaCore.hw13_30_12_19.cargo.domain.ClothersCargo;
import com.Epam.JavaCore.hw13_30_12_19.cargo.domain.FoodCargo;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class CargoHandler extends DefaultHandler {
    Map<String, Cargo> cargoMap = new HashMap<>();
    Cargo currCargo;
    String currKeyCargo;
    private StringBuilder stringBuilder = new StringBuilder();

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        stringBuilder.setLength(0);

        if (qName == "cargo") {
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
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        String data = stringBuilder.toString();
        switch (qName) {
            case "name": {
                if (currCargo != null){
                    currCargo.setName(data);
                }
                break;
            }
            case "weight": {
                if (currCargo != null) {
                    currCargo.setWeight(Integer.valueOf(data));
                }
                break;
            }
            case "expirationDate": {
                if (currCargo != null && FoodCargo.class.equals(currCargo.getClass())){
                    try {
                        ((FoodCargo) currCargo).setExpirationDate(parseDate(data));
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                }
                break;
            }
            case "storeTemperature": {
                if (currCargo != null && FoodCargo.class.equals(currCargo.getClass())){
                    ((FoodCargo) currCargo).setStoreTemperature(Integer.valueOf(data));
                }
                break;
            }
            case "size": {
                if (currCargo != null && ClothersCargo.class.equals((currCargo.getClass()))){
                    ((ClothersCargo) currCargo).setSize(data);
                }
                break;
            }
            case "material": {
                if ( currCargo != null && ClothersCargo.class.equals((currCargo.getClass()))){
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

    private Date parseDate(String data) throws ParseException{
        SimpleDateFormat format = new SimpleDateFormat();
        format.applyPattern("dd.MM.yyyy");
        Date date = format.parse(data);
        return date;
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String data = new String(ch, start, length);
        stringBuilder.append(data);
    }

    public Map<String, Cargo> getCargoMap() {
        return cargoMap;
    }
}
