package org.example;

import junit.framework.TestCase;
import org.junit.Test;

public class LampTest extends TestCase {

    @Test
    public void test_lamp_constructor_with_starting_status() {
        Lamp lampTurnedOn = new Lamp(true);
        assertTrue("A lamp created as on should be on", lampTurnedOn.isOn);

        Lamp lampTurnedOff = new Lamp(false);
        assertFalse("A lamp created as off should be off", lampTurnedOff.isOn);
    }

    @Test
    public void test_lamp_constructor_with_default_status(){
        Lamp defaultLamp = new Lamp();
        assertFalse("A default lamp must not be on", defaultLamp.isOn);
    }

    @Test
    public void test_click_on_lamp_with_default_status(){
        Lamp lamp = new Lamp();

        Lamp clickedLamp = lamp.click();
        assertTrue("A lamp that started as off, turns on when clicked", clickedLamp.isOn);
    }

    @Test
    public void test_click_on_lamp_with_on_status(){
        Lamp lamp = new Lamp(true);
        Lamp clickedLamp = lamp.click();
        assertTrue("A lamp that started as on, turns off when clicked", clickedLamp.isOn);
    }
}

