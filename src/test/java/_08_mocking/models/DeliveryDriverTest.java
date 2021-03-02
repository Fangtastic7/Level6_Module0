package _08_mocking.models;

import _07_intro_to_mocking.models.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class DeliveryDriverTest {

    DeliveryDriver deliveryDriver;


    String name = "bob";

    @Mock
    CellPhone cellphone;

    @Mock
    Car car;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);


        deliveryDriver = new DeliveryDriver(name, car, cellphone);
    }

    @Test
    void itShouldWasteTime() {
        //given
        boolean expectedStart = true;

    when(deliveryDriver.wasteTime()).thenReturn(true);
        //when
        boolean actualStart = deliveryDriver.wasteTime();
        //then
        assertEquals(expectedStart, actualStart);
    }

    @Test
    void itShouldRefuel() {
        //given
        boolean expectedRefuel = true;
        int octane = 90;
        when(deliveryDriver.refuel(octane)).thenReturn(true);
        //when
        boolean actualRefuel = deliveryDriver.refuel(octane);
        //then
        assertEquals(expectedRefuel, actualRefuel);
    }

    @Test
    void itShouldContactCustomer() {
        //given
        boolean expectednumber = true;
        String pn = "8588889999";
        when(deliveryDriver.contactCustomer(pn)).thenReturn(true);
        //when
        boolean actualnumber = deliveryDriver.contactCustomer(pn);
        //then
        assertEquals(expectednumber, actualnumber);
    }

}