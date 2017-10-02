package com.misl.customer;

import org.apache.tomcat.jdbc.pool.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.ParameterMode;
import javax.persistence.PersistenceContext;
import javax.persistence.StoredProcedureQuery;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Mojidul on 27-Sep-17.
 */
@Repository
public class CustomerRepository implements ICustomerRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    DataSource dataSource;

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

    @Override
    public String deleteCustomer(long id) {

        String response = null;

        String cusNo ="PCUSID";
        String responseMsg = "PERROR";
        try {

            StoredProcedureQuery storedProcedure = entityManager.createStoredProcedureQuery("MY_TEST_PACKAGE.USR_CUSTOMER_DELE");

            storedProcedure.registerStoredProcedureParameter(cusNo, Long.class, ParameterMode.IN);
            storedProcedure.registerStoredProcedureParameter(responseMsg, String.class, ParameterMode.OUT);

            storedProcedure.setParameter(cusNo, id);

            storedProcedure.execute();

            response = (String) storedProcedure.getOutputParameterValue(responseMsg);
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return response;
    }

    @Override
    public Customer getCustomerById(long id) {
        Customer customer=new Customer();

        try {
            CallableStatement cs = dataSource.getConnection().prepareCall("{call MY_TEST_PACKAGE.GET_CUSTOMER_BY_ID(?,?)}");
            cs.setLong(1,id);
            cs.registerOutParameter(2, -10);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(2);
            while (rs.next()){
                customer.setId(rs.getInt("CUSID"));
                customer.setName(rs.getString("CUSNAME"));
                customer.setFathername(rs.getString("CUSFATHERNAME"));
                customer.setMothername(rs.getString("CUSMOTHERNAME"));
                customer.setPhone(rs.getString("CUSPHONE"));
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return customer;
    }

    @Override
    public List<Customer> getAllCustomer() {
        ArrayList<Customer> allCustomer = new ArrayList<Customer>();
        try {
            CallableStatement cs = dataSource.getConnection().prepareCall("{call MY_TEST_PACKAGE.GET_ALL_CUSTOMERS(?)}");
            cs.registerOutParameter(1, -10);
            cs.execute();
            ResultSet rs = (ResultSet)cs.getObject(1);
            while (rs.next()){
                Customer customer = new Customer();
                customer.setId(rs.getInt("CUSID"));
                customer.setName(rs.getString("CUSNAME"));
                customer.setFathername(rs.getString("CUSFATHERNAME"));
                customer.setMothername(rs.getString("CUSMOTHERNAME"));
                customer.setPhone(rs.getString("CUSPHONE"));
                allCustomer.add(customer);

            }
        } catch (Exception ex) {
            throw new RuntimeException(ex.getMessage());
        }
        return allCustomer;
    }

}
