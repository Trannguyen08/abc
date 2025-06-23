package utc2.apartmentManage.service.interfaces;

import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import utc2.apartmentManage.model.Employee;

public interface IEmployee {
    public boolean loadSelectedRowData(JTable table, JComboBox<String> position, JTextField salary);
    public boolean filterEmployeeIcon(JTable table, Employee emp, double toValue);
    public boolean confirmDelete(String s);
    public Integer getEmployeeId(JTable table);
    
}
