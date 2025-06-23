package utc2.apartmentManage.controller.manager.bill;

import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.JPanel;
import utc2.apartmentManage.view.manager.pages.*;


public class billHandle {
    private JPanel hdcd, hdql, mainPanel;

    public billHandle(JPanel finance, JPanel employee, JPanel mainPanel) {
        this.hdcd = finance;
        this.hdql = employee;
        this.mainPanel = mainPanel;
        
        
        this.hdql.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPanel.removeAll();
                mainPanel.setLayout(new BorderLayout());
                BillDetailForManagerUI fi = new BillDetailForManagerUI(mainPanel);
                mainPanel.add(fi, BorderLayout.CENTER);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
        
        this.hdcd.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                mainPanel.removeAll();
                mainPanel.setLayout(new BorderLayout());
                BillAllUserUI emp = new BillAllUserUI(mainPanel);
                mainPanel.add(emp, BorderLayout.CENTER);
                mainPanel.revalidate();
                mainPanel.repaint();
            }
        });
    
    }
}
