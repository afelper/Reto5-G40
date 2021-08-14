package reto4.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.List;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.WindowConstants;
import javax.swing.JScrollPane;
import javax.swing.JOptionPane;


import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;


import reto4.controller.ControladorRequerimientosReto4;
import reto4.model.vo.LideresMayorSalario;
import reto4.model.vo.LideresProyectosEmblematicos;
import reto4.model.vo.MaterialRankeadoImportado;

public class FPrincipal extends JFrame {

    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JTabbedPane panelPestanas;
    private ControladorRequerimientosReto4 controller;
    private JTable tabla;
    private JTable tabla2;
    private JTable tabla3;

    public FPrincipal(){
        controller = new ControladorRequerimientosReto4();
        initGUI();
        setLocationRelativeTo(null);// centrar ventanas
    }

    private void initGUI(){
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setTitle("Nosotros Fuimos /Requerimientos Reto 5");
        {
            panelPestanas = new JTabbedPane();
            getContentPane().add(panelPestanas, BorderLayout.CENTER);
            {
                panel1 = new JPanel(); // crear la primera pestaña
                panel1.setLayout(new BorderLayout());//Ordenar posiciones de botones y tablas
                panelPestanas.addTab("Líderes con mayor salario", new ImageIcon("img/cash.png") ,panel1);
                var panelEntrada = new JPanel();
                var btnConsulta = new JButton("Consultar");
                panelEntrada.add(btnConsulta);
                panel1.add(panelEntrada, BorderLayout.PAGE_START);
                tabla = new JTable();
                panel1.add(new JScrollPane(tabla), BorderLayout.CENTER);
                btnConsulta.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        consultarRequerimientoUno();
                    }
                    
                });
            }
            {
                panel2 = new JPanel(); //creación de segunda pestaña
                panel2.setLayout(new BorderLayout());
                panelPestanas.addTab("Líderes proyectos emblemáticos",new ImageIcon("img/leader.png"), panel2);
                var panelEntrada2 = new JPanel();
                var btnConsulta2 = new JButton("Consultar");
                panelEntrada2.add(btnConsulta2);
                panel2.add(panelEntrada2, BorderLayout.PAGE_START);
                tabla2 = new JTable();
                panel2.add(new JScrollPane(tabla2), BorderLayout.CENTER);
                btnConsulta2.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        consultarRequerimientoDos();
                    }
                    
                });
            }
            {
                panel3 = new JPanel(); //creación de tercera pestaña
                panel3.setLayout(new BorderLayout());
                panelPestanas.addTab("Productos importados",new ImageIcon("img/tool10.png"), panel3);
                var panelEntrada3 = new JPanel();
                var btnConsulta3 = new JButton("Consultar");
                panelEntrada3.add(btnConsulta3);
                panel3.add(panelEntrada3, BorderLayout.PAGE_START);
                tabla3 = new JTable();
                //tabla3.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);
                panel3.add(new JScrollPane(tabla3), BorderLayout.CENTER); 
                btnConsulta3.addActionListener(new ActionListener(){

                    @Override
                    public void actionPerformed(ActionEvent e) {
                        consultarRequerimientoTres();
                    }
                    
                });

            }
        }
        setSize(650,400); //tamaño de pantalla
    }

    private void consultarRequerimientoUno(){
        try {
            var lista = controller.requerimiento1();
            var tableModel = new LidereSueldoTableModel();
            tableModel.setData(lista);
   
            tabla.setModel(tableModel);
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }       
       }


    //Modelo de la tabla de líderes con mayor salario 
    private class LidereSueldoTableModel extends AbstractTableModel{

        private List<LideresMayorSalario> data;

        public void setData(List<LideresMayorSalario> data) {
            this.data = data;
        }

        //Nombres de las columnas
        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "ID_Lider";
                case 1:
                    return "Nombre";
                case 2:
                    return "Primer_Apellido";
                default:
                    break;
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return  data.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var project = data.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return project.getID_Lider();
                case 1:
                    return project.getNombre();
                case 2:
                    return project.getPrimer_Apellido();
                default:
                    break;
            }
            return null;
        }


    }

    //Datos de la segunda pestaña
    private void consultarRequerimientoDos(){
        try {
            var lista = controller.requerimiento2();
            var tableModel = new LideresProyectoTableModel();
            tableModel.setData(lista);
   
            tabla2.setModel(tableModel);
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }       
       }

    //Segunda Consulta
    //Modelo de la tabla de líderes proyectos emblemáticos
    private class LideresProyectoTableModel extends AbstractTableModel{

        private List<LideresProyectosEmblematicos> data;

        public void setData(List<LideresProyectosEmblematicos> data) {
            this.data = data;
        }

        //Nombres de las columnas
        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Id_Lider";
                case 1:
                    return "Id_Proyecto";
                case 2:
                    return "Id_Tipo";
                default:
                    break;
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return  data.size();
        }

        @Override
        public int getColumnCount() {
            return 3;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var project = data.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return project.getID_Lider();
                case 1:
                    return project.getID_Proyecto();
                case 2:
                    return project.getID_Tipo();
                default:
                    break;
            }
            return null;
        }
    }

    //Datos de la tercera pestaña
    //consulta 3
    private void consultarRequerimientoTres(){
        try {
            var lista = controller.requerimiento3();
            var tableModel = new MaterialImportadoTableModel();
            tableModel.setData(lista);
   
            tabla3.setModel(tableModel);
   
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }       
       }
    //MaterialRankeadoImportado
    //Modelo de la tabla de líderes proyectos emblemáticos
    private class MaterialImportadoTableModel extends AbstractTableModel{

        private List<MaterialRankeadoImportado> data;

        public void setData(List<MaterialRankeadoImportado> data) {
            this.data = data;
        }

        //Nombres de las columnas
        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Productos Importados";
                default:
                    break;
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return  data.size();
        }

        @Override
        public int getColumnCount() {
            return 1;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var project = data.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return "El producto de ID " + project.getID_MaterialConstruccion() 
                    + " de descripción: " + project.getNombre_Material() +
                    " de tipo importado(a), tiene un  precio de "
                    + project.getPrecio_Unidad();
                default:
                    break;
            }
            return null;
        }
    }
}
