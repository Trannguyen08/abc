package utc2.apartmentManage.service.interfaces;

import javax.swing.*;
import utc2.apartmentManage.model.Service;

public interface IService {
    public boolean loadSelectedRowData(JTable table, JTextField serviceName, JComboBox<String> serviceType,
                                       JComboBox<String> relevant, JTextField price, JTextField unit, JTextArea description);
    public boolean getFilterServiceByIcon(Service service, double toPrice, JTable table);
    public boolean confirmDelete(String s);
    
}
