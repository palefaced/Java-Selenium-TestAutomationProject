package Utils.models;

import java.util.List;

public class RegistrationUser {
    private String testCaseID;
    private String firstName;
    private String lastName;
    private String email;
    private List<Boolean> genders;
    private String phoneNumber;
    private String birthDay;
    private String birthMonth;
    private String birthYear;
    private String subject;
    private List<Boolean> hobbies;
    private String picture;
    private String address;
    private String state;
    private String city;

    public String getFirstName(){
        return this.firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public String getEmail(){
        return this.email;
    }
    public List<Boolean> getGenders(){
        return this.genders;
    }
    public String getPhoneNumber(){
        return this.phoneNumber;
    }
    public String getBirthDay(){
        return this.birthDay;
    }
    public String getBirthMonth(){
        return this.birthMonth;
    }
    public String getBirthYear(){
        return this.birthYear;
    }
    public String getSubject(){
        return this.subject;
    }
    public List<Boolean> getHobbies(){
        return this.hobbies;
    }
    public String getPicture(){
        return this.picture;
    }
    public String getAddress(){
        return this.address;
    }
    public String getState(){
        return this.state;
    }
    public String getCity(){
        return this.city;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGenders(List<Boolean> genders){
        this.genders = genders;
    }

    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setBirthMonth(String birthMonth) {
        this.birthMonth = birthMonth;
    }

    public void setBirthYear(String birthYear){
        this.birthYear = birthYear;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
    public void setHobbies(List<Boolean> hobbies){
        this.hobbies = hobbies;
    }

    public void setPicture(String picture){
        this.picture = picture;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public void setState(String state){
        this.state = state;
    }

    public void setCity(String city){
        this.city = city;
    }

    public String getTestCaseID() {
        return testCaseID;
    }

    public void setTestCaseID(String testCaseID) {
        this.testCaseID = testCaseID;
    }
}
