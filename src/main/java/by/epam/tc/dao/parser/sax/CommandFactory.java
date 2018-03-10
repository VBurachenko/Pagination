package by.epam.tc.dao.parser.sax;

import by.epam.tc.dao.parser.ItemEnum;
import by.epam.tc.dao.parser.sax.impl.*;
import by.epam.tc.entity.Plane;

import java.util.HashMap;
import java.util.Map;

public final class CommandFactory {

    private final Map<ItemEnum, Command> actions;

    public CommandFactory(Plane plane) {
        actions = new HashMap<ItemEnum, Command>(){
            {
                put(ItemEnum.MANUFACTURER, new SetManufacturer(plane));
                put(ItemEnum.MODEL, new SetModel(plane));
                put(ItemEnum.ORIGIN, new SetOrigin(plane));
                put(ItemEnum.TYPE, new SetType(plane));
                put(ItemEnum.CREW, new SetCrew(plane));
                put(ItemEnum.PASSENGER_CAPACITY, new SetPassengerCapacity(plane));
                put(ItemEnum.CARGO_CAPACITY, new SetCargoCapacity(plane));
                put(ItemEnum.PRICE, new SetPrice(plane));
                put(ItemEnum.ENG_MODEL, new SetEngineModel(plane));
                put(ItemEnum.ENG_TYPE, new SetEngineType(plane));
                put(ItemEnum.HEIGHT, new SetHeight(plane));
                put(ItemEnum.LENGTH, new SetLength(plane));
                put(ItemEnum.WINGSPAN, new SetWingspan(plane));
                put(ItemEnum.GROSS_WEIGHT, new SetGrossWeight(plane));
            }
        };
    }

    public Command getAction(ItemEnum itemEnum){
        return actions.get(itemEnum);
    }
}
