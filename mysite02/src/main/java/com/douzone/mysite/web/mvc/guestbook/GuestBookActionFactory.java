package com.douzone.mysite.web.mvc.guestbook;

import com.douzone.mysite.web.mvc.main.MainAction;
import com.douzone.web.mvc.Action;
import com.douzone.web.mvc.ActionFactory;

public class GuestBookActionFactory extends ActionFactory {

	@Override
	public Action getAction(String actionName) {
		Action action = null;
		
		System.out.println(actionName);

		if ("insert".equals(actionName)) {
			action = new InsertAction();
		} else if ("deleteform".equals(actionName)) {
			action = new DeleteFormAction();
		} else if ("list".equals(actionName)) {
			action = new ListAction();
		} else if ("delete".equals(actionName)) {
			action = new DeleteAction();
		} else {
			action = new MainAction();
		}

		return action;
	}

}
