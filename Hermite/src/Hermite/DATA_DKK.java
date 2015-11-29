//    public void Fungsi1(int i,float x){
//        DefaultTableModel Input_Table = (DefaultTableModel) Table_Input.getModel();
//        double answera = round((x*Math.log(x)),7);
//        double answerb = round((Math.log(x)+1),7);
//        System.out.println(roundf(x,1));
//        Input_Table.addRow(new Object[]{i,x,answera,answerb});
//        Label_Aprox.setText("Aprox : F(" + Numx +")");
//        float nilaix = Float.parseFloat(TXT_KN.getText());
//        double hasil = round((nilaix*Math.log(nilaix)),7);
//        Eksak_Nilai.setText(String.valueOf(hasil));
//    }
//    
//    public void Fungsi2(int i,float x){
//        DefaultTableModel Input_Table = (DefaultTableModel) Table_Input.getModel();
//        double answera = round(((x*Math.cos(x))-(2*Math.pow(x, 2))+(3*x-1)),7);
//        double answerb = round((Math.cos(x)-(x*Math.sin(x))-(4*x)),7);
//        System.out.println(roundf(x,1));
//        Input_Table.addRow(new Object[]{i,x,answera,answerb});
//        Label_Aprox.setText("Aprox : F(" + Numx +")");
//        float nilaix = Float.parseFloat(TXT_KN.getText());
//        double hasil = round(((nilaix*Math.cos(x))-(2*Math.pow(nilaix, 2))+(3*nilaix-1)),7);
//        Eksak_Nilai.setText(String.valueOf(hasil));
//    }
//    
//    public void Fungsi3(int i,float x){
//        DefaultTableModel Input_Table = (DefaultTableModel) Table_Input.getModel();
//        double answera = round(((Math.pow(x, 3)+(4.001*Math.pow(x, 2))+(4.002*x)+1.101)),7);
//        double answerb = round(((3*Math.pow(x, 2))+(8.002*x)+4.002),7);
//        System.out.println(roundf(x,1));
//        Input_Table.addRow(new Object[]{i,x,answera,answerb});
//        Label_Aprox.setText("Aprox : F(" + Numx +")");
//        float nilaix = Float.parseFloat(TXT_KN.getText());
//        double hasil = round(((Math.pow(nilaix, 3)+(4.001*Math.pow(nilaix, 2))+(4.002*nilaix)+1.101)),7);
//        Eksak_Nilai.setText(String.valueOf(hasil));
//    }
//    
//    public void Fungsi4(int i,float x){
//        DefaultTableModel Input_Table = (DefaultTableModel) Table_Input.getModel();
//        double answera = round(Math.sin((Math.exp(x)-2)),7);
//        double answerb = round(Math.sin((Math.exp(x)*Math.cos((Math.exp(2)-2)))),7);
//        System.out.println(roundf(x,1));
//        Input_Table.addRow(new Object[]{i,x,answera,answerb});
//        Label_Aprox.setText("Aprox : F(" + Numx +")");
//        float nilaix = Float.parseFloat(TXT_KN.getText());
//        double hasil = round(Math.sin((Math.exp(nilaix)-2)),7);
//        Eksak_Nilai.setText(String.valueOf(hasil));
//    }
//    
//    public void Fungsi5(int i,float x){
//        DefaultTableModel Input_Table = (DefaultTableModel) Table_Input.getModel();
//        double answera = round(Math.pow(Math.E,(2*x)),7);
//        double answerb = round((2*Math.pow(Math.E,(2*x))),7);
//        System.out.println(roundf(x,1));
//        Input_Table.addRow(new Object[]{i,x,answera,answerb});
//        Label_Aprox.setText("Aprox : F(" + Numx +")");
//        float nilaix = Float.parseFloat(TXT_KN.getText());
//        double hasil = round(Math.pow(Math.E,(2*nilaix)),7);
//        Eksak_Nilai.setText(String.valueOf(hasil));
//    }

//    public void Input(){
//        i=Table_Input.getRowCount();
////        Numx = Float.parseFloat(TXT_X2.getText());
//        switch(choice){
//            case 1:
//                Fungsi1(i,Numx);
//                break;
//            case 2:
//                Fungsi2(i,Numx);
//                break;
//            case 3:
//                Fungsi3(i,Numx);
//                break;
//            case 4:
//                Fungsi4(i,Numx);
//                break;
//            case 5:
//                Fungsi5(i,Numx);
//                break;
//        }
//    }
//
//    public void chart2(){
//        final XYSeries series = new XYSeries("Perbandingan Data X dan Y Dari f(x)");
//        for(i=0;i<Table_Input.getRowCount();i++)
//        {
//            float angka1 = Float.parseFloat(Table_Input.getValueAt(i, 1).toString());
//            float angka2 = Float.parseFloat(Table_Input.getValueAt(i, 2).toString());
//            series.add(angka1, angka2);
//        }
//        final XYSeriesCollection data = new XYSeriesCollection(series);
//        final JFreeChart chart = ChartFactory.createXYLineChart("X Dan Y Dari F(X)","X", "Y", data,PlotOrientation.VERTICAL,true,true,false);
//
//        final XYPlot plot = chart.getXYPlot( );
//        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer( );
//        renderer.setSeriesPaint( 0 , Color.RED );
//        renderer.setSeriesPaint( 1 , Color.BLUE );
//        renderer.setSeriesStroke( 0 , new BasicStroke( 3.0f ) );
//        renderer.setSeriesStroke( 1 , new BasicStroke( 3.0f ) );
//        plot.setRenderer( renderer );
//        ChartFrame frame = new ChartFrame("Perbandingan", chart);
//        frame.setVisible(true);
//        frame.setSize(750,500);
//          
//    }

//    public void Chart(){
//        Double a = Double.parseDouble(Eksak_Nilai.getText());
//        Double b = Double.parseDouble(AproxHasil.getText());
////        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
//        dataset.addValue(0 , "Eksak" , "Nilai Awal" );
//        dataset.addValue(a , "Eksak" , "Nilai Akhir" );
//        dataset.addValue(0 , "Aprox" ,  "Nilai Awal" );
//        dataset.addValue(b , "Aprox" , "Nilai Akhir" );     
////        JFreeChart chart = ChartFactory.createLineChart("Perbandingan Aprox Dan Eksak", "Type", "Value", dataset);
////        chart.getTitle().setPaint(Color.white);
////        chart.setBackgroundPaint(Color.black);
////        CategoryPlot p = chart.getCategoryPlot();
////        p.setRangeGridlinePaint(Color.black);
////        p.setBackgroundPaint(Color.lightGray);
////        p.setDomainGridlinePaint(Color.black);
////        ChartFrame frame = new ChartFrame("Perbandingan", chart);
////        frame.setVisible(true);
////        frame.setSize(750,500);
//        JFreeChart chart = ChartFactory.createLineChart(
//            "Pebandingan Nilai Eksak dan Nilai Aprox",       // chart title
//            "Type",                    // domain axis label
//            "Value",                   // range axis label
//            dataset                   // data
//        );
//        
//        chart.setBackgroundPaint(Color.white);
//        final CategoryPlot plot = (CategoryPlot) chart.getPlot();
//        plot.setBackgroundPaint(Color.lightGray);
//        plot.setRangeGridlinePaint(Color.white);
//
//        // customise the range axis...
//        final NumberAxis rangeAxis = (NumberAxis) plot.getRangeAxis();
//        rangeAxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
//        rangeAxis.setAutoRangeIncludesZero(true);
//        
//        final LineAndShapeRenderer renderer = (LineAndShapeRenderer) plot.getRenderer();
////        renderer.setDrawShapes(true);
//
//        renderer.setSeriesStroke(
//            0, new BasicStroke(
//                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
//                1.0f, new float[] {10.0f, 6.0f}, 0.0f
//            )
//        );
//        renderer.setSeriesStroke(
//            1, new BasicStroke(
//                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
//                1.0f, new float[] {6.0f, 6.0f}, 0.0f
//            )
//        );
//        renderer.setSeriesStroke(
//            2, new BasicStroke(
//                2.0f, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND,
//                1.0f, new float[] {2.0f, 6.0f}, 0.0f
//            )
//        );
//        
//        ChartFrame frame = new ChartFrame("Perbandingan", chart);
//        frame.setVisible(true);
//        frame.setSize(750,500);
//
//        
//    }