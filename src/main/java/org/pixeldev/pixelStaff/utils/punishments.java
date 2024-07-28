package org.pixeldev.pixelStaff.utils;

import java.util.HashMap;
import java.util.UUID;

public class punishments {

    public static HashMap<String, punishmentList> punishList = new HashMap<>();


    public static class punishmentList {
        public final String name;
        public final UUID uuid;
        public final String type;
        public final String reason;

        public punishmentList(
                String name,
                UUID uuid,
                String type,
                String reason
        ) {
            this.name = name;
            this.uuid = uuid;
            this.type = type;
            this.reason = reason;
        }
    }
}
