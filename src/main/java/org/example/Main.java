package org.example;

public class Main {
    public static void main(String[] args) {
        MessageRender mr = MessageSupportFactory
                .getInstance().getMessageRenderer();
        MessageProvider mp = MessageSupportFactory
                .getInstance().getMessageProvider();

        mr.setMessageProvider(mp);
        mr.render();
    }
}