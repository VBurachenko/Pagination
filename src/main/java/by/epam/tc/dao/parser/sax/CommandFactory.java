package by.epam.tc.dao.parser.sax;

import by.epam.tc.dao.parser.ItemField;
import by.epam.tc.dao.parser.sax.impl.*;
import by.epam.tc.entity.Plane;

import java.util.HashMap;
import java.util.Map;

public final class CommandFactory {

    private final Map<ItemField, Command> actions;

    public CommandFactory(Plane plane) {
        actions = new HashMap<ItemField, Command>(){
            {
                put(ItemField.MANUFACTURER, new SetManufacturer(plane));
                put(ItemField.MODEL, new SetModel(plane));
                put(ItemField.ORIGIN, new SetOrigin(plane));
                put(ItemField.TYPE, new SetType(plane));
                put(ItemField.CREW, new SetCrew(plane));
                put(ItemField.PASSENGER_CAPACITY, new SetPassengerCapacity(plane));
                put(ItemField.CARGO_CAPACITY, new SetCargoCapacity(plane));
                put(ItemField.PRICE, new SetPrice(plane));
                put(ItemField.ENG_MODEL, new SetEngineModel(plane));
                put(ItemField.ENG_TYPE, new SetEngineType(plane));
                put(ItemField.HEIGHT, new SetHeight(plane));
                put(ItemField.LENGTH, new SetLength(plane));
                put(ItemField.WINGSPAN, new SetWingspan(plane));
                put(ItemField.GROSS_WEIGHT, new SetGrossWeight(plane));
            }
        };
    }

    public Command getAction(ItemField itemField){
        return actions.get(itemField);
    }
}
