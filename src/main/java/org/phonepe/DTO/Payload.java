package org.phonepe.DTO;

import org.phonepe.models.Action;

import java.util.Map;

public class Payload {

    private Map<String,String> payloadMap;

    private Action action;

    public Action getAction() {
        return action;
    }

    public void setAction(Action action) {
        this.action = action;
    }

    public Map<String, String> getPayloadMap() {
        return payloadMap;
    }

    public void setPayloadMap(Map<String, String> payloadMap) {
        this.payloadMap = payloadMap;
    }
}
