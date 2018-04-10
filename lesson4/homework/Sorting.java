package lesson4.homework;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Михаил on 20.03.2018.
 */
public class Sorting extends AbstractSorting {

    @Override
    AbstractVehicle[] min(AbstractVehicle[] abstractVehicles) {
        Arrays.sort(abstractVehicles);
        return abstractVehicles;
    }

    @Override
    AbstractVehicle[] max(AbstractVehicle[] abstractVehicles) {
        Arrays.sort(abstractVehicles);
        Collections.reverse(Arrays.asList(abstractVehicles));
        return abstractVehicles;
    }
}
