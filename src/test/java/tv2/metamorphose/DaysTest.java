package tv2.metamorphose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaysTest {


    @Test
    void day1() {

    }

    @Test
    void day2() {

    }

    @Test
    void lenaRosario() {
        Days d = new Days(1,1);
        String name = "Lena Rosario";
        String buttonName = "Next Patient";
        String dialogue = "Good morning! Sorry to bother you today, but I have had a low grade fever I think for the last few days, " +
                "it's hard to remember how long its been. I’ve had a horrible headache, I haven’t been eating and I feel like my body is shaking a lot.";

        assertEquals(name, d.name);
        assertEquals(buttonName, d.buttonName);
        assertEquals(dialogue, d.dialogue);
    }

    @Test
    void milesJohnson() {

    }

    @Test
    void ariaFoster() {

    }

    @Test
    void finnODonoghue() {

    }

    @Test
    void arjunSignh() {

    }
}