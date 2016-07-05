/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package diary3;

import java.awt.Color;
import java.awt.Component;
import java.io.File;
import java.util.Date;
import java.util.StringTokenizer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Mahe
 */
public class DCalendar extends javax.swing.JPanel {

    public int year = 2004;
    public int month = 1;
    public int[] nofd = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    public String[] monthLabels = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    public String[] col = {"Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"};
    int selectedDay = 1;

    /**
     * Creates new form DCalendar
     */
    public DCalendar() {
        initComponents();
        for (int i = 1990; i <= new Date().getYear() + 1900; i++) {
            years.addItem(i);
        }
        years.setSelectedIndex(years.getItemCount() - 1);
        year = new Date().getYear() + 1900;
        month = new Date().getMonth();
        fillDates();
        months.setRenderer(new ListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                JLabel j = new JLabel(value.toString());
                try {
                    if (Diary3.CURRENT_USER != null) {
                        if (new File(Home.getHomeFor(Diary3.CURRENT_USER.USERNAME) + "/" + years.getSelectedItem().toString() + "/" + (months.getSelectedIndex() + 1)).listFiles().length == 0) {
                            j.setBackground(new Color(255, 204, 204));
                        } else {
                            j.setBackground(new Color(153, 255, 153));
                        }
                    }
                } catch (NullPointerException e) {
                }
                return j;
            }
        });
    }

    public void fillDates() {
        String[][] days = new String[6][7];
        Date d = new Date(year - 1900, month, 1);
        int i = d.getDay();
        if (month == 1) {
            if (year % 4 == 0) {
                nofd[1] = 29;
            } else {
                nofd[1] = 28;
            }
        }
        days[0][i] = 1 + "";
        try {
            int clog = Diary3.CURRENT_USER.getNumberOfLogs(year + "", (month + 1) + "", "1");
            System.out.println(clog + " : " + (1));
            days[0][i] = 1 + " " + (clog == -1 ? "" : "[" + clog + "]");
        } catch (NullPointerException e) {
            days[0][i] = 1 + "";
        }
        for (int k = 1; k < nofd[month]; k++) {
            int r = (k + i) / 7;
            int c = (k + i) % 7;
            try {
                int clog = Diary3.CURRENT_USER.getNumberOfLogs(year + "", (month + 1) + "", (k + 1) + "");
                System.out.println(clog + " : " + (k + 1));
                days[r][c] = (k + 1) + " " + (clog == -1 ? "" : "[" + clog + "]");
            } catch (NullPointerException e) {
                days[r][c] = (k + 1) + "";
            }
        }
        dates.setModel(new DefaultTableModel(days, col));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        dates = new javax.swing.JTable();
        months = new javax.swing.JComboBox();
        years = new javax.swing.JComboBox();

        dates.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        dates.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "Sun", "Mon", "Tue", "Wed", "Thur", "Fri", "Sat"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        dates.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        dates.setCellSelectionEnabled(true);
        dates.setFillsViewportHeight(true);
        dates.setSelectionMode(javax.swing.ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        dates.setShowHorizontalLines(false);
        dates.setShowVerticalLines(false);
        dates.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                datesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(dates);

        months.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        months.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" }));
        months.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                monthsItemStateChanged(evt);
            }
        });

        years.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        years.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                yearsItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(months, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(years, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(197, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(months, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(years, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 140, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void monthsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_monthsItemStateChanged
        // TODO add your handling code here:
        month = months.getSelectedIndex();
        fillDates();
    }//GEN-LAST:event_monthsItemStateChanged

    private void yearsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_yearsItemStateChanged
        // TODO add your handling code here:
        year = (int) years.getSelectedItem();
        fillDates();
    }//GEN-LAST:event_yearsItemStateChanged

    public void refreshList() {
        datesMouseClicked(null);
        fillDates();
    }

    private void datesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_datesMouseClicked
        // TODO add your handling code here:
        try {
            int x = dates.getSelectedRow();
            int y = dates.getSelectedColumn();
            if (dates.getSelectedColumnCount() != 0) {
                final String value = (String) dates.getModel().getValueAt(x, y);
                if (value.indexOf("[") != -1) {
                    String path = Home.getLogHomeFor(Diary3.CURRENT_USER.USERNAME).getAbsolutePath() + "/" + years.getSelectedItem().toString() + "/" + (months.getSelectedIndex() + 1) + "/" + value.substring(0, value.indexOf(" "));
                    System.out.println(path);
                    File f[] = new File(path).listFiles();
                    Diary3.DIARY.currentLogList.removeAll();
                    DefaultListModel d = new DefaultListModel();
                    for (int i = 0; i < f.length; i++) {
                        d.addElement(f[i].getName());
                    }
                    ListCellRenderer ren = new ListCellRenderer() {

                        @Override
                        public Component getListCellRendererComponent(JList list, Object t, int index, boolean isSelected, boolean cellHasFocus) {
                            JLabel j = new JLabel();
                            j.setOpaque(true);
                            if (isSelected) {
                                j.setBackground(new Color(240, 240, 240));
                            } else {
                                j.setBackground(Color.WHITE);
                            }
                            String n = (String) t;
                            if (n.contains(".logx")) {
                                n = n.substring(0, n.lastIndexOf(".logx"));
                            }
                            String time = n.substring(0, n.indexOf("."));
                            StringTokenizer st = new StringTokenizer(time, "-");
                            String h = (st.nextToken());
                            String m = (st.nextToken());
                            String s = (st.nextToken());
                            String title = n.substring(n.indexOf(".") + 1);
                            title = new JuliusCrypter().perfectSquareCrypt(title);
                            String yr = years.getSelectedItem().toString();
                            String mth = (months.getSelectedIndex() + 1) + "";
                            String date = value.substring(0, value.indexOf(" "));
                            j.setText(date+"/"+mth+"/"+yr+" - "+h+":"+m+":"+s+" - "+title);
                            return j;
                        }
                    };
                    Diary3.DIARY.currentLogList.setModel(d);
                    Diary3.DIARY.currentLogList.setCellRenderer(ren);
                    Diary3.DIARY.currentLogList.setSelectedIndex(0);
                }
            }
        } catch (Exception e) {
        }
    }//GEN-LAST:event_datesMouseClicked
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable dates;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JComboBox months;
    public javax.swing.JComboBox years;
    // End of variables declaration//GEN-END:variables

    public String getDateString() {
        int x = dates.getSelectedRow();
        int y = dates.getSelectedColumn();
        String value = (String) dates.getModel().getValueAt(x, y);
        if (value.indexOf("[") != -1) {
            value = value.substring(0, value.indexOf(" "));
        }
        String year = years.getSelectedItem().toString();
        String month = (months.getSelectedIndex() + 1) + "";
        return year + "/" + month + "/" + value;
    }

}
