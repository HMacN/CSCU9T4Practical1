// GUI and main program for the Training Record
//package com.stir.cscu9t4practical1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class TrainingRecordGUI extends JFrame implements ActionListener {

    private JTextField name = new JTextField(30);
    private JTextField day = new JTextField(2);
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);
    private JTextField hours = new JTextField(2);
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km):");

    private JButton addR = new JButton("Add");
    private JButton lookUpByDate = new JButton("Look Up");
    private JButton findAllByDate = new JButton("Find All By Date");
    private JButton deleteEntryButton = new JButton("Delete Specified Entry");

    private JComboBox typeOfExerciseDropDown = new JComboBox(EnumExerciseType.values());

    private JLabel cyclingSurfaceLabel = new JLabel(" Surface Type: ");
    private JTextField cyclingSurfaceType = new JTextField(15);

    private JLabel cyclingRouteLabel = new JLabel(" Route Difficulty: ");
    private JTextField cyclingRouteDifficulty = new JTextField(15);

    private JLabel sprintingRepsLabel = new JLabel(" Repetitions: ");
    private JTextField sprintingRepetitions = new JTextField(3);

    private JLabel sprintingRecoveryLabel = new JLabel(" Recovery: ");
    private JTextField sprintingRecovery = new JTextField(3);

    private JLabel swimmingLocationLabel = new JLabel(" Location: ");
    private JTextField swimmingLocation = new JTextField(15);

    private TrainingRecord myAthletes = new TrainingRecord();

    private JTextArea outputArea = new JTextArea(5, 50);

    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
    } // main

    // set up the GUI 
    public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout());
        getContentPane().setBackground(Color.BLACK);

        add(labn);
        labn.setForeground(Color.GREEN);

        add(name);
        name.setEditable(true);
        name.setBackground(Color.BLACK);
        name.setForeground(Color.GREEN);
        name.setCaretColor(Color.GREEN);

        add(typeOfExerciseDropDown);
        typeOfExerciseDropDown.setSelectedIndex(0);
        typeOfExerciseDropDown.addActionListener(this);
        typeOfExerciseDropDown.setBackground(Color.BLACK);
        typeOfExerciseDropDown.setForeground(Color.GREEN);

        add(labd);
        labd.setForeground(Color.GREEN);

        add(day);
        day.setEditable(true);
        day.setBackground(Color.BLACK);
        day.setForeground(Color.GREEN);
        day.setCaretColor(Color.GREEN);

        add(labm);
        labm.setForeground(Color.GREEN);

        add(month);
        month.setEditable(true);
        month.setBackground(Color.BLACK);
        month.setForeground(Color.GREEN);
        month.setCaretColor(Color.GREEN);


        add(laby);
        laby.setForeground(Color.GREEN);

        add(year);
        year.setEditable(true);
        year.setBackground(Color.BLACK);
        year.setForeground(Color.GREEN);
        year.setCaretColor(Color.GREEN);

        add(labh);
        labh.setForeground(Color.GREEN);

        add(hours);
        hours.setEditable(true);
        hours.setBackground(Color.BLACK);
        hours.setForeground(Color.GREEN);
        hours.setCaretColor(Color.GREEN);

        add(labmm);
        labmm.setForeground(Color.GREEN);

        add(mins);
        mins.setEditable(true);
        mins.setBackground(Color.BLACK);
        mins.setForeground(Color.GREEN);
        mins.setCaretColor(Color.GREEN);

        add(labs);
        labs.setForeground(Color.GREEN);

        add(secs);
        secs.setEditable(true);
        secs.setBackground(Color.BLACK);
        secs.setForeground(Color.GREEN);
        secs.setCaretColor(Color.GREEN);

        add(labdist);
        labdist.setForeground(Color.GREEN);

        add(dist);
        dist.setEditable(true);
        dist.setBackground(Color.BLACK);
        dist.setForeground(Color.GREEN);
        dist.setCaretColor(Color.GREEN);


        add(addR);
        addR.addActionListener(this);
        addR.setBackground(Color.BLACK);
        addR.setForeground(Color.GREEN);
        addR.setBorderPainted(true);

        add(cyclingSurfaceLabel);
        cyclingSurfaceLabel.setForeground(Color.GREEN);

        add(cyclingSurfaceType);
        cyclingSurfaceType.setEditable(true);
        cyclingSurfaceType.setEnabled(true);
        cyclingSurfaceType.setBackground(Color.BLACK);
        cyclingSurfaceType.setForeground(Color.GREEN);
        cyclingSurfaceType.setCaretColor(Color.GREEN);

        add(cyclingRouteLabel);
        cyclingRouteLabel.setForeground(Color.GREEN);

        add(cyclingRouteDifficulty);
        cyclingRouteDifficulty.setEditable(true);
        cyclingRouteDifficulty.setEnabled(true);
        cyclingRouteDifficulty.setBackground(Color.BLACK);
        cyclingRouteDifficulty.setForeground(Color.GREEN);
        cyclingRouteDifficulty.setCaretColor(Color.GREEN);

        add(sprintingRepsLabel);
        sprintingRepsLabel.setForeground(Color.GREEN);

        add(sprintingRepetitions);
        sprintingRepetitions.setEditable(true);
        sprintingRepetitions.setEnabled(false);
        sprintingRepetitions.setBackground(Color.BLACK);
        sprintingRepetitions.setForeground(Color.GREEN);
        sprintingRepetitions.setCaretColor(Color.GREEN);

        add(sprintingRecoveryLabel);
        sprintingRecoveryLabel.setForeground(Color.GREEN);

        add(sprintingRecovery);
        sprintingRecovery.setEditable(true);
        sprintingRecovery.setEnabled(false);
        sprintingRecovery.setBackground(Color.BLACK);
        sprintingRecovery.setForeground(Color.GREEN);
        sprintingRecovery.setCaretColor(Color.GREEN);

        add(swimmingLocationLabel);
        swimmingLocationLabel.setForeground(Color.GREEN);

        add(swimmingLocation);
        swimmingLocation.setEditable(true);
        swimmingLocation.setEnabled(false);
        swimmingLocation.setBackground(Color.BLACK);
        swimmingLocation.setForeground(Color.GREEN);
        swimmingLocation.setCaretColor(Color.GREEN);

        add(lookUpByDate);
        lookUpByDate.addActionListener(this);
        lookUpByDate.setEnabled(false);
        lookUpByDate.setBackground(Color.BLACK);
        lookUpByDate.setForeground(Color.GREEN);
        lookUpByDate.setBorderPainted(true);


        add(findAllByDate);
        findAllByDate.addActionListener(this);
        findAllByDate.setEnabled(false);
        findAllByDate.setBackground(Color.BLACK);
        findAllByDate.setForeground(Color.GREEN);
        findAllByDate.setBorderPainted(true);

        add(deleteEntryButton);
        deleteEntryButton.addActionListener(this);
        deleteEntryButton.setEnabled(false);
        deleteEntryButton.setBackground(Color.BLACK);
        deleteEntryButton.setForeground(Color.GREEN);
        deleteEntryButton.setBorderPainted(true);

        add(outputArea);
        outputArea.setEditable(false);
        outputArea.setBackground(Color.BLACK);
        outputArea.setForeground(Color.GREEN);

        setSize(720, 200);
        setVisible(true);

        blankDisplay();

        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        
    } // constructor

    // listen for and respond to GUI events 
    public void actionPerformed(ActionEvent event) {
        String message = "";
        if (event.getSource() == addR) {
            message = addEntry("generic");
        }
        if (event.getSource() == lookUpByDate) {
            message = lookupEntry();
        }
        if (event.getSource() == findAllByDate)
        {
            message = findAllByDate();
        }
        if (event.getSource() == typeOfExerciseDropDown)
        {
            message = "";

            setUpDisplayForDifferentExerciseTypes();
        }
        if (event.getSource() == deleteEntryButton)
        {
            message = deleteSpecifiedEntry();
        }
        outputArea.setText(message);
        blankDisplay();
    } // actionPerformed

    private void setUpDisplayForDifferentExerciseTypes()
    {
        if (typeOfExerciseDropDown.getSelectedItem().equals(EnumExerciseType.Cycling))
        {
            setEnablingForGUIComponents(true, true, false, false, false);
        }
        else if (typeOfExerciseDropDown.getSelectedItem().equals(EnumExerciseType.Running))
        {
            setEnablingForGUIComponents(false, false,true, true, false);
        }
        else
        {
            setEnablingForGUIComponents(false, false, false, false, true);
        }
    }

    private void setEnablingForGUIComponents(boolean cyclingRouteDifficulty, boolean cyclingSurfaceType, boolean sprintingRepetitions, boolean sprintingRecovery, boolean swimmingLocation)
    {
        this.cyclingRouteDifficulty.setEnabled(cyclingRouteDifficulty);
        this.cyclingSurfaceType.setEnabled(cyclingSurfaceType);
        this.sprintingRepetitions.setEnabled(sprintingRepetitions);
        this.sprintingRecovery.setEnabled(sprintingRecovery);
        this.swimmingLocation.setEnabled(swimmingLocation);
    }

    public String deleteSpecifiedEntry()
    {
        return myAthletes.deleteSpecifiedEntry(name.getText(), day.getText(), month.getText(), year.getText());
    }   //deleteSpecifiedEntry

    public String addEntry(String what)
    {
        String message;
        int numberOfEntriesAtStart = myAthletes.getNumberOfEntries();

        System.out.println("Adding "+what+" entry to the records.");
        message = myAthletes.addEntry(getExerciseTypeFromDropDown(), name.getText(), day.getText(), month.getText(), year.getText(), hours.getText(), mins.getText(), secs.getText(), dist.getText(), cyclingSurfaceType.getText(), cyclingRouteDifficulty.getText(), sprintingRepetitions.getText(), sprintingRecovery.getText(), swimmingLocation.getText());

        if ((numberOfEntriesAtStart != myAthletes.getNumberOfEntries()) && !lookUpByDate.isEnabled())  //Check to see if an entry has actually been added, and if the buttons for looking up entries are disabled.
        {
            lookUpByDate.setEnabled(true);  //Enable buttons for looking up entries.
            findAllByDate.setEnabled(true);
            deleteEntryButton.setEnabled(true);
        }

        return message;
    }   //addEntry

    private EnumExerciseType getExerciseTypeFromDropDown()
    {
        return (EnumExerciseType) typeOfExerciseDropDown.getSelectedItem();
    }

    public String lookupEntry()
    {
        return myAthletes.lookupEntry(day.getText(), month.getText(), year.getText());
    }   //lookupEntry

    public String findAllByDate()
    {
        return myAthletes.findAllByDate(day.getText(), month.getText(), year.getText());
    }   //findAllByDate

    public void blankDisplay() {
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");
        cyclingSurfaceType.setText("");
        cyclingRouteDifficulty.setText("");
        sprintingRepetitions.setText("0");
        sprintingRecovery.setText("0");
        swimmingLocation.setText("");
    }// blankDisplay

    // Fills the input fields on the display for testing purposes only
    public void fillDisplay(Entry ent) {

        EnumExerciseType entityExerciseType = ent.getExerciseType();
        CycleEntry cyclingEntity;
        SprintEntry sprintingEntity;
        SwimEntry swimmingEntity;
        typeOfExerciseDropDown.setSelectedItem(entityExerciseType);

        name.setText(ent.getName());
        day.setText(String.valueOf(ent.getDay()));
        month.setText(String.valueOf(ent.getMonth()));
        year.setText(String.valueOf(ent.getYear()));
        hours.setText(String.valueOf(ent.getHour()));
        mins.setText(String.valueOf(ent.getMin()));
        secs.setText(String.valueOf(ent.getSec()));
        dist.setText(String.valueOf(ent.getDistance()));

        if (entityExerciseType == EnumExerciseType.Cycling)
        {
            cyclingEntity = (CycleEntry) ent;   //Cast to cycling entry to call appropriate getters.

            cyclingRouteDifficulty.setText(cyclingEntity.getRouteDifficulty());
            cyclingSurfaceType.setText(cyclingEntity.getTerrain());
        }
        else if (entityExerciseType == EnumExerciseType.Running)
        {
            sprintingEntity = (SprintEntry) ent;    //Cast to sprinting entry to call appropriate getters.

            sprintingRepetitions.setText(String.valueOf(sprintingEntity.getRepetitions()));
            sprintingRecovery.setText(String.valueOf(sprintingEntity.getRecovery()));
        }
        else
        {
            swimmingEntity = (SwimEntry) ent;   //Cast to swimming entry to call appropriate getters.

            swimmingLocation.setText(swimmingEntity.getWhere());
        }
    }

} // TrainingRecordGUI

