package utc2.apartmentManage.view.manager.addWindow;

import utc2.apartmentManage.controller.manager.apartment.addButtonHandle;
import javax.swing.*;

public class addApartment extends JFrame {
    public addApartment(JTable table) {
        initComponents();
        addButtonHandle add = new addButtonHandle(addBtn, addImg,  apartmentIndex, area, building, buyPrice, floor,
                                                     interior, rentPrice, roomNum, wcnum, table, this, imglabel);
        this.setLocationRelativeTo(null);
        this.setTitle("Thêm căn hộ");
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new JPanel();
        jLabel1 = new JLabel();
        jLabel2 = new JLabel();
        jLabel7 = new JLabel();
        jLabel4 = new JLabel();
        jLabel5 = new JLabel();
        jLabel6 = new JLabel();
        addBtn = new JButton();
        apartmentIndex = new JComboBox<>();
        building = new JComboBox<>();
        floor = new JComboBox<>();
        roomNum = new JComboBox<>();
        area = new JTextField();
        rentPrice = new JTextField();
        buyPrice = new JTextField();
        jLabel9 = new JLabel();
        addImg = new JButton();
        jLabel8 = new JLabel();
        wcnum = new JComboBox<>();
        jLabel10 = new JLabel();
        interior = new JComboBox<>();
        imglabel = new JLabel();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(249, 249, 249));

        jPanel1.setBackground(new java.awt.Color(253, 253, 253));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel1.setText("Tòa");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel2.setText("Tầng");

        jLabel7.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel7.setText("Số phòng ngủ ");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel4.setText("Diện tích ");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel5.setText("Giá thuê");

        jLabel6.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel6.setText("Giá mua");

        addBtn.setBackground(new java.awt.Color(50, 65, 94));
        addBtn.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        addBtn.setForeground(new java.awt.Color(255, 255, 255));
        addBtn.setText("Thêm");
        addBtn.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        apartmentIndex.setBackground(new java.awt.Color(250, 250, 250));
        apartmentIndex.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        apartmentIndex.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        building.setBackground(new java.awt.Color(250, 250, 250));
        building.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        building.setModel(new DefaultComboBoxModel<>(new String[] { "A", "B", "C", "D" }));

        floor.setBackground(new java.awt.Color(250, 250, 250));
        floor.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        floor.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20" }));

        roomNum.setBackground(new java.awt.Color(250, 250, 250));
        roomNum.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        roomNum.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        area.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        rentPrice.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        buyPrice.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N

        jLabel9.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel9.setText("Số căn hộ");

        addImg.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        addImg.setText("Thêm ảnh");
        addImg.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel8.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel8.setText("Số phòng wc");

        wcnum.setBackground(new java.awt.Color(250, 250, 250));
        wcnum.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        wcnum.setModel(new DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4" }));

        jLabel10.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        jLabel10.setText("Nội thất");

        interior.setBackground(new java.awt.Color(250, 250, 250));
        interior.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        interior.setModel(new DefaultComboBoxModel<>(new String[] { "Cơ bản", "Đầy đủ", "Trống" }));

        GroupLayout jPanel1Layout = new GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel1, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, GroupLayout.PREFERRED_SIZE, 37, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel8))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(apartmentIndex, GroupLayout.Alignment.TRAILING, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(building, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel10, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(floor, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(roomNum, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE))
                                .addGap(69, 69, 69)
                                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel5, GroupLayout.PREFERRED_SIZE, 68, GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel6))))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                            .addComponent(area, GroupLayout.PREFERRED_SIZE, 88, GroupLayout.PREFERRED_SIZE)
                            .addComponent(interior, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                            .addComponent(rentPrice, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)
                            .addComponent(buyPrice, GroupLayout.PREFERRED_SIZE, 127, GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(wcnum, GroupLayout.PREFERRED_SIZE, 62, GroupLayout.PREFERRED_SIZE)
                        .addGap(69, 69, 69)
                        .addComponent(addImg, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 41, Short.MAX_VALUE))
            .addGroup(GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(imglabel, GroupLayout.PREFERRED_SIZE, 365, GroupLayout.PREFERRED_SIZE)
                .addGap(78, 78, 78))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(187, 187, 187)
                .addComponent(addBtn, GroupLayout.PREFERRED_SIZE, 140, GroupLayout.PREFERRED_SIZE)
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(apartmentIndex, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel10)
                    .addComponent(interior, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(building, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(area, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(floor, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel5)
                    .addComponent(rentPrice, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(roomNum, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(buyPrice, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(wcnum, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(addImg, GroupLayout.PREFERRED_SIZE, 34, GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(imglabel, GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE)
                .addGap(38, 38, 38)
                .addComponent(addBtn, GroupLayout.PREFERRED_SIZE, 50, GroupLayout.PREFERRED_SIZE)
                .addGap(32, 32, 32))
        );

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton addBtn;
    private JButton addImg;
    private JComboBox<String> apartmentIndex;
    private JTextField area;
    private JComboBox<String> building;
    private JTextField buyPrice;
    private JComboBox<String> floor;
    private JLabel imglabel;
    private JComboBox<String> interior;
    private JLabel jLabel1;
    private JLabel jLabel10;
    private JLabel jLabel2;
    private JLabel jLabel4;
    private JLabel jLabel5;
    private JLabel jLabel6;
    private JLabel jLabel7;
    private JLabel jLabel8;
    private JLabel jLabel9;
    private JPanel jPanel1;
    private JTextField rentPrice;
    private JComboBox<String> roomNum;
    private JComboBox<String> wcnum;
    // End of variables declaration//GEN-END:variables
}
