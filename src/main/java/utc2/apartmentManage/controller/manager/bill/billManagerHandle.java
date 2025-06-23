package utc2.apartmentManage.controller.manager.bill;

import java.awt.BorderLayout;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

import utc2.apartmentManage.service.export.excelExport;
import utc2.apartmentManage.service.implement.user.billIMP;
import utc2.apartmentManage.view.manager.pages.BillUI;
import utc2.apartmentManage.view.manager.addWindow.addBillManager;

public class billManagerHandle {
    private JButton addBtn, backBtn, excelBtn;
    private JComboBox<String> month, year;
    private JTextField searchField;
    private JTable table;
    private JPanel mainPanel;
    private final billIMP billService = new billIMP();

    public billManagerHandle(JButton addBtn, JButton backBtn, JButton excelBtn, JComboBox<String> month, 
                            JComboBox<String> year, JTextField searchField, JTable table, JPanel mainPanel) {
        this.addBtn = addBtn;
        this.backBtn = backBtn;
        this.excelBtn = excelBtn;
        this.month = month;
        this.year = year;
        this.searchField = searchField;
        this.table = table;
        this.mainPanel = mainPanel;
        
        this.backBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                backBtnClick();
            }
        });
        
        this.year.addActionListener(e -> {
            loadData();
        });
        
        this.month.addActionListener(e -> {
            loadData();
        });
        
        this.excelBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String directoryPath = System.getProperty("user.dir") + File.separator + "data";
                excelExport.exportTableToExcelWithDirectory(directoryPath, table, "bill_manager_detail");
            }
        });
        
        this.addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new addBillManager(table, month, year).setVisible(true);
            }
        });
        
        searchField.getDocument().addDocumentListener(new javax.swing.event.DocumentListener() {
            @Override
            public void insertUpdate(javax.swing.event.DocumentEvent e) {
                billService.searchTable2(table, searchField);
            }

            @Override
            public void removeUpdate(javax.swing.event.DocumentEvent e) {
                billService.searchTable2(table, searchField);
            }

            @Override
            public void changedUpdate(javax.swing.event.DocumentEvent e) {
                billService.searchTable2(table, searchField);
            }
        });
        
        placeHolder();
        loadData();
        
    }
    
    public void loadData() {
        int monthNum = Integer.parseInt(month.getSelectedItem().toString());
        int yearNum = Integer.parseInt(year.getSelectedItem().toString());      
        billService.setUpTableBillManagerDetail(table, monthNum, yearNum);
    }
    
    private void backBtnClick() {
        mainPanel.removeAll();
        mainPanel.setLayout(new BorderLayout());
        BillUI report = new BillUI(mainPanel);
        mainPanel.add(report, BorderLayout.CENTER);
        mainPanel.revalidate();
        mainPanel.repaint();
    }
    
    private void placeHolder() {
        searchField.setForeground(java.awt.Color.GRAY);
        searchField.setText("Nhập tên dịch vụ...");
        searchField.addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent evt) {
                if (searchField.getText().equals("Nhập tên dịch vụ...")) {
                    searchField.setText("");
                    searchField.setForeground(java.awt.Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent evt) {
                if (searchField.getText().isEmpty()) {
                    searchField.setForeground(java.awt.Color.GRAY);
                    searchField.setText("Nhập tên dịch vụ...");
                }
            }
        });
    }
    
    
}
