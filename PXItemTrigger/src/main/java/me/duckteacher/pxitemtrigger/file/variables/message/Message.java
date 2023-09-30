package me.duckteacher.pxitemtrigger.file.variables.message;

import me.duckteacher.pxitemtrigger.PXItemTrigger;
import me.duckteacher.pxitemtrigger.file.DataManager;
import org.bukkit.configuration.file.FileConfiguration;

import java.util.HashMap;

public class Message {
    public static Message instance;

    public HashMap<MessageKey, String> messageMap;

    public Message(FileConfiguration fileConfiguration) {
        this.messageMap = new HashMap<>();

        for (MessageKey key : MessageKey.values()) {
            String msg = fileConfiguration.getString(key.getKey());
            if (msg == null) {
                PXItemTrigger.getInstance().saveResource("messages.yml", true);
                DataManager.setup();
                break;
            }

            messageMap.put(key, msg);
        }
    }

    public String getMessage(MessageKey key) { return this.messageMap.get(key); }

    public static Message getInstance() {
        return instance;
    }
}
