package week7.kcb;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
//KCBData类负责table的数据，实现了TableModel
public class KCBData implements TableModel {
    private String[] columnNames = {"周一","周二","周三","周四","周五","周六","周日"};
    private String[][] data = new String[8][7];
    //数组对象的初始化
    public KCBData() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 7; j++) {
                data[i][j] = "";
            }
        }
    }
    @Override
    public int getRowCount() {
        return 8;
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return columnNames[columnIndex];
    }
    //每个column返回的都是什么类型的数据
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return true;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return data[rowIndex][columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        data[rowIndex][columnIndex] = aValue.toString();
    }

    @Override
    public void addTableModelListener(TableModelListener l) {

    }

    @Override
    public void removeTableModelListener(TableModelListener l) {

    }
}
