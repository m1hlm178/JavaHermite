/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hermite;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.math.BigDecimal;
import java.math.RoundingMode;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
//import static jdk.nashorn.internal.objects.NativeMath.round;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartFrame;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

/**
 *
 * @author Susanto
 */
public class Hermite extends javax.swing.JFrame {
int k,n,i,ib,j,a=0,b=0,c=0,row;
int choice = Hermite_New.choice;
public static float[] E = new float [50];
public static float[] X = new float [50];
float Numx,Numa,Numb,Numi,NumRound;
float[] z = new float[100];
float[] x = new float[100];
float [][] Q = new float [100][100];
    /**
     * Creates new form Hermite
     */
    public Hermite() {
        initComponents();
        choice = Hermite_New.choice;
        check();
        TXT_A.setEnabled(false);
        TXT_B.setEnabled(false);
        TXT_I.setEnabled(false);
        B_Add_M.setEnabled(false);
        center();
    }
    
    public void center(){
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
    }
    
    public void check(){
        switch(choice){
            case 1:
                Label_Soal.setText("F(x) = X Ln X");
                break;
            case 2:
                Label_Soal.setText("F(x) = X cos X - 2X^2 + 3X - 1");
                break;
            case 3:
                Label_Soal.setText("F(x) = X^3 + 4.001X^2 + 4.002X + 1.101");
                break;
            case 4:
                Label_Soal.setText("F(x) = Sin(e^x - 2)");
                break;
            case 5:
                Label_Soal.setText("F(x) = e^2x");
                break;
            case 6:
                Label_Soal.setText("F(x) = x^2 cos x - 3x");
                break;
            case 7:
                Label_Soal.setText("F(x) = 3xe^x - e^2x");
                break;
            case 8:
                Label_Soal.setText("F(x) = e^(3x^2)");
                break;
            case 9:
                Label_Soal.setText("F(x) = e^x sin x");
                break;
            case 10:
                Label_Soal.setText("F(x) = ln x");
                break;
            case 11:
                Label_Soal.setText("F(x) = cos x + sin x");
                break;
            case 12:
                Label_Soal.setText("F(x) = sin x");
                break;
            case 13:
                Label_Soal.setText("F(x) = ln(e^x+2)");
                break;
            case 14:
                Label_Soal.setText("Sin(e^x - 2)");
                break;
        }
    }
        
    public void input2(){
        double FX1,FX2;
        float NumXI = Float.parseFloat(TXT_A.getText());
        float NumB = Float.parseFloat(TXT_B.getText());
        float NumInt = Math.abs(Float.parseFloat(TXT_I.getText()));
        float NumXII;
        try{
            if(NumXI<NumB)
            {
                while(NumXI<=NumB)
                {
                    System.out.print(NumXI);
                    NumXII = roundf(NumXI,1);
                    row = Table_Input.getRowCount();
                    DefaultTableModel Input_Table = (DefaultTableModel) Table_Input.getModel();
                    switch(choice){
                        case 1:
                            FX1 = round((NumXII*Math.log(NumXI)),7);
                            FX2 = round((Math.log(NumXII)+1),7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                        case 2:
                            FX1 = round(((NumXII*Math.cos(NumXII))-(2*Math.pow(NumXII, 2))+(3*NumXII-1)),7);
                            FX2 = round((Math.cos(NumXII)-(NumXII*Math.sin(NumXII))-(4*NumXII)),7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                        case 3:
                            FX1 = round(((Math.pow(NumXII, 3)+(4.001*Math.pow(NumXII, 2))+(4.002*NumXII)+1.101)),7);
                            FX2 = round(((3*Math.pow(NumXII, 2))+(8.002*NumXII)+4.002),7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                        case 4:
                            FX1 = round(Math.sin((Math.exp(NumXII)-2)),7);
                            FX2 = round(Math.sin((Math.exp(NumXII)*Math.cos((Math.exp(2)-2)))),7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                        case 5:
                            FX1 = round(Math.pow(Math.E,(2*NumXII)),7);
                            FX2 = round((2*Math.pow(Math.E,(2*NumXII))),7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                        case 6:
                            FX1 = round((Math.pow(NumXI, 2)-(3*NumXI)),7);
                            FX2 = round(((2*NumXI*Math.cos(NumXI))-(Math.pow(NumXI, 2)*Math.sin(NumXI-3))),7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                        case 7:
                            FX1 = round(((3*NumXI)*Math.pow(Math.E, 2*NumXI)-(Math.pow(Math.E, 2*NumXI))),7);
                            FX2 = round(((3*Math.pow(Math.E, NumXI))+(3*NumXI*Math.pow(Math.E, NumXI))-(2*Math.pow(Math.E, (2*NumXI)))),7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                        case 8:
                            FX1 = round((Math.pow(Math.E, (Math.pow(3*NumXI, 2)))),7);
                            FX2 = round((6*NumXI*Math.pow(Math.E, (Math.pow(3*NumXI, 2)))),7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                        case 9:
                            FX1 = round((Math.pow(Math.E, NumXI)*Math.sin(NumXI)),7);
                            FX2 = round((Math.pow(Math.E, NumXI)*(Math.sin(NumXI)+Math.cos(NumXI))),7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                        case 10:
                            FX1 = round((Math.log(NumXI)),7);
                            FX2 = round((1/NumXI),7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                        case 11:
                            FX1 = round((Math.cos(NumXI)+Math.sin(NumXI)),7);
                            FX2 = round((Math.cos(NumXI)-Math.sin(NumXI)),7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                        case 12:
                            FX1 = round((Math.sin(NumXI)),7);
                            FX2 = round((Math.cos(NumXI)),7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                        case 13:
                            FX1 = round((Math.log(Math.pow(Math.E, NumXI))+2),7);
                            FX2 = round((Math.pow(Math.E, NumXI))/(Math.pow(Math.E, NumXI)+2),7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                        case 14:
                            FX1 = round(Math.pow(NumXI, 4)-Math.pow(NumXI, 3)+Math.pow(NumXI, 2)-NumXI+1,7);
                            FX2 = round(4*Math.pow(NumXI, 3)-3*Math.pow(NumXI, 2)+2*NumXI,7);
                            Input_Table.addRow(new Object[]{row,NumXII,FX1,FX2});
                            break;
                    }
                    NumXI += NumInt;
                }
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Angka Yang Anda Masukan Tidak Support Untuk Fungsi Ini!!");
        }
}

    public void eksakinput(){
        float nilaix;
        double hasil;
        nilaix = Float.parseFloat(TXT_KN.getText());
        Label_Aprox.setText("Aprox : F(" + nilaix +")");
            switch(choice){
                case 1:
                    
                    hasil = round((nilaix*Math.log(nilaix)),7);
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
                case 2:
                    hasil = round(((nilaix*Math.cos(nilaix))-(2*Math.pow(nilaix, 2))+(3*nilaix-1)),7);
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
                case 3:
                    hasil = round(((Math.pow(nilaix, 3)+(4.001*Math.pow(nilaix, 2))+(4.002*nilaix)+1.101)),7);
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
                case 4:
                    hasil = round(Math.sin((Math.exp(nilaix)-2)),7);
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
                case 5:
                    hasil = round(Math.pow(Math.E, (2*nilaix)),7);
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
                case 6:
                    hasil = round((Math.pow(nilaix, 2)-(3*nilaix)),7);
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
                case 7:
                    hasil = round(((3*nilaix)*Math.pow(Math.E, 2*nilaix)-(Math.pow(Math.E, 2*nilaix))),7);              
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
                case 8:
                    hasil = round((Math.pow(Math.E, (Math.pow(3*nilaix, 2)))),7);                 
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
                case 9:
                    hasil = round((Math.pow(Math.E, nilaix)*Math.sin(nilaix)),7);                   
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
                case 10:
                    hasil = round((Math.log(nilaix)),7);                 
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
                case 11:
                    hasil = round((Math.cos(nilaix)+Math.sin(nilaix)),7);               
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
                case 12:
                    hasil = round((Math.sin(nilaix)),7);              
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
                case 13:
                    hasil = round((Math.log(Math.pow(Math.E, nilaix))+2),7);               
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
                case 14:
                    hasil = round(Math.pow(nilaix, 4)-Math.pow(nilaix, 3)+Math.pow(nilaix, 2)-nilaix+1,7);               
                    Eksak_Nilai.setText(String.valueOf(hasil));
                    break;
            }
}    
    
    public void Hitung(){
        n = 2*Table_Input.getRowCount()+1;
        i=0;
        a=0;
        while(i<Table_Input.getRowCount())
        {
            z[2*i] = Float.parseFloat(Table_Input.getValueAt(a, 1).toString()); //Pengambilan Z atau angka I
            z[2*i+1] = z[2*i];
            x[i] = Float.parseFloat(Table_Input.getValueAt(a, 1).toString());; // Pemasukan Array Xi dari Xi
            Q[2*i][0] = Float.parseFloat(Table_Input.getValueAt(a, 2).toString()); // Pemasukan Array Dari F(X)
            Q[2*i+1][0] = Float.parseFloat(Table_Input.getValueAt(a, 2).toString()); 
            Q[2*i+1][1] = Float.parseFloat(Table_Input.getValueAt(a, 3).toString());// Pemasukan Array Dari F'(X)
            if(i!=0)
            {
                Q[2*i][1] = ((Q[2*i][0]-Q[2*i-1][0])/(z[2*i]-z[2*i-1])); // Perhitungan Dari Q[I+N)[1]
            }
            i++;
            a++;
        }
        for(i=2;i<n;i++)
        {
            for(j=2;j<=i;j++)
            {
                Q[i][j] = ((Q[i][j-1]-Q[i-1][j-1])/(z[i]-z[i-j])); //Perhitungan dari [2+N][N]
                System.out.println(Q[i][j] + "Hasil : " + (Q[i][j-1]-Q[i-1][j-1]) + "Hasil : " + (z[i]-z[i-j]) + " " + Q[i][j-1] + "-" + Q[i-1][j-1] + " / " + (z[i]-z[i-j] + " i "));
            }
        }
        
        DefaultTableModel QI_TABLE = (DefaultTableModel) QI_Table.getModel();
        DefaultTableModel Z_Table = (DefaultTableModel) Table_Z.getModel();
        for(i=1;i<n;i++)
        {
            if(i!=n-1)
            {
                Z_Table.addRow(new Object[]{"Z("+i+")",z[i]}); //Untuk memasukan Angka Z
            }
            for(j=0;j<=i;j++)
            {
//                System.out.println("q " + i + " " + j +  " : " + Q[i][j]);
                QI_TABLE.addRow(new Object[]{"Q("+i+")("+j+")",Q[i][j]});
            }
        }
//        for(i=0;i<n;i++)
//        {
//            System.out.println("q " + "0" + " " + i +  " : " + Q[0][i]);
        Numx = Float.parseFloat(TXT_KN.getText());
        h((float) Numx); //Untuk perhitungan H(x)
    }
    
    public void h(float x2){
        double answer = 0, tempans = 1, hasil;
        String Step = "";
        int count = 0, k = 0;
        for(i=0;i<2*Table_Input.getRowCount()+1;i++)
        {
            double totalnow = Q[i][i];
            if(i > 0){
                tempans *= (x2 - x[k]);
                count = (count + 1) % 2;
                if(count == 0) ++k;
//                System.out.println("Tempans :" + tempans + "X2 :" + x2 + "X[K] :" + x[k]);
            }
            answer += (totalnow * tempans);
            hasil = round(tempans,7);
            if(i>0)
            {
                Step += "+ Q" +i + "," + i + " * (" + String.valueOf(hasil) +")";
            }else if(i<1)
            {
                Step += "Q " +i + "," + i + " * (" + String.valueOf(hasil) +")";
            }
            
//            System.out.print("Qii = " + totalnow);
//            System.out.print("+ tempans = " + tempans + " : x-x[k] = " + (x2-x[k]));
        }
        TXT_Answer.setText(Step + " = " + answer);
        AproxHasil.setText(String.valueOf(answer));
}
    
    public void newChart(){
        float x = Float.parseFloat(TXT_KN.getText());
        Double a = Double.parseDouble(Eksak_Nilai.getText());
        Double b = Double.parseDouble(AproxHasil.getText());
        XYSeries series1 = new XYSeries("Nilai Eksak");
        series1.add(x, a);
        for(i=0;i<Table_Input.getRowCount();i++)
        {
            series1.add(Float.parseFloat(Table_Input.getValueAt(i, 1).toString()),Double.parseDouble(Table_Input.getValueAt(i, 2).toString()));
        }
        XYSeries series2 = new XYSeries("Interpolasi Hermite F(X)=" + x);
        series2.add(x, b);
        XYSeriesCollection dataset = new XYSeriesCollection();
        dataset.addSeries(series2);
        dataset.addSeries(series1);

        
        JFreeChart chart = ChartFactory.createXYLineChart(
            "Perbandingan Nilai Interpolasi Hermite F(X) = " + x +" Dan Nilai Eksak",
            "Nilai X",
            "Nilai Eksak Dan Hermite",
            dataset,
            PlotOrientation.VERTICAL,
            true,
            false,
            false
        );
        final XYPlot plot = chart.getXYPlot();
        plot.setBackgroundPaint(Color.lightGray);
        plot.setDomainGridlinePaint(Color.white);
        plot.setRangeGridlinePaint(Color.white);
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        renderer.setSeriesLinesVisible(0, true);
//        renderer.setSeriesShapesVisible(0, false);
//        renderer.setSeriesLinesVisible(1, false);
        renderer.setSeriesShapesVisible(1, true);        
        plot.setRenderer(renderer);
        ChartFrame frame = new ChartFrame("Perbandingan", chart);
        frame.setVisible(true);
        frame.setSize(750,500);
        
    }
    

     
    public void saveAprox(){
        
        switch(choice){
                case 1:
                    E[1] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[1] = Float.parseFloat(TXT_KN.getText());
                    break;
                case 2:
                    E[2] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[2] = Float.parseFloat(TXT_KN.getText());
                    break;
                case 3:
                    E[3] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[3] = Float.parseFloat(TXT_KN.getText());
                    break;
                case 4:
                    E[4] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[4] = Float.parseFloat(TXT_KN.getText());
                    break;
                case 5:
                    E[5] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[5] = Float.parseFloat(TXT_KN.getText());
                    break;
                case 16:
                    E[6] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[6] = Float.parseFloat(TXT_KN.getText());
                    break;
                case 7:
                    E[7] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[7] = Float.parseFloat(TXT_KN.getText());
                    break;
                case 8:
                    E[8] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[8] = Float.parseFloat(TXT_KN.getText());
                    break;
                case 9:
                    E[9] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[9] = Float.parseFloat(TXT_KN.getText());
                    break;
                case 10:
                    E[10] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[10] = Float.parseFloat(TXT_KN.getText());
                    break;
                case 11:
                    E[11] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[11] = Float.parseFloat(TXT_KN.getText());
                    break;
                case 12:
                    E[12] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[12] = Float.parseFloat(TXT_KN.getText());
                    break;
                case 13:
                    E[13] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[13] = Float.parseFloat(TXT_KN.getText());
                    break;
                case 14:
                    E[14] = (((Float.parseFloat(Eksak_Nilai.getText())-Float.parseFloat(AproxHasil.getText()))/Float.parseFloat(Eksak_Nilai.getText()))*100)/100;
                    X[14] = Float.parseFloat(TXT_KN.getText());
                    break;
            }
    }
    
    public void clear(){
        TXT_A.setText("");
        TXT_B.setText("");
        TXT_I.setText("");
    }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }

    public static float roundf(float value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.floatValue();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        Group_B = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        TXT_KN = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        Table_Input = new javax.swing.JTable();
        B_Add_I = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        C_B = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Table_Z = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        B_B = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        QI_Table = new javax.swing.JTable();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        Label_Soal = new javax.swing.JLabel();
        Label_Aprox = new javax.swing.JLabel();
        AproxHasil = new javax.swing.JLabel();
        Eksak_Nilai = new javax.swing.JLabel();
        B_Int = new javax.swing.JRadioButton();
        B_M = new javax.swing.JRadioButton();
        TXT_A = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        B_Add_M = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        TXT_Answer = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        B_R = new javax.swing.JButton();
        B_Change = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        TXT_B = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        TXT_I = new javax.swing.JTextField();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Interpolasi Hermite", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        jLabel1.setText("X :");

        Table_Input.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Orde", "Xi", "F(Xi)", "F'(Xi)"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(Table_Input);

        B_Add_I.setBackground(new java.awt.Color(255, 255, 0));
        B_Add_I.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        B_Add_I.setText("SUBMIT");
        B_Add_I.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Add_IActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(0, 255, 0));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setText("CALCULATE");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        C_B.setBackground(new java.awt.Color(0, 204, 0));
        C_B.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        C_B.setText("TAMPILKAN CHART");
        C_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                C_BActionPerformed(evt);
            }
        });

        Table_Z.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Z[i]", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane2.setViewportView(Table_Z);

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hermite/Img/1.JPG"))); // NOI18N

        B_B.setBackground(new java.awt.Color(255, 0, 0));
        B_B.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        B_B.setText("BACK");
        B_B.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_BActionPerformed(evt);
            }
        });

        QI_Table.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Qi,i", "Data"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(QI_Table);
        if (QI_Table.getColumnModel().getColumnCount() > 0) {
            QI_Table.getColumnModel().getColumn(0).setResizable(false);
            QI_Table.getColumnModel().getColumn(0).setPreferredWidth(50);
            QI_Table.getColumnModel().getColumn(1).setResizable(false);
        }

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hermite/Img/2.JPG"))); // NOI18N

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Function", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        Label_Soal.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        Label_Aprox.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));

        AproxHasil.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nilai Hermite", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        Eksak_Nilai.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Nilai Eksak", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Label_Soal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(AproxHasil, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Eksak_Nilai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addComponent(Label_Aprox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(Label_Soal, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Label_Aprox, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Eksak_Nilai, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(AproxHasil, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        Group_B.add(B_Int);
        B_Int.setSelected(true);
        B_Int.setText("AutoMatic");
        B_Int.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_IntActionPerformed(evt);
            }
        });

        Group_B.add(B_M);
        B_M.setText("Interval");
        B_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_MActionPerformed(evt);
            }
        });

        jLabel9.setText("Xi Awal : ");

        B_Add_M.setBackground(new java.awt.Color(255, 255, 0));
        B_Add_M.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        B_Add_M.setText("ADD");
        B_Add_M.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_Add_MActionPerformed(evt);
            }
        });

        TXT_Answer.setColumns(20);
        TXT_Answer.setRows(5);
        jScrollPane4.setViewportView(TXT_Answer);

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hermite/Img/3.JPG"))); // NOI18N

        B_R.setBackground(new java.awt.Color(204, 0, 204));
        B_R.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        B_R.setText("RESET");
        B_R.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_RActionPerformed(evt);
            }
        });

        B_Change.setText("Change");
        B_Change.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                B_ChangeActionPerformed(evt);
            }
        });

        jLabel10.setText("Xi Akhir : ");

        jLabel11.setText("Xi Int : ");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addGap(39, 39, 39)
                                            .addComponent(jLabel5)))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                            .addGap(0, 0, Short.MAX_VALUE)
                                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(26, 26, 26))))
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 483, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(B_Int)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(B_Add_I, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXT_KN, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(B_Change, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(B_M)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXT_A, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXT_B, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TXT_I, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(B_Add_M, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 22, Short.MAX_VALUE)))
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane4)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, 537, Short.MAX_VALUE)
                        .addContainerGap())
                    .addComponent(C_B, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(B_R, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(B_B, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B_Int)
                            .addComponent(B_Add_I)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(TXT_KN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_Change))
                        .addGap(9, 9, 9)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(B_M)
                            .addComponent(jLabel9)
                            .addComponent(TXT_A, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel10)
                            .addComponent(TXT_B, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_Add_M, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11)
                            .addComponent(TXT_I, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)))
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(C_B, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(B_B, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(B_R, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void B_Add_IActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Add_IActionPerformed
        // Input Data Ke Jtable
        if(Table_Input.getRowCount()==0)
        {
            DefaultTableModel model = (DefaultTableModel) Table_Input.getModel();
            choice = Hermite_New.choice;
            switch(choice){
                case 1:
                TXT_KN.setText("8.4");
                model.addRow(new Object[]{"0","8.3","17.56492","3.116256"});
                model.addRow(new Object[]{"1","8.6","18.50515","3.151762"});
                   break;
                case 2:
                TXT_KN.setText("0.25");
                model.addRow(new Object[]{"0","0.1","-0.62049958","3.58502082"});
                model.addRow(new Object[]{"1","0.2","-0.28398668","3.14033271"});
                model.addRow(new Object[]{"2","0.3","0.00660095","2.66668043"});
                model.addRow(new Object[]{"3","0.4","0.2484244","2.16529366"});
                   break;
                case 3:
                TXT_KN.setText("-0.3333");
                model.addRow(new Object[]{"0","-0.4","0.07636","1.2812"});
                model.addRow(new Object[]{"1","-0.3","0.23349","1.871399"});
                model.addRow(new Object[]{"2","-0.2","0.45264","2.5216"});
                model.addRow(new Object[]{"3","-0.1","0.73981","3.2318"});
                   break;
                case 4:
                TXT_KN.setText("0.9");
                model.addRow(new Object[]{"0","0.8","0.22363362","2.1691753"});
                model.addRow(new Object[]{"1","1","0.65809197","2.0466965"});
                   break;
                case 5:
                TXT_KN.setText("0.43");
                model.addRow(new Object[]{"0","0.1","1.2214028","2.44208055"});
                model.addRow(new Object[]{"1","0.2","1.4918247","2.9836494"});
                model.addRow(new Object[]{"2","0.3","1.8221188","3.6442377"});
                model.addRow(new Object[]{"3","0.4","2.22541","4.45108919"});
                model.addRow(new Object[]{"4","0.5","2.7182818","5.4365637"});
                   break;
                case 6:
                TXT_KN.setText("0.18");
                model.addRow(new Object[]{"0","0.1","-0.29004996","-2.8019975"});
                model.addRow(new Object[]{"1","0.2","-0.56079734","-2.6159201"});
                model.addRow(new Object[]{"2","0.3","-0.81401972","-2.453394925"});
                   break;
                case 7:
                TXT_KN.setText("0.5");
                model.addRow(new Object[]{"0","0.2","-0.758983043","1.413400534"});
                model.addRow(new Object[]{"1","0.4","-0.435351291","1.814581873"});
                model.addRow(new Object[]{"2","0.6","-0.040303082","2.105936396"});
                   break;
                case 8:
                TXT_KN.setText("0.8");
                model.addRow(new Object[]{"0","0.3","1.309964451","2.357936011"});
                model.addRow(new Object[]{"1","0.6","2.944679551","10.60084638"});
                model.addRow(new Object[]{"2","0.9","11.35888208","61.33796323"});
                   break;
                case 9:
                TXT_KN.setText("0.7");
                model.addRow(new Object[]{"0","0.4","0.580943901","1.95500544"});
                model.addRow(new Object[]{"1","0.8","1.596505341","3.147054637"});
                model.addRow(new Object[]{"2","1.2","3.094478742","4.297548855"});
                   break;
                case 10:
                TXT_KN.setText("1.4");
                model.addRow(new Object[]{"0","1.2","0.182321557","0.83333333"});
                model.addRow(new Object[]{"1","1.35","0.300104593","0.74074074"});
                model.addRow(new Object[]{"2","1.5","0.40546511","0.6666667"});
                   break;
                case 11:
                TXT_KN.setText("0.3");
                model.addRow(new Object[]{"0","0.25","1.216316381","0.721508462"});
                model.addRow(new Object[]{"1","0.5","1.3570081","0.398157023"});
                   break;
                case 12:
                TXT_KN.setText("2.5");
                model.addRow(new Object[]{"0","1","0.841471","0.540302"});
                model.addRow(new Object[]{"1","2","0.909297","-0.41615"});
                model.addRow(new Object[]{"2","3","0.14112","-0.98999"});
                model.addRow(new Object[]{"3","4","-0.7568","-0.65364"});
                   break;
                case 13:
                TXT_KN.setText("1.25");
                model.addRow(new Object[]{"0","1","1.55144471","0.576116885"});
                model.addRow(new Object[]{"1","2","2.23954477","0.786986042"});
                   break;
                case 14:
                TXT_KN.setText("0.7");
                model.addRow(new Object[]{"0","0.2","0.8336","0.312"});
                model.addRow(new Object[]{"1","0.8","0.7376","1.728"});
                   break;
            }    
        clear();
        } 
    }//GEN-LAST:event_B_Add_IActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        if(Table_Z.getRowCount()>0 || QI_Table.getRowCount()>0)
        {
            DefaultTableModel model1 = (DefaultTableModel) Table_Z.getModel();
            DefaultTableModel model2 = (DefaultTableModel) QI_Table.getModel();
            while(model1.getRowCount() > 0) model1.removeRow(0);
            while(model2.getRowCount() > 0) model2.removeRow(0);
        }
        int checks=0;
        if(TXT_KN.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!!");
        } else {
        if(Table_Input.getRowCount()>0)
        {
            for(i=0;i<Table_Input.getRowCount()-1;i++)
            {
                if(Float.parseFloat(Table_Input.getValueAt(i, 1).toString())==Float.parseFloat(TXT_KN.getText()))
                {
                    checks = 1;
                }
            }
            if(checks==0 && Float.parseFloat(Table_Input.getValueAt(0, 1).toString())<Float.parseFloat(TXT_KN.getText()) && Float.parseFloat(Table_Input.getValueAt(Table_Input.getRowCount()-1, 1).toString())>Float.parseFloat(TXT_KN.getText()))
            {
                Hitung();
                eksakinput();
                saveAprox();
            }else{
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!!");
            }  
        }else{
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!!");
        }}
    }//GEN-LAST:event_jButton1ActionPerformed

    private void C_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_C_BActionPerformed
        // TODO add your handling code here:
        newChart();
    }//GEN-LAST:event_C_BActionPerformed

    private void B_BActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_BActionPerformed
        // TODO add your handling code here:
        new Hermite_New().setVisible(true);
        this.setVisible(false);
        this.dispose();
    }//GEN-LAST:event_B_BActionPerformed

    private void B_IntActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_IntActionPerformed
        // TODO add your handling code here:
        TXT_A.setEnabled(false);
        TXT_B.setEnabled(false);
        TXT_I.setEnabled(false);
        B_Add_M.setEnabled(false);
    }//GEN-LAST:event_B_IntActionPerformed

    private void B_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_MActionPerformed
        // TODO add your handling code here:
        TXT_A.setEnabled(true);
        TXT_B.setEnabled(true);
        TXT_I.setEnabled(true);
        B_Add_M.setEnabled(true);
    }//GEN-LAST:event_B_MActionPerformed

    private void B_Add_MActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_Add_MActionPerformed
        // TODO add your handling code here:
        if(Table_Input.getRowCount()>0 && Table_Z.getRowCount()>0)
        {
            JOptionPane.showMessageDialog(null, "Silakan Mereset Data Terlebih Dahulu!!");
        } else if(TXT_A.getText().isEmpty() == true || TXT_B.getText().isEmpty() == true || TXT_I.getText().isEmpty() == true)
        {
            JOptionPane.showMessageDialog(null, "Silakan Masukan Data Terlebih Dahulu!!");
        } else
        {
            input2();
        }
        
//        float NumA = Float.parseFloat(TXT_A.getText());
//        float NumB = Float.parseFloat(TXT_B.getText());
//        if(NumA<NumB)
//        {
//            JOptionPane.showMessageDialog(null, "Suksesk!!");
//        }
    }//GEN-LAST:event_B_Add_MActionPerformed

    private void B_RActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_RActionPerformed
        // TODO add your handling code here:
        DefaultTableModel TABLE_QI = (DefaultTableModel) QI_Table.getModel();
        DefaultTableModel Z_TABLE = (DefaultTableModel) Table_Z.getModel();
        DefaultTableModel I_TABLE = (DefaultTableModel) Table_Input.getModel();
        while(TABLE_QI.getRowCount() > 0) TABLE_QI.removeRow(0);
        while(Z_TABLE.getRowCount() > 0) Z_TABLE.removeRow(0);
        while(I_TABLE.getRowCount() > 0) I_TABLE.removeRow(0);
        clear();
        AproxHasil.setText("");
        Eksak_Nilai.setText("");
        TXT_Answer.setText("");
    }//GEN-LAST:event_B_RActionPerformed

    private void B_ChangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_B_ChangeActionPerformed
        // TODO add your handling code here:
        int checks=0;
        if(TXT_KN.getText().equals(""))
        {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!!");
        } else {
        if(Table_Input.getRowCount()>0)
        {
            for(i=0;i<Table_Input.getRowCount()-1;i++)
            {
                if(Float.parseFloat(Table_Input.getValueAt(i, 1).toString())==Float.parseFloat(TXT_KN.getText()))
                {
                    checks = 1;
                }
            }
            if(checks==0 && Float.parseFloat(Table_Input.getValueAt(0, 1).toString())<Float.parseFloat(TXT_KN.getText()) && Float.parseFloat(Table_Input.getValueAt(Table_Input.getRowCount()-1, 1).toString())>Float.parseFloat(TXT_KN.getText()))
            {
                eksakinput();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!!");
            }  
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Terjadi Kesalahan Input!!");
        }}
    }//GEN-LAST:event_B_ChangeActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Hermite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Hermite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Hermite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Hermite.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Hermite().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel AproxHasil;
    private javax.swing.JButton B_Add_I;
    private javax.swing.JButton B_Add_M;
    private javax.swing.JButton B_B;
    private javax.swing.JButton B_Change;
    private javax.swing.JRadioButton B_Int;
    private javax.swing.JRadioButton B_M;
    private javax.swing.JButton B_R;
    private javax.swing.JButton C_B;
    private javax.swing.JLabel Eksak_Nilai;
    private javax.swing.ButtonGroup Group_B;
    private javax.swing.JLabel Label_Aprox;
    private javax.swing.JLabel Label_Soal;
    private javax.swing.JTable QI_Table;
    private javax.swing.JTextField TXT_A;
    private javax.swing.JTextArea TXT_Answer;
    private javax.swing.JTextField TXT_B;
    private javax.swing.JTextField TXT_I;
    private javax.swing.JTextField TXT_KN;
    private javax.swing.JTable Table_Input;
    private javax.swing.JTable Table_Z;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    // End of variables declaration//GEN-END:variables
}
