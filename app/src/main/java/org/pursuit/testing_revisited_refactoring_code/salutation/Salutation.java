package org.pursuit.testing_revisited_refactoring_code.salutation;

public class Salutation implements SalutationInterface {

    private static Salutation instance;

    /**
     * Singleton Static Factory Method to create an instance of the class, store it statically (if null), and return it to the user.
     *
     * @return Salutation instance.
     */

    public static Salutation getInstance() {
        if (instance == null) {
            instance = new Salutation();
        }
        return instance;
    }

    private Salutation() {
    }

    /**
     * This method returns the name entered by the user.
     *
     * @param name String input of full name.
     */

    @Override
    public String fullName(String name) {
        if (name == null) {
            return "";
        }
        return name;
    }

    /**
     * This method returns a String array consisting of two elements, a first name and a last name.
     *
     * @param name String input of full name.
     * @return String array of first and last name at indices 0 and 1, respectively.
     */

    @Override
    public String[] splitName(String name) {
        String first = null;
        String last = null;
        int temp = 0;

        for (int i = 0; i < name.length(); i++) {
            if (name.charAt(i) == ' ') {
                first = first == null ? name.substring(0, i) : first;
                temp = i;
            }
        }
        last = name.substring(temp + 1);

        return new String[]{first, last};


        //private static String getFirstName(String fullName) {
        //        int index = fullName.lastIndexOf(" ");
        //        if (index > -1) {
        //            return fullName.substring(0, index);
        //        }
        //        return fullName;
        //    }
        //
        //    private static String getLastName(String fullName) {
        //        int index = fullName.lastIndexOf(" ");
        //        if (index > -1) {
        //            return fullName.substring(index + 1 , fullName.length());
        //        }
        //        return "";
        //    }
    }

    /**
     * This method returns a String, the user's first name.
     *
     * @param nameArray String array consisting of first and last name values.
     * @return the String value of the user's first name.
     */

    @Override
    public String firstName(String[] nameArray) {
        String first = null;
        int temp = 0;
        if (nameArray != null) {
            first = nameArray[0];
        } else {
            return "";
        }

        return first;
    }

    /**
     * This method returns a String, the user's last name.
     *
     * @param nameArray String array consisting of first and last name values.
     * @return the String value of the user's last name.
     */

    @Override
    public String lastName(String[] nameArray) {
        return nameArray[nameArray.length - 1];
    }

    /**
     * This method returns a prefix value based on the profession - i.e. "Dr,", "Honorable", etc.
     *
     * @param profession ProfessionalDesignationEnum enum value.
     * @return the String prefix value for a particular profession.
     */

    @Override
    public String professionalPrefix(ProfessionalDesignationEnum profession) {
        if (profession == null) {
            return "";
        }

        String prefix = null;
        switch (profession) {
            case MEDICAL_DOCTOR:
                prefix = "Dr.";
                break;
            case ACADEMIC_PROFESSONAL:
                prefix = "Dr.";
                break;
            case DENTIST:
                prefix = "Dr.";
                break;
            case VETERNARIAN:
                prefix = "Dr.";
                break;
            case JUDGE:
                prefix = "Honorable";
                break;
            default:
                prefix = null;
        }

        return prefix;
    }

    /**
     * This method returns a suffix value based on the profession - i.e. "MD", "DDS", etc.
     *
     * @param profession ProfessionalDesignationEnum enum value.
     * @return the String suffix value for a particular profession.
     */

    @Override
    public String professionalSuffix(ProfessionalDesignationEnum profession) {
        if (profession == null) {
            return "";
        }

        String suffix = null;
        switch (profession) {
            case MEDICAL_DOCTOR:
                suffix = "MD";
                break;
            case LAWYER:
                suffix = "Esq.";
                break;
            case ACADEMIC_PROFESSONAL:
                suffix = "PhD";
                break;
            case DENTIST:
                suffix = "DDS";
                break;
            case CERTIFIED_PUBLIC_ACCOUNTANT:
                suffix = "CPA";
            case VETERNARIAN:
                suffix = "DVM";
                break;
            default:
                suffix = null;
        }

        return suffix;
    }

    /**
     * This method returns a boolean value based on whether the profession has a prefix.
     *
     * @param profession ProfessionalDesignationEnum enum value.
     * @return the boolean value based on the prefix value.
     */

    @Override
    public boolean hasPrefix(ProfessionalDesignationEnum profession) {
        if(profession == null){
            return false;
        }
        return professionalPrefix(profession) != null ? true : false;
    }

    /**
     * This method returns a String value for the complete professional name of a person: i.e. - "Dr. Amy Martinez, DDS.", etc.
     *
     * @param prefix     prefix String value.
     * @param splitName  String[] array of first/last name.
     * @param suffix     suffix String value.
     * @param profession ProfessionalDesignationEnum enum value.
     * @return a String value for the complete professional name of a person.
     */

    @Override
    public String professionalName(String prefix, String[] splitName, String suffix, ProfessionalDesignationEnum profession) {
        return null;
    }

    /**
     * This method returns an int value for the number of years of additional education after a bachelor's degree it takes to join a profession - i.e. Accountant: 2 years, Lawyer: 3 years, Doctor: 5 years, etc.
     *
     * @param profession ProfessionalDesignationEnum enum value.
     * @return int value for the number of years of additional education after a bachelor's degree
     */

    @Override
    public int yearsOfEducation(ProfessionalDesignationEnum profession) {
        return 0;
    }

    /**
     * This method returns a String value for a mini-biography of a professional, i.e. - "Dr. Amy Martinez, DDS. went to school for an additional 5 years to join their profession."
     *
     * @param splitName      String[] array of first/last name.
     * @param prefix         prefix String value.
     * @param suffix         suffix String value.
     * @param profession     ProfessionalDesignationEnum enum value.
     * @param educationYears int value for the number of years of additional education after a bachelor's degree
     * @param hasPrefix      the boolean value based on the prefix value.
     * @return a String value for a mini-biography of a professional
     */

    @Override
    public String careerBio(String[] splitName, String prefix, String suffix, ProfessionalDesignationEnum profession, int educationYears, boolean hasPrefix) {
        return null;
    }
}
