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
    public void check_professional_prefix() {
        ProfessionalDesignationEnum profession = "Ron" ,"Burgundy";
        String expected = "Burgundy";

        String lastName = salutation.lastName(fullName);
        Assert.assertEquals(expected, lastName);
    }

//    @Test
//    public void check_first_name_for_null_values() {
//        String[] splitName = new String[]{null, "Burgundy"};
//        String firstName = splitName[0];
//        Assert.assertNotNull(salutation.firstName(splitName));
//    }
//
//    @Test (expected = ArrayIndexOutOfBoundsException.class)
//    public void check_last_name_for_null_values() {
//        String[] splitName = new String[]{"Ron", null};
//        String lastName = splitName[splitName.length - 1];
//        Assert.assertNotNull(salutation.lastName(splitName), lastName);
//    }

    @After
    public void tearDown() throws Exception {
        salutation = null;
    }
}
