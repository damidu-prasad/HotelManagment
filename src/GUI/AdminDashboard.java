/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import GUI.UserManagement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;
import javax.swing.Timer;
import javax.swing.table.DefaultTableModel;
import model.MYSQL;

/**
 *
 * @author DELL
 */
public class AdminDashboard extends javax.swing.JFrame {

    /**
     * Creates new form adminDashboard
     */
    public AdminDashboard() {
        initComponents();
        setTodayDate();
        setTime();
        cards();
        loadEvents();
        loadInventory(); 
        loadRooms(); 
        loadFoodMenu();
    }

    public void setTodayDate() {

        // Get the current date
        Date today = new Date();

        // Format the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        // Set the formatted date to the label
        labelDate.setText(dateFormat.format(today));
    }

    public void setTime() {
        // Get the current time
        Date now = new Date();

        // Format the time
        SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm");

        // Set the formatted time to the label
        labelTime.setText(timeFormat.format(now));
    }

    private void cards() {
        try {
            // Fetch address
            String today = labelDate.getText();
            ResultSet revenueResultSet = MYSQL.execute("SELECT SUM(recieved_amount) AS total_received_amount FROM recieved_payment WHERE recieved_date = '" + today + "'");
            if (revenueResultSet.next()) {
                // Use the correct column name "total_received_amount" instead of "revenue"
                int totalReceivedAmount = revenueResultSet.getInt("total_received_amount");
                labelRevenue.setText(String.valueOf(totalReceivedAmount));
            }

            // Fetch guest count
            ResultSet guestResultSet = MYSQL.execute("SELECT COUNT(*) AS total FROM reservation_customer WHERE status='1'");
            if (guestResultSet.next()) {
                // Use getInt() to retrieve the integer value from the ResultSet
                int guestCount = guestResultSet.getInt("total");
                // Set the guest count to labelGuestsCount
                labelGuestsCount.setText(String.valueOf(guestCount));
            }

            // Fetch staff count
            ResultSet staffResultSet = MYSQL.execute("SELECT COUNT(*) AS total FROM user WHERE status_id='1'");
            if (staffResultSet.next()) {
                // Use getInt() to retrieve the integer value from the ResultSet
                int staffCount = staffResultSet.getInt("total");
                // Set the staff count to labelActiveStaff
                labelStaffCount.setText(String.valueOf(staffCount));
            }

            // Fetch available room count
            ResultSet availableResultSet = MYSQL.execute("SELECT COUNT(*) AS total FROM room WHERE status='1'");
            if (availableResultSet.next()) {
                // Use getInt() to retrieve the integer value from the ResultSet
                int availableCount = availableResultSet.getInt("total");
                // Set the available room count to labelRoomCount
                labelRoomCount.setText(String.valueOf(availableCount));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadEvents() {
        try {
            //search user table from database
            ResultSet resultSet = MYSQL.execute("SELECT * FROM `special_event`");

            //load data to table
            DefaultTableModel model = (DefaultTableModel) jTableEvent.getModel();
            model.setRowCount(0);

            //get data to table
            while (resultSet.next()) {
                Vector<String> vector1 = new Vector();

                vector1.add(resultSet.getString("date"));
                vector1.add(resultSet.getString("description"));

                model.addRow(vector1);
                jTableEvent.setModel(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
     private void loadInventory() {
        try {
            //search user table from database
            ResultSet resultSet = MYSQL.execute("SELECT * FROM `inventory`");

            //load data to table
            DefaultTableModel model = (DefaultTableModel) jTableInventry.getModel();
            model.setRowCount(0);

            //get data to table
            while (resultSet.next()) {
                Vector<String> vector1 = new Vector();

                vector1.add(resultSet.getString("description"));
                vector1.add(resultSet.getString("qty"));

                model.addRow(vector1);
                jTableInventry.setModel(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 
     
     private void loadRooms() {
        try {
            //search user table from database
            ResultSet resultSet = MYSQL.execute("SELECT `room_id`,`room_price` FROM `room` ; ");

            //load data to table
            DefaultTableModel model = (DefaultTableModel) jTableRooms.getModel();
            model.setRowCount(0);

            //get data to table
            while (resultSet.next()) {
                Vector<String> vector1 = new Vector();

                vector1.add(resultSet.getString("room_id"));
                vector1.add(resultSet.getString("room_price"));

                model.addRow(vector1);
                jTableRooms.setModel(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
     
    private void loadFoodMenu() {
        try {
            //search user table from database
            ResultSet resultSet = MYSQL.execute("SELECT `title`,`price` FROM `menu`");

            //load data to table
            DefaultTableModel model = (DefaultTableModel) jTableFoodMenu.getModel();
            model.setRowCount(0);

            //get data to table
            while (resultSet.next()) {
                Vector<String> vector1 = new Vector();

                vector1.add(resultSet.getString("title"));
                vector1.add(resultSet.getString("price"));

                model.addRow(vector1);
                jTableFoodMenu.setModel(model);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    } 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenu = new javax.swing.JPanel();
        jLabelLogo = new javax.swing.JLabel();
        jLabelUserManagement = new javax.swing.JLabel();
        jLabelSystemconfiguration = new javax.swing.JLabel();
        jLabelLogsAudit = new javax.swing.JLabel();
        jLabelLogOut = new javax.swing.JLabel();
        jPanelCurrent = new javax.swing.JPanel();
        jLabelDashboard = new javax.swing.JLabel();
        jPaneluser = new javax.swing.JPanel();
        jLabelUseImg = new javax.swing.JLabel();
        jLabelId = new javax.swing.JLabel();
        jLabelUserName = new javax.swing.JLabel();
        jLabelUserId = new javax.swing.JLabel();
        jLabelName = new javax.swing.JLabel();
        jPanelScreen = new javax.swing.JPanel();
        labelWelcom = new java.awt.Label();
        labelAdminName = new java.awt.Label();
        labelTime = new java.awt.Label();
        labelDate = new java.awt.Label();
        jPanelCardRevenue = new javax.swing.JPanel();
        labelTodayRevenue = new java.awt.Label();
        jSeparatorLine = new javax.swing.JSeparator();
        labelRevenue = new java.awt.Label();
        jPanelGuests = new javax.swing.JPanel();
        labelCheckedIn = new java.awt.Label();
        jSeparatorLine3 = new javax.swing.JSeparator();
        labelGuestsCount = new java.awt.Label();
        jPanelStaff = new javax.swing.JPanel();
        labelActiveStaff = new java.awt.Label();
        jSeparatorLine4 = new javax.swing.JSeparator();
        labelStaffCount = new java.awt.Label();
        jPanelRooms = new javax.swing.JPanel();
        labelAvailable = new java.awt.Label();
        jSeparatorLine5 = new javax.swing.JSeparator();
        labelRoomCount = new java.awt.Label();
        labelOf = new java.awt.Label();
        label100 = new java.awt.Label();
        jPanelEventCalender = new javax.swing.JPanel();
        labelSpecialEvents = new java.awt.Label();
        jSeparatorLine6 = new javax.swing.JSeparator();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTableEvent = new javax.swing.JTable();
        jPanelHousekeeping = new javax.swing.JPanel();
        labelInventory = new java.awt.Label();
        jSeparatorLine7 = new javax.swing.JSeparator();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTableInventry = new javax.swing.JTable();
        jPanelRoomProcing = new javax.swing.JPanel();
        labelPricing = new java.awt.Label();
        jSeparatorLine9 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTableRooms = new javax.swing.JTable();
        jPanelRoomProcing1 = new javax.swing.JPanel();
        labelPricing1 = new java.awt.Label();
        jSeparatorLine10 = new javax.swing.JSeparator();
        jScrollPane5 = new javax.swing.JScrollPane();
        jTableFoodMenu = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanelMenu.setBackground(new java.awt.Color(83, 66, 54));
        jPanelMenu.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPanelMenu.setPreferredSize(new java.awt.Dimension(200, 500));

        jLabelLogo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/logo.png"))); // NOI18N

        jLabelUserManagement.setBackground(new java.awt.Color(83, 66, 54));
        jLabelUserManagement.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabelUserManagement.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUserManagement.setText("User Management ");
        jLabelUserManagement.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelUserManagement.setNextFocusableComponent(jLabelUserManagement);
        jLabelUserManagement.setPreferredSize(null);
        jLabelUserManagement.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelUserManagementMouseClicked(evt);
            }
        });

        jLabelSystemconfiguration.setBackground(new java.awt.Color(83, 66, 54));
        jLabelSystemconfiguration.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabelSystemconfiguration.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSystemconfiguration.setText("System Configuration");
        jLabelSystemconfiguration.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelSystemconfiguration.setPreferredSize(null);
        jLabelSystemconfiguration.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelSystemconfigurationMouseClicked(evt);
            }
        });

        jLabelLogsAudit.setBackground(new java.awt.Color(83, 66, 54));
        jLabelLogsAudit.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabelLogsAudit.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogsAudit.setText("Logs/Audit Trails");
        jLabelLogsAudit.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLogsAudit.setPreferredSize(null);
        jLabelLogsAudit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelLogsAuditMouseClicked(evt);
            }
        });

        jLabelLogOut.setBackground(new java.awt.Color(83, 66, 54));
        jLabelLogOut.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabelLogOut.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelLogOut.setText("Log Out");
        jLabelLogOut.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelLogOut.setPreferredSize(null);

        jPanelCurrent.setBackground(new java.awt.Color(255, 255, 255));
        jPanelCurrent.setPreferredSize(new java.awt.Dimension(199, 32));

        jLabelDashboard.setBackground(new java.awt.Color(255, 255, 255));
        jLabelDashboard.setFont(new java.awt.Font("SansSerif", 0, 20)); // NOI18N
        jLabelDashboard.setForeground(new java.awt.Color(83, 66, 54));
        jLabelDashboard.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelDashboard.setText("Dashboard");
        jLabelDashboard.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPanelCurrentLayout = new javax.swing.GroupLayout(jPanelCurrent);
        jPanelCurrent.setLayout(jPanelCurrentLayout);
        jPanelCurrentLayout.setHorizontalGroup(
            jPanelCurrentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDashboard, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
        );
        jPanelCurrentLayout.setVerticalGroup(
            jPanelCurrentLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelDashboard, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 32, Short.MAX_VALUE)
        );

        jPaneluser.setBackground(new java.awt.Color(83, 66, 54));
        jPaneluser.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jPaneluser.setPreferredSize(new java.awt.Dimension(199, 72));

        jLabelUseImg.setBackground(new java.awt.Color(83, 66, 54));
        jLabelUseImg.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/user.png"))); // NOI18N

        jLabelId.setBackground(new java.awt.Color(83, 66, 54));
        jLabelId.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabelId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelId.setText("ID     : ");
        jLabelId.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelUserName.setBackground(new java.awt.Color(83, 66, 54));
        jLabelUserName.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabelUserName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUserName.setText("Shehara");
        jLabelUserName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelUserId.setBackground(new java.awt.Color(83, 66, 54));
        jLabelUserId.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabelUserId.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelUserId.setText("RS0001");
        jLabelUserId.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabelName.setBackground(new java.awt.Color(83, 66, 54));
        jLabelName.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jLabelName.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelName.setText("Name:");
        jLabelName.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        javax.swing.GroupLayout jPaneluserLayout = new javax.swing.GroupLayout(jPaneluser);
        jPaneluser.setLayout(jPaneluserLayout);
        jPaneluserLayout.setHorizontalGroup(
            jPaneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneluserLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jLabelUseImg)
                .addGap(10, 10, 10)
                .addGroup(jPaneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPaneluserLayout.createSequentialGroup()
                        .addComponent(jLabelId)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelUserId))
                    .addGroup(jPaneluserLayout.createSequentialGroup()
                        .addComponent(jLabelName)
                        .addGap(3, 3, 3)
                        .addComponent(jLabelUserName)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPaneluserLayout.setVerticalGroup(
            jPaneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPaneluserLayout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addGroup(jPaneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelUseImg)
                    .addGroup(jPaneluserLayout.createSequentialGroup()
                        .addGroup(jPaneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelId, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabelUserId))
                        .addGap(4, 4, 4)
                        .addGroup(jPaneluserLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelName)
                            .addComponent(jLabelUserName)))))
        );

        javax.swing.GroupLayout jPanelMenuLayout = new javax.swing.GroupLayout(jPanelMenu);
        jPanelMenu.setLayout(jPanelMenuLayout);
        jPanelMenuLayout.setHorizontalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabelLogo))
                    .addComponent(jPanelCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPaneluser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(jLabelUserManagement, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(jLabelSystemconfiguration, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(jLabelLogOut, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                        .addComponent(jLabelLogsAudit, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMenuLayout.setVerticalGroup(
            jPanelMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuLayout.createSequentialGroup()
                .addComponent(jLabelLogo)
                .addGap(30, 30, 30)
                .addComponent(jPanelCurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addComponent(jLabelUserManagement, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabelSystemconfiguration, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addComponent(jLabelLogsAudit, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addComponent(jLabelLogOut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPaneluser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jPanelMenu, java.awt.BorderLayout.LINE_START);

        jPanelScreen.setBackground(new java.awt.Color(255, 255, 255));

        labelWelcom.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelWelcom.setFont(new java.awt.Font("SansSerif", 3, 25)); // NOI18N
        labelWelcom.setForeground(new java.awt.Color(83, 66, 64));
        labelWelcom.setText("Shehara!");

        labelAdminName.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelAdminName.setFont(new java.awt.Font("SansSerif", 1, 25)); // NOI18N
        labelAdminName.setForeground(new java.awt.Color(83, 66, 64));
        labelAdminName.setText("Welcome");

        labelTime.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelTime.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelTime.setForeground(new java.awt.Color(83, 66, 64));
        labelTime.setText("09:10AM");

        labelDate.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelDate.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelDate.setForeground(new java.awt.Color(83, 66, 64));
        labelDate.setText("2024.05.12");

        jPanelCardRevenue.setBackground(new java.awt.Color(199, 189, 177));
        jPanelCardRevenue.setPreferredSize(new java.awt.Dimension(140, 95));

        labelTodayRevenue.setAlignment(java.awt.Label.CENTER);
        labelTodayRevenue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelTodayRevenue.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelTodayRevenue.setForeground(new java.awt.Color(83, 66, 64));
        labelTodayRevenue.setText("Today's Revenue");

        jSeparatorLine.setBackground(new java.awt.Color(199, 189, 177));
        jSeparatorLine.setForeground(new java.awt.Color(221, 217, 214));
        jSeparatorLine.setName(""); // NOI18N
        jSeparatorLine.setPreferredSize(new java.awt.Dimension(120, 2));

        labelRevenue.setAlignment(java.awt.Label.CENTER);
        labelRevenue.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelRevenue.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        labelRevenue.setForeground(new java.awt.Color(155, 117, 1));
        labelRevenue.setName(""); // NOI18N
        labelRevenue.setText("Rs.");

        javax.swing.GroupLayout jPanelCardRevenueLayout = new javax.swing.GroupLayout(jPanelCardRevenue);
        jPanelCardRevenue.setLayout(jPanelCardRevenueLayout);
        jPanelCardRevenueLayout.setHorizontalGroup(
            jPanelCardRevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelTodayRevenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelCardRevenueLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparatorLine, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(labelRevenue, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelCardRevenueLayout.setVerticalGroup(
            jPanelCardRevenueLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCardRevenueLayout.createSequentialGroup()
                .addComponent(labelTodayRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparatorLine, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelRevenue, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jSeparatorLine.getAccessibleContext().setAccessibleDescription("");

        jPanelGuests.setBackground(new java.awt.Color(199, 189, 177));
        jPanelGuests.setPreferredSize(new java.awt.Dimension(149, 83));

        labelCheckedIn.setAlignment(java.awt.Label.CENTER);
        labelCheckedIn.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelCheckedIn.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelCheckedIn.setForeground(new java.awt.Color(83, 66, 64));
        labelCheckedIn.setText("Guests Checked-in");

        jSeparatorLine3.setBackground(new java.awt.Color(199, 189, 177));
        jSeparatorLine3.setForeground(new java.awt.Color(221, 217, 214));
        jSeparatorLine3.setPreferredSize(new java.awt.Dimension(120, 2));

        labelGuestsCount.setAlignment(java.awt.Label.CENTER);
        labelGuestsCount.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelGuestsCount.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        labelGuestsCount.setForeground(new java.awt.Color(155, 117, 1));
        labelGuestsCount.setName(""); // NOI18N
        labelGuestsCount.setText("70");

        javax.swing.GroupLayout jPanelGuestsLayout = new javax.swing.GroupLayout(jPanelGuests);
        jPanelGuests.setLayout(jPanelGuestsLayout);
        jPanelGuestsLayout.setHorizontalGroup(
            jPanelGuestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelCheckedIn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelGuestsLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparatorLine3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(labelGuestsCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelGuestsLayout.setVerticalGroup(
            jPanelGuestsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelGuestsLayout.createSequentialGroup()
                .addComponent(labelCheckedIn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparatorLine3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelGuestsCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelStaff.setBackground(new java.awt.Color(199, 189, 177));
        jPanelStaff.setPreferredSize(new java.awt.Dimension(120, 83));

        labelActiveStaff.setAlignment(java.awt.Label.CENTER);
        labelActiveStaff.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelActiveStaff.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelActiveStaff.setForeground(new java.awt.Color(83, 66, 64));
        labelActiveStaff.setText("Active Staff");

        jSeparatorLine4.setBackground(new java.awt.Color(199, 189, 177));
        jSeparatorLine4.setForeground(new java.awt.Color(221, 217, 214));
        jSeparatorLine4.setPreferredSize(new java.awt.Dimension(120, 2));

        labelStaffCount.setAlignment(java.awt.Label.CENTER);
        labelStaffCount.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelStaffCount.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        labelStaffCount.setForeground(new java.awt.Color(155, 117, 1));
        labelStaffCount.setName(""); // NOI18N
        labelStaffCount.setText("89");

        javax.swing.GroupLayout jPanelStaffLayout = new javax.swing.GroupLayout(jPanelStaff);
        jPanelStaff.setLayout(jPanelStaffLayout);
        jPanelStaffLayout.setHorizontalGroup(
            jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelActiveStaff, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelStaffLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparatorLine4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(labelStaffCount, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanelStaffLayout.setVerticalGroup(
            jPanelStaffLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelStaffLayout.createSequentialGroup()
                .addComponent(labelActiveStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparatorLine4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelStaffCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanelRooms.setBackground(new java.awt.Color(199, 189, 177));
        jPanelRooms.setPreferredSize(new java.awt.Dimension(137, 83));

        labelAvailable.setAlignment(java.awt.Label.CENTER);
        labelAvailable.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelAvailable.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelAvailable.setForeground(new java.awt.Color(83, 66, 64));
        labelAvailable.setPreferredSize(new java.awt.Dimension(120, 24));
        labelAvailable.setText("Available Rooms");

        jSeparatorLine5.setBackground(new java.awt.Color(199, 189, 177));
        jSeparatorLine5.setForeground(new java.awt.Color(221, 217, 214));
        jSeparatorLine5.setPreferredSize(new java.awt.Dimension(115, 2));

        labelRoomCount.setAlignment(java.awt.Label.CENTER);
        labelRoomCount.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelRoomCount.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        labelRoomCount.setForeground(new java.awt.Color(155, 117, 1));
        labelRoomCount.setName(""); // NOI18N
        labelRoomCount.setText("16");

        labelOf.setAlignment(java.awt.Label.RIGHT);
        labelOf.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelOf.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelOf.setForeground(new java.awt.Color(155, 117, 1));
        labelOf.setName(""); // NOI18N
        labelOf.setText("of");

        label100.setAlignment(java.awt.Label.CENTER);
        label100.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        label100.setFont(new java.awt.Font("SansSerif", 1, 20)); // NOI18N
        label100.setForeground(new java.awt.Color(155, 117, 1));
        label100.setName(""); // NOI18N
        label100.setText("100");

        javax.swing.GroupLayout jPanelRoomsLayout = new javax.swing.GroupLayout(jPanelRooms);
        jPanelRooms.setLayout(jPanelRoomsLayout);
        jPanelRoomsLayout.setHorizontalGroup(
            jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelAvailable, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelRoomsLayout.createSequentialGroup()
                .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelRoomsLayout.createSequentialGroup()
                        .addContainerGap(27, Short.MAX_VALUE)
                        .addComponent(labelRoomCount, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelOf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(label100, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanelRoomsLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jSeparatorLine5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanelRoomsLayout.setVerticalGroup(
            jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRoomsLayout.createSequentialGroup()
                .addComponent(labelAvailable, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparatorLine5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelRoomsLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelRoomCount, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelOf, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(label100, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanelEventCalender.setBackground(new java.awt.Color(199, 189, 177));

        labelSpecialEvents.setAlignment(java.awt.Label.CENTER);
        labelSpecialEvents.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelSpecialEvents.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelSpecialEvents.setForeground(new java.awt.Color(83, 66, 64));
        labelSpecialEvents.setText("Monthly Special Events ");

        jSeparatorLine6.setBackground(new java.awt.Color(199, 189, 177));
        jSeparatorLine6.setForeground(new java.awt.Color(221, 217, 214));
        jSeparatorLine6.setName(""); // NOI18N
        jSeparatorLine6.setPreferredSize(new java.awt.Dimension(120, 2));

        jScrollPane2.setBackground(new java.awt.Color(83, 66, 54));
        jScrollPane2.setAutoscrolls(true);

        jTableEvent.setAutoCreateRowSorter(true);
        jTableEvent.setBackground(new java.awt.Color(199, 189, 177));
        jTableEvent.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableEvent.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jTableEvent.setForeground(new java.awt.Color(83, 66, 54));
        jTableEvent.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Time", "Event"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableEvent.setGridColor(new java.awt.Color(255, 255, 255));
        jTableEvent.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTableEvent.setSelectionForeground(new java.awt.Color(155, 117, 1));
        jTableEvent.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(jTableEvent);

        javax.swing.GroupLayout jPanelEventCalenderLayout = new javax.swing.GroupLayout(jPanelEventCalender);
        jPanelEventCalender.setLayout(jPanelEventCalenderLayout);
        jPanelEventCalenderLayout.setHorizontalGroup(
            jPanelEventCalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelSpecialEvents, javax.swing.GroupLayout.DEFAULT_SIZE, 287, Short.MAX_VALUE)
            .addGroup(jPanelEventCalenderLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelEventCalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparatorLine6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelEventCalenderLayout.setVerticalGroup(
            jPanelEventCalenderLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelEventCalenderLayout.createSequentialGroup()
                .addComponent(labelSpecialEvents, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparatorLine6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 9, Short.MAX_VALUE))
        );

        jPanelHousekeeping.setBackground(new java.awt.Color(199, 189, 177));

        labelInventory.setAlignment(java.awt.Label.CENTER);
        labelInventory.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelInventory.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelInventory.setForeground(new java.awt.Color(83, 66, 64));
        labelInventory.setText("Today’s Housekeeping Inventory");

        jSeparatorLine7.setBackground(new java.awt.Color(199, 189, 177));
        jSeparatorLine7.setForeground(new java.awt.Color(221, 217, 214));
        jSeparatorLine7.setName(""); // NOI18N
        jSeparatorLine7.setPreferredSize(new java.awt.Dimension(120, 2));

        jScrollPane3.setBackground(new java.awt.Color(83, 66, 54));
        jScrollPane3.setAutoscrolls(true);

        jTableInventry.setAutoCreateRowSorter(true);
        jTableInventry.setBackground(new java.awt.Color(199, 189, 177));
        jTableInventry.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableInventry.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jTableInventry.setForeground(new java.awt.Color(83, 66, 54));
        jTableInventry.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Description", "Quantity"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableInventry.setGridColor(new java.awt.Color(255, 255, 255));
        jTableInventry.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTableInventry.setSelectionForeground(new java.awt.Color(155, 117, 1));
        jTableInventry.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(jTableInventry);

        javax.swing.GroupLayout jPanelHousekeepingLayout = new javax.swing.GroupLayout(jPanelHousekeeping);
        jPanelHousekeeping.setLayout(jPanelHousekeepingLayout);
        jPanelHousekeepingLayout.setHorizontalGroup(
            jPanelHousekeepingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelInventory, javax.swing.GroupLayout.DEFAULT_SIZE, 283, Short.MAX_VALUE)
            .addGroup(jPanelHousekeepingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelHousekeepingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparatorLine7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelHousekeepingLayout.setVerticalGroup(
            jPanelHousekeepingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelHousekeepingLayout.createSequentialGroup()
                .addComponent(labelInventory, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparatorLine7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        jPanelRoomProcing.setBackground(new java.awt.Color(199, 189, 177));

        labelPricing.setAlignment(java.awt.Label.CENTER);
        labelPricing.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelPricing.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelPricing.setForeground(new java.awt.Color(83, 66, 64));
        labelPricing.setText("Room Price List");

        jSeparatorLine9.setBackground(new java.awt.Color(199, 189, 177));
        jSeparatorLine9.setForeground(new java.awt.Color(221, 217, 214));
        jSeparatorLine9.setName(""); // NOI18N
        jSeparatorLine9.setPreferredSize(new java.awt.Dimension(120, 2));

        jScrollPane4.setBackground(new java.awt.Color(83, 66, 54));
        jScrollPane4.setAutoscrolls(true);

        jTableRooms.setAutoCreateRowSorter(true);
        jTableRooms.setBackground(new java.awt.Color(199, 189, 177));
        jTableRooms.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableRooms.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jTableRooms.setForeground(new java.awt.Color(83, 66, 54));
        jTableRooms.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Room No.", "Price (Rs.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableRooms.setGridColor(new java.awt.Color(255, 255, 255));
        jTableRooms.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTableRooms.setSelectionForeground(new java.awt.Color(155, 117, 1));
        jTableRooms.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(jTableRooms);

        javax.swing.GroupLayout jPanelRoomProcingLayout = new javax.swing.GroupLayout(jPanelRoomProcing);
        jPanelRoomProcing.setLayout(jPanelRoomProcingLayout);
        jPanelRoomProcingLayout.setHorizontalGroup(
            jPanelRoomProcingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelPricing, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelRoomProcingLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRoomProcingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparatorLine9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelRoomProcingLayout.setVerticalGroup(
            jPanelRoomProcingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRoomProcingLayout.createSequentialGroup()
                .addComponent(labelPricing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparatorLine9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jPanelRoomProcing1.setBackground(new java.awt.Color(199, 189, 177));

        labelPricing1.setAlignment(java.awt.Label.CENTER);
        labelPricing1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        labelPricing1.setFont(new java.awt.Font("SansSerif", 1, 15)); // NOI18N
        labelPricing1.setForeground(new java.awt.Color(83, 66, 64));
        labelPricing1.setText("Food Menu");

        jSeparatorLine10.setBackground(new java.awt.Color(199, 189, 177));
        jSeparatorLine10.setForeground(new java.awt.Color(221, 217, 214));
        jSeparatorLine10.setName(""); // NOI18N
        jSeparatorLine10.setPreferredSize(new java.awt.Dimension(120, 2));

        jScrollPane5.setBackground(new java.awt.Color(83, 66, 54));
        jScrollPane5.setAutoscrolls(true);

        jTableFoodMenu.setAutoCreateRowSorter(true);
        jTableFoodMenu.setBackground(new java.awt.Color(199, 189, 177));
        jTableFoodMenu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jTableFoodMenu.setFont(new java.awt.Font("SansSerif", 0, 15)); // NOI18N
        jTableFoodMenu.setForeground(new java.awt.Color(83, 66, 54));
        jTableFoodMenu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Title", "Price (Rs.)"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTableFoodMenu.setGridColor(new java.awt.Color(255, 255, 255));
        jTableFoodMenu.setSelectionBackground(new java.awt.Color(255, 255, 255));
        jTableFoodMenu.setSelectionForeground(new java.awt.Color(155, 117, 1));
        jTableFoodMenu.getTableHeader().setReorderingAllowed(false);
        jScrollPane5.setViewportView(jTableFoodMenu);

        javax.swing.GroupLayout jPanelRoomProcing1Layout = new javax.swing.GroupLayout(jPanelRoomProcing1);
        jPanelRoomProcing1.setLayout(jPanelRoomProcing1Layout);
        jPanelRoomProcing1Layout.setHorizontalGroup(
            jPanelRoomProcing1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(labelPricing1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanelRoomProcing1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelRoomProcing1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparatorLine10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanelRoomProcing1Layout.setVerticalGroup(
            jPanelRoomProcing1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelRoomProcing1Layout.createSequentialGroup()
                .addComponent(labelPricing1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jSeparatorLine10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 12, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanelScreenLayout = new javax.swing.GroupLayout(jPanelScreen);
        jPanelScreen.setLayout(jPanelScreenLayout);
        jPanelScreenLayout.setHorizontalGroup(
            jPanelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelScreenLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelScreenLayout.createSequentialGroup()
                        .addComponent(labelAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(2, 2, 2)
                        .addComponent(labelWelcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                        .addComponent(labelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(labelTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanelScreenLayout.createSequentialGroup()
                        .addGroup(jPanelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanelRoomProcing, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanelScreenLayout.createSequentialGroup()
                                .addComponent(jPanelCardRevenue, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelGuests, javax.swing.GroupLayout.DEFAULT_SIZE, 145, Short.MAX_VALUE))
                            .addComponent(jPanelEventCalender, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelScreenLayout.createSequentialGroup()
                                .addComponent(jPanelStaff, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanelRooms, javax.swing.GroupLayout.DEFAULT_SIZE, 147, Short.MAX_VALUE))
                            .addComponent(jPanelHousekeeping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanelRoomProcing1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanelScreenLayout.setVerticalGroup(
            jPanelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelScreenLayout.createSequentialGroup()
                .addGroup(jPanelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelScreenLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanelScreenLayout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(jPanelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelAdminName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelWelcom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(22, 22, 22)
                .addGroup(jPanelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jPanelStaff, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanelGuests, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jPanelCardRevenue, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanelRooms, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanelEventCalender, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanelHousekeeping, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanelScreenLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jPanelRoomProcing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanelRoomProcing1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24))
        );

        getContentPane().add(jPanelScreen, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(816, 539));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabelUserManagementMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelUserManagementMouseClicked
        UserManagement userManagement = new UserManagement();// Get the new UserManagement
        userManagement.setVisible(true); // Show the new UserManagement
        this.setVisible(false); // Close the current window
    }//GEN-LAST:event_jLabelUserManagementMouseClicked

    private void jLabelSystemconfigurationMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelSystemconfigurationMouseClicked
        SystemConfiguration systemConfiguration = new SystemConfiguration();// Get the new SystemConfiguration
        systemConfiguration.setVisible(true); // Show the new SystemConfiguration
        this.setVisible(false); // Close the current window
    }//GEN-LAST:event_jLabelSystemconfigurationMouseClicked

    private void jLabelLogsAuditMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelLogsAuditMouseClicked
        Logs_Audit Logs_Audit = new Logs_Audit();// Get the new logs&audit
        Logs_Audit.setVisible(true); // Show the new logs&audit
        this.setVisible(false); // Close the current window
    }//GEN-LAST:event_jLabelLogsAuditMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AdminDashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AdminDashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabelDashboard;
    private javax.swing.JLabel jLabelId;
    private javax.swing.JLabel jLabelLogOut;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelLogsAudit;
    private javax.swing.JLabel jLabelName;
    private javax.swing.JLabel jLabelSystemconfiguration;
    private javax.swing.JLabel jLabelUseImg;
    private javax.swing.JLabel jLabelUserId;
    private javax.swing.JLabel jLabelUserManagement;
    private javax.swing.JLabel jLabelUserName;
    private javax.swing.JPanel jPanelCardRevenue;
    private javax.swing.JPanel jPanelCurrent;
    private javax.swing.JPanel jPanelEventCalender;
    private javax.swing.JPanel jPanelGuests;
    private javax.swing.JPanel jPanelHousekeeping;
    private javax.swing.JPanel jPanelMenu;
    private javax.swing.JPanel jPanelRoomProcing;
    private javax.swing.JPanel jPanelRoomProcing1;
    private javax.swing.JPanel jPanelRooms;
    private javax.swing.JPanel jPanelScreen;
    private javax.swing.JPanel jPanelStaff;
    private javax.swing.JPanel jPaneluser;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JSeparator jSeparatorLine;
    private javax.swing.JSeparator jSeparatorLine10;
    private javax.swing.JSeparator jSeparatorLine3;
    private javax.swing.JSeparator jSeparatorLine4;
    private javax.swing.JSeparator jSeparatorLine5;
    private javax.swing.JSeparator jSeparatorLine6;
    private javax.swing.JSeparator jSeparatorLine7;
    private javax.swing.JSeparator jSeparatorLine9;
    private javax.swing.JTable jTableEvent;
    private javax.swing.JTable jTableFoodMenu;
    private javax.swing.JTable jTableInventry;
    private javax.swing.JTable jTableRooms;
    private java.awt.Label label100;
    private java.awt.Label labelActiveStaff;
    private java.awt.Label labelAdminName;
    private java.awt.Label labelAvailable;
    private java.awt.Label labelCheckedIn;
    private java.awt.Label labelDate;
    private java.awt.Label labelGuestsCount;
    private java.awt.Label labelInventory;
    private java.awt.Label labelOf;
    private java.awt.Label labelPricing;
    private java.awt.Label labelPricing1;
    private java.awt.Label labelRevenue;
    private java.awt.Label labelRoomCount;
    private java.awt.Label labelSpecialEvents;
    private java.awt.Label labelStaffCount;
    private java.awt.Label labelTime;
    private java.awt.Label labelTodayRevenue;
    private java.awt.Label labelWelcom;
    // End of variables declaration//GEN-END:variables
}
