package org.pursuit.testing_revisited_refactoring_code;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.pursuit.testing_revisited_refactoring_code.salutation.ProfessionalDesignationEnum;
import org.pursuit.testing_revisited_refactoring_code.salutation.Salutation;

public class SalutationUnitTest {

    private Salutation salutation;
    //private ProfessionalDesignationEnum profession;

    @Before
    public void setUp() throws Exception {
        salutation = Salutation.getInstance();
    }

    @Test
    public void check_full_name_method_not_null_with_valid_input() {
        String fullName = salutation.fullName("Ron Burgundy");
        Assert.assertNotNull(fullName);
    }

    @Test
    public void check_full_name_method_not_null_with_null_input() {
        String fullName = salutation.fullName(null);
        Assert.assertNotNull(fullName);
    }

    @Test
    public void check_split_name_for_inputs_with_first_last_name() {
        String fullName = "Ron Burgundy";
        String[] firstLastName = salutation.splitName(fullName);
        Assert.assertEquals("Ron", firstLastName[0]);
        Assert.assertEquals("Burgundy", firstLastName[firstLastName.length - 1]);
    }

    @Test
    public void check_split_name_for_inputs_with_longer_names() {
        String fullName = "Ron Carlos Archibald Ferdinand Burgundy";
        String[] firstLastName = salutation.splitName(fullName);
        Assert.assertEquals("Ron", firstLastName[0]);
        Assert.assertEquals("Burgundy", firstLastName[firstLastName.length - 1]);
    }

    @Test
    public void check_split_name_for_not_null_values() {
        String fullName = "Ron Carlos Archibald Ferdinand Burgundy";
        String[] firstLastName = salutation.splitName(fullName);
        Assert.assertNotNull(firstLastName[0]);
        Assert.assertNotNull(firstLastName[firstLastName.length - 1]);
    }

    @Test
    public void check_first_name() {
        String[] fullName = {"Ron" ,"Burgundy"};
        String expected = "Ron";

        String firstName = salutation.firstName(fullName);
        Assert.assertEquals(expected, firstName);
    }

    @Test
    public void check_last_name() {
        String[] fullName = {"Ron" ,"Burgundy"};
        String expected = "Burgundy";

        String lastName = salutation.lastName(fullName);
        Assert.assertEquals(expected, lastName);
    }

    @Test
    public void check_professional_prefix_for_Dr() {
        ProfessionalDesignationEnum profession = ProfessionalDesignationEnum.MEDICAL_DOCTOR;
        String expected = "Dr.";

        String prefix = salutation.professionalPrefix(profession);
        Assert.assertEquals(expected, prefix);
    }

    @Test
    public void check_professional_prefix_for_Honorable() {
        ProfessionalDesignationEnum profession = ProfessionalDesignationEnum.JUDGE;
        String expected = "Honorable";

        String prefix = salutation.professionalPrefix(profession);
        Assert.assertEquals(expected, prefix);
    }

    @Test
    public void check_professional_prefix_for_Null_prefix() {
        ProfessionalDesignationEnum profession = ProfessionalDesignationEnum.CERTIFIED_PUBLIC_ACCOUNTANT;
        String expected = null;

        String prefix = salutation.professionalPrefix(profession);
        Assert.assertEquals(expected, prefix);
    }

    @Test
    public void check_professional_prefix_for_Null_value() {
        ProfessionalDesignationEnum profession = null;
        String expected = "";

        String prefix = salutation.professionalPrefix(profession);
        Assert.assertEquals(expected, prefix);
    }

    @Test
    public void check_professional_suffix_for_MD() {
        ProfessionalDesignationEnum profession = ProfessionalDesignationEnum.MEDICAL_DOCTOR;
        String expected = "MD";

        String prefix = salutation.professionalSuffix(profession);
        Assert.assertEquals(expected, prefix);
    }

    @Test
    public void check_professional_suffix_for_PhD() {
        ProfessionalDesignationEnum profession = ProfessionalDesignationEnum.ACADEMIC_PROFESSONAL;
        String expected = "PhD";

        String prefix = salutation.professionalSuffix(profession);
        Assert.assertEquals(expected, prefix);
    }

    @Test
    public void check_professional_suffix_for_Null_value() {
        ProfessionalDesignationEnum profession = null;
        String expected = "";

        String prefix = salutation.professionalSuffix(profession);
        Assert.assertEquals(expected, prefix);
    }

    @Test
    public void check_has_prefix() {
        ProfessionalDesignationEnum profession = ProfessionalDesignationEnum.ACADEMIC_PROFESSONAL;
        boolean expected = true;

        boolean prefix = salutation.hasPrefix(profession);
        Assert.assertEquals(expected, prefix);
    }

    @Test
    public void check_has_prefix_with_null_value() {
        ProfessionalDesignationEnum profession = null;
        boolean expected = false;

        boolean prefix = salutation.hasPrefix(profession);
        Assert.assertEquals(expected, prefix);
    }

    @After
    public void tearDown() throws Exception {
        salutation = null;
    }
}
