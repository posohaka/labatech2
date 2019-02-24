package view;

import control.Manager;
import model.Matrix;

import javax.swing.*;
import javax.xml.bind.JAXBException;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class View extends JFrame {

    private JPanel panel = new JPanel();;
    private  JPanel panelup = new JPanel();
    private  JPanel panelA = new JPanel();
    private  JPanel panelB = new JPanel();
    private JPanel panelbutton = new JPanel();
    private  JPanel panelAone = new JPanel();
    private JPanel panelAtwo = new JPanel();
    private  JPanel panelBone = new JPanel();
    private JPanel panelBtwo = new JPanel();
    private JLabel label11 = new JLabel();
    private JLabel label12 = new JLabel();
    private JLabel label21 = new JLabel();
    private JLabel label22 = new JLabel();
    private JTextArea textArea11 = new JTextArea(1, 7);
    private JTextArea textArea12 = new JTextArea(1, 7);
    private JTextArea textArea21 = new JTextArea(1, 7);
    private JTextArea textArea22 = new JTextArea(1, 7);
    private JButton buttonsum = new JButton("A = A + B");
    private JButton buttonmultiAB = new JButton("A = A * B");
    private JButton buttonmultiBA = new JButton("A = B * A");
    private Matrix matrix;
    private Manager manager;

    public View() throws JAXBException {
        super();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 400);
        add(panel);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(panelup);
        panelup.setLayout(new BoxLayout(panelup, BoxLayout.X_AXIS));
        panelup.add(panelA);
        panelup.add(panelB);
        panelA.setLayout(new BoxLayout(panelA, BoxLayout.Y_AXIS));
        panelA.add(new JLabel("A"));
        panelA.add(panelAone);
        panelA.add(panelAtwo);

        manager = new Manager();
        update(manager);

        panelAone.add(label11);
        panelAone.add(label12);
        panelAtwo.add(label21);
        panelAtwo.add(label22);



        panelB.setLayout(new BoxLayout(panelB, BoxLayout.Y_AXIS));
        panelB.add(new JLabel("B"));
        panelB.add(panelBone);
        panelB.add(panelBtwo);
        panelBone.add(textArea11);
        panelBone.add(textArea12);
        panelBtwo.add(textArea21);
        panelBtwo.add(textArea22);

        panel.add(panelbutton);
        panelbutton.setLayout(new BoxLayout(panelbutton, BoxLayout.X_AXIS));
        panelbutton.add(buttonsum);
        panelbutton.add(buttonmultiAB);
        panelbutton.add(buttonmultiBA);

       buttonsum.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               try {
                   Matrix matrixB = getMatrix();
                   matrix.sumMatrix(matrixB);
                   manager.setMatrix(matrix);
                   update(manager);
               } catch (Exception e) {
                   JOptionPane.showMessageDialog(View.this, "Введите правильные значения", "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
               }
           }
       });
       buttonmultiAB.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               try {
                   Matrix matrixB = getMatrix();
                   matrix.mulipMatrixleft(matrixB);
                   manager.setMatrix(matrix);
                   update(manager);
               } catch (JAXBException e) {
                   e.printStackTrace();
               }
               catch (Exception e) {
                   JOptionPane.showMessageDialog(View.this, "Введите правильные значения", "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
               }
           }
       });
       buttonmultiBA.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent actionEvent) {
               try {
                   Matrix matrixB = getMatrix();
                   matrix.mulipMatrixright(matrixB);
                   manager.setMatrix(matrix);
                   update(manager);
               } catch (JAXBException e) {
                   e.printStackTrace();
               }
               catch (Exception e) {
                   JOptionPane.showMessageDialog(View.this, "Введите правильные значения", "Ошибка ввода", JOptionPane.WARNING_MESSAGE);
               }
           }
       });
    }

    private Matrix getMatrix() {
        double a11 = Double.parseDouble(textArea11.getText());
        double a12 = Double.parseDouble(textArea12.getText());
        double a21 = Double.parseDouble(textArea21.getText());
        double a22 = Double.parseDouble(textArea22.getText());
        return new Matrix(a11, a12, a21, a22);
    }

    private void update(Manager manager) throws JAXBException {
        matrix = manager.getMatrix();
        label11.setText(String.valueOf(matrix.getA11()));
        label12.setText(String.valueOf(matrix.getA12()));
        label21.setText(String.valueOf(matrix.getA21()));
        label22.setText(String.valueOf(matrix.getA22()));
    }
}
