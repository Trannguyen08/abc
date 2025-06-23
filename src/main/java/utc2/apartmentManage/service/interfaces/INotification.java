package utc2.apartmentManage.service.interfaces;

import javax.swing.*;
import utc2.apartmentManage.model.Notification;

public interface INotification {
    public boolean confirmDelete(String s);
    public boolean loadSelectedRowData(JTable table, JTextField title, JTextArea mess, JComboBox<String> type);
    public boolean filterNotification(JTable table, Notification noti);
}
