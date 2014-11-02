
package de.christoph.broeker;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;

/**
 *
 */
public class Calendar extends JPanel {

    private java.util.Calendar calendar = java.util.Calendar.getInstance();
    private DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);

    private JLabel currentWeekLabel;
    private JLabel mondayLabel;
    private JLabel tuesdayLabel;
    private JLabel wednesdayLabel;
    private JLabel thursdayLabel;
    private JLabel fridayLabel;
    private JLabel saturdayLabel;
    private JLabel sundayLabel;

    private static final long serialVersionUID = 1L;

    public Calendar() {

        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);


		/*
		 * mainPanel = buttonPanel + calendarPanel
		 */

        this.setLayout(new BorderLayout());


		/*
		 * buttonPanel
		 */
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(java.awt.Color.WHITE);
        this.add(buttonPanel, BorderLayout.NORTH);

        JButton priorWeekButton = new JButton("Vorherige Woche");
        priorWeekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent a) {
                priorWeek();
            }
        });
        buttonPanel.add(priorWeekButton);

        JButton newEventButton = new JButton("Neuer Termin");
        newEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent b) {
                //TODO:
            }
        });
        buttonPanel.add(newEventButton);

        JButton editEventButton = new JButton("Termin bearbeiten");
        editEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent b) {
                JOptionPane
                        .showMessageDialog(
                                null,
                                "sie müssen einen Termin auswählen!",
                                "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonPanel.add(editEventButton);

        JButton delteEventButton = new JButton("Termin löschen");
        delteEventButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                JOptionPane
                        .showMessageDialog(
                                null,
                                "Sie müssen einen Termin auswählen!",
                                "Fehler", JOptionPane.ERROR_MESSAGE);
            }
        });
        buttonPanel.add(delteEventButton);

        JButton nextWeekButton = new JButton("Nächste Woche");
        nextWeekButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(final ActionEvent e) {
                nextWeek();
            }
        });
        buttonPanel.add(nextWeekButton);

		/*
		 * calendarPanel = currentWeekLabel + dayPanel
		 */

        JPanel calendarPanel = new JPanel();
        calendarPanel.setBackground(SystemColor.text);
        this.add(calendarPanel, BorderLayout.CENTER);
        calendarPanel.setLayout(new BorderLayout(0, 0));



		/*
		 * currentWeekLabel
		 */

        JPanel weekLabelPanel = new JPanel();
        weekLabelPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null,null, null, null));
        weekLabelPanel.setBackground(new java.awt.Color(194, 213, 232));
        currentWeekLabel = new JLabel("Kalenderwoche "+ calendar.get(java.util.Calendar.WEEK_OF_YEAR));
        currentWeekLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
        weekLabelPanel.add(currentWeekLabel);
        calendarPanel.add(weekLabelPanel, BorderLayout.NORTH);



		/*
		 * dayPanel
		 */

        JPanel dayPanel = new JPanel();
        dayPanel.setBackground(java.awt.Color.WHITE);
        dayPanel.setLayout(new BoxLayout(dayPanel, BoxLayout.X_AXIS));
        dayPanel.setSize(1024, 1440);
        dayPanel.setPreferredSize(new Dimension(1024, 1440));
        JScrollPane dayScrollPane = new JScrollPane( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
        dayScrollPane.setBorder(new EmptyBorder(10, 0, 0, 0));
        dayScrollPane.setBackground(Color.WHITE);
        dayScrollPane.setViewportView(dayPanel);
        calendarPanel.add(dayScrollPane, BorderLayout.CENTER);



        JPanel scalePanel = new JPanel();
        scalePanel.setBorder(new EmptyBorder(0, 0, 0, 0));
        scalePanel.setBackground(java.awt.Color.WHITE);
        dayPanel.add(scalePanel);
        scalePanel.setSize(30, 1440);
        scalePanel.setLayout(null);
        int a = 30;
        for (int i = 0; i < 25; i++) {
            JPanel timePanel = new JPanel();
            timePanel.setBounds(0, a, 300, 60);
            timePanel.setBackground(java.awt.Color.WHITE);
            scalePanel.add(timePanel);
            timePanel.setLayout(new BoxLayout(timePanel, BoxLayout.Y_AXIS));

            JLabel timeLabel = new JLabel("       "+i+" Uhr");
            timePanel.add(timeLabel);
            a = a + 60;
        }


        JPanel mondayPanel = new JPanel();
        dayPanel.add(mondayPanel);
        mondayPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,null, null));
        mondayPanel.setBackground(SystemColor.inactiveCaptionBorder);
        mondayPanel.setLayout(null);

        JPanel mondayLabelPanel = new JPanel();
        mondayLabelPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null,null, null, null));
        mondayLabelPanel.setBackground(new java.awt.Color(194, 213, 232));
        mondayLabel = new JLabel(dateFormat.format(calendar.getTime()));
        mondayLabelPanel.add(mondayLabel);
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        mondayLabelPanel.setBounds(0, 0, 300, 30);
        mondayLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        mondayPanel.add(mondayLabelPanel);


        JPanel tuesdayPanel = new JPanel();
        dayPanel.add(tuesdayPanel);
        tuesdayPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,null, null));
        tuesdayPanel.setBackground(SystemColor.inactiveCaptionBorder);
        tuesdayPanel.setLayout(null);

        JPanel tuesdayLabelPanel = new JPanel();
        tuesdayLabelPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null,null, null, null));
        tuesdayLabelPanel.setBackground(new java.awt.Color(194, 213, 232));
        tuesdayLabel = new JLabel(dateFormat.format(calendar.getTime()));
        tuesdayLabelPanel.add(tuesdayLabel);
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        tuesdayLabelPanel.setBounds(0, 0, 300, 30);
        tuesdayLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        tuesdayPanel.add(tuesdayLabelPanel);


        JPanel wednesdayPanel = new JPanel();
        dayPanel.add(wednesdayPanel);
        wednesdayPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null,null, null, null));
        wednesdayPanel.setBackground(SystemColor.inactiveCaptionBorder);
        wednesdayPanel.setLayout(null);

        JPanel wednesdayLabelPanel = new JPanel();
        wednesdayLabelPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null,null, null, null));
        wednesdayLabelPanel.setBackground(new java.awt.Color(194, 213, 232));
        wednesdayLabel = new JLabel(dateFormat.format(calendar.getTime()));
        wednesdayLabelPanel.add(wednesdayLabel);
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        wednesdayLabelPanel.setBounds(0, 0, 300, 30);
        wednesdayLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        wednesdayPanel.add(wednesdayLabelPanel);


        JPanel thursdayPanel = new JPanel();
        dayPanel.add(thursdayPanel);
        thursdayPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,null, null));
        thursdayPanel.setBackground(SystemColor.inactiveCaptionBorder);
        thursdayPanel.setLayout(null);

        JPanel thursdayLabelPanel = new JPanel();
        thursdayLabelPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null,null, null, null));
        thursdayLabelPanel.setBackground(new java.awt.Color(194, 213, 232));
        thursdayLabel = new JLabel(dateFormat.format(calendar.getTime()));
        thursdayLabelPanel.add(thursdayLabel);
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        thursdayLabelPanel.setBounds(0, 0, 300, 30);
        thursdayLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        thursdayPanel.add(thursdayLabelPanel);


        JPanel fridayPanel = new JPanel();
        dayPanel.add(fridayPanel);
        fridayPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,null, null));
        fridayPanel.setBackground(SystemColor.inactiveCaptionBorder);
        fridayPanel.setLayout(null);

        JPanel fridayLabelPanel = new JPanel();
        fridayLabelPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null,null, null, null));
        fridayLabelPanel.setBackground(new java.awt.Color(194, 213, 232));
        fridayLabel = new JLabel(dateFormat.format(calendar.getTime()));
        fridayLabelPanel.add(fridayLabel);
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        fridayLabelPanel.setBounds(0, 0, 300, 30);
        fridayLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        fridayPanel.add(fridayLabelPanel);


        JPanel saturdayPanel = new JPanel();
        dayPanel.add(saturdayPanel);
        saturdayPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,null, null));
        saturdayPanel.setBackground(SystemColor.inactiveCaptionBorder);
        saturdayPanel.setLayout(null);

        JPanel saturdayLabelPanel = new JPanel();
        saturdayLabelPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null,null, null, null));
        saturdayLabelPanel.setBackground(new java.awt.Color(194, 213, 232));
        saturdayLabel = new JLabel(dateFormat.format(calendar.getTime()));
        saturdayLabelPanel.add(saturdayLabel);
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        saturdayLabelPanel.setBounds(0, 0, 300, 30);
        saturdayLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        saturdayPanel.add(saturdayLabelPanel);


        JPanel sundayPanel = new JPanel();
        dayPanel.add(sundayPanel);
        sundayPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null,null, null));
        sundayPanel.setBackground(SystemColor.inactiveCaptionBorder);
        sundayPanel.setLayout(null);

        JPanel sundayLabelPanel = new JPanel();
        sundayLabelPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null,null, null, null));
        sundayLabelPanel.setBackground(new java.awt.Color(194, 213, 232));
        sundayLabel = new JLabel(dateFormat.format(calendar.getTime()));
        sundayLabelPanel.add(sundayLabel);
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        sundayLabelPanel.setBounds(0, 0, 300, 30);
        sundayLabelPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
        sundayPanel.add(sundayLabelPanel);

        this.setVisible(true);

    }

    private void nextWeek() {
        currentWeekLabel.setText("Kalenderwoche "
                + calendar.get(java.util.Calendar.WEEK_OF_YEAR));
        mondayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        tuesdayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        wednesdayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        thursdayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        fridayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        saturdayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        sundayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        this.setVisible(true);
    }

    private void priorWeek() {
        calendar.add(java.util.Calendar.DAY_OF_WEEK, -14);

        currentWeekLabel.setText("Kalenderwoche "
                + calendar.get(java.util.Calendar.WEEK_OF_YEAR));

        mondayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        tuesdayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        wednesdayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        thursdayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        fridayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        saturdayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
        sundayLabel.setText(dateFormat.format(calendar.getTime()));
        calendar.add(java.util.Calendar.DAY_OF_WEEK, 1);
    }
}
