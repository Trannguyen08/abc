package utc2.apartmentManage.service.implement.manager;

import com.toedter.calendar.JDateChooser;
import java.awt.Font;
import java.text.NumberFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.*;
import utc2.apartmentManage.model.*;
import utc2.apartmentManage.repository.manager.employeeRepository;
import utc2.apartmentManage.service.interfaces.*;
import utc2.apartmentManage.service.implement.login.loginIMP;
import utc2.apartmentManage.util.ScannerUtil;

public class employeeIMP implements ISQL<Employee>, ITable<Employee>, IValidate, IEmployee {
    private final employeeRepository employeeRepo = new employeeRepository();
    private final loginIMP loginService = new loginIMP();
    private final NumberFormat df = NumberFormat.getInstance(new Locale("vi", "VN"));

    @Override
    public boolean add(Employee object) {
        return employeeRepo.addEmployee(object);
    }

    @Override
    public boolean update(Employee object) {
        return employeeRepo.updateEmployee(object);
    }

    @Override
    public boolean delete(int id) {
         return employeeRepo.deleteEmployee(id);
    }

    @Override
    public int getNewID() {
        return employeeRepo.getIDMinNotExist();
    }

    @Override
    public boolean isExist(int id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean isDuplicate(Employee object) {
        int code = employeeRepo.isDuplicate(object);
        switch (code) {
            case 1 -> JOptionPane.showMessageDialog(null, "Email đã được sử dụng!", "Lỗi trùng dữ liệu", JOptionPane.ERROR_MESSAGE);
            case 2 -> JOptionPane.showMessageDialog(null, "Số điện thoại đã được sử dụng!", "Lỗi trùng dữ liệu", JOptionPane.ERROR_MESSAGE);
            case 3 -> JOptionPane.showMessageDialog(null, "CMND/CCCD đã được sử dụng!", "Lỗi trùng dữ liệu", JOptionPane.ERROR_MESSAGE);
            default -> {
                return false; 
            }
        }
        return true; 
    }


    @Override
    public Employee getObject(int id) {
        return employeeRepo.getEmployeeById(id);
    }

    @Override
    public void setUpTable(JTable table) {
        List<Employee> list = employeeRepo.getAllEmployee();
        addData(table, list);
        setFont(table); 
    }

    @Override
    public void addData(JTable table, List<Employee> list) {
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(0);
        for( Employee emp : list ) {
            model.addRow(new Object[] {emp.getId(), emp.getName(), emp.getGender(), 
                                        emp.getDate(), emp.getPhoneNumber(),
                                        emp.getEmail(), emp.getPosition(),
                                        df.format(emp.getSalary()), emp.getStatus(), emp.getShift()});
        }
    }

    @Override
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

    @Override
    public boolean isSelectedRow(JTable table) {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(null,
                    "Vui lòng chọn một dòng",
                    "Thông báo", JOptionPane.INFORMATION_MESSAGE
            );
            return false;
        }
        return true;
    }

    @Override
    public boolean addValidate(Object... obj) {
        JTextField username = (JTextField) obj[0];
        JTextField password = (JTextField) obj[1];
        JTextField fullName = (JTextField) obj[2];
        JTextField phoneNumber = (JTextField) obj[3];
        JTextField email = (JTextField) obj[4];
        JTextField idcard = (JTextField) obj[5];
        JTextField salary = (JTextField) obj[6];
        JDateChooser date = (JDateChooser) obj[7];

        String uName = username.getText().trim();
        String pWord = password.getText().trim();
        String fName = fullName.getText().trim();
        String pNumber = phoneNumber.getText().trim();
        String eEmail = email.getText().trim();
        String sal = salary.getText().trim();
        String cccd = idcard.getText().trim();
        sal = sal.replace(",", ".");

        // Kiểm tra rỗng
        if (    uName.isEmpty() || pWord.isEmpty() || 
                fName.isEmpty() || pNumber.isEmpty() || 
                eEmail.isEmpty() || sal.isEmpty() || cccd.isEmpty()) {
            
            JOptionPane.showMessageDialog(null,
                    "Vui lòng điền đầy đủ thông tin!",
                    "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        // Kiểm tra username
        if (!ScannerUtil.isValidUsername(uName)) {
            return false;
        }
        List<Account> list = loginService.gettAllAccount();
        boolean isDuplicate = list.stream()
                                .anyMatch(acc -> acc.getUsername().equalsIgnoreCase(uName));

        if (isDuplicate) {
            JOptionPane.showMessageDialog(null, "Tên đăng nhập đã tồn tại!", 
                    "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Kiểm tra password
        if (!ScannerUtil.isValidPassword(pWord)) {
            return false;
        }

        // Kiểm tra họ tên
        if (!ScannerUtil.isValidFullName(fName)) {
            return false;
        }
        
        if( !ScannerUtil.isValidAge(date.getDate()) ) {
            return false;
        }
        
        // Kiểm tra số điện thoại
        if (!ScannerUtil.validatePhoneNumber(pNumber)) {
            return false;
        }

        // Kiểm tra email
        if (!ScannerUtil.validateEmail(eEmail)) {
            return false;
        } 
        
        if( !ScannerUtil.isValidCCCD(cccd) ) {
            return false;
        }

        // Kiểm tra lương
        if (!ScannerUtil.validateDouble(sal, "Lương")) {
            return false;
        } else {
            double salaryValue = Double.parseDouble(sal);
            if (salaryValue < 3000000 || salaryValue > 25000000) {
                JOptionPane.showMessageDialog(null,
                        "Lương nhân viên phải nằm trong khoảng từ 3 triệu đến 25 triệu!",
                        "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE
                );
                return false;
            }
        }

        
        
        return true;
    }


    @Override
    public boolean editValidate(Object... obj) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public boolean searchValidate(Object... obj) {
        JTextField salary = (JTextField) obj[0];
        JTextField toSalary = (JTextField) obj[1];

        String fromSalaryText = salary.getText().trim();
        String toSalaryText = toSalary.getText().trim();

        // Validate lương tối thiểu
        if (!fromSalaryText.isEmpty() && !ScannerUtil.validateDouble(fromSalaryText, "Lương tối thiểu")) {
            return false;
        }

        // Validate lương tối đa
        if (!toSalaryText.isEmpty() && !ScannerUtil.validateDouble(toSalaryText, "Lương tối đa")) {
            return false;
        }

        // Nếu cả 2 đều có giá trị, kiểm tra khoảng
        if (!fromSalaryText.isEmpty() && !toSalaryText.isEmpty()) {
            double fromSalary = Double.parseDouble(fromSalaryText);
            double toSalaryVal = Double.parseDouble(toSalaryText);

            if (fromSalary > toSalaryVal) {
                JOptionPane.showMessageDialog(null,
                        "Lương tối thiểu không được lớn hơn lương tối đa!",
                        "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE
                );
                return false;
            }
        }

        return true;
    }
    
    @Override
    public boolean loadSelectedRowData(JTable table, JComboBox<String> position, JTextField salary) {
        boolean error = isSelectedRow(table);
        if( !error ) {
            return false;
        }
        int selectedRow = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        
        position.setSelectedItem(model.getValueAt(selectedRow, 6).toString());
        
        String salaryText = model.getValueAt(selectedRow, 7).toString().replace(".", "");
        salaryText = salaryText.replace(",", ".");
        salary.setText(salaryText);
        
        return true;
    }
    
    @Override
    public boolean filterEmployeeIcon(JTable table, Employee emp, double toValue) {
        List<Employee> emps = employeeRepo.getAllEmployeeBySearchIcon(emp, toValue);
        if( emps.isEmpty() ){
            DefaultTableModel model = (DefaultTableModel) table.getModel();
            table.setRowSorter(null);
            model.setRowCount(0); 
            
            return false;
        }
        addData(table, emps);
        return true;
    }
    
    @Override
    public boolean confirmDelete(String s) {
        return ScannerUtil.comfirmWindow(s);
    }
    
    @Override
    public Integer getEmployeeId(JTable table) {
        isSelectedRow(table);

        int selectedRow = table.getSelectedRow();
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        Object value = model.getValueAt(selectedRow, 0);

        try {
            return Integer.valueOf(value.toString());
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null,
                    "ID không hợp lệ!",
                    "Lỗi", JOptionPane.ERROR_MESSAGE
            );
            return null;
        }
    }

    
    
}
