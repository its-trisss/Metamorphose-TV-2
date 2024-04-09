package tv2.metamorphose;

public class Patients {

    String patient;
    String[] symptoms;

    String dialogue;

    Patients (int day, int patientNum) {
        String[] namesDay1 = {"Lena Rosario", "Miles Johnson", "Aria Foster", "Finn O'Donoghue", "Arjun Signh"};
        String[] namesDay2 = {"Raj Patel", "Alexa Knight", "Zara Indigo", "Ivy Sterling", "Jade Li"};
        String[] namesDay3 = {"Max Harper", "Sophia Martinez", "Theo Barnnet", "Serena Vega", "Elana Rivera"};

        switch (day) {
            case 1:
                patient = namesDay1[patientNum];

                switch (patient) {
                    case "Lena Rosario":
                        symptoms = new String[]{"Low Grade Fever", "Headache", "Loss of Appetite", "Body Tremors",
                        "Confusion", "Small Rashes", "Skin Warts", "Skin Bumps", "Swollen Limbs", "Large Skin Lesions"};
                        break;
                }

                break;
            case 2:
                patient = namesDay2[patientNum];
                break;
            case 3:
                patient = namesDay3[patientNum];
                break;
        }



    }

    String GetPatientName() {
        return patient;
    }

    String[] GetSymptoms() {
        return symptoms;
    }

    String GetDialogue() {
        return dialogue;
    }

}
