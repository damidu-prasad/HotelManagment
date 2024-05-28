/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.Month;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import model.MYSQL;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author mlahi
 */
public class Expense_Tracking extends javax.swing.JFrame {

    /**
     * Creates new form Financial_Transaction
     */
    public Expense_Tracking() {
        initComponents();
        Expencedataload();
        loadlabel();
        loadMonth();
    }

    
    private void loadMonth() {
        Vector<String> vector = new Vector<>(); // Use generic type for better type safety

        try (ResultSet resultset = MYSQL.execute("SELECT `name` FROM `month`")) {
            vector.add("Select month");
            while (resultset.next()) {
                String month = resultset.getString("name");
                vector.add(month);
            }

            DefaultComboBoxModel<String> comboboxModel = new DefaultComboBoxModel<>(vector);
            jComboBox1.setModel(comboboxModel);

        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Error loading months: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    private void Expencedataload() {

        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            ResultSet resultset = MYSQL.execute("SELECT * FROM `user_payroll` INNER JOIN `user` ON `user_payroll`.`user_id`=`user`.`user_id` INNER JOIN `month` ON `user_payroll`.`month_id`=`month`.`month_id`");

            while (resultset.next()) {
                String month = resultset.getString("month.name");
                String description = resultset.getString("user_payroll_id");
                String totalsalary = resultset.getString("total_salary");
                String name = resultset.getString("user.name");

                Vector vector = new Vector();
                vector.add(description);
                vector.add(month);
                vector.add(totalsalary);
                vector.add(name);
                

                model.addRow(vector);

            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }
    
    private void loadlabel(){
        try {
            LocalDate currentDate = LocalDate.now();
        
        // Extract the current month
        Month currentMonth = currentDate.getMonth();
        
           // System.out.println(currentMonth);
        
            ResultSet resultset = MYSQL.execute("SELECT SUM(total_salary) AS total FROM `user_payroll` WHERE `month_id` = (SELECT `month_id` FROM `month` WHERE `name` = '"+currentMonth+"')");
           
               if (resultset.next()) {
            
            double totalSalary = resultset.getDouble("total");

            
            jLabel6.setText(String.valueOf(totalSalary));

               }
    }   catch (SQLException ex) {
            Logger.getLogger(Expense_Tracking.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    private void payrolldataload() {

        try {
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();

            ResultSet resultset = MYSQL.execute("SELECT * FROM `user_payroll` INNER JOIN "
                    + "`user` ON  `user_payroll`.user_id = `user`.user_id  INNER JOIN "
                    + "`month` ON `user_payroll`.month_id = `month`.month_id");

//            ResultSet resultset = MYSQL.execute("SELECT * FROM `user_payroll`");
            while (resultset.next()) {
                String month = resultset.getString("month.name");
                String employee = resultset.getString("user.name");
                //String hours = resultset.getString("workingHours");
                String benifit = resultset.getString("benifits");
                String salary = resultset.getString("salary");
                String totalsalery = resultset.getString("total_salary");

                Vector vector = new Vector();
                vector.add(month);
                vector.add(employee);
                //vector.add(hours);
                vector.add(benifit);
                vector.add(salary);
                vector.add(totalsalery);

                model.addRow(vector);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
}
    
//    public void BarChartExample(String title) {
//
//        // Create dataset
//        CategoryDataset dataset = createDataset();
//
//        // Create chart
//        JFreeChart chart = ChartFactory.createBarChart(
//                "Bar Chart Example", // Chart title
//                "Category", // X-Axis Label
//                "Score", // Y-Axis Label
//                dataset, // Dataset
//                PlotOrientation.VERTICAL,
//                true, true, false);
//
//        // Customize the chart
//        customizeChart(chart);
//
//        // Add the chart to a panel
//        ChartPanel chartPanel = new ChartPanel(chart);
//        chartPanel.setPreferredSize(new Dimension(800, 600));
//        setContentPane(chartPanel);
//    }
//
//    private CategoryDataset createDataset() {
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//
//        dataset.addValue(80, "School A", "Math");
//        dataset.addValue(50, "School A", "Science");
//        dataset.addValue(70, "School A", "English");
//
//        dataset.addValue(60, "School B", "Math");
//        dataset.addValue(40, "School B", "Science");
//        dataset.addValue(90, "School B", "English");
//
//        return dataset;
//    }
//
//    private void customizeChart(JFreeChart chart) {
//        // Customize chart (optional)
//        chart.getTitle().setPaint(Color.BLUE);
//    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jButton7 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(816, 539));

        jPanel1.setBackground(new java.awt.Color(83, 66, 54));
        jPanel1.setForeground(new java.awt.Color(222, 222, 222));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/hp1)nnnn 2.png"))); // NOI18N

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 20)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Accountant");

        jButton1.setBackground(new java.awt.Color(83, 66, 54));
        jButton1.setForeground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Financial Transaction ");
        jButton1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(83, 66, 54));
        jButton2.setForeground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Revenue Report");
        jButton2.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jButton2.setBorderPainted(false);
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText(" Expense Tracking");
        jButton3.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton5.setBackground(new java.awt.Color(83, 66, 54));
        jButton5.setForeground(new java.awt.Color(255, 255, 255));
        jButton5.setText("Payroll Management");
        jButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addContainerGap(25, Short.MAX_VALUE))
            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton3)
                .addGap(18, 18, 18)
                .addComponent(jButton5)
                .addContainerGap(119, Short.MAX_VALUE))
        );

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jButton7.setBackground(new java.awt.Color(83, 66, 54));
        jButton7.setForeground(new java.awt.Color(255, 255, 255));
        jButton7.setText("SEARCH");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jTable1.setBackground(new java.awt.Color(199, 189, 177));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Amount", "Parties"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionForeground(new java.awt.Color(199, 189, 177));
        jScrollPane1.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setResizable(false);
            jTable1.getColumnModel().getColumn(1).setResizable(false);
            jTable1.getColumnModel().getColumn(2).setResizable(false);
            jTable1.getColumnModel().getColumn(3).setResizable(false);
        }

        jPanel3.setBackground(new java.awt.Color(199, 189, 177));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(83, 66, 54));
        jLabel4.setText("Monthly Expense");

        jLabel5.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(83, 66, 54));
        jLabel5.setText("RS.");

        jLabel6.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(83, 66, 54));
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("00.00");
        jLabel6.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(184, 184, 184)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(54, 54, 54)
                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(203, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(34, Short.MAX_VALUE))
        );

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 585, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(jButton7)))
                .addContainerGap(7, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 282, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        setSize(new java.awt.Dimension(814, 507));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Financial_Transaction ft = new Financial_Transaction();
        ft.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         Revenue_Report rreport = new Revenue_Report();
        rreport.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Payroll_Management pm = new Payroll_Management();
        pm.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:

       try {
           
           String choosemonth = jComboBox1.getSelectedItem().toString();
            DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
            model.setNumRows(0);

            ResultSet resultset = MYSQL.execute("SELECT * FROM `user_payroll` INNER JOIN `user` ON `user_payroll`.`user_id`=`user`.`user_id` INNER JOIN `month` ON `user_payroll`.`month_id`=`month`.`month_id`WHERE month.name = '" + choosemonth + "'");

            while (resultset.next()) {
                String month = resultset.getString("month.name");
                String description = resultset.getString("user_payroll_id");
                String totalsalary = resultset.getString("total_salary");
                String name = resultset.getString("user.name");

                Vector vector = new Vector();
                vector.add(description);
                vector.add(month);
                vector.add(totalsalary);
                vector.add(name);
                

                model.addRow(vector);

            }
        } catch (Exception e) {
            e.printStackTrace();
            
        }
    }//GEN-LAST:event_jButton7ActionPerformed

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
            java.util.logging.Logger.getLogger(Expense_Tracking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Expense_Tracking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Expense_Tracking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Expense_Tracking.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Expense_Tracking().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
