package tv2.metamorphose;

public class Days {
    public String name = "";
    public String buttonName = "";
    public String dialogue = "";
    public String[] symptoms = {""};
    public String beginDayDialogue = "";
    public String characterImage = "";
    public String armImage = "";
    public String headImage = "";
    public String legImage = "";

    public Days(int day, int patientNum) {
        if (day == 1) {
            beginDayDialogue = "The new assignments always suck, new place no ones heard from in years and all of a sudden lets go check on these whinos down in the sticks.\n " +
                    "It's been a few months since I've been able to practice though, so I suppose it's about time I get back into it, even if it is only for the next three days";
            Day1(patientNum);
        }
        else if (day == 2) {
            beginDayDialogue = "Do you ever wonder whether or not these diagnoses actually help anyone?";
            Day2(patientNum);
        }
    }

    private void Day1(int patientNum) {
        if (patientNum == 1) {
            LenaRosario();
        }
        else if (patientNum == 2) {
            MilesJohnson();
        }
        else if (patientNum == 3) {
            AriaFoster();
        }
        else if(patientNum == 4) {
            FinnODonoghue();
        }
        else if (patientNum == 5){
            ArjunSignh();
        }
    }

    private void Day2(int patientNum) {
        if (patientNum == 6) {
            RajPatel();
        }
        else if (patientNum == 7) {
            AlexaKnight();
        }
        else if (patientNum == 8) {
            SloanCameron();
        }
        else if (patientNum == 9) {
            IvySterling();
        }
        else if (patientNum == 10) {
            JadeLi();
        }
    }

    private void LenaRosario() {
        name = "Lena Rosario";
        symptoms = new String[]{"Low Grade Fever", "Headache", "Loss of Appetite", "Body Tremors", "Confusion",
                "Small Rashes", "Skin Warts", "Skin Bumps", "Swollen Limbs", "Large Skin Lesion"};
        dialogue = "Good morning! Sorry to bother you today, but I have had a low grade fever I think for the last few days, " +
                "it's hard to remember how long its been. I’ve had a horrible headache, I haven’t been eating and I feel like my body is shaking a lot.";

        characterImage = "/lena.png";
        headImage = "/lenaHead.png";
        armImage = "/lenaArms.png";
        legImage = "/lenaLegs.png";

        buttonName = "Next Patient";
    }

    private void MilesJohnson() {
        name = "Miles Johnson";
        symptoms = new String[]{"Confusion", "Loss of Appetite", "Low Grade Fever", "Headache", "Small Rashes", "Skin Bumps", "Cold Sores", "Swollen Limbs", "Cracked Fingernails", "Skin Abscesses"};
        dialogue = "Hey doc, I have not been eatin’ well, I could have sworn Ive been running a fever, and I’ve had a pretty mild headache, but honestly I couldn’t tell you how long though it's kinda hard to remember.";

        characterImage = "/miles.png";
        headImage = "/milesHead.png";
        armImage = "/milesArms.png";
        legImage = "/milesLegs.png";

        buttonName = "Next Patient";
    }

    private void AriaFoster() {
        name = "Aria Foster";
        symptoms = new String[]{"High Grade Fever", "Headache", "Loss of Appetite", "Body Tremors",
                "Small Rashes", "Skin Abscesses", "Skin Bumps", "Swollen Limbs", "Cold Sores", "Cracked Fingernails"};
        dialogue = "Hey um yea, I have had a horrible headache, been running a pretty high fever for the last few days, haven’t been eating because of it, and I think I’ve been shaking.";

        characterImage = "/aria.png";
        headImage = "/ariaHead.png";
        armImage = "/ariaArms.png";
        legImage = "/ariaLegs.png";

        buttonName = "Next Patient";
    }

    private void FinnODonoghue() {
        name = "Finn O'Donoghue";
        symptoms = new String[]{"Confusion", "Loss of Appetite", "Body Tremors", "Headache", "Small Rashes", "Skin Bumps", "Cold Sores", "Swollen Limbs", "Cracked Fingernails", "Skin Warts"};
        dialogue = "Doc, Imr feeln terble, em not hngry, and head hurts,I feeel lst ,and em shky.";

        characterImage = "/finn.png";
        headImage = "/finnHead.png";
        armImage = "/finnArms.png";
        legImage = "/finnLegs.png";

        buttonName = "Next Patient";
    }

    private void ArjunSignh() {
        name = "Arjun Signh";
        symptoms = new String[]{"Low Grade Fever", "Headache", "Loss of Appetite", "Weakness",
                "Bloody Nose", "Skin Lesions", "Swollen Limbs", "Cold Sores", "Cracked Fingernails"};
        dialogue = "Evening, sorry to be here so late but I just got off work, I’ve had a fever, a headache, haven’t been able to really eat, and it has been making me feel rather weak.";

        characterImage = "/arjun.png";
        headImage = "/arjunHead.png";
        armImage = "/arjunArms.png";
        legImage = "/arjunLegs.png";

        buttonName = "Clock Out";
    }

    private void RajPatel() {
        name = "Raj Patel";
        symptoms = new String[]{"Low Grade Fever", "Body Tremors", "Major Skin Rashes", "Swollen Limbs", "Skin Abscesses", "Weakness", "Cold Sores", "Visible Veins", "Holes in Skin"};
        dialogue = "Good morning! I have been feeling pretty weak lately, as well as I’ve been shaky, and I think I may have a slight fever";

        characterImage = "/raj.png";
        headImage = "/rajHead.png";
        armImage = "/rajArms.png";
        legImage = "/rajLegs.png";

        buttonName = "Next Patient";
    }

    private void AlexaKnight() {
        name = "Alexa Knight";
        symptoms = new String[]{"Weakness", "Loss of Appetite", "High Grade Fever", "Body Tremors", "Open Sores", "Cold Sores", "Swollen Limbs", "Visible Veins", "Skin Abscesses", "Blood Shot Eyes"};
        dialogue = "Mornin’! Nice to see a new doctor in town, I’ve been recently dealing with some general weakness, loss of appetite, and pretty high fever, and I believe that's whats making me super shaky";

        characterImage = "/alexa.png";
        headImage = "/alexaHead.png";
        armImage = "/alexaArms.png";
        legImage = "/alexaLegs.png";

        buttonName = "Next Patient";
    }

    private void SloanCameron() {
        name = "Sloan Cameron";
        symptoms = new String[]{"High Grade Fever", "Body Tremors", "Loss of Appetite", "Weakness", "Confusion",
                "Bloodshot Eyes", "Skin Abscesses", "Skin Warts", "Small Rashes", "Visible Veins"};
        dialogue = "Howdy Hey! I've been struggling with some shakiness and weakness, as well as I have been confused and a rather high fever.";

        characterImage = "/sloan.png";
        headImage = "/sloanHead.png";
        armImage = "/sloanArms.png";
        legImage = "/sloanLegs.png";

        buttonName = "Next Patient";
    }

    private void IvySterling() {
        name = "Ivy Sterling";
        symptoms = new String[]{"High Grade Fever", "Body Tremors", "Weakness", "Bloodshot Eyes", "Skin Warts",
                "Visible Veins", "Open Sores", "Skin Gashes", "Swollen Limbs", "Cold Sores"};
        dialogue = "I've been struggling to stand honestly, very weak as well as shaky, and I feel like I'm running a pretty high fever";

        characterImage = "/ivy.png";
        headImage = "/ivyHead.png";
        armImage = "/ivyArms.png";
        legImage = "/ivyLegs.png";

        buttonName = "Next Patient";
    }

    private void JadeLi() {
        name = "Jade Li";
        symptoms = new String[]{"High Grade Fever", "Headache", "Loss of Appetite", "Weakness",
                "Visible Veins", "Open Sores", "Swollen Limbs", "Bloody Nose", "Skin Abscesses", "Cracked Fingernails"};
        dialogue = "I’ve been pretty weak lately, it's been hard to eat and move and I believe I may be running a fever";

        characterImage = "/jade.png";
        headImage = "/jadeHead.png";
        armImage = "/jadeArms.png";
        legImage = "/jadeLegs.png";

        buttonName = "Clock Out";
    }
}
