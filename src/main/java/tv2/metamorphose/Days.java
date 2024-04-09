package tv2.metamorphose;

public class Days {
    String name = "";
    String buttonName = "";
    String dialogue = "";
    String[] symptoms = {""};
    String beginDayDialogue = "";
    String characterImage = "";
    String armImage = "";
    String headImage = "";
    String torsoImage = "";
    String legImage = "";


    Days(int day, int patientNum) {
        if (day == 1) {
            beginDayDialogue = "The new assignments always suck, new place no ones heard from in years and all of a sudden lets go check on these whinos down in the sticks.\n " +
                    "It's been a few months since I've been able to practice though, so I suppose it's about time I get back into it, even if it is only for the next three days";

            Day1(patientNum);

        }
        else if (day == 2) {
            Day2(patientNum);
        }
        else {
            Day3(patientNum);
        }

    }

    void Day1(int patientNum) {
        // Patient 1 Lena Rosario
        if (patientNum == 1) {
            // TODO: Insert first cutscene
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

    void Day2(int patientNum) {
        if (patientNum == 6) {

        }
        else if (patientNum == 7) {

        }
        else if (patientNum == 8) {

        }
        else if (patientNum == 9) {

        }
        else if (patientNum == 10) {

        }
    }

    void Day3(int patientNum) {

    }

    void LenaRosario() {
        name = "Lena Rosario";
        symptoms = new String[]{"Low Grade Fever", "Headache", "Loss of Appetite", "Body Tremors", "Confusion",
                "Small Rashes", "Skin Warts", "Skin Bumps", "Swollen Limbs", "Large Skin Lesion"};
        dialogue = "Good morning! Sorry to bother you today, but I have had a low grade fever I think for the last few days, " +
                "it's hard to remember how long its been. I’ve had a horrible headache, I haven’t been eating and I feel like my body is shaking a lot.";

        //TODO: Change this
        characterImage = "/character.png";
        headImage = "/face.png";
        armImage = "/arms.png";
        torsoImage = "/torso.png";
        legImage = "/legs.png";

        buttonName = "Next Patient";
    }

    void MilesJohnson() {
        name = "Miles Johnson";
        symptoms = new String[]{"Confusion", "Loss of Appetite", "Low Grade Fever", "Headache", "Small Rashes", "Skin Bumps", "Cold Sores", "Swollen Limbs", "Cracked Fingernails", "Skin Abscesses"};
        dialogue = "Hey doc, I have not been eatin’ well, and I’ve had a pretty mild headache, but honestly I couldn’t tell you how long though it's kinda hard to remember.";

        //TODO: Change this
        characterImage = "/boar.png";
        headImage = "/face.png";
        armImage = "/arms.png";
        torsoImage = "/torso.png";
        legImage = "/legs.png";

        buttonName = "Next Patient";
    }

    void AriaFoster() {
        name = "Aria Foster";
        symptoms = new String[]{"High Grade Fever", "Headache", "Loss of Appetite", "Body Tremors",
                "Small Rashes", "Skin Abscesses", "Skin Bumps", "Swollen Limbs", "Cold Sores", "Cracked Fingernails"};
        dialogue = "Hey um yea, I have had a horrible headache and been running a pretty high fever for the last few days, haven’t been eating because of it, and I think I’ve been shaking.";

        //TODO: Change this
        characterImage = "/character.png";
        headImage = "/face.png";
        armImage = "/arms.png";
        torsoImage = "/torso.png";
        legImage = "/legs.png";

        buttonName = "Next Patient";
    }

    void FinnODonoghue() {
        name = "Finn O'Donoghue";
        symptoms = new String[]{"Confusion", "Loss of Appetite", "Body Tremors", "Headache", "Small Rashes", "Skin Bumps", "Cold Sores", "Swollen Limbs", "Cracked Fingernails", "Skin Warts"};
        dialogue = "Doc, imr feeln terble, em not hngry, and head hurts, and em shky.";

        //TODO: Change this
        characterImage = "/boar.png";
        headImage = "/face.png";
        armImage = "/arms.png";
        torsoImage = "/torso.png";
        legImage = "/legs.png";

        buttonName = "Next Patient";
    }

    void ArjunSignh() {
        name = "Arjun Signh";
        symptoms = new String[]{"Low Grade Fever", "Headache", "Loss of Appetite", "Weakness",
                "Bloody Nose", "Skin Lesions", "Swollen Limbs", "Cold Sores", "Cracked Fingernails"};
        dialogue = "Evening, sorry to be here so late but i just got off work, I’ve has a fever, a headache, and haven’t been able to really eat, and it has been making me feel rather weak.";

        //TODO: Change this
        characterImage = "/character.png";
        headImage = "/face.png";
        armImage = "/arms.png";
        torsoImage = "/torso.png";
        legImage = "/legs.png";

        buttonName = "Clock Out";
    }

}
