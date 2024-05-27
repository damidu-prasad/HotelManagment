/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author mlahi
 */
public class room  {
   private String RoomType = null;
   private String RoomService = null;
   private String AditionalService = null;
   private String Checkin = null;
   private String CheckOut = null;

    /**
     * @return the RoomType
     */
    public String getRoomType() {
        return RoomType;
    }

    /**
     * @param RoomType the RoomType to set
     */
    public void setRoomType(String RoomType) {
        this.RoomType = RoomType;
    }

    /**
     * @return the RoomService
     */
    public String getRoomService() {
        return RoomService;
    }

    /**
     * @param RoomService the RoomService to set
     */
    public void setRoomService(String RoomService) {
        this.RoomService = RoomService;
    }

    /**
     * @return the AditionalService
     */
    public String getAditionalService() {
        return AditionalService;
    }

    /**
     * @param AditionalService the AditionalService to set
     */
    public void setAditionalService(String AditionalService) {
        this.AditionalService = AditionalService;
    }

    /**
     * @return the Checkin
     */
    public String getCheckin() {
        return Checkin;
    }

    /**
     * @param Checkin the Checkin to set
     */
    public void setCheckin(String Checkin) {
        this.Checkin = Checkin;
    }

    /**
     * @return the CheckOut
     */
    public String getCheckOut() {
        return CheckOut;
    }

    /**
     * @param CheckOut the CheckOut to set
     */
    public void setCheckOut(String CheckOut) {
        this.CheckOut = CheckOut;
    }
   
    @Override
    public String toString(){
         return "Room{"
                + "RoomType='" + RoomType + '\''
                + ", RoomService='" + RoomService + '\''
                + ", Additional='" + AditionalService + '\''
                + ", Checkin='" + Checkin + '\''
                + ", CheckOut='" + CheckOut + '\''
                + '}';
    }
    
   

}
