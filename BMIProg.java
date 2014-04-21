// Nader K
// 
// Date: 10/17/2013
// Body Mass Index Calculator Applet with Swing components




import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class BMIProg extends JFrame 
{
     private JLabel nameLabel, heightLabel, weightLabel; 
     private JTextField nameField, heightField, weightField;
     private JButton calculateButton, exitButton;
     
     private CalculateButtonHandler cbHandler;
     private ExitButtonHandler ebHandler;
     private NameFieldHandler  nfHandler;
         
     // create objects from classes
     Person person = new Person();
     HealthyPerson hPerson = new HealthyPerson();

     private static final int WIDTH = 400;
     private static final int HEIGHT = 300;
     
     // CONSTRUCTOR
     public BMIProg()
     {
     // create labels
     nameLabel = new JLabel("Enter Name  ");
     heightLabel  = new JLabel("Enter Height in Inches  ");
     weightLabel = new JLabel("Enter Weight in Pounds  ");
           
     // create textfields
     nameField = new JTextField(10);
     heightField = new JTextField(10);
     weightField = new JTextField(10);
        
     // set alignment of TextFields
     nameField.setHorizontalAlignment(JTextField.RIGHT);
     heightField.setHorizontalAlignment(JTextField.RIGHT);
     weightField.setHorizontalAlignment(JTextField.RIGHT);
                
     // set alignment of labels
     nameLabel.setHorizontalAlignment(JTextField.RIGHT);
     heightLabel.setHorizontalAlignment(JTextField.RIGHT);
     weightLabel.setHorizontalAlignment(JTextField.RIGHT);
               
     // create calculate button
     calculateButton = new JButton("Compute BMI");
     cbHandler = new CalculateButtonHandler();
     calculateButton.addActionListener(cbHandler);
         
         //create exit button
         exitButton = new JButton("Exit");
         ebHandler = new ExitButtonHandler();
         exitButton.addActionListener(ebHandler);
         
         // create name field handler
         nfHandler = new NameFieldHandler();
         nameField.addActionListener(nfHandler);
         
         // set window title
         setTitle("Nader's BMI Calculator");
         
         // get Container
         Container pane = getContentPane();
         
         //set layout
         pane.setLayout(new GridLayout(4, 2));
         
         
         // place components
         pane.add(nameLabel);
         pane.add(nameField);
         pane.add(heightLabel);
         pane.add(heightField);
         pane.add(weightLabel);
         pane.add(weightField);
         pane.add(calculateButton);
         pane.add(exitButton);
         
         // set size of window and display it         
        setSize(WIDTH, HEIGHT);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
                      
      } // end constructor
      
      //nameField Handler - If the user only inputs the name and hits the ENTER KEY,
      // an object of Person is created, and a message about the person is displayed.  
      private class NameFieldHandler implements ActionListener
      {
         public void actionPerformed(ActionEvent e)
         {
               String name;
               name=nameField.getText();
               //make sure name field is not empty
                 if(!name.isEmpty())
                   {
                   
                      person.setName(nameField.getText());
                      
                      JOptionPane.showMessageDialog(null, person.toString(),"Nader BMI                          Calculator",JOptionPane.INFORMATION_MESSAGE);
    
                   }
                    else
                        {
                             JOptionPane.showMessageDialog(null, "Invalid entry. You must                               enter your name: ","EXCEPTION ",JOptionPane.ERROR_MESSAGE);
           
                        }// end else
         
         }// end actionPerformed
      }// end class
      
      
      // if the user enters his name and his height and weight (healthy person),
      // then hitting the calculate button will display a message about the person 
      //including his name and BMI.   
      private class CalculateButtonHandler implements ActionListener
      {     
   
             public void actionPerformed(ActionEvent e)
             {
                  String name;
                  double height, weight;                                     
                  
                 // get user input of name, height and weight       
                  name = nameField.getText();
                                        
                       if(!name.isEmpty())// check for an empty name field
                       {
                         // check for input mismatch exceptions in height field input
                         try
                         {
                           Double.parseDouble(heightField.getText());
                                     
                          }
                         catch (NumberFormatException exception)
                         {
                          JOptionPane.showMessageDialog(null, "Please enter a positive                              NUMBER for height\n"+ exception.toString(),"Input Mismatch                                Exception ",JOptionPane.ERROR_MESSAGE);
                         } // end catch 
         
                          // check for input mismatch exceptions in weight field input
                          try
                         {
                           
                           Double.parseDouble(weightField.getText());
                          
                         }
                         catch (NumberFormatException exception)
                         {
                          JOptionPane.showMessageDialog(null, "Please enter a positive NUMBER for weight\n"+ exception.toString(),"Input Mismatch Exception ",JOptionPane.ERROR_MESSAGE);
                         } // end catch 2
                
                               height = Double.parseDouble(heightField.getText());
                               weight = Double.parseDouble(weightField.getText());       
                               hPerson.setName(name);
                            
                          if(height !=0)
                          {
                            
                               hPerson.setHeight(height);
                               hPerson.setWeight(weight);
                                      
                              JOptionPane.showMessageDialog(null,                                                       hPerson.toString(),"Nader BMI                  Calculator",JOptionPane.INFORMATION_MESSAGE);            
                          }
                            else
                          {
                             JOptionPane.showMessageDialog(null, "Cannot Divide by Zero!\n" +"Please enter a positive NUMBER for height","EXCEPTION ",JOptionPane.ERROR_MESSAGE);
                          }
                                               
                      }//end if
                      //Warn user to enter name if namefield is left blank
                      else
                       {
                          JOptionPane.showMessageDialog(null, "You must enter your name: ","Invalid entry! ",JOptionPane.ERROR_MESSAGE);
                
                       }//end else
                                  
          }// end action performed
          
    }// end class CalculateButtonHandler
    
    
    private class ExitButtonHandler implements ActionListener
    {
         public void actionPerformed(ActionEvent e)
         {
            System.exit(0);
         }
    
    }// end class ExitButtonHandler
    
    
     public static void main(String[]args)
    {
      
      BMIProg bmiProgram = new BMIProg();
      
    }

                               
}// end class 