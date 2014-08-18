package com.epam.ad.action;


import com.epam.ad.admin.CreateCustomer;

import java.util.HashMap;
import java.util.Map;

public class ActionFactory {

    private final static Map<String, Action> actions = new HashMap<String, Action>();

    static {
        actions.put("GET/",new ShowLoginPageAction());
        actions.put("POST/", new LoginAction());
        actions.put("GET/registrationform",new ShowPageAction("registrationform"));
        actions.put("POST/registrationform",new RegistrationForm());
        actions.put("GET/adminForm",new ShowPageAction("adminForm"));
        actions.put("POST/adminForm",new ShowEditPageAction());
//        actions.put("GET/bookingtable",new ShowPageAction("bookingtable"));
        actions.put("GET/bookingtable",new BookingTableAction());
        actions.put("GET/roomdetail",new ShowPageAction("roomdetail"));
        actions.put("POST/roomdetail",new RoomTableAction());
        actions.put("GET/customerdetail",new ShowPageAction("customerdetail"));
        actions.put("POST/customerdetail",new CustomerTableAction());
        actions.put("GET/welcome", new ShowPageAction("welcome"));
       actions.put("POST/welcome", new ChangeRoomAction());
       actions.put("GET/customerForm", new ShowPageAction("customerForm"));
       actions.put("POST/customerForm", new ConfirmAction());


    }

    public static Action getAction(String actionName) {
        return actions.get(actionName);
    }
}
