package org.example;

enum TransistorStates {
    On, Off, Broken
}

class Transistor {
    TransistorStates status;
}

enum MessageStatus {
    sent, read, reject, failed, notSent;
}

class Message {
    MessageStatus status;

    public Message(MessageStatus status) { this.status = status; }
}

public class EnumAndFriends {
    public static void main(String args[]){
        var message = new Message(MessageStatus.notSent);
        System.out.println(MessageStatus.notSent.ordinal());
    }
}
