/**
 * File generated by the ThingML IDE
 * /!\Do not edit this file/!\
 * In case of a bug in the generated code,
 * please submit an issue on our GitHub
 **/

package org.thingml.generated;
import org.sintef.smac.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;
import java.text.SimpleDateFormat;
import scala.collection.immutable.$colon$colon;

public class TemperatureSensorScalaMock extends ReactiveComponent implements ActionListener {

@Override
public void onIncomingMessage(SignedEvent e) {
print(e.event().name() + "_via_" + e.port().name(), dateFormat.format(new Date()) + ": " + e.event().toString());
}
Port port_TemperatureSensorScala_TemperatureSensor = null;

java.util.List<TemperatureSensorScalaListener> listeners = new java.util.LinkedList<TemperatureSensorScalaListener>();

public TemperatureSensorScalaMock(){
scala.collection.immutable.List<String> rec = null;
scala.collection.immutable.List<String> sent = null;
rec = scala.collection.immutable.List$.MODULE$.empty();
sent = scala.collection.immutable.List$.MODULE$.empty();
rec = new $colon$colon("read_temperature", rec);
sent = new $colon$colon("temperature_value", sent);
port_TemperatureSensorScala_TemperatureSensor = (Port) new Port("TemperatureSensor", rec, sent, this).start();
init();}

private SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMM yyy 'at' HH:mm:ss.SSS");private JTabbedPane tabbedPane = new JTabbedPane();
private JFrame frame;
private JPanel frame_TemperatureSensor;
private JTextPane screen;
private JButton clearButton;
private StyledDocument doc;

//Attributes related to temperature_value via TemperatureSensor
public JButton sendtemperature_value_via_TemperatureSensor;
private JTextField fieldtemperature_value_via_TemperatureSensor_Val;
public JButton getSendtemperature_value_via_TemperatureSensor() {
return sendtemperature_value_via_TemperatureSensor;
}

public JTextField getFieldtemperature_value_via_TemperatureSensor_Val() {
return fieldtemperature_value_via_TemperatureSensor_Val;
}

public void disableAll() {
sendtemperature_value_via_TemperatureSensor.setEnabled(false);
}

public void enableAll() {
sendtemperature_value_via_TemperatureSensor.setEnabled(true);
}

public void print(String id, String data){
try {
doc.insertString(doc.getLength(), formatForPrint(data), doc.getStyle("receive"+id+"Style"));
screen.setCaretPosition(doc.getLength());
} catch (BadLocationException ex) {
ex.printStackTrace();
}
}

public void addListener(ActionListener l){
sendtemperature_value_via_TemperatureSensor.addActionListener(l);
}

private void init(){
GridBagConstraints c = new GridBagConstraints();
c.gridwidth = 1;
c.fill = GridBagConstraints.HORIZONTAL;
c.insets = new Insets(0,3,0,3);
clearButton = new JButton("Clear Console");
c.gridy = 0;
c.gridx = 0;
frame = new JFrame("TemperatureSensorScala Mock Simulator");
frame.setLayout(new GridBagLayout());
frame.add(tabbedPane, c);
frame_TemperatureSensor = new JPanel();
frame_TemperatureSensor.setLayout(new GridBagLayout());
//GUI related to TemperatureSensor_via_TemperatureSensor => temperature_value
c.gridy = 0;
c.gridx = 0;
frame_TemperatureSensor.add(createLabel("temperature_value"), c);
c.gridy = 1;
c.gridx = 0;
frame_TemperatureSensor.add(createtemperature_value_via_TemperatureSensorPanel(), c);
c.gridy = 2;
c.gridx = 0;
sendtemperature_value_via_TemperatureSensor = createSendButton("TemperatureSensor => temperature_value");
frame_TemperatureSensor.add(sendtemperature_value_via_TemperatureSensor, c);
tabbedPane.addTab("TemperatureSensor", frame_TemperatureSensor);
c.gridy = 1;
c.gridx = 0;
c.gridwidth = 1;
frame.add(createJTextPane(), c);
c.gridy = 2;
frame.add(clearButton, c);
frame.pack();
clearButton.addActionListener(this);
addListener(this);
frame.setVisible(true);
}

public static JLabel createLabel(String name){
return new JLabel(name);
}

public static JButton createSendButton(String name){
return new JButton("send");
}

public JPanel createtemperature_value_via_TemperatureSensorPanel(){
GridBagConstraints c = new GridBagConstraints();
c.fill = GridBagConstraints.HORIZONTAL;
c.weightx = 0.5;
JPanel panel = new JPanel(new GridBagLayout());
JLabel labelval = new JLabel();
labelval.setText("val");
c.gridx = 0;
c.gridy = 0;
panel.add(labelval, c);
fieldtemperature_value_via_TemperatureSensor_Val = new JTextField();
fieldtemperature_value_via_TemperatureSensor_Val.setText("val");
c.gridx = 1;
c.gridy = 0
;panel.add(fieldtemperature_value_via_TemperatureSensor_Val, c);
return panel;
}

public JScrollPane createJTextPane(){
screen = new JTextPane();
screen.setFocusable(false);
screen.setEditable(false);
screen.setAutoscrolls(true);
JScrollPane editorScrollPane = new JScrollPane(screen);
editorScrollPane.setVerticalScrollBarPolicy(
JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
editorScrollPane.setPreferredSize(new Dimension(480, 240));
editorScrollPane.setMinimumSize(new Dimension(320, 160));
doc = screen.getStyledDocument();
Style def = StyleContext.getDefaultStyleContext().getStyle(StyleContext.DEFAULT_STYLE);
Style receiveread_temperature_via_TemperatureSensorStyle = doc.addStyle("receiveread_temperature_via_TemperatureSensorScala_TemperatureSensorStyle", def);
StyleConstants.setForeground(receiveread_temperature_via_TemperatureSensorStyle, new Color(160, 143, 164));
return editorScrollPane;
}

private String formatForPrint(String text) {
return (text.endsWith("\n") ? text : text + "\n");
}

@Override
public void actionPerformed(ActionEvent ae) {
if (ae.getSource() == clearButton){
screen.setText("");
}
else if ( ae.getSource() == getSendtemperature_value_via_TemperatureSensor()) {
port_TemperatureSensorScala_TemperatureSensor.send(new Temperature_value(new Integer(getFieldtemperature_value_via_TemperatureSensor_Val().getText()), Temperature_value$.MODULE$.getName()));
for(TemperatureSensorScalaListener l : listeners)
l.onTemperature_value_via_TemperatureSensor(new Integer(getFieldtemperature_value_via_TemperatureSensor_Val().getText()));
}
}

public static void main(String args[]){
TemperatureSensorScalaMock mock = new TemperatureSensorScalaMock();
TemperatureSensorScalaMockMirror mockMirror = new TemperatureSensorScalaMockMirror();
Channel c_TemperatureSensor_8865133 = new Channel();
c_TemperatureSensor_8865133.connect(mock.port_TemperatureSensorScala_TemperatureSensor, mockMirror.port_TemperatureSensorScala_TemperatureSensor);
c_TemperatureSensor_8865133.connect(mockMirror.port_TemperatureSensorScala_TemperatureSensor, mock.port_TemperatureSensorScala_TemperatureSensor);
c_TemperatureSensor_8865133.start();
}
}

