import javax.swing.*;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

public class MainForm {
    private JPanel mainPanel;
    private JTextField textFieldSurname;
    private JTextField textFieldName;
    private JTextField textFieldSecondName;
    private JPanel collapsePanel;
    private JPanel expandPanel;
    private JTextField textFieldFio;
    private JButton button1;
    private JLabel labelSurname;
    private JLabel labelFio;
    private JLabel labelName;
    private JLabel labelSecondName;

    public MainForm() {

        checkButton();

        button1.addActionListener(new Action() {
            @Override
            public Object getValue(String key) {
                return null;
            }

            @Override
            public void putValue(String key, Object value) {

            }

            @Override
            public void setEnabled(boolean b) {

            }

            @Override
            public boolean isEnabled() {
                return false;
            }

            @Override
            public void addPropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void removePropertyChangeListener(PropertyChangeListener listener) {

            }

            @Override
            public void actionPerformed(ActionEvent e) {
                checkFillTextsFields();
            }
        });
    }
    public JPanel getMainForm() {
        return mainPanel;
    }

    private void checkButton() {
        if (button1.getText() == "Collapse") {
            expandPanel.setVisible(false);
            collapsePanel.setVisible(true);
        }
        if (button1.getText() == "Expand"){
            collapsePanel.setVisible(false);
            expandPanel.setVisible(true);
        }
    }

    private void checkFillTextsFields() {
        String[] textFio = new String[0];
        if (button1.getText() == "Collapse") {
            if (textFieldSurname.getText().isEmpty() || textFieldName.getText().isEmpty()) {
                JOptionPane.showMessageDialog(
                        mainPanel,
                        "Введите фамилию и имя",
                        "Alert ERROR!!!",
                        JOptionPane.PLAIN_MESSAGE
                );
            }
            else {
                pushButtonCollapse();
            }
        }
        if (button1.getText() == "Expand") {
            textFio = textFieldFio.getText().split("\\s");
            if (textFio.length < 2 || textFio.length > 3) {
                JOptionPane.showMessageDialog(
                        mainPanel,
                        "Введите фамилию и имя верно",
                        "Alert ERROR!!!",
                        JOptionPane.PLAIN_MESSAGE
                );
            }
            else {
                pushButtonExpand(textFio);
            }
        }
    }

    private void pushButtonCollapse() {
        String total = textFieldSurname.getText().concat(" ").concat(textFieldName.getText()).concat(" ");
        textFieldFio.setText(total);
       // System.out.println(total);
        expandPanel.setVisible(true);
        collapsePanel.setVisible(false);
        button1.setText("Expand");
    }

    private void pushButtonExpand(String[] textFio) {
        if (textFio.length == 2) {
            textFieldSurname.setText(textFio[0]);
            textFieldName.setText(textFio[1]);
            textFieldSecondName.setText("");
        }
        else {
            textFieldSurname.setText(textFio[0]);
            textFieldName.setText(textFio[1]);
            textFieldSecondName.setText(textFio[2]);
        }

        collapsePanel.setVisible(true);
        expandPanel.setVisible(false);
        button1.setText("Collapse");
    }
}
