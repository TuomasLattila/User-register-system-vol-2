package com.example.viikko10_tehtava;

import java.io.ObjectStreamClass;
import java.io.Serializable;
import java.util.ArrayList;

public class User implements Serializable {

    private String firstName;
    private String lastName;
    private String email;
    private String degreeProgram;

    private ArrayList<String> degrees = new ArrayList<>();

    private final long serialVersionUID = ObjectStreamClass.lookup(this.getClass()).getSerialVersionUID();

    public User(String firstName, String lastName, String email, String degreeProgram)  {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degreeProgram = degreeProgram;
    }

    public String getFirstName()    {
        return firstName;
    }

    public String getLastName()    {
        return lastName;
    }

    public String getEmail()    {
        return email;
    }

    public String getDegreeProgram()    {
        return degreeProgram;
    }

    public void addDegree(String string) {
        degrees.add(string);
    }

    public ArrayList<String> getDegrees()   {
        return degrees;
    }

    public String getDegreesString()  {
        String returnString = "Suoritetut tutkinnot:\n";
        int i = 1;
        for (String degree: degrees)    {
            if (i == degrees.size())    {
                returnString += "-" + degree;
            } else {
                returnString += "-" + degree + "\n";
            }
            i++;
        }
        return returnString;
    }
}
