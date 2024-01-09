package org.example;

import java.io.IOException;
import java.util.Properties;

public class MessageSupportFactory {
    private  static MessageSupportFactory instance;

    private Properties props;
    private MessageRender renderer;
    private MessageProvider provider;

    private MessageSupportFactory() {
        props = new Properties();

        try {
            props.load(this.getClass().getResourceAsStream("/msf.properties"));
            String renderClass = props.getProperty("renderer.class");
            String providerClass = props.getProperty("provider.class");

            renderer = (MessageRender)
                    Class.forName(renderClass).newInstance();
            provider = (MessageProvider)
                    Class.forName(providerClass).newInstance();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    static {
        instance = new MessageSupportFactory();
    }

    public static MessageSupportFactory getInstance() {
        return instance;
    }

    public MessageRender getMessageRenderer() {
        return renderer;
    }

    public MessageProvider getMessageProvider() {
        return provider;
    }
}
