package p06_TirePressureMonitoringSystem;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.lang.reflect.Field;

import static org.junit.Assert.*;

public class AlarmTest {

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void checkAlarmIsOnWhenPressureIsLessThanLowerLimit() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm = new Alarm();

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(16.0);

        Field field = Alarm.class.getDeclaredField("sensor");

        field.setAccessible(true);
        field.set(alarm, sensor);
    }

    @Test
    public void checkAlarmIsOnWhenPressureIsLessThanLowerUpperLimit() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm = new Alarm();

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(21.5);

        Field field = Alarm.class.getDeclaredField("sensor");

        field.setAccessible(true);
        field.set(alarm, sensor);
    }

    @Test
    public void checkAlarmIsOnWhenPressureIsBetweenTheLimit() throws NoSuchFieldException, IllegalAccessException {
        Alarm alarm = new Alarm();

        Sensor sensor = Mockito.mock(Sensor.class);
        Mockito.when(sensor.popNextPressurePsiValue())
                .thenReturn(20.0);

        Field field = Alarm.class.getDeclaredField("sensor");

        field.setAccessible(true);
        field.set(alarm, sensor);
    }
}