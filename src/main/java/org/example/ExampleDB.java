package org.example;

import java.util.ArrayList;
import java.util.Objects;

interface Database {
    Object read(int id);
    void write(Object obj);
}

class ProstressDB implements Database {

    @Override
    public Object read(int id) { return null; }

    @Override
    public void write(Object obj) { }
}

class MySQLDB implements Database {

    @Override
    public Object read(int id) { return null; }

    @Override
    public void write(Object obj) { }
}

public class ExampleDB {
    static ArrayList<Objects> list;

    static void exec(Database database){
        for(var obj: list)
            database.write(obj);
    }

    static void main() {
        Database database = new MySQLDB();
        exec(database);
    }
}
