package com.example.viikko10_tehtava;

import android.content.Context;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class UserStorage {
    private ArrayList<User> users = new ArrayList<>();
    private static UserStorage userStorage = null;

    private UserStorage()   {
    }

    public static UserStorage getInstance() {
        if (userStorage == null)    {
            userStorage = new UserStorage();
        }
        return userStorage;
    }

    public ArrayList<User> getUsers()   {
        return users;
    }

    public void addUser(User newUser)  {
        users.add(newUser);
    }

    public void loadUsers(Context context)   {
        try {
            ObjectInputStream userReader = new ObjectInputStream(context.openFileInput("users.data"));
            users = (ArrayList<User>) userReader.readObject();
            userReader.close();
        } catch (IOException e) {
            System.out.println("Käyttäjien lukeminen epäonnistui");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Käyttäjien lukeminen epäonnistui");
            e.printStackTrace();
        }
    }

    public void saveUsers(Context context)   {
        try {
            ObjectOutputStream userWriter = new ObjectOutputStream(context.openFileOutput("users.data", Context.MODE_PRIVATE));
            userWriter.writeObject(users);
            userWriter.close();
        } catch (IOException e) {
            System.out.println("Käyttäjien kirjoittaminen epäonnistui");
            e.printStackTrace();
        }
    }

    public void sortUsersAlphabetically()   {
        int i1;
        int i2;
        User temporaryUser;

        for (i1 = 0; i1 < users.size(); i1++)    {
            for (i2 = i1 + 1; i2 < users.size(); i2++)  {
                if(users.get(i1).getLastName().toLowerCase().compareTo(users.get(i2).getLastName().toLowerCase()) > 0)  {
                    temporaryUser = users.get(i1);
                    users.set(i1, users.get(i2));
                    users.set(i2, temporaryUser);
                }
            }
        }
    }
}
