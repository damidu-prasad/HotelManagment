/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

public class Customer {

    private static String Name = null;
    private static String Email = null;
    private static String NIC = null;
    private static String Mobile = null;
    private static String Religion = null;
    private static String Country = null;
    private static String Address = null;
    private static String Description = null;
    private static String ReservationNo = null;

    private static String ProfilePhoto = null;
    private static String NicFront = null;
    private static String NicBack = null;

    private static Integer otherTotalPrice = 0;
    private static Integer TotalPrice = 0;

    private static Integer roomCount = 0;

    private static ArrayList<String[]> rooms = new ArrayList<String[]>();

    /**
     * @return the Name
     */
    public static String getName() {
        return Name;
    }

    /**
     * @param aName the Name to set
     */
    public static void setName(String aName) {
        Name = aName;
    }

    /**
     * @return the Email
     */
    public static String getEmail() {
        return Email;
    }

    /**
     * @param aEmail the Email to set
     */
    public static void setEmail(String aEmail) {
        Email = aEmail;
    }

    /**
     * @return the NIC
     */
    public static String getNIC() {
        return NIC;
    }

    /**
     * @param aNIC the NIC to set
     */
    public static void setNIC(String aNIC) {
        NIC = aNIC;
    }

    /**
     * @return the Mobile
     */
    public static String getMobile() {
        return Mobile;
    }

    /**
     * @param aMobile the Mobile to set
     */
    public static void setMobile(String aMobile) {
        Mobile = aMobile;
    }

    /**
     * @return the Religion
     */
    public static String getReligion() {
        return Religion;
    }

    /**
     * @param aReligion the Religion to set
     */
    public static void setReligion(String aReligion) {
        Religion = aReligion;
    }

    /**
     * @return the Country
     */
    public static String getCountry() {
        return Country;
    }

    /**
     * @param aCountry the Country to set
     */
    public static void setCountry(String aCountry) {
        Country = aCountry;
    }

    /**
     * @return the Address
     */
    public static String getAddress() {
        return Address;
    }

    /**
     * @param aAddress the Address to set
     */
    public static void setAddress(String aAddress) {
        Address = aAddress;
    }

    /**
     * @return the Description
     */
    public static String getDescription() {
        return Description;
    }

    /**
     * @param aDescription the Description to set
     */
    public static void setDescription(String aDescription) {
        Description = aDescription;
    }

    /**
     * @return the ProfilePhoto
     */
    public static String getProfilePhoto() {
        return ProfilePhoto;
    }

    /**
     * @param aProfilePhoto the ProfilePhoto to set
     */
    public static void setProfilePhoto(String aProfilePhoto) {
        ProfilePhoto = aProfilePhoto;
    }

    /**
     * @return the NicFront
     */
    public static String getNicFront() {
        return NicFront;
    }

    /**
     * @param aNicFront the NicFront to set
     */
    public static void setNicFront(String aNicFront) {
        NicFront = aNicFront;
    }

    /**
     * @return the NicBack
     */
    public static String getNicBack() {
        return NicBack;
    }

    /**
     * @param aNicBack the NicBack to set
     */
    public static void setNicBack(String aNicBack) {
        NicBack = aNicBack;
    }

    /**
     * @return the ReservationNo
     */
    public static String getReservationNo() {
        return ReservationNo;
    }

    /**
     * @param aReservationNo the ReservationNo to set
     */
    public static void setReservationNo(String aReservationNo) {
        ReservationNo = aReservationNo;
    }

    /**
     * @return the rooms
     */
    public static ArrayList<String[]> getRooms() {
        return rooms;
    }

    /**
     * @param aRooms the rooms to set
     */
    public static void setRooms(String[] aRooms) {
        rooms.add(aRooms);
        System.out.println("Str Array : " + rooms);
    }

    /**
     * @return the otherTotalPrice
     */
    public static Integer getOtherTotalPrice() {
        return otherTotalPrice;
    }

    /**
     * @param aOtherTotalPrice the otherTotalPrice to set
     */
    public static void setOtherTotalPrice(Integer aOtherTotalPrice) {
        otherTotalPrice = otherTotalPrice + aOtherTotalPrice;
    }

    /**
     * @return the TotalPrice
     */
    public static Integer getTotalPrice() {
        return TotalPrice;
    }

    /**
     * @param aTotalPrice the TotalPrice to set
     */
    public static void setTotalPrice(Integer aTotalPrice) {
        TotalPrice = TotalPrice + aTotalPrice;
    }

    /**
     * @return the roomCount
     */
    public static Integer getRoomCount() {
        return roomCount;
    }

    /**
     * @param aRoomCount the roomCount to set
     */
    public static void setRoomCount(Integer aRoomCount) {
        roomCount = aRoomCount;
    }

}
