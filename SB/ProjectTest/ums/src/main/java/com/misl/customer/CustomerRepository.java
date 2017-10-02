package com.misl.customer;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;

/**
 * Created by Mojidul on 27-Sep-17.
 */
@Repository
public class CustomerRepository implements ICustomerRepository{

    @PersistenceContext
    private EntityManager entityManager;

    public String createCustomer(Customer customer) {


        String response = null;

        String cusName = "PCUSNAME";
        String cusFatherName = "PCUSFATHERNAME";
        String cusMotherName = "PCUSMOTHERNAME";
        String cusPhone = "PCUSPHONE";
        String responseMsg = "PERROR";

        try {

            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("MY_TEST_PACKAGE.USR_CUSTOMER_INST");

            storedProcedure.registerStoredProcedureParameter(cusName, String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter(cusFatherName, String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter(cusMotherName, String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter(cusPhone, String.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter(responseMsg, String.class, ParameterMode.OUT);

            storedProcedure.setParameter(cusName, customer.getName());
            storedProcedure.setParameter(cusFatherName, customer.getFathername());
            storedProcedure.setParameter(cusMotherName, customer.getMothername());
            storedProcedure.setParameter(cusPhone, customer.getPhone());

            storedProcedure.execute();

            response = (String) storedProcedure.getOutputParameterValue(responseMsg);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }

        return response;
    }
public String editCustomer(Customer customer){

    String response = null;

    String cusNo ="PCUSID";
    String cusName = "PCUSNAME";
    String cusFatherName = "PCUSFATHERNAME";
    String cusMotherName = "PCUSMOTHERNAME";
    String cusPhone = "PCUSPHONE";
    String responseMsg = "PERROR";

    try {

        StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("MY_TEST_PACKAGE.USR_CUSTOMER_UPDA");

        storedProcedure.registerStoredProcedureParameter(cusNo, Long.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(cusName, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(cusFatherName, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(cusMotherName, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(cusPhone, String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter(responseMsg, String.class, ParameterMode.OUT);

        storedProcedure.setParameter(cusNo, customer.getId());
        storedProcedure.setParameter(cusName, customer.getName());
        storedProcedure.setParameter(cusFatherName, customer.getFathername());
        storedProcedure.setParameter(cusMotherName, customer.getMothername());
        storedProcedure.setParameter(cusPhone, customer.getPhone());

        storedProcedure.execute();

        response = (String) storedProcedure.getOutputParameterValue(responseMsg);
    } catch (Exception ex) {
        throw new RuntimeException(ex.getMessage());
    }
    return response;
}

}
