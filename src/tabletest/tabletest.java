package tabletest;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class tabletest
{
    public static void main(String[] args)
    {
        JFrame f=new JFrame();
        DefaultTableModel model = new DefaultTableModel();
        JTable jt=new JTable(model);
        jt.setBounds(30,40,200,300);
        JScrollPane sp=new JScrollPane(jt);

        model.addColumn("Name");
        model.addRow(new Object[]{"Teilnehmer"});
        model.addRow(new Object[]{"Teilnehmer2"});
        model.addRow(new Object[]{"Teilnehmer3"});


        f.add(sp);
        f.setSize(300,400);
        f.setVisible(true);
    }

}

