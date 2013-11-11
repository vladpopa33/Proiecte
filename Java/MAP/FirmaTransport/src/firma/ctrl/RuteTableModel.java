package firma.ctrl;

import firma.model.Ruta;

import javax.swing.table.AbstractTableModel;

/**
 * Created by IntelliJ IDEA.
 * User: grigo
 * Date: Nov 19, 2011
 * Time: 12:20:36 AM
 */
public class RuteTableModel extends AbstractTableModel {
    private String[] numeCol={"Plecare", "Destinatie"};
    private Ruta[] rute;

    public RuteTableModel() {
        rute=new Ruta[0];
    }

    public int getRowCount() {
        return rute.length;
    }

    public int getColumnCount() {
        return numeCol.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        if (columnIndex==0)
            return rute[rowIndex].getPlecare();
        if (columnIndex==1)
            return rute[rowIndex].getDestinatie();
        return null;
    }

    public void setRute(Ruta[] rute){
        this.rute=rute;
        fireTableDataChanged();
    }

    @Override
    public String getColumnName(int column) {
        return numeCol[column];
    }

    public Ruta get(int index){
        return rute[index];
    }

    public void clear() {
        rute=new Ruta[0];
        fireTableDataChanged();
    }
}
