package utp.alumno.app.model;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
	
    private int id;
    private Company company;
    private PaymentsType paymentsType;
    private String cardNumber;
    private String name;
    private String lastName;
    private String firstAddress;
    private String secondAddress;
    private Timestamp paymentDate;
    private String location;
    private String country;
    private String codeZip;
    private String cellPhoneNumber;
    private float amount;
    private int expiryMonth;
    private int expiryDay;
    private int securityCode;

    public String getCardNumberAsValue() {return "'" + getCardNumber() + "'"; }
    public String getIdAsString() { return String.valueOf(getId());  }
    public String getNameAsValue() {return "'" + getName() + "'"; }
    public String getLastNameAsValue() {return "'" + getLastName() + "'"; }


    public String getFirstAddressAsValue(){return "'"+ getFirstAddress()+"'";}
    public String getSecondAddressAsValue(){return"'"+ getSecondAddress()+"'";}


    public String getDateAsValue()
    {return "'"+String.valueOf(getPaymentDate())+"'";}

    public String getLocationAsValue(){return "'"+getLocation()+"'";}
    public String getCountryAsValue(){return "'"+getCountry()+"'";}
    public String getCodeZipAsValue(){return "'"+getCodeZip()+"'";}
    public String getCellPhoneNumberAsValue(){return "'"+getCellPhoneNumber()+"'";}
    public String getAmountAsValue(){return String.valueOf(getAmount());}
    public String getExpiryMonthAsString() { return String.valueOf(getExpiryMonth());  }
    public String getExpiryDayAsString() { return String.valueOf(getExpiryDay());  }
    public String getSecurityCodeAsString() { return String.valueOf(getSecurityCode());  }



    /*public static Payment build(ResultSet rs,CompaniesEntity companiesEntity,PaymentsTypesEntity paymentsTypesEntity
            ,EmailAddressesEntity emailAddressesEntity ) {

        try {
            return (new Payment())
                    .setId(rs.getInt("id"))
                    .setCompany(companiesEntity.findById(rs.getInt("id_companies"), emailAddressesEntity))
                    .setPaymentsType(paymentsTypesEntity.findById(rs.getInt("id_payment_type")))
                    .setCardNumber(rs.getString("card_number"))
                    .setName(rs.getString("name"))
                    .setLastName(rs.getString("last_name"))
                    .setFirstAddress(rs.getString("first_address"))
                    .setSecondAddress(rs.getString("second_address"))
                    .setPaymentDate(rs.getTimestamp("payment_date_and_time"))
                    .setLocation(rs.getString("location"))
                    .setCountry(rs.getString("country"))
                    .setCodeZip(rs.getString("code_zip"))
                    .setCellPhoneNumber(rs.getString("cell_phone_number"))
                    .setAmount(rs.getFloat("payment_amount"))
                    .setExpiryMonth(rs.getInt("expiry_month"))
                    .setExpiryDay(rs.getInt("expiry_day"))
                    .setSecurityCode(rs.getInt("security_code"))
                    ;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }*/



}