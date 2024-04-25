package tv2.metamorphose;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DaysTest {



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
        Days d = new Days(1,2);
        String name = "Miles Johnson";
        String buttonName = "Next Patient";
        String dialogue = "Hey doc, I have not been eatin’ well, I could have sworn Ive been running a fever, and I’ve had a pretty mild headache, but honestly I couldn’t tell you how long though it's kinda hard to remember.";

        assertEquals(name, d.name);
        assertEquals(buttonName, d.buttonName);
        assertEquals(dialogue, d.dialogue);
    }

    @Test
    void ariaFoster() {
        Days d = new Days(1,3);
        String name = "Aria Foster";
        String buttonName = "Next Patient";
        String dialogue = "Hey um yea, I have had a horrible headache, been running a pretty high fever for the last few days, haven’t been eating because of it, and I think I’ve been shaking.";

        assertEquals(name, d.name);
        assertEquals(buttonName, d.buttonName);
        assertEquals(dialogue, d.dialogue);
    }

    @Test
    void finnODonoghue() {
        Days d = new Days(1,4);
        String name = "Finn O'Donoghue";
        String buttonName = "Next Patient";
        String dialogue = "Doc, Imr feeln terble, em not hngry, and head hurts,I feeel lst ,and em shky.";

        assertEquals(name, d.name);
        assertEquals(buttonName, d.buttonName);
        assertEquals(dialogue, d.dialogue);
    }

    @Test
    void arjunSignh() {
        Days d = new Days(1,5);
        String name = "Arjun Signh";
        String buttonName = "Clock Out";
        String dialogue = "Evening, sorry to be here so late but I just got off work, I’ve had a fever, a headache, haven’t been able to really eat, and it has been making me feel rather weak.";

        assertEquals(name, d.name);
        assertEquals(buttonName, d.buttonName);
        assertEquals(dialogue, d.dialogue);
    }
    @Test
    void rajPatel() {
        Days d = new Days(2,6);
        String name = "Raj Patel";
        String buttonName = "Next Patient";
        String dialogue = "Good morning! I have been feeling pretty weak lately, as well as I’ve been shaky, and I think I may have a slight fever";

        assertEquals(name, d.name);
        assertEquals(buttonName, d.buttonName);
        assertEquals(dialogue, d.dialogue);
    }
    @Test
    void alexaKnight() {
        Days d = new Days(2,7);
        String name = "Alexa Knight";
        String buttonName = "Next Patient";
        String dialogue = "Mornin’! Nice to see a new doctor in town, I’ve been recently dealing with some general weakness, loss of appetite, and pretty high fever, and I believe that's whats making me super shaky";

        assertEquals(name, d.name);
        assertEquals(buttonName, d.buttonName);
        assertEquals(dialogue, d.dialogue);
    }
    @Test
    void sloanCameron() {
        Days d = new Days(2,8);
        String name = "Sloan Cameron";
        String buttonName = "Next Patient";
        String dialogue = "Howdy Hey! I've been struggling with some shakiness and weakness, as well as I have been confused and a rather high fever.";

        assertEquals(name, d.name);
        assertEquals(buttonName, d.buttonName);
        assertEquals(dialogue, d.dialogue);
    }
    @Test
    void ivySterling() {
        Days d = new Days(2,9);
        String name = "Ivy Sterling";
        String buttonName = "Next Patient";
        String dialogue = "I've been struggling to stand honestly, very weak as well as shaky, and I feel like I'm running a pretty high fever";

        assertEquals(name, d.name);
        assertEquals(buttonName, d.buttonName);
        assertEquals(dialogue, d.dialogue);
    }
    @Test
    void jadeLi() {
        Days d = new Days(2,10);
        String name = "Jade Li";
        String buttonName = "Clock Out";
        String dialogue = "I’ve been pretty weak lately, it's been hard to eat and move and I believe I may be running a fever";

        assertEquals(name, d.name);
        assertEquals(buttonName, d.buttonName);
        assertEquals(dialogue, d.dialogue);
    }

}