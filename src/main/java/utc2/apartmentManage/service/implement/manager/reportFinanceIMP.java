package utc2.apartmentManage.service.implement.manager;

import java.awt.*;
import java.text.NumberFormat;
import java.util.*;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import utc2.apartmentManage.controller.manager.report.*;
import utc2.apartmentManage.model.Amount;
import utc2.apartmentManage.repository.manager.reportRepository;

public class reportFinanceIMP  {
    private reportRepository rr = new reportRepository();
    private final NumberFormat df = NumberFormat.getInstance(new Locale("vi", "VN"));

    public void setUpTable(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
    
    public void setUpTable1(JTable table, int month, int year, JPanel chartPanel) {
        List<Amount> list = rr.calculateTotalRevenueByService(month, year);
        
        double totalAmount = rr.calculateMonthlyRevenue(year, month);
        for (Amount a : list) {
            a.setPercent(a.getTotal() / totalAmount * 100);
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Amount a : list) {
            model.addRow(new Object[] {
                a.getName(),
                df.format(a.getTotal()),
                df.format(a.getPercent())
            });
        }

        setFont1(table);

        
        chartPanel.removeAll();
        chartPanel.setLayout(new BorderLayout());
        PieChartPanel pieChart = new PieChartPanel(list);
        pieChart.setPreferredSize(new Dimension(600, 300));
        chartPanel.add(pieChart, BorderLayout.CENTER);
        chartPanel.revalidate();
        chartPanel.repaint();
    }

    public void setUpTable2(JTable table, int month, int year, JPanel chartPanel) {
        List<Amount> list = rr.calculateTotalRevenueByServiceWithoutJoin(month, year);
        if( list.isEmpty() ) {
            System.out.println("rong");
        }

        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        int index = 1;
        for (Amount a : list) {
            model.addRow(new Object[] {
                index++,                   
                a.getName(),                
                df.format(a.getTotal())     
            });
        }


        setFont2(table);

        // Vẽ biểu đồ cột
        chartPanel.removeAll();
        chartPanel.setLayout(new BorderLayout());
        BarChartPanel barChart = new BarChartPanel(list);
        chartPanel.add(barChart, BorderLayout.CENTER);
        chartPanel.revalidate();
        chartPanel.repaint();
    }


    public void setFont1(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        
        for( int i = 0 ; i < table.getColumnCount() ; i++ ) {
            table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
        }
        ((DefaultTableCellRenderer) table.getTableHeader()
                                    .getDefaultRenderer()).
                                    setHorizontalAlignment(SwingConstants.CENTER);
    }
    
    public void setFont2(JTable table) {
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
        JTableHeader header = table.getTableHeader();
        header.setFont(new Font("Arial", Font.BOLD, 14));
        
        for( int i = 0 ; i < table.getColumnCount() ; i++ ) {
            if (i == 1) {
                table.getColumnModel().getColumn(i).setCellRenderer(new MultiLineCellRenderer());
            } else {
                centerRenderer.setHorizontalAlignment(SwingConstants.CENTER);
                table.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
            }
        }
        ((DefaultTableCellRenderer) table.getTableHeader()
                                    .getDefaultRenderer()).
                                    setHorizontalAlignment(SwingConstants.CENTER);
    }

    
    public boolean isSelectedRow(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null,
                    "Vui lòng chọn một dòng.",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE
            );
            return false;
        }
        return true;
    }
    
}
