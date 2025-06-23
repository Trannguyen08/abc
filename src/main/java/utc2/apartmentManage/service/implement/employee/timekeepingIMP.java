package utc2.apartmentManage.service.implement.employee;

import java.awt.Font;
import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.*;
import javax.swing.table.*;
import utc2.apartmentManage.model.Attendance;
import utc2.apartmentManage.repository.employee.timekeepingRepository;


public class timekeepingIMP {
    private timekeepingRepository repository = new timekeepingRepository();

    public int getNewID() {
        return repository.getIDMinNotExist();
    }
    
    public boolean add(int attendanceId, int employeeId, Date attendanceDate) {
        return repository.insertAttendance(attendanceId, employeeId, attendanceDate);
    }
    
    public boolean addCheckInTime(Date attendanceId, Time checkInTime) {
        return repository.updateCheckInTime(attendanceId, checkInTime);
    }
    
    public boolean addCheckOutTime(Date attendanceId, Time checkOutTime) {
        return repository.updateCheckOutTime(attendanceId, checkOutTime);
    }
    
    public Attendance isExistTodayDate(int employee_id) {
        return repository.getAttendanceToday(employee_id);
    }
    
    public void sortlist(List<Attendance> list) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        list.sort((n1, n2) -> {
            LocalDate d1 = LocalDate.parse(n1.getDate(), formatter);
            LocalDate d2 = LocalDate.parse(n2.getDate(), formatter);
            return d2.compareTo(d1); 
        });
    }
    
    public void setUpTable(JTable table, int month, int year, int employee_id) {
        List<Attendance> list = repository.getAttendance(employee_id, month, year);
        sortlist(list);
        
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);

        for (Attendance a : list) {
            model.addRow(new Object[]{
                    a.getDate(),
                    a.getCheckin(),
                    a.getCheckout()
            });
        }
        setFont(table);
        
    }
    
    public void setFont(JTable table) {
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
}