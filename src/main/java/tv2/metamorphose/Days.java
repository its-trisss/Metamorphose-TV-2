package tv2.metamorphose;

public class Days {
    String name = "";

    String buttonName = "";
    String dialogue = "";
    String[] symptoms = {""};

    String characterImage = "";
    String armImage = "";
    String headImage = "";
    String torsoImage = "";
    String legImage = "";


    Days(int day, int patientNum) {
        if (day == 1) {
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

        }
        else if(patientNum == 4) {

        }
        else if (patientNum == 5){

        }


    }

    void Day2(int patientNum) {

    }

    void Day3(int patientNum) {

    }

    void LenaRosario() {
        name = "Lena Rosario";
        symptoms = new String[]{"Low Grade Fever", "Headache", "Loss of Appetite", "Body Tremors", "Confusion",
                "Small Rashes", "Skin Warts", "Skin Bumps", "Swollen Limbs", "Large Skin Lesion"};
        dialogue = "Good morning! Sorry to bother you today, but I have had a low grade fever I think for the last few days, it's hard to remember how long its been. I’ve had a horrible headache, I haven’t been eating and I feel like my body is shaking a lot";

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
        symptoms = new String[]{"Confusion", "Loss of Appetite", "Low Grade Fever", "Headache", "Small Rashes", "Skin Bumps", "Cold Sores", "Swelling Limbs", "Cracked Fingernails", "Skin Abscesses"};
        dialogue = "Hey doc, I have not been eatin’ well, and I’ve had a pretty mild headache, but honestly I couldn’t tell you how long though it's kinda hard to remember.";

        //TODO: Change this
        characterImage = "/boar.png";
        headImage = "/face.png";
        armImage = "/arms.png";
        torsoImage = "/torso.png";
        legImage = "/legs.png";

        buttonName = "Next Patient";
    }



}
